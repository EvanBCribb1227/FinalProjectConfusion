package Grading;
import java.util.*;
import java.io.*;

public class Exam {
	//define data fields
	private String courseName;
	private String studentName;
	private ArrayList<Integer> ExamQuestionScoreList;
	
	//define constructors
	public Exam(String courseName) {}
	
	public Exam (String studentName, String courseName, ArrayList<Integer> ExamQuestionScoreList) {
		this.studentName = studentName;
		this.courseName = courseName;
		this.ExamQuestionScoreList = ExamQuestionScoreList;
	}

	//define methods
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public ArrayList<Integer> getExamQuestionScoreList() {
		return ExamQuestionScoreList;
	}

	public void setExamQuestionScoreList(ArrayList<Integer> examQuestionScoreList) {
		ExamQuestionScoreList = examQuestionScoreList;
	}
	
	public int getExamScore() {
		int ExamScore = 0;
		
		return ExamScore;
	}
}
