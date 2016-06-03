/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinYobihanteiKinyuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.iinYobihanteiKinyuhyoReportSource.IinYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用予備判定記入表のReportです。
 *
 * @reamsid_L DBE-0150-150 wangrenze
 */
public class IinYobihanteiKinyuhyoReport extends Report<IinYobihanteiKinyuhyoReportSource> {

    private final List<IinYobihanteiKinyuhyoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 委員用予備判定記入表のITEM
     * @return 委員用予備判定記入表のReport
     */
    public static IinYobihanteiKinyuhyoReport createFrom(List<IinYobihanteiKinyuhyoItem> itemList) {

        return new IinYobihanteiKinyuhyoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 委員用予備判定記入表のITEM
     */
    protected IinYobihanteiKinyuhyoReport(List<IinYobihanteiKinyuhyoItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<IinYobihanteiKinyuhyoReportSource> reportSourceWriter) {
        for (IinYobihanteiKinyuhyoItem item : itemList) {
            IinYobihanteiKinyuhyoEditor editor = new IinYobihanteiKinyuhyoEditor(item);
            IinYobihanteiKinyuhyoBuilder builder = new IinYobihanteiKinyuhyoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
