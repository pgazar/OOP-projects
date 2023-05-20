import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import RPGpackage.Character;
import RPGpackage.CharacterImp;
import RPGpackage.Battle;
import RPGpackage.Gears;
import RPGpackage.FootGear;
import RPGpackage.HeadGear;
import RPGpackage.HandGear;

import static org.junit.Assert.*;

public class CharacterImpTest {
  @Test
  public void testPlayer() {
    Gears equipment9 = new FootGear("GOOD9", "foot2",9, 7);
    Gears equipment4 = new HandGear("GOOD4", "GLOVE4",6, 0);
    Gears equipment3 = new HandGear( "GOOD3", "GLOVE3",4, 0);
    Gears equipment1 = new FootGear("GOOD1", "foot1",3, 5);
    Gears equipment2 = new HandGear( "GOOD2", "GLOVE2",1, 0);
    Gears equipment7 = new HeadGear("GOOD7", "head3",0, 10);
    Gears equipment5 = new HeadGear("GOOD5", "head1",0, 8);
    Gears equipment6 = new HeadGear("GOOD6", "head2",0, 5);
    Gears equipment8 = new HeadGear("GOOD8", "head4",0, 3);


    List<Gears>  list = new ArrayList<Gears>();
    list.add(equipment1);
    list.add(equipment2);
    list.add(equipment3);
    list.add(equipment4);
    list.add(equipment5);
    list.add(equipment6);
    list.add(equipment7);
    list.add(equipment8);
    list.add(equipment9);


    Character player1 = new CharacterImp ("Sonic", 0, 0);
    Character player2 = new CharacterImp ("Dr.Egg", 0, 0);

    player1.choseGears(list);
    player1.choseGears(list);
    player1.choseGears(list);
    player1.choseGears(list);
    player1.choseGears(list);
    player1.choseGears(list);
    /*for (Equipment x : lis) {
      System.out.print(x.getName() + "\n");
    }*/
    assertEquals("Hand gears: [GOOD4 GLOVE4, GOOD3, GOOD2 GLOVE2]\n" +
            " Foot gears: [GOOD9 foot2, GOOD1 foot1]\n" +
            " Head gears: GOOD7 head3\n" +
            " Final attack:23, Final defense:22", player1.toString());
  }
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttackOrDefenseInputForCharacter() {
     Character player = new CharacterImp("IRON", -20, -30);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testtestInvalidNounInputForCharacter() {
    Character player = new CharacterImp(null, 10, 20);
  }

}
