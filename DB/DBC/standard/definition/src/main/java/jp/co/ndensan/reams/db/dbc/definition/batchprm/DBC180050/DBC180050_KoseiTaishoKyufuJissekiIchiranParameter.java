/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180050;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更正対象給付実績一覧画面で入力されたデータより、バッチ用パラメータクラスを作成する。
 *
 * @reamsid_L DBC-4960-031 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC180050_KoseiTaishoKyufuJissekiIchiranParameter extends BatchParameterBase {

    private static final String NENDO = "年度";
    private static final String CHUSHUTUKIKAN_KAISHIHIJI = "抽出期間開始日時";
    private static final String CHUSHUTUKIKAN_SYURYOHIJI = "抽出期間終了日時";
    private static final String SHUTURYO_KUJUN = "出力順ID";

    @BatchParameter(key = NENDO, name = "年度")
    private FlexibleYear 年度;
    @BatchParameter(key = CHUSHUTUKIKAN_KAISHIHIJI, name = "抽出期間開始日時")
    private YMDHMS 抽出期間開始日時;
    @BatchParameter(key = CHUSHUTUKIKAN_SYURYOHIJI, name = "抽出期間終了日時")
    private YMDHMS 抽出期間終了日時;
    @BatchParameter(key = SHUTURYO_KUJUN, name = "出力順ID")
    private RString 出力順ID;

}
