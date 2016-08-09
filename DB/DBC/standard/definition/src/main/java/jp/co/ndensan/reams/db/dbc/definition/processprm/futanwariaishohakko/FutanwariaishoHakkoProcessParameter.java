/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaishohakko.FutanwariaishoHakkoMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担割合証発行（一括）のProcessパラメータクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanwariaishoHakkoProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 年度;
    private RDate 交付年月日;
    private RString 発行区分;
    private RString 出力対象;
    private RString 当初発行区分;
    private RDateTime 抽出期間開始日時;
    private RDateTime 抽出期間終了日時;
    private RString 出力順;
    private RDateTime バッチ起動時処理日時;

    private IShikibetsuTaishoPSMSearchKey searchKey;
    private IAtesakiPSMSearchKey atesakiKey;

    /**
     * MybatisParameter取得です。
     *
     * @return {@link FutanwariaishoHakkoMybatisParameter}
     */
    public FutanwariaishoHakkoMybatisParameter toMybatisParameter() {
        return new FutanwariaishoHakkoMybatisParameter(atesakiKey, 年度, 交付年月日, 発行区分, 出力対象, 抽出期間開始日時,
                抽出期間終了日時, 出力順, searchKey);
    }
}
