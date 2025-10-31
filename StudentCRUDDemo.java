public class StudentCRUDDemo {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s = new Student();
        s.setName("Amit"); s.setAge(22);
        dao.saveStudent(s); // create

        Student fetched = dao.getStudent(s.getId());
        fetched.setAge(23);
        dao.updateStudent(fetched); // update

        dao.listStudents().forEach(student -> System.out.println(student.getName()));

        dao.deleteStudent(fetched.getId()); // delete
    }
}
