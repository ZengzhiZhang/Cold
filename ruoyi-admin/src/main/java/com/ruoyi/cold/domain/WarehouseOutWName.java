package com.ruoyi.cold.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出库对象 warehouse_out
 *
 * @author zzz
 * @date 2025-05-13
 */
public class WarehouseOutWName extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库操作ID */
    private Integer warehouseOutId;

    /** 客户 */
    @Excel(name = "客户编号")
    private Integer warehouseOutClientId;

    @Excel(name = "客户姓名")
    private String warehouseOutClientName;
    /** 品类 */
    @Excel(name = "品类")
    private String warehouseOutCategory;

    /** 库号 */
    @Excel(name = "库号")
    private Integer warehouseOutNumber;

    /** 数量 */
    @Excel(name = "数量")
    private Double warehouseOutQuantity;

    @Excel(name = "单位")
    private String warehouseOutUnit;

    /** 出货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date warehouseOutTime;

    /** 金额 */
    @Excel(name = "金额")
    private Double warehouseOutMoney;

    /** 收款方式 */
    @Excel(name = "收款方式")
    private Integer warehouseOutManner;

    @Excel(name = "结算标识")
    private Integer warehouseOutSettle;


    public void setWarehouseOutId(Integer warehouseOutId)
    {
        this.warehouseOutId = warehouseOutId;
    }

    public Integer getWarehouseOutId()
    {
        return warehouseOutId;
    }

    public void setWarehouseOutClientId(Integer warehouseOutClientId)
    {
        this.warehouseOutClientId = warehouseOutClientId;
    }

    public Integer getWarehouseOutClientId()
    {
        return warehouseOutClientId;
    }

    public void setWarehouseOutClientName(String warehouseOutClientName){ this.warehouseOutClientName = warehouseOutClientName; }

    public String getWarehouseOutClientName() { return warehouseOutClientName; }

    public void setWarehouseOutCategory(String warehouseOutCategory)
    {
        this.warehouseOutCategory = warehouseOutCategory;
    }

    public String getWarehouseOutCategory()
    {
        return warehouseOutCategory;
    }

    public void setWarehouseOutNumber(Integer warehouseOutNumber)
    {
        this.warehouseOutNumber = warehouseOutNumber;
    }

    public Integer getWarehouseOutNumber()
    {
        return warehouseOutNumber;
    }

    public void setWarehouseOutQuantity(Double warehouseOutQuantity)
    {
        this.warehouseOutQuantity = warehouseOutQuantity;
    }

    public Double getWarehouseOutQuantity()
    {
        return warehouseOutQuantity;
    }

    public void setWarehouseOutUnit(String warehouseOutUnit) {this.warehouseOutUnit = warehouseOutUnit;}

    public String getWarehouseOutUnit () {return warehouseOutUnit;}

    public void setWarehouseOutTime(Date warehouseOutTime)
    {
        this.warehouseOutTime = warehouseOutTime;
    }

    public Date getWarehouseOutTime()
    {
        return warehouseOutTime;
    }

    public void setWarehouseOutMoney(Double warehouseOutMoney)
    {
        this.warehouseOutMoney = warehouseOutMoney;
    }

    public Double getWarehouseOutMoney()
    {
        return warehouseOutMoney;
    }

    public void setWarehouseOutManner(Integer warehouseOutManner)
    {
        this.warehouseOutManner = warehouseOutManner;
    }

    public Integer getWarehouseOutManner()
    {
        return warehouseOutManner;
    }

    public void setWarehouseOutSettle(Integer warehouseOutSettle) {this.warehouseOutSettle = warehouseOutSettle;}

    public Integer getWarehouseOutSettle() {
        return warehouseOutSettle;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("warehouseOutId", getWarehouseOutId())
                .append("warehouseOutClientId", getWarehouseOutClientId())
                .append("warehouseOutClientName", getWarehouseOutClientName())
                .append("warehouseOutCategory", getWarehouseOutCategory())
                .append("warehouseOutNumber", getWarehouseOutNumber())
                .append("warehouseOutQuantity", getWarehouseOutQuantity())
                .append("warehouseOutUnit", getWarehouseOutUnit())
                .append("warehouseOutTime", getWarehouseOutTime())
                .append("warehouseOutMoney", getWarehouseOutMoney())
                .append("warehouseOutManner", getWarehouseOutManner())
                .append("warehouseOutSettle", getWarehouseOutSettle())
                .toString();
    }
}
