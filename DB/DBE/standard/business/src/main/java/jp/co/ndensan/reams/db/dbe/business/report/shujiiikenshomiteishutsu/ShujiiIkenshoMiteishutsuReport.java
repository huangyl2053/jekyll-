/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiteishutsu;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書未提出者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-150 suguangjun
 */
public class ShujiiIkenshoMiteishutsuReport extends Report<ShujiiIkenshoMiteishutsuReportSource> {

    private final ShujiiIkenshoMiteishutsuEntity data;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param index int
     */
    public ShujiiIkenshoMiteishutsuReport(ShujiiIkenshoMiteishutsuEntity data, int index) {
        this.data = data;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoMiteishutsuReportSource> reportSourceWriter) {

        IShujiiIkenshoMiteishutsuEditor editor = new ShujiiIkenshoMiteishutsuEditor(data, index);
        IShujiiIkenshoMiteishutsuBuilder builder = new ShujiiIkenshoMiteishutsuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
