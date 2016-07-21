/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ichijihanteizumifoutput;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput.IchijiHanteizumIfOutputEucCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput.NinteichosahyoChosaItemSkuseyiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput.NinteichosahyoServiceJokyoSkuseyiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput.ShujiiIkenshoJohoSkuseyiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput.ZenkaiChosaGaikyouChousaJokyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput.ZenkaiNinteichosahyoChosaItemProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ichijihanteizumifoutput.IchijiHanteizumIfOutputBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBE309001_一次判定IF作成のバッチフロークラスです。
 *
 * @reamsid_L DBE-1470-021 wanghui
 */
public class IchijiHanteizumIfOutputFlow extends BatchFlowBase<IchijiHanteizumIfOutputBatchParamter> {

    private static final String 調査票概況調査サービスの状況 = "NinteichosahyoServiceJokyoSkuseyiProcess";
    private static final String 認定調査票基本調査調査項目 = "NinteichosahyoChosaItemSkuseyiProcess";
    private static final String 要介護認定主治医意見書意見項目 = "ShujiiIkenshoJohoSkuseyiProcess";
    private static final String 前回調査票概況調査サービスの状況 = "ZenkaiChosaGaikyouChousaJokyoProcess";
    private static final String 前回認定調査票基本調査調査項目 = "ZenkaiNinteichosahyoChosaItemProcess";
    private static final String 一次判定IF作成 = "ShinchokuDataOutputEucCsvProcess";

    @Override
    protected void defineFlow() {
        executeStep(調査票概況調査サービスの状況);
        executeStep(認定調査票基本調査調査項目);
        executeStep(要介護認定主治医意見書意見項目);
        executeStep(前回調査票概況調査サービスの状況);
        executeStep(前回認定調査票基本調査調査項目);
        executeStep(一次判定IF作成);
    }

    /**
     * 調査票概況調査サービスの状況一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(調査票概況調査サービスの状況)
    protected IBatchFlowCommand createNinteichosahyoServiceJokyoSkuseyiProcess() {
        return loopBatch(NinteichosahyoServiceJokyoSkuseyiProcess.class)
                .arguments(getParameter().toIchijiHanteizumIfOutputProcessParamter()).define();
    }

    /**
     * 認定調査票基本調査調査項目一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票基本調査調査項目)
    protected IBatchFlowCommand createNinteichosahyoChosaItemSkuseyiProcess() {
        return loopBatch(NinteichosahyoChosaItemSkuseyiProcess.class)
                .arguments(getParameter().toIchijiHanteizumIfOutputProcessParamter()).define();
    }

    /**
     * 要介護認定主治医意見書意見項目一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(要介護認定主治医意見書意見項目)
    protected IBatchFlowCommand createShujiiIkenshoJohoSkuseyiProcess() {
        return loopBatch(ShujiiIkenshoJohoSkuseyiProcess.class)
                .arguments(getParameter().toIchijiHanteizumIfOutputProcessParamter()).define();
    }

    /**
     * 前回調査票概況調査サービスの状況一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(前回調査票概況調査サービスの状況)
    protected IBatchFlowCommand createZenkaiChosaGaikyouChousaJokyoProcess() {
        return loopBatch(ZenkaiChosaGaikyouChousaJokyoProcess.class)
                .arguments(getParameter().toIchijiHanteizumIfOutputProcessParamter()).define();
    }

    /**
     * 前回認定調査票（基本調査）調査項目一時テーブルの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(前回認定調査票基本調査調査項目)
    protected IBatchFlowCommand createZenkaiNinteichosahyoChosaItemProcess() {
        return loopBatch(ZenkaiNinteichosahyoChosaItemProcess.class)
                .arguments(getParameter().toIchijiHanteizumIfOutputProcessParamter()).define();
    }

    /**
     * 一次判定IF作成の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(一次判定IF作成)
    protected IBatchFlowCommand createJigyoJyokyoHokokuData() {
        return loopBatch(IchijiHanteizumIfOutputEucCsvProcess.class)
                .arguments(getParameter().toIchijiHanteizumIfOutputProcessParamter()).define();
    }
}
