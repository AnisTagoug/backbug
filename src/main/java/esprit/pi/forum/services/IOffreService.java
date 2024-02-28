package esprit.pi.forum.services;

import esprit.pi.forum.entities.Offre;

import java.util.List;

public interface IOffreService {
    public Offre addOffre(Offre o);
    public List<Offre> getAllOffres();
}
