package com.ruoyi.cold.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存信息对象 warehouse_status
 *
 * @author ruoyi
 * @date 2025-05-12
 */
public class WarehouseStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long warehouseId;

    /** 品类 */
    @Excel(name = "品类")
    private String category;

    /** 库号 */
    @Excel(name = "库号")
    private Integer wareNumber;

    /** 数量 */
    @Excel(name = "数量")
    private Integer inventory;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 客户id */
    @Excel(name = "客户id")
    private Long clientId;

    public void setWarehouseId(Long warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId()
    {
        return warehouseId;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }

    public void setWareNumber(Integer wareNumber)
    {
        this.wareNumber = wareNumber;
    }

    public Integer getWareNumber()
    {
        return wareNumber;
    }

    public void setInventory(Integer inventory)
    {
        this.inventory = inventory;
    }

    public Integer getInventory()
    {
        return inventory;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setClientId(Long clientId)
    {
        this.clientId = clientId;
    }

    public Long getClientId()
    {
        return clientId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("warehouseId", getWarehouseId())
                .append("category", getCategory())
                .append("wareNumber", getWareNumber())
                .append("inventory", getInventory())
                .append("unit", getUnit())
                .append("remark", getRemark())
                .append("clientId", getClientId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
