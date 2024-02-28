package esprit.pi.forum.services;

import esprit.pi.forum.entities.Offre;
import esprit.pi.forum.repositories.OffreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OffreServiceImp implements IOffreService{
    private OffreRepository offreRepository;

    @Override
    public Offre addOffre(Offre o) {
        return offreRepository.save(o);
    }

    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

}


