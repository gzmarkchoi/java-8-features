package com.mci.javaeight.stream;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

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
