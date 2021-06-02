package shuati;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {
        List<Student> list = new ArrayList();

        list.add(new Student(5, "ss"));
        list.add(new Student(1, "ss"));
        sort(list);
        System.out.println(list);
    }


    public static void sort(List<Student> list) {

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                }else return -1;
            }});
        }



  static   class Student{
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

      @Override
      public String toString() {
          return "Student{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  '}';
      }
  }
}

