/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料徴収猶予決定通知書B5横タイプ帳票Buider
 *
 * @reamsid_L DBC-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoBuider
        implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoBuider {

    private final ReiyaB5Editor reiyaEditor;
    private final CompNinshoshaB5Editor compNinshoshaEditor;
    private final CompKaigoToiawasesakiB5Editor compKaigoToiawasesakiEditor;
    private final CompSofubutsuAtesakiB5Editor compSofubutsuAtesakiEditor;

    /**
     * インスタンスを生成します。
     *
     * @param reiyaEditor ReiyaEditor
     * @param compNinshoshaEditor CompNinshoshaEditor
     * @param compKaigoToiawasesakiEditor CompKaigoToiawasesakiEditor
     * @param compSofubutsuAtesakiEditor CompSofubutsuAtesakiEditor
     */
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoBuider(
            ReiyaB5Editor reiyaEditor,
            CompNinshoshaB5Editor compNinshoshaEditor,
            CompKaigoToiawasesakiB5Editor compKaigoToiawasesakiEditor,
            CompSofubutsuAtesakiB5Editor compSofubutsuAtesakiEditor) {
        this.reiyaEditor = reiyaEditor;
        this.compNinshoshaEditor = compNinshoshaEditor;
        this.compKaigoToiawasesakiEditor = compKaigoToiawasesakiEditor;
        this.compSofubutsuAtesakiEditor = compSofubutsuAtesakiEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource}
     */
    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource build() {
        return ReportEditorJoiner.from(new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource())
                .join(reiyaEditor).join(compNinshoshaEditor).join(compKaigoToiawasesakiEditor)
                .join(compSofubutsuAtesakiEditor).buildSource();
    }

}
