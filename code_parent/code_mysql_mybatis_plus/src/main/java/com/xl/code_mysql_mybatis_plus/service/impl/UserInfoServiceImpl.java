package com.xl.code_mysql_mybatis_plus.service.impl;

import com.xl.code_mysql_mybatis_plus.entity.UserInfo;
import com.xl.code_mysql_mybatis_plus.dao.UserInfoMapper;
import com.xl.code_mysql_mybatis_plus.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wxl
 * @since 2020-12-03
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
