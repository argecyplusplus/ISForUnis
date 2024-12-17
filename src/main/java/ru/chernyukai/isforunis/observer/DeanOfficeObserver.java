package ru.chernyukai.isforunis.observer;

import ru.chernyukai.isforunis.model.User;

public class DeanOfficeObserver implements Observer {

    private final User dean;

    public DeanOfficeObserver(User user){
        dean = user;
    }


    @Override
    public void notify(String message) {

       System.out.println("Деканат (пользователь " + dean.getSurname()  + ") получил сообщение: " + message);
    }
}
