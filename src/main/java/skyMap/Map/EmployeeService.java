package skyMap.Map;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName);
    Employee deleteEmployee(String lastName, String firstName);
    Employee findEmployee(String lastName, String firstName);
}
