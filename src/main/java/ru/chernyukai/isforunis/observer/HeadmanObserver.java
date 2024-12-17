package ru.chernyukai.isforunis.observer;

import ru.chernyukai.isforunis.model.LearningGroup;
import ru.chernyukai.isforunis.model.Student;
import ru.chernyukai.isforunis.model.User;
import ru.chernyukai.isforunis.repository.StudentRepository;

public class HeadmanObserver implements Observer {

    private final User headman;

    public HeadmanObserver(User user){
        headman = user;
    }

    @Override
    public void notify(String message) {

        System.out.println("Староста группы" + headman.getSurname()  + " получил сообщение: " + message);
    }
}
