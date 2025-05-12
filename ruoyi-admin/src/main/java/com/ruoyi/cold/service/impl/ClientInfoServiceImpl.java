package com.ruoyi.cold.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cold.mapper.ClientInfoMapper;
import com.ruoyi.cold.domain.ClientInfo;
import com.ruoyi.cold.service.IClientInfoService;

/**
 * 客户信息Service业务层处理
 * 
 * @author zzz
 * @date 2025-05-11
 */
@Service
public class ClientInfoServiceImpl implements IClientInfoService 
{
    @Autowired
    private ClientInfoMapper clientInfoMapper;

    /**
     * 查询客户信息
     * 
     * @param clientInfoId 客户信息主键
     * @return 客户信息
     */
    @Override
    public ClientInfo selectClientInfoByClientInfoId(Long clientInfoId)
    {
        return clientInfoMapper.selectClientInfoByClientInfoId(clientInfoId);
    }

    /**
     * 查询客户信息列表
     * 
     * @param clientInfo 客户信息
     * @return 客户信息
     */
    @Override
    public List<ClientInfo> selectClientInfoList(ClientInfo clientInfo)
    {
        return clientInfoMapper.selectClientInfoList(clientInfo);
    }

    /**
     * 新增客户信息
     * 
     * @param clientInfo 客户信息
     * @return 结果
     */
    @Override
    public int insertClientInfo(ClientInfo clientInfo)
    {
        return clientInfoMapper.insertClientInfo(clientInfo);
    }

    /**
     * 修改客户信息
     * 
     * @param clientInfo 客户信息
     * @return 结果
     */
    @Override
    public int updateClientInfo(ClientInfo clientInfo)
    {
        return clientInfoMapper.updateClientInfo(clientInfo);
    }

    /**
     * 批量删除客户信息
     * 
     * @param clientInfoIds 需要删除的客户信息主键
     * @return 结果
     */
    @Override
    public int deleteClientInfoByClientInfoIds(Long[] clientInfoIds)
    {
        return clientInfoMapper.deleteClientInfoByClientInfoIds(clientInfoIds);
    }

    /**
     * 删除客户信息信息
     * 
     * @param clientInfoId 客户信息主键
     * @return 结果
     */
    @Override
    public int deleteClientInfoByClientInfoId(Long clientInfoId)
    {
        return clientInfoMapper.deleteClientInfoByClientInfoId(clientInfoId);
    }
}
