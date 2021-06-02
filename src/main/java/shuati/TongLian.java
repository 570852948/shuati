package shuati;

import java.util.*;

public class TongLian {



    public static void main(String[] args) {
        List<Student> list = new ArrayList();
        list.add(new Student(1,"xx",25));
        list.add(new Student(2,"xx",21));
        list.add(new Student(3,"xx",23));

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                }else return -1;
            }
        });
        list.forEach((student -> System.out.println(student.id)));
    }



}

class Student{
    Integer id;
    String name;
    Integer age;

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}