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
            double midtermWeight = 0.30;
            double assignmentWeight = 0.20;
            double classPerfWeight = 0.10;
            double finalExamWeight = 0.40;
            
            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            
            double totalPercentage = 0;
            double totalGPA = 0;
            
            for (int subj = 1; subj <= n; subj++) {
                System.out.print("\nEnter name of Subject " + subj + ": ");
                String subjectName = sc.nextLine();
                
                // Input marks for each component
                System.out.print("Enter Midterm Marks (obtained / total): ");
                double midObt = sc.nextDouble();
                double midTotal = sc.nextDouble();
                
                System.out.print("Enter Assignment Marks (obtained / total): ");
                double assignObt = sc.nextDouble();
                double assignTotal = sc.nextDouble();
                
                System.out.print("Enter Class Performance Marks (obtained / total): ");
                double cpObt = sc.nextDouble();
                double cpTotal = sc.nextDouble();
                
                System.out.print("Enter Final Exam Marks (obtained / total): ");
                double finalObt = sc.nextDouble();
                double finalTotal = sc.nextDouble();
                
                sc.nextLine(); // consume newline for next subject
                
                // Calculate percentages
                double midPerc = (midObt / midTotal) * 100;
                double assignPerc = (assignObt / assignTotal) * 100;
                double cpPerc = (cpObt / cpTotal) * 100;
                double finalPerc = (finalObt / finalTotal) * 100;
                
                // Weighted percentage
                double percentage = (midPerc * midtermWeight) +
                        (assignPerc * assignmentWeight) +
                        (cpPerc * classPerfWeight) +
                        (finalPerc * finalExamWeight);
                
                String grade = getLetterGrade(percentage);
                double gpa = getGPA(percentage);
                
                // Print subject result
                System.out.println("\nResult for " + subjectName + ":");
                System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
                System.out.println("Letter Grade: " + grade);
                System.out.println("GPA: " + gpa);
                
                // Add to overall totals
                totalPercentage += percentage;
                totalGPA += gpa;
            }
            
            // Final overall result
            double avgPercentage = totalPercentage / n;
            double avgGPA = totalGPA / n;
            
            System.out.println("\n===== Overall Result =====");
            System.out.println("Average Percentage: " + String.format("%.2f", avgPercentage) + "%");
            System.out.println("Average GPA: " + String.format("%.2f", avgGPA));
            System.out.println("Overall Letter Grade: " + getLetterGrade(avgPercentage));
        }
    }
}
