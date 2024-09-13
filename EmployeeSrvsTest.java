package springbootemployeecrudtest;

import com.example.springbootemployeecrud.entity.Employee;
import com.example.springbootemployeecrud.repository.EmployeeRepository;
import com.example.springbootemployeecrud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.AssertionErrors;


@ExtendWith(MockitoExtension.class)
public class EmployeeSrvsTest {

    @Mock
    private EmployeeRepository employeerepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void createEmployeeServiceTest(){
        Employee emp = new Employee();
        emp.setId(2L);
        emp.setName("Arjun Roy");
        emp.setEmail("aroy@exp.com");
        emp.setDepartment("IT");
        Mockito.when(employeerepository.save(Mockito.any(Employee.class))).thenReturn(emp);
        Employee emp1 = employeeService.createEmployee(emp);
        AssertionErrors.assertEquals("Ok",emp1,emp);
    }


}
