/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100030;

import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.ShugiiIkenshoKakuninshoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100030.ShujiiIkenshoKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書確認書Reportです。
 *
 * @reamsid_L DBD-5790-030 x_zhaowen
 */
public class ShujiiIkenshoKakuninshoReport extends Report<ShujiiIkenshoKakuninshoReportSource> {

    private final ShugiiIkenshoKakuninshoEntity 主治医意見書確認書Entity;

    /**
     * インスタンスを生成します。
     *
     * @param 主治医意見書確認書Entity ShugiiIkenshoKakuninshoEntity
     */
    public ShujiiIkenshoKakuninshoReport(ShugiiIkenshoKakuninshoEntity 主治医意見書確認書Entity) {
        this.主治医意見書確認書Entity = 主治医意見書確認書Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoKakuninshoReportSource> writer) {
        IShugiiIkenshoKakuninshoEditor editor = new ShujiiIkenshoKakuninshoEditor(主治医意見書確認書Entity);
        IShugiiIkenshoKakuninshoBuilder builder = new ShujiiIkenshoKakuninshoBuilder(editor);
        writer.writeLine(builder);
    }
}
