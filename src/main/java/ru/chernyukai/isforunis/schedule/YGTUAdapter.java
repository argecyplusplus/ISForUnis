package ru.chernyukai.isforunis.schedule;

public class YGTUAdapter implements ScheduleProvider {
    private final YSTUSystem ystuSystem;

    public YGTUAdapter(YSTUSystem ystuSystem) {
        this.ystuSystem = ystuSystem;
    }

    @Override
    public String getSchedule(String groupName) {
        return ystuSystem.fetchScheduleYSTU(groupName);
    }
}
