/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査対象者一覧表A3のReportです。
 *
 * @reamsid_L DBE-0150-230 lishengli
 */
public class ShinsakaishiryoA3Report extends Report<ShinsakaishiryoA3ReportSource> {

    private final JimuShinsakaishiryoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 介護認定審査対象者一覧表のITEMLIST
     */
    public ShinsakaishiryoA3Report(JimuShinsakaishiryoBusiness business) {
        this.business = business;
    }

    /**
     *
     * @param reportSourceWriter 介護認定審査対象者一覧表A3Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsakaishiryoA3ReportSource> reportSourceWriter) {
        IShinsakaishiryoA3Editor headerEditor = new ShinsakaishiryoA3Editor(business);
        IShinsakaishiryoA3Builder builder = new ShinsakaishiryoA3BuilderImpl(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
