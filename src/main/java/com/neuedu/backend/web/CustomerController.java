package com.neuedu.backend.web;

import com.github.pagehelper.PageInfo;
import com.neuedu.backend.model.Customer;
import com.neuedu.backend.model.PageCondition;
import com.neuedu.backend.model.Result;
import com.neuedu.backend.service.CustomerService;
import javafx.scene.shape.CircleBuilder;
import org.apache.ibatis.annotations.DeleteProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer") //配置controller的处理请求的前缀
public class CustomerController {

    //alt+enter快捷键：哪里不会点哪里
    @Autowired
    private CustomerService customerService;

    /**
     * 返回分页查询数据,以Result对象形式返回数据
     *
     * @param pageCondition
     * @return
     */
    @PostMapping("page") //url ：/customer/page
    public Result<PageInfo<Customer>> getPage(@RequestBody PageCondition<Customer> pageCondition) {
        return Result.getOk(customerService.page(pageCondition));
    }

    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable Long id) {
        customerService.deleteById(id);
        return Result.getOk(null);
    }
}
