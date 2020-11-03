package com.iu2java.tmall.service.impl;

import com.iu2java.tmall.mapper.PropertyValueMapper;
import com.iu2java.tmall.pojo.*;
import com.iu2java.tmall.service.PropertyService;
import com.iu2java.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    PropertyService propertyService;
    @Autowired
    PropertyValueMapper propertyValueMapper;

    @Override
    public void init(Product p) {
        List<Property> pts = propertyService.list(p.getCid());
        for (Property pt : pts) {
            PropertyValue pv = get(pt.getId(), p.getId()); //根据属性id和产品id获取属性值，这个方法的返回值可能是null，因为数据库不存在对应的pv记录
            if (pv == null) {            //已获取的属性值对象可能是null，如果是null就初始化,向数据库插入记录
                pv = new PropertyValue();
                pv.setPid(p.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
            }
        }
    }

    @Override
    public void update(PropertyValue pv) {
        //使用这个方法而不是updateByPrimaryKey()
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }

    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
        if(pvs.isEmpty()) {
            return null;
        }
        return pvs.get(0);
    }

    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
        for (PropertyValue pv : pvs) {
            Property property = propertyService.get(pv.getPtid());//从数据库中取出对应属性值id的属性
            pv.setProperty(property);//为每个属性值设置其对应的属性对象，这个property不是propertyValue表的字段，需要手动关联
        }
        return pvs;
    }
}
