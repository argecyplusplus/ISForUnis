package ru.chernyukai.isforunis.schedule;

import ru.chernyukai.isforunis.model.Session;

import java.util.List;

public interface ScheduleProvider {
    List<Session> getSchedule(String groupName);
}