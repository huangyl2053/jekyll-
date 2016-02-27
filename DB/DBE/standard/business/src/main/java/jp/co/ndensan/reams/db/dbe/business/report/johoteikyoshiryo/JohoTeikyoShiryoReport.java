/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo;

import jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo.JohoTeikyoShiryoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定結果情報提供票（主治医）のReportです。
 */
public class JohoTeikyoShiryoReport extends Report<JohoTeikyoShiryoReportSource> {

    private final JohoTeikyoShiryoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定結果情報提供票（主治医）のITEM
     * @return 要介護認定結果情報提供票（主治医）のReport
     */
    public static JohoTeikyoShiryoReport createFrom(JohoTeikyoShiryoItem item) {

        return new JohoTeikyoShiryoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定結果情報提供票（主治医）のITEM
     */
    protected JohoTeikyoShiryoReport(JohoTeikyoShiryoItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<JohoTeikyoShiryoReportSource> reportSourceWriter) {
        IJohoTeikyoShiryoEditor editor = new JohoTeikyoShiryoEditor(item);
        IJohoTeikyoShiryoBuilder builder = new JohoTeikyoShiryoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
