import java.util.Scanner;
import java.util.List;
public class StudentController {
//    private Student student=new Student();
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Scanner sc = new Scanner(System.in);
        int exit = 1;
        System.out.println("==== Student Management System ====");
        while (exit == 1) {
            new ConsoleUI().consoleUI();
            System.out.println("Enter your choice");
            int aboveChoice = sc.nextInt();
            sc.nextLine();
            switch (aboveChoice) {
                //Aad Students
                case 1:
                    int id;
                    try {
                        System.out.println("Enter Student Id");
                        id = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter Student Name");
                        String name = sc.nextLine();

                        Response response=studentService.addStudent(id, name);
                        if(response.isSuccess()){
                            System.out.println(response.getMessage());
                        }else{
                            System.out.println("Error: "+response.getMessage());
                        }
                    } catch (Exception e) {
                        sc.nextLine();
                        System.out.println("Invalid Input.");
                    }

                    break;
                //Search Student
                case 2:
                    List<Student> studentList = studentService.viewStudent();
                    if (studentList.isEmpty()) {
                        System.out.println("No student found");
                    } else {
                            for (Student s : studentList) {
                                System.out.println("Student " + s.getName() + " id is " + s.getId());
                            }
                        }
                    break;
                //Search Student By id
                case 3:
                   try{
                       System.out.print("Enter Student ID: ");
                       int newId = sc.nextInt();
                       sc.nextLine();// clear Buffer
                       Response response=studentService.getStudentById(newId);
                       if(response.isSuccess()){
                           System.out.println(response.getMessage());
                       }else{
                           System.out.println("Error: " + response.getMessage());                 }
                   }
                   catch(Exception e){
                       System.out.println("Invalid input. Enter a valid number");
                       sc.nextLine();
                   }

                    break;
                //Delete Student
                case 4:
                    try{
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        Response response=studentService.deleteStudentById(deleteId);
                        if(response.isSuccess()){
                            System.out.println(response.getMessage());
                        }else{
                            System.out.println("Error: "+response.getMessage());
                        }
                    }catch(Exception e){
                        System.out.println("Invalid Input. Enter Valid Input");
                        sc.nextLine();
                    }
                    break;
                //Update Student
                case 5:
                    try{
                        System.out.print("Enter Student ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();

                        Response response=studentService.updateStudent(updateId, newName);
                        if( response.isSuccess()){
                            System.out.println(response.getMessage());
                        }
                        else System.out.println("Error: "+response.getMessage());
                    }
                    catch(Exception e){
                        System.out.println("Invalid Input. Enter correct data");
                        sc.nextLine();
                    }
                    break;
                case 0:
                    exit=0;
            }
        }
        sc.close();
    }
}
