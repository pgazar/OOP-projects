package transmission;

import java.util.LinkedList;

public class AutomaticTransmission implements Transmission {

  private static final int NUM_GEARS = 6;
 // private LinkedList<Integer> speedRange;

  private  int[] speedRange;
  private int currentSpeed;
  private int gear;

  public AutomaticTransmission(int speedThreshold1, int speedThreshold2, int speedThreshold3, int speedThreshold4, int speedThreshold5) {

    if (speedThreshold1 <= 0 || speedThreshold2 <= speedThreshold1 || speedThreshold3 <= speedThreshold2 ||
            speedThreshold4 <= speedThreshold3 || speedThreshold5 <= speedThreshold4) {
      throw new IllegalArgumentException("Invalid speed thresholds");
    }
    speedRange = new int[] {0, speedThreshold1, speedThreshold2, speedThreshold3,
            speedThreshold4, speedThreshold5};


    currentSpeed =0;
    gear = 0;

  }
  public AutomaticTransmission(int speedThreshold1, int speedThreshold2, int speedThreshold3, int speedThreshold4, int speedThreshold5 ,int gear,
                                int currentSpeed){
    if (speedThreshold1 < 0 || speedThreshold2 <= speedThreshold1 || speedThreshold3 <= speedThreshold2 ||
              speedThreshold4 <= speedThreshold3 || speedThreshold5 <= speedThreshold4) {
        throw new IllegalArgumentException("Invalid speed thresholds");
      }
      speedRange = new int[] {0, speedThreshold1, speedThreshold2, speedThreshold3,
              speedThreshold4, speedThreshold5};
    if(currentSpeed <0){
      throw new IllegalArgumentException("Invalid speed thresholds");
    }
    if(gear <0 || gear > 6){
      throw new  IllegalArgumentException("Invalid gear");
    }

    this.currentSpeed = currentSpeed;
    this.gear = gear;
  }

  public void setGear(int gear) {
    this.gear = gear;
  }

  public Transmission increaseSpeed() {
    if (currentSpeed < 0) {
      throw new IllegalStateException("Invalid SPEED");
    }

    currentSpeed += 2;
    for (int i =1; i < NUM_GEARS; i++) {
      if (currentSpeed < speedRange[i]) {
        setGear(i);
        break;
      }
    }
    if(currentSpeed >= speedRange[NUM_GEARS-1]){
      setGear(6);
      return new AutomaticTransmission(speedRange[1],speedRange[2],
              speedRange[3],speedRange[4],speedRange[5],gear,
              currentSpeed);
    }

    return new AutomaticTransmission(speedRange[1],speedRange[2],
            speedRange[3],speedRange[4],speedRange[5],gear,currentSpeed);
  }

  public Transmission decreaseSpeed() {
    if (currentSpeed < 0) {
      throw new IllegalStateException("Invalid SPEED");
    }
    currentSpeed -= 2;
    if (currentSpeed == 0) {
      setGear(0);
      return new AutomaticTransmission(speedRange[1],speedRange[2],
              speedRange[3],speedRange[4],speedRange[5],gear,currentSpeed);
    }
    if (currentSpeed < 0) {
       throw new IllegalStateException("Invalid SPEED");
    }

    for (int i = NUM_GEARS - 1; i > 0; i--) {
      if (currentSpeed >= speedRange[i]) {
        setGear(i+1);
        break;
      }
    }
    if (currentSpeed < speedRange[gear-1]) {
      setGear(1);
       return new AutomaticTransmission(speedRange[1],speedRange[2],
               speedRange[3],speedRange[4],speedRange[5],gear,currentSpeed);
    }
    return new AutomaticTransmission(speedRange[1],speedRange[2],
            speedRange[3],speedRange[4],speedRange[5],gear,currentSpeed);
  }

  public int getSpeed() {
    return currentSpeed;
  }

  public int getGear() {
    return gear;
  }

  public String toString() {
    return "Transmission (speed = " + currentSpeed + ", gear = " + gear + ")";
  }


  public static void main(String[] args) {
    AutomaticTransmission transmission = new AutomaticTransmission(10, 20, 30
            , 40, 50);

    System.out.println(transmission.toString());

    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.decreaseSpeed();
    System.out.println(transmission.toString());

    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());
    transmission.increaseSpeed();
    System.out.println(transmission.toString());

  }
}