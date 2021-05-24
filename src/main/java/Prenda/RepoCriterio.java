package Prenda;

import java.util.HashSet;
import java.util.Set;

public class RepoCriterio {
  private static Set<Criterio> criterioList = new HashSet<>();
  private static RepoCriterio repoCriterio = new RepoCriterio();

  public static RepoCriterio getIntance() {
    return repoCriterio;
  }

  public void agregarCriterio(Criterio criterio) {
    this.criterioList.add(criterio);
  }

  public boolean existeCriterio(Criterio criterio) {
    return this.criterioList.contains(criterio);
  }
}
