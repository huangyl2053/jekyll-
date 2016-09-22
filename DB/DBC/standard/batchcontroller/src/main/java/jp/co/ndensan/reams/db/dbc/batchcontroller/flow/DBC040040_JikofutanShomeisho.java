/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040.JikoFutangakushomeishoCsvOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040.JikoFutangakushomeishoFrom2009OutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040.JikoFutangakushomeishoTo2008OutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040.KogakuGassanJikoFutanGakuInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040.KogakuGassanTempInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040.KogakuGassanTempUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040.SeiriNoSetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040.ShoriDateKanriInsertPocess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040040.DBC040040_JikofutanShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040040.JikofutanShomeishoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 自己負担証明書作成（括）のバッチフロークラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class DBC040040_JikofutanShomeisho extends BatchFlowBase<DBC040040_JikofutanShomeishoParameter> {

    private static final String 高額合算情報抽出 = "KogakuGassanTempInsertProcess";
    private static final String 被保険者台帳宛名情報抽出 = "KogakuGassanTempUpdateProcess";
    private static final String 自己負担額証明書整理番号付与 = "SeiriNoSetProcess";
    private static final String 自己負担額証明書発行2008年度 = "JikoFutangakushomeishoTo2008OutputProcess";
    private static final String 自己負担額証明書発行2009年度以降 = "JikoFutangakushomeishoFrom2009OutputProcess";
    private static final String 高額合算自己負担額証明書発行一覧表発行 = "JikoFutangakushomeishoCsvOutputProcess";
    private static final String 高額合算自己負担額更新 = "KogakuGassanJikoFutanGakuInsertProcess";
    private static final String 処理日付管理更新 = "ShoriDateKanriInsertPocess";

    @Override
    protected void defineFlow() {
        executeStep(高額合算情報抽出);
        executeStep(被保険者台帳宛名情報抽出);
        executeStep(自己負担額証明書整理番号付与);
        executeStep(自己負担額証明書発行2008年度);
        executeStep(自己負担額証明書発行2009年度以降);
        executeStep(高額合算自己負担額証明書発行一覧表発行);
        executeStep(高額合算自己負担額更新);
        executeStep(処理日付管理更新);
    }

    @Step(高額合算情報抽出)
    IBatchFlowCommand step1() {
        return loopBatch(KogakuGassanTempInsertProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(被保険者台帳宛名情報抽出)
    IBatchFlowCommand step2() {
        return loopBatch(KogakuGassanTempUpdateProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(自己負担額証明書整理番号付与)
    IBatchFlowCommand step3() {
        return loopBatch(SeiriNoSetProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(自己負担額証明書発行2008年度)
    IBatchFlowCommand step4() {
        return loopBatch(JikoFutangakushomeishoTo2008OutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(自己負担額証明書発行2009年度以降)
    IBatchFlowCommand step5() {
        return loopBatch(JikoFutangakushomeishoFrom2009OutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(高額合算自己負担額証明書発行一覧表発行)
    IBatchFlowCommand step6() {
        return loopBatch(JikoFutangakushomeishoCsvOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(高額合算自己負担額更新)
    IBatchFlowCommand step7() {
        return loopBatch(KogakuGassanJikoFutanGakuInsertProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(処理日付管理更新)
    IBatchFlowCommand step8() {
        return loopBatch(ShoriDateKanriInsertPocess.class)
                .arguments(getProcessParameter())
                .define();
    }

    private JikofutanShomeishoProcessParameter getProcessParameter() {
        JikofutanShomeishoProcessParameter param = new JikofutanShomeishoProcessParameter();
        param.set開始申請年月日(getParameter().get開始申請年月日());
        param.set終了申請年月日(getParameter().get終了申請年月日());
        param.set受取年月(getParameter().get受取年月());
        param.set印書(getParameter().get印書());
        param.set発行日(getParameter().get発行日());
        param.set出力順ID(getParameter().get出力順ID());
        param.set文書情報(getParameter().get文書情報());
        param.set抽出対象(getParameter().get抽出対象());
        return param;
    }
}
