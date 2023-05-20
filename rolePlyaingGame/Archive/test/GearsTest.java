
import org.junit.Before;
import org.junit.Test;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import RPGpackage.Gears;
import RPGpackage.FootGear;
import RPGpackage.HeadGear;
import RPGpackage.HandGear;
public class GearsTest {
  @Test
  public void testFootWear() {
    FootGear footWear1 = new FootGear("Good", "Cool", 20, 30);
    assertEquals("FOOT_GEAR", footWear1.getGearType().toString());
    assertEquals(20, footWear1.getAttack());
    assertEquals(30, footWear1.getDefense());
    assertEquals("Good", footWear1.getAdjective());
    assertEquals("Cool", footWear1.getNoun());
  }

  @Test
  public void testHeadGear() {
    HeadGear headGear1 = new HeadGear("Good", "Cool", 0, 30);
    assertEquals("HEAD_GEAR", headGear1.getGearType().toString());
    assertEquals(0, headGear1.getAttack());
    assertEquals(30, headGear1.getDefense());
    assertEquals("Good", headGear1.getAdjective());
    assertEquals("Cool", headGear1.getNoun());
  }

  @Test
  public void testHandGear() {
    HandGear handGear1 = new HandGear("Nice", "Wow", 20, 0);
    assertEquals("HAND_GEAR", handGear1.getGearType().toString());
    assertEquals(20, handGear1.getAttack());
    assertEquals(0, handGear1.getDefense());
    assertEquals("Nice", handGear1.getAdjective());
    assertEquals("Wow", handGear1.getNoun());
  }

  @Test
  public void testFootWearCombine() {
    FootGear footWear1 = new FootGear("Nice", "Wow", 20, 30);
    FootGear footWear2 = new FootGear("Nice eee", "Wow www", 10, 20);
    assertEquals(30, footWear1.combineGears(footWear2).getAttack());
    assertEquals(50, footWear1.combineGears(footWear2).getDefense());
    assertEquals("Nice, Nice eee",
            footWear1.combineGears(footWear2).getAdjective());
    assertEquals("Wow www", footWear1.combineGears(footWear2).getNoun());
    assertEquals("Nice, Nice eee Wow www",
            footWear1.combineGears(footWear2).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCombineWithDifferentType() {
    FootGear footWear1 = new FootGear("Nice", "Wow", 20, 30);
    HandGear handGear1 = new HandGear("Nice", "Wow", 20, 30);
    HeadGear headGear1 = new HeadGear("Wok", "Ca", 20, 30);
    HandGear handGear2 = null;
    footWear1.combineGears(handGear1).getAttack();
    footWear1.combineGears(handGear2).getAttack();
    footWear1.combineGears(headGear1).getAttack();
    footWear1.combineGears(handGear1).getGearType();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttackOrDefenseInputForFootWear() {
    FootGear footWear1 = new FootGear("Good", "Cool", -20, 30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAdjOrNounInputForFootWear() {
    FootGear footWear1 = new FootGear(null, "", 20, 30);
  }

  @Test
  public void testHandGearCombine() {
    HandGear handGear1 = new HandGear("Nice", "Wow", 20, 0);
    HandGear handGear2 = new HandGear("Nice eee", "Wow www", 10, 0);
    assertEquals(30, handGear1.combineGears(handGear2).getAttack());
    assertEquals("Nice, Nice eee", handGear1.combineGears(handGear2).getAdjective());
    assertEquals("Wow www", handGear1.combineGears(handGear2).getNoun());
    assertEquals("Nice, Nice eee Wow www", handGear1.combineGears(handGear2).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttackOrDefenseInputForHandGear() {
    HandGear handGear1 = new HandGear("Good", "Cool", -20, 30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAdjOrNounInputForHandGear() {
    HandGear handGear1 = new HandGear(null, "", 20, 30);
  }

  @Test
  public void testHeadGearCombine() {
    HeadGear headGear1 = new HeadGear("Good", "Cool", 0, 30);
    HeadGear headGear2 = new HeadGear("Good ddd", "Cool lll", 0, 20);
    assertEquals(50, headGear1.combineGears(headGear2).getDefense());
    assertEquals("Good, Good ddd",
            headGear1.combineGears(headGear2).getAdjective());
    assertEquals("Cool lll", headGear1.combineGears(headGear2).getNoun());
    assertEquals("Good, Good ddd Cool lll",
            headGear1.combineGears(headGear2).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttackOrDefenseInputForHeadGear() {
    HeadGear headGear1 = new HeadGear("Good", "Cool", 0, -30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAdjOrNounInputForHeadGear() {
    HeadGear headGear1 = new HeadGear(null, "", 20, 30);
  }
}



