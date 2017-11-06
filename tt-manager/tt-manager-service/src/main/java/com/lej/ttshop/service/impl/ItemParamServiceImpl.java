package com.lej.ttshop.service.impl;

import com.lej.common.dto.Page;
import com.lej.common.dto.Result;
import com.lej.ttshop.dao.TbItemParamCustomMapper;
import com.lej.ttshop.dao.TbItemParamMapper;
import com.lej.ttshop.pojo.po.TbItemParam;
import com.lej.ttshop.pojo.po.TbItemParamExample;
import com.lej.ttshop.pojo.vo.TbItemParamCustom;
import com.lej.ttshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: lienjiaa
 * Date: 2017/11/2
 * Time: 16:46
 * Version:V1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Autowired
    private TbItemParamCustomMapper tbItemParamMapperCustom;

    @Override
    public Result<TbItemParamCustom> listItemParams(Page page) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("page", page);
        List<TbItemParamCustom> list = tbItemParamMapperCustom.listItemParamsByPage(map);
        long counts = tbItemParamMapperCustom.countItemParams(map);
        Result<TbItemParamCustom> rs = new Result<TbItemParamCustom>();
        rs.setTotal(counts);
        rs.setRows(list);
        return rs;
    }

    @Override
    public int saveItemParam(Long cid, String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setUpdated(new Date());
        tbItemParam.setCreated(new Date());
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramData);
        return tbItemParamMapper.insert(tbItemParam);
    }

    @Override
    public TbItemParam getItemParamByCid(Long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list =  tbItemParamMapper.selectByExampleWithBLOBs(example);
        if(list != null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

}
