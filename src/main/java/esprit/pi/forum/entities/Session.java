package esprit.pi.forum.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Session implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSession ;

    private String intitule;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateSession;

    private int nbrDePlaces;

    @ManyToMany(mappedBy = "sessions",cascade = CascadeType.ALL)
    private Set<User> users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessions")
    private Set<Materiel> materiels;
}
