package RPGpackage;

public class HeadGear extends Gears {


  public HeadGear(String adjective, String noun, int attack,
                  int defense) {
    super(GearType.HEAD_GEAR,adjective,noun, attack, defense);

  }

  @Override
 public int getAttack(){
    return 0;
  }

  @Override
  public Gears newGear(String newAdj, String newNoun, int newAttack,
                       int newDefense){

    return new HeadGear(newAdj,newNoun,newAttack,newDefense);


  }
}