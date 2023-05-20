package RPGpackage;

  public class HandGear extends Gears {

    public HandGear(String adjective, String noun, int attack,int defense) {
      super(GearType.HAND_GEAR,adjective,noun, attack, defense);
    }

    @Override
    public int getDefense(){
      return 0;
    }

    @Override
    public Gears newGear(String newAdj, String newNoun, int newAttack,
                                  int newDefense){

      return new HandGear(newAdj,newNoun,newAttack,newDefense);


    }


    }

