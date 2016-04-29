/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendokoseikeisan;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;

/**
 * 賦課の情報Entityクラスです。
 *
 * @reamsid_L DBB-9050-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseigoFukaEntity implements Serializable {

    private DbT2015KeisangoJohoEntity 賦課情報1;
    private DbT2015KeisangoJohoEntity 賦課情報2;
    private DbT2015KeisangoJohoEntity 賦課情報3;
    private DbT2015KeisangoJohoEntity 賦課情報4;
    private DbT2015KeisangoJohoEntity 賦課情報5;
    private DbT2015KeisangoJohoEntity 賦課情報6;
}
