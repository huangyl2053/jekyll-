/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.itizihanteiiftorikomi;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.itizihanteiiftorikomi.ItizihanteiIFtoriKomiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.itizihanteiiftorikomi.ItizihanteiIFtoriKomiUpdateProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.itizihanteishori.ItziHanteiShoriBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBE309002_一次判定IF取込のバッチ処理クラスです。
 *
 * @reamsid_L DBE-1470-022 wanghui
 */
public class ItizihanteiIFtoriKomiFlow extends BatchFlowBase<ItziHanteiShoriBatchParamter> {

    private static final String SHINSAKAISCHEDULEKAGAMIHYO = "ItizihanteiIFtoriKomiProcess";
    private static final String HEDULEKAGAMIHYOUPDATE = "ItizihanteiIFtoriKomiUpdateProcess";

    @Override
    protected void defineFlow() {
        executeStep(SHINSAKAISCHEDULEKAGAMIHYO);
        executeStep(HEDULEKAGAMIHYOUPDATE);
    }

    /**
     * 一次判定IF取込のバッチ処理のProcessです。
     *
     * @return 一次判定IF取込
     */
    @Step(SHINSAKAISCHEDULEKAGAMIHYO)
    protected IBatchFlowCommand shinsakaiSchedulekagami() {
        return loopBatch(ItizihanteiIFtoriKomiProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 一次判定IF取込のバッチ処理の更新Processです。
     *
     * @return 一次判定IF取込
     */
    @Step(HEDULEKAGAMIHYOUPDATE)
    protected IBatchFlowCommand itizihanteiIFtoriKomiUpdateProcess() {
        return loopBatch(ItizihanteiIFtoriKomiUpdateProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }
}
