package RPGpackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface Character{


  String getName();

  int getDefendVal();

  int getAttackVal();


  ArrayList<Gears> getHandGear();

  ArrayList<Gears>  getFootGear();

  List<Gears> sortGears(List<Gears> gearsList);

  void choseGears(List<Gears> gearslist);


}
