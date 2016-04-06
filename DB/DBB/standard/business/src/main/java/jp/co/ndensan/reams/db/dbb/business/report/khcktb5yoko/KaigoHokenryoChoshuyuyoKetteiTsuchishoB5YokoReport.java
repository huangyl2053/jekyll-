/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護保険料徴収猶予決定通知書帳票B5横タイプReport
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport extends Report<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> {

    private final List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets List<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoItem>
     */
    protected KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport(List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param targets List<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoItem> targets
     * @return KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport
     */
    public static KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport createForm(
            @NonNull List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets) {
        return new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> writer) {

        for (KaigoHokenryoChoshuyuyoKetteiTsuchishoItem target : targets) {
            ReiyaB5Editor reiyaEditor = new ReiyaB5Editor(target);
            CompNinshoshaB5Editor compNinshoshaEditor = new CompNinshoshaB5Editor(target);
            CompKaigoToiawasesakiB5Editor compKaigoToiawasesakiEditor = new CompKaigoToiawasesakiB5Editor(target);
            CompSofubutsuAtesakiB5Editor compSofubutsuAtesakiEditor = new CompSofubutsuAtesakiB5Editor(target);
            IKaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoBuider builder
                    = new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoBuider(
                            reiyaEditor, compNinshoshaEditor, compKaigoToiawasesakiEditor, compSofubutsuAtesakiEditor);
            writer.writeLine(builder);
        }
    }

}
