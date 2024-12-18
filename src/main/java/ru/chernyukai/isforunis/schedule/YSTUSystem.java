package ru.chernyukai.isforunis.schedule;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class YSTUSystem {
    public List<String> fetchScheduleYSTU(String group) {

        List<String> response = new ArrayList<>();
        response.add("1 Физика Г-505 " + group);

        return response;

    }
}
