/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakukorenchonofusho;

import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書のBuilder
 *
 */
public class KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoBuilder implements IKarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoBuilder {

    private final IKarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoEditor nofushoEditor;

    /**
     * インスタンスを生成します。
     *
     * @param nofushoEditor nofushoEditor
     */
    public KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoBuilder(
            IKarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoEditor nofushoEditor) {

        this.nofushoEditor = nofushoEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource()).join(nofushoEditor).buildSource();

    }

}
