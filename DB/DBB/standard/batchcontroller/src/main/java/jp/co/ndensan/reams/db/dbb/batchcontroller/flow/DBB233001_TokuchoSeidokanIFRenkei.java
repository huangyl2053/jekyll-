/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb233001.CreateRenkeiFileProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB233001.DBB233001_TokuchoSeidokanIFRenkeiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携　の作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
public class DBB233001_TokuchoSeidokanIFRenkei extends BatchFlowBase<DBB233001_TokuchoSeidokanIFRenkeiParameter> {

    private static final String TOKUCHOUSEIDOKANIFRENKEI_PROCESS = "tokuchouSeidoKanIFRenkeiProcess";

    @Override
    protected void defineFlow() {
        executeStep(TOKUCHOUSEIDOKANIFRENKEI_PROCESS);
    }

    @Step(TOKUCHOUSEIDOKANIFRENKEI_PROCESS)
    IBatchFlowCommand tokuchouSeidoKanIFRenkeiProcess() {
        List<RString> 市町村コードリスト = new ArrayList<>();
        return loopBatch(CreateRenkeiFileProcess.class).arguments(
                new DBB233001_TokuchoSeidokanIFRenkeiParameter().
                toTokuchouSeidoKanIFRenkeiProcessParameter(FlexibleYear.EMPTY, 市町村コードリスト)).define();
    }

}
