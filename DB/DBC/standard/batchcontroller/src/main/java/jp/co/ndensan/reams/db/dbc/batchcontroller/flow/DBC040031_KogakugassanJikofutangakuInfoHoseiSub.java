/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031.JikofutangakuTempUpdateProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040031.DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 高額合算自己負担額情報補正（一括）_サブ処理のフローです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
public class DBC040031_KogakugassanJikofutangakuInfoHoseiSub extends BatchFlowBase<DBC040031_KogakugassanJikofutangakuInfoHoseiSubParameter> {

    private static final String 高額支給額集計処理 = "sumJikofutangaku";

    @Override
    protected void defineFlow() {
        // TODO 給付実績抽出（償還）処理
        executeStep(高額支給額集計処理);

    }

    @Step(高額支給額集計処理)
    IBatchFlowCommand sumJikofutangaku() {
        return loopBatch(JikofutangakuTempUpdateProcess.class).define();
    }

}
