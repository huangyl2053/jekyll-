/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahoshuichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahoshuichiran.ShinsaHoshuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会委員報酬一覧表のReportです。
 *
 * @reamsid_L DBE-1920-030 zhaoyao
 */
public class ShinsaHoshuIchiranReport extends Report<ShinsaHoshuIchiranReportSource> {

    private final ShinsaHoshuIchiranEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 帳票発行のdataList
     */
    public ShinsaHoshuIchiranReport(ShinsaHoshuIchiranEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsaHoshuIchiranReportSource> reportSourceWriter) {
        IShinsaHoshuIchiranEditor editor = new ShinsaHoshuIchiranEditor(data);
        IShinsaHoshuIchiranBuilder builder = new ShinsaHoshuIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
