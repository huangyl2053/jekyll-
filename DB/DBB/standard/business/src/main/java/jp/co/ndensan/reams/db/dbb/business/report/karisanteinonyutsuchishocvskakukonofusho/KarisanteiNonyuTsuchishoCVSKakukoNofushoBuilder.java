/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakukonofusho;

import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書のBuilder
 *
 */
public class KarisanteiNonyuTsuchishoCVSKakukoNofushoBuilder implements IKarisanteiNonyuTsuchishoCVSKakukoNofushoBuilder {

    private final IKarisanteiNonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor;

    /**
     * インスタンスを生成します。
     *
     * @param nofushoEditor nofushoEditor
     */
    public KarisanteiNonyuTsuchishoCVSKakukoNofushoBuilder(
            IKarisanteiNonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor) {

        this.nofushoEditor = nofushoEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KarisanteiNonyuTsuchishoCVSKakukoNofushoSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSKakukoNofushoSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSKakukoNofushoSource()).join(nofushoEditor).buildSource();

    }

}
