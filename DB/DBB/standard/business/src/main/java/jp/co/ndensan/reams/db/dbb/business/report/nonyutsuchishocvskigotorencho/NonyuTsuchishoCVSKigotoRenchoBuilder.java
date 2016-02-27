/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskigotorencho;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニ期毎タイプ】連帳のBuilder
 *
 */
public class NonyuTsuchishoCVSKigotoRenchoBuilder implements INonyuTsuchishoCVSKigotoRenchoBuilder {

    private final INonyuTsuchishoCVSKigotoRenchoEditor nofushoEditor;

    /**
     * インスタンスを生成します。
     *
     * @param nofushoEditor nofushoEditor
     */
    public NonyuTsuchishoCVSKigotoRenchoBuilder(
            INonyuTsuchishoCVSKigotoRenchoEditor nofushoEditor) {

        this.nofushoEditor = nofushoEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSKigotoRenchoSource}
     */
    @Override
    public NonyuTsuchishoCVSKigotoRenchoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSKigotoRenchoSource()).join(nofushoEditor).buildSource();

    }

}
