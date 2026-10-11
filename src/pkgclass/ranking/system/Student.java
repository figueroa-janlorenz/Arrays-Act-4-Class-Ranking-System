package pkgclass.ranking.system;

public class Student {
    private String name;
    private int[] quizzes;

    public Student(String name, int[] quizzes) {
        this.name = name;
        this.quizzes = quizzes;
    }

    public double getAverage() {
        if (quizzes == null || quizzes.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < quizzes.length; i++) {
            sum += quizzes[i];
        }
        return (double) sum / quizzes.length;
    }

    public String getName() {
        return name;
    }

    public int[] getQuizzes() {
        return quizzes;
    }
}
