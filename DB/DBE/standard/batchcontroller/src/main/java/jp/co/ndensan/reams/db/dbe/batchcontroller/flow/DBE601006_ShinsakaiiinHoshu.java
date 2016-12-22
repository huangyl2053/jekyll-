/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601006.ShinsaHoshuIchiranCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601006.ShinsaHoshuIchiranReportProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601006.DBE601006_ShinsakaiiinHoshuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員報酬一覧表の帳票のバッチフロークラスです。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
public class DBE601006_ShinsakaiiinHoshu extends BatchFlowBase<DBE601006_ShinsakaiiinHoshuParameter> {

    private static final String SHINSA_HOSHU_ICHIRAN_CSV = "shinsahoshuichiranCsv";
    private static final String SHINSA_HOSHU_ICHIRAN_REPORT = "shinsahoshuichiranReport";

    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");

    @Override
    protected void defineFlow() {
        if (CSVを出力する.equals(getParameter().getSyohyoSyuturyoku())) {
            executeStep(SHINSA_HOSHU_ICHIRAN_CSV);
        } else if (一覧表を発行する.equals(getParameter().getSyohyoSyuturyoku())) {
            executeStep(SHINSA_HOSHU_ICHIRAN_REPORT);
        }
    }

    /**
     * 介護認定審査会委員報酬一覧表のCSVファイル作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(SHINSA_HOSHU_ICHIRAN_CSV)
    IBatchFlowCommand shinsaHoshuIchiranCsv() {
        return loopBatch(ShinsaHoshuIchiranCsvProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護認定審査会委員報酬一覧表の帳票作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(SHINSA_HOSHU_ICHIRAN_REPORT)
    IBatchFlowCommand shinsaHoshuIchiranReport() {
        return loopBatch(ShinsaHoshuIchiranReportProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
