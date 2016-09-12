/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】CoverのBuilder
 *
 * @reamsid_L DBB-9110-120 huangh
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
     * @return {@link NonyuTsuchishoCVSKakukoSource}
     */
    @Override
    public NonyuTsuchishoCVSKakukoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSKakukoSource())
                .join(coverEditor).buildSource();
    }

}
