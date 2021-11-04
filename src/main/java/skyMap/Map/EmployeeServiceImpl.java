package skyMap.Map;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> empMap = new HashMap<>();

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee newEmp = new Employee(lastName, firstName);
        empMap.put(lastName + " " + firstName, newEmp);
        return empMap.get(lastName + " " + firstName);
    }

        @Override
        public Employee deleteEmployee (String lastName, String firstName) {
            Employee delEmp = new Employee(lastName, firstName);
            if (empMap.containsKey(lastName + " " + firstName)) {
                empMap.remove(lastName + " " + firstName);
                return delEmp;
            }
            throw new EmpNotFoundException();
        }

        @Override
        public Employee findEmployee (String lastName, String firstName) {
            if (empMap.containsKey(lastName + " " + firstName)) {
                return empMap.get(lastName + " " + firstName);
            }
            throw new EmpNotFoundException();
        }
    }
