/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.HanteiTaishoshaTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.HanteiTaishoshaTuikaTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.JukyushaTaichoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.RiyoshaFutanWariaiDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.RiyoshaFutanWariaiKonkyoDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.RiyoshaFutanWariaiMeisaiDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.ShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.ShoriKekkaKakuninListProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.SinseicyuDateDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010.SogoJigyoTaishoshaTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180010.DBC180010_NenjiRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180011.DBC180011_RiyoshaFutanwariaiHanteiIchiranSubParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180022.DBC180022_RiyoshaFutanwariaiHanteiSubParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年次利用者負担割合判定のバッチ処理フロー
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
public class DBC180010_NenjiRiyoshaFutanwariaiHantei extends BatchFlowBase<DBC180010_NenjiRiyoshaFutanwariaiHanteiParameter> {

    private static final String 受給者台帳TEMPへ登録する = "creatJukyushaTaichoTemp";
    private static final String 総合事業対象者台帳TEMPへ登録する = "creatSogoJigyoTaishoshaTemp";
    private static final String 申請中データを削除する = "deleteSinseicyuDate";
    private static final String 判定対象者TEMPに受給者データを追加する = "creatHanteiTaishoshaTemp";
    private static final String 判定対象者TEMPに総合事業データを追加する = "creatHanteiTaishoshaTuikaTemp";
    private static final String 利用者負担割合を削除する = "deleteRiyoshaFutanWariai";
    private static final String 利用者負担割合明細を削除する = "deleteRiyoshaFutanWariaiMeisai";
    private static final String 利用者負担割合世帯員を削除する = "deleteRiyoshaFutanWariaiKonkyo";
    private static final String 利用者負担割合判定 = "riyoshaFutanWariaiHantei";
    private static final String 負担割合判定一覧出力 = "futanwariaiHantei";
    private static final RString 負担割合判定一覧BATCH_ID = new RString("DBC180011_RiyoshaFutanwariaiHanteiIchiranSub");
    private static final RString 利用者負担割合判定BATCH_ID = new RString("DBC180022_RiyoshaFutanwariaiHanteiSub");
    private static final String 処理日付管理マスタAND受給管理情報の更新 = "updateDate";
    private static final String 処理結果確認リストCSV出力 = "outPutShoriKekkaKakunin";
    private static final RString 再処理前 = new RString("2");
    private static final int 抽出回数_1 = 1;

    @Override
    protected void defineFlow() {
        executeStep(受給者台帳TEMPへ登録する);
        executeStep(総合事業対象者台帳TEMPへ登録する);
        executeStep(申請中データを削除する);
        executeStep(判定対象者TEMPに受給者データを追加する);
        executeStep(判定対象者TEMPに総合事業データを追加する);
        if (再処理前.equals(getParameter().get処理状態())) {
            executeStep(利用者負担割合を削除する);
            executeStep(利用者負担割合明細を削除する);
            executeStep(利用者負担割合世帯員を削除する);
        }
        executeStep(利用者負担割合判定);
        executeStep(負担割合判定一覧出力);
        executeStep(処理日付管理マスタAND受給管理情報の更新);
        executeStep(処理結果確認リストCSV出力);

    }

    @Step(受給者台帳TEMPへ登録する)
    IBatchFlowCommand creatJukyushaTaichoTemp() {
        return loopBatch(JukyushaTaichoTempProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter()).define();
    }

    @Step(総合事業対象者台帳TEMPへ登録する)
    IBatchFlowCommand creatSogoJigyoTaishoshaTemp() {
        return loopBatch(SogoJigyoTaishoshaTempProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter()).define();
    }

    @Step(申請中データを削除する)
    IBatchFlowCommand deleteSinseicyuDate() {
        return loopBatch(SinseicyuDateDeleteProcess.class).define();
    }

    @Step(判定対象者TEMPに受給者データを追加する)
    IBatchFlowCommand creatHanteiTaishoshaTemp() {
        return loopBatch(HanteiTaishoshaTempProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter()).define();
    }

    @Step(判定対象者TEMPに総合事業データを追加する)
    IBatchFlowCommand creatHanteiTaishoshaTuikaTemp() {
        return loopBatch(HanteiTaishoshaTuikaTempProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter()).define();
    }

    @Step(利用者負担割合を削除する)
    IBatchFlowCommand deleteRiyoshaFutanWariai() {
        return loopBatch(RiyoshaFutanWariaiDeleteProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter()).define();
    }

    @Step(利用者負担割合明細を削除する)
    IBatchFlowCommand deleteRiyoshaFutanWariaiMeisai() {
        return loopBatch(RiyoshaFutanWariaiMeisaiDeleteProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter())
                .define();
    }

    @Step(利用者負担割合世帯員を削除する)
    IBatchFlowCommand deleteRiyoshaFutanWariaiKonkyo() {
        return loopBatch(RiyoshaFutanWariaiKonkyoDeleteProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter())
                .define();
    }

    /**
     * 利用者負担割合判定バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(利用者負担割合判定)
    protected IBatchFlowCommand riyoshaFutanWariaiHantei() {
        DBC180022_RiyoshaFutanwariaiHanteiSubParameter parameter = new DBC180022_RiyoshaFutanwariaiHanteiSubParameter();
        parameter.setTaishoNendo(getParameter().get対象年度());
        parameter.setKijunbi(getParameter().get基準日());
        parameter.setShoriKubun(getParameter().get処理区分());
        parameter.setTestMode(getParameter().isテストモード());
        parameter.setNendoShuryoNengappi(getParameter().get年度終了年月日());
        parameter.setShoriNichiji(getParameter().get処理日時());
        parameter.setChushutuKaisu(抽出回数_1);
        return otherBatchFlow(利用者負担割合判定BATCH_ID, SubGyomuCode.DBC介護給付,
                parameter).define();
    }

    /**
     * 負担割合判定一覧出力バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(負担割合判定一覧出力)
    protected IBatchFlowCommand futanwariaiHantei() {
        DBC180011_RiyoshaFutanwariaiHanteiIchiranSubParameter parameter = new DBC180011_RiyoshaFutanwariaiHanteiIchiranSubParameter();
        parameter.setTaishoNendo(getParameter().get対象年度());
        parameter.setKijunbi(getParameter().get基準日());
        parameter.setShoriKubun(getParameter().get処理区分());
        parameter.setShoriNichiji(getParameter().get処理日時());
        parameter.setNendoShuryoNengappi(getParameter().get年度終了年月日());
        return otherBatchFlow(負担割合判定一覧BATCH_ID, SubGyomuCode.DBC介護給付,
                parameter).define();
    }

    @Step(処理日付管理マスタAND受給管理情報の更新)
    IBatchFlowCommand updateDate() {
        return loopBatch(ShoriDateKanriProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter())
                .define();
    }

    @Step(処理結果確認リストCSV出力)
    IBatchFlowCommand outPutShoriKekkaKakunin() {
        return loopBatch(ShoriKekkaKakuninListProcess.class).define();
    }

}
