package ru.chernyukai.isforunis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chernyukai.isforunis.model.Session;
import ru.chernyukai.isforunis.observer.NotificationSubject;
import ru.chernyukai.isforunis.repository.SessionRepository;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final NotificationSubject notificationSubject;

    @Autowired
    public SessionService(SessionRepository sessionRepository, NotificationSubject notificationSubject) {
        this.sessionRepository = sessionRepository;
        this.notificationSubject = notificationSubject;
    }

    @Transactional
    public Session addSession(Session session) {
        // Сохраняем занятие
        Session savedSession = sessionRepository.save(session);

        // Формируем сообщение для уведомления
        String message = String.format(
                "Изменения в расписании." +
                        "Добавлено занятие: %s для групп %s у преподавателя %s в аудитории %s в %s длительностью %s",
                session.getSubject(), session.getLearningGroupList(), session.getProfessor(),
                session.getClassroom(),
                session.getStartDatetime(), session.getDuration()
        );

        // Уведомляем наблюдателей
        notificationSubject.notifyObservers(message, savedSession);

        return savedSession;
    }

}
