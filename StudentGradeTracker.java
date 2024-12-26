import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Tracker!");
        boolean moreGrades = true;

        while (moreGrades) {
            System.out.print("Enter a student's grade (or type 'done' to finish): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                moreGrades = false;
            } else {
                try {
                    double grade = Double.parseDouble(input);
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                    } else {
                        System.out.println("Please enter a grade between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric grade or 'done'.");
                }
            }
        }

        if (!grades.isEmpty()) {
            double total = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                total += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = total / grades.size();

            System.out.println("\nGrade Summary:");
            System.out.println("Total Students: " + grades.size());
            System.out.printf("Average Grade: %.2f%n", average);
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
        } else {
            System.out.println("No grades were entered.");
        }

        scanner.close();
    }
}