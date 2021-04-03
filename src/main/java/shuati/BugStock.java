package shuati;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class BugStock {

    public static void main(String[] args) {
        int[] stock = {5,5,7,1,9,6,4,88,9,99,1,200};
        int[] wz = IndexB(stock);
        System.out.println("最佳买点："+ wz[0] + "最佳卖点："+ wz[1]);

    }

    //以买点为基准根据卖点与卖点的最大差值找到index
    public static int[] IndexB(int[] stock) {
        int cz = 0;
        int indexB = -1;
        int indexS = -1;
        int[] f = new int[2];
        for (int i = 0; i <= stock.length; i++) {
            for (int j = i; j < stock.length; j++) {
                if (stock[j] - stock[i] > cz) {
                    cz = stock[j] - stock[i];
                    indexB = i;
                    indexS = j;
                }
            }
        }
        f[0] = indexB;
        f[1] = indexS;
        return f;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        Vector<Integer> vector = (Vector<Integer>) Arrays.stream(input).iterator();
        ArrayList<Integer> list = new ArrayList();
        if(k>input.length)
            return list;
        for(int i=0;i<input.length;i++)
            for(int j=0;j<input.length-i-1;j++){
                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }

        for(int q=0;q<k;q++){
            list.add(input[q]);
        }
        return list;
    }


    public void Te() {
        int[] p = new int[2];

        System.out.println(p[1]);
    }
}
