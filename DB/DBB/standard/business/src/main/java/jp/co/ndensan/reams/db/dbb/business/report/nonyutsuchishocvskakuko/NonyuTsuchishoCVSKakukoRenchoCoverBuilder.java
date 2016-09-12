/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】（連帳）CoverのBuilder
 *
 * @reamsid_L DBB-9110-120 huangh
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
     * @return {@link NonyuTsuchishoCVSKakukoRenchoSource}
     */
    @Override
    public NonyuTsuchishoCVSKakukoRenchoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSKakukoRenchoSource())
                .join(renchoCoverEditor).buildSource();
    }

}
