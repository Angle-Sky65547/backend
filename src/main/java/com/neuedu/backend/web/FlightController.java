package com.neuedu.backend.web;

import com.github.pagehelper.PageInfo;
import com.neuedu.backend.model.*;
import com.neuedu.backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("info") //url ：/customer/page
    public Result<PageInfo<Flight>> getPage(@RequestBody PageCondition<Flight> pageCondition) {
        return Result.getOk(flightService.page(pageCondition));
    }
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable Long id) {
        flightService.deleteById(id);
        return Result.getOk(null);
    }

    @PostMapping("add")
    public void Add(@RequestBody Flight flight) throws ParseException {
        flightService.insert(flight);
    }

    @DeleteMapping("update/{id}")
    public Result<Void> update(@PathVariable Long id) {
        flightService.updateById(id);
        return Result.getOk(null);
    }

}
