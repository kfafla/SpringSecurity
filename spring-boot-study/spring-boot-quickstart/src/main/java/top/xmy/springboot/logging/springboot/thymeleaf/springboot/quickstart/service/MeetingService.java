package top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.entity.Meeting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mqxu
 * @date 2024/9/2
 * @description MeetingService
 **/
@Service
public class MeetingService {

    private final List<Meeting> meetings = new ArrayList<>();

    public boolean isRoomAvailable(Meeting newMeeting) {
        return meetings.stream()
                .noneMatch(exitingMeeting -> exitingMeeting.isOverlapping(newMeeting));
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }
}
