/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険住所地特例施設変更通知書のReportです。
 */
public class ShisetsuHenkoTsuchishoReport extends Report<ShisetsuHenkoTsuchishoReportSource> {

    private final ShisetsuHenkoTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険住所地特例施設変更通知書のITEM
     * @return 介護保険住所地特例施設変更通知書のReport
     */
    public static ShisetsuHenkoTsuchishoReport createFrom(
            ShisetsuHenkoTsuchishoItem item) {

        return new ShisetsuHenkoTsuchishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険住所地特例施設変更通知書のITEM
     */
    protected ShisetsuHenkoTsuchishoReport(ShisetsuHenkoTsuchishoItem item) {
        this.item = item;
    }

    /**
     * 介護保険住所地特例施設変更通知書writeByです。
     *
     * @param reportSourceWriter 介護保険住所地特例施設変更通知書のreportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ShisetsuHenkoTsuchishoReportSource> reportSourceWriter) {
        IShisetsuHenkoTsuchishoEditor editor = new ShisetsuHenkoTsuchishoEditor(item);
        IShisetsuHenkoTsuchishoBuilder builder = new ShisetsuHenkoTsuchishoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }

}
