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

    private static final String CHUSHUPROCESS = "TaishoshaChushuProcess";
    private static final String JISSEKICHECKINITPROCESS = "InitJissekiCheckProcess";
    private static final String INSSHIHARAIHOHOHENKOPROCESS1 = "InsShiharaihohoHenkoTempBeforeProcess";
    private static final String INSSHIHARAIHOHOHENKOPROCESS2 = "InsShiharaihohoHenkoTempProcess";
    private static final String UPDSHAFUKUKEIGENPROCESS = "UpdshafukuKeigenTempProcess";
    private static final String UPDJISSEKIFUTANGAKUPROCESS1 = "UpdJIssekiFutangakuTempProcess";
    private static final String UPDJISSEKIFUTANGAKUPROCESS2 = "UpdJIssekiFutangakuTempAfterProcess";
    private static final String CKOGAKUSHIKYUGAKUCALPROCESS = "CalcKogakuShikyugakuProcess";
    private static final String FUTANGAKUSETPROCESS = "SetFutangakuProcess";
    private static final String FUTANGAKUAFTERSETPROCESS = "SetFutangakuAfterProcess";
    private static final String GASSANKEKKAICHIRANPROCESS = "DBC200029GassanKekkaIchiranReportProcess";
    private static final String SHORICSVPROCESS = "DBC040010ShoriCsvProcess";
    private static final String SHORIDATEKANRIUPDPROCESS = "DBC040010ShoriDateKanriUpdProcess";
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
        executeStep(CHUSHUPROCESS);
        executeStep(JISSEKICHECKINITPROCESS);
        boolean isデータがあり = getResult(Boolean.class, new RString(JISSEKICHECKINITPROCESS), InitJissekiCheckProcess.OUTPUTNAME);
        if (!isデータがあり) {
            return;
        }
        executeStep(INSSHIHARAIHOHOHENKOPROCESS1);
        executeStep(INSSHIHARAIHOHOHENKOPROCESS2);
        executeStep(UPDSHAFUKUKEIGENPROCESS);
        executeStep(UPDJISSEKIFUTANGAKUPROCESS1);
        executeStep(UPDJISSEKIFUTANGAKUPROCESS2);
        executeStep(CKOGAKUSHIKYUGAKUCALPROCESS);
        executeStep(FUTANGAKUSETPROCESS);
        executeStep(FUTANGAKUAFTERSETPROCESS);
        if (getParameter().isShuturyokuFlg()) {
            executeStep(GASSANKEKKAICHIRANPROCESS);
        }
        executeStep(SHORICSVPROCESS);
        executeStep(SHORIDATEKANRIUPDPROCESS);
    }

    @Step(BACKUP_TO_TEMPORARYTABLE)
    IBatchFlowCommand backupToTemporaryTable() {
        return backupToTemporaryTable(importTableNamePermanent, exportTableNameTemporary).define();
    }

    @Step(CHUSHUPROCESS)
    IBatchFlowCommand taishoshaChushuProcess() {
        TaishoshaChushuProcessParameter param = new TaishoshaChushuProcessParameter(getParameter().getShoriTimestamp(),
                getParameter().getTaishoKaishiDay(), getParameter().getTaishoShuryoDay());
        return loopBatch(TaishoshaChushuProcess.class).arguments(param).define();
    }

    @Step(JISSEKICHECKINITPROCESS)
    IBatchFlowCommand initJissekiCheckProcess() {
        return simpleBatch(InitJissekiCheckProcess.class).define();
    }

    @Step(INSSHIHARAIHOHOHENKOPROCESS1)
    IBatchFlowCommand insShiharaihohoHenkoTempBeforeProcess() {
        InsShiharaihohoHenkoTempBeforeProcessParameter param
                = new InsShiharaihohoHenkoTempBeforeProcessParameter(false);
        return loopBatch(InsShiharaihohoHenkoTempBeforeProcess.class).arguments(param).define();
    }

    @Step(INSSHIHARAIHOHOHENKOPROCESS2)
    IBatchFlowCommand insShiharaihohoHenkoTempProcess() {
        return loopBatch(InsShiharaihohoHenkoTempProcess.class).define();
    }

    @Step(UPDSHAFUKUKEIGENPROCESS)
    IBatchFlowCommand updshafukuKeigenTempProcess() {
        UpdshafukuKeigenTempProcessParameter param = new UpdshafukuKeigenTempProcessParameter(false);
        return loopBatch(UpdshafukuKeigenTempProcess.class).arguments(param).define();
    }

    @Step(UPDJISSEKIFUTANGAKUPROCESS1)
    IBatchFlowCommand updJIssekiFutangakuTempProcess() {
        return loopBatch(UpdJIssekiFutangakuTempProcess.class).define();
    }

    @Step(UPDJISSEKIFUTANGAKUPROCESS2)
    IBatchFlowCommand updJIssekiFutangakuTempAfterProcess() {
        UpdJIssekiFutangakuTempAfterProcessParameter param = new UpdJIssekiFutangakuTempAfterProcessParameter(
                処理区分_呼び出し元自己負担額計算, getParameter().getShoriTimestamp());
        return loopBatch(UpdJIssekiFutangakuTempAfterProcess.class).arguments(param).define();
    }

    @Step(CKOGAKUSHIKYUGAKUCALPROCESS)
    IBatchFlowCommand calcKogakuShikyugakuProcess() {
        CalcKogakuShikyugakuProcessParameter param = new CalcKogakuShikyugakuProcessParameter(getParameter().getShoriTimestamp());
        return loopBatch(CalcKogakuShikyugakuProcess.class).arguments(param).define();
    }

    @Step(FUTANGAKUSETPROCESS)
    IBatchFlowCommand setFutangakuProcess() {
        SetFutangakuProcessParameter param = new SetFutangakuProcessParameter(false, RString.EMPTY);
        return loopBatch(SetFutangakuProcess.class).arguments(param).define();
    }

    @Step(FUTANGAKUAFTERSETPROCESS)
    IBatchFlowCommand setFutangakuAfterProcess() {
        SetFutangakuAfterProcessParameter param = new SetFutangakuAfterProcessParameter(getParameter().getShoriTimestamp());
        return loopBatch(SetFutangakuAfterProcess.class).arguments(param).define();
    }

    @Step(GASSANKEKKAICHIRANPROCESS)
    IBatchFlowCommand dBC200029GassanKekkaIchiranReportProcess() {
        DBC040010ProcessParameter param = getParameter().toDBC040010ProcessParameter();
        return loopBatch(DBC200029GassanKekkaIchiranReportProcess.class).arguments(param).define();
    }

    @Step(SHORICSVPROCESS)
    IBatchFlowCommand dBC040010ShoriCsvProcess() {
        DBC040010ProcessParameter param = getParameter().toDBC040010ProcessParameter();
        return loopBatch(DBC040010ShoriCsvProcess.class).arguments(param).define();
    }

    @Step(SHORIDATEKANRIUPDPROCESS)
    IBatchFlowCommand dBC040010ShoriDateKanriUpdProcess() {
        DBC040010ProcessParameter param = getParameter().toDBC040010ProcessParameter();
        return loopBatch(DBC040010ShoriDateKanriUpdProcess.class).arguments(param).define();
    }

}
