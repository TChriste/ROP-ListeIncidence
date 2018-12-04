package utils;

import java.util.Comparator;
import model.Noeuds.Noeud;

public class DijkstraNodeComparator implements Comparator {

  public int compare(Object o1, Object o2) {
    Noeud one = (Noeud) o1;
    Noeud two = (Noeud) o2;

    if(one.getDijkstraPoids() < two.getDijkstraPoids()){
      return -1;
    } else if(one.getDijkstraPoids() > two.getDijkstraPoids()){
      return 1;
    } else{
      return 0;
    }
  }
}
