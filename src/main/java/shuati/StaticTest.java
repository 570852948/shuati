package shuati;

public class StaticTest{
     private static int x=100;
    public static void main(String[] args){
                StaticTest hs1=new StaticTest();
                x++;
                StaticTest hs2=new StaticTest();
                x++;
                hs1=new StaticTest();
                x++;
               StaticTest.x--;
               System.out.println("x="+x);
            }
   } 