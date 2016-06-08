/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shijiiikenshoiraihenko;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shijiiikenshoiraihen.ShijiiIkenshoIraiHenko;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shijiiikenshoiraihenko.ShijiiIkenshoIraiHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成依頼変更者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-140 suguangjun
 */
public class ShijiiIkenshoIraiHenkoReport extends Report<ShijiiIkenshoIraiHenkoReportSource> {

    private final List<ShijiiIkenshoIraiHenko> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ShijiiIkenshoIraiHenkoReport(List<ShijiiIkenshoIraiHenko> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShijiiIkenshoIraiHenkoReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            IShijiiIkenshoIraiHenkoEditor editor = new ShijiiIkenshoIraiHenkoEditor(data.get(i), i);
            IShijiiIkenshoIraiHenkoBuilder builder = new ShijiiIkenshoIraiHenkoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            ShijiiIkenshoIraiHenko entity = new ShijiiIkenshoIraiHenko();
            entity.set氏名(new RString("該当データがありません"));
            IShijiiIkenshoIraiHenkoEditor editor = new ShijiiIkenshoIraiHenkoEditor(entity, -1);
            IShijiiIkenshoIraiHenkoBuilder builder = new ShijiiIkenshoIraiHenkoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
