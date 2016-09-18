/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180030.ShoriHizukeKanriTblUpdateProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180030.DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kanendoriyoshafutanwariaihantei.KanendoRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動分利用者負担割合判定（過年度）のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-4940-030 wangrenze
 */
public class DBC180030_KanendoRiyoshaFutanwariaiHantei extends BatchFlowBase<DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter> {

    private static final RString 異動データ抽出_ID = new RString("DBC180021_RiyoshaFutanwariaiHanteiIdoDataSelectSub");
    private static final String 異動データ抽出 = "idodatetyuushutukyoutsuu";
    private static final RString 利用者負担割合判定_ID = new RString("DBC180022_RiyoshaFutanwariaiHanteiSub");
    private static final String 利用者負担割合判定 = "riyoshafutanwariaihantei";
    private static final RString 負担割合判定一覧出力_ID = new RString("DBC180011_RiyoshaFutanwariaiHanteiIchiranSub");
    private static final String 負担割合判定一覧出力 = "futanwariaiichiran";
    private static final String DB_UPDATE = "db_update";

    @Override
    protected void defineFlow() {
        executeStep(異動データ抽出);
        executeStep(利用者負担割合判定);
        executeStep(負担割合判定一覧出力);
        executeStep(DB_UPDATE);
    }

    /**
     * 異動データ抽出バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(異動データ抽出)
    IBatchFlowCommand callIdoDateTyuushutuKyoutsu() {
        return otherBatchFlow(異動データ抽出_ID, SubGyomuCode.DBC介護給付, getParameter().toIdoDateTyuushutuKyoutsuuParameter()).define();
    }

    /**
     * 利用者負担割合判定バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(利用者負担割合判定)
    IBatchFlowCommand callRiyoshaFutanwariaiHantei() {
        return otherBatchFlow(利用者負担割合判定_ID, SubGyomuCode.DBC介護給付, getParameter().toRiyoshaFutanwariaiHanteiCommonFlowParameter()).define();
    }

    /**
     * 負担割合判定一覧出力バッチを呼び出す。。
     *
     * @return バッチコマンド
     */
    @Step(負担割合判定一覧出力)
    IBatchFlowCommand callFutanWariaiIchiranFlow() {
        return otherBatchFlow(負担割合判定一覧出力_ID, SubGyomuCode.DBC介護給付, getParameter().toFutanWariaiIchiranFlowParameter()).define();
    }

    /**
     * 処理日付管理の登録。
     *
     * @return ShoriHizukeKanriTblUpdateProcess
     */
    @Step(DB_UPDATE)
    IBatchFlowCommand callDbupdate() {
        KanendoRiyoshaFutanwariaiHanteiProcessParameter param = new KanendoRiyoshaFutanwariaiHanteiProcessParameter(getParameter().get対象年度(),
                getParameter().get抽出開始日時(), getParameter().get抽出終了日時());
        return loopBatch(ShoriHizukeKanriTblUpdateProcess.class).arguments(param).define();
    }
}
