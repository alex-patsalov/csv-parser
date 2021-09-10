package app;

public class Employer {

  private String id;
  private String name;
  private String surname;
  private String department_id;

  public Employer(String id, String name, String surname, String department_id) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.department_id = department_id;
  }

  public Employer() {

  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getDepartment_id() {
    return department_id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setDepartment_id(String department_id) {
    this.department_id = department_id;
  }

  @Override
  public String toString() {
    return String.format("Employer (id:%s): name: %s, surname: %s, department: %s ", id, name, surname, department_id);
  }
}
