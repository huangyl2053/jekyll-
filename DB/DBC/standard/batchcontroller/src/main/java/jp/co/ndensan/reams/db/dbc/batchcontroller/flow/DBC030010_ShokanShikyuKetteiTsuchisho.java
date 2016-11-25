/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.KetteiTsuchiIchiranOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShiharaiYoteiBiYijiNashiOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShoHihokenshabunOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShoShiharaiYoteiBiYijiAriOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanKetteiTsuchiShoIkkatsuDBUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanKetteiTsuchiShoMeisaiTempInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanKetteiTsuchiShoMeisaiTempServiceUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanKetteiTsuchiShoMeisaiTempYoshikiUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanKetteiTsuchiShoSealer2OutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanKetteiTsuchiShoSealerOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanKetteiTsuchiShoTempInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanKetteiTsuchiShokanShinseiDBUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.ShokanbaraiSashitomeTaishoshaIchiranOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010.UpdHakkoutaisyouFlgProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC030010.DBC030010_ShokanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanKetteiTsuchiShokanShinsei.ShokanKetteiTsuchiShokanShinseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書一括作成のバッチ処理フロー
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class DBC030010_ShokanShikyuKetteiTsuchisho extends BatchFlowBase<DBC030010_ShokanShikyuKetteiTsuchishoParameter> {

    private static final String TEMP_INSERT = "shokanKetteiTsuchiShoTempInsertProcess";
    private static final String UPD_HAKKOUTAISYOUFLG = "updHakkoutaisyouFlgProcess";
    private static final String MEISAI_TEMP_INSERT = "shokanKetteiTsuchiShoMeisaiTempInsertProcess";
    private static final String TEMP_UPDATE_SERVICE = "ShokanKetteiTsuchiShoMeisaiTempServiceUpdateProcess";
    private static final String TEMP_UPDATE_YOSHIKI = "ShokanKetteiTsuchiShoMeisaiTempYoshikiUpdateProcess";
    private static final String DB_UPDATE = "shokanKetteiTsuchiShoIkkatsuDBUpdateProcess";
    private static final String DB_UPDATE2 = "ShokanKetteiTsuchiShokanShinseiDBUpdateProcess";

    private static final String DBC100002 = "shiharaiYoteiBiYijiNashiOutputProcess";
    private static final String DBC100003 = "shoShiharaiYoteiBiYijiAriOutputProcess";
    private static final String DBC100004 = "shokanKetteiTsuchiShoSealerOutputProcess";
    private static final String DBC100005 = "shoHihokenshabunOutputProcess";
    private static final String DBC100006 = "shokanKetteiTsuchiShoSealer2OutputProcess";
    private static final String DBC200023 = "ketteiTsuchiIchiranOutputProcess";
    private static final String DBC200024 = "ShokanbaraiSashitomeTaishoshaIchiranOutputProcess";

    private static final RString 帳票制御汎用キー_用紙タイプ = new RString("用紙タイプ");
    private static final RString 帳票制御汎用キー_支払予定日印字有無 = new RString("支払予定日印字有無");
    private static final RString 用紙タイプ_A4 = new RString("1");
    private static final RString 用紙タイプ_シーラ = new RString("2");
    private static final RString 用紙タイプ_諏訪広域版 = new RString("3");
    private static final RString 支払予定日印字有無_印字しない = new RString("0");
    private static final RString 支払予定日印字有無_印字する = new RString("1");
    private static final RString 更新する = new RString("2");
    private static final RString フラグ_FALSE = new RString("false");
    private static final RString フラグ_TRUE = new RString("true");
    private static final RString 発行有無_発行しない = new RString("0");
    private static Long jobId = Long.MIN_VALUE;

    @Override
    protected void prepareConfigData() {
        jobId = super.getJobId();
    }

    @Override
    protected void defineFlow() {

        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        RString 用紙タイプ = RString.EMPTY;

        ChohyoSeigyoHanyo 帳票制御汎用紙タイプ = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 帳票制御汎用キー_用紙タイプ);
        if (帳票制御汎用紙タイプ != null) {
            用紙タイプ = 帳票制御汎用紙タイプ.get設定値();
        }
        RString 支払予定日印字有無 = RString.EMPTY;
        ChohyoSeigyoHanyo 帳票制御汎支払予定日印字
                = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                        FlexibleYear.MIN, 帳票制御汎用キー_支払予定日印字有無);
        if (帳票制御汎支払予定日印字 != null) {
            支払予定日印字有無 = 帳票制御汎支払予定日印字.get設定値();
        }
        executeStep(TEMP_INSERT);
        executeStep(UPD_HAKKOUTAISYOUFLG);
        executeStep(MEISAI_TEMP_INSERT);
        executeStep(TEMP_UPDATE_YOSHIKI);
        executeStep(TEMP_UPDATE_SERVICE);
        if (フラグ_FALSE.equals(getParameter().getテスト出力フラグ())) {
            executeStep(DB_UPDATE);
        }
        if (更新する.equals(getParameter().get窓口払い一括更新区分())) {
            executeStep(DB_UPDATE2);
        }
        
        if (用紙タイプ_A4.equals(用紙タイプ)) {
            if (支払予定日印字有無_印字しない.equals(支払予定日印字有無)) {
                executeStep(DBC100002);
            } else if (支払予定日印字有無_印字する.equals(支払予定日印字有無)) {
                executeStep(DBC100003);
            }
        } 
        if (フラグ_FALSE.equals(getParameter().get受領委任者向け決定通知書フラグ())
                && 用紙タイプ_諏訪広域版.equals(用紙タイプ)) {
            executeStep(DBC100006);
        }

        if (用紙タイプ_シーラ.equals(用紙タイプ)) {
            executeStep(DBC100004);
        }

        if (フラグ_TRUE.equals(getParameter().get利用者向け決定通知書フラグ())) {
            executeStep(DBC100005);
        }
        executeStep(DBC200023);
        executeStep(DBC200024);
    }

    @Step(TEMP_INSERT)
    IBatchFlowCommand shokanKetteiTsuchiShoTempInsertProcess() {
        return loopBatch(ShokanKetteiTsuchiShoTempInsertProcess.class)
                .arguments(ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter.createProcessParam(getParameter()))
                .define();
    }
    
     @Step(UPD_HAKKOUTAISYOUFLG)
    IBatchFlowCommand updHakkoutaisyouFlgProcess() {
        return simpleBatch(UpdHakkoutaisyouFlgProcess.class)
                .define();
    }

    @Step(MEISAI_TEMP_INSERT)
    IBatchFlowCommand shokanKetteiTsuchiShoMeisaiTempInsertProcess() {
        return loopBatch(ShokanKetteiTsuchiShoMeisaiTempInsertProcess.class).define();
    }

    @Step(TEMP_UPDATE_YOSHIKI)
    IBatchFlowCommand shokanKetteiTsuchiShoMeisaiTempYoshikiUpdateProcess() {
        return loopBatch(ShokanKetteiTsuchiShoMeisaiTempYoshikiUpdateProcess.class).define();
    }

    @Step(TEMP_UPDATE_SERVICE)
    IBatchFlowCommand shokanKetteiTsuchiShoMeisaiTempServiceUpdateProcess() {
        return loopBatch(ShokanKetteiTsuchiShoMeisaiTempServiceUpdateProcess.class).define();
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand shokanKetteiTsuchiShoIkkatsuDBUpdateProcess() {
        return loopBatch(ShokanKetteiTsuchiShoIkkatsuDBUpdateProcess.class)
                .arguments(ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter.createProcessParam(getParameter()))
                .define();
    }

    @Step(DB_UPDATE2)
    IBatchFlowCommand shokanKetteiTsuchiShokanShinseiDBUpdateProcess() {
        return loopBatch(ShokanKetteiTsuchiShokanShinseiDBUpdateProcess.class)
                .arguments(ShokanKetteiTsuchiShokanShinseiProcessParameter.createProcessParam(getParameter()))
                .define();
    }

    @Step(DBC100002)
    IBatchFlowCommand shiharaiYoteiBiYijiNashiOutputProcess() {
        return loopBatch(ShiharaiYoteiBiYijiNashiOutputProcess.class)
                .arguments(ShokanKetteiTsuchiShoSealerBatchParameter.createProcessParam(getParameter(), jobId))
                .define();
    }

    @Step(DBC100003)
    IBatchFlowCommand shoShiharaiYoteiBiYijiAriOutputProcess() {
        return loopBatch(ShoShiharaiYoteiBiYijiAriOutputProcess.class)
                .arguments(ShokanKetteiTsuchiShoSealerBatchParameter.createProcessParam(getParameter(), jobId))
                .define();
    }

    @Step(DBC100004)
    IBatchFlowCommand shokanKetteiTsuchiShoSealerOutputProcess() {
        return loopBatch(ShokanKetteiTsuchiShoSealerOutputProcess.class)
                .arguments(ShokanKetteiTsuchiShoSealerBatchParameter.createProcessParam(getParameter(), jobId))
                .define();
    }

    @Step(DBC100005)
    IBatchFlowCommand shoHihokenshabunOutputProcess() {
        return loopBatch(ShoHihokenshabunOutputProcess.class)
                .arguments(ShokanKetteiTsuchiShoSealerBatchParameter.createProcessParam(getParameter(), jobId))
                .define();
    }

    @Step(DBC100006)
    IBatchFlowCommand shokanKetteiTsuchiShoSealer2OutputProcess() {
        return loopBatch(ShokanKetteiTsuchiShoSealer2OutputProcess.class)
                .arguments(ShokanKetteiTsuchiShoSealerBatchParameter.createProcessParam(getParameter(), jobId))
                .define();
    }

    @Step(DBC200023)
    IBatchFlowCommand ketteiTsuchiIchiranOutputProcess() {
        return loopBatch(KetteiTsuchiIchiranOutputProcess.class)
                .arguments(ShokanKetteiTsuchiShoSealerBatchParameter.createProcessParam(getParameter(), jobId))
                .define();
    }

    @Step(DBC200024)
    IBatchFlowCommand shokanbaraiSashitomeTaishoshaIchiranOutputProcess() {
        return loopBatch(ShokanbaraiSashitomeTaishoshaIchiranOutputProcess.class)
                .arguments(ShokanKetteiTsuchiShoSealerBatchParameter.createProcessParam(getParameter(), jobId))
                .define();
    }
}
