/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiirai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshomiirai.ShujiiIkenshoMiIraiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiirai.ShujiiIkenshoMiIraiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書依頼未処理者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-130 suguangjun
 */
public class ShujiiIkenshoMiIraiReport extends Report<ShujiiIkenshoMiIraiReportSource> {

    private final List<ShujiiIkenshoMiIraiEntity> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ShujiiIkenshoMiIraiReport(List<ShujiiIkenshoMiIraiEntity> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoMiIraiReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            IShujiiIkenshoMiIraiEditor editor = new ShujiiIkenshoMiIraiEditor(data.get(i), i);
            IShujiiIkenshoMiIraiBuilder builder = new ShujiiIkenshoMiIraiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            ShujiiIkenshoMiIraiEntity entity = new ShujiiIkenshoMiIraiEntity();
            entity.set保険者名(new RString("該当データがありません"));
            IShujiiIkenshoMiIraiEditor editor = new ShujiiIkenshoMiIraiEditor(entity, -1);
            IShujiiIkenshoMiIraiBuilder builder = new ShujiiIkenshoMiIraiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
