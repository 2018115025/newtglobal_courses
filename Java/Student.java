import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getMarks() == student.getMarks() && Objects.equals(getName(), student.getName());
    }

    @Override
    public String toString() {
        return "Student => {" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMarks());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
class RankComp implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getMarks()>o2.getMarks()){
            return -1;
        }
        else if(o1.getMarks()<o2.getMarks()){
            return 1;
        }
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

class Main{
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student("ram",70));
        list.add(new Student("prem",60));
        list.add(new Student("kumar",60));
        list.add(new Student("dhanush",60));
        list.add(new Student("rajesh",30));
        System.out.println("before sort");
        list.forEach(System.out::println);
        Collections.sort(list,new RankComp());
        System.out.println("After sort");
        list.forEach(System.out::println);
        System.out.println("student marks more than 50 ");
        List<Student> ans= list.stream().filter(s->s.getMarks()>50).collect(Collectors.toList());
        System.out.println(ans);
    }
}

