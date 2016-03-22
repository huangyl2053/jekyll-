/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険住所地特例施設退所通知書のReportです。
 */
public class ShisetsuTaishoTsuchishoReport extends Report<ShisetsuTaishoTsuchishoReportSource> {

    private final ShisetsuTaishoTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険住所地特例施設退所通知書のITEM
     * @return 介護保険住所地特例施設退所通知書のReport
     */
    public static ShisetsuTaishoTsuchishoReport createFrom(
            ShisetsuTaishoTsuchishoItem item) {

        return new ShisetsuTaishoTsuchishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険住所地特例施設退所通知書のITEM
     */
    protected ShisetsuTaishoTsuchishoReport(ShisetsuTaishoTsuchishoItem item) {
        this.item = item;
    }

    /**
     * 介護保険住所地特例施設退所通知書writeByです。
     *
     * @param reportSourceWriter 介護保険住所地特例施設退所通知書のreportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ShisetsuTaishoTsuchishoReportSource> reportSourceWriter) {
        IShisetsuTaishoTsuchishoEditor editor = new ShisetsuTaishoTsuchishoEditor(item);
        IShisetsuTaishoTsuchishoBuilder builder = new ShisetsuTaishoTsuchishoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }

}
