// 1. Simple Student Management System:
// Create a Student class with attributes like name, roll number, and marks.
// Implement methods to calculate the average marks, display student details, and check if the student passed or failed (based on a minimum passing percentage).
// Create an array of Student objects to represent a class and calculate the class average.
class Student {
    String name;
    int rollNumber;
    int marks;
    static double passingMarks = 50.00;
    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    static double averageMarks(Student[] students, int numSubjects) {
        double totalMarks = 0;
        for (Student s : students) {
            totalMarks += s.marks;
        }
        return totalMarks / (students.length * numSubjects);
    }
    void displayStudentDetails() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Student Roll Number: " + this.rollNumber);
        System.out.println("Student Marks: " + this.marks);
    }
    void passFail() {
        if (this.marks >= passingMarks) {
            System.out.println(this.name + " has passed.");
        } else {
            System.out.println(this.name + " has failed.");
        }
    }
    public static void main(String[] args) {
        Student[] students = {
            new Student("Rauf", 32, 49),
            new Student("Ahsan", 45, 55),
            new Student("M: Umar ", 66, 60)
        };

        for (Student s : students) {
            s.displayStudentDetails();
            s.passFail();
            System.out.println();
        }

        double classAverage = averageMarks(students, 1);
        System.out.println("Class Average Marks: " + classAverage);
    }
}
