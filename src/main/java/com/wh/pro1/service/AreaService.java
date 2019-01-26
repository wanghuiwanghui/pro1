package com.wh.pro1.service;

import com.wh.pro1.entity.Area;

import java.util.List;

/**
 * @author WangHui
 * @since 2019/1/25
 */
public interface AreaService {
    /**
     * findOne
     *
     * @param id id
     * @return Area
     */
    public Area findOne(Long id);

    /**
     * update
     *
     * @param area area
     */
    public boolean update(Area area);

    /**
     * delete
     *
     * @param id id
     */
    public boolean delete(Long id);

    /**
     * save
     *
     * @param area area
     * @return boolean
     */
    public boolean save(Area area);

    List<Area> findAll();
}
