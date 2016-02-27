/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukocover;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】CoverのBuilder
 *
 */
public class NonyuTsuchishoCVSKakukoCoverBuilder implements INonyuTsuchishoCVSKakukoCoverBuilder {

    private final INonyuTsuchishoCVSKakukoCoverEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public NonyuTsuchishoCVSKakukoCoverBuilder(INonyuTsuchishoCVSKakukoCoverEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSKakukoCoverSource}
     */
    @Override
    public NonyuTsuchishoCVSKakukoCoverSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSKakukoCoverSource())
                .join(coverEditor).buildSource();
    }

}
