/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchonofusho;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】納付書のBuilder
 *
 */
public class NonyuTsuchishoCVSKakukoRenchoNofushoBuilder implements INonyuTsuchishoCVSKakukoRenchoNofushoBuilder {

    private final INonyuTsuchishoCVSKakukoRenchoNofushoEditor nofushoEditor;

    /**
     * インスタンスを生成します。
     *
     * @param nofushoEditor nofushoEditor
     */
    public NonyuTsuchishoCVSKakukoRenchoNofushoBuilder(
            INonyuTsuchishoCVSKakukoRenchoNofushoEditor nofushoEditor) {

        this.nofushoEditor = nofushoEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSKakukoRenchoNofushoSource}
     */
    @Override
    public NonyuTsuchishoCVSKakukoRenchoNofushoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSKakukoRenchoNofushoSource()).join(nofushoEditor).buildSource();

    }

}
