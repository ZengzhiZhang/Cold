package com.ruoyi.cold.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 结算对象 warehouse_settle
 * 
 * @author zzz
 * @date 2025-05-15
 */
public class WarehouseSettle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 结算ID */
    private Integer warehouseSettleId;

    /** 客户 */
    @Excel(name = "客户")
    private Integer warehouseSettleClientId;

    /** 品类 */
    @Excel(name = "品类")
    private String warehouseSettleCategory;

    /** 单位 */
    @Excel(name = "单位")
    private String warehouseSettleUnit;

    /** 总件数 */
    @Excel(name = "总件数")
    private Double warehouseSettleQuantity;

    /** 总库费 */
    @Excel(name = "总库费")
    private Double warehouseSettleMoneyKu;

    /** 总收费 */
    @Excel(name = "总收费")
    private Double warehouseSettleMoneyShou;

    public void setWarehouseSettleId(Integer warehouseSettleId) 
    {
        this.warehouseSettleId = warehouseSettleId;
    }

    public Integer getWarehouseSettleId() 
    {
        return warehouseSettleId;
    }

    public void setWarehouseSettleClientId(Integer warehouseSettleClientId) 
    {
        this.warehouseSettleClientId = warehouseSettleClientId;
    }

    public Integer getWarehouseSettleClientId() 
    {
        return warehouseSettleClientId;
    }

    public void setWarehouseSettleCategory(String warehouseSettleCategory)
    {
        this.warehouseSettleCategory = warehouseSettleCategory;
    }

    public String getWarehouseSettleCategory()
    {
        return warehouseSettleCategory;
    }

    public void setWarehouseSettleUnit(String warehouseSettleUnit)
    {
        this.warehouseSettleUnit = warehouseSettleUnit;
    }

    public String getWarehouseSettleUnit()
    {
        return warehouseSettleUnit;
    }

    public void setWarehouseSettleQuantity(Double warehouseSettleQuantity) 
    {
        this.warehouseSettleQuantity = warehouseSettleQuantity;
    }

    public Double getWarehouseSettleQuantity() 
    {
        return warehouseSettleQuantity;
    }

    public void setWarehouseSettleMoneyKu(Double warehouseSettleMoneyKu) 
    {
        this.warehouseSettleMoneyKu = warehouseSettleMoneyKu;
    }

    public Double getWarehouseSettleMoneyKu() 
    {
        return warehouseSettleMoneyKu;
    }

    public void setWarehouseSettleMoneyShou(Double warehouseSettleMoneyShou) 
    {
        this.warehouseSettleMoneyShou = warehouseSettleMoneyShou;
    }

    public Double getWarehouseSettleMoneyShou() 
    {
        return warehouseSettleMoneyShou;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("warehouseSettleId", getWarehouseSettleId())
            .append("warehouseSettleClientId", getWarehouseSettleClientId())
            .append("warehouseSettleCategory", getWarehouseSettleCategory())
            .append("warehouseSettleUnit", getWarehouseSettleUnit())
            .append("warehouseSettleQuantity", getWarehouseSettleQuantity())
            .append("warehouseSettleMoneyKu", getWarehouseSettleMoneyKu())
            .append("warehouseSettleMoneyShou", getWarehouseSettleMoneyShou())
            .toString();
    }
}
