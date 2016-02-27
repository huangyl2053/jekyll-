/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskakuko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.kanendononyutsuchishocvskakuko.KanendoNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】のBuilder
 *
 */
public class KanendoNonyuTsuchishoCVSKakukoBuilder implements IKanendoNonyuTsuchishoCVSKakukoBuilder {

    private final IKanendoNonyuTsuchishoCVSKakukoEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public KanendoNonyuTsuchishoCVSKakukoBuilder(IKanendoNonyuTsuchishoCVSKakukoEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KanendoNonyuTsuchishoCVSKakukoSource}
     */
    @Override
    public KanendoNonyuTsuchishoCVSKakukoSource build() {
        return ReportEditorJoiner.from(new KanendoNonyuTsuchishoCVSKakukoSource())
                .join(coverEditor).buildSource();
    }

}
