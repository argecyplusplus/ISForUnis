package ru.chernyukai.isforunis.schedule;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class YARGUSystem {
    public List<String> loadScheduleYARGU(String groupName) {
        List<String> response = new ArrayList<>();
        response.add("Г-505 Физика " + groupName);

        return response;
    }
}
