/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 仮算定額変更【B5横タイプ】のReportです。
 */
public class KarisanteiHenkoTsuchishoB5YokoReport extends Report<KarisanteiHenkoTsuchishoB5YokoReportSource> {

    private final List<KarisanteiHenkoTsuchishoB5YokoItem> targets;

    protected KarisanteiHenkoTsuchishoB5YokoReport(List<KarisanteiHenkoTsuchishoB5YokoItem> targets) {
        this.targets = targets;
    }

    /**
     * フォームを生成します。
     *
     * @param items 住基連動登録リストのITEMリスト
     * @return 住基連動登録リストのReport
     */
    public static KarisanteiHenkoTsuchishoB5YokoReport createFrom(@NonNull List<KarisanteiHenkoTsuchishoB5YokoItem> items) {
        return new KarisanteiHenkoTsuchishoB5YokoReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiHenkoTsuchishoB5YokoReportSource> reportSourceWriter) {
        for (KarisanteiHenkoTsuchishoB5YokoItem target : targets) {
            IKarisanteiHenkoTsuchishoB5YokoEditor headerEditor = new KarisanteiHenkoTsuchishoB5YokoHeaderEditor(target);
            IKarisanteiHenkoTsuchishoB5YokoEditor hyojiBodyEditor = new KarisanteiHenkoTsuchishoB5YokoBodyEditor(target);
            IKarisanteiHenkoTsuchishoB5YokoBuilder builder = new KarisanteiHenkoTsuchishoB5YokoBuilderBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
