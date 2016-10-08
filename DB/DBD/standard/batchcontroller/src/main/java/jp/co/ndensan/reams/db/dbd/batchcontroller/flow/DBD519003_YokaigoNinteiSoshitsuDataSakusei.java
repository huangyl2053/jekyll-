/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519003.ShinsaHanteiIraiIchiranhyoCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519003.ShinsaHanteiIraiIchiranhyoProcess;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失（死亡）データ作成フロークラスです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public class DBD519003_YokaigoNinteiSoshitsuDataSakusei extends
        BatchFlowBase<jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519003.DBD519003_YokaigoNinteiSoshitsuDataSakusei> {

    private static final RString 印刷する = new RString("1");
    private static final String 資格喪失情報PROCESSを実行 = "資格喪失情報PROCESSを実行";
    private static final String 資格喪失情報CSVPROCESSを実行 = "資格喪失情報CSVPROCESSを実行";

    @Override
    protected void defineFlow() {
        if (印刷する.equals(getParameter().toRenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter().getHanteiiraiichiranhyou())) {
            executeStep(資格喪失情報PROCESSを実行);
        }
        executeStep(資格喪失情報CSVPROCESSを実行);
    }

    /**
     * 資格喪失Entity情報を取得作成です。
     *
     * @return IBatchFlowCommand
     */
    @Step(資格喪失情報PROCESSを実行)
    protected IBatchFlowCommand shikakusoushitsuShibouJohyoProcess() {
        return loopBatch(ShinsaHanteiIraiIchiranhyoProcess.class)
                .arguments(getParameter().toRenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter())
                .define();
    }

    /**
     * 資格喪失Entity情報を取得作成です。
     *
     * @return IBatchFlowCommand
     */
    @Step(資格喪失情報CSVPROCESSを実行)
    protected IBatchFlowCommand shikakusoushitsuShibouJohyoCsvProcess() {
        return loopBatch(ShinsaHanteiIraiIchiranhyoCsvProcess.class)
                .arguments(getParameter().toRenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter())
                .define();
    }

}
