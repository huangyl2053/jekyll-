/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 適用除外者台帳のReportです。
 *
 * @reamsid_L DBA-0412-040 lishengli
 */
public class TekiyojogaishaDaichoReport extends Report<TekiyojogaishaDaichoReportSource> {

    private final List<TekiyojogaishaDaichoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 適用除外者台帳ボディのITEMリスト
     * @return 適用除外者台帳のReport
     */
    public static TekiyojogaishaDaichoReport createFrom(
            List<TekiyojogaishaDaichoItem> itemList) {

        return new TekiyojogaishaDaichoReport(
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 適用除外者台帳のITEMリスト
     */
    protected TekiyojogaishaDaichoReport(
            List<TekiyojogaishaDaichoItem> itemList) {

        this.itemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TekiyojogaishaDaichoReportSource> reportSourceWriter) {
        for (TekiyojogaishaDaichoItem item : itemList) {
            TekiyojogaishaDaichoEditor editor = new TekiyojogaishaDaichoEditor(item);
            ITekiyojogaishaDaichoBuilder builder = new TekiyojogaishaDaichoBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
