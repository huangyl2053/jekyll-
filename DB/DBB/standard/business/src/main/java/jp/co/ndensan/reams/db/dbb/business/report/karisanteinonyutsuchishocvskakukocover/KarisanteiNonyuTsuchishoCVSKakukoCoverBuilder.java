/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakukocover;

import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】CoverのBuilder
 *
 */
public class KarisanteiNonyuTsuchishoCVSKakukoCoverBuilder implements IKarisanteiNonyuTsuchishoCVSKakukoCoverBuilder {

    private final IKarisanteiNonyuTsuchishoCVSKakukoCoverEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public KarisanteiNonyuTsuchishoCVSKakukoCoverBuilder(IKarisanteiNonyuTsuchishoCVSKakukoCoverEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KarisanteiNonyuTsuchishoCVSKakukoCoverSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSKakukoCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSKakukoCoverSource())
                .join(coverEditor).buildSource();
    }

}
