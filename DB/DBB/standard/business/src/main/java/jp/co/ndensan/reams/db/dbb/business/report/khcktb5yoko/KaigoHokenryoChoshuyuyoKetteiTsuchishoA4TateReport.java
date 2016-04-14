/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護保険料徴収猶予決定通知書帳票A4縦タイプReport
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport
        extends Report<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> {

    private final List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem>
     */
    protected KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport(List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param targets List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets
     * @return KaigoHokenryoChoshuyuyoKetteiTsuchishoA4YokoReport
     */
    public static KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport createForm(
            @NonNull List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets) {
        return new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> writer) {

        for (KaigoHokenryoChoshuyuyoKetteiTsuchishoItem target : targets) {
            ReiyaA4Editor reiyaA4Editor = new ReiyaA4Editor(target);
            CompNinshoshaA4Editor compNinshoshaA4Editor = new CompNinshoshaA4Editor(target);
            CompKaigoToiawasesakiA4Editor compKaigoToiawasesakiA4Editor = new CompKaigoToiawasesakiA4Editor(target);
            CompSofubutsuAtesakiA4Editor compSofubutsuAtesakiA4Editor = new CompSofubutsuAtesakiA4Editor(target);
            IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider builder
                    = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider(
                            reiyaA4Editor, compNinshoshaA4Editor, compKaigoToiawasesakiA4Editor, compSofubutsuAtesakiA4Editor);
            writer.writeLine(builder);
        }
    }

}
