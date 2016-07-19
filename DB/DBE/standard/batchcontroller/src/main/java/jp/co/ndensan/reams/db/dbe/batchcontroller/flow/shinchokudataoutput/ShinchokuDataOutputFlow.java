/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shinchokudataoutput;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinchokudataoutput.NinteichosahyoChosaItemSkuseyiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinchokudataoutput.NinteichosahyoServiceJokyoSkuseyiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinchokudataoutput.ShinchokuDataOutputEucCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinchokudataoutput.ShujiiIkenshoJohoSkuseyiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinchokudataoutput.ZenkaiChosaGaikyouChousaJokyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinchokudataoutput.ZenkaiNinteichosahyoChosaItemProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinchokudataoutput.ShinchokuDataOutputBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBE491001_日次進捗データ作成のバッチフロークラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
public class ShinchokuDataOutputFlow extends BatchFlowBase<ShinchokuDataOutputBatchParamter> {

    private static final String 調査票概況調査サービスの状況 = "NinteichosahyoServiceJokyoSkuseyiProcess";
    private static final String 認定調査票基本調査調査項目 = "NinteichosahyoChosaItemSkuseyiProcess";
    private static final String 要介護認定主治医意見書意見項目 = "ShujiiIkenshoJohoSkuseyiProcess";
    private static final String 前回調査票概況調査サービスの状況 = "ZenkaiChosaGaikyouChousaJokyoProcess";
    private static final String 前回認定調査票基本調査調査項目 = "ZenkaiNinteichosahyoChosaItemProcess";
    private static final String 日次進捗データ作成 = "ShinchokuDataOutputEucCsvProcess";

    @Override
    protected void defineFlow() {
        executeStep(調査票概況調査サービスの状況);
        executeStep(認定調査票基本調査調査項目);
        executeStep(要介護認定主治医意見書意見項目);
        executeStep(前回調査票概況調査サービスの状況);
        executeStep(前回認定調査票基本調査調査項目);
        executeStep(日次進捗データ作成);
    }

    /**
     * 調査票概況調査サービスの状況一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(調査票概況調査サービスの状況)
    protected IBatchFlowCommand createNinteichosahyoServiceJokyoSkuseyiProcess() {
        return loopBatch(NinteichosahyoServiceJokyoSkuseyiProcess.class)
                .arguments(getParameter().toShinchokuDataOutputProcessParamter()).define();
    }

    /**
     * 認定調査票基本調査調査項目一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票基本調査調査項目)
    protected IBatchFlowCommand createNinteichosahyoChosaItemSkuseyiProcess() {
        return loopBatch(NinteichosahyoChosaItemSkuseyiProcess.class)
                .arguments(getParameter().toShinchokuDataOutputProcessParamter()).define();
    }

    /**
     * 要介護認定主治医意見書意見項目一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(要介護認定主治医意見書意見項目)
    protected IBatchFlowCommand createShujiiIkenshoJohoSkuseyiProcess() {
        return loopBatch(ShujiiIkenshoJohoSkuseyiProcess.class)
                .arguments(getParameter().toShinchokuDataOutputProcessParamter()).define();
    }

    /**
     * 前回調査票概況調査サービスの状況一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(前回調査票概況調査サービスの状況)
    protected IBatchFlowCommand createZenkaiChosaGaikyouChousaJokyoProcess() {
        return loopBatch(ZenkaiChosaGaikyouChousaJokyoProcess.class)
                .arguments(getParameter().toShinchokuDataOutputProcessParamter()).define();
    }

    /**
     * 前回認定調査票（基本調査）調査項目一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(前回認定調査票基本調査調査項目)
    protected IBatchFlowCommand createZenkaiNinteichosahyoChosaItemProcess() {
        return loopBatch(ZenkaiNinteichosahyoChosaItemProcess.class)
                .arguments(getParameter().toShinchokuDataOutputProcessParamter()).define();
    }

    /**
     * 日次進捗データ作成の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(日次進捗データ作成)
    protected IBatchFlowCommand createJigyoJyokyoHokokuData() {
        return loopBatch(ShinchokuDataOutputEucCsvProcess.class)
                .arguments(getParameter().toShinchokuDataOutputProcessParamter()).define();
    }
}
