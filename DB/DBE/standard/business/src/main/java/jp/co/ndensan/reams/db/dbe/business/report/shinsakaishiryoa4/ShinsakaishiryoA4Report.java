/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査対象者一覧表A4のReportです。
 *
 * @reamsid_L DBE-0150-260 lishengli
 */
public class ShinsakaishiryoA4Report extends Report<ShinsakaishiryoA4ReportSource> {

    private final JimuShinsakaishiryoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 介護認定審査対象者一覧表
     */
    public ShinsakaishiryoA4Report(JimuShinsakaishiryoBusiness business) {
        this.business = business;
    }

    /**
     * @param reportSourceWriter 介護認定審査対象者一覧表A4Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsakaishiryoA4ReportSource> reportSourceWriter) {
        IShinsakaishiryoA4Editor headerEditor = new ShinsakaishiryoA4Editor(business);
        IShinsakaishiryoA4Builder builder = new ShinsakaishiryoA4BuilderImpl(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
