package com.ruoyi.cold.mapper;

import java.util.List;

import com.ruoyi.cold.domain.WarehouseIn;
import com.ruoyi.cold.domain.WarehouseInWName;
import com.ruoyi.cold.domain.WarehouseOut;
import com.ruoyi.cold.domain.WarehouseOutWName;

/**
 * 出库Mapper接口
 * 
 * @author zzz
 * @date 2025-05-13
 */
public interface WarehouseOutMapper 
{

    public List<WarehouseOutWName> selectWarehouseOutWNameList(WarehouseOut warehouseOut);
    /**
     * 查询出库
     * 
     * @param warehouseOutId 出库主键
     * @return 出库
     */
    public WarehouseOut selectWarehouseOutByWarehouseOutId(Integer warehouseOutId);

    /**
     * 查询出库列表
     * 
     * @param warehouseOut 出库
     * @return 出库集合
     */
    public List<WarehouseOut> selectWarehouseOutList(WarehouseOut warehouseOut);

    /**
     * 新增出库
     * 
     * @param warehouseOut 出库
     * @return 结果
     */
    public int insertWarehouseOut(WarehouseOut warehouseOut);

    /**
     * 修改出库
     * 
     * @param warehouseOut 出库
     * @return 结果
     */
    public int updateWarehouseOut(WarehouseOut warehouseOut);

    /**
     * 删除出库
     * 
     * @param warehouseOutId 出库主键
     * @return 结果
     */
    public int deleteWarehouseOutByWarehouseOutId(Integer warehouseOutId);

    /**
     * 批量删除出库
     * 
     * @param warehouseOutIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarehouseOutByWarehouseOutIds(Integer[] warehouseOutIds);

    int batchUpdateOut2Settle(List<Integer> warehouseOutIds);
}
