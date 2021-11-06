import java.rmi.Naming;

public class Client {



    public static void main(String[] args) {
        try{
            Management obj = (Management) Naming.lookup("rmi://localhost:1099/promotion");
            System.out.println("Got Server");

//            Add Students
            Student student1 = new Student(1, "Shinwon", 25);
            Student student2 = new Student(2, "Yanan", 24);
            Student student3 = new Student(3, "Hongseok", 26);
            obj.add_student(student1);
            obj.add_student(student2);
            obj.add_student(student3);

//            Add exam to Student
            Student studentShinwon = obj.get_student(1);
            obj.add_exam(studentShinwon, new Exam("Chemistry", 15, 0.8));
            obj.add_exam(studentShinwon, new Exam("Physics", 17, 0.5));

            Student studentYanan = obj.get_student(2);
            obj.add_exam(studentYanan, new Exam("Biology", 12, 0.2));
            obj.add_exam(studentYanan, new Exam("Physics", 12, 0.5));

            Student studentHongseok = obj.get_student(3);
            obj.add_exam(studentHongseok, new Exam("Geography", 18, 0.5));
            obj.add_exam(studentHongseok, new Exam("Mathematics", 10, 0.5));

            System.out.println("exams added");

//            Print exams
            System.out.println("print exams");
            System.out.println(obj.print_exams(obj.get_student(1)));
            System.out.println(obj.print_exams(obj.get_student(2)));
            System.out.println(obj.print_exams(obj.get_student(3)));

//            calculate average
            System.out.println("Average score");
            System.out.println(obj.calculate_average(obj.get_student(1)));
            System.out.println(obj.calculate_average(obj.get_student(2)));
            System.out.println(obj.calculate_average(obj.get_student(3)));

//            Total promotion score
            System.out.println("Promotion score");
            System.out.println(obj.promotion_score());

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
