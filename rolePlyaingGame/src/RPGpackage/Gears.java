package RPGpackage;

public abstract class Gears implements GearFace  {

  private final GearType type;
  private String noun;
  private String adjective;
  private int attack;
  private int defense;

  public Gears(GearType type,String adjective,String noun ,  int attack,
               int defense) {
    super();
    this.type = type;
    this.noun =noun;
    this.adjective = adjective;
    this.attack = attack;
    this.defense = defense;


    if (this.attack < 0 || this.defense < 0) {
      throw new IllegalArgumentException("Invalid Attack and defense value.");
    }

    // Adjective can't be empty
    if (this.adjective == null || this.adjective.equals("")) {
      throw new IllegalArgumentException("feature can't be empty.");
    }

    // Noun can't be negative
    if (this.noun == null || this.noun.equals("")) {
      throw new IllegalArgumentException("Noun can't be empty.");
    }

  }
  @Override
  public GearType getGearType() {
    return this.type;
  }


  @Override
  public String getNoun() {
    return noun;
  }

  @Override
 public String getAdjective() {
    return adjective;
  }

  @Override
  public int getAttack(){
    return attack;
  }

  @Override
  public int getDefense(){
    return defense;
  }

  @Override
  public String toString(){
    return this.getAdjective() + " " + this.getNoun();
  }

 public abstract Gears newGear(String newAdj, String newNoun, int newAttack,
                   int newDefense);
  @Override
  public Gears combineGears(Gears gear) {
       if (gear == null) {
    throw new IllegalArgumentException("Gears can't be null.");
  }

      if (gear.getGearType() != this.getGearType()) {
    throw new IllegalArgumentException("Gear types are not the same.");
  }

           String newNoun =  gear.getNoun();
           String newAdj =  this.getAdjective()+ ", "+ gear.getAdjective();
           int newAttack =   this.getAttack()+gear.getAttack();
           int newDefense =  gear.getDefense() + this.getDefense();

      return newGear(newAdj, newNoun, newAttack, newDefense);
}

}
