/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100012;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別徴収平準化【B5横タイプ】のReportです。
 */
public class KarisanteiHenjunkaHenkoTsuchishoB5YokoReport extends Report<KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource> {

    private final List<KarisanteiHenjunkaHenkoTsuchishoB5YokoItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets ITEMリスト
     */
    protected KarisanteiHenjunkaHenkoTsuchishoB5YokoReport(List<KarisanteiHenjunkaHenkoTsuchishoB5YokoItem> targets) {
        this.targets = targets;
    }

    /**
     * インスタンスを生成します。
     *
     * @param items ITEMリスト
     * @return Report
     */
    public static KarisanteiHenjunkaHenkoTsuchishoB5YokoReport createFrom(@NonNull List<KarisanteiHenjunkaHenkoTsuchishoB5YokoItem> items) {
        return new KarisanteiHenjunkaHenkoTsuchishoB5YokoReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource> reportSourceWriter) {
        for (KarisanteiHenjunkaHenkoTsuchishoB5YokoItem target : targets) {
            IKarisanteiHenjunkaHenkoTsuchishoB5YokoEditor headerEditor = new KarisanteiHenjunkaHenkoTsuchishoB5YokoHeaderEditor(target);
            IKarisanteiHenjunkaHenkoTsuchishoB5YokoEditor hyojiBodyEditor = new KarisanteiHenjunkaHenkoTsuchishoB5YokoBodyEditor(target);
            IKarisanteiHenjunkaHenkoTsuchishoB5YokoBuilder builder
                    = new KarisanteiHenjunkaHenkoTsuchishoB5YokoBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);
        }

    }

}
