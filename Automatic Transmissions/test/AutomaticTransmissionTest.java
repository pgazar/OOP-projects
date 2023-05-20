package transmission;

import static org.junit.Assert.*;


import java.util.LinkedList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;



public class AutomaticTransmissionTest {


  private static final int NUM_GEARS = 6;
  private static final int STEP = 2;

  // helper
  private int findGear(int speed, int[] thresholds) {
    int gear = 0;
    if (speed > 0) {
      gear = NUM_GEARS;
      while (gear >= 1 && speed < thresholds[gear - 1]) {
        gear -= 1;
      }
    }
    return gear;
  }

  /**
   * Testing increaseSpeed() and decreaseSpeed().
   */
  @Test
  public void testSpeedChanges() {
    // iterate over a bunch of test cases
    Random rand = new Random();
    for (int i = 0; i < 3000; i++) {
      // generate increasing thresholds
      int[] thres = new int[NUM_GEARS];
      thres[0] = 1;
      for (int j = 1; j < NUM_GEARS; j++) {
        int gap = rand.nextInt(20) + 1; // the +5 guarantees there is a gap of at least 1
        thres[j] = thres[j - 1] + gap;
      }
      // iterate over the calls to increase speed
      int count = 10 + rand.nextInt(100);
      int speed = 0;
      Transmission trans = new AutomaticTransmission(thres[1], thres[2], thres[3], thres[4],
              thres[5]);
      for (int j = 0; j < count; j++) {
        int gear = findGear(speed, thres);
        assertEquals("getSpeed() returned an invalid speed after increaseSpeed() was called", speed,
                trans.getSpeed());
        assertEquals("getGear() returned an invalid gear after increaseSpeed() was called", gear,
                trans.getGear());
        String expected = String.format("Transmission (speed = %d, gear = %d)", speed, gear);
        assertEquals("toString() return invalid string after increaseSpeed() was called", expected,
                trans.toString());
        trans = trans.increaseSpeed();
        speed += STEP;
      }
      // since we don't have a way to set a speed, test decreaseSpeed
      // using the object that we just increased the speed with
      while (speed > 0) {
        int gear = findGear(speed, thres);
        assertEquals("getSpeed() returned an invalid speed after decreaseSpeed() was called", speed,
                trans.getSpeed());
        assertEquals("getGear() returned an invalid gear after decreaseSpeed() was called", gear,
                trans.getGear());
        String expected = String.format("Transmission (speed = %d, gear = %d)", speed, gear);
        assertEquals("toString() return invalid string after decreaseSpeed() was called", expected,
                trans.toString());
        speed -= STEP;
        trans = trans.decreaseSpeed();
      }
    }
  }


  @Test
  public void testUnorderedThresholdConstructor1() {
    // Ensure that constructor throws IllegalArgumentException with unordered speed thresholds
    assertThrows("Invalid speed thresholds",IllegalArgumentException.class,
            () -> {new AutomaticTransmission(60,20,10,40,50);});

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidUnorderedThresholdConstructor() {
    // Arrange
    // Create a valid list of speed thresholds
    int[] speedRange = new int[] {0, 20,10,30,40,50};

    // Create an automatic transmission with invalid arguments
    AutomaticTransmission transmission1 =
            new AutomaticTransmission(speedRange[3],speedRange[1],
            speedRange[2],speedRange[4],speedRange[5]);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidUnorderedThresholdConstructor2() {
    // Create a valid list of speed thresholds
    int[] speedRange = new int[] {0, 10,20,30,40,50};

    // Create an automatic transmission with invalid arguments
    AutomaticTransmission transmission1 = new AutomaticTransmission(speedRange[1],speedRange[2],
            speedRange[3],speedRange[4],speedRange[5], -1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor() {
    // Create a valid list of speed thresholds
    int[] speedRange = new int[] {0, 10,20,30,40,50};

    // Create an automatic transmission with invalid arguments
    AutomaticTransmission transmission1 = new AutomaticTransmission(speedRange[1],speedRange[2],
            speedRange[3],speedRange[4],speedRange[5], 1, -2);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    // Create a valid list of speed thresholds
    int[] speedRange = new int[] {0, 20,10,30,40,50};

    // Create an automatic transmission with invalid arguments
    AutomaticTransmission transmission1 = new AutomaticTransmission(speedRange[1],speedRange[2],
            speedRange[3],speedRange[4],speedRange[5], 1, 2);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidUnorderedThresholdConstructor4() {
    // Create a valid list of speed thresholds
    int[] speedRange = new int[] {0, 10,20,30,40,50};

    // Create an automatic transmission with invalid arguments
    AutomaticTransmission transmission1 = new AutomaticTransmission(speedRange[1],speedRange[2],
            speedRange[3],speedRange[4],speedRange[5], 7, 50);
  }
  @Test(expected = IllegalStateException.class)
  public void testInvalidDecreaseSpeed() {

    // Create a valid list of speed thresholds
    int[] speedRange = new int[] {0, 10,20,30,40,50};

    // Create an automatic transmission with invalid arguments
    AutomaticTransmission trans = new AutomaticTransmission(speedRange[1],speedRange[2],
            speedRange[3],speedRange[4],speedRange[5], 1, 2);

    trans.decreaseSpeed(); // This should not throw an exception
    trans.decreaseSpeed(); // This should throw an exception

  }



}