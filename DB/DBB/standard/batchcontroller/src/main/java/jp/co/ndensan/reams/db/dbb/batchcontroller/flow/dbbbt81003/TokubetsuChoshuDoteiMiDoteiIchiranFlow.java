/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbbbt81003;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt81003.TokubetsuChoshuDoteiIchiranOutputProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt81003.TokubetsuChoshuMidoteiIchiranOutputProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収同定・未同定一覧表バッチフロークラスです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
public class TokubetsuChoshuDoteiMiDoteiIchiranFlow extends BatchFlowBase<TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter> {

    private static final String 特別徴収同定一覧表 = "TokubetsuChoshuDoteiIchiran";
    private static final String 特別徴収未同定一覧表 = "TokubetsuChoshuMidoteiIchiran";
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    @Override
    protected void defineFlow() {
        if (ONE.equals(getParameter().get出力対象()) || ZERO.equals(getParameter().get出力対象())) {
            executeStep(特別徴収同定一覧表);
        }
        if (TWO.equals(getParameter().get出力対象()) || ZERO.equals(getParameter().get出力対象())) {
            executeStep(特別徴収未同定一覧表);
        }
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(特別徴収同定一覧表)
    protected IBatchFlowCommand createReport1() {
        return simpleBatch(TokubetsuChoshuDoteiIchiranOutputProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(特別徴収未同定一覧表)
    protected IBatchFlowCommand createReport2() {
        return simpleBatch(TokubetsuChoshuMidoteiIchiranOutputProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }

}
