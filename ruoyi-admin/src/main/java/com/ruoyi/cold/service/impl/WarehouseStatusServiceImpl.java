package com.ruoyi.cold.service.impl;

import java.util.List;

import com.ruoyi.cold.domain.WarehouseStatus;
import com.ruoyi.cold.mapper.WarehouseStatusMapper;
import com.ruoyi.cold.service.IWarehouseStatusService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 库存信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-05-12
 */
@Service
public class WarehouseStatusServiceImpl implements IWarehouseStatusService
{
    @Autowired
    private WarehouseStatusMapper warehouseStatusMapper;

    /**
     * 查询库存信息
     *
     * @param warehouseId 库存信息主键
     * @return 库存信息
     */
    @Override
    public WarehouseStatus selectWarehouseStatusByWarehouseId(Long warehouseId)
    {
        return warehouseStatusMapper.selectWarehouseStatusByWarehouseId(warehouseId);
    }

    /**
     * 查询库存信息列表
     *
     * @param warehouseStatus 库存信息
     * @return 库存信息
     */
    @Override
    public List<WarehouseStatus> selectWarehouseStatusList(WarehouseStatus warehouseStatus)
    {
        return warehouseStatusMapper.selectWarehouseStatusList(warehouseStatus);
    }

    /**
     * 新增库存信息
     *
     * @param warehouseStatus 库存信息
     * @return 结果
     */
    @Override
    public int insertWarehouseStatus(WarehouseStatus warehouseStatus)
    {
        warehouseStatus.setCreateTime(DateUtils.getNowDate());
        return warehouseStatusMapper.insertWarehouseStatus(warehouseStatus);
    }

    /**
     * 修改库存信息
     *
     * @param warehouseStatus 库存信息
     * @return 结果
     */
    @Override
    public int updateWarehouseStatus(WarehouseStatus warehouseStatus)
    {
        warehouseStatus.setUpdateTime(DateUtils.getNowDate());
        return warehouseStatusMapper.updateWarehouseStatus(warehouseStatus);
    }

    /**
     * 批量删除库存信息
     *
     * @param warehouseIds 需要删除的库存信息主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseStatusByWarehouseIds(Long[] warehouseIds)
    {
        return warehouseStatusMapper.deleteWarehouseStatusByWarehouseIds(warehouseIds);
    }

    /**
     * 删除库存信息信息
     *
     * @param warehouseId 库存信息主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseStatusByWarehouseId(Long warehouseId)
    {
        return warehouseStatusMapper.deleteWarehouseStatusByWarehouseId(warehouseId);
    }
}
