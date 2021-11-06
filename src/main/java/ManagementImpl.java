import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagementImpl extends UnicastRemoteObject implements Management {

    private List<Student> students = new ArrayList<>();

    public ManagementImpl() throws RemoteException {
    }

    @Override
    public void add_student(Student student) throws RemoteException {
        if (!students.contains(student.getId())){
            students.add(student);
        }
    }

    @Override
    public Student get_student(int studentId) throws RemoteException {
        for(Student student: students)
            if (student.getId() == studentId) {
                return student;
            }
        return null;
    }

    @Override
    public double promotion_score() throws RemoteException {
        double total = 0;
        for(Student student: students){
            if(student.getExams().size() != 0){
                total += calculate_average(student);
            }
        }
        return total /students.size();
    }

    @Override
    public void add_exam(Student student, Exam exam) throws RemoteException {
        student = get_student(student.getId());
        if(student == null){
            System.out.println("Student does not exist");
        } else{
            student.getExams().add(exam);
        }
    }

    @Override
    public String print_exams(Student student) throws RemoteException {
        return student.toString();
    }

    @Override
    public double calculate_average(Student student) throws RemoteException {
        double total_coeff = 0.0 ;
        double total_points = 0.0; //exam score * coeff
        double average = 0.0; // total points / total coeff

        for (Exam exam: student.getExams()){
            total_coeff += exam.getCoefficient();
            total_points += exam.getExam_score() * exam.getCoefficient();
        }


        average = total_points / total_coeff;
        System.out.println(average);

        return average;
    }
}
