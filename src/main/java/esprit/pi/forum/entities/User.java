package esprit.pi.forum.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Candidature> candidatures;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Offre> offres;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Reclamation> reclamations;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Session> sessions;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Messagerie> messageries;
}
