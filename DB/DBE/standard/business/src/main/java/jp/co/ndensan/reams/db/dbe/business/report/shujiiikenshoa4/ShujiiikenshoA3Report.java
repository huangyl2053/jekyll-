/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho.ShujiiikenshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1A4.ShujiiikenshoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用主治医意見書A3のReportです。
 *
 * @reamsid_L DBE-0150-090 wangrenze
 */
public class ShujiiikenshoA3Report extends Report<ShujiiikenshoA3ReportSource> {

    private final ShujiiikenshoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item 事務局用主治医意見書のITEM
     */
    public ShujiiikenshoA3Report(ShujiiikenshoEntity item) {
        this.item = item;
    }

    /**
     *
     * @param reportSourceWriter 事務局用主治医意見書A3Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShujiiikenshoA3ReportSource> reportSourceWriter) {
        IShujiiikenshoA3Editor headerEditor = new ShujiiikenshoA3Editor(item);
        IShujiiikenshoA3Builder builder = new ShujiiikenshoA3Builder(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
