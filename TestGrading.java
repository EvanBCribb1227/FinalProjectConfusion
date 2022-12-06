package Grading;
import java.io.*;
import java.util.*;
public class TestGrading {
	public static void main (String[] args) throws FileNotFoundException {
		String solutionFilePath = "/Users/evanbrookscribb/eclipse-workspace/CSC1850/src/Grading/Solutions.txt";
		String studentExamAnswerDirectory = "/Users/evanbrookscribb/eclipse-workplaceCSC1850/src/Grading/StudentAnswers";
		
		Teacher Grades = new Teacher(solutionFilePath, studentExamAnswerDirectory);
		
		System.out.println(Grades.gradingAllStudents());
		
	}
}
