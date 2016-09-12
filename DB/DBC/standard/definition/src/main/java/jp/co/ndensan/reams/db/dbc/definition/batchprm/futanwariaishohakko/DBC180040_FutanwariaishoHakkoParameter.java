/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.futanwariaishohakko;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担割合証発行（一括）のバッチパラメータクラスです。
 *
 * @reamsid_L DBC-4990-010 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC180040_FutanwariaishoHakkoParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    @BatchParameter(key = "年度", name = "年度")
    private FlexibleYear 年度;
    @BatchParameter(key = "交付年月日", name = "交付年月日")
    private RDate 交付年月日;
    @BatchParameter(key = "発行区分", name = "発行区分")
    private RString 発行区分;
    @BatchParameter(key = "出力対象", name = "出力対象")
    private RString 出力対象;
    @BatchParameter(key = "当初発行区分", name = "当初発行区分")
    private RString 当初発行区分;
    @BatchParameter(key = "抽出期間開始日時", name = "抽出期間開始日時")
    private RDateTime 抽出期間開始日時;
    @BatchParameter(key = "抽出期間終了日時", name = "抽出期間終了日時")
    private RDateTime 抽出期間終了日時;
    @BatchParameter(key = "出力順", name = "出力順")
    private RString 出力順;

}
