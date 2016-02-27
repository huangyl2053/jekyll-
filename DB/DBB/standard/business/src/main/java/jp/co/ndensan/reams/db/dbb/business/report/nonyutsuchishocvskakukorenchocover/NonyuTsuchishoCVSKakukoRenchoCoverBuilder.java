/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchocover;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】（連帳）CoverのBuilder
 *
 */
public class NonyuTsuchishoCVSKakukoRenchoCoverBuilder implements INonyuTsuchishoCVSKakukoRenchoCoverBuilder {

    private final INonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param renchoCoverEditor renchoCoverEditor
     */
    public NonyuTsuchishoCVSKakukoRenchoCoverBuilder(INonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor) {
        this.renchoCoverEditor = renchoCoverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSKakukoRenchoCoverSource}
     */
    @Override
    public NonyuTsuchishoCVSKakukoRenchoCoverSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSKakukoRenchoCoverSource())
                .join(renchoCoverEditor).buildSource();
    }

}
