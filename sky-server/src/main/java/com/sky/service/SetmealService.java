package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.entity.Setmeal;

import java.util.List;

public interface SetmealService {


    /**
     * 新增套餐和相关菜品
     * @param setmealDTO
     */
    void saveWithDishes(SetmealDTO setmealDTO);

    /**
     *
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);


}
