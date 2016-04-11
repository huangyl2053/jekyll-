/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプ帳票Buider。
 *
 * @reamsid_L DBC-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider
        implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider {

    private final ReiyaA4Editor reiyaEditor;
    private final CompNinshoshaA4Editor compNinshoshaEditor;
    private final CompKaigoToiawasesakiA4Editor compKaigoToiawasesakiEditor;
    private final CompSofubutsuAtesakiA4Editor compSofubutsuAtesakiEditor;

    /**
     * インスタンスを生成します。
     *
     * @param reiyaEditor ReiyaEditor
     * @param compNinshoshaEditor CompNinshoshaEditor
     * @param compKaigoToiawasesakiEditor CompKaigoToiawasesakiEditor
     * @param compSofubutsuAtesakiEditor CompSofubutsuAtesakiEditor
     */
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider(
            ReiyaA4Editor reiyaEditor,
            CompNinshoshaA4Editor compNinshoshaEditor,
            CompKaigoToiawasesakiA4Editor compKaigoToiawasesakiEditor,
            CompSofubutsuAtesakiA4Editor compSofubutsuAtesakiEditor) {
        this.reiyaEditor = reiyaEditor;
        this.compNinshoshaEditor = compNinshoshaEditor;
        this.compKaigoToiawasesakiEditor = compKaigoToiawasesakiEditor;
        this.compSofubutsuAtesakiEditor = compSofubutsuAtesakiEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource}
     */
    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource build() {
        return ReportEditorJoiner.from(new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource())
                .join(reiyaEditor).join(compNinshoshaEditor).join(compKaigoToiawasesakiEditor)
                .join(compSofubutsuAtesakiEditor).buildSource();
    }

}
