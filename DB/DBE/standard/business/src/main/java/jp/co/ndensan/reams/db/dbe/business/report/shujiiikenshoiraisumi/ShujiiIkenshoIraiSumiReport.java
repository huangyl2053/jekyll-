/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoiraisumi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoiraisumi.ShujiiIkenshoIraiSumiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoiraisumi.ShujiiIkenshoIraiSumiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書依頼済み一覧表のReportです。
 *
 * @reamsid_L DBE-1390-160 suguangjun
 */
public class ShujiiIkenshoIraiSumiReport extends Report<ShujiiIkenshoIraiSumiReportSource> {

    private final List<ShujiiIkenshoIraiSumiEntity> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ShujiiIkenshoIraiSumiReport(List<ShujiiIkenshoIraiSumiEntity> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoIraiSumiReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            IShujiiIkenshoIraiSumiEditor editor = new ShujiiIkenshoIraiSumiEditor(data.get(i), i);
            IShujiiIkenshoIraiSumiBuilder builder = new ShujiiIkenshoIraiSumiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            ShujiiIkenshoIraiSumiEntity entity = new ShujiiIkenshoIraiSumiEntity();
            entity.set氏名(new RString("該当データがありません"));
            IShujiiIkenshoIraiSumiEditor editor = new ShujiiIkenshoIraiSumiEditor(entity, -1);
            IShujiiIkenshoIraiSumiBuilder builder = new ShujiiIkenshoIraiSumiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
