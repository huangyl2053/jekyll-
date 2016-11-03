/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu;

import java.io.Serializable;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者データTempEntity
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchoHeijunkaRokuBatchTaishogaiHachiEntity implements Cloneable, Serializable {

    private RString 特別徴収義務者コード;
    private RString 徴収方法Newest_仮徴収_年金コード;
    private RString 備考コード;
    private FukaJohoTmpHachiEntity 対象外データTemp;
    private UaFt200FindShikibetsuTaishoEntity 宛名;

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunkaRokuBatchTaishogaiHachiEntity() {
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
     * @param 対象外データTemp FukaJohoTmpHachiEntity
     * @param 宛名 UaFt200FindShikibetsuTaishoEntity
     * @param 徴収方法Newest_仮徴収_年金コード RString
     * @param 備考コード RString
     */
    public TokuchoHeijunkaRokuBatchTaishogaiHachiEntity(RString 特別徴収義務者コード, FukaJohoTmpHachiEntity 対象外データTemp,
            UaFt200FindShikibetsuTaishoEntity 宛名, RString 徴収方法Newest_仮徴収_年金コード, RString 備考コード) {
        this.特別徴収義務者コード = 特別徴収義務者コード;
        this.対象外データTemp = 対象外データTemp;
        this.宛名 = 宛名;
        this.徴収方法Newest_仮徴収_年金コード = 徴収方法Newest_仮徴収_年金コード;
        this.備考コード = 備考コード;
    }
}
