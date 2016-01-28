/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakukaishujizenshinseishoninkekka.JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住宅改修事前申請承認結果通知書のReportです。
 */
public class JutakukaishuJizenShinseiShoninKekkaTsuchishoReport extends Report<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> {

    private final JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 住宅改修事前申請承認結果通知書のITEM
     * @return 住宅改修事前申請承認結果通知書のReport
     */
    public static JutakukaishuJizenShinseiShoninKekkaTsuchishoReport createFrom(
            JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item) {

        return new JutakukaishuJizenShinseiShoninKekkaTsuchishoReport(
                item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 住宅改修事前申請承認結果通知書表のITEM
     */
    protected JutakukaishuJizenShinseiShoninKekkaTsuchishoReport(
            JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> reportSourceWriter) {
        IJutakukaishuJizenShinseiShoninKekkaTsuchishoEditor editor = new JutakukaishuJizenShinseiShoninKekkaTsuchishoEditor(item);
        IJutakukaishuJizenShinseiShoninKekkaTsuchishoBuilder builder = new JutakukaishuJizenShinseiShoninKekkaTsuchishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
