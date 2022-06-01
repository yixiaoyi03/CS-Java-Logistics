package net.csjava.logistics.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.entity.Member;
import net.csjava.logistics.mapper.MemberMapper;
import net.csjava.logistics.service.IMemberService;
import org.springframework.stereotype.Service;

/**
 * 用户服务类实现
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}