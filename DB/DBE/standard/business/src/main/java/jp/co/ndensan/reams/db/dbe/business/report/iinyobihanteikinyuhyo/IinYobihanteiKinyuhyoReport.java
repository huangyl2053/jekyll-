/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinYobihanteiKinyuhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.iinyobihanteikinyuhyo.IinYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用予備判定記入表のReportです。
 *
 * @reamsid_L DBE-0150-150 wangrenze
 */
public class IinYobihanteiKinyuhyoReport extends Report<IinYobihanteiKinyuhyoReportSource> {

    private final IinYobihanteiKinyuhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 委員用予備判定記入表のITEM
     * @return 委員用予備判定記入表のReport
     */
    public static IinYobihanteiKinyuhyoReport createFrom(IinYobihanteiKinyuhyoItem item) {

        return new IinYobihanteiKinyuhyoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 委員用予備判定記入表のITEM
     */
    protected IinYobihanteiKinyuhyoReport(IinYobihanteiKinyuhyoItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<IinYobihanteiKinyuhyoReportSource> reportSourceWriter) {

        IinYobihanteiKinyuhyoEditor editor = new IinYobihanteiKinyuhyoEditor(item);
        IinYobihanteiKinyuhyoBuilder builder = new IinYobihanteiKinyuhyoBuilder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
