package com.wh.pro1.service.impl;

import com.wh.pro1.dao.AreaDao;
import com.wh.pro1.entity.Area;
import com.wh.pro1.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author WangHui
 * @since 2019/1/25
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public Area findOne(Long id) {
        return areaDao.findOne(id);
    }

    @Transactional
    @Override
    public boolean update(Area area) {
        if (area.getId() != null && area.getId() > 0) {
            try {
                String en = "en";
                int count = areaDao.update(area);
                if (count > 0) {
                    return true;
                } else {
                    throw new RuntimeException("跟新区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("跟新区域信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean delete(Long id) {
        return areaDao.delete(id) > 0;
    }

    @Transactional
    @Override
    public boolean save(Area area) {
        if (area.getName() != null && !"".equals(area.getName())) {
            try {
                int count = areaDao.save(area);
                if (count > 0) {
                    return true;
                } else {
                    throw new RuntimeException("保存区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("保存区域信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }

    }

    @Override
    public List<Area> findAll() {
        return areaDao.findAll();
    }
}
