package Grading;
import java.util.*;
import java.io.*;
public class Teacher extends ArrayList<Exam> {
	//define data fields
	private String solutionFilePath;
	private String studentExamAnswerDirectory;
	private ArrayList<String> solutionList;
	
	//define constructors
	public Teacher (String solutionFilePath, String studentExamAnswerDirectory) throws FileNotFoundException {
		this.solutionFilePath = solutionFilePath;
		this.studentExamAnswerDirectory = studentExamAnswerDirectory;
		this.solutionList = readDataFromFile(solutionFilePath);
	}

	//define methods
	public String getSolutionFilePath() {
		return solutionFilePath;
	}

	public void setSolutionFilePath(String solutionFilePath) {
		this.solutionFilePath = solutionFilePath;
	}

	public String getStudentExamAnswerDirectory() {
		return studentExamAnswerDirectory;
	}

	public void setStudentExamAnswerDirectory(String studentExamAnswerDirectory) {
		this.studentExamAnswerDirectory = studentExamAnswerDirectory;
	}

	public ArrayList<String> getSolutionList() {
		return solutionList;
	}

	public void setSolutionList(ArrayList<String> solutionList) {
		this.solutionList = solutionList;
	}
	
	public ArrayList<String> readDataFromFile(String dataFilePath) throws FileNotFoundException {
		ArrayList<String> answerList = new ArrayList<String>();
		File fileData = new File(dataFilePath);
		Scanner read = new Scanner(fileData);
		try {
			while (read.hasNextLine()) {
				answerList.add(read.nextLine());
			}
		} catch (Exception e) {}
		read.close();
		return answerList;
	}
	
	public ArrayList<Integer> gradingOneExam(String studentAnswerFilePath) {
		ArrayList<Integer> gradedExam = new ArrayList<Integer>();
		
		File SolutionFile = new File(solutionFilePath);
		String[] SolutionStrings = SolutionFile.list();
		
		File StudentExamAnswers = new File(studentAnswerFilePath);
		String[] Answerstrings = StudentExamAnswers.list();
		
		for (int i = 0; i < Answerstrings.length; i++) {
			if (SolutionStrings[i] == (Answerstrings[i])) {
				gradedExam.add(1);
			} else {
				gradedExam.add(0);
			}	
		}
		return gradedExam;
	}
	
	public ArrayList<Exam> gradingAllStudents() {
		ArrayList<Exam> studentAnswerFiles = new ArrayList<Exam>();
		File examFiles = new File(studentExamAnswerDirectory);
		String[] StudentExams = examFiles.list();
		for (int i = 0; i <= StudentExams.length; i++) {
			ArrayList<Integer> AnswerList = gradingOneExam(StudentExams[i]);
			String studentToken = StudentExams[i];
			String[] TokenDescription = studentToken.split("[()]");
			String studentName = TokenDescription[0];
			String courseName = TokenDescription[1];
			Exam studentExam = new Exam(studentName, courseName, AnswerList);
			studentAnswerFiles.add(studentExam);
		} 
		return studentAnswerFiles;
	}
}