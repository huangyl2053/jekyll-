/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.koseitaishokyufujissekiichiran;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更正対象給付実績一覧画面で入力されたデータより、バッチ用パラメータクラスを作成する。
 *
 * @reamsid_L DBC-4960-031 dongqianjing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiTaishoKyufuJissekiIchiranBatchParameter extends BatchParameterBase {

    private FlexibleYear 年度;
    private YMDHMS 抽出期間開始日時;
    private YMDHMS 抽出期間終了日時;
    private RString 出力順ID;
}
