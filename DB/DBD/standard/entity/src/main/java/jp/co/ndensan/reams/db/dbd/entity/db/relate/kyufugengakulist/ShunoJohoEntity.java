/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;

/**
 * 収納情報のRelateEntityクラスです。
 *
 * @reamsid_L DBD-3610-050 wangchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJohoEntity {

    private DbT2002FukaEntity fukaEntity;
    private List<KibetsuJohoEntity> kibetsuJohoEntity;
}
