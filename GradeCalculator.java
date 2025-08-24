import java.util.Scanner;

public class GradeCalculator {

    // Function to get letter grade
    public static String getLetterGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 85) return "A";
        else if (percentage >= 80) return "B+";
        else if (percentage >= 75) return "B";
        else if (percentage >= 70) return "C+";
        else if (percentage >= 65) return "C";
        else if (percentage >= 60) return "D+";
        else if (percentage >= 55) return "D";
        else if (percentage >= 50) return "E+";
        else if (percentage >= 40) return "E";
        else return "F";
    }

    // Function to convert percentage to GPA (out of 4.0)
    public static double getGPA(double percentage) {
        if (percentage >= 90) return 4.0;   // A+
        else if (percentage >= 85) return 3.7; // A
        else if (percentage >= 80) return 3.3; // B+
        else if (percentage >= 75) return 3.0; // B
        else if (percentage >= 70) return 2.7; // C+
        else if (percentage >= 65) return 2.3; // C
        else if (percentage >= 60) return 2.0; // D+
        else if (percentage >= 55) return 1.7; // D
        else if (percentage >= 50) return 1.3; // E+
        else if (percentage >= 40) return 1.0; // E
        else return 0.0; // F
    }

    public static void main(String[] args) {
        // Weight distribution
        try (Scanner sc = new Scanner(System.in)) {
            // Weight distribution
            double midtermWeight = 0.30;     // 30%
            double assignmentWeight = 0.20;  // 20%
            double classPerfWeight = 0.10;   // 10%
            double finalExamWeight = 0.40;   // 40%
            
            // Take input with obtained + total
            System.out.print("Enter Midterm Marks (obtained / total): ");
            double midtermObt = sc.nextDouble();
            double midtermTotal = sc.nextDouble();
            
            System.out.print("Enter Assignment Marks (obtained / total): ");
            double assignmentObt = sc.nextDouble();
            double assignmentTotal = sc.nextDouble();
            
            System.out.print("Enter Class Performance Marks (obtained / total): ");
            double classPerfObt = sc.nextDouble();
            double classPerfTotal = sc.nextDouble();
            
            System.out.print("Enter Final Exam Marks (obtained / total): ");
            double finalExamObt = sc.nextDouble();
            double finalExamTotal = sc.nextDouble();
            
            // Calculate weighted percentage
            double midtermPerc = (midtermObt / midtermTotal) * 100;
            double assignmentPerc = (assignmentObt / assignmentTotal) * 100;
            double classPerfPerc = (classPerfObt / classPerfTotal) * 100;
            double finalExamPerc = (finalExamObt / finalExamTotal) * 100;
            
            double percentage = (midtermPerc * midtermWeight) +
                    (assignmentPerc * assignmentWeight) +
                    (classPerfPerc * classPerfWeight) +
                    (finalExamPerc * finalExamWeight);
            
            // Results
            String grade = getLetterGrade(percentage);
            double gpa = getGPA(percentage);
            
            System.out.println("\n===== Final Result =====");
            System.out.println("Overall Percentage: " + String.format("%.2f", percentage) + "%");
            System.out.println("Letter Grade: " + grade);
            System.out.println("GPA: " + gpa);
        } // 30%
    }
}
