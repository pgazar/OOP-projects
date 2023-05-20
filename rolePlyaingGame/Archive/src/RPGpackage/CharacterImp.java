package RPGpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class CharacterImp implements Character {

  private final int MAX_HAND = 2;
  private final int MAX_FOOT = 2;

  private final String charName;
  private int baseDefense;
  private int baseAttack;


  private Gears headGear;
  private ArrayList<Gears> handGearList;
  private ArrayList<Gears> footGearList;


  public CharacterImp(String charName, int baseAttack,int baseDefense) {

    if (baseAttack < 0 || baseDefense < 0) {
      throw new IllegalArgumentException("Attack and defense value should be positive.");
    }
    if (charName== null) {
      throw new IllegalArgumentException("name is not valid!");
    }
    this.charName = charName;
    this.baseDefense = baseDefense;
    this.baseAttack = baseAttack;
    this.handGearList = new ArrayList<Gears>();
    this.footGearList = new ArrayList<Gears>();
    this.headGear = null;
  }

  @Override
  public String getName() {
    return this.charName;
  }

  @Override
  public int getDefendVal() {
    int totalDefense = baseDefense;
    if (headGear != null) {
      totalDefense += headGear.getDefense();
    }
    for (Gears f : footGearList) {
      totalDefense += f.getDefense();
    }

    return totalDefense;
  }


  @Override
  public int getAttackVal() {
    int totalAttack = baseAttack;
    for (Gears h : handGearList) {
      totalAttack += h.getAttack();
    }
    for (Gears f : footGearList) {
      totalAttack += f.getAttack();
    }

    return totalAttack;
  }

  public Gears getHeadGear() {
    return headGear;
  }

  @Override
  public ArrayList<Gears> getHandGear() {
    return handGearList;
  }

  @Override
  public ArrayList<Gears> getFootGear() {
    return footGearList;
  }


  @Override
  public List<Gears> sortGears(List<Gears> gearsList) {
       List<Gears> sortedGearList = gearsList;

            // Sort gearList based on attack value in descending order
    Comparator<Gears> attack = Comparator.comparing(Gears::getAttack,
            Comparator.reverseOrder());
    // Sort gearList based on defense value in descending order
    Comparator<Gears> defense= Comparator.comparing(Gears::getDefense,
            Comparator.reverseOrder());
      sortedGearList.sort(attack.thenComparing(defense));

    return sortedGearList;
 }


  @Override
  public void choseGears(List<Gears> gearslist) {
    gearslist = sortGears(gearslist);
    for (Gears gear : gearslist) {
      GearType type = gear.getGearType();
      if(type.equals(GearType.HAND_GEAR) && this.handGearList.size() < MAX_HAND) {
        this.handGearList.add(gear);
        gearslist.remove(gear);
        return;
      }
      else if (type.equals(GearType.FOOT_GEAR) && this.footGearList.size() < MAX_FOOT) {
        this.footGearList.add(gear);
        gearslist.remove(gear);
        return;
      } else if (this.headGear == null) {
        if(type.equals(GearType.HEAD_GEAR)){

          this.headGear = gear;
          gearslist.remove(gear);
          return;}

        }
    }
    //&& this.headGear != null && this.footGearList.size() >=2 && this.handGearList.size() >=2
    if (gearslist.size() > 0 ) {
      Gears gear = gearslist.get(0);
      GearType type = gear.getGearType();
      switch (type) {
        case HEAD_GEAR:
          headGear = headGear.combineGears(gear);
          gearslist.remove(gear);
          break;
        case HAND_GEAR:
          Gears newHandGear = handGearList.get(1).combineGears(gear);
          handGearList.remove(1);
          handGearList.add(newHandGear);
          gearslist.remove(gear);
          break;
        case FOOT_GEAR:
          Gears newFootWear = footGearList.get(1).combineGears(gear);
          footGearList.remove(1);
          footGearList.add(newFootWear);
          gearslist.remove(gear);
          break;
      }
    }

  }

  @Override
  public String toString() {
    String Handlist = "";
    String Footlist = "";

    for (Gears g : this.handGearList) {
        Handlist += g.toString() + "   ";
      }

    for (Gears e : this.footGearList) {
      Footlist += e.toString() + "   ";
    }
    return  "Hand gears: " + handGearList + "\n " +
            "Foot gears: " + footGearList + "\n " +
            "Head gears: " + this.headGear + "\n " +
            "Final attack:" + this.getAttackVal() + ", " +
            "Final defense:" + this.getDefendVal();

  }
}