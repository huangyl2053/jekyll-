/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinsonotashiryosakusei.IinSonotashiryoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用その他資料のReportです。
 *
 * @reamsid_L DBE-0150-170 wangrenze
 */
public class IinSonotashiryoSakuseiA3Report extends Report<SonotashiryoA3ReportSource> {

    private final IinSonotashiryoSakuseiEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public IinSonotashiryoSakuseiA3Report(IinSonotashiryoSakuseiEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<SonotashiryoA3ReportSource> reportSourceWriter) {

        IIinSonotashiryoSakuseiA3Editor editor = new IinSonotashiryoSakuseiA3Editor(data);
        IIinSonotashiryoSakuseiA3Builder builder = new IinSonotashiryoSakuseiA3Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
