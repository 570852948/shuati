package Data;

import sun.security.jca.GetInstance.Instance;

public class DuoZhiChuanRu {


    public static void main(String[] args) {
        try {
            //动态加载类
            System.out.println(DuoZhiChuanRu.class.getClassLoader());
            DuoZhiChuanRu duoZhiChuanRu = DuoZhiChuanRu.class.newInstance();
            duoZhiChuanRu.s(1,2,3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //...就是数组
    public void s(int... strings){
        System.out.println(strings[1]);
    }
}
