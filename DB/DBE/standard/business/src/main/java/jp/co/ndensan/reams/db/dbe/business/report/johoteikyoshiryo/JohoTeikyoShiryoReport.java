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
 *
 * @reamsid_L DBE-0220-020 wangkun
 */
public class JohoTeikyoShiryoReport extends Report<JohoTeikyoShiryoReportSource> {

    private final JohoTeikyoShiryo item;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定結果情報提供票（主治医）のitem
     */
    public JohoTeikyoShiryoReport(JohoTeikyoShiryo item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<JohoTeikyoShiryoReportSource> reportSourceWriter) {
        IJohoTeikyoShiryoEditor editor = new JohoTeikyoShiryoEditor(item);
        IJohoTeikyoShiryoBuilder builder = new JohoTeikyoShiryoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
