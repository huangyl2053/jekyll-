/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010010.JuryoininKeiyakuShoninKakuninshoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010010.DBC010010_JuryoininKeiyakuShoninKakuninshoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 介護保険受領委任契約承認（不承認）確認書のFLOWです。
 *
 * @reamsid_L DBC-1910-030 yuanzhenxia
 */
public class DBC010010_JuryoininKeiyakuShoninKakuninsho extends BatchFlowBase<DBC010010_JuryoininKeiyakuShoninKakuninshoParameter> {

    private static final String 介護保険受領委任契約承認確認書 = "editJuryoininKeiyakuShoninKakuninsho";

    @Override
    protected void defineFlow() {
        executeStep(介護保険受領委任契約承認確認書);
    }

    @Step(介護保険受領委任契約承認確認書)
    IBatchFlowCommand editJuryoininKeiyakuShoninKakuninsho() {
        return loopBatch(JuryoininKeiyakuShoninKakuninshoProcess.class).arguments(getParameter().
                toJuryoininKeiyakuShoninKakuninshoProcessParameter())
                .define();
    }
}
