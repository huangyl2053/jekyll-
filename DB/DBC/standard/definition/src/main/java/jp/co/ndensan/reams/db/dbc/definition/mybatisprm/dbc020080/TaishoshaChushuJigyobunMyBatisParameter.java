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
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のMyBatisパラメタークラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TaishoshaChushuJigyobunMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 抽出期間開始年月;
    private RString 年度;
    private RString 被保険者番号;
    private RString 出力対象区分;

    /**
     * DBC020080MyBatisParameterのコンストラクタです。
     *
     * @param 抽出期間開始年月 RString
     * @param 年度 RString
     * @param 被保険者番号 RString
     * @param 出力対象区分 RString
     * @param searchKey RString
     */
    public TaishoshaChushuJigyobunMyBatisParameter(
            RString 抽出期間開始年月,
            RString 年度,
            RString 被保険者番号,
            RString 出力対象区分,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.抽出期間開始年月 = 抽出期間開始年月;
        this.年度 = 年度;
        this.被保険者番号 = 被保険者番号;
        this.出力対象区分 = 出力対象区分;
    }

}
