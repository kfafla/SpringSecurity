package top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.entity.Meeting;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.service.MeetingService;

/**
 * @author mqxu
 * @date 2024/9/2
 * @description Meeting
 **/
@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Resource
    private MeetingService meetingService;

    @PostMapping("/check")
    public ResponseEntity<String> check(@RequestBody Meeting meeting) {

        if (meetingService.isRoomAvailable(meeting)) {
            //添加到会议室列表
            meetingService.addMeeting(meeting);
            return ResponseEntity.ok("会议室可用！");
        } else {
            return ResponseEntity.ok("会议室已被占用！");
        }
    }
}