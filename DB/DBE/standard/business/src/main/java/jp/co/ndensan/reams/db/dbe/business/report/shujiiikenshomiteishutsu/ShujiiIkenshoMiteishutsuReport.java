/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiteishutsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書未提出者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-150 suguangjun
 */
public class ShujiiIkenshoMiteishutsuReport extends Report<ShujiiIkenshoMiteishutsuReportSource> {

    private final List<ShujiiIkenshoMiteishutsuEntity> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ShujiiIkenshoMiteishutsuReport(List<ShujiiIkenshoMiteishutsuEntity> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoMiteishutsuReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            IShujiiIkenshoMiteishutsuEditor editor = new ShujiiIkenshoMiteishutsuEditor(data.get(i), i);
            IShujiiIkenshoMiteishutsuBuilder builder = new ShujiiIkenshoMiteishutsuBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            ShujiiIkenshoMiteishutsuEntity entity = new ShujiiIkenshoMiteishutsuEntity();
            entity.set保険者名(new RString("該当データがありません"));
            IShujiiIkenshoMiteishutsuEditor editor = new ShujiiIkenshoMiteishutsuEditor(entity, -1);
            IShujiiIkenshoMiteishutsuBuilder builder = new ShujiiIkenshoMiteishutsuBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
