/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001.InsSetaiinHaakuTmp1Process;
import jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001.InsSetaiinHaakuTmp2Process;
import jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001.InsSetaiinHaakuTmp3Process;
import jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001.UpdSetaiinHaakuNyuryokuProcess;
import jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001.UpdSetaiinHaakuTmpProcess;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 世帯員把握（バッチ）のバッチフロークラスです。
 *
 * @reamsid_L DBB-0640-010 chenaoqi
 */
public class DBB002001_SetaiinHaaku extends BatchFlowBase<DBB002001_SetaiinHaakuParameter> {

    private static final String UPDATESETAIINHAAKU = "updSetaiinHaaku";
    private static final String INSSETAIINHAAKU_1 = "insSetaiinHaaku1";
    private static final String INSSETAIINHAAKU_2 = "insSetaiinHaaku2";
    private static final String INSSETAIINHAAKU_3 = "insSetaiinHaaku3";
    private static final String UPDATESESAIHAAKU = "updSetaiHaaku";

    @Override
    protected void defineFlow() {
        executeStep(UPDATESETAIINHAAKU);
        executeStep(INSSETAIINHAAKU_1);
        executeStep(INSSETAIINHAAKU_2);
        executeStep(INSSETAIINHAAKU_3);
        executeStep(UPDATESESAIHAAKU);
    }

    /**
     * update世帯員把握入力です。
     *
     * @return IBatchFlowCommand
     */
    @Step (UPDATESETAIINHAAKU)
    protected IBatchFlowCommand updSetaiinHaaku() {
        return simpleBatch(UpdSetaiinHaakuNyuryokuProcess.class).define();
    }

    /**
     * 世帯員（住民）の把握_住所地特例該当が１クラスです。
     *
     * @return IBatchFlowCommand
     */
    @Step (INSSETAIINHAAKU_1)
    protected IBatchFlowCommand insSetaiinHaaku1() {

        return loopBatch(InsSetaiinHaakuTmp1Process.class).define();
    }

    /**
     * 世帯員（住民）の把握_住所地特例該当が１以外クラスです。
     *
     * @return IBatchFlowCommand
     */
    @Step (INSSETAIINHAAKU_2)
    protected IBatchFlowCommand insSetaiinHaaku2() {

        return loopBatch(InsSetaiinHaakuTmp2Process.class).arguments(getParameter().
                toSetaiShotokuKazeiHanteiProcessParameter()).define();
    }

    /**
     * 世帯員（住民）の把握_被保険者番号のデータ抽出クラスです。
     *
     * @return IBatchFlowCommand
     */
    @Step (INSSETAIINHAAKU_3)
    protected IBatchFlowCommand insSetaiinHaaku3() {

        return loopBatch(InsSetaiinHaakuTmp3Process.class).define();
    }

    /**
     * 各住民の所得情報の取得です。
     *
     * @return 帳票出力パラメータ
     */
    @Step (UPDATESESAIHAAKU)
    protected IBatchFlowCommand updSetaiHaaku() {
        return simpleBatch(UpdSetaiinHaakuTmpProcess.class).arguments(getParameter().
                toSetaiShotokuKazeiHanteiProcessParameter()).define();
    }
}
