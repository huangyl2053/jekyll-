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
 * 要介護認定情報提供一式のReportです。
 *
 * @author N3212 竹内 和紀
 */
public class JohoTeikyoIsshikiReport extends Report<YokaigoNinteiJohoTeikyoIsshikiReportSource> {

    private final SonoTashiryoEntity その他資料Entity;

    /**
     * インスタンスを生成します。
     *
     * @param その他資料Entity SonoTashiryoEntity
     */
    public JohoTeikyoIsshikiReport(SonoTashiryoEntity その他資料Entity) {
        this.その他資料Entity = その他資料Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter) {
        IJohoTeikyoIsshikiBuilder builder = new JohoTeikyoIsshikiSonoTashiryoBuilder(その他資料Entity);
        reportSourceWriter.writeLine(builder);
    }
}
