/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710120.HanyoListSaishinsaKekkaProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710120.DBC710120_HanyoListSaishinsaKekkaParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 汎用リスト 再審査結果情報のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3105-020 yaodongsheng
 */
public class DBC710120_HanyoListSaishinsaKekka extends BatchFlowBase<DBC710120_HanyoListSaishinsaKekkaParameter> {

    private static final String 再審査結果情報 = "hanyoListSaishinsaKekka";
    private FlexibleDate date;

    @Override
    protected void defineFlow() {
        date = FlexibleDate.getNowDate();
        executeStep(再審査結果情報);
    }

    @Step(再審査結果情報)
    IBatchFlowCommand callKijunShunyugakuTekiyoRebanari() {
        return loopBatch(HanyoListSaishinsaKekkaProcess.class).arguments(getParameter().toHanyoListSaishinsaKekkaProcessParameterr(date)).define();
    }
}
