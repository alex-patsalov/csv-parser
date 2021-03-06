package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

  public static <T> List<T> readFile(String fileName, Class<T> type) throws Exception {
    try(BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
      List<T> array = new ArrayList<>();
      String oneLine;
      while ((oneLine = bf.readLine()) != null) {
        String[] line = oneLine.split(";");
        Constructor<?> constructorWithParams = type.getDeclaredConstructors()[0];
        if (constructorWithParams.getParameterCount() == line.length) {
          T entity = (T) constructorWithParams.newInstance(line);
          array.add(entity);
        }
      }
      array.remove(0);
      return array;
    }
  }

  public static List<Employer> join(List<Employer> employers, List<Department> departments) {
    return departments.stream()
            .flatMap(d ->
                    employers.stream()
                    .peek(e -> {
      if (e.getDepartment_id().equals(d.getId())) e.setDepartment_id(d.getName());
    }))
            .distinct()
            .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    try{
      List<Employer> allEmployers = readFile("employers.csv", Employer.class);
      List<Department> departments = readFile("departments.csv", Department.class);
      List<Employer> joined = join(allEmployers, departments);
      joined.forEach(System.out::println);
    } catch (Exception e){
      System.out.printf("File is broken or not found, %s \n", e);
    }
  }

}
