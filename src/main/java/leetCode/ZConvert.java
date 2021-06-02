package leetCode;

public class ZConvert {

    public static void main(String[] args) {
        String[][] s = {{"1","2","3"},{"4","5","6"}};

        //System.out.println(s);
        String result = concert2("PAYPALISHIRING",3);
        System.out.println(result);

    }

    public static void printArray(String[][] z) {
        for (int i = 0; i < z.length; i++) {
            System.out.println();
            for (int j = 0; j < z[i].length; j++) {
                System.out.print(z[i][j]+" ");
            }
        }
    }

    //leetCode思路: 模拟法  上下滑动数组的index  添加遍历到的字符
    public static String concert2(String s,int numRows) {

        String[] strings = new String[numRows];

        //把null去了
        for (int i = 0; i < numRows; i++) {
            strings[i] = "";
        }

        int index = 0;
        String flag = "增";
        for (int i = 0; i < s.length(); i++) {
            strings[index] = strings[index] + s.charAt(i);

            if (index == 0) {
                flag = "增";
            } else if (index == numRows - 1) {
                flag = "减";
            }
            if (flag.equals("增")) {
                index++;
            }else {
                index--;
            }
        }
        s = "";
        for (int i = 0; i < numRows; i++) {
            s = s + strings[i];
        }
        return s;
    }








    //不使用技巧很难
    public static String concert(String s, int numRows) {



        //每一列数量为 numRows


        //排除长度小于等于numRows的情况
        if (s.length() <= numRows || numRows == 1) {
            return s;
        } else if (numRows == 2) {
            String r = "";
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    r = r + s.charAt(i);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    r = r + s.charAt(i);
                }
            }
            return r;
        }
        //列之间有 numRows-2 个字母  如果numRows<3怎么处理？
        int gap = numRows - 2;

        //尝试用二维数组解决


        //计算有几列
        //int lie = s.length()/numRows;
        String[][] z = new String[numRows][s.length()];

        int HX = 0;

        int count = 0;

        int temp = numRows-1;

        //遍历所有字符
        for (int i = 0; i < s.length(); i++) {

            if (count<numRows) {
                z[count][HX] = s.charAt(i)+"";
                count++;

            }else if (count >= numRows) {
                    temp--;
                    HX++;
                    z[temp][HX] = s.charAt(i)+"";
                    count++;
                    if (count == numRows + gap){
                        count = 0;
                        HX++;
                        temp = numRows - 1;
                    }

            }






        }

        //printArray(z);
        String r = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (z[i][j] != null)
                    r = r + z[i][j];
            }
        }


        return r;

    }
}
