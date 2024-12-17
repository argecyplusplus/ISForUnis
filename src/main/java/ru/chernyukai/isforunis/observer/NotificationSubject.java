package ru.chernyukai.isforunis.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.chernyukai.isforunis.model.LearningGroup;
import ru.chernyukai.isforunis.model.Session;
import ru.chernyukai.isforunis.model.User;
import ru.chernyukai.isforunis.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationSubject {
    private final List<Observer> observers = new ArrayList<>();

    @Autowired
    private StudentRepository studentRepository;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message, Session session) {

        for ( LearningGroup group : session.getLearningGroupList()){
            addObserver(new HeadmanObserver(studentRepository.getHeadmanByGroup(group).getUser()));
        }
        addObserver(new ProfessorObserver(session.getProfessor()));

        List<LearningGroup> learningGroupList = session.getLearningGroupList();




        for (Observer observer : observers) {
            observer.notify(message);
        }
    }
}

