/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請情報IF編集(バッチ) SQLパラメータクラスです。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ModifyNinteiShinseiJohoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final RString 認定申請IF種類;
    private final LasdecCode 市町村コード;
    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;
    private boolean is市町村コード非空 = true;

    /**
     * コンストラクタ。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 認定申請IF種類 RString
     * @param 市町村コード LasdecCode
     */
    public ModifyNinteiShinseiJohoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString 認定申請IF種類, LasdecCode 市町村コード) {
        super(searchKey);
        this.市町村コード = 市町村コード;
        this.認定申請IF種類 = 認定申請IF種類;
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(searchKey);
        if (認定申請IF種類 == null || 認定申請IF種類.isEmpty()) {
            this.is市町村コード非空 = false;
        }
    }

}
