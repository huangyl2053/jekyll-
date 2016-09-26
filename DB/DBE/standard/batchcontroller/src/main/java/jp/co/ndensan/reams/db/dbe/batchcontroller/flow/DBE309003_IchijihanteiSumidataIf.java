/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif.IchijihanteiSumidataIfDBUpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif.IchijihanteiSumidataIfProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE309003.DBE309003_IchijihanteiSumidataIfParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 一次判定データ出力です。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
public class DBE309003_IchijihanteiSumidataIf extends BatchFlowBase<DBE309003_IchijihanteiSumidataIfParameter> {

    private static final String 一次判定済データIF = "IchijihanteiSumidataIfProcess";
    private static final String 外部連携データ抽出情報 = "IchijihanteiSumidataIfDBUpdateProcess";

    @Override
    protected void defineFlow() {
        executeStep(一次判定済データIF);
        executeStep(外部連携データ抽出情報);
    }

    /**
     * 一次判定済データIF作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(一次判定済データIF)
    protected IBatchFlowCommand createIchijihanteiSumidataIfProcess() {
        return loopBatch(IchijihanteiSumidataIfProcess.class)
                .arguments(getParameter().toIchijihanteiSumidataIftProcessParamter()).define();
    }

    /**
     * 外部連携データ抽出情報。
     *
     * @return バッチコマンド
     */
    @Step(外部連携データ抽出情報)
    protected IBatchFlowCommand createIchijihanteiSumidataIfDBUpdateProcess() {
        return loopBatch(IchijihanteiSumidataIfDBUpdateProcess.class)
                .arguments(getParameter().toIchijihanteiSumidataIftProcessParamter()).define();
    }
}
