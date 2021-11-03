package SkyMap.Map;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> empMap = new HashMap<>();

    @Override
    public Employee addEmployee(String lastName, String firstName) throws EmpIntServErrException {
        Employee newEmp = new Employee(lastName, firstName);
        if (empMap.containsKey(lastName + " " + firstName)) {
            //throw new EmpIntServErrException();
            deleteEmployee(lastName, firstName);
        }
        empMap.put(lastName + " " + firstName, newEmp);
        return newEmp;
    }

        @Override
        public Employee deleteEmployee (String lastName, String firstName) throws EmpNotFoundException {
            Employee delEmp = new Employee(lastName, firstName);
            if (empMap.containsKey(lastName + " " + firstName)) {
                empMap.remove(lastName + " " + firstName);
            } else {
                throw new EmpNotFoundException();
            }
            return delEmp;
        }

        @Override
        public Employee findEmployee (String lastName, String firstName) throws EmpNotFoundException {
            Employee findEmp = new Employee(lastName, firstName);
            if (empMap.containsKey(lastName + " " + firstName)) {
                return findEmp;
            } else {
                throw new EmpNotFoundException();
            }
        }
    }
