/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakukorenchocover;

import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】（連帳）CoverのBuilder
 *
 */
public class KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverBuilder implements IKarisanteiNonyuTsuchishoCVSKakukoRenchoCoverBuilder {

    private final IKarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param renchoCoverEditor renchoCoverEditor
     */
    public KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverBuilder(IKarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor) {
        this.renchoCoverEditor = renchoCoverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverSource())
                .join(renchoCoverEditor).buildSource();
    }

}
