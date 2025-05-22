package com.ruoyi.cold.mapper;

import java.util.List;
import com.ruoyi.cold.domain.WarehouseIn;
import com.ruoyi.cold.domain.WarehouseInWName;

/**
 * 入库Mapper接口
 * 
 * @author zzz
 * @date 2025-05-12
 */
public interface WarehouseInMapper 
{

    public List<WarehouseInWName> selectWarehouseInWNameList(WarehouseIn warehouseIn);
    /**
     * 查询入库
     * 
     * @param warehouseInId 入库主键
     * @return 入库
     */
    public WarehouseIn selectWarehouseInByWarehouseInId(Integer warehouseInId);

    /**
     * 查询入库列表
     * 
     * @param warehouseIn 入库
     * @return 入库集合
     */
    public List<WarehouseIn> selectWarehouseInList(WarehouseIn warehouseIn);

    /**
     * 新增入库
     * 
     * @param warehouseIn 入库
     * @return 结果
     */
    public int insertWarehouseIn(WarehouseIn warehouseIn);

    /**
     * 修改入库
     * 
     * @param warehouseIn 入库
     * @return 结果
     */
    public int updateWarehouseIn(WarehouseIn warehouseIn);

    /**
     * 删除入库
     * 
     * @param warehouseInId 入库主键
     * @return 结果
     */
    public int deleteWarehouseInByWarehouseInId(Integer warehouseInId);

    /**
     * 批量删除入库
     * 
     * @param warehouseInIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarehouseInByWarehouseInIds(Integer[] warehouseInIds);

    List<Integer> selectUnfinishByClientId(WarehouseIn warehouseIn);

    int updateWarehouseInFinishByIds(List<Integer> warehouseInIds);

    int batchUpdateWarehouseIn2Settle(List<Integer> inIds);
}
