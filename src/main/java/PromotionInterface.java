public interface PromotionInterface extends java.rmi.Remote {

    public void add_student(Student student) throws java.rmi.RemoteException;

    public Student get_student(int studentId) throws java.rmi.RemoteException;

    public double promotion_score() throws java.rmi.RemoteException;


}
