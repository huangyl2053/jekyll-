/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb2310001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001.NenkinTokuChoKaifuJohoSelectProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001.NenkinTokuChoTaishosyaJohoInsertProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001.ShoriDateKanriUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001.TokuChoJohoTorikomiRirekiTuikaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001.TuikaDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * DBB2310001_TokuchoSeidokanIFSakuseiFlowのクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class DBB2310001_TokuchoSeidokanIFSakuseiFlow
        extends BatchFlowBase<TokuchoSeidokanIFSakuseiBatchParameter> {

    @Override
    protected void defineFlow() {
        getParameter().set遷移元メニュー(ResponseHolder.getMenuID());
        executeStep(年金特徴回付情報の抽出);
        executeStep(介護特別徴収情報取込履歴追加);
        executeStep(介護保険年金特徴対象者情報追加用データ作成);
        executeStep(介護保険年金特徴対象者情報登録);
        executeStep(処理日付管理マスタ更新);
    }
    private static final String 年金特徴回付情報の抽出 = "nenkinTokuChoKaifuJohoSelectProcess";
    private static final String 介護特別徴収情報取込履歴追加 = "tokuChoJohoTorikomiRirekiTuikaProcess";
    private static final String 介護保険年金特徴対象者情報追加用データ作成 = "tuikaDataSakuseiProcess";
    private static final String 介護保険年金特徴対象者情報登録 = "nenkinTokuChoTaishosyaJohoInsertProcess";
    private static final String 処理日付管理マスタ更新 = "shoriDateKanriUpdateProcess";

    /**
     * 年金特徴回付情報の抽出です。
     *
     * @return IBatchFlowCommand
     */
    @Step(年金特徴回付情報の抽出)
    protected IBatchFlowCommand nenkinTokuChoKaifuJohoSelectProcess() {
        return loopBatch(NenkinTokuChoKaifuJohoSelectProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }

    /**
     * 介護特別徴収情報取込履歴追加です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護特別徴収情報取込履歴追加)
    protected IBatchFlowCommand tokuChoJohoTorikomiRirekiTuikaProcess() {
        return loopBatch(TokuChoJohoTorikomiRirekiTuikaProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }

    /**
     * 介護保険年金特徴対象者情報追加用データ作成です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護保険年金特徴対象者情報追加用データ作成)
    protected IBatchFlowCommand tuikaDataSakuseiProcess() {
        return loopBatch(TuikaDataSakuseiProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }

    /**
     * 介護保険年金特徴対象者情報登録です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護保険年金特徴対象者情報登録)
    protected IBatchFlowCommand nenkinTokuChoTaishosyaJohoInsertProcess() {
        return loopBatch(NenkinTokuChoTaishosyaJohoInsertProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }

    /**
     * 処理日付管理マスタ更新です。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタ更新)
    protected IBatchFlowCommand shoriDateKanriUpdateProcess() {
        return loopBatch(ShoriDateKanriUpdateProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }
}
