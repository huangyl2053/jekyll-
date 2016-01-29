/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

import jp.co.ndensan.reams.db.dbu.entity.report.bemmeisyo.BemmeisyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 弁明書のReportです。
 */
public class BemmeisyoReport extends Report<BemmeisyoReportSource> {

    private final BemmeisyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 弁明書ヘッダのITEM
     * @param itemList 弁明書ボディのITEMリスト
     * @return 弁明書のReport
     */
    public static BemmeisyoReport createFrom(
            BemmeisyoHeadItem headItem) {

        return new BemmeisyoReport(
                headItem);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 弁明書ヘッダのITEM
     * @param itemList 弁明書のITEMリスト
     */
    protected BemmeisyoReport(
            BemmeisyoHeadItem headItem) {

        this.headItem = headItem;
    }

    /**
     *
     * @param reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<BemmeisyoReportSource> reportSourceWriter) {
        BemmeisyoEditor headerEditor = new BemmeisyoHeaderEditor(headItem);
        BemmeisyoBuilder builder = new BemmeisyoBuilderImpl(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
