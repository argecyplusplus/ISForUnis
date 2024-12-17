package ru.chernyukai.isforunis.service;

import org.springframework.stereotype.Service;
import ru.chernyukai.isforunis.schedule.ScheduleProvider;

import java.util.List;

@Service
public class ScheduleService {

    private final List<ScheduleProvider> providers;

    public ScheduleService(List<ScheduleProvider> providers) {
        this.providers = providers;
    }

    public void loadSchedules(String groupName) {
        for (ScheduleProvider provider : providers) {
            System.out.println(provider.getSchedule(groupName));
        }
    }
}
