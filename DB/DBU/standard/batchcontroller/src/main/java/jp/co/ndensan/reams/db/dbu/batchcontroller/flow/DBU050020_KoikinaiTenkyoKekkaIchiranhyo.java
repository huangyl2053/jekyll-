/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU050020.HiroshimaDomainReportProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU050020.DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 広域内転居結果一覧表_バッチフ処理クラスです
 *
 * @reamsid_L DBU-1150-020 chenaoqi
 */
public class DBU050020_KoikinaiTenkyoKekkaIchiranhyo extends BatchFlowBase<DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter> {

    private static final String REPORT_PROCESS = "hiroshimaDomainReportProcess";

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

    /**
     * 帳票出力パラメータの取得です。
     *
     * @return 帳票出力パラメータ
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand hiroshimaDomainReportProcess() {
        return loopBatch(HiroshimaDomainReportProcess.class).arguments(getParameter().toHiroshimaDomainProcessParameter()).define();
    }
}
