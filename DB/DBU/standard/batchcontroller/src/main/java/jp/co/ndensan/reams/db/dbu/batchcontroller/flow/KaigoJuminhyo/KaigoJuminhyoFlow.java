/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow.KaigoJuminhyo;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.KaigoJuminhyo.KaigoJuminhyoDBUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.KaigoJuminhyo.KaigoJuminhyoEucCsvProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo.KaigoJuminhyoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 介護住民票個別事項連携情報作成【他社住基】のバッチ処理クラスです。
 */
public class KaigoJuminhyoFlow extends BatchFlowBase<KaigoJuminhyoBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(KAIGOJUMINHYO_EUC_CSV_PROCESS);
        executeStep(KAIGOJUMINHYO_DB_UPD_PROCESS);
    }

    private static final String KAIGOJUMINHYO_EUC_CSV_PROCESS = "kaigoJuminhyoEucCsvProcess";
    private static final String KAIGOJUMINHYO_DB_UPD_PROCESS = "kaigoJuminhyoDBUpdateProcess";

    /**
     * CSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(KAIGOJUMINHYO_EUC_CSV_PROCESS)
    protected IBatchFlowCommand kaigoJuminhyoEucCsvProcess() {
        return loopBatch(KaigoJuminhyoEucCsvProcess.class).arguments(getParameter().toKaigoJuminhyoProcessParameter()).define();
    }

    /**
     * DB登録またはDB更新です。
     *
     * @return 登録または更新件数
     */
    @Step(KAIGOJUMINHYO_DB_UPD_PROCESS)
    protected IBatchFlowCommand kaigoJuminhyoDBUpdateProcess() {
        return loopBatch(KaigoJuminhyoDBUpdateProcess.class).arguments(getParameter().toKaigoJuminhyoProcessParameter()).define();
    }
}
