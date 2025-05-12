package com.ruoyi.cold.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户信息对象 client_info
 * 
 * @author zzz
 * @date 2025-05-11
 */
public class ClientInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户ID */
    private Long clientInfoId;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String clientInfoName;

    /** 客户手机号 */
    @Excel(name = "客户手机号")
    private String clientInfoPhone;

    /** 备注 */
    @Excel(name = "备注")
    private String clientInfoRemark;

    public void setClientInfoId(Long clientInfoId) 
    {
        this.clientInfoId = clientInfoId;
    }

    public Long getClientInfoId() 
    {
        return clientInfoId;
    }

    public void setClientInfoName(String clientInfoName) 
    {
        this.clientInfoName = clientInfoName;
    }

    public String getClientInfoName() 
    {
        return clientInfoName;
    }

    public void setClientInfoPhone(String clientInfoPhone) 
    {
        this.clientInfoPhone = clientInfoPhone;
    }

    public String getClientInfoPhone() 
    {
        return clientInfoPhone;
    }

    public void setClientInfoRemark(String clientInfoRemark) 
    {
        this.clientInfoRemark = clientInfoRemark;
    }

    public String getClientInfoRemark() 
    {
        return clientInfoRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clientInfoId", getClientInfoId())
            .append("clientInfoName", getClientInfoName())
            .append("clientInfoPhone", getClientInfoPhone())
            .append("clientInfoRemark", getClientInfoRemark())
            .toString();
    }
}
