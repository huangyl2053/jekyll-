/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.CalcKogakuShikyugakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.DBC040010ShoriCsvProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.DBC040010ShoriDateKanriUpdProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.DBC200029GassanKekkaIchiranReportProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InitJissekiCheckProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InsShiharaihohoHenkoTempBeforeProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InsShiharaihohoHenkoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.SetFutangakuAfterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.SetFutangakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.TaishoshaChushuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdJIssekiFutangakuTempAfterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdJIssekiFutangakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdshafukuKeigenTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040010.DBC040010_KogakuGassanJikofutangakuKeisanParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.CalcKogakuShikyugakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.DBC040010ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.InsShiharaihohoHenkoTempBeforeProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.SetFutangakuAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.SetFutangakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.TaishoshaChushuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.UpdJIssekiFutangakuTempAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.UpdshafukuKeigenTempProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のバッチフロークラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public class DBC040010_KogakuGassanJikofutangakuKeisan
        extends BatchFlowBase<DBC040010_KogakuGassanJikofutangakuKeisanParameter> {

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
    private static final String DBC040010SHORICSVPROCESS = "DBC040010ShoriCsvProcess";
    private static final String DBC040010SHORIDATEKANRIUPDPROCESS = "DBC040010ShoriDateKanriUpdProcess";

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
        executeStep(DBC040010SHORICSVPROCESS);
        executeStep(DBC040010SHORIDATEKANRIUPDPROCESS);
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
        DBC040010ProcessParameter param = getParameter().toDBC040010ProcessParameter();
        return loopBatch(DBC200029GassanKekkaIchiranReportProcess.class).arguments(param).define();
    }

    @Step(DBC040010SHORICSVPROCESS)
    IBatchFlowCommand dBC040010ShoriCsvProcess() {
        DBC040010ProcessParameter param = getParameter().toDBC040010ProcessParameter();
        return loopBatch(DBC040010ShoriCsvProcess.class).arguments(param).define();
    }

    @Step(DBC040010SHORIDATEKANRIUPDPROCESS)
    IBatchFlowCommand dBC040010ShoriDateKanriUpdProcess() {
        DBC040010ProcessParameter param = getParameter().toDBC040010ProcessParameter();
        return loopBatch(DBC040010ShoriDateKanriUpdProcess.class).arguments(param).define();
    }

}
