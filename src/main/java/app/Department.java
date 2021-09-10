package app;

public class Department {

  private String id;
  private String name;

  public Department(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Department(){

  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("Department (id: %s): name: %s", id, name);
  }
}
