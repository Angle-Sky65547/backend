package com.neuedu.backend.web;

import com.github.pagehelper.PageInfo;
import com.neuedu.backend.model.Flight;
import com.neuedu.backend.model.PageCondition;
import com.neuedu.backend.model.Result;
import com.neuedu.backend.service.RestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket/")
public class RestoreController {
    @Autowired
    private RestoreService restoreService;

    @PostMapping("restore")
    public Result<PageInfo<Flight>> getPage(@RequestBody PageCondition<Flight> pageCondition) {
        return Result.getOk(restoreService.page(pageCondition));
    }
}
