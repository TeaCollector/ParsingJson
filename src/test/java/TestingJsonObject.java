import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.coffee.http.entity.Car;
import ru.coffee.http.entity.Cat;
import ru.coffee.http.entity.Employee;
import ru.coffee.http.entity.Order;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class TestingJsonObject {
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @Test
    @SneakyThrows
    void testingObject() {      // Переводим объект в JSON формат
        Employee employee = new Employee("Sasha", "Sergeev", 31, 30000);

        String objectToString = objectMapper.writeValueAsString(employee);
        System.out.println(objectToString);
    }

    @Test
    @SneakyThrows
    void jsonStringToPojo() {               // переводим JSON в объект
        String employeeJson = "{\"firstName\":\"Sasha\",\"lastName\":\"Sergeev\"" +
                ",\"age\":31,\"salary\":30000}";

        Employee employee = objectMapper.readValue(employeeJson, Employee.class);
        System.out.println(employee);

        Assertions.assertEquals(employee.getFirstName(), "Sasha");

    }

    @Test
    @SneakyThrows
    void jsonFileToPojo() {
        File file = new File("jsonexample/employee.json");
        Employee employee = objectMapper.readValue(file, Employee.class);

        Assertions.assertEquals(employee.getFirstName(), "Sasha");
        Assertions.assertEquals(employee.getLastName(), "Sergeev");
        Assertions.assertEquals(employee.getAge(), 31);

        System.out.println(employee);
    }

    @Test
    @SneakyThrows
    void byteArrayToPojo() {
        String employeeJson = "{\"firstName\":\"Sasha\",\"lastName\":\"Sergeev\"" +
                ",\"age\":31,\"salary\":30000}";

        Employee employee = objectMapper.readValue(employeeJson.getBytes(), Employee.class);

        System.out.println(employee);
        Assertions.assertEquals(employee.getAge(), 31);
    }

    @Test
    @SneakyThrows
    void fileToListObject() {
        File file = new File("jsonexample/employeeList.json");

        List<Employee> employees = objectMapper.readValue(file, new TypeReference<>() {
        });

        Assertions.assertEquals(employees.size(), 2);
        Assertions.assertEquals(employees.get(0).getAge(), 33);
        Assertions.assertEquals(employees.get(1).getAge(), 44);

        for (Employee empl :
                employees) {
            System.out.println(empl);
        }
    }

    @Test
    @SneakyThrows
    void fileToMap() {
        File file = new File("jsonexample/employee.json");

        Map<String, Object> objectMap = objectMapper.readValue(file, new TypeReference<>() {
        });

        for (Map.Entry<String, Object> emp :
                objectMap.entrySet()) {
            System.out.println(emp.getKey() + ": " + emp.getValue());

        }
    }

    @Test
    @SneakyThrows
    void fileToPojoWithUnknownProperties() {
        File file = new File("jsonexample/employeeWithUnknownProperties.json");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Employee employee = objectMapper.readValue(file, Employee.class);

        System.out.println(employee);
    }

    @Test
    @SneakyThrows
    void orderToJson() {
        Order order = new Order(1, LocalDate.of(2023,8,25));

        String json = objectMapper.writeValueAsString(order);

        System.out.println(json);
    }

    @Test
    @SneakyThrows
    void fileToOrder() {
        File file = new File("jsonexample/order.json");
        Order order = objectMapper.readValue(file, Order.class);

        Assertions.assertEquals(order.getDate().getMonthValue(), 4);

        System.out.println(order);
    }

    @Test
    @SneakyThrows
    void fileToCar() {
        File file = new File("jsonexample/car.json");
        Car car = objectMapper.readValue(file, Car.class);

        System.out.println(car);
    }

    @Test
    @SneakyThrows
    void unrecognizedFieldWithJsonAnySetter() {
        File file = new File("carUnrecognized.json");

        Car car = objectMapper.readValue(file, Car.class);

        for (Map.Entry<String, String> field:
             car.getUndetectedField().entrySet()) {
            System.out.println(field.getKey() + ": " + field.getValue());
        }
    }

    @Test
    @SneakyThrows
    void jsonGetterTest() {
        Cat cat = new Cat("Kitty");
        System.out.println(objectMapper.writeValueAsString(cat));

    }

    @Test
    @SneakyThrows
    void catToJsonWithMap() {
        Cat cat = new Cat("Monica");

        String json = objectMapper.writeValueAsString(cat);

        System.out.println(json);
    }

}
