package leetCode;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("bbbbbb"));


    }

    public static int lengthOfLongestSubstring(String s) {
        int MAX = 0;
        String sub = "";
        int start = 0;
        //int end = 0;
        int location = -1;
        for (int i = 0; i < s.length(); i++) {
            //检查截取字符串中是否有该字符 没有就-1
            location = sub.indexOf(s.charAt(i));
            if (location == -1) {

                sub = s.substring(start, i+1);
                if (MAX < sub.length())
                    MAX = sub.length();

            }else {
                //如果发现有存在的字符串  则把截取的起点往后面移一个位置


                start = start + 1;
            }
        }
        return MAX;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int MAX = 0;

        for (int i = 0; i <s.length(); i++) {
            String sub = "";
            for (int j = i; j < s.length(); j++) {

                if (sub.indexOf(s.charAt(j))!=-1) {
                    break;
                }
                sub = s.substring(i, j+1);
                if (MAX < j - i + 1)
                    MAX = j - i +1;
            }
        }
        return MAX;
    }


}
