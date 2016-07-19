/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokubetsuchoshudoteimidoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private FlexibleYear 処理年度;
    private List<RString> 捕捉月リスト;
    private RString 特別徴収開始月;
    private RString 出力対象;
    private YMDHMS 処理日時;

    public TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter toProcessParameter() {
        return new TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter(
                処理年度, 捕捉月リスト, 特別徴収開始月, 出力対象, 処理日時
        );
    }
}
