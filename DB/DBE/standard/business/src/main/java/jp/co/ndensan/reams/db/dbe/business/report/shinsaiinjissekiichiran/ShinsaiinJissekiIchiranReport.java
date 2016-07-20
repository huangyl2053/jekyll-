/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会委員報酬実績集計表のレポートです。
 *
 * @reamsid_L DBE-1700-040 wanghuafeng
 */
public class ShinsaiinJissekiIchiranReport extends Report<ShinsaiinJissekiIchiranReportSource> {

    private final ShinsaiinJissekiIchiranRelateEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data dataList
     */
    public ShinsaiinJissekiIchiranReport(ShinsaiinJissekiIchiranRelateEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsaiinJissekiIchiranReportSource> reportSourceWriter) {
        IShinsaiinJissekiIchiranEditor editor = new ShinsaiinJissekiIchiranEditor(data);
        IShinsaiinJissekiIchiranBuidler builder = new ShinsaiinJissekiIchiranBuidler(editor);
        reportSourceWriter.writeLine(builder);
    }

}
