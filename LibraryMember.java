import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LibraryMember {

    @Id
    private int memberId;
    private String name;

    public LibraryMember() {}

    public LibraryMember(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}
