package studentreportcardsystem;

import java.util.Scanner;

public class Main {



		/**
		 * Student Report Card System
		 * -----------------------------------------
		 * A simple console app that lets a user generate a report card
		 * for a student by entering subject scores.
		 *
		 * Demonstrates:
		 *  - Ternary statements
		 *  - For loops
		 *  - While loops
		 *  - Do-while loops
		 */
		public class StudentReportCardSystem {

		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        int menuChoice;

		        // ---- DO-WHILE LOOP ----
		        // Shows the main menu at least once, and keeps repeating until the user exits.
		        do {
		            System.out.println("\n===== STUDENT REPORT CARD SYSTEM =====");
		            System.out.println("1. Generate Report Card");
		            System.out.println("2. Exit");
		            System.out.print("Enter your choice: ");
		            menuChoice = readValidInt(sc);

		            switch (menuChoice) {
		                case 1:
		                    generateReportCard(sc);
		                    break;
		                case 2:
		                    System.out.println("Thank you for using the system. Goodbye!");
		                    break;
		                default:
		                    System.out.println("Invalid option. Please choose 1 or 2.");
		            }

		        } while (menuChoice != 2);

		        sc.close();
		    }

		    /**
		     * Reads an integer from the user, re-prompting if the input is not a valid number.
		     * ---- WHILE LOOP ----
		     */
		    private static int readValidInt(Scanner sc) {
		        while (!sc.hasNextInt()) {
		            System.out.print("Invalid input, please enter a number: ");
		            sc.next();
		        }
		        return sc.nextInt();
		    }

		    private static void generateReportCard(Scanner sc) {
		        sc.nextLine(); // clear the leftover newline after nextInt()
		        System.out.print("\nEnter student name: ");
		        String studentName = sc.nextLine();

		        System.out.print("Enter number of subjects (1-10): ");
		        int numSubjects = readValidInt(sc);

		        // ---- WHILE LOOP ----
		        // Keep asking until the number of subjects is within a sensible range
		        while (numSubjects <= 0 || numSubjects > 10) {
		            System.out.print("Please enter a number between 1 and 10: ");
		            numSubjects = readValidInt(sc);
		        }

		        String[] subjectNames = new String[numSubjects];
		        int[] scores = new int[numSubjects];
		        int total = 0;

		        // ---- FOR LOOP ----
		        // Loops through each subject to collect its name and score
		        for (int i = 0; i < numSubjects; i++) {
		            sc.nextLine(); // flush leftover newline
		            System.out.print("Enter name of subject " + (i + 1) + ": ");
		            subjectNames[i] = sc.nextLine();

		            System.out.print("Enter score for " + subjectNames[i] + " (0-100): ");
		            int score = readValidInt(sc);

		            // ---- WHILE LOOP ----
		            // Keep asking until the score entered is valid
		            while (score < 0 || score > 100) {
		                System.out.print("Score must be between 0 and 100. Try again: ");
		                score = readValidInt(sc);
		            }

		            scores[i] = score;
		            total += score;
		        }

		        double average = (double) total / numSubjects;

		        System.out.println("\n----------- REPORT CARD -----------");
		        System.out.println("Student: " + studentName);
		        System.out.println("------------------------------------");

		        // ---- FOR LOOP + TERNARY ----
		        // Prints each subject's score with a pass/fail result decided by a ternary operator
		        for (int i = 0; i < numSubjects; i++) {
		            String result = (scores[i] >= 50) ? "PASS" : "FAIL";
		            System.out.printf("%-15s : %-3d  [%s]%n", subjectNames[i], scores[i], result);
		        }

		        System.out.println("------------------------------------");
		        System.out.printf("Average Score : %.2f%n", average);

		        // ---- TERNARY OPERATOR (nested) ----
		        // Determines the overall letter grade based on the average score
		        String overallGrade = (average >= 80) ? "A"
		                             : (average >= 70) ? "B"
		                             : (average >= 60) ? "C"
		                             : (average >= 50) ? "D"
		                             : "F";

		        // ---- TERNARY OPERATOR ----
		        // Determines the final pass/fail remark
		        String remark = (average >= 50) ? "PASSED" : "FAILED";

		        System.out.println("Overall Grade : " + overallGrade);
		        System.out.println("Final Remark  : " + remark);
		        System.out.println("------------------------------------");
		    }
		}

	}


