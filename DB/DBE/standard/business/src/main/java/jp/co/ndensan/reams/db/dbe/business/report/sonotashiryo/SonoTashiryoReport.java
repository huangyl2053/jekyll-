/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.SonoTashiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryo.SonoTashiryoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定情報提供その他資料情報のReportです。
 *
 * @reamsid_L DBE-0230-050 zhangzhiming
 */
public class SonoTashiryoReport extends Report<SonoTashiryoReportSource> {

    private final SonoTashiryoEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護認定情報提供その他資料情報のdataList
     */
    public SonoTashiryoReport(SonoTashiryoEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<SonoTashiryoReportSource> reportSourceWriter) {
        ISonoTashiryoBodyEditor editor = new SonoTashiryoBodyEditor(data);
        ISonoTashiryoBuilder builder = new SonoTashiryoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
