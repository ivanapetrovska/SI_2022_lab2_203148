import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) {//A
        if (list.size() <= 0) {//B
            throw new IllegalArgumentException("List length should be greater than 0");//C
        }
        int n = list.size();//D
        int rootOfN = (int) Math.sqrt(n);//D
        if (rootOfN * rootOfN  != n) {//E
            throw new IllegalArgumentException("List length should be a perfect square");//F
        }
        List<String> numMines = new ArrayList<>();//G
        for (int i = 0; i < n; i++) {//H
            if (!list.get(i).equals("#")) {//I
                int num = 0;//J
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) {//K
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){//L
                        num += 2;//M
                    }
                    else {//N
                        num  += 1;
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){//O
                    num++;//P
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){//Q
                    num++;//R
                }
                numMines.add(String.valueOf(num));//S
            }
            else {//T
                numMines.add(list.get(i));
            }
        }//U
        return numMines;//V
    }//W
}