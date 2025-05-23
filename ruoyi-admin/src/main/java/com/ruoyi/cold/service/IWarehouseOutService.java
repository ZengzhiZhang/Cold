package com.ruoyi.cold.service;

import java.util.List;

import com.ruoyi.cold.domain.WarehouseIn;
import com.ruoyi.cold.domain.WarehouseInWName;
import com.ruoyi.cold.domain.WarehouseOut;
import com.ruoyi.cold.domain.WarehouseOutWName;

/**
 * 出库Service接口
 * 
 * @author zzz
 * @date 2025-05-13
 */
public interface IWarehouseOutService 
{


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
     * 批量修改出库为已结算
     *
     * @param warehouseOutIds 出库
     * @return 结果
     */
    public int batchUpdateWarehouseOut2Settle(List<Integer> warehouseOutIds);
    /**
     * 修改出库
     * 
     * @param warehouseOut 出库
     * @return 结果
     */
    public int updateWarehouseOut(WarehouseOut warehouseOut);

    /**
     * 批量删除出库
     * 
     * @param warehouseOutIds 需要删除的出库主键集合
     * @return 结果
     */
    public int deleteWarehouseOutByWarehouseOutIds(Integer[] warehouseOutIds);

    /**
     * 删除出库信息
     * 
     * @param warehouseOutId 出库主键
     * @return 结果
     */
    public int deleteWarehouseOutByWarehouseOutId(Integer warehouseOutId);

    List<WarehouseOutWName> selectWarehouseInWNameList(WarehouseOut warehouseOut);
}
