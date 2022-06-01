package net.csjava.logistics.service.impl;
import lombok.extern.slf4j.Slf4j;
import net.csjava.logistics.common.utils.Result;
import net.csjava.logistics.entity.Member;
import net.csjava.logistics.feign.MemberFeign;
import net.csjava.logistics.feign.UserClient;
import net.csjava.logistics.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberFeign memberFeign;

    @Autowired
    private UserClient userClient;


    @Override
    public Member detail(String userId) {
        log.info("查找用户信息(本地):{}", userId);
        Member member = memberFeign.detail(userId);
        log.info("查找用户信息(本地):{} Result:{}", userId, member);

        log.info("查找用户信息(远端):{}", userId);
        Map user = userClient.findById(userId);
        log.info("查找用户信息(远端):{} Result:{}", userId, user);

        if (member == null) {
            // 本地不存在  创建一份
            if (user != null && user.get("data") != null) {
                Map userData = (Map) user.get("data");
                member = new Member();
                member.setId(userId);
                member.setAuthId(userId);
                member.setPhone((String) userData.get("mobile"));
                member.setAvatar((String) userData.get("avatar"));
                member.setName((String) userData.get("userName"));
                Result result = memberFeign.save(member);
                log.info("查找用户信息(远端):{} 留存结果:{}", userId, result);
            }
        } else {
            if (user != null && user.get("data") != null) {
                Map userData = (Map) user.get("data");
                member.setAvatar((String) userData.get("avatar"));
                member.setName((String) userData.get("userName"));
            }
        }

        return member;
    }

}
