package com.ruoyi.cold.service.impl;

import java.util.Collections;
import java.util.List;

import com.ruoyi.cold.domain.WarehouseInWName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cold.mapper.WarehouseInMapper;
import com.ruoyi.cold.domain.WarehouseIn;
import com.ruoyi.cold.service.IWarehouseInService;

/**
 * 入库Service业务层处理
 * 
 * @author zzz
 * @date 2025-05-12
 */
@Service
public class WarehouseInServiceImpl implements IWarehouseInService 
{
    @Autowired
    private WarehouseInMapper warehouseInMapper;


    @Override
    public List<Integer> selectUnfinishByClientId(WarehouseIn warehouseIn) {
        return warehouseInMapper.selectUnfinishByClientId(warehouseIn);
    }

    @Override
    public List<WarehouseInWName> selectWarehouseInWNameList(WarehouseIn warehouseIn) {
        return warehouseInMapper.selectWarehouseInWNameList(warehouseIn);
    }

    /**
     * 查询入库
     * 
     * @param warehouseInId 入库主键
     * @return 入库
     */
    @Override
    public WarehouseIn selectWarehouseInByWarehouseInId(Integer warehouseInId)
    {
        return warehouseInMapper.selectWarehouseInByWarehouseInId(warehouseInId);
    }

    /**
     * 查询入库列表
     * 
     * @param warehouseIn 入库
     * @return 入库
     */
    @Override
    public List<WarehouseIn> selectWarehouseInList(WarehouseIn warehouseIn)
    {
        return warehouseInMapper.selectWarehouseInList(warehouseIn);
    }

    /**
     * 新增入库
     * 
     * @param warehouseIn 入库
     * @return 结果
     */
    @Override
    public int insertWarehouseIn(WarehouseIn warehouseIn)
    {
        return warehouseInMapper.insertWarehouseIn(warehouseIn);
    }

    /**
     * 修改入库
     * 
     * @param warehouseIn 入库
     * @return 结果
     */
    @Override
    public int updateWarehouseIn(WarehouseIn warehouseIn)
    {
        return warehouseInMapper.updateWarehouseIn(warehouseIn);
    }

    /**
     * 批量删除入库
     * 
     * @param warehouseInIds 需要删除的入库主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseInByWarehouseInIds(Integer[] warehouseInIds)
    {
        return warehouseInMapper.deleteWarehouseInByWarehouseInIds(warehouseInIds);
    }

    /**
     * 删除入库信息
     * 
     * @param warehouseInId 入库主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseInByWarehouseInId(Integer warehouseInId)
    {
        return warehouseInMapper.deleteWarehouseInByWarehouseInId(warehouseInId);
    }

    @Override
    public int updateWarehouseInFinishByIds(List<Integer> warehouseInIds) {
        return warehouseInMapper.updateWarehouseInFinishByIds(warehouseInIds);
    }

    @Override
    public int batchUpdateWarehouseIn2Settle(List<Integer> inIds) {
        return warehouseInMapper.batchUpdateWarehouseIn2Settle(inIds);
    }
}
