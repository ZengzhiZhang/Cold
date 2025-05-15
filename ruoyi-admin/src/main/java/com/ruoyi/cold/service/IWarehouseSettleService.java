package com.ruoyi.cold.service;

import java.util.List;

import com.ruoyi.cold.domain.WarehouseOutWName;
import com.ruoyi.cold.domain.WarehouseSettle;
import com.ruoyi.cold.domain.WarehouseSettleWName;

/**
 * 结算Service接口
 * 
 * @author zzz
 * @date 2025-05-15
 */
public interface IWarehouseSettleService 
{
    /**
     * 查询结算
     * 
     * @param warehouseSettleId 结算主键
     * @return 结算
     */
    public WarehouseSettle selectWarehouseSettleByWarehouseSettleId(Integer warehouseSettleId);

    /**
     * 查询结算列表
     * 
     * @param warehouseSettle 结算
     * @return 结算集合
     */
    public List<WarehouseSettle> selectWarehouseSettleList(WarehouseSettle warehouseSettle);

    /**
     * 新增结算
     * 
     * @param warehouseSettle 结算
     * @return 结果
     */
    public int insertWarehouseSettle(WarehouseSettle warehouseSettle);

    /**
     * 修改结算
     * 
     * @param warehouseSettle 结算
     * @return 结果
     */
    public int updateWarehouseSettle(WarehouseSettle warehouseSettle);

    /**
     * 批量删除结算
     * 
     * @param warehouseSettleIds 需要删除的结算主键集合
     * @return 结果
     */
    public int deleteWarehouseSettleByWarehouseSettleIds(Integer[] warehouseSettleIds);

    /**
     * 删除结算信息
     * 
     * @param warehouseSettleId 结算主键
     * @return 结果
     */
    public int deleteWarehouseSettleByWarehouseSettleId(Integer warehouseSettleId);



    List<WarehouseSettleWName> selectWarehouseSettleWNameList(WarehouseSettle warehouseSettle);
}
