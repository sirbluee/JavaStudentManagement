import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Student {
    int id;
    String name;
    static String gender;
    int age;
    String classroom;
    int[] scores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        Student.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    Student() {
    }

    public Student(int id, String name, String gender, int age, String classroom, int[] scores) {
        this.id = id;
        this.name = name;
        Student.gender = gender;
        this.age = age;
        this.classroom = classroom;
        this.scores = scores;
    }

    static void pressEnterKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ======================== Press Enter to continue ========================");
        scanner.nextLine();
    }

    void outputInformation() {
        System.out.println("---------------------------------");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Gender :" + gender);
        System.out.println("AGE : " + age);
        System.out.println("Classroom : " + classroom);
        System.out.println("SCORE : " + Arrays.toString(scores));
    }

    void inputInformation(Scanner input) {
        boolean isIDValid = false;
        do {
            String stID;
            System.out.print("Enter ID:");
            try {
                stID = input.nextLine();
                id = Integer.parseUnsignedInt(stID);
                isIDValid = true;
            } catch (Exception exception) {
                System.out.println("Invalid ID format!!(ID can be Number only !)");
            }
        } while (!isIDValid);

        boolean isNameValid = false;
        do {
            System.out.print("Enter Name: ");
            String name = input.nextLine();
            if (name.matches("[a-zA-Z ]+")) {
                this.name = name;
                isNameValid = true;
            } else {
                System.out.println("Invalid Name format! Name must contain letters only.");
            }
        } while (!isNameValid);

        boolean isGenderValid = false;
        do {
            System.out.print("Enter Gender: ");
            String gender = input.nextLine();
            if (gender.matches("[a-zA-Z]+")) {
                Student.gender = gender;
                isGenderValid = true;
            } else {
                System.out.println("Invalid Gender format! Gender must contain letters only.");
            }
        } while (!isGenderValid);

        boolean isAGEValid = false;
        do {
            String strAGE;
            System.out.print("Enter AGE:");
            try {
                strAGE = input.nextLine();
                age = Integer.parseUnsignedInt(strAGE);
                isAGEValid = true;
            } catch (Exception exception) {
                System.out.println("Invalid AGE format!!(AGE can be Number only !)");
            }
        } while (!isAGEValid);

        boolean isClassValid = false;
        do {
            System.out.print("Enter Classroom: ");
            String classroom = input.nextLine();
            if (classroom.matches("[a-zA-Z]+")) {
                this.classroom = classroom;
                isClassValid = true;
            } else {
                System.out.println("Invalid Classroom format! Classroom must contain letters only.");
            }
        } while (!isClassValid);

        boolean isSCOREValid = false;
        do {
            String stScore;
            System.out.print("Enter Score:");
            try {
                stScore = input.nextLine();
                scores = new int[]{Integer.parseUnsignedInt(stScore)};
                isSCOREValid = true;
            } catch (Exception exception) {
                System.out.println("Invalid Scores format!!(Score can be Number only !)");
            }
        } while (!isSCOREValid);
    }

    public static class HomeWorkStudent {
        public static void main(String[] args) {
            ArrayList<Student> students = new ArrayList<>();
            Scanner input = new Scanner(System.in);
            int op;
            do {
                System.out.println("--------------- Student Management Console Application -----------------");
                System.out.println("1. Insert Student to System ");
                System.out.println("2. Edit Student Information ");
                System.out.println("3. Search Student Information ");
                System.out.println("4. Delete Student Information ");
                System.out.println("5. Show Student Information ");
                System.out.println("6. Exit ");
                String strOption;
                System.out.print(">>> Choose option from 1 - 6 : ");
                strOption = input.next();
                try {
                    op = Integer.parseUnsignedInt(strOption);
                } catch (Exception ex) {
                    op = 0;
                    System.out.println("Invalid Input !!! Option can be the Number from 1 - 6");pressEnterKey();
                }

                switch (op) {
                    case 1 -> {
                        System.out.println("-------------------- Input Student to List System -----------------");
                        Student newStudent = new Student();
                        newStudent.inputInformation(input);
                        students.add(newStudent);
                        System.out.println("Successfully Added.");
                    }
                    case 2 -> {

                        boolean isOptionValid2 = false;
                        do {
                            System.out.println("-------------------- Edit Student Information ------------------");
                            System.out.println("Please input the ID of the student to edit:");
                            int editID = input.nextInt();
                            boolean isStudentExist = false;
                            for (Student student : students) {
                                if (student.getId() == editID) {
                                    isStudentExist = true;
                                    System.out.println("Please select the information you want to edit:");
                                    System.out.println("1. ID");
                                    System.out.println("2. Name");
                                    System.out.println("3. Gender");
                                    System.out.println("4. Age");
                                    System.out.println("5. Classroom");
                                    System.out.println("6. Scores");
                                    int editop = input.nextInt();
                                    switch (editop) {
                                        case 1 -> {
                                            System.out.println("Please input the new ID:");
                                            int newID = input.nextInt();
                                            student.setId(newID);
                                            input.nextLine();
                                            System.out.println("ID updated successfully!");
                                            pressEnterKey();
                                        }
                                        case 2 -> {
                                            System.out.println("Please input the new name:");
                                            String newName = input.next();
                                            student.setName(String.valueOf(newName));
                                            input.nextLine();
                                            System.out.println("Name updated successfully!");pressEnterKey();
                                        }
                                        case 3 -> {
                                            System.out.println("Please input the new gender (Male/Female)");
                                            String newGender = input.next();
                                            student.setGender(String.valueOf(newGender));
                                            input.nextLine();
                                            System.out.println("Gender updated successfully!");pressEnterKey();
                                        }
                                        case 4 -> {
                                            System.out.println("Please input the new age:");
                                            int newAge = Integer.parseInt(input.next());
                                            student.setAge(newAge);
                                            System.out.println("Age updated successfully!");pressEnterKey();
                                        }
                                        case 5 -> {
                                            System.out.print("Please input the new classroom: ");
                                            String newClassroom = input.next();
                                            student.setClassroom(newClassroom);
                                            input.nextLine();
                                            System.out.println("Classroom updated successfully!");pressEnterKey();
                                        }
                                        case 6 -> {
                                            System.out.println("Please input the new scores in (comma separated):");
                                            String newScoresStr = input.next();
                                            String[] newScoresArr = newScoresStr.split(",");
                                            int[] newScores = new int[newScoresArr.length];
                                            for (int i = 0; i < newScoresArr.length; i++) {
                                                newScores[i] = Integer.parseInt(newScoresArr[i].trim());
                                            }
                                            student.setScores(newScores);
                                            input.nextLine();
                                            System.out.println("Scores updated successfully!");pressEnterKey();
                                        }
                                    }isOptionValid2 = true;
                                }
                            }
                            if (!isStudentExist) {
                                System.out.println("Student with ID " + editID + " does not exist!");
                            }
                        } while (!isOptionValid2);
                    }
                    case 3 -> {
                        int option3;
                        System.out.println("--------------------- Search Student Information --------------------");
                        System.out.println("1. Search By ID");
                        System.out.println("2. Search By NAME");
                        System.out.println("3. Exit.............");
                        System.out.println("Choose a option from 1 - 3 :");
                        option3 = input.nextInt();
                        switch (option3) {
                            case 1 -> {
                                int searchID;
                                boolean isStudentExist2 = false;
                                System.out.println("-------------- Search by ID -----------");
                                System.out.println("Please input ID to Search");
                                searchID = input.nextInt();
                                input.nextLine();
                                for (Student value : students) {
                                    if (searchID == value.id) {
                                        isStudentExist2 = true;
                                        value.outputInformation();
                                    }
                                    if (!isStudentExist2) {
                                        System.out.println("Student 's ID = " + searchID + " doesn't exist !!!");
                                    }
                                }
                            }
                            case 2 -> {
                                String searchNAME;
                                boolean isStudentExist3 = false;
                                System.out.println("------------------------ Search by NAME -------------------------");
                                System.out.println("Please input NAME to Search");
                                searchNAME = input.next();
                                input.nextLine();
                                for (Student student : students) {
                                    if (searchNAME.equals(student.name)) {
                                        isStudentExist3 = true;
                                        student.outputInformation();
                                    }
                                    if (!isStudentExist3) {
                                        System.out.println("Student 's NAME = " + searchNAME + " doesn't exist !!!");
                                    }
                                }
                            }
                            case 3 ->{
                                input.nextLine();
                                System.out.println("Exist...........................................................");
                            }

                        }
                    }
                    case 4 -> {
                        System.out.println("-------------------- Delete Student Information -----------------");
                        System.out.println("Choose the delete option: ");
                        System.out.println("1. Delete by ID");
                        System.out.println("2. Delete by Name");
                        int deleteOption = input.nextInt();
                        input.nextLine();
                        boolean isDeleted = false;
                        switch (deleteOption) {
                            case 1 -> {
                                System.out.print("Enter the ID of the student to delete: ");
                                int deleteID = input.nextInt();
                                input.nextLine();
                                for (Student student : students) {
                                    if (student.getId() == deleteID) {
                                        students.remove(student);
                                        isDeleted = true;
                                        System.out.println("Student information has been successfully deleted from the system.");
                                        break;
                                    }
                                }
                                if (!isDeleted) {
                                    System.out.println("Student information not found in the system.");
                                }
                            }
                            case 2 -> {
                               System.out.print("Enter the name of the student to delete: ");
                                String deleteName = input.nextLine();
                                for (Student student : students) {
                                    if (student.getName().equalsIgnoreCase(deleteName)) {
                                        students.remove(student);
                                        isDeleted = true;
                                        System.out.println("Student information has been successfully deleted from the system.");
                                        break;
                                    }
                                }
                                if (!isDeleted) {
                                    System.out.println("Student information not found in the system.");
                                }
                            }
                        }pressEnterKey();
                    }
                    case 5 -> {
                        System.out.println("----------------------- Show Student Information -----------------------");
                        if (students.size() == 0) {
                            System.out.println("No students found!");
                        } else {
                            for (Student student : students) {
                                student.outputInformation();
                                System.out.println("---------------------------");
                            }
                        }
                    }
                    case 6 -> System.out.println("----------------------- Exist -------------------------");
                }
            } while (op != 6);
        }
    }
}

