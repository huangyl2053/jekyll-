/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranReportProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員報酬実績集計表のバッチフロークラスです。
 *
 * @reamsid_L DBE-1700-020 wanghuafeng
 */
public class ShinsaiinJissekiIchiranFlow extends BatchFlowBase<ShinsaiinJissekiIchiranBatchParameter> {

    private static final String SHINSAI_JISSE_ICHIRAN_CSV = "shinsaiinjissekiichirancsv";
    private static final String SHINSAI_JISSE_ICHIRAN_REPORT = "shinsaiinjissekiichiranreport";
    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");

    @Override
    protected void defineFlow() {
        if (!getParameter().getKeyJoho().isEmpty()) {
            if (CSVを出力する.equals(getParameter().getSyohyoSyuturyoku())) {
                executeStep(SHINSAI_JISSE_ICHIRAN_CSV);
            } else if (集計表を発行する.equals(getParameter().getSyohyoSyuturyoku())) {
                executeStep(SHINSAI_JISSE_ICHIRAN_REPORT);
            }
        }
    }

    /**
     * 要介護認定事業状況データCSVの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(SHINSAI_JISSE_ICHIRAN_CSV)
    IBatchFlowCommand shinsaiinjissekiichiranCsv() {
        return loopBatch(ShinsaiinJissekiIchiranCsvProcess.class)
                .arguments(getParameter().toProcessParamter())
                .define();
    }

    /**
     * 要介護認定事業状況データ帳票の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(SHINSAI_JISSE_ICHIRAN_REPORT)
    IBatchFlowCommand shinsaiinjissekiichiranReport() {
        return loopBatch(ShinsaiinJissekiIchiranReportProcess.class)
                .arguments(getParameter().toProcessParamter())
                .define();
    }
}
