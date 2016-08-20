/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc180010;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010.HanteiTaishoshaTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010.JukyushaTaichoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010.RiyoshaFutanWariaiDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010.RiyoshaFutanWariaiKonkyoDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010.RiyoshaFutanWariaiMeisaiDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010.ShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010.SinseicyuDateDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010.SogoJigyoTaishoshaTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.futanwariaiichiran.FutanWariaiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiParameter;
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
public class DBC180010_NenjiRiyoshaFutanwariaiHantei extends BatchFlowBase<NenjiRiyoshaFutanwariaiHanteiParameter> {

    private static final String 受給者台帳TEMPへ登録する = "creatJukyushaTaichoTemp";
    private static final String 総合事業対象者台帳TEMPへ登録する = "creatSogoJigyoTaishoshaTemp";
    private static final String 申請中データを削除する = "deleteSinseicyuDate";
    private static final String 判定対象者TEMPにデータを追加する = "creatHanteiTaishoshaTemp";
    private static final String 利用者負担割合を削除する = "deleteRiyoshaFutanWariai";
    private static final String 利用者負担割合明細を削除する = "deleteRiyoshaFutanWariaiMeisai";
    private static final String 利用者負担割合世帯員を削除する = "deleteRiyoshaFutanWariaiKonkyo";
    private static final String 利用者負担割合判定 = "riyoshaFutanWariaiHantei";
    private static final String 負担割合判定一覧出力 = "futanwariaiHantei";
    private static final RString 負担割合判定一覧BATCH_ID = new RString("FutanWariaiIchiranFlow");
    private static final RString 利用者負担割合判定BATCH_ID = new RString("RiyoshaFutanwariaiHanteiCommonFlow");
    private static final String 処理日付管理マスタAND受給管理情報の更新 = "updateDate";
    private static final RString 再処理前 = new RString("3");

    @Override
    protected void defineFlow() {
        executeStep(受給者台帳TEMPへ登録する);
        executeStep(総合事業対象者台帳TEMPへ登録する);
        executeStep(申請中データを削除する);
        executeStep(判定対象者TEMPにデータを追加する);
        if (再処理前.equals(getParameter().get処理区分().再処理.getコード())) {
            executeStep(利用者負担割合を削除する);
            executeStep(利用者負担割合明細を削除する);
            executeStep(利用者負担割合世帯員を削除する);
        }
        executeStep(利用者負担割合判定);
        executeStep(負担割合判定一覧出力);
        executeStep(処理日付管理マスタAND受給管理情報の更新);

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

    @Step(判定対象者TEMPにデータを追加する)
    IBatchFlowCommand creatHanteiTaishoshaTemp() {
        return loopBatch(HanteiTaishoshaTempProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter()).define();
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
        DBC180020_IdoRiyoshaFutanwariaiHanteiParameter parameter = new DBC180020_IdoRiyoshaFutanwariaiHanteiParameter();
        parameter.setTaishoNendo(getParameter().get対象年度());
        parameter.setKijunbi(getParameter().get基準日());
        parameter.setShoriKubun(getParameter().get処理区分().getコード());
        parameter.setTestMode(getParameter().isテストモード());
        parameter.setShoriNichiji(getParameter().get処理日時());
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
        FutanWariaiIchiranBatchParameter parameter = new FutanWariaiIchiranBatchParameter();
        parameter.set対象年度(getParameter().get対象年度());
        parameter.set基準日(getParameter().get基準日());
        parameter.set処理区分(getParameter().get処理区分().getコード());
        parameter.setテストモード(getParameter().isテストモード());
        parameter.set処理日時(getParameter().get処理日時());
        return otherBatchFlow(負担割合判定一覧BATCH_ID, SubGyomuCode.DBC介護給付,
                parameter).define();
    }

    @Step(処理日付管理マスタAND受給管理情報の更新)
    IBatchFlowCommand updateDate() {
        return loopBatch(ShoriDateKanriProcess.class).arguments(getParameter().toNenjiRiyoshaFutanwariaiHanteiProcessParameter())
                .define();
    }

}
