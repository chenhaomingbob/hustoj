package com.zjgsu.service.common;

import com.zjgsu.dao.zjgsu.ExceptionDao;
import com.zjgsu.entity.zjgsu.ExceptionEntity;
import com.zjgsu.util.JudgeCenterConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author chm 神魔法
 * @date 2019/6/4 12:57
 */
@Service
public class CommonService {
    /**
     * 自定义的初始化
     *
     * @throws UnknownHostException host异常
     * @throws SocketException      端口的异常
     */
    @PostConstruct
    public void init() throws UnknownHostException, SocketException {
        InetAddress addr = InetAddress.getLocalHost();
        JudgeCenterConstant.HOST_NAME = addr.getHostName();
        JudgeCenterConstant.HOST_IP = this.getAddress();
    }

    /**
     * 保存异常信息
     *
     * @param event       信息的事件
     * @param description 信息的内容
     */
    public void saveErrorRecord(String event, String description) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setEvent(event);
        exceptionEntity.setDescription(description);
        exceptionEntity.setStatus(1);
        exceptionDao.save(exceptionEntity);
    }

    /**
     * 获取主机ip （获取网卡会不会更好？）
     *
     * @return 主机ip
     * @throws SocketException 端口异常
     */
    private String getAddress() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip;
        // 遍历每个网卡，拿到ip
        String hostAddress = null;
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface ni = networkInterfaces.nextElement();
            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = addresses.nextElement();
                if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(':') == -1) {
                    String name = ni.getName();
                    if (name.indexOf("wlan") == 0) {
                        return ip.getHostAddress();
                    } else if (name.indexOf("eth") == 0) {
                        return ip.getHostAddress();
                    }
                    hostAddress = ip.getHostAddress();
                }
            }
        }
        return hostAddress;
    }

    @Autowired
    private ExceptionDao exceptionDao;

}
