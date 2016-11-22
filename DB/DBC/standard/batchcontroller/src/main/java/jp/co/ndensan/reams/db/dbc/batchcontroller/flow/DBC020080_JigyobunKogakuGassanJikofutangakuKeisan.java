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
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.DBC020080_JigyobunKogakuGassanJikofutangakuKeisanProcessParameter;
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

    private static final String TAISHOSHACHUSHUJIGYOBUNPPROCESS = "TaishoshaChushuJigyobunProcess";
    private static final String BACKUP_TO_TEMPORARYTABLE = "backup_To_TemporaryTable";
    private static final String INITJISSEKICHECKPROCESS = "InitJissekiCheckProcess";
    private static final String INSSHIHARAIHOHOHENKOTEMPBEFOREPROCESS = "InsShiharaihohoHenkoTempBeforeProcess";
    private static final String INSSHIHARAIHOHOHENKOTEMPPROCESS = "InsShiharaihohoHenkoTempProcess";
    private static final String UPDSHAFUKUKEIGENTEMPPROCESS = "UpdshafukuKeigenTempProcess";
    private static final String UPDJISSEKIFUTANGAKUTEMPPROCESS = "UpdJIssekiFutangakuTempProcess";
    private static final String UPDJISSEKIFUTANGAKUTEMPAFTERPROCESS = "UpdJIssekiFutangakuTempAfterProcess";
    private static final String CALCKOGAKUSHIKYUGAKUPROCESS = "CalcKogakuShikyugakuProcess";
    private static final String SETFUTANGAKUPROCESS = "SetFutangakuProcess";
    private static final String SETFUTANGAKUAFTERPROCESS = "SetFutangakuAfterProcess";
    private static final String GASSANJIGYOBUNJIKOFUTANGAKUKEISANKEKKAICHAIRAN = "GassanJigyobunJikofutangakuKeisanKekkaIchiranProcess";
    private static final String DBC040010SHORICSVPROCESS = "DBC040010ShoriCsvProcess";
    private static final String UPDSHORIDATEKANRIPROCESS = "UpdShoriDateKanriProcess";
    private static final RString BACKUPTABLE = new RString("DbT3070KogakuGassanJikoFutanGaku");
    private static final RString TEMPTABLE = new RString("DbT3070TempTable");
    private static final RString 処理区分_呼び出し元自己負担額計算 = new RString("3");

    @Override
    protected void defineFlow() {
        executeStep(BACKUP_TO_TEMPORARYTABLE);
        executeStep(TAISHOSHACHUSHUJIGYOBUNPPROCESS);
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
        if (getParameter().isShuturyokuFlg()) {
            executeStep(GASSANJIGYOBUNJIKOFUTANGAKUKEISANKEKKAICHAIRAN);
        }
        executeStep(DBC040010SHORICSVPROCESS);
        executeStep(UPDSHORIDATEKANRIPROCESS);
    }

    @Step(BACKUP_TO_TEMPORARYTABLE)
    IBatchFlowCommand backupToTemporaryTable() {
        return backupToTemporaryTable(BACKUPTABLE, TEMPTABLE).define();
    }

    @Step(TAISHOSHACHUSHUJIGYOBUNPPROCESS)
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
        UpdshafukuKeigenTempProcessParameter param = new UpdshafukuKeigenTempProcessParameter(true);
        return loopBatch(UpdshafukuKeigenTempProcess.class).arguments(param).define();
    }

    @Step(UPDJISSEKIFUTANGAKUTEMPPROCESS)
    IBatchFlowCommand updJIssekiFutangakuTempProcess() {
        return loopBatch(UpdJIssekiFutangakuTempProcess.class).define();
    }

    @Step(UPDJISSEKIFUTANGAKUTEMPAFTERPROCESS)
    IBatchFlowCommand updJIssekiFutangakuTempAfterProcess() {
        UpdJIssekiFutangakuTempAfterProcessParameter param = new UpdJIssekiFutangakuTempAfterProcessParameter(
                処理区分_呼び出し元自己負担額計算, getParameter().getShoriTime());
        return loopBatch(UpdJIssekiFutangakuTempAfterProcess.class).arguments(param).define();
    }

    @Step(CALCKOGAKUSHIKYUGAKUPROCESS)
    IBatchFlowCommand calcKogakuShikyugakuProcess() {
        CalcKogakuShikyugakuProcessParameter param = new CalcKogakuShikyugakuProcessParameter(getParameter().getShoriTime());
        return loopBatch(CalcKogakuShikyugakuProcess.class).arguments(param).define();
    }

    @Step(SETFUTANGAKUPROCESS)
    IBatchFlowCommand setFutangakuProcess() {
        SetFutangakuProcessParameter param = new SetFutangakuProcessParameter(true, getParameter().getRadSakuseiJoken());
        return loopBatch(SetFutangakuProcess.class).arguments(param).define();
    }

    @Step(SETFUTANGAKUAFTERPROCESS)
    IBatchFlowCommand setFutangakuAfterProcess() {
        SetFutangakuAfterProcessParameter param = new SetFutangakuAfterProcessParameter(getParameter().getShoriTime());
        return loopBatch(SetFutangakuAfterProcess.class).arguments(param).define();
    }

    @Step(GASSANJIGYOBUNJIKOFUTANGAKUKEISANKEKKAICHAIRAN)
    IBatchFlowCommand gassanJigyobunJikofutangakuKeisanKekkaIchiranProcess() {
        DBC040010ProcessParameter param = new DBC040010ProcessParameter();
        param.set処理日時(getParameter().getShoriTime());
        param.set市町村コード(getParameter().getDantaiCd());
        param.set帳票出力順ID(getParameter().getShutsuryokujunId());
        return loopBatch(GassanJigyobunJikofutangakuKeisanKekkaIchiranProcess.class).arguments(param).define();
    }

    @Step(DBC040010SHORICSVPROCESS)
    IBatchFlowCommand dBC040010ShoriCsvProcess() {
        DBC040010ProcessParameter param = new DBC040010ProcessParameter();
        param.set処理日時(getParameter().getShoriTime());
        return loopBatch(DBC040010ShoriCsvProcess.class).arguments(param).define();
    }

    @Step(UPDSHORIDATEKANRIPROCESS)
    IBatchFlowCommand updShoriDateKanriProcess() {
        DBC020080_JigyobunKogakuGassanJikofutangakuKeisanProcessParameter param
                = new DBC020080_JigyobunKogakuGassanJikofutangakuKeisanProcessParameter();
        param.set処理日時(getParameter().getShoriTime());
        param.set受取年月(getParameter().getUketoriym());
        param.set市町村コード(getParameter().getDantaiCd());
        return loopBatch(UpdShoriDateKanriProcess.class).arguments(param).define();
    }
}
