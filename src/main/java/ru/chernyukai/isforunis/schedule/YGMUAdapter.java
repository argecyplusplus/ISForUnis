package ru.chernyukai.isforunis.schedule;

import lombok.RequiredArgsConstructor;
import ru.chernyukai.isforunis.model.LearningGroup;
import ru.chernyukai.isforunis.model.Session;
import ru.chernyukai.isforunis.repository.ClassroomRepository;
import ru.chernyukai.isforunis.repository.LearningGroupRepository;
import ru.chernyukai.isforunis.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class YGMUAdapter implements ScheduleProvider {
    private final YGMUSystem ygmuSystem;

    private final SubjectRepository subjectRepository;
    private final ClassroomRepository classroomRepository;
    private final LearningGroupRepository learningGroupRepository;

    @Override
    public List<Session> getSchedule(String groupName) {




        List<Session> sessionList = new ArrayList<>();

        for (String sessionStr : ygmuSystem.getYGMSchedule(groupName)){

            String[] parts = sessionStr.split("\\s+");

            String subject = parts[0];
            String room = parts[1];
            String group = parts[2];

            List<LearningGroup> groupList = new ArrayList<LearningGroup>();
            groupList.add(learningGroupRepository.getLearningGroupByName(groupName));

            Session session = new Session(
                    null,
                    subjectRepository.getSubjectsByName(subject),
                    null,
                    null,
                    null,
                    classroomRepository.getClassroomByName(room),
                    groupList
            );
            sessionList.add(session);
        }

        return sessionList;
    }
}
