package mybatis;

import entity.loginInfo;

public interface IloginMapper {
    public loginInfo selectLoginInfoByID(String name);
}
