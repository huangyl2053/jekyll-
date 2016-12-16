/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku.HanteiKekkaIchiranA3Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku.HanteiKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku.HanteikekkaKagamiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku.KekkatsuchiIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku.ShinsakaiGijirokuProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525001.DBE525001_HanteiKekkaShinsakaiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 判定結果情報出力(介護認定審査会)バッチ処理クラスです。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public class DBE525001_HanteiKekkaShinsakai extends BatchFlowBase<DBE525001_HanteiKekkaShinsakaiParameter> {

    private static final String HANTEIKEKKA_PROCESS = "hanteiKekkaIchiranProcess";
    private static final String HANTEIKEKKA_A3_PROCESS = "hanteiKekkaIchiranA3Process";
    private static final String HANTEIKEKKA_KAGAMI_PROCESS = "hanteiKekkaIchiranKagamiProcess";
    private static final String GIJIROKUSHUTURYOKU_PROCESS = "gijirokuShuturyokuProcess";
    private static final String KEKKATSUCHI_PROCESS = "kekkatsuchiIchiranhyoProcess";

    @Override
    protected void defineFlow() {
        if (getParameter().isPublish_HanteiKekkaA3()) {
            executeStep(HANTEIKEKKA_A3_PROCESS);
        }
        if (getParameter().isPublish_HanteiKekka()) {
            executeStep(HANTEIKEKKA_PROCESS);
        }
        if (getParameter().isPublish_HanteiKekkaKagami()) {
            executeStep(HANTEIKEKKA_KAGAMI_PROCESS);
        }
        if (getParameter().isPublish_ShinsakaiGijiroku()) {
            executeStep(GIJIROKUSHUTURYOKU_PROCESS);
        }
        if (getParameter().isPublish_KekkaTsuchiIchiran()) {
            executeStep(KEKKATSUCHI_PROCESS);
        }
    }

    /**
     * 要介護認定判定結果一覧表のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(HANTEIKEKKA_PROCESS)
    protected IBatchFlowCommand createHanteiKekkaIchiranData() {
        return loopBatch(HanteiKekkaIchiranProcess.class).arguments(
                getParameter().toHanteiKekkaJohoShuturyokuProcessParameter()).define();
    }

    /**
     * 要介護認定判定結果一覧表Ａ３版のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(HANTEIKEKKA_A3_PROCESS)
    protected IBatchFlowCommand createHanteiKekkaIchiranA3Data() {
        return loopBatch(HanteiKekkaIchiranA3Process.class).arguments(
                getParameter().toHanteiKekkaJohoShuturyokuProcessParameter()).define();
    }

    /**
     * 介護認定審査判定結果（鑑）のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(HANTEIKEKKA_KAGAMI_PROCESS)
    protected IBatchFlowCommand createHanteikekkaKagamiData() {
        return loopBatch(HanteikekkaKagamiProcess.class).arguments(
                getParameter().toHanteiKekkaJohoShuturyokuProcessParameter()).define();
    }

    /**
     * 介護認定審査会議事録のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(GIJIROKUSHUTURYOKU_PROCESS)
    protected IBatchFlowCommand createData() {
        return loopBatch(ShinsakaiGijirokuProcess.class).arguments(
                getParameter().toHanteiKekkaJohoShuturyokuProcessParameter()).define();
    }

    /**
     * 要介護認定結果通知一覧表のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(KEKKATSUCHI_PROCESS)
    protected IBatchFlowCommand createKekkatsuchiIchiranhyoData() {
        return loopBatch(KekkatsuchiIchiranhyoProcess.class).arguments(
                getParameter().toHanteiKekkaJohoShuturyokuProcessParameter()).define();
    }

}
