package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressBookMapper {

    /**
     * 新增地址数据
     * @param addressBook
     */
    @Insert("insert into address_book (user_id, consignee, sex, phone, province_code, province_name, city_code, city_name, district_code, district_name, detail, label, is_default) VALUES " +
            "(#{userId}, #{consignee}, #{sex}, #{phone}, #{provinceCode}, #{provinceName}, #{cityCode}, #{cityName}, #{districtCode}, #{districtName}, #{detail}, #{label}, #{isDefault})")
    void insert(AddressBook addressBook);

    /**
     * 条件查询
     * @param addressBook
     * @return
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 根据id查询地址数据
     * @param id
     * @return
     */
    @Select("select * from address_book where id = #{id}")
    AddressBook getById(Long id);

    /**
     * 根据id修改地址数据
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /**
     * 根据id删除地址数据
     * @param id
     */
    @Delete("delete from address_book where id = #{id}")
    void deleteById(Long id);

    @Update("update address_book set is_default = #{isDefault} where user_id = #{userId}")
    void setIsDefaultByUserId(AddressBook addressBook);
}
