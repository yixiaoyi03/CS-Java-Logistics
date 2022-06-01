package net.csjava.logistics.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.entity.AddressBook;
import net.csjava.logistics.mapper.AddressBookMapper;
import net.csjava.logistics.service.IAddressBookService;
import org.springframework.stereotype.Service;

/**
 * 地址簿服务类实现
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements IAddressBookService {

}