package RPGpackage;

import java.util.ArrayList;
import java.util.List;

public class Battle implements BattleFace {

  private final int MAX_TURN = 10;
   private final Character player1;
   private final Character player2;

  private List<Gears> gearList;


  public Battle(Character player1, Character player2, List<Gears> gearList){
    this.player1 = player1;
    this.player2 = player2;
    if (gearList == null || gearList.isEmpty()) {
      throw new IllegalArgumentException("gearList cannot be null or empty");
    }
    this.gearList = gearList;
  }

  @Override
  public String startBattle() {
    StringBuilder battleField = new StringBuilder();
    for (int i = 0; i < MAX_TURN; i++) {
      battleField.append("battlefield ").append(i + 1).append("\n");
      player1.choseGears(this.gearList);
      player2.choseGears(this.gearList);
      battleField.append("player1:" + player1.getName() + "\n").append(player1).append("\n");
      battleField.append("player2:" + player2.getName() + "\n").append(player2).append("\n");
    }

    int attack1 = player1.getAttackVal();
    int defense1 = player1.getDefendVal();
    int attack2 = player2.getAttackVal();
    int defense2 = player2.getDefendVal();

    if ((attack1 - defense2) == (attack2 - defense1)) {
      battleField.append("Tie!!!\n");
      System.out.println(battleField.toString()); // print battlefield
      return "Tie!!!";
    } else if ((attack1 - defense2) > (attack2 - defense1)) {
      battleField.append("Player 1 win!!!\n");
      System.out.println(battleField.toString()); // print battlefield
      return "Player 1 win!!!";
    } else {
      battleField.append("Player 2 win!!!\n");
      System.out.println(battleField.toString()); // print battlefield
      return "Player 2 win!!!";
    }
  }

  public static void main(String[] args) {

    ArrayList<Gears> equipmentlist = new ArrayList<>();
    Character player1 = new CharacterImp ("Sonic", 2, 5);
    Character player2 = new CharacterImp ("Dr.Egg", 2, 5);
    HeadGear headgear1 = new HeadGear(
            "SPIKY","HELMET",0,5);
    HandGear handgear1 = new HandGear(
            "LEATHER", "GLOVES",5,0);
    HandGear handgear2 = new HandGear(
            "SILVER", "SHEILDS",4,0);
    HandGear handgear3 = new HandGear(
            "SHARP", "SWORDS",10,0);
    FootGear footgear1 = new FootGear("JET", "HOVERBOARDS", 10,2);
    FootGear footgear2 = new FootGear("MAGIC", "BOOTS", 4,10);
    FootGear footgear3 = new FootGear("NIKE", "SNEAKERS", 6,3);
    HeadGear headgear2 = new HeadGear(
            "BLACK","HAT",0,5);
    HandGear handgear4 = new HandGear(
            "GOLDEN", "SWORD",5,0);
    HandGear handgear5 = new HandGear(
            "MAGIC", "SHEILDS",4,0);
    HandGear handgear6 = new HandGear(
            "IRON", "GLOVES",4,0);
    FootGear footgear4 = new FootGear("JET", "SNEAKERS", 10,2);
    FootGear footgear5 = new FootGear("SPIRAL", "BOOTS", 4,10);
    FootGear footgear6 = new FootGear("FLYING", "SNEAKERS", 6,3);
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

    System.out.println("====================================== ");
    System.out.println("Unsorted Equipments:\n");
    for(int i=0; i < equipmentlist.size();i++){
     System.out.println(equipmentlist.get(i) +
             " attack value: " +equipmentlist.get(i).getAttack());
    }
//
//    Iterator<Gears> git = equipmentlist.listIterator();
//    while(git.hasNext()){
//      System.out.println(git.next()+  " attack value: " + git.next().getAttack());}
    System.out.println("====================================== ");
    Battle battle1 = new Battle(player1,player2, equipmentlist);
    battle1.startBattle();


  }



}

