package com.neuedu.backend.web;

import com.github.pagehelper.PageInfo;
import com.neuedu.backend.model.AirType;
import com.neuedu.backend.model.PageCondition;
import com.neuedu.backend.model.Result;
import com.neuedu.backend.service.AirTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

@RestController
@RequestMapping("type")
public class AirTypeController {

    @Autowired
    private AirTypeService airTypeService;

    /**
     * 返回分页查询数据,以Result对象形式返回数据
     *
     * @param pageCondition
     * @return
     */
    @PostMapping("info")
    public Result<PageInfo<AirType>> getPage(@RequestBody PageCondition<AirType> pageCondition) {
        return Result.getOk(airTypeService.page(pageCondition));
    }

    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable Long id) {
        airTypeService.deleteById(id);
        return Result.getOk(null);
    }

    @PostMapping("add")
    public void Add(@RequestBody AirType airType) {
         airTypeService.insert(airType);
    }
}
