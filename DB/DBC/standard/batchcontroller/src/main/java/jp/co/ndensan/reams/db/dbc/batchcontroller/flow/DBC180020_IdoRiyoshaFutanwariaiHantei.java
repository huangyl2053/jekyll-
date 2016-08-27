/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.UpdateShoriDateKanriTblProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.idoriyoshafutanwariaihentei.IdoRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動分利用者負担割合判定のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-4950-031 zhujun
 */
public class DBC180020_IdoRiyoshaFutanwariaiHantei extends BatchFlowBase<DBC180020_IdoRiyoshaFutanwariaiHanteiParameter> {

    private static final RString 異動データ抽出_ID = new RString("IdoDateTyuushutuKyoutsuu");
    private static final String 異動データ抽出 = "idodatetyuushutukyoutsuu";
    private static final RString 利用者負担割合判定_ID = new RString("RiyoshaFutanwariaiHanteiCommonFlow");
    private static final String 利用者負担割合判定 = "riyoshafutanwariaihantei";
    private static final RString 負担割合判定一覧出力_ID = new RString("FutanWariaiIchiranFlow");
    private static final String 負担割合判定一覧出力 = "futanwariaiichiran";
    private static final String DB_UPDATE = "db_update";

    @Override
    protected void defineFlow() {
        executeStep(異動データ抽出);
        executeStep(利用者負担割合判定);
        executeStep(負担割合判定一覧出力);
        executeStep(DB_UPDATE);
    }

    @Step(異動データ抽出)
    IBatchFlowCommand callIdoDateTyuushutuKyoutsu() {
        return otherBatchFlow(異動データ抽出_ID, SubGyomuCode.DBC介護給付, getParameter()).define();
    }

    @Step(利用者負担割合判定)
    IBatchFlowCommand callRiyoshaFutanwariaiHantei() {
        return otherBatchFlow(利用者負担割合判定_ID, SubGyomuCode.DBC介護給付, getParameter()).define();
    }

    @Step(負担割合判定一覧出力)
    IBatchFlowCommand callFutanWariaiIchiranFlow() {
        return otherBatchFlow(負担割合判定一覧出力_ID, SubGyomuCode.DBC介護給付, getParameter()).define();
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand callDbupdate() {
        IdoRiyoshaFutanwariaiHanteiProcessParameter param = new IdoRiyoshaFutanwariaiHanteiProcessParameter(getParameter().getTaishoNendo(),
                getParameter().getChushutsuKaishiNichiji(), getParameter().getChushutsuShuryonichiNichiji());
        return loopBatch(UpdateShoriDateKanriTblProcess.class).arguments(param).define();
    }
}
