/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskigoto;

import jp.co.ndensan.reams.db.dbb.entity.db.report.kanendononyutsuchishocvskigoto.KanendoNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【コンビニ期毎タイプ】のBuilder
 *
 */
public class KanendoNonyuTsuchishoCVSKigotoBuilder implements IKanendoNonyuTsuchishoCVSKigotoBuilder {

    private final IKanendoNonyuTsuchishoCVSKigotoEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public KanendoNonyuTsuchishoCVSKigotoBuilder(IKanendoNonyuTsuchishoCVSKigotoEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KanendoNonyuTsuchishoCVSKigotoSource}
     */
    @Override
    public KanendoNonyuTsuchishoCVSKigotoSource build() {
        return ReportEditorJoiner.from(new KanendoNonyuTsuchishoCVSKigotoSource())
                .join(coverEditor).buildSource();
    }

}
