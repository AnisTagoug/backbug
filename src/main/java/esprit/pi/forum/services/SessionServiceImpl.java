package esprit.pi.forum.services;

import esprit.pi.forum.entities.Session;
import esprit.pi.forum.repositories.SessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SessionServiceImpl implements  ISessionRepository {
    @Autowired
    SessionRepository sessionRepository;
    @Override
    public Session addSession(Session s) {
        return sessionRepository.save(s);


    }
    @Override
    public Session retrieveSession(Long id) {
        return sessionRepository.findByIdSession(id)
                .orElseThrow(() -> new IllegalArgumentException("no instructor found with this id " + id));
    }

    @Override
    public void removeSession(Long idSession) {
        sessionRepository.deleteById(idSession);

    }

    @Override
    public Session modifiySession(Long idSession, Session updateSession) {
        Optional<Session> optUpdate = sessionRepository.findByIdSession(idSession);
        if (optUpdate.isPresent()){
            Session sessioExist = optUpdate.get();
            sessioExist.setIntitule(updateSession.getIntitule());
            sessioExist.setDateSession(updateSession.getDateSession());
            sessioExist.setNbrDePlaces(updateSession.getNbrDePlaces());

            return sessionRepository.save(sessioExist);

        }else {
            return  null;
        }

    }

    @Override
    public List<Session> retrieveAllSession() {
        List<Session> sessionList = sessionRepository.findAll();
        for(Session S:sessionList){
            log.info("Session"+S);
        }
        return sessionList;
    }
}
