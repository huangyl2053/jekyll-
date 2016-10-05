/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010020.KogakuServicehiJuryoininKeiyakuShoninKakuninshoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010020.DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成のバッチフロークラスです。
 *
 * @reamsid_L DBC-1970-030 zhouchuanlin
 */
public class DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninsho
        extends BatchFlowBase<DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter> {

    private static final String 高額サービス費受領委任契約承認_不承認_認書作成 = "KogakuServicehiJuryoininKeiyakuShoninKakuninshoProcess";

    @Override
    protected void defineFlow() {
        executeStep(高額サービス費受領委任契約承認_不承認_認書作成);
    }

    @Step(高額サービス費受領委任契約承認_不承認_認書作成)
    IBatchFlowCommand editKogakuServicehiJuryoininKeiyakuShoninKakuninsho() {
        return loopBatch(KogakuServicehiJuryoininKeiyakuShoninKakuninshoProcess.class).
                arguments(getParameter().toProcessParameter()).define();
    }

}
