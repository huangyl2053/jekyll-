/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.futanwariaiichiran;

import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担割合判定一覧出力（共通）のバッチパラメータです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiIchiranBatchParameter extends BatchParameterBase {

    @BatchParameter(key = "対象年度", name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = "基準日", name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = "処理区分", name = "処理区分")
    private RString 処理区分;
    @BatchParameter(key = "テストモード", name = "テストモード")
    private boolean テストモード;
    @BatchParameter(key = "年度終了年月日", name = "年度終了年月日")
    private FlexibleDate 年度終了年月日;
    @BatchParameter(key = "処理日時", name = "処理日時")
    private RDateTime 処理日時;

    /**
     * 負担割合判定一覧出力のProcessParameter作成する。
     *
     * @return FutanWariaiHanteiIchiranProcessParameter
     */
    public FutanWariaiHanteiIchiranProcessParameter toFutanWariaiHanteiIchiranProcessParameter() {
        return new FutanWariaiHanteiIchiranProcessParameter(処理区分, 対象年度, 基準日, テストモード, 処理日時);
    }
}
