package pkgclass.ranking.system;

public class ClassRankingSystem {

    public static void main(String[] args) {
        String[] names = {"Marco", "Lira", "Esther", "Althea", "Lorenz"};
        int[][] quizData = {
            {90, 85, 88, 92},
            {95, 90, 93, 92},
            {80, 85, 82, 83},
            {95, 90, 93, 92},
            {88, 86, 90, 84}
        };

        Student[] students = new Student[names.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(names[i], quizData[i]);
        }

        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getAverage() < students[j + 1].getAverage()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("CLASS LEADERBOARD");
        System.out.println("-------------------------------------");
        System.out.printf("%-8s %-12s %-10s%n", "Rank", "Name", "Average");
        System.out.println("-------------------------------------");

        int currentRank = 1;
        double epsilon = 0.00001;

        for (int i = 0; i < students.length; i++) {
            if (i > 0 && Math.abs(students[i].getAverage() - students[i - 1].getAverage()) > epsilon) {
                currentRank = i + 1;
            }
            System.out.printf("%-8d %-12s %-10.2f%n",
                    currentRank, students[i].getName(), students[i].getAverage());
        }
        System.out.println("-------------------------------------");

        String searchName = "Morgan";
        int studentRank = findRank(students, searchName);

        if (studentRank != -1) {
            System.out.println(searchName + "'s rank is: " + studentRank);
        } else {
            System.out.println(searchName + " was not found.");
        }
    }

    public static int findRank(Student[] students, String searchName) {
        int currentRank = 1;
        double epsilon = 0.00001;
        
        for (int i = 0; i < students.length; i++) {
            if (i > 0 && Math.abs(students[i].getAverage() - students[i - 1].getAverage()) > epsilon) {
                currentRank = i + 1;
            }
            if (students[i].getName().equalsIgnoreCase(searchName)) {
                return currentRank;
            }
        }
        return -1;
    }
}
