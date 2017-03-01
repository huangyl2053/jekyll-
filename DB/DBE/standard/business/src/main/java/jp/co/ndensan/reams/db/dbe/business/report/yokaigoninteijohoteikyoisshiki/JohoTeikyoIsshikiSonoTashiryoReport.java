/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.SonoTashiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定情報提供一式その他資料情報のReportです。
 *
 * @author N3212 竹内 和紀
 */
public class JohoTeikyoIsshikiSonoTashiryoReport extends Report<YokaigoNinteiJohoTeikyoIsshikiReportSource> {

    private final SonoTashiryoEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護認定情報提供その他資料情報のdataList
     */
    public JohoTeikyoIsshikiSonoTashiryoReport(SonoTashiryoEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter) {
        IJohoTeikyoIsshikiBuilder builder = new JohoTeikyoIsshikiSonoTashiryoBuilder(data);
        reportSourceWriter.writeLine(builder);
    }
}
