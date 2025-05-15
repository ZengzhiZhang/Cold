package com.ruoyi.cold.mapper;

import java.util.List;
import com.ruoyi.cold.domain.WarehouseSettle;
import com.ruoyi.cold.domain.WarehouseSettleWName;

/**
 * 结算Mapper接口
 * 
 * @author zzz
 * @date 2025-05-15
 */
public interface WarehouseSettleMapper 
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
     * 删除结算
     * 
     * @param warehouseSettleId 结算主键
     * @return 结果
     */
    public int deleteWarehouseSettleByWarehouseSettleId(Integer warehouseSettleId);

    /**
     * 批量删除结算
     * 
     * @param warehouseSettleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarehouseSettleByWarehouseSettleIds(Integer[] warehouseSettleIds);

    List<WarehouseSettleWName> selectWarehouseSettleWNameList(WarehouseSettle warehouseSettle);
}
