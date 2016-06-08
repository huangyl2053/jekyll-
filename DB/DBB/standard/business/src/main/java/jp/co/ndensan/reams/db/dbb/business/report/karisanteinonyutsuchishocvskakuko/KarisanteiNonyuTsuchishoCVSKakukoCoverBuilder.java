/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】CoverのBuilder
 *
 * @reamsid_L DBB-9110-060 huangh
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
     * @return {@link KarisanteiNonyuTsuchishoCVSKakukoSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSKakukoSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSKakukoSource())
                .join(coverEditor).buildSource();
    }

}
