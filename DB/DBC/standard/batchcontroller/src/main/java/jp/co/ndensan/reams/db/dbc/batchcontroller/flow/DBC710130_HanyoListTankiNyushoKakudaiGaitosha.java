/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710130.TankiNyushoKakudaiGaitoshaProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710130.DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト_短期入所拡大該当者のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3111-020 duanzhanli
 */
public class DBC710130_HanyoListTankiNyushoKakudaiGaitosha
        extends BatchFlowBase<DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter> {

    private static final String 短期入所拡大該当者情報 = "TankiNyushoKakudaiGaitosha";

    @Override
    protected void defineFlow() {
        executeStep(短期入所拡大該当者情報);
    }

    @Step(短期入所拡大該当者情報)
    IBatchFlowCommand callTankiNyushoKakudaiGaitosha() {
        return loopBatch(TankiNyushoKakudaiGaitoshaProcess.class).arguments(getParameter().toProcessParameter()).define();
    }
}
