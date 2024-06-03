package Algorithm1;

import java.util.Scanner;

public class baekjoon_25206_정훈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double totalPoints = 0.0;
        double totalCredits = 0.0;
        
        for (int i = 0; i < 20; i++) {
            String courseName = sc.next();
            double credit = sc.nextDouble();
            String grade = sc.next();
            
            if (!grade.equals("P")) {
                double gradePoint = 0.0;
                
                switch (grade) {
                    case "A+":
                        gradePoint = 4.5;
                        break;
                    case "A0":
                        gradePoint = 4.0;
                        break;
                    case "B+":
                        gradePoint = 3.5;
                        break;
                    case "B0":
                        gradePoint = 3.0;
                        break;
                    case "C+":
                        gradePoint = 2.5;
                        break;
                    case "C0":
                        gradePoint = 2.0;
                        break;
                    case "D+":
                        gradePoint = 1.5;
                        break;
                    case "D0":
                        gradePoint = 1.0;
                        break;
                    case "F":
                        gradePoint = 0.0;
                        break;
                }
                
                totalPoints += credit * gradePoint;
                totalCredits += credit;
            }
        }
        
        sc.close();
        
        double gpa = totalPoints / totalCredits;
        System.out.printf("%.4f\n", gpa);
    }
}
