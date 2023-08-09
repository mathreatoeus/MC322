public class Book {
    // Private Attributes ---------------------------------------------------------------
    private String id;
    private String title;
    private String authorName;
    private String authorSurname;   // Author's name was separated to facilitate user input.
    private String edition;
    private String section;
    private boolean available;

    // Constructor ----------------------------------------------------------------------
    public Book(String id, String title, String authorName, String authorSurname,
                String edition, String section, boolean available) {
        setId(id);
        setTitle(title);
        setAuthorName(authorName);
        setAuthorSurname(authorSurname);
        setEdition(edition);
        setSection(section);
        setBorrowed(available);
    }

    // Getters --------------------------------------------------------------------------
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public String getEdition() {
        return edition;
    }

    public String getSection() {
        return section;
    }

    public boolean getAvailable() {
        return available;
    }

    // Setters --------------------------------------------------------------------------
    public void setId(String newId) {
        this.id = newId;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setAuthorName(String newAuthorName) {
        this.authorName = newAuthorName;
    }

    public void setAuthorSurname(String newSurname) {
        this.authorSurname = newSurname;
    }

    public void setEdition(String newEdition) {
        this.edition = newEdition;
    }

    public void setSection(String newSection) {
        this.section = newSection;
    }

    public void setBorrowed(boolean status) {
        this.available = status;
    }
}
