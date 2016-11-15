/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD511001.KoshinTaishoshaKanriProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511001.DBD511001_KoshinTaishoshaKanriParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5610001.KoshinTaishoshaKanriProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 更新対象者抽出のバッチフロークラスです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public class DBD511001_KoshinTaishoshaKanri extends BatchFlowBase<DBD511001_KoshinTaishoshaKanriParameter> {

    private static final String SELECT_TABLE = "slect_table";

    @Override
    protected void defineFlow() {
        executeStep(SELECT_TABLE);

    }

    /**
     * 'バッチパラメータの取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(SELECT_TABLE)
    protected IBatchFlowCommand selectTable() {
        return loopBatch(KoshinTaishoshaKanriProcess.class)
                .arguments(createProcessParameter()).define();
    }

    private KoshinTaishoshaKanriProcessParameter createProcessParameter() {
        DBD511001_KoshinTaishoshaKanriParameter parameter = getParameter();
        KoshinTaishoshaKanriProcessParameter processParameter = parameter.toKoshinTaishoshaKanriProcessParameter();
        processParameter.set対象月(parameter.get対象月());
        processParameter.set市町村コード(parameter.get市町村コード());
        processParameter.set年度(parameter.get年度());
        processParameter.set年度内連番(parameter.get年度内連番());
        processParameter.set有効期間終了日From(parameter.get有効期間終了日From());
        processParameter.set有効期間終了日To(parameter.get有効期間終了日To());
        processParameter.set条件指定(parameter.get条件指定());
        return processParameter;
    }
}
