package com.test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class ShudentTest {
	
    public static void main(String[] args) {
        //sort();
    	page(10, 2);
    }
    
    /**
     * 排序
     */
    public static void sort() {
    	List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "Mahesh", 12));
        list.add(new Student(2, "Suresh", 15));
        list.add(new Student(3, "Nilesh", 10));

        System.out.println("---Natural Sorting by Name---");
        List<Student> slist = list.stream().sorted().collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));

        System.out.println("---Natural Sorting by Name in reverse order---");
        slist = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));        

        System.out.println("---Sorting using Comparator by Age---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));

        System.out.println("---Sorting using Comparator by Age with reverse order---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));
    }
    
    /**
     * 分页
     * @param pageSize
     * @param pageNo
     */
    public static void page(int pageSize, int pageNo) {
    	List<Student> students = new ArrayList<Student>();
    	for (int i = 0; i < 100; i++) {
			Student student = new Student(i+1, "name"+(i+1), i+1);
			students.add(student);
		}
    	List<Student> list = students.stream().skip(pageNo).limit(pageSize).collect(Collectors.toList());
    	list.forEach(stu->{
    		System.out.println("Id:"+ stu.getId()+", Name: "+stu.getName()+", Age:"+stu.getAge());
    	});
    }
}