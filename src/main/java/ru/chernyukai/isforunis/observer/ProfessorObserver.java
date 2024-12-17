package ru.chernyukai.isforunis.observer;

import ru.chernyukai.isforunis.model.User;

public class ProfessorObserver implements Observer {

    private final User professor;

    public ProfessorObserver(User user){
        professor = user;
    }

    @Override
    public void notify(String message) {


        System.out.println("Проподаватель " + professor.getSurname()  + " получил сообщение: " + message);
    }
}
