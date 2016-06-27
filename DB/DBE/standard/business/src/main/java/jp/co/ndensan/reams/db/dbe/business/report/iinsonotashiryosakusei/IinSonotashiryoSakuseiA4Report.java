/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinsonotashiryosakusei.IinSonotashiryoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用その他資料のReportです。
 *
 * @reamsid_L DBE-0150-170 wangrenze
 */
public class IinSonotashiryoSakuseiA4Report extends Report<SonotashiryoA4ReportSource> {

    private final IinSonotashiryoSakuseiEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public IinSonotashiryoSakuseiA4Report(IinSonotashiryoSakuseiEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<SonotashiryoA4ReportSource> reportSourceWriter) {

        IIinSonotashiryoSakuseiA4Editor editor = new IinSonotashiryoSakuseiA4Editor(data);
        IIinSonotashiryoSakuseiA4Builder builder = new IinSonotashiryoSakuseiA4Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
