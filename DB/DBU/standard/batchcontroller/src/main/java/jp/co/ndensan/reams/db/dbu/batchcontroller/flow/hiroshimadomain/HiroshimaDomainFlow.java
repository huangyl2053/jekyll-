/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow.hiroshimadomain;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hiroshimadomain.HiroshimaDomainReportProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.hiroshimadomain.HiroshimaDomainBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 広域内転居結果一覧表_バッチフ処理クラスです
 *
 * @author 陳奥奇
 */
public class HiroshimaDomainFlow extends BatchFlowBase<HiroshimaDomainBatchParameter> {

    private static final String REPORT_PROCESS = "hiroshimaDomainReportProcess";

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

//    private static final String EXPORT_TABLE = "exportTable";
//
//    @Step(EXPORT_TABLE)
//    private IBatchFlowCommand exportTable() {
//        return exportCsv(getFilePath("DBA200011_KoikinaiTenkyoKekkaIchiranhyo.csv"), KoikinaiTenkyoEntity.TABLE_NAME).
//                delimiter(IMPORT_CSV_DELIMITER).
//                encode(Encode.UTF_8withBOM).
//                enclosure(IMPORT_CSV_ENCLOSURE).
//                define();
//    }
//
//    private static RString getFilePath(String inputFileName) {
//        StringBuilder filePath = new StringBuilder();
//        filePath.append("src");
//        filePath.append(File.separator).append("main");
//        filePath.append(File.separator).append("resources");
//        filePath.append(File.separator).append("jp");
//        filePath.append(File.separator).append("co");
//        filePath.append(File.separator).append("ndensan");
//        filePath.append(File.separator).append("reams");
//        filePath.append(File.separator).append("db");
//        filePath.append(File.separator).append("dbu");
//        filePath.append(File.separator).append("batchcontroller");
//        filePath.append(File.separator).append("hiroshimadomain");
//        filePath.append(File.separator).append("inputFileName");
//
//        File file = new File(filePath.toString());
//        return new RString(file.getAbsolutePath());
//
//    }
    /**
     * 帳票出力パラメータの取得です。
     *
     * @return 帳票出力パラメータ
     */
    @Step(REPORT_PROCESS)
    private IBatchFlowCommand hiroshimaDomainReportProcess() {
        return loopBatch(HiroshimaDomainReportProcess.class).arguments(getParameter().toHiroshimaDomainProcessParameter()).define();
    }
}
