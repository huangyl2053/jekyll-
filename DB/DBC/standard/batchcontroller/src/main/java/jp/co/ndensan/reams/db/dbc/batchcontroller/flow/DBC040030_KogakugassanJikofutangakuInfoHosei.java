/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030.FutangakuTashoshaInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030.GetGassanJikofutangakuHoseiIchiranProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030.GetKogakugassanJikofutangakuInfoHoseiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030.KogakuGassanJikoFutanGakuMeiseiUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030.KogakuGassanJikoFutanGakuUpdateProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040030.DBC040030_KogakugassanJikofutangakuInfoHoseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040031.DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040030.KogakugassanJikofutangakuInfoHoseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報補正（一括）のバッチ処理フローです。
 *
 * @reamsid_L DBC-2320-030 chenyadong
 */
public class DBC040030_KogakugassanJikofutangakuInfoHosei extends BatchFlowBase<DBC040030_KogakugassanJikofutangakuInfoHoseiParameter> {

    private static final String BACKUP3070_TO_TEMPORARY_TABLE = "backupDbT3070KogakuGassanJikoFutanGaku";
    private static final String BACKUP3071_TO_TEMPORARY_TABLE = "backupDbT3071KogakuGassanJikoFutanGakuMeisai";
    private static final String 中間DB自己負担額データを書き込む = "getKogakugassanJikofutangakuInfoHoseiTempProcess";
    private static final String バッチ高額合算自己負担額情報一括補正サブ処理を呼び出し = "doKogakugassanJikofutangakuInfoHoseiSub";
    private static final String 高額合算自己負担額明細情報更新 = "kogakuGassanJikoFutanGakuMeiseiUpdateProcess";
    private static final String 高額合算自己負担額情報更新 = "kogakuGassanJikoFutanGakuUpdateProcess";
    private static final String 負担額補正対象者データ更新 = "futangakuTashoshaInsertProcess";
    private static final RString BATCH_ID = new RString("DBC040031_KogakugassanJikofutangakuInfoHoseiSub");
    private static final String 帳票出力 = "getGassanJikofutangakuHoseiIchiranProcess";
    private static final RString IMPORTTABLENAMEPERMANENT3070 = new RString("DbT3070KogakuGassanJikoFutanGaku");
    private static final RString TABLENAMEFORTAIHITEMP3070 = new RString("DbT3070KogakuGassanJikoFutanGakuTemp");
    private static final RString IMPORTTABLENAMEPERMANENT3071 = new RString("DbT3071KogakuGassanJikoFutanGakuMeisai");
    private static final RString TABLENAMEFORTAIHITEMP3071 = new RString("DbT3071KogakuGassanJikoFutanGakuMeisaiTemp");

    @Override
    protected void defineFlow() {
        executeStep(BACKUP3070_TO_TEMPORARY_TABLE);
        executeStep(BACKUP3071_TO_TEMPORARY_TABLE);
        executeStep(中間DB自己負担額データを書き込む);
        executeStep(バッチ高額合算自己負担額情報一括補正サブ処理を呼び出し);
        executeStep(高額合算自己負担額情報更新);
        executeStep(高額合算自己負担額明細情報更新);
        executeStep(負担額補正対象者データ更新);
        executeStep(帳票出力);
    }

    /**
     * データのバックアップのメソッドです。
     *
     * @return データのバックアップ
     */
    @Step(BACKUP3070_TO_TEMPORARY_TABLE)
    protected IBatchFlowCommand backupDbT3070KogakuGassanJikoFutanGaku() {
        return backupToTemporaryTable(IMPORTTABLENAMEPERMANENT3070, TABLENAMEFORTAIHITEMP3070).
                define();
    }

    /**
     * データのバックアップのメソッドです。
     *
     * @return データのバックアップ
     */
    @Step(BACKUP3071_TO_TEMPORARY_TABLE)
    protected IBatchFlowCommand backupShikyuuKetteiTsuuchisho() {
        return backupToTemporaryTable(IMPORTTABLENAMEPERMANENT3071, TABLENAMEFORTAIHITEMP3071).
                define();
    }

    /**
     * 中間DB自己負担額データを書き込むのメソッドです。
     *
     * @return 中間DB自己負担額データを書き込むProcess
     */
    @Step(中間DB自己負担額データを書き込む)
    protected IBatchFlowCommand getKogakugassanJikofutangakuInfoHoseiTempProcess() {
        return loopBatch(GetKogakugassanJikofutangakuInfoHoseiTempProcess.class).arguments(setParameter()).define();
    }

    /**
     * 帳票出力のメソッドです。
     *
     * @return 帳票出力Process
     */
    @Step(帳票出力)
    protected IBatchFlowCommand getGassanJikofutangakuHoseiIchiranProcess() {
        return loopBatch(GetGassanJikofutangakuHoseiIchiranProcess.class).arguments(setParameter()).define();
    }

    /**
     * バッチ_高額合算自己負担額情報一括補正サブ処理(DBC040031_KogakugassanJikofutangakuInfoHoseiSub)を呼び出しクラスです。
     *
     * @return DoBatchTokuchoDoteiProcess
     */
    @Step(バッチ高額合算自己負担額情報一括補正サブ処理を呼び出し)
    protected IBatchFlowCommand doKogakugassanJikofutangakuInfoHoseiSub() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBC介護給付,
                getBatchParamter()).define();
    }

    /**
     * 高額合算自己負担額明細情報更新のメソッドです。
     *
     * @return 高額合算自己負担額明細情報更新Process
     */
    @Step(高額合算自己負担額明細情報更新)
    protected IBatchFlowCommand kogakuGassanJikoFutanGakuMeiseiUpdateProcess() {
        return loopBatch(KogakuGassanJikoFutanGakuMeiseiUpdateProcess.class).arguments(setParameter()).define();
    }

    /**
     * 高額合算自己負担額情報更新のメソッドです。
     *
     * @return 高額合算自己負担額情報更新Process
     */
    @Step(高額合算自己負担額情報更新)
    protected IBatchFlowCommand kogakuGassanJikoFutanGakuUpdateProcess() {
        return loopBatch(KogakuGassanJikoFutanGakuUpdateProcess.class).arguments(setParameter()).define();
    }

    /**
     * 負担額補正対象者データ更新のメソッドです。
     *
     * @return 負担額補正対象者データ更新Process
     */
    @Step(負担額補正対象者データ更新)
    protected IBatchFlowCommand futangakuTashoshaInsertProcess() {
        return loopBatch(FutangakuTashoshaInsertProcess.class).arguments(setParameter()).define();
    }

    private KogakugassanJikofutangakuInfoHoseiProcessParameter setParameter() {
        KogakugassanJikofutangakuInfoHoseiProcessParameter parameter = new KogakugassanJikofutangakuInfoHoseiProcessParameter();
        parameter.setKakunin_UketoriYM(new FlexibleYearMonth(getParameter().getKakunin_UketoriYM()));
        parameter.setHandleTimestamp(getParameter().getHandleTimestamp());
        parameter.set改頁出力順ID(getParameter().getShutsuryokujunId());
        parameter.set開始年月日(getParameter().getKaishiYMD());
        parameter.set終了年月日(getParameter().getShuryoYMD());
        parameter.set開始時間(getParameter().getKaishiHHMM());
        parameter.set終了時間(getParameter().getShuryoHHMM());
        parameter.set開始曜日(getParameter().getKaishiWeek());
        parameter.set終了曜日(getParameter().getShuryoWeek());
        return parameter;
    }

    private DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter getBatchParamter() {

        DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter parameter = new DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter();
        parameter.set処理区分(getParameter().getTreatmentType());
        return parameter;
    }
}
