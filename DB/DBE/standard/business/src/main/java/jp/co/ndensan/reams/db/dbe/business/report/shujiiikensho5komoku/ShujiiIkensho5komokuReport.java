/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho5komoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho5komoku.ShujiiIkensho5komokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho5komoku.ShujiiIkensho5komokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書5項目確認一覧表のReportです。
 *
 * @reamsid_L DBE-1390-170 suguangjun
 */
public class ShujiiIkensho5komokuReport extends Report<ShujiiIkensho5komokuReportSource> {

    private final ShujiiIkensho5komokuEntity data;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param index int
     */
    public ShujiiIkensho5komokuReport(ShujiiIkensho5komokuEntity data, int index) {
        this.data = data;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkensho5komokuReportSource> reportSourceWriter) {
        IShujiiIkensho5komokuEditor editor = new ShujiiIkensho5komokuEditor(data, index);
        IShujiiIkensho5komokuBuilder builder = new ShujiiIkensho5komokuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
