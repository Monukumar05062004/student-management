import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    private Map<Integer,Student> studentList=new LinkedHashMap<>();

    public List<Student> getAllStudent() {
        return  new ArrayList<>(studentList.values());
    }


    public Student getStudent(int id) {
        return studentList.get(id);
    }
    public Student deleteById(int id ){
        return studentList.remove(id);
    }

    public Student update(int id,String name) {
        if(studentList.containsKey(id)){
            studentList.get(id).setName(name);
            return studentList.get(id);
        }
        return null;
    }

    public void add(int id,Student student) {
       studentList.put(id,student);
    }

}
