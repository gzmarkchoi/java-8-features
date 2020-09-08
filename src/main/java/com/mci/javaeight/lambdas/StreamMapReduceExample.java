package com.mci.javaeight.lambdas;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

public class StreamMapReduceExample {
    private static int noOfNoteBooks() {
        int noOfNoteBooks =  StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter(student -> student.getGradeLevel() >= 3)
                .map(Student::getNoteBooks) // Stream<Integer>
                .reduce(0, Integer::sum);

        return noOfNoteBooks;
    }

    public static void main(String[] args) {
        System.out.println("Number of note books: " + noOfNoteBooks());
    }
}
