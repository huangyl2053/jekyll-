/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100075;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100075.KanendoNonyuTsuchishoCVSMultiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ通知書】のReportです。
 */
public class KanendoNonyuTsuchishoCVSMultiReport extends Report<KanendoNonyuTsuchishoCVSMultiReportSource> {

    private final List<KanendoNonyuTsuchishoCVSMultiItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets ITEMリスト
     */
    protected KanendoNonyuTsuchishoCVSMultiReport(List<KanendoNonyuTsuchishoCVSMultiItem> targets) {
        this.targets = targets;
    }

    /**
     * フォームを生成します。
     *
     * @param items ITEMリスト
     * @return Report
     */
    public static KanendoNonyuTsuchishoCVSMultiReport createFrom(@NonNull List<KanendoNonyuTsuchishoCVSMultiItem> items) {
        return new KanendoNonyuTsuchishoCVSMultiReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<KanendoNonyuTsuchishoCVSMultiReportSource> reportSourceWriter) {
        for (KanendoNonyuTsuchishoCVSMultiItem item : targets) {
            IKanendoNonyuTsuchishoCVSMultiEditor headerEditor = new KanendoNonyuTsuchishoCVSMultiHeaderEditor(item);
            IKanendoNonyuTsuchishoCVSMultiEditor bodyEditor = new KanendoNonyuTsuchishoCVSMultiBodyEditor(item);
            IKanendoNonyuTsuchishoCVSMultiBuilder builder = new KanendoNonyuTsuchishoCVSMultiBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
