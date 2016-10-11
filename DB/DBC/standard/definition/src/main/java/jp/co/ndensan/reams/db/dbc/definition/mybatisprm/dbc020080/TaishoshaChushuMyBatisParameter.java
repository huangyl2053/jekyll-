/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のMyBatisパラメタークラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TaishoshaChushuMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 申請対象日開始;
    private RString 申請対象日終了;

    /**
     * DBC020080MyBatisParameterのコンストラクタです。
     *
     * @param 申請対象日開始 RString
     * @param 申請対象日終了 RString
     * @param 宛名検索条件 IShikibetsuTaishoPSMSearchKey
     */
    public TaishoshaChushuMyBatisParameter(
            RString 申請対象日開始,
            RString 申請対象日終了,
            IShikibetsuTaishoPSMSearchKey 宛名検索条件) {
        super(宛名検索条件);
        this.申請対象日開始 = 申請対象日開始;
        this.申請対象日終了 = 申請対象日終了;
    }
}
