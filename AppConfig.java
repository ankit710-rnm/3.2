// AppConfig.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public StudentService studentService() {
        return new StudentService(studentRepository());
    }

    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepository();
    }
}

// StudentService.java
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void showStudent() {
        repo.printStudent();
    }
}

// StudentRepository.java
public class StudentRepository {
    public void printStudent() {
        System.out.println("Dependency Injection Example: Student Repository Logic");
    }
}

// Main.java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService service = context.getBean(StudentService.class);
        service.showStudent();
    }
}
