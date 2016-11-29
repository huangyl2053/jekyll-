/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.GassanJigyobunJikofutangakuKeisanKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.CalcKogakuShikyugakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.DBC040010ShoriCsvProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InitJissekiCheckProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InsShiharaihohoHenkoTempBeforeProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.InsShiharaihohoHenkoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.SetFutangakuAfterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.SetFutangakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.TaishoshaChushuJigyobunProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdJIssekiFutangakuTempAfterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdJIssekiFutangakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010.UpdshafukuKeigenTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020080.DBC020080_JigyobunKogakuGassanJikofutangakuKeisanParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.DBC020080JigyobunKogakuGassanJikofutangakuKeisanProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.CalcKogakuShikyugakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.DBC040010ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.InsShiharaihohoHenkoTempBeforeProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.SetFutangakuAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.SetFutangakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.TaishoshaChushuJigyobunProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.UpdJIssekiFutangakuTempAfterProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.UpdshafukuKeigenTempProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）のバッチフロークラスです。
 *
 * @reamsid_L DBC-4790-030 pengxingyi
 */
public class DBC020080_JigyobunKogakuGassanJikofutangakuKeisan extends BatchFlowBase<DBC020080_JigyobunKogakuGassanJikofutangakuKeisanParameter> {

    private static final String TAISHOSHACHUSHUJIGYOBUNP = "TaishoshaChushuJigyobunProcess";
    private static final String BACKUP_TO_TEMPORARYTABLE = "backup_To_TemporaryTable";
    private static final String INITJISSEKICHECK = "InitJissekiCheckProcess";
    private static final String INSSHIHARAIHOHOHENKOBEFORE = "InsShiharaihohoHenkoTempBeforeProcess";
    private static final String INSSHIHARAIHOHOHENKOTEMP = "InsShiharaihohoHenkoTempProcess";
    private static final String UPDSHAFUKUKEIGENTEMP = "UpdshafukuKeigenTempProcess";
    private static final String UPDJISSEKIFUTANGAKUTEMP = "UpdJIssekiFutangakuTempProcess";
    private static final String UPDJISSEKIFUTANGAKUTEMPAFTER = "UpdJIssekiFutangakuTempAfterProcess";
    private static final String CALCKOGAKUSHIKYUGAKU = "CalcKogakuShikyugakuProcess";
    private static final String SETFUTANGAKU = "SetFutangakuProcess";
    private static final String SETFUTANGAKUAFTER = "SetFutangakuAfterProcess";
    private static final String GASSANJIGYOBUN = "GassanJigyobunJikofutangakuKeisanKekkaIchiranProcess";
    private static final String DBC040010SHORICSV = "DBC040010ShoriCsvProcess";
    private static final String UPDSHORIDATEKANRI = "UpdShoriDateKanriProcess";
    private static final RString BACKUPTABLE = new RString("DbT3070KogakuGassanJikoFutanGaku");
    private static final RString TEMPTABLE = new RString("DbT3070TempTable");
    private static final RString 処理区分_呼び出し元自己負担額計算 = new RString("3");

    @Override
    protected void defineFlow() {
        executeStep(BACKUP_TO_TEMPORARYTABLE);
        executeStep(TAISHOSHACHUSHUJIGYOBUNP);
        executeStep(INITJISSEKICHECK);
        boolean isデータがあり = getResult(Boolean.class, new RString(INITJISSEKICHECK), InitJissekiCheckProcess.OUTPUTNAME);
        if (!isデータがあり) {
            return;
        }
        executeStep(INSSHIHARAIHOHOHENKOBEFORE);
        executeStep(INSSHIHARAIHOHOHENKOTEMP);
        executeStep(UPDSHAFUKUKEIGENTEMP);
        executeStep(UPDJISSEKIFUTANGAKUTEMP);
        executeStep(UPDJISSEKIFUTANGAKUTEMPAFTER);
        executeStep(CALCKOGAKUSHIKYUGAKU);
        executeStep(SETFUTANGAKU);
        executeStep(SETFUTANGAKUAFTER);
        if (getParameter().isShuturyokuFlg()) {
            executeStep(GASSANJIGYOBUN);
        }
        executeStep(DBC040010SHORICSV);
        executeStep(UPDSHORIDATEKANRI);
    }

    @Step(BACKUP_TO_TEMPORARYTABLE)
    IBatchFlowCommand backupToTemporaryTable() {
        return backupToTemporaryTable(BACKUPTABLE, TEMPTABLE).define();
    }

    @Step(TAISHOSHACHUSHUJIGYOBUNP)
    IBatchFlowCommand taishoshaChushuJigyobunProcess() {
        TaishoshaChushuJigyobunProcessParameter param = new TaishoshaChushuJigyobunProcessParameter();
        param.set処理日時(getParameter().getShoriTime());
        param.set出力対象区分(getParameter().getRadSakuseiJoken());
        param.set被保険者番号(getParameter().getHihokenshano());
        param.set年度(getParameter().getNendo());
        if (getParameter().getUketoriym() != null) {
            param.set抽出期間開始年月(getParameter().getUketoriym().toDateString());
        }
        return loopBatch(TaishoshaChushuJigyobunProcess.class).arguments(param).define();
    }

    @Step(INITJISSEKICHECK)
    IBatchFlowCommand initJissekiCheckProcess() {
        return simpleBatch(InitJissekiCheckProcess.class).define();
    }

    @Step(INSSHIHARAIHOHOHENKOBEFORE)
    IBatchFlowCommand insShiharaihohoHenkoTempBeforeProcess() {
        InsShiharaihohoHenkoTempBeforeProcessParameter param
                = new InsShiharaihohoHenkoTempBeforeProcessParameter(false);
        return loopBatch(InsShiharaihohoHenkoTempBeforeProcess.class).arguments(param).define();
    }

    @Step(INSSHIHARAIHOHOHENKOTEMP)
    IBatchFlowCommand insShiharaihohoHenkoTempProcess() {
        return loopBatch(InsShiharaihohoHenkoTempProcess.class).define();
    }

    @Step(UPDSHAFUKUKEIGENTEMP)
    IBatchFlowCommand updshafukuKeigenTempProcess() {
        UpdshafukuKeigenTempProcessParameter param = new UpdshafukuKeigenTempProcessParameter(true);
        return loopBatch(UpdshafukuKeigenTempProcess.class).arguments(param).define();
    }

    @Step(UPDJISSEKIFUTANGAKUTEMP)
    IBatchFlowCommand updJIssekiFutangakuTempProcess() {
        return loopBatch(UpdJIssekiFutangakuTempProcess.class).define();
    }

    @Step(UPDJISSEKIFUTANGAKUTEMPAFTER)
    IBatchFlowCommand updJIssekiFutangakuTempAfterProcess() {
        UpdJIssekiFutangakuTempAfterProcessParameter param = new UpdJIssekiFutangakuTempAfterProcessParameter(
                処理区分_呼び出し元自己負担額計算, getParameter().getShoriTime());
        return loopBatch(UpdJIssekiFutangakuTempAfterProcess.class).arguments(param).define();
    }

    @Step(CALCKOGAKUSHIKYUGAKU)
    IBatchFlowCommand calcKogakuShikyugakuProcess() {
        CalcKogakuShikyugakuProcessParameter param = new CalcKogakuShikyugakuProcessParameter(getParameter().getShoriTime());
        return loopBatch(CalcKogakuShikyugakuProcess.class).arguments(param).define();
    }

    @Step(SETFUTANGAKU)
    IBatchFlowCommand setFutangakuProcess() {
        SetFutangakuProcessParameter param = new SetFutangakuProcessParameter(true, getParameter().getRadSakuseiJoken());
        return loopBatch(SetFutangakuProcess.class).arguments(param).define();
    }

    @Step(SETFUTANGAKUAFTER)
    IBatchFlowCommand setFutangakuAfterProcess() {
        SetFutangakuAfterProcessParameter param = new SetFutangakuAfterProcessParameter(getParameter().getShoriTime());
        return loopBatch(SetFutangakuAfterProcess.class).arguments(param).define();
    }

    @Step(GASSANJIGYOBUN)
    IBatchFlowCommand gassanJigyobunJikofutangakuKeisanKekkaIchiranProcess() {
        DBC040010ProcessParameter param = new DBC040010ProcessParameter();
        param.set処理日時(getParameter().getShoriTime());
        param.set市町村コード(getParameter().getDantaiCd());
        param.set帳票出力順ID(getParameter().getShutsuryokujunId());
        return loopBatch(GassanJigyobunJikofutangakuKeisanKekkaIchiranProcess.class).arguments(param).define();
    }

    @Step(DBC040010SHORICSV)
    IBatchFlowCommand dBC040010ShoriCsvProcess() {
        DBC040010ProcessParameter param = new DBC040010ProcessParameter();
        param.set処理日時(getParameter().getShoriTime());
        return loopBatch(DBC040010ShoriCsvProcess.class).arguments(param).define();
    }

    @Step(UPDSHORIDATEKANRI)
    IBatchFlowCommand updShoriDateKanriProcess() {
        DBC020080JigyobunKogakuGassanJikofutangakuKeisanProcessParameter param
                = new DBC020080JigyobunKogakuGassanJikofutangakuKeisanProcessParameter();
        param.set処理日時(getParameter().getShoriTime());
        param.set受取年月(getParameter().getUketoriym());
        param.set市町村コード(getParameter().getDantaiCd());
        return loopBatch(UpdShoriDateKanriProcess.class).arguments(param).define();
    }
}
