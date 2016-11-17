/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.CareManagementListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.HukushiYouguListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.JukyushaKyufuJissekidaichoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.JuutakuKaishuuListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.KeikakuHiCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.KihonListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.KinkyuuziShisetuRyouyouCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.KyuuhuZissekiKihonProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.KyuuhuZissekiKougakuListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.MeisaiJuushoListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.MeisaiListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.ShakaiHukushiHouzinKeigenListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.ShoteiShikkanListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.ShuukeiListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.TokuteiServiceHiCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.TokuteiShinryouHiCreateProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140010.DBC140010_JukyushaKyufujissekiDaichoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 受給者給付実績台帳 のバッチフロークラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public class DBC140010_JukyushaKyufujissekiDaicho extends BatchFlowBase<DBC140010_JukyushaKyufujissekiDaichoParameter> {

    private static final String 給付実績基本 = "KyuuhuZissekiKihonProcess";
    private static final String 基本_TMP = "KihonListCreateProcess";
    private static final String 基本_高額_TMP = "KyuuhuZissekiKougakuListCreateProcess";
    private static final String 明細_TMP = "MeisaiListCreateProcess";
    private static final String 明細_住所地特例_TMP = "MeisaiJuushoListCreateProcess";
    private static final String 特定入所_TMP = "TokuteiServiceHiCreateProcess";
    private static final String 集計_TMP = "ShuukeiListCreateProcess";
    private static final String 施設療養_TMP = "KinkyuuziShisetuRyouyouCreateProcess";
    private static final String 特別療養_TMP = "TokuteiShinryouHiCreateProcess";
    private static final String 計画費_TMP = "KeikakuHiCreateProcess";
    private static final String 福祉用具_TMP = "HukushiYouguListCreateProcess";
    private static final String 住宅改修_TMP = "JuutakuKaishuuListCreateProcess";
    private static final String 社会福祉法人_TMP = "ShakaiHukushiHouzinKeigenListCreateProcess";
    private static final String ケアマネジメント費_TMP = "CareManagementListCreateProcess";
    private static final String 所定疾患_TMP = "ShoteiShikkanListCreateProcess";
    private static final String 帳票実行 = "JukyushaKyufuJissekidaichoProcess";

    @Override
    protected void defineFlow() {
        executeStep(基本_TMP);
        executeStep(基本_高額_TMP);
        executeStep(明細_TMP);
        executeStep(明細_住所地特例_TMP);
        executeStep(特定入所_TMP);
        executeStep(集計_TMP);
        executeStep(施設療養_TMP);
        executeStep(特別療養_TMP);
        executeStep(計画費_TMP);
        executeStep(福祉用具_TMP);
        executeStep(住宅改修_TMP);
        executeStep(社会福祉法人_TMP);
        executeStep(ケアマネジメント費_TMP);
        executeStep(所定疾患_TMP);
        executeStep(給付実績基本);
        executeStep(帳票実行);
    }

    /**
     * DBのテーブルから情報を取得します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(給付実績基本)
    protected IBatchFlowCommand callKyuuhuZissekiKihonProcess() {
        return loopBatch(KyuuhuZissekiKihonProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 基本の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(基本_TMP)
    protected IBatchFlowCommand createKihonList() {
        return loopBatch(KihonListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 高額から基本の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(基本_高額_TMP)
    protected IBatchFlowCommand createKyuuhuZissekiKougakuList() {
        return loopBatch(KyuuhuZissekiKougakuListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 明細の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(明細_TMP)
    protected IBatchFlowCommand createMeisaiList() {
        return loopBatch(MeisaiListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 住所地特例から明細の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(明細_住所地特例_TMP)
    protected IBatchFlowCommand createKyuuhuZissekiKihonProcess() {
        return loopBatch(MeisaiJuushoListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 特定入所の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(特定入所_TMP)
    protected IBatchFlowCommand createTokuteiServiceHi() {
        return loopBatch(TokuteiServiceHiCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 集計の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(集計_TMP)
    protected IBatchFlowCommand createShuukeiList() {
        return loopBatch(ShuukeiListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 施設療養の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(施設療養_TMP)
    protected IBatchFlowCommand createKinkyuuziShisetuRyouyou() {
        return loopBatch(KinkyuuziShisetuRyouyouCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 特別療養の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(特別療養_TMP)
    protected IBatchFlowCommand createTokuteiShinryouHi() {
        return loopBatch(TokuteiShinryouHiCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 計画費の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(計画費_TMP)
    protected IBatchFlowCommand createKeikakuHi() {
        return loopBatch(KeikakuHiCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 福祉用具の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(福祉用具_TMP)
    protected IBatchFlowCommand createHukushiYouguList() {
        return loopBatch(HukushiYouguListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 住宅改修の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(住宅改修_TMP)
    protected IBatchFlowCommand createJuutakuKaishuuList() {
        return loopBatch(JuutakuKaishuuListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 社会福祉法人の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(社会福祉法人_TMP)
    protected IBatchFlowCommand createShakaiHukushiHouzinKeigenList() {
        return loopBatch(ShakaiHukushiHouzinKeigenListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * ケアマネジメント費の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(ケアマネジメント費_TMP)
    protected IBatchFlowCommand createCareManagementListCreate() {
        return loopBatch(CareManagementListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 所定疾患の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(所定疾患_TMP)
    protected IBatchFlowCommand createShoteiShikkanList() {
        return loopBatch(ShoteiShikkanListCreateProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

    /**
     * 所定疾患の一時テーブルの作成します。
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(帳票実行)
    protected IBatchFlowCommand jukyushaKyufuJissekidaichoProcess() {
        return loopBatch(JukyushaKyufuJissekidaichoProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }
}
