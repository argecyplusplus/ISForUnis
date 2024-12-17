package ru.chernyukai.isforunis.schedule;

public class YGMUAdapter implements ScheduleProvider {
    private final YGMUSystem ygmuSystem;

    public YGMUAdapter(YGMUSystem ygmuSystem) {
        this.ygmuSystem = ygmuSystem;
    }

    @Override
    public String getSchedule(String groupName) {
        String rawSchedule = ygmuSystem.getYGMSchedule(groupName);
        return rawSchedule.replace("|", " ").replace("Group:", "Group: ");
    }
}
