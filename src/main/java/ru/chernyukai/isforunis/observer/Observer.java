package ru.chernyukai.isforunis.observer;

import ru.chernyukai.isforunis.model.LearningGroup;
import ru.chernyukai.isforunis.model.User;

public interface Observer {


    void notify(String message);
}
