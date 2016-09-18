/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;

/**
 * 賦課NewestのRelateEntityクラスです。
 *
 * @reamsid_L DBD-3610-050 wangchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KibetsuJohoEntity {

    private DbT2003KibetsuEntity kibetsuEntity;
    private UrT0705ChoteiKyotsuEntity choteiKyotsuEntity;
    private List<DbT4023JikoKisambiKanriEntity> jikoKisambiKanriEntity;
}
