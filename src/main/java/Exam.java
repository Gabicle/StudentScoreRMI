import java.io.Serializable;

public class Exam implements Serializable {
    private String exam_name;
    private double exam_score;
    private double coefficient;


    public Exam(String exam_name, double exam_score, double coefficient) {
        this.exam_name = exam_name;
        this.exam_score = exam_score;
        this.coefficient = coefficient;
    }




    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public double getExam_score() {
        return exam_score;
    }

    public void setExam_score(double exam_score) {
        this.exam_score = exam_score;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "exam_name='" + exam_name + '\'' +
                ", exam_score=" + exam_score +
                ", coefficient=" + coefficient +
                '}';
    }
}
