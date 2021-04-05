package Test;

public interface Default {
    default void o() {
        System.out.println(this.getClass());
        System.out.println("o方法测");
    }
}
