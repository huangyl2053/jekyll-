/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb112002;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001.SystemTimeHonsanteiFukaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001.CheckShotokuJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001.ConfigUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001.InsKaigoShotokuKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001.SelectShotokuJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001.SpoolShotokuJohoIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb112001.UpdShoriHidukeKanriProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112002.DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携_当初広域のバッチFlowです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class DBB112002_ToushoShotokuJohoChushutsuRenkeiKoiki extends BatchFlowBase<DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String CSVファイル読み込み = "csvFileYomikomi";
    private static final String 所得情報をチェックとEUCファイル出力 = "callCheckShotokuJohoProcess";
    private static final String 介護所得TEMPテーブルに登録 = "callInsKaigoShotokuKanriProcess";
    private static final String 帳票とEUCファイル出力 = "callSpoolShotokuJohoIchiranProcess";
    private static final String 処理日付管理マスタの更新 = "callUpdShoriHidukeKanriProcess";
    private static final String 業務コンフィグの更新 = "callConfigUpdateProcess";

    private ShutokuJohoShuchutsuRenkeiProcessParameter processParameter;

    @Override
    protected void initialize() {
        processParameter = getParameter().toProcessParamter();
        executeStep(システム日時の取得);
        YMDHMS システム日時 = getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeHonsanteiFukaProcess.SYSTEM_TIME);
        processParameter.set処理日時(システム日時);
    }

    @Override
    protected void defineFlow() {
        executeStep(CSVファイル読み込み);
        executeStep(所得情報をチェックとEUCファイル出力);
        executeStep(介護所得TEMPテーブルに登録);
        executeStep(帳票とEUCファイル出力);
        executeStep(処理日付管理マスタの更新);
        executeStep(業務コンフィグの更新);
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        return simpleBatch(SystemTimeHonsanteiFukaProcess.class).define();
    }

    /**
     * CSVファイル読み込みを行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(CSVファイル読み込み)
    protected IBatchFlowCommand csvFileYomikomi() {
        return loopBatch(SelectShotokuJohoProcess.class).arguments(processParameter).define();
    }

    /**
     * 所得情報をチェックとEUCファイル出力を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(所得情報をチェックとEUCファイル出力)
    protected IBatchFlowCommand callCheckShotokuJohoProcess() {
        return loopBatch(CheckShotokuJohoProcess.class).arguments(processParameter).define();
    }

    /**
     * 介護所得Tempテーブルに登録を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護所得TEMPテーブルに登録)
    protected IBatchFlowCommand callInsKaigoShotokuKanriProcess() {
        return loopBatch(InsKaigoShotokuKanriProcess.class).define();
    }

    /**
     * 帳票とEUCファイル出力を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票とEUCファイル出力)
    protected IBatchFlowCommand callSpoolShotokuJohoIchiranProcess() {
        return loopBatch(SpoolShotokuJohoIchiranProcess.class).arguments(processParameter).define();
    }

    /**
     * 帳票とEUCファイル出力を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタの更新)
    protected IBatchFlowCommand callUpdShoriHidukeKanriProcess() {
        return loopBatch(UpdShoriHidukeKanriProcess.class).arguments(processParameter).define();
    }

    /**
     * 業務コンフィグの更新を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(業務コンフィグの更新)
    protected IBatchFlowCommand callConfigUpdateProcess() {
        return simpleBatch(ConfigUpdateProcess.class).arguments(processParameter).define();
    }
}
