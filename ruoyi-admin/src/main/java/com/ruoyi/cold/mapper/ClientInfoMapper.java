package com.ruoyi.cold.mapper;

import java.util.List;
import com.ruoyi.cold.domain.ClientInfo;

/**
 * 客户信息Mapper接口
 * 
 * @author zzz
 * @date 2025-05-11
 */
public interface ClientInfoMapper 
{
    /**
     * 查询客户信息
     * 
     * @param clientInfoId 客户信息主键
     * @return 客户信息
     */
    public ClientInfo selectClientInfoByClientInfoId(Long clientInfoId);

    /**
     * 查询客户信息列表
     * 
     * @param clientInfo 客户信息
     * @return 客户信息集合
     */
    public List<ClientInfo> selectClientInfoList(ClientInfo clientInfo);

    /**
     * 新增客户信息
     * 
     * @param clientInfo 客户信息
     * @return 结果
     */
    public int insertClientInfo(ClientInfo clientInfo);

    /**
     * 修改客户信息
     * 
     * @param clientInfo 客户信息
     * @return 结果
     */
    public int updateClientInfo(ClientInfo clientInfo);

    /**
     * 删除客户信息
     * 
     * @param clientInfoId 客户信息主键
     * @return 结果
     */
    public int deleteClientInfoByClientInfoId(Long clientInfoId);

    /**
     * 批量删除客户信息
     * 
     * @param clientInfoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClientInfoByClientInfoIds(Long[] clientInfoIds);

    List<ClientInfo> selectClientsByIds(List<Integer> clientIds);
}
