/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710180.HanyoListSogoJigyoHiRenbanAriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710180.HanyoListSogoJigyoHiRenbanNashiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710180.DBC710180_HanyoListSogoJigyoHiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(総合事業費情報)のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
public class DBC710180_HanyoListSogoJigyoHi extends BatchFlowBase<DBC710180_HanyoListSogoJigyoHiParameter> {

    private static final String 総合事業費情報_連番あり = "sogojigyohijohoari";
    private static final String 総合事業費情報_連番なし = "sogojigyohijohonashi";

    @Override
    protected void defineFlow() {
        if (getParameter().is連番付加()) {
            executeStep(総合事業費情報_連番あり);
        } else {
            executeStep(総合事業費情報_連番なし);
        }

    }

    @Step(総合事業費情報_連番あり)
    IBatchFlowCommand callHanyoListSogoJigyoHiRenbanAri() {
        return loopBatch(HanyoListSogoJigyoHiRenbanAriProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(総合事業費情報_連番なし)
    IBatchFlowCommand callHanyoListSogoJigyoHiRenbanNashi() {
        return loopBatch(HanyoListSogoJigyoHiRenbanNashiProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

}
