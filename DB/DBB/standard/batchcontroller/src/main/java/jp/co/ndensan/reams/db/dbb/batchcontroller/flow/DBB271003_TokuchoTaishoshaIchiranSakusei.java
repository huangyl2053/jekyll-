/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB271003.PrtTokuchoDoteiIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB271003.PrtTokuchoMidoteiIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB271003.DBB271003_TokuchoTaishoshaIchiranSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収同定・未同定一覧表バッチフロークラスです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
public class DBB271003_TokuchoTaishoshaIchiranSakusei extends BatchFlowBase<DBB271003_TokuchoTaishoshaIchiranSakuseiParameter> {

    private static final String 特別徴収同定一覧表 = "TokubetsuChoshuDoteiIchiran";
    private static final String 特別徴収未同定一覧表 = "TokubetsuChoshuMidoteiIchiran";
    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");

    @Override
    protected void defineFlow() {
        if (定数_1.equals(getParameter().getShuturyokuTaisho()) || 定数_0.equals(getParameter().getShuturyokuTaisho())) {
            executeStep(特別徴収同定一覧表);
        }
        if (定数_2.equals(getParameter().getShuturyokuTaisho()) || 定数_0.equals(getParameter().getShuturyokuTaisho())) {
            executeStep(特別徴収未同定一覧表);
        }
    }

    @Step(特別徴収同定一覧表)
    IBatchFlowCommand createReport1() {
        return loopBatch(PrtTokuchoDoteiIchiranhyoProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }

    @Step(特別徴収未同定一覧表)
    IBatchFlowCommand createReport2() {
        return loopBatch(PrtTokuchoMidoteiIchiranhyoProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }

}
