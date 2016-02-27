/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.joseikinKyufuShinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.joseikinKyufuShinseisho.JoseikinKyufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険助成金給付申請書のReportです。
 */
public class JoseikinKyufuShinseishoReport extends Report<JoseikinKyufuShinseishoReportSource> {

    private final JoseikinKyufuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険助成金給付申請書のITEM
     * @return 介護保険助成金給付申請書のReport
     */
    public static JoseikinKyufuShinseishoReport createFrom(
            JoseikinKyufuShinseishoItem item) {

        return new JoseikinKyufuShinseishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険助成金給付申請書のITEM
     */
    protected JoseikinKyufuShinseishoReport(JoseikinKyufuShinseishoItem item) {

        this.item = item;
    }

	/**
     * 介護保険助成金給付申請書writeByします。
     * @param reportSourceWriter 介護保険助成金給付申請書クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<JoseikinKyufuShinseishoReportSource> reportSourceWriter) {
        IJoseikinKyufuShinseishoEditor editor = new JoseikinKyufuShinseishoEditor(item);
        IJoseikinKyufuShinseishoBuilder builder = new JoseikinKyufuShinseishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
