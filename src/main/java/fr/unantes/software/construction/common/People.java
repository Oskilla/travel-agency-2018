package fr.unantes.software.construction.common;

/**
 * Generic people
 */
public abstract class People {
    protected String name;
    protected String birthplace;
    protected String role;

    public People(String name, String birthplace, String role) {
        this.name = name;
        this.birthplace = birthplace;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
