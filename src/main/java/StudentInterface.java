public interface StudentInterface extends java.rmi.Remote{
    public void add_exam(Student student, Exam exam) throws java.rmi.RemoteException;

    public String print_exams(Student student) throws java.rmi.RemoteException;

    public double calculate_average(Student student) throws java.rmi.RemoteException;


}
