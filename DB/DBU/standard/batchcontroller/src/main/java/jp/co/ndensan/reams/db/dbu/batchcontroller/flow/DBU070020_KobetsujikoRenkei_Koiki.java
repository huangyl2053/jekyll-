/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuDBUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuEucCsvProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU070020.DBU070020_KobetsujikoRenkei_KoikiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
public class DBU070020_KobetsujikoRenkei_Koiki extends BatchFlowBase<DBU070020_KobetsujikoRenkei_KoikiParameter> {

    @Override
    protected void defineFlow() {
        executeStep(KAIGOJUMINHYO_EUC_CSV_PROCESS);
        executeStep(KAIGOJUMINHYO_DB_UPD_PROCESS);
    }

    private static final String KAIGOJUMINHYO_EUC_CSV_PROCESS = "KaiGoJuminHyokouKiuEucCsvProcess";
    private static final String KAIGOJUMINHYO_DB_UPD_PROCESS = "KaiGoJuminHyokouKiuDBUpdateProcess";

    /**
     * CSVファイルの出力です。
     *
     * @return CSVファイル
     */
    @Step(KAIGOJUMINHYO_EUC_CSV_PROCESS)
    protected IBatchFlowCommand kaigoJuminhyoEucCsvProcess() {
        return loopBatch(KaiGoJuminHyokouKiuEucCsvProcess.class).arguments(getParameter().toKaiGoJuminHyokouKiuProcessParameter()).define();
    }

    /**
     * DB登録またはDB更新です。
     *
     * @return 登録または更新件数
     */
    @Step(KAIGOJUMINHYO_DB_UPD_PROCESS)
    protected IBatchFlowCommand kaigoJuminhyoDBUpdateProcess() {
        return loopBatch(KaiGoJuminHyokouKiuDBUpdateProcess.class).arguments(getParameter().toKaiGoJuminHyokouKiuProcessParameter()).define();
    }
}
