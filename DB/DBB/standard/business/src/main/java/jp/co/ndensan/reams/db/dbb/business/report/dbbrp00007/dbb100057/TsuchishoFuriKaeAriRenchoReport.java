/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.dbb100057;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.dbb100057.TsuchishoFuriKaeAriRenchoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 口振依頼あり通知書_連帳のReportです。
 */
public class TsuchishoFuriKaeAriRenchoReport extends Report<TsuchishoFuriKaeAriRenchoReportSource> {

    private final List<TsuchishoFuriKaeAriRenchoItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets ITEMリスト
     */
    protected TsuchishoFuriKaeAriRenchoReport(List<TsuchishoFuriKaeAriRenchoItem> targets) {
        this.targets = targets;
    }

    /**
     * フォームを生成します。
     *
     * @param items ITEMリスト
     * @return Report
     */
    public static TsuchishoFuriKaeAriRenchoReport createFrom(@NonNull List<TsuchishoFuriKaeAriRenchoItem> items) {
        return new TsuchishoFuriKaeAriRenchoReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<TsuchishoFuriKaeAriRenchoReportSource> reportSourceWriter) {
        for (TsuchishoFuriKaeAriRenchoItem item : targets) {
            ITsuchishoFuriKaeAriRenchoEditor headerEditor = new TsuchishoFuriKaeAriRenchoHeaderEditor(item);
            ITsuchishoFuriKaeAriRenchoEditor bodyEditor = new TsuchishoFuriKaeAriRenchoBodyEditor(item);
            ITsuchishoFuriKaeAriRenchoBuilder builder = new TsuchishoFuriKaeAriRenchoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
