import org.junit.Test;

import java.util.ArrayList;

import RPGpackage.Battle;
import RPGpackage.Character;
import RPGpackage.CharacterImp;
import RPGpackage.FootGear;
import RPGpackage.Gears;
import RPGpackage.HandGear;
import RPGpackage.HeadGear;

import static org.junit.Assert.*;

public class BattleTest {


  @Test
  public void TestStartBattle() {

    ArrayList<Gears> equipmentlist = new ArrayList<>();

    HeadGear headgear1 = new HeadGear(
            "SPIKY", "HELMET", 0, 5);
    HandGear handgear1 = new HandGear(
            "LEATHER", "GLOVES", 5, 0);
    HandGear handgear2 = new HandGear(
            "SILVER", "SHEILDS", 4, 0);
    HandGear handgear3 = new HandGear(
            "SHARP", "SWORDS", 10, 0);
    FootGear footgear1 = new FootGear("JET", "HOVERBOARDS", 10, 2);
    FootGear footgear2 = new FootGear("MAGIC", "BOOTS", 4, 10);
    FootGear footgear3 = new FootGear("NIKE", "SNEAKERS", 6, 3);
    HeadGear headgear2 = new HeadGear(
            "BLACK", "HAT", 0, 5);
    HandGear handgear4 = new HandGear(
            "GOLDEN", "SWORD", 5, 0);
    HandGear handgear5 = new HandGear(
            "MAGIC", "SHEILDS", 4, 0);
    HandGear handgear6 = new HandGear(
            "IRON", "GLOVES", 4, 0);
    FootGear footgear4 = new FootGear("JET", "SNEAKERS", 10, 2);
    FootGear footgear5 = new FootGear("SPIRAL", "BOOTS", 4, 10);
    FootGear footgear6 = new FootGear("FLYING", "SNEAKERS", 6, 3);
    equipmentlist.add(headgear1);
    equipmentlist.add(handgear2);
    equipmentlist.add(handgear1);
    equipmentlist.add(footgear1);
    equipmentlist.add(footgear2);
    equipmentlist.add(footgear3);
    equipmentlist.add(handgear3);
    equipmentlist.add(footgear5);
    equipmentlist.add(headgear2);
    equipmentlist.add(footgear4);
    equipmentlist.add(handgear4);
    equipmentlist.add(handgear5);
    equipmentlist.add(footgear6);
    equipmentlist.add(handgear6);

    Character player3 = new CharacterImp("Nuckles", 0, 0);

    Character player4 = new CharacterImp("BOXY_BOO", 0, 0);
    Battle battle = new Battle(player3, player4, equipmentlist);

    String log = "Player 1 win!!!";
    assertEquals(log, battle.startBattle());
  }
    @Test
    public void TestTieBattle() {
    Character player1 = new CharacterImp("Sonic", 2, 5);
    Character player2 = new CharacterImp("Dr.Egg", 2, 5);
    ArrayList<Gears> equipmentlist2 = new ArrayList<>();
    HandGear handgear = new HandGear(
            "LEATHER", "GLOVES", 5, 0);
    HandGear handgear11 = new HandGear(
            "SILVER", "SHEILDS", 5, 0);
    equipmentlist2.add(handgear);
    equipmentlist2.add(handgear11);
    Battle battle2 = new Battle(player1, player2, equipmentlist2);
    String log= "Tie!!!";
    assertEquals(log, battle2.startBattle());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAdjOrNounInputForHeadGear() {
    HeadGear headGear1 = new HeadGear(null, "", 20, 30);
  }
}