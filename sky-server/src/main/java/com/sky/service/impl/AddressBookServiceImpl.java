package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.mapper.AddressBookMapper;
import com.sky.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookMapper addressBookMapper;


    /**
     * 新增地址
     * @param addressBook
     */
    public void addAddress(AddressBook addressBook) {
        Long userId = BaseContext.getCurrentId();
        addressBook.setUserId(userId);
        addressBook.setIsDefault(0);
        addressBookMapper.insert(addressBook);
    }

    /**
     * 条件查询
     * @param addressBook
     * @return
     */
    public List<AddressBook> list(AddressBook addressBook) {

        List<AddressBook> list = addressBookMapper.list(addressBook);
        return list;
    }


    /**
     * 根据id查询地址
     * @param id
     * @return
     */
    public AddressBook getById(Long id) {
        AddressBook addressBook = addressBookMapper.getById(id);
        return addressBook;
    }


    /**
     * 根据id修改地址
     * @param addressBook
     */
    public void update(AddressBook addressBook) {
        addressBookMapper.update(addressBook);
    }


    /**
     * 根据id删除地址
     * @param id
     */
    public void deleteById(Long id) {
        addressBookMapper.deleteById(id);
    }


    /**
     * 设置默认地址
     * @param addressBook
     */
    public void setDefaultAddress(AddressBook addressBook) {
        // 1.将所有的地址改为非默认状态
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBook.setIsDefault(0);
        // update address_book set isDefault = ? where user_id = ?
        addressBookMapper.setIsDefaultByUserId(addressBook);

        // 2.修改默认地址
        addressBook.setIsDefault(1);
        // update address_book set is_default = ? where id = ?
        addressBookMapper.update(addressBook);
    }
}
