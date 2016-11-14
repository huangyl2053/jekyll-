/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryoa4;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryoa4.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

        if (data != null) {
            List<RString> ファイルPathList = data.getその他資料();
            if (ファイルPathList != null && 0 < ファイルPathList.size()) {
                for (int i = 0; i < ファイルPathList.size(); i++) {
                    ISonotashiryoA4Editor editor = new SonotashiryoA4Editor(data, i);
                    ISonotashiryoA4Builder builder = new SonotashiryoA4Builder(editor);
                    reportSourceWriter.writeLine(builder);
                }
            } else {
                ISonotashiryoA4Editor editor = new SonotashiryoA4Editor(data, 0);
                ISonotashiryoA4Builder builder = new SonotashiryoA4Builder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }

    }
}
