/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710200.KijunShunyugakuTekiyoRenbanariProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710200.KijunShunyugakuTekiyoRenbannashiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710200.DBC710200_HanyoListKijunShunyugakuTekiyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト_基準収入額適用情報のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-5050-030 duanzhanli
 */
public class DBC710200_HanyoListKijunShunyugakuTekiyo extends BatchFlowBase<DBC710200_HanyoListKijunShunyugakuTekiyoParameter> {

    private static final String 基準収入額適用情報_連番あり = "hanyoListKijunShunyugakuTekiyoAri";
    private static final String 基準収入額適用情報_連番なし = "hanyoListKijunShunyugakuTekiyoNashi";

    @Override
    protected void defineFlow() {
        if (getParameter().is連番付加()) {
            executeStep(基準収入額適用情報_連番あり);
        } else {
            executeStep(基準収入額適用情報_連番なし);
        }
    }

    @Step(基準収入額適用情報_連番あり)
    IBatchFlowCommand callKijunShunyugakuTekiyoRebanari() {
        return loopBatch(KijunShunyugakuTekiyoRenbanariProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(基準収入額適用情報_連番なし)
    IBatchFlowCommand callKijunShunyugakuTekiyoRebannashi() {
        return loopBatch(KijunShunyugakuTekiyoRenbannashiProcess.class).arguments(getParameter().toProcessParameter()).define();
    }
}
