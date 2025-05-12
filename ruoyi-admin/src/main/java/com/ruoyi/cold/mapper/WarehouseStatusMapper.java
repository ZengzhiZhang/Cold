package com.ruoyi.cold.mapper;

import com.ruoyi.cold.domain.WarehouseStatus;

import java.util.List;

/**
 * 库存信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-05-12
 */
public interface WarehouseStatusMapper
{
    /**
     * 查询库存信息
     *
     * @param warehouseId 库存信息主键
     * @return 库存信息
     */
    public WarehouseStatus selectWarehouseStatusByWarehouseId(Long warehouseId);

    /**
     * 查询库存信息列表
     *
     * @param warehouseStatus 库存信息
     * @return 库存信息集合
     */
    public List<WarehouseStatus> selectWarehouseStatusList(WarehouseStatus warehouseStatus);

    /**
     * 新增库存信息
     *
     * @param warehouseStatus 库存信息
     * @return 结果
     */
    public int insertWarehouseStatus(WarehouseStatus warehouseStatus);

    /**
     * 修改库存信息
     *
     * @param warehouseStatus 库存信息
     * @return 结果
     */
    public int updateWarehouseStatus(WarehouseStatus warehouseStatus);

    /**
     * 删除库存信息
     *
     * @param warehouseId 库存信息主键
     * @return 结果
     */
    public int deleteWarehouseStatusByWarehouseId(Long warehouseId);

    /**
     * 批量删除库存信息
     *
     * @param warehouseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarehouseStatusByWarehouseIds(Long[] warehouseIds);
}
