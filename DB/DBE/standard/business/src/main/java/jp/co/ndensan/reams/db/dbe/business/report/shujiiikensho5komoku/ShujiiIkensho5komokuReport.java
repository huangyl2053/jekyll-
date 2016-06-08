/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho5komoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho5komoku.ShujiiIkensho5komokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho5komoku.ShujiiIkensho5komokuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書5項目確認一覧表のReportです。
 *
 * @reamsid_L DBE-1390-170 suguangjun
 */
public class ShujiiIkensho5komokuReport extends Report<ShujiiIkensho5komokuReportSource> {

    private final List<ShujiiIkensho5komokuEntity> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ShujiiIkensho5komokuReport(List<ShujiiIkensho5komokuEntity> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkensho5komokuReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            IShujiiIkensho5komokuEditor editor = new ShujiiIkensho5komokuEditor(data.get(i), i);
            IShujiiIkensho5komokuBuilder builder = new ShujiiIkensho5komokuBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            ShujiiIkensho5komokuEntity entity = new ShujiiIkensho5komokuEntity();
            entity.set氏名(new RString("該当データがありません"));
            IShujiiIkensho5komokuEditor editor = new ShujiiIkensho5komokuEditor(entity, -1);
            IShujiiIkensho5komokuBuilder builder = new ShujiiIkensho5komokuBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
