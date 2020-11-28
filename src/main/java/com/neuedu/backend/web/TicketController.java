package com.neuedu.backend.web;

import com.github.pagehelper.PageInfo;
import com.neuedu.backend.model.Flight;
import com.neuedu.backend.model.PageCondition;
import com.neuedu.backend.model.Result;
import com.neuedu.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("info") //url ：/customer/page
    public Result<PageInfo<Flight>> getPage(@RequestBody PageCondition<Flight> pageCondition) {
        return Result.getOk(ticketService.page(pageCondition));
    }

    @DeleteMapping("update/{id}")
    public Result<Void> updat(@PathVariable Long id) {
        ticketService.updateById(id);
        return Result.getOk(null);
    }
    @DeleteMapping("delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        ticketService.deleteById(id);
        return Result.getOk(null);
    }

}
