/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100058;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100058.TsuchishoFuriKaeNashiRenchoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 口振依頼なし通知書_連帳のReportです。
 */
public class TsuchishoFuriKaeNashiRenchoReport extends Report<TsuchishoFuriKaeNashiRenchoReportSource> {

    private final List<TsuchishoFuriKaeNashiRenchoItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets ITEMリスト
     */
    protected TsuchishoFuriKaeNashiRenchoReport(List<TsuchishoFuriKaeNashiRenchoItem> targets) {
        this.targets = targets;
    }

    /**
     * フォームを生成します。
     *
     * @param items ITEMリスト
     * @return Report
     */
    public static TsuchishoFuriKaeNashiRenchoReport createFrom(@NonNull List<TsuchishoFuriKaeNashiRenchoItem> items) {
        return new TsuchishoFuriKaeNashiRenchoReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<TsuchishoFuriKaeNashiRenchoReportSource> reportSourceWriter) {
        for (TsuchishoFuriKaeNashiRenchoItem item : targets) {
            ITsuchishoFuriKaeNashiRenchoEditor headerEditor = new TsuchishoFuriKaeNashiRenchoHeaderEditor(item);
            ITsuchishoFuriKaeNashiRenchoEditor bodyEditor = new TsuchishoFuriKaeNashiRenchoBodyEditor(item);
            ITsuchishoFuriKaeNashiRenchoBuilder builder = new TsuchishoFuriKaeNashiRenchoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
