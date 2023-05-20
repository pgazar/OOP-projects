package RPGpackage;

public interface GearFace {
  GearType getGearType();

  String getNoun();

  String getAdjective();

  int getAttack();

  int getDefense();

 Gears combineGears(Gears gear);
}
