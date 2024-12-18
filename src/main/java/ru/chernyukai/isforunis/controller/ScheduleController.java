package ru.chernyukai.isforunis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.chernyukai.isforunis.model.Session;
import ru.chernyukai.isforunis.service.ScheduleService;

import java.util.List;
import java.util.Optional;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/api/schedules")
    public ResponseEntity<List<Session>> getSchedules(@RequestParam String groupName) {
        return ResponseEntity.of(Optional.ofNullable(scheduleService.loadSchedules(groupName))) ;
    }
}
