/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd532001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd532001.YokaigoNinteiKekkaTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定結果通知書のReportです。
 *
 * @reamsid_L DBD-1430-030 b_zhengs
 */
public final class YokaigoNinteiKekkaTshuchishoReport extends Report<YokaigoNinteiKekkaTshuchishoReportSource> {

    private final YokaigoNinteiKekkaTshuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 要介護認定結果通知書
     * @return 要介護認定結果通知書
     */
    public static YokaigoNinteiKekkaTshuchishoReport createReport(@NonNull YokaigoNinteiKekkaTshuchishoItem bodyItem) {
        return new YokaigoNinteiKekkaTshuchishoReport(bodyItem);
    }

    private YokaigoNinteiKekkaTshuchishoReport(YokaigoNinteiKekkaTshuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiKekkaTshuchishoReportSource> writer) {
        IYokaigoNinteiKekkaTshuchishoEditor bodyEditor = new YokaigoNinteiKekkaTshuchishoBodyEditor(bodyItem);
        IYokaigoNinteiKekkaTshuchishoBuilder builder = new YokaigoNinteiKekkaTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
