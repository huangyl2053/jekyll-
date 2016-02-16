/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 仮算定額変更【A4縦タイプ】のReportです。
 */
public class KarisanteiHenkoTsuchishoA4TateReport extends Report<KarisanteiHenkoTsuchishoA4TateReportSource> {

    private final List<KarisanteiHenkoTsuchishoA4TateItem> targets;

    public KarisanteiHenkoTsuchishoA4TateReport(List<KarisanteiHenkoTsuchishoA4TateItem> targets) {
        this.targets = targets;
    }

    /**
     * フォームを生成します。
     *
     * @param items 住基連動登録リストのITEMリスト
     * @return 住基連動登録リストのReport
     */
    public static KarisanteiHenkoTsuchishoA4TateReport createFrom(@NonNull List<KarisanteiHenkoTsuchishoA4TateItem> items) {
        return new KarisanteiHenkoTsuchishoA4TateReport(items);
    }

    @Override
    protected void writeBy(ReportSourceWriter<KarisanteiHenkoTsuchishoA4TateReportSource> reportSourceWriter) {
        for (KarisanteiHenkoTsuchishoA4TateItem target : targets) {
            IKarisanteiHenkoTsuchishoA4TateEditor headerEditor = new KarisanteiHenkoTsuchishoA4TateHeaderEditor(target);
            IKarisanteiHenkoTsuchishoA4TateEditor hyoujiBodyEditor = new KarisanteiHenkoTsuchishoA4TateBodyEditor(target);
            IKarisanteiHenkoTsuchishoA4TateBuilder builder = new KarisanteiHenkoTsuchishoA4TateBuilderImpl(headerEditor, hyoujiBodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
