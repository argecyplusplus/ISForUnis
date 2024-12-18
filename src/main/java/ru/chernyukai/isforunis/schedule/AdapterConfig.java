package ru.chernyukai.isforunis.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chernyukai.isforunis.repository.ClassroomRepository;
import ru.chernyukai.isforunis.repository.LearningGroupRepository;
import ru.chernyukai.isforunis.repository.SubjectRepository;

@Configuration
@RequiredArgsConstructor
public class AdapterConfig {

    private final YARGUSystem yarguSystem;
    private final YSTUSystem ystuSystem;
    private final YGMUSystem ygmuSystem;
    private final SubjectRepository subjectRepository;
    private final ClassroomRepository classroomRepository;
    private final LearningGroupRepository learningGroupRepository;

    @Bean
    public YSTUAdapter ystuAdapter() {
        return new YSTUAdapter(
                ystuSystem,
                subjectRepository,
                classroomRepository,
                learningGroupRepository
        );
    }

    @Bean
    public YARGUAdapter yarguAdapter() {
        return new YARGUAdapter(
                yarguSystem,
                subjectRepository,
                classroomRepository,
                learningGroupRepository
        );
    }

    @Bean
    public YGMUAdapter ygmuAdapter() {
        return new YGMUAdapter(
                ygmuSystem,
                subjectRepository,
                classroomRepository,
                learningGroupRepository
        );
    }
}
