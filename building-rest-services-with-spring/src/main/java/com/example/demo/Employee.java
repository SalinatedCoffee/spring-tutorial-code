package com.example.demo;

import java.util.Objects;

// javax renamed to jakarta
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// JPA annotation
// @Entity means prep this object for storage in data store
@Entity
class Employee {
  // JPA annotations
  // @id means use var as primary key
  // @GeneratedValue specifies how pk is generated
  // Long wraps a primitive long into an object
  // https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/jpa-primary-key.html
  private @Id @GeneratedValue Long id;
  private String name;
  private String role;

  Employee() {}

  Employee(String name, String role) {
    this.name = name;
    this.role = role;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getRole() {
    return this.role;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    // Same object
    if (this == o)
      return true;
    // Object not instance of Employee
    if (!(o instanceof Employee))
      return false;
    // Cast object to Employee
    Employee employee = (Employee) o;
    // Return true if all variables match
    return Objects.equals(this.id, employee.id) &&
           Objects.equals(this.name, employee.name) &&
           Objects.equals(this.role, employee.role);
  }

  // Override default methods
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.role);
  }

  @Override
  public String toString() {
    return "Employee{id=" + this.id + ", name='" + this.name +"', role='" + this.role + "'}";
  }
}
