/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用介護認定審査対象者一覧表A4のReportです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
public class ShinsakaishiryoA4Report extends Report<ShinsakaishiryoA4ReportSource> {

    private final ShinsakaishiryoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 事務局用介護認定審査対象者一覧表のITEM
     */
    public ShinsakaishiryoA4Report(ShinsakaishiryoItem item) {
        this.item = item;
    }

    /**
     * @param reportSourceWriter 事務局用介護認定審査対象者一覧表Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsakaishiryoA4ReportSource> reportSourceWriter) {
        IShinsakaishiryoA4Editor headerEditor = new ShinsakaishiryoA4Editor(item);
        IShinsakaishiryoA4Builder builder = new ShinsakaishiryoA4BuilderImpl(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
