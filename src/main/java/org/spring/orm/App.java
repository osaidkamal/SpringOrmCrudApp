package org.spring.orm;

import org.spring.orm.dao.StudentDao;
import org.spring.orm.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


public class App {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao) c.getBean("studentDao");
//        Student student=new Student(2324,"Osaid","Delhi");
//        int r=studentDao.insert(student);
//        System.out.println("Done "+r);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while (go) {
            System.out.println("1.Add Student");
            System.out.println("2.Display");
            System.out.println("3.Get Single Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Update Student");
            System.out.println("6.Exit");
            try {
                int inp = Integer.parseInt(br.readLine());
                switch (inp) {
                    case 1: {
                        System.out.println("Enter User Id");
                        int uid = Integer.parseInt(br.readLine());
                        System.out.println("Enter Name");
                        String name = br.readLine();
                        System.out.println("Enter city");
                        String city = br.readLine();
                        Student student = new Student();
                        student.setStudentId(uid);
                        student.setName(name);
                        student.setCity(city);
                        int r = studentDao.insert(student);
                        System.out.println("Student Added " + r);
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    }
                    case 2: {
                        List<Student> allStudents = studentDao.getAllStudents();
                        for (Student st : allStudents) {
                            System.out.println("Id: " + st.getStudentId()+"  Name: " + st.getName()+"  City: " + st.getCity());
                            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
                        }
                        break;

                    }
                    case 3: {
                        System.out.println("Enter User Id");
                        int userId = Integer.parseInt(br.readLine());
                        Student g = studentDao.getStudent(userId);
                        System.out.println("Id: " + g.getStudentId()+"  Name: " + g.getName()+"  City: " + g.getCity());
                        break;
                    }
                    case 4: {
                        System.out.println("Enter User Id");
                        int uuid = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(uuid);
                        System.out.println("Deleted");
                        break;
                    }
                    case 5: {
                        System.out.println("Enter User Id");
                        int uid1 = Integer.parseInt(br.readLine());
                        System.out.println("Enter Name");
                        String name1 = br.readLine();
                        System.out.println("Enter city");
                        String city1 = br.readLine();
                        Student stu = new Student();
                        stu.setName(name1);
                        stu.setStudentId(uid1);
                        stu.setCity(city1);
                        studentDao.updateStudent(stu);
                        System.out.println("Updated");
                        break;

                    }
                    case 6: {
                        go = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                System.out.println(e.getMessage());
            }
        }


    }
}
