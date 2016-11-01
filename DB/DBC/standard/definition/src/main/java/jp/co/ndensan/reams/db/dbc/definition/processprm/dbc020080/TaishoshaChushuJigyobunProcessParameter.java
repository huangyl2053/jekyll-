/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.TaishoshaChushuJigyobunMyBatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TaishoshaChushuJigyobunProcessParameter implements IBatchProcessParameter {

    private RDateTime 処理日時;
    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;
    private RString 抽出期間開始年月;
    private RString 年度;
    private RString 被保険者番号;
    private RString 出力対象区分;

    /**
     * DBC020080ProcessParameterのコンストラクタです。
     */
    public TaishoshaChushuJigyobunProcessParameter() {
    }

    /**
     * DBC020080ProcessParameterのコンストラクタです。
     *
     * @param 処理日時 RDateTime
     * @param 抽出期間開始年月 RString
     * @param 年度 RString
     * @param 被保険者番号 RString
     * @param 出力対象区分 RString
     */
    public TaishoshaChushuJigyobunProcessParameter(
            RDateTime 処理日時,
            RString 抽出期間開始年月,
            RString 年度,
            RString 被保険者番号,
            RString 出力対象区分) {
        this.処理日時 = 処理日時;
        this.抽出期間開始年月 = 抽出期間開始年月;
        this.年度 = 年度;
        this.被保険者番号 = 被保険者番号;
        this.出力対象区分 = 出力対象区分;
    }

    /**
     * toDBC020080MyBatisParameterのコンストラクタです
     *
     * @return DBC020080MyBatisParameter
     */
    public TaishoshaChushuJigyobunMyBatisParameter toTaishoshaChushuJigyobunMyBatisParameter() {
        return new TaishoshaChushuJigyobunMyBatisParameter(抽出期間開始年月, 年度, 被保険者番号, 出力対象区分, 宛名検索条件);
    }
}
