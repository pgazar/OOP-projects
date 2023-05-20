package RPGpackage;


  public class FootGear extends Gears {

    // Constructor
    public FootGear(String feature,String name ,
                  int attack,  int defense) {
      super(GearType.FOOT_GEAR,feature,name, attack, defense);
    }

    /**
     * Create a new equipment which have the same type
     * @param
     * @return FootGears obj
     */
    @Override
    public Gears newGear(String newAdj, String newNoun, int newAttack,
                         int newDefense){

      return new FootGear(newAdj,newNoun,newAttack,newDefense);


    }



}
