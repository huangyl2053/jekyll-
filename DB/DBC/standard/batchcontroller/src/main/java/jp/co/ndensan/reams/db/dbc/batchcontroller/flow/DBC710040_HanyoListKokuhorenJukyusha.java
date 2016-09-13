/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710040.HanyoListKokuhorenJukyushaProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710040.DBC710040_HanyoListKokuhorenJukyushaParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト 国保連受給者情報のバッチ用フロークラスです。
 *
 * @reamsid_L DBC-3104-020 yaodongsheng
 */
public class DBC710040_HanyoListKokuhorenJukyusha extends BatchFlowBase<DBC710040_HanyoListKokuhorenJukyushaParameter> {

    private static final String 国保連受給者情報 = "KokuhorenJukyusha";

    @Override
    protected void defineFlow() {
        executeStep(国保連受給者情報);
    }

    @Step(国保連受給者情報)
    IBatchFlowCommand callTankiNyushoKakudaiGaitosha() {
        return loopBatch(HanyoListKokuhorenJukyushaProcess.class).arguments(getParameter().toProcessParameter()).define();
    }
}
