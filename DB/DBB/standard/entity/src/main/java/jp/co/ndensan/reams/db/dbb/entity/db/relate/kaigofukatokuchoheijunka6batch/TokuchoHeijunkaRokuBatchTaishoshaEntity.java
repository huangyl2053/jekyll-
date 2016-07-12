/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者データTempEntity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TaishoshaEntity implements Cloneable, Serializable {

    private RString 特別徴収義務者コード;
    private DbT2015KeisangoJohoEntity 計算後情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名;

    /**
     * コンストラクタです。
     */
    public TaishoshaEntity() {
        this.特別徴収義務者コード = null;
        this.計算後情報 = null;
        this.宛名 = null;
    }

    /**
     * コンストラクタです。
     *
     * @param 特別徴収義務者コード RString
     * @param 計算後情報 DbT2015KeisangoJohoEntity
     * @param 宛名 UaFt200FindShikibetsuTaishoEntity
     */
    public TaishoshaEntity(RString 特別徴収義務者コード, DbT2015KeisangoJohoEntity 計算後情報,
            UaFt200FindShikibetsuTaishoEntity 宛名) {
        this.特別徴収義務者コード = 特別徴収義務者コード;
        this.計算後情報 = 計算後情報;
        this.宛名 = 宛名;
    }
}
