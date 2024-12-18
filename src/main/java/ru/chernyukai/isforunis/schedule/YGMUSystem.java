package ru.chernyukai.isforunis.schedule;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class YGMUSystem {
    public List<String> getYGMSchedule(String group) {
        List<String> response = new ArrayList<>();
        response.add("Физика Г-505 " + group);

        return response;
    }
}
