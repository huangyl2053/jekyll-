/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shijiiikenshoiraihenko;

import jp.co.ndensan.reams.db.dbe.business.core.shijiiikenshoiraihen.ShijiiIkenshoIraiHenko;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shijiiikenshoiraihenko.ShijiiIkenshoIraiHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成依頼変更者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-140 suguangjun
 */
public class ShijiiIkenshoIraiHenkoReport extends Report<ShijiiIkenshoIraiHenkoReportSource> {

    private final ShijiiIkenshoIraiHenko data;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param index int
     */
    public ShijiiIkenshoIraiHenkoReport(ShijiiIkenshoIraiHenko data, int index) {
        this.data = data;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShijiiIkenshoIraiHenkoReportSource> reportSourceWriter) {

        IShijiiIkenshoIraiHenkoEditor editor = new ShijiiIkenshoIraiHenkoEditor(data, index);
        IShijiiIkenshoIraiHenkoBuilder builder = new ShijiiIkenshoIraiHenkoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
