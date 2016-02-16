/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100013;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別徴収平準化【A4縦タイプ】のReportです。
 */
public class KarisanteiHenjunkaHenkoTsuchishoA4TateReport extends Report<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> {

    private final List<KarisanteiHenjunkaHenkoTsuchishoA4TateItem> targets;

    public KarisanteiHenjunkaHenkoTsuchishoA4TateReport(List<KarisanteiHenjunkaHenkoTsuchishoA4TateItem> targets) {
        this.targets = targets;

    }
        /**
     * インスタンスを生成します。
     *
     * @param items
     * @return
     */
    public static KarisanteiHenjunkaHenkoTsuchishoA4TateReport createFrom(@NonNull List<KarisanteiHenjunkaHenkoTsuchishoA4TateItem> items) {
        return new KarisanteiHenjunkaHenkoTsuchishoA4TateReport(items);
    }

    @Override
    protected void writeBy(ReportSourceWriter<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> reportSourceWriter) {
      for (KarisanteiHenjunkaHenkoTsuchishoA4TateItem target: targets){
      IKarisanteiHenjunkaHenkoTsuchishoA4TateEditor headerEditor = new KarisanteiHenjunkaHenkoTsuchishoA4TateHeaderEditor(target);
      IKarisanteiHenjunkaHenkoTsuchishoA4TateEditor hyojiBodyEditor = new KarisanteiHenjunkaHenkoTsuchishoA4TateBodyEditor(target);
      IKarisanteiHenjunkaHenkoTsuchishoA4TateBuilder builder = new KarisanteiHenjunkaHenkoTsuchishoA4TateBuiderImpl(headerEditor,hyojiBodyEditor);
      reportSourceWriter.writeLine(builder);
      
      }
    }

}
