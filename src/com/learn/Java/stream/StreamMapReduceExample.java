package com.learn.Java.stream;

import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

public class StreamMapReduceExample {

    private static int nbNoteBooks() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter((student -> student.getGradeLevel() > 3))
                .map(Student::getNoteBooks) // Stream<Integer>
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("number of notebooks: " + nbNoteBooks());
    }
}
