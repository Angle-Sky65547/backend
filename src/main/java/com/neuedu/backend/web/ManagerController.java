package com.neuedu.backend.web;

import com.github.pagehelper.PageInfo;
import com.neuedu.backend.model.Flight;
import com.neuedu.backend.model.Manager;
import com.neuedu.backend.model.PageCondition;
import com.neuedu.backend.model.Result;
import com.neuedu.backend.service.ManagerService;
import com.neuedu.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("info") //url ：/customer/page
    public Result<PageInfo<Manager>> getPage(@RequestBody PageCondition<Manager> pageCondition) {
        return Result.getOk(managerService.page(pageCondition));
    }

    @PostMapping("add")
    public void Add(@RequestBody Manager manager) {
        managerService.insert(manager);
    }


    @DeleteMapping("delete/{id}")
    public Result<Void> update(@PathVariable Long id) {
        managerService.deleteById(id);
        return Result.getOk(null);
    }
}
