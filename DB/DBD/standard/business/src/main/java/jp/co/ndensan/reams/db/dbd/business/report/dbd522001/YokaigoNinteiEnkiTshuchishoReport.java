/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd522001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.YokaigoNinteiEnkiTshuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522001.YokaigoNinteiEnkiTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定延期通知書タイトルのReportです。
 *
 * @reamsid_L DBD-1410-030 chenxin
 */
public class YokaigoNinteiEnkiTshuchishoReport extends Report<YokaigoNinteiEnkiTshuchishoReportSource> {

    private final YokaigoNinteiEnkiTshuchishoEntity target;

    /**
     * インスタンスを生成します。
     *
     * @param target 要介護認定延期通知書タイトル
     */
    public YokaigoNinteiEnkiTshuchishoReport(YokaigoNinteiEnkiTshuchishoEntity target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiEnkiTshuchishoReportSource> reportSourceWriter) {

        IYokaigoNinteiEnkiTshuchishoEditor editor = new YokaigoNinteiEnkiTshuchishoEditor(target);
        IYokaigoNinteiEnkiTshuchishoBuilder builder = new YokaigoNinteiEnkiTshuchishoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
