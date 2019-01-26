package com.wh.pro1.controller;

import com.wh.pro1.entity.Area;
import com.wh.pro1.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangHui
 * @since 2019/1/25
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/areaList")
    public Map<String, Object> areaList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.findAll();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @GetMapping("/findOne/id")
    public Map<String, Object> findOne(Long id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area a = areaService.findOne(id);
        modelMap.put("list", a);
        return modelMap;
    }

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.save(area));
        return modelMap;
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.update(area));
        return modelMap;
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(Long id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.delete(id));
        return modelMap;
    }
}
