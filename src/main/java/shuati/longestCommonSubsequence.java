package shuati;
/**
* @Description: 给定两个字符串str1和str2，输出连个字符串的最长公共子序列。如过最长公共子序列为空，则输出-1。
 * "1A2C3D4B56","B1D23CA45B6A"  返回"123456" "123456"和“12C4B6”都是最长公共子序列，任意输出一个。
* @Param:
* @return:
* @Author: Mr.Pan
* @Date: 2021/3/30
*/
public class longestCommonSubsequence {

    public static void main(String[] args) {
        longestCommonSubsequence l = new longestCommonSubsequence();
        System.out.println(l.LCS("1A2C3D4B56", "B1D23CA45B6A"));
    }

    public String LCS (String s1, String s2) {

        String result = "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int r=0;r<s1.length();r++){

            int str2Index = 0;
            if (result.length()<stringBuffer.length())
                result = stringBuffer.toString();
            System.out.println(stringBuffer);
            stringBuffer = new StringBuffer();

            for (int i = r; i < s1.length(); i++) {

               // System.out.println(str2Index);
                for (int j = str2Index; j < s2.length(); j++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        stringBuffer.append(s1.charAt(i));
                        str2Index = j+1;
                        break;
                    }
                }

            }

        }
        if (result.length() == 0) {
            return "-1";
        }else return result;

    }
}
