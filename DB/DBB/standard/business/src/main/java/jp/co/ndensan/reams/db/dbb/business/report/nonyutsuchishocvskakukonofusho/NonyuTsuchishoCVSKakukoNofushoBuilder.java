/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukonofusho;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】納付書のBuilder
 *
 */
public class NonyuTsuchishoCVSKakukoNofushoBuilder implements INonyuTsuchishoCVSKakukoNofushoBuilder {

    private final INonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor;

    /**
     * インスタンスを生成します。
     *
     * @param nofushoEditor nofushoEditor
     */
    public NonyuTsuchishoCVSKakukoNofushoBuilder(
            INonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor) {

        this.nofushoEditor = nofushoEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSKakukoNofushoSource}
     */
    @Override
    public NonyuTsuchishoCVSKakukoNofushoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSKakukoNofushoSource()).join(nofushoEditor).buildSource();

    }

}
