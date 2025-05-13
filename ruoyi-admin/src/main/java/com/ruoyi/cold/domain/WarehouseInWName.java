package com.ruoyi.cold.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class WarehouseInWName extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 入库操作ID */
    private Integer warehouseInId;

    private String warehouseInClientName;

    /** 客户 */
    @Excel(name = "客户")
    private Integer warehouseInClient;

    /** 品类 */
    @Excel(name = "品类")
    private String warehouseInCategory;

    /** 数量 */
    @Excel(name = "数量")
    private Long warehouseInQuantity;

    /** 单位 */
    @Excel(name = "单位")
    private String warehouseInUnit;

    /** 价格 */
    @Excel(name = "价格")
    private Long warehouseInPrice;

    /** 库号 */
    @Excel(name = "库号")
    private Long warehouseInNumber;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date warehouseInTime;

    /** 结算标识 */
    @Excel(name = "结算标识")
    private Integer warehouseInSettle;

    /** 入库完成标识 */
    @Excel(name = "入库完成标识")
    private Integer warehouseInFinish;

    public void setWarehouseInId(Integer warehouseInId)
    {
        this.warehouseInId = warehouseInId;
    }

    public Integer getWarehouseInId()
    {
        return warehouseInId;
    }

    public void setWarehouseInClientName(String warehouseInClientName){ this.warehouseInClientName = warehouseInClientName; }

    public String getWarehouseInClientName() { return warehouseInClientName; }

    public void setWarehouseInClient(Integer warehouseInClient)
    {
        this.warehouseInClient = warehouseInClient;
    }

    public Integer getWarehouseInClient()
    {
        return warehouseInClient;
    }

    public void setWarehouseInCategory(String warehouseInCategory)
    {
        this.warehouseInCategory = warehouseInCategory;
    }

    public String getWarehouseInCategory()
    {
        return warehouseInCategory;
    }

    public void setWarehouseInQuantity(Long warehouseInQuantity)
    {
        this.warehouseInQuantity = warehouseInQuantity;
    }

    public Long getWarehouseInQuantity()
    {
        return warehouseInQuantity;
    }

    public void setWarehouseInUnit(String warehouseInUnit)
    {
        this.warehouseInUnit = warehouseInUnit;
    }

    public String getWarehouseInUnit()
    {
        return warehouseInUnit;
    }

    public void setWarehouseInPrice(Long warehouseInPrice)
    {
        this.warehouseInPrice = warehouseInPrice;
    }

    public Long getWarehouseInPrice()
    {
        return warehouseInPrice;
    }

    public void setWarehouseInNumber(Long warehouseInNumber)
    {
        this.warehouseInNumber = warehouseInNumber;
    }

    public Long getWarehouseInNumber()
    {
        return warehouseInNumber;
    }

    public void setWarehouseInTime(Date warehouseInTime)
    {
        this.warehouseInTime = warehouseInTime;
    }

    public Date getWarehouseInTime()
    {
        return warehouseInTime;
    }

    public void setWarehouseInSettle(Integer warehouseInSettle)
    {
        this.warehouseInSettle = warehouseInSettle;
    }

    public Integer getWarehouseInSettle()
    {
        return warehouseInSettle;
    }

    public void setWarehouseInFinish(Integer warehouseInFinish)
    {
        this.warehouseInFinish = warehouseInFinish;
    }

    public Integer getWarehouseInFinish()
    {
        return warehouseInFinish;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("warehouseInId", getWarehouseInId())
                .append("warehouseInClientName", getWarehouseInClientName())
                .append("warehouseInClient", getWarehouseInClient())
                .append("warehouseInCategory", getWarehouseInCategory())
                .append("warehouseInQuantity", getWarehouseInQuantity())
                .append("warehouseInUnit", getWarehouseInUnit())
                .append("warehouseInPrice", getWarehouseInPrice())
                .append("warehouseInNumber", getWarehouseInNumber())
                .append("warehouseInTime", getWarehouseInTime())
                .append("warehouseInSettle", getWarehouseInSettle())
                .append("warehouseInFinish", getWarehouseInFinish())
                .toString();
    }
}
