/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100056;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100056.TsuchishoFuriKaeNashiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 口振依頼なし通知書のReportです。
 */
public class TsuchishoFuriKaeNashiReport extends Report<TsuchishoFuriKaeNashiReportSource> {

    private final List<TsuchishoFuriKaeNashiItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets ITEMリスト
     */
    protected TsuchishoFuriKaeNashiReport(List<TsuchishoFuriKaeNashiItem> targets) {
        this.targets = targets;
    }

    /**
     * フォームを生成します。
     *
     * @param items 住基連動登録リストのITEMリスト
     * @return 住基連動登録リストのReport
     */
    public static TsuchishoFuriKaeNashiReport createFrom(@NonNull List<TsuchishoFuriKaeNashiItem> items) {
        return new TsuchishoFuriKaeNashiReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<TsuchishoFuriKaeNashiReportSource> reportSourceWriter) {
        for (TsuchishoFuriKaeNashiItem item : targets) {
            ITsuchishoFuriKaeNashiEditor headerEditor = new TsuchishoFuriKaeNashiHeaderEditor(item);
            ITsuchishoFuriKaeNashiEditor bodyEditor = new TsuchishoFuriKaeNashiBodyEditor(item);
            ITsuchishoFuriKaeNashiBuilder builder = new TsuchishoFuriKaeNashiBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
