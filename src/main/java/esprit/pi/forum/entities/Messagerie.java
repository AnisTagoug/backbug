package esprit.pi.forum.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Messagerie implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMsg ;


    @ManyToMany(mappedBy = "messageries",cascade=CascadeType.ALL)
    private Set<User> users;
}
