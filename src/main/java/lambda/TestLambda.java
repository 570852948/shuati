package lambda;

public class TestLambda {

    public static void main(String[] args) {
        //lambda
        //调用该接口方法时传参是什么，w就是什么
        H(w-> System.out.println(w.name));

        //匿名内部类实现接口
        A a = new A() {
            @Override
            public void methodA(Hero h) {
                System.out.println(h.name);
            }
        };

        H(a);

        //引用静态函数
        H(h -> TestLambda.U(h));
        H(TestLambda::U);
    }

    public static void H(A a) {
        Hero hero = new Hero();
        a.methodA(hero);
    }

    public static void U(Hero hero) {
        hero.setName("U");
        System.out.println(hero.name);
    }
}
