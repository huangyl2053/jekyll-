/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.CalcKogakuShikyugakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.DBC020080ShoriCsvProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.DBC020080ShoriDateKanriUpdProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.DBC200029GassanKekkaIchiranReportProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.InitJissekiCheckProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.InsShiharaihohoHenkoTempBeforeProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.InsShiharaihohoHenkoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.SetFutangakuAfterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.SetFutangakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.TaishoshaChushuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.UpdJIssekiFutangakuTempAfterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.UpdJIssekiFutangakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.UpdshafukuKeigenTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020080.DBC020080_JigyobunKogakuGassanJikofutangakuKeisanParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.CalcKogakuShikyugakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.DBC020080ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.InsShiharaihohoHenkoTempBeforeProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.SetFutangakuAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.SetFutangakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.TaishoshaChushuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.UpdJIssekiFutangakuTempAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.UpdshafukuKeigenTempProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のバッチフロークラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public class DBC020080_JigyobunKogakuGassanJikofutangakuKeisan
        extends BatchFlowBase<DBC020080_JigyobunKogakuGassanJikofutangakuKeisanParameter> {

    private static final String TAISHOSHACHUSHUPROCESS = "TaishoshaChushuProcess";
    private static final String INITJISSEKICHECKPROCESS = "InitJissekiCheckProcess";
    private static final String INSSHIHARAIHOHOHENKOTEMPBEFOREPROCESS = "InsShiharaihohoHenkoTempBeforeProcess";
    private static final String INSSHIHARAIHOHOHENKOTEMPPROCESS = "InsShiharaihohoHenkoTempProcess";
    private static final String UPDSHAFUKUKEIGENTEMPPROCESS = "UpdshafukuKeigenTempProcess";
    private static final String UPDJISSEKIFUTANGAKUTEMPPROCESS = "UpdJIssekiFutangakuTempProcess";
    private static final String UPDJISSEKIFUTANGAKUTEMPAFTERPROCESS = "UpdJIssekiFutangakuTempAfterProcess";
    private static final String CALCKOGAKUSHIKYUGAKUPROCESS = "CalcKogakuShikyugakuProcess";
    private static final String SETFUTANGAKUPROCESS = "SetFutangakuProcess";
    private static final String SETFUTANGAKUAFTERPROCESS = "SetFutangakuAfterProcess";
    private static final String DBC200029GASSANKEKKAICHIRANREPORTPROCESS = "DBC200029GassanKekkaIchiranReportProcess";
    private static final String DBC020080SHORICSVPROCESS = "DBC020080ShoriCsvProcess";
    private static final String DBC020080SHORIDATEKANRIUPDPROCESS = "DBC020080ShoriDateKanriUpdProcess";

    private static final String BACKUP_TO_TEMPORARYTABLE = "backup_To_TemporaryTable";
    private RString importTableNamePermanent;
    private RString exportTableNameTemporary;

    private static final RString BACKUPTABLE1 = new RString("DbT3068KogakuGassanShinseisho");
    private static final RString BACKUPTABLE2 = new RString("DbT3070KogakuGassanJikoFutanGaku");
    private static final RString TEMPTABLE1 = new RString("DbT3068TempTable");
    private static final RString TEMPTABLE2 = new RString("DbT3070TempTable");

    private static final RString 処理区分_呼び出し元自己負担額計算 = new RString("3");

    @Override
    protected void initialize() {
    }

    @Override
    protected void defineFlow() {
        importTableNamePermanent = BACKUPTABLE1;
        exportTableNameTemporary = TEMPTABLE1;
        executeStep(BACKUP_TO_TEMPORARYTABLE);
        importTableNamePermanent = BACKUPTABLE2;
        exportTableNameTemporary = TEMPTABLE2;
        executeStep(BACKUP_TO_TEMPORARYTABLE);
        executeStep(TAISHOSHACHUSHUPROCESS);
        executeStep(INITJISSEKICHECKPROCESS);
        boolean isデータがあり = getResult(Boolean.class, new RString(INITJISSEKICHECKPROCESS), InitJissekiCheckProcess.OUTPUTNAME);
        if (!isデータがあり) {
            return;
        }
        executeStep(INSSHIHARAIHOHOHENKOTEMPBEFOREPROCESS);
        executeStep(INSSHIHARAIHOHOHENKOTEMPPROCESS);
        executeStep(UPDSHAFUKUKEIGENTEMPPROCESS);
        executeStep(UPDJISSEKIFUTANGAKUTEMPPROCESS);
        executeStep(UPDJISSEKIFUTANGAKUTEMPAFTERPROCESS);
        executeStep(CALCKOGAKUSHIKYUGAKUPROCESS);
        executeStep(SETFUTANGAKUPROCESS);
        executeStep(SETFUTANGAKUAFTERPROCESS);
        executeStep(DBC200029GASSANKEKKAICHIRANREPORTPROCESS);
        executeStep(DBC020080SHORICSVPROCESS);
        executeStep(DBC020080SHORIDATEKANRIUPDPROCESS);
    }

    @Step(BACKUP_TO_TEMPORARYTABLE)
    IBatchFlowCommand backupToTemporaryTable() {
        return backupToTemporaryTable(importTableNamePermanent, exportTableNameTemporary).define();
    }

    @Step(TAISHOSHACHUSHUPROCESS)
    IBatchFlowCommand taishoshaChushuProcess() {
        TaishoshaChushuProcessParameter param = new TaishoshaChushuProcessParameter(getParameter().getShoriTimestamp(),
                getParameter().getTaishoKaishiDay(), getParameter().getTaishoShuryoDay());
        return loopBatch(TaishoshaChushuProcess.class).arguments(param).define();
    }

    @Step(INITJISSEKICHECKPROCESS)
    IBatchFlowCommand initJissekiCheckProcess() {
        return simpleBatch(InitJissekiCheckProcess.class).define();
    }

    @Step(INSSHIHARAIHOHOHENKOTEMPBEFOREPROCESS)
    IBatchFlowCommand insShiharaihohoHenkoTempBeforeProcess() {
        InsShiharaihohoHenkoTempBeforeProcessParameter param
                = new InsShiharaihohoHenkoTempBeforeProcessParameter(false);
        return loopBatch(InsShiharaihohoHenkoTempBeforeProcess.class).arguments(param).define();
    }

    @Step(INSSHIHARAIHOHOHENKOTEMPPROCESS)
    IBatchFlowCommand insShiharaihohoHenkoTempProcess() {
        return loopBatch(InsShiharaihohoHenkoTempProcess.class).define();
    }

    @Step(UPDSHAFUKUKEIGENTEMPPROCESS)
    IBatchFlowCommand updshafukuKeigenTempProcess() {
        UpdshafukuKeigenTempProcessParameter param = new UpdshafukuKeigenTempProcessParameter(false);
        return loopBatch(UpdshafukuKeigenTempProcess.class).arguments(param).define();
    }

    @Step(UPDJISSEKIFUTANGAKUTEMPPROCESS)
    IBatchFlowCommand updJIssekiFutangakuTempProcess() {
        return loopBatch(UpdJIssekiFutangakuTempProcess.class).define();
    }

    @Step(UPDJISSEKIFUTANGAKUTEMPAFTERPROCESS)
    IBatchFlowCommand updJIssekiFutangakuTempAfterProcess() {
        UpdJIssekiFutangakuTempAfterProcessParameter param = new UpdJIssekiFutangakuTempAfterProcessParameter(
                処理区分_呼び出し元自己負担額計算, getParameter().getShoriTimestamp());
        return loopBatch(UpdJIssekiFutangakuTempAfterProcess.class).arguments(param).define();
    }

    @Step(CALCKOGAKUSHIKYUGAKUPROCESS)
    IBatchFlowCommand calcKogakuShikyugakuProcess() {
        CalcKogakuShikyugakuProcessParameter param = new CalcKogakuShikyugakuProcessParameter(getParameter().getShoriTimestamp());
        return loopBatch(CalcKogakuShikyugakuProcess.class).arguments(param).define();
    }

    @Step(SETFUTANGAKUPROCESS)
    IBatchFlowCommand setFutangakuProcess() {
        SetFutangakuProcessParameter param = new SetFutangakuProcessParameter(false, RString.EMPTY);
        return loopBatch(SetFutangakuProcess.class).arguments(param).define();
    }

    @Step(SETFUTANGAKUAFTERPROCESS)
    IBatchFlowCommand setFutangakuAfterProcess() {
        SetFutangakuAfterProcessParameter param = new SetFutangakuAfterProcessParameter(getParameter().getShoriTimestamp());
        return loopBatch(SetFutangakuAfterProcess.class).arguments(param).define();
    }

    @Step(DBC200029GASSANKEKKAICHIRANREPORTPROCESS)
    IBatchFlowCommand dBC200029GassanKekkaIchiranReportProcess() {
        DBC020080ProcessParameter param = getParameter().toDBC020080ProcessParameter();
        return loopBatch(DBC200029GassanKekkaIchiranReportProcess.class).arguments(param).define();
    }

    @Step(DBC020080SHORICSVPROCESS)
    IBatchFlowCommand dBC020080ShoriCsvProcess() {
        DBC020080ProcessParameter param = getParameter().toDBC020080ProcessParameter();
        return loopBatch(DBC020080ShoriCsvProcess.class).arguments(param).define();
    }

    @Step(DBC020080SHORIDATEKANRIUPDPROCESS)
    IBatchFlowCommand dBC020080ShoriDateKanriUpdProcess() {
        DBC020080ProcessParameter param = getParameter().toDBC020080ProcessParameter();
        return loopBatch(DBC020080ShoriDateKanriUpdProcess.class).arguments(param).define();
    }

}
