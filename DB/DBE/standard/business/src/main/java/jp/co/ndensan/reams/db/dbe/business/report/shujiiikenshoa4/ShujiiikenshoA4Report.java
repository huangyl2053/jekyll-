/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho.ShujiiikenshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1A4.ShujiiikenshoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用主治医意見書のReportです。
 *
 * @reamsid_L DBE-0150-090 wangrenzes
 */
public class ShujiiikenshoA4Report extends Report<ShujiiikenshoA4ReportSource> {

    private final ShujiiikenshoEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public ShujiiikenshoA4Report(ShujiiikenshoEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiikenshoA4ReportSource> reportSourceWriter) {

        IShujiiikenshoA4Editor editor = new ShujiiikenshoA4Editor(data);
        IShujiiikenshoA4Builder builder = new ShujiiikenshoA4Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
