package ru.chernyukai.isforunis.service;

import org.springframework.stereotype.Service;
import ru.chernyukai.isforunis.model.Session;
import ru.chernyukai.isforunis.schedule.*;

import java.util.List;

@Service
public class ScheduleService {


    private final ScheduleProvider YSTUAdapter;
    private final ScheduleProvider YGMUAdapter;
    private final ScheduleProvider YARGUAdapter;

    public ScheduleService(YSTUAdapter ystuAdapter, YARGUAdapter yarguAdapter, YGMUAdapter ygmuAdapter) {
        YSTUAdapter = ystuAdapter;
        YGMUAdapter = ygmuAdapter;
        YARGUAdapter = yarguAdapter;
    }


    public List<Session> loadSchedules(String groupName, String sys) {
        switch (sys){
            case "ЯГТУ":
                return YSTUAdapter.getSchedule(groupName);
            case "ЯрГУ":
                return YARGUAdapter.getSchedule(groupName);
            case "ЯГМУ":
                return YGMUAdapter.getSchedule(groupName);
        }

    }
}
