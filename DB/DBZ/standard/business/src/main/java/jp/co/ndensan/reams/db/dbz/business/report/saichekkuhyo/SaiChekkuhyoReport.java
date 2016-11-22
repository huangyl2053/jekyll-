/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票差異チェック票のReportです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoReport extends Report<SaiChekkuhyoReportSource> {

    private static final int 第１群_COUNT = 20;
    private final List<SaiChekkuhyoItem> itemList;
    private final SaiChekkuhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票差異チェック票のItem
     * @return 要介護認定調査票差異チェック票のReport
     */
    public static SaiChekkuhyoReport createFrom(SaiChekkuhyoItem item) {
        return new SaiChekkuhyoReport(null, item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票差異チェック票のItem
     * @return 要介護認定調査票差異チェック票のReport
     */
    public static SaiChekkuhyoReport createFrom(List<SaiChekkuhyoItem> itemList) {
        return new SaiChekkuhyoReport(itemList, null);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票差異チェック票のItemList
     * @param item 要介護認定調査票差異チェック票のItem
     */
    protected SaiChekkuhyoReport(List<SaiChekkuhyoItem> itemList, SaiChekkuhyoItem item) {
        this.itemList = itemList;
        this.item = item;
    }

    /**
     * 帳票を作成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<SaiChekkuhyoReportSource> reportSourceWriter) {
        if (itemList != null) {
            for (SaiChekkuhyoItem saiChekkuhyoItem : itemList) {
                for (int i = 1; i <= 第１群_COUNT; i++) {
                    ISaiChekkuhyoEditor editor = new SaiChekkuhyoEditorImpl(saiChekkuhyoItem, i);
                    ISaiChekkuhyoBuilder builder = new SaiChekkuhyoBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                }
            }
        } else {
            for (int i = 1; i <= 第１群_COUNT; i++) {
                ISaiChekkuhyoEditor editor = new SaiChekkuhyoEditorImpl(item, i);
                ISaiChekkuhyoBuilder builder = new SaiChekkuhyoBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        }

    }
}
