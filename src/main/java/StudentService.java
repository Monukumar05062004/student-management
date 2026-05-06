import java.util.List;
public class StudentService {
    private StudentRepository studentRepository=new StudentRepository();

    //View Student
     public List<Student> viewStudent(){
       return studentRepository.getAllStudent();
    }
    //Delete student by id
     public Response deleteStudentById(int id) {
         if(id<=0){
             return new Response("Invalid ID. Must be greater than 0",false);
         }
         Student student=studentRepository.deleteById(id);
         if(student!=null){
             return new Response("Student "+student.getName()+" is deleted successfully",true);
         }
        else{
             return new Response("Student not found",false);
         }
     }

    // Get Student By id
     public Response  getStudentById(int id){
         if(id<=0){
             return new Response("Invalid id. Must be greater than 0",false);
         }
         Student student=studentRepository.getStudent(id);
         if(student!=null){
             return new Response("Student name is: "+student.getName()+" id is "+student.getId(),true);
         }
         else {
             return new Response("Student not found with this id " + id, false);
         }
    }
    // Update Student
     public Response updateStudent(int id,String name){
         if(id<=0){
             return new Response("Invalid ID. Must be greater than 0",false);
         }
         Student student=studentRepository.update(id,name);
         if(student!=null){
             return new Response("Student " + student.getName() + " (ID: " + id + ") updated successfully",true);
         }else{
             return new Response("Student not found ",false);
         }
    }
    //Add Student
    public Response addStudent(int id,String name) {
         // input validation
         if(id<=0){
             return new Response("Invalid ID. Must be greater than 0 ",false);
         }
         if(studentRepository.getStudent(id)==null){
             studentRepository.add(id,new Student(name,id));
             return new Response("Student added successfully ",true);
         }
             return new Response("Student already exists ",false);
    }
}
