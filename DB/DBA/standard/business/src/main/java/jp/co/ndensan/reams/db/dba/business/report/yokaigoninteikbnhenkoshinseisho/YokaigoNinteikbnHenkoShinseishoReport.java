/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 要介護認定区分変更申請書のReportです。
 */
public class YokaigoNinteikbnHenkoShinseishoReport
        extends Report<YokaigoNinteikbnHenkoShinseishoReportSource> {

    private final YokaigoNinteikbnHenkoShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定区分変更申請書のITEM
     * @return 要介護認定区分変更申請書のReport
     */
    public static YokaigoNinteikbnHenkoShinseishoReport createFrom(
            YokaigoNinteikbnHenkoShinseishoItem item) {

        return new YokaigoNinteikbnHenkoShinseishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定区分変更申請書のITEM
     */
    protected YokaigoNinteikbnHenkoShinseishoReport(
            YokaigoNinteikbnHenkoShinseishoItem item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteikbnHenkoShinseishoReportSource> reportSourceWriter) {
        IYokaigoNinteikbnHenkoShinseishoEditor editor
                = new YokaigoNinteikbnHenkoShinseishoItemEditor(item);
        IYokaigoNinteikbnHenkoShinseishoBuilder builder
                = new YokaigoNinteikbnHenkoShinseishoItemBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
