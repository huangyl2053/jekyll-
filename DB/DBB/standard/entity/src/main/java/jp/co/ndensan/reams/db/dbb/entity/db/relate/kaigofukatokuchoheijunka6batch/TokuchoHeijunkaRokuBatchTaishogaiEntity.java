/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
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
public final class TokuchoHeijunkaRokuBatchTaishogaiEntity implements Cloneable, Serializable {

    private RString 特別徴収義務者コード;
    private RString 徴収方法Newest_仮徴収_年金コード;
    private RString 備考コード;
    private FukaJohoRelateEntity 対象外データTemp;
    private UaFt200FindShikibetsuTaishoEntity 宛名;

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunkaRokuBatchTaishogaiEntity() {
        this.特別徴収義務者コード = null;
        this.対象外データTemp = null;
        this.宛名 = null;
        this.徴収方法Newest_仮徴収_年金コード = null;
        this.備考コード = null;
    }

    /**
     * コンストラクタです。
     *
     * @param 特別徴収義務者コード RString
     * @param 対象外データTemp FukaJohoRelateEntity
     * @param 宛名 UaFt200FindShikibetsuTaishoEntity
     * @param 徴収方法Newest_仮徴収_年金コード RString
     * @param 備考コード RString
     */
    public TokuchoHeijunkaRokuBatchTaishogaiEntity(RString 特別徴収義務者コード, FukaJohoRelateEntity 対象外データTemp,
            UaFt200FindShikibetsuTaishoEntity 宛名, RString 徴収方法Newest_仮徴収_年金コード, RString 備考コード) {
        this.特別徴収義務者コード = 特別徴収義務者コード;
        this.対象外データTemp = 対象外データTemp;
        this.宛名 = 宛名;
        this.徴収方法Newest_仮徴収_年金コード = 徴収方法Newest_仮徴収_年金コード;
        this.備考コード = 備考コード;
    }
}
