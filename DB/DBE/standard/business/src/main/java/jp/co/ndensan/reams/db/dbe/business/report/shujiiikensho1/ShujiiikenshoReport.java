/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujikensho.ShujiiikenshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1.ShujiiikenshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書ののReportです。
 *
 * @reamsid_L DBE-0230-070 lizhuoxuan
 */
public class ShujiiikenshoReport extends Report<ShujiiikenshoReportSource> {

    private final ShujiiikenshoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 主治医意見書Entity
     */
    public ShujiiikenshoReport(ShujiiikenshoEntity entity) {
        this.entity = entity;
    }

    /**
     * 主治医意見書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShujiiikenshoReportSource> reportSourceWriter) {
        IShujiiikenshoEditor editor = new ShujiiikenshoEditor(entity, 1);
        IShujiiikenshoBuilder builder = new ShujiiikenshoBuilder(editor);
        reportSourceWriter.writeLine(builder);
        IShujiiikenshoEditor editor2 = new ShujiiikenshoEditor(entity, 2);
        IShujiiikenshoBuilder builder2 = new ShujiiikenshoBuilder(editor2);
        reportSourceWriter.writeLine(builder2);
    }
}
