/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskigoto;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニ期毎タイプ】のBuilder
 *
 */
public class NonyuTsuchishoCVSKigotoBuilder implements INonyuTsuchishoCVSKigotoBuilder {

    private final INonyuTsuchishoCVSKigotoEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public NonyuTsuchishoCVSKigotoBuilder(INonyuTsuchishoCVSKigotoEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSKigotoSource}
     */
    @Override
    public NonyuTsuchishoCVSKigotoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSKigotoSource())
                .join(coverEditor).buildSource();
    }

}
