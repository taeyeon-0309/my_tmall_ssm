package com.iu2java.tmall.controller;

import com.iu2java.tmall.pojo.Product;
import com.iu2java.tmall.pojo.PropertyValue;
import com.iu2java.tmall.service.ProductService;
import com.iu2java.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    ProductService productService;
    @Autowired
    PropertyValueService propertyValueService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model, int pid) {
        Product p = productService.get(pid);
        propertyValueService.init(p);
        List<PropertyValue> pvs = propertyValueService.list(p.getId());

        model.addAttribute("p",p);
        model.addAttribute("pvs",pvs);

        return "admin/editPropertyValue";
    }

    /**
     * //表示方法返回结果直接写入HTTP response body中，一般结合AJAX使用
     * 前台数据 Ajax{"value": value, "id": pvid},也可以自己构造/admin_propertyValue_update?value=666&id=2
     * @param pv 根据前台数据构造对象
     * @return 表示成功字符串"success"
     */
    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv) {
        propertyValueService.update(pv);
        return "success";
    }
}
