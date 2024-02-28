package esprit.pi.forum.controllers;


import esprit.pi.forum.entities.Session;
import esprit.pi.forum.services.ISessionRepository;
import esprit.pi.forum.services.SessionServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class SessionController {
    @Autowired
    SessionServiceImpl sessionService;

    @PostMapping("/add")
    public Session AddSession(@RequestBody Session s){
        return sessionService.addSession(s);
    }

    @DeleteMapping("/delete/{idSession}")
    public ResponseEntity<?> delete(@PathVariable("idSession") Long sid){
        sessionService.removeSession(sid);
        return new  ResponseEntity<>("delete succ"+sid, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idSession}")
    public ResponseEntity<?> update(@PathVariable("idSession") Long sid, @RequestBody Session updateSession) {
        Session session = sessionService.modifiySession(sid, updateSession);
        if (session != null) {
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune session trouvée avec l'ID : " + sid);
        }
    }


    @GetMapping("/session/{id}")
    public Session getById(@PathVariable("id") Long id){
        return sessionService.retrieveSession(id);
    }

    @GetMapping("/getAll")
    public List<Session> getSession(){
        List<Session> sessions = sessionService.retrieveAllSession();
        return sessions;
    }
}
