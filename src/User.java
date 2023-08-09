public class User {
    // Private Attributes ---------------------------------------------------------------
    private String name;
    private String surname;
    private String email;
    private String password;
    private String id;
    private boolean member = false;

    // Constructors ----------------------------------------------------------------------
    public User(String name, String surname, String email, String password, String id) {
        // User who's already a member
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.id = id;
        this.member = true;
    }

    public User(String name, String surname) {
        // User who's yet to be registered
        this.name = name;
        this.surname = surname;
        this.email = "none";
        this.password = "none";
        this.id = "none";
        this.member = false;
    }

    // Getters --------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        if (this.getMember()) {
            return email;
        }
        else {
            return "none";
        }
    }

    public String getPassword() {
        if (this.getMember()) {
            return password;
        }
        else {
            return "none";
        }
    }

    public String getId() {
        if (this.getMember()) {
            return id;
        }
        else {
            return "none";
        }
    }

    public boolean getMember() {
        return member;
    }

    // Setters --------------------------------------------------------------------------
    public void setName(String newName) {
        this.name = newName;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public void setMember(boolean newStatus) {
        this.member = newStatus;
    }

    // Private Methods ------------------------------------------------------------------
}
