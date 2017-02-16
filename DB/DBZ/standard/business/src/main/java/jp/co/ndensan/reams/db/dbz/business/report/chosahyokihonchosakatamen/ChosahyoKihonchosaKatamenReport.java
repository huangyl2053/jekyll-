/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosahyokihonchosakatamen;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（基本調査）のReportです。
 *
 * @reamsid_L DBE-0080-020 zuotao
 */
public class ChosahyoKihonchosaKatamenReport extends Report<ChosahyoKihonchosaKatamenReportSource> {

    private final List<ChosahyoKihonchosaKatamenItem> itemList;
    private final ChosahyoKihonchosaKatamenItem item;
    private final int layoutIndex;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（基本調査）のITEM
     * @return 要介護認定調査票（基本調査）のReport
     */
    public static ChosahyoKihonchosaKatamenReport createFrom(List<ChosahyoKihonchosaKatamenItem> itemList) {

        return new ChosahyoKihonchosaKatamenReport(itemList, null, 0);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（基本調査）のITEM
     * @return 要介護認定調査票（基本調査）のReport
     */
    public static ChosahyoKihonchosaKatamenReport createFrom(ChosahyoKihonchosaKatamenItem item) {
        return new ChosahyoKihonchosaKatamenReport(null, item, 0);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（基本調査）のITEM
     * @return 要介護認定調査票（基本調査）のReport
     */
    public static ChosahyoKihonchosaKatamenReport createFrom(List<ChosahyoKihonchosaKatamenItem> itemList, int layoutIndex) {

        return new ChosahyoKihonchosaKatamenReport(itemList, null, layoutIndex);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（基本調査）のITEM
     * @return 要介護認定調査票（基本調査）のReport
     */
    public static ChosahyoKihonchosaKatamenReport createFrom(ChosahyoKihonchosaKatamenItem item, int layoutIndex) {
        return new ChosahyoKihonchosaKatamenReport(null, item, layoutIndex);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（基本調査）のITEMLIST
     * @param item 要介護認定調査票（基本調査）のITEM
     */
    protected ChosahyoKihonchosaKatamenReport(List<ChosahyoKihonchosaKatamenItem> itemList, ChosahyoKihonchosaKatamenItem item, int layoutIndex) {
        this.itemList = itemList;
        this.item = item;
        this.layoutIndex = layoutIndex;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosahyoKihonchosaKatamenReportSource> reportSourceWriter) {
        if (itemList != null) {
            for (ChosahyoKihonchosaKatamenItem chosahyoKihonchosaKatamenItem : itemList) {
                ChosahyoKihonchosaKatamenEditor editor = new ChosahyoKihonchosaKatamenEditor(chosahyoKihonchosaKatamenItem, layoutIndex);
                ChosahyoKihonchosaKatamenBuilder builder = new ChosahyoKihonchosaKatamenBuilder(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            ChosahyoKihonchosaKatamenEditor editor = new ChosahyoKihonchosaKatamenEditor(item, layoutIndex);
            ChosahyoKihonchosaKatamenBuilder builder = new ChosahyoKihonchosaKatamenBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }

    }
}
