/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InitJissekiCheckProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InsShiharaihohoHenkoTempBeforeProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InsShiharaihohoHenkoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdJIssekiFutangakuTempAfterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdJIssekiFutangakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdshafukuKeigenTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031.ClearJikofutangakuInfoHoseiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031.ClearJissekiFutangakuDataTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031.JikofutangakuTempUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031.JissekiFutangakuDataToTyukanDbData;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031.TyukanDbDataToJissekiFutangakuData;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040031.DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.InsShiharaihohoHenkoTempBeforeProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.UpdJIssekiFutangakuTempAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.UpdshafukuKeigenTempProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報補正（一括）_サブ処理のフローです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
public class DBC040031_KogakugassanJikofutangakuInfoHoseiSub extends BatchFlowBase<DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter> {

    private static final String 高額支給額集計処理 = "sumJikofutangaku";
    private static final String 中間DBデータ削除 = " clearJikofutangakuInfoHoseiTemp";
    private static final String 実績基本データTO中間DBデータ = "jissekiFutangakuToTyukanDb";
    private static final String 実績基本データ削除 = "clearJissekiFutangakuDataTemp";
    private static final String 中間DBデータTO実績基本データ = "tyukanDbToJissekiFutangaku";
    private static final String 実績負担額更新登録 = "initJissekiCheckProcess";
    private static final String 負担額ワークエリア登録 = "insShiharaihohoHenkoProcess";
    private static final String 負担額ワークエリア登録後 = "insShiharaihohoHenko";
    private static final String 自己負担額ワークエリア更新 = "updshafukuKeigenTempProcess";
    private static final String 実績負担額更新 = "updJIssekiFutangakuProcess";
    private static final String 実績負担額更新後 = "updJIssekiFutangakuAfter";

    @Override
    protected void defineFlow() {
        executeStep(実績基本データ削除);
        executeStep(中間DBデータTO実績基本データ);
        executeStep(実績負担額更新登録);
        boolean isデータがあり = getResult(Boolean.class, new RString(実績負担額更新登録), InitJissekiCheckProcess.OUTPUTNAME);
        if (!isデータがあり) {
            return;
        }
        executeStep(負担額ワークエリア登録);
        executeStep(負担額ワークエリア登録後);
        executeStep(自己負担額ワークエリア更新);
        executeStep(実績負担額更新);
        executeStep(実績負担額更新後);
        executeStep(中間DBデータ削除);
        executeStep(実績基本データTO中間DBデータ);
        executeStep(高額支給額集計処理);

    }

    @Step(高額支給額集計処理)
    IBatchFlowCommand sumJikofutangaku() {
        return loopBatch(JikofutangakuTempUpdateProcess.class).define();
    }

    @Step(中間DBデータ削除)
    IBatchFlowCommand clearJikofutangakuInfoHoseiTemp() {
        return loopBatch(ClearJikofutangakuInfoHoseiTempProcess.class).define();
    }

    @Step(実績基本データTO中間DBデータ)
    IBatchFlowCommand jissekiFutangakuToTyukanDb() {
        return loopBatch(JissekiFutangakuDataToTyukanDbData.class).define();
    }

    @Step(実績基本データ削除)
    IBatchFlowCommand clearJissekiFutangakuDataTemp() {
        return loopBatch(ClearJissekiFutangakuDataTempProcess.class).define();
    }

    @Step(中間DBデータTO実績基本データ)
    IBatchFlowCommand tyukanDbToJissekiFutangaku() {
        return loopBatch(TyukanDbDataToJissekiFutangakuData.class).define();
    }

    @Step(実績負担額更新登録)
    IBatchFlowCommand initJissekiCheckProcess() {
        return simpleBatch(InitJissekiCheckProcess.class).define();
    }

    @Step(負担額ワークエリア登録)
    IBatchFlowCommand insShiharaihohoHenkoProcess() {
        InsShiharaihohoHenkoTempBeforeProcessParameter param
                = new InsShiharaihohoHenkoTempBeforeProcessParameter(false);
        return loopBatch(InsShiharaihohoHenkoTempBeforeProcess.class).arguments(param).define();
    }

    @Step(負担額ワークエリア登録後)
    IBatchFlowCommand insShiharaihohoHenko() {
        return loopBatch(InsShiharaihohoHenkoTempProcess.class).define();
    }

    @Step(自己負担額ワークエリア更新)
    IBatchFlowCommand updshafukuKeigenTempProcess() {
        UpdshafukuKeigenTempProcessParameter param = new UpdshafukuKeigenTempProcessParameter(false);
        return loopBatch(UpdshafukuKeigenTempProcess.class).arguments(param).define();
    }

    @Step(実績負担額更新)
    IBatchFlowCommand updJIssekiFutangakuProcess() {
        return loopBatch(UpdJIssekiFutangakuTempProcess.class).define();
    }

    @Step(実績負担額更新後)
    IBatchFlowCommand updJIssekiFutangakuAfter() {
        UpdJIssekiFutangakuTempAfterProcessParameter param = new UpdJIssekiFutangakuTempAfterProcessParameter(
                getParameter().get処理区分(), RDateTime.now());
        return loopBatch(UpdJIssekiFutangakuTempAfterProcess.class).arguments(param).define();
    }

}
