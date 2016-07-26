/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa4.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * その他資料（A4版）のReportです。
 *
 * @reamsid_L DBE-0150-270 wangrenze
 */
public class SonotashiryoA4Report extends Report<SonotashiryoA4ReportSource> {

    private final JimuSonotashiryoBusiness data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public SonotashiryoA4Report(JimuSonotashiryoBusiness data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<SonotashiryoA4ReportSource> reportSourceWriter) {

        ISonotashiryoA4Editor editor = new SonotashiryoA4Editor(data);
        ISonotashiryoA4Builder builder = new SonotashiryoA4Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
