/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001.InsKaigoNenkinTokuchoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001.InsTorikomiRirekiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001.InsTsuikaTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB231001.DBB231001_TokuchoSeidokanIFSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * DBB2310001_TokuchoSeidokanIFSakuseiFlowのクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class DBB231001_TokuchoSeidokanIFSakusei
        extends BatchFlowBase<DBB231001_TokuchoSeidokanIFSakuseiParameter> {

    @Override
    protected void defineFlow() {
        getParameter().setシステム日時(RDateTime.now());
        executeStep(介護特別徴収情報取込履歴追加);
        executeStep(介護保険年金特徴対象者情報追加用データ作成);
        executeStep(介護保険年金特徴対象者情報登録);
        executeStep(処理日付管理マスタ更新);
    }
    private static final String 介護特別徴収情報取込履歴追加 = "tokuChoJohoTorikomiRirekiTuikaProcess";
    private static final String 介護保険年金特徴対象者情報追加用データ作成 = "tuikaDataSakuseiProcess";
    private static final String 介護保険年金特徴対象者情報登録 = "nenkinTokuChoTaishosyaJohoInsertProcess";
    private static final String 処理日付管理マスタ更新 = "shoriDateKanriUpdateProcess";

    /**
     * 介護特別徴収情報取込履歴追加です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護特別徴収情報取込履歴追加)
    protected IBatchFlowCommand tokuChoJohoTorikomiRirekiTuikaProcess() {
        return simpleBatch(InsTorikomiRirekiProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }

    /**
     * 介護保険年金特徴対象者情報追加用データ作成です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護保険年金特徴対象者情報追加用データ作成)
    protected IBatchFlowCommand tuikaDataSakuseiProcess() {
        return loopBatch(InsTsuikaTempProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }

    /**
     * 介護保険年金特徴対象者情報登録です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護保険年金特徴対象者情報登録)
    protected IBatchFlowCommand nenkinTokuChoTaishosyaJohoInsertProcess() {
        return loopBatch(InsKaigoNenkinTokuchoProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }

    /**
     * 処理日付管理マスタ更新です。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタ更新)
    protected IBatchFlowCommand shoriDateKanriUpdateProcess() {
        return simpleBatch(UpdShoriDateKanriProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }
}
