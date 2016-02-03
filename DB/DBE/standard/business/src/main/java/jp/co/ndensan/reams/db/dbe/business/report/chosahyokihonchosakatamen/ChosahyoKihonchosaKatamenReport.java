/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（基本調査）のReportです。
 *
 */
public class ChosahyoKihonchosaKatamenReport extends Report<ChosahyoKihonchosaKatamenReportSource> {

    private final ChosahyoKihonchosaKatamenItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（基本調査）のITEM
     * @return 要介護認定調査票（基本調査）のReport
     */
    public static ChosahyoKihonchosaKatamenReport createFrom(ChosahyoKihonchosaKatamenItem item) {

        return new ChosahyoKihonchosaKatamenReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（基本調査）のITEM
     */
    protected ChosahyoKihonchosaKatamenReport(ChosahyoKihonchosaKatamenItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosahyoKihonchosaKatamenReportSource> reportSourceWriter) {
        ChosahyoKihonchosaKatamenEditor editor = new ChosahyoKihonchosaKatamenEditor(item);
        ChosahyoKihonchosaKatamenBuilder builder = new ChosahyoKihonchosaKatamenBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
