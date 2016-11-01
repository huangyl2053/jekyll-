/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.JutakuKaishuRiyushoTesuryoMeisaiDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.JutakuKaishuRiyushoTesuryoShukeiDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.KaishuriyushoSeikyushoShinseishoDBC100045Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.KaishuriyushoSeikyushoShinseishoDBC200064Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.SeikyuMeisaiItiziDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.ShoriDateKanriDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.ShukeiKanrendukeBangouUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.TempSeikyuMeisaiItiziDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010.TempSeikyuShukeiItiziDataProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC100010.DBC100010_KaishuriyushoSeikyushoShinseishoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のFLOWです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
public class DBC100010_KaishuriyushoSeikyushoShinseisho extends BatchFlowBase<DBC100010_KaishuriyushoSeikyushoShinseishoParameter> {

    private static final String 請求明細一時TEMP作成 = "TempSeikyuMeisaiItiziDataProcess";
    private static final String 請求明細一時TEMPデータ登録 = "SeikyuMeisaiItiziDataProcess";
    private static final String 請求集計一時TEMP作成 = "TempSeikyuShukeiItiziDataProcess";
    private static final String 集計関連付け番号更新 = "ShukeiKanrendukeBangouUpdateProcess";
    private static final String 住宅改修理由書作成手数料請求書兼申請書帳票出力 = "KaishuriyushoSeikyushoShinseishoDBC100045Process";
    private static final String 住宅改修理由書作成手数料請求書兼申請書作成一覧表帳票出力 = "KaishuriyushoSeikyushoShinseishoDBC200064Process";
    private static final String 住宅改修理由書作成手数料請求明細の登録 = "JutakuKaishuRiyushoTesuryoMeisaiDataProcess";
    private static final String 住宅改修理由書作成手数料請求集計の登録 = "JutakuKaishuRiyushoTesuryoShukeiDataProcess";
    private static final String 処理日付管理マスタの更新 = "ShoriDateKanriDataProcess";

    @Override
    protected void defineFlow() {
        executeStep(請求明細一時TEMP作成);
        if (new RString("1").equals(getParameter().get処理対象区分())) {
            executeStep(請求明細一時TEMPデータ登録);
        }
        executeStep(請求集計一時TEMP作成);
        executeStep(集計関連付け番号更新);
        executeStep(住宅改修理由書作成手数料請求書兼申請書帳票出力);
        executeStep(住宅改修理由書作成手数料請求書兼申請書作成一覧表帳票出力);
        executeStep(住宅改修理由書作成手数料請求明細の登録);
        executeStep(住宅改修理由書作成手数料請求集計の登録);
        executeStep(処理日付管理マスタの更新);
    }

    @Step(請求明細一時TEMP作成)
    IBatchFlowCommand editTempSeikyuMeisaiItiziDataProcess() {
        return loopBatch(TempSeikyuMeisaiItiziDataProcess.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }

    @Step(請求明細一時TEMPデータ登録)
    IBatchFlowCommand editSeikyuMeisaiItiziDataProcess() {
        return loopBatch(SeikyuMeisaiItiziDataProcess.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }

    @Step(請求集計一時TEMP作成)
    IBatchFlowCommand editTempSeikyuShukeiItiziDataProcess() {
        return loopBatch(TempSeikyuShukeiItiziDataProcess.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }

    @Step(集計関連付け番号更新)
    IBatchFlowCommand editShukeiKanrendukeBangouUpdateProcess() {
        return loopBatch(ShukeiKanrendukeBangouUpdateProcess.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }

    @Step(住宅改修理由書作成手数料請求書兼申請書帳票出力)
    IBatchFlowCommand editKaishuriyushoSeikyushoShinseishoDBC100045Process() {
        return loopBatch(KaishuriyushoSeikyushoShinseishoDBC100045Process.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }

    @Step(住宅改修理由書作成手数料請求書兼申請書作成一覧表帳票出力)
    IBatchFlowCommand editKaishuriyushoSeikyushoShinseishoDBC200064Process() {
        return loopBatch(KaishuriyushoSeikyushoShinseishoDBC200064Process.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }

    @Step(住宅改修理由書作成手数料請求明細の登録)
    IBatchFlowCommand editJutakuKaishuRiyushoTesuryoMeisaiDataProcess() {
        return loopBatch(JutakuKaishuRiyushoTesuryoMeisaiDataProcess.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }

    @Step(住宅改修理由書作成手数料請求集計の登録)
    IBatchFlowCommand editJutakuKaishuRiyushoTesuryoShukeiDataProcess() {
        return loopBatch(JutakuKaishuRiyushoTesuryoShukeiDataProcess.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }

    @Step(処理日付管理マスタの更新)
    IBatchFlowCommand editShoriDateKanriDataProcess() {
        return loopBatch(ShoriDateKanriDataProcess.class).arguments(getParameter().
                toKaishuriyushoSeikyushoShinseishoProcessParameter())
                .define();
    }
}
