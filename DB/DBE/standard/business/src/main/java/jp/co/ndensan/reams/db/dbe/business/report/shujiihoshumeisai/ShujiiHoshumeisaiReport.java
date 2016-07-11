/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshumeisai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai.ShujiiHoshumeisaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai.ShujiiHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のShujiiHoshumeisaiReportです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
public class ShujiiHoshumeisaiReport extends Report<ShujiiHoshumeisaiReportSource> {

    private final ShujiiHoshumeisaiEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data ShujiiHoshumeisaiEntity
     */
    public ShujiiHoshumeisaiReport(ShujiiHoshumeisaiEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiHoshumeisaiReportSource> reportSourceWriter) {
        IShujiiHoshumeisaiEditor editor = new ShujiiHoshumeisaiEditor(data);
        IShujiiHoshumeisaiBuilder builder = new ShujiiHoshumeisaiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
