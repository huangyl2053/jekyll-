/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa3.SonotashiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * その他資料（A3版）のReportです。
 *
 * @reamsid_L DBE-0150-250 wangrenze
 */
public class SonotashiryoA3Report extends Report<SonotashiryoA3ReportSource> {

    private final JimuSonotashiryoBusiness data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public SonotashiryoA3Report(JimuSonotashiryoBusiness data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<SonotashiryoA3ReportSource> reportSourceWriter) {

        if (data != null) {
            if (data.getその他資料() != null && 0 < data.getその他資料().size()) {
                for (int i = 0; i < (int) Math.ceil((double) data.getその他資料().size() / 2); i++) {
                    ISonotashiryoA3Editor editor = new SonotashiryoA3Editor(data, i);
                    ISonotashiryoA3Builder builder = new SonotashiryoA3Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            } else {
                ISonotashiryoA3Editor editor = new SonotashiryoA3Editor(data, 0);
                ISonotashiryoA3Builder builder = new SonotashiryoA3Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }

    }
}
