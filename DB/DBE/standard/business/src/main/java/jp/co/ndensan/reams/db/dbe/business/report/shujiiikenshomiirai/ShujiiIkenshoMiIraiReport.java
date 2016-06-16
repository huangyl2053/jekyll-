/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiirai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshomiirai.ShujiiIkenshoMiIraiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiirai.ShujiiIkenshoMiIraiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書依頼未処理者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-130 suguangjun
 */
public class ShujiiIkenshoMiIraiReport extends Report<ShujiiIkenshoMiIraiReportSource> {

    private final ShujiiIkenshoMiIraiEntity data;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param index int
     */
    public ShujiiIkenshoMiIraiReport(ShujiiIkenshoMiIraiEntity data, int index) {
        this.data = data;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoMiIraiReportSource> reportSourceWriter) {

        IShujiiIkenshoMiIraiEditor editor = new ShujiiIkenshoMiIraiEditor(data, index);
        IShujiiIkenshoMiIraiBuilder builder = new ShujiiIkenshoMiIraiBuilder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
