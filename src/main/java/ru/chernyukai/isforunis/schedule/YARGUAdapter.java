package ru.chernyukai.isforunis.schedule;

public class YARGUAdapter implements ScheduleProvider {
    private final YARGUSystem yarguSystem;

    public YARGUAdapter(YARGUSystem yarguSystem) {
        this.yarguSystem = yarguSystem;
    }

    @Override
    public String getSchedule(String groupName) {
        return yarguSystem.loadScheduleYARGU(groupName)
                .replace("{YARGU_Schedule: ", "")
                .replace("] for group ", ": ")
                .replace("}", "");
    }
}
