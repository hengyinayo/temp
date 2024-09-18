package org.ybigta.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.ybigta.backend.domain.Session;
import org.ybigta.backend.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findById(id);
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session updateSession(Long id, Session sessionDetails) {
        Session existingSession = sessionRepository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));

        sessionDetails.setUserId(sessionDetails.getUserId());
        sessionDetails.setTitle(sessionDetails.getTitle());
        sessionDetails.setDate(sessionDetails.getDate());
        sessionDetails.setTeamId(sessionDetails.getTeamId());

        return sessionRepository.save(sessionDetails);
    }

    public void deleteSession(Long id) {
        Session existingSession = sessionRepository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
        sessionRepository.delete(existingSession);
    }
}
