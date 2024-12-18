package ru.chernyukai.isforunis.schedule;

import ru.chernyukai.isforunis.model.Session;

import java.util.List;

public class YARGUAdapter implements ScheduleProvider {
    private final YARGUSystem yarguSystem;

    public YARGUAdapter(YARGUSystem yarguSystem) {
        this.yarguSystem = yarguSystem;
    }

    @Override
    public List<Session> getSchedule(String groupName) {
        return yarguSystem.loadScheduleYARGU(groupName)
                .replace("{YARGU_Schedule: ", "")
                .replace("] for group ", ": ")
                .replace("}", "");
    }
}
