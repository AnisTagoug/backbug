package esprit.pi.forum.services;

import esprit.pi.forum.entities.Session;

import java.util.List;

public interface ISessionRepository {
    Session addSession(Session s);

    public void removeSession(Long idSession);

    public Session modifiySession(Long idSession, Session updateSession);

    public List<Session> retrieveAllSession();
    public Session retrieveSession(Long id);
}
