/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100055;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100055.TsuchishoFuriKaeAriReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 口振依頼あり通知書のReportです。
 */
public class TsuchishoFuriKaeAriReport extends Report<TsuchishoFuriKaeAriReportSource> {

    private final List<TsuchishoFuriKaeAriItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets ITEMリスト
     */
    protected TsuchishoFuriKaeAriReport(List<TsuchishoFuriKaeAriItem> targets) {
        this.targets = targets;
    }

    /**
     * フォームを生成します。
     *
     * @param items ITEMリスト
     * @return Report
     */
    public static TsuchishoFuriKaeAriReport createFrom(@NonNull List<TsuchishoFuriKaeAriItem> items) {
        return new TsuchishoFuriKaeAriReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<TsuchishoFuriKaeAriReportSource> reportSourceWriter) {
        for (TsuchishoFuriKaeAriItem item : targets) {
            ITsuchishoFuriKaeAriEditor headerEditor = new TsuchishoFuriKaeAriHeaderEditor(item);
            ITsuchishoFuriKaeAriEditor bodyEditor = new TsuchishoFuriKaeAriBodyEditor(item);
            ITsuchishoFuriKaeAriBuilder builder = new TsuchishoFuriKaeAriBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
