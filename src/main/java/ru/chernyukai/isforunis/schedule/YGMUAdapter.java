package ru.chernyukai.isforunis.schedule;

import ru.chernyukai.isforunis.model.Session;

import java.util.List;

public class YGMUAdapter implements ScheduleProvider {
    private final YGMUSystem ygmuSystem;

    public YGMUAdapter(YGMUSystem ygmuSystem) {
        this.ygmuSystem = ygmuSystem;
    }

    @Override
    public List<Session> getSchedule(String groupName) {
        String rawSchedule = ygmuSystem.getYGMSchedule(groupName);
        return rawSchedule.replace("|", " ").replace("Group:", "Group: ");
    }
}
