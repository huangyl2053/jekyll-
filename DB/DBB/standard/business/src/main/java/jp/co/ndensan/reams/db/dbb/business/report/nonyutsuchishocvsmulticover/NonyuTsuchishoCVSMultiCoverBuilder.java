/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulticover;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】CoverのBuilder
 *
 */
public class NonyuTsuchishoCVSMultiCoverBuilder implements INonyuTsuchishoCVSMultiCoverBuilder {

    private final INonyuTsuchishoCVSMultiCoverEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public NonyuTsuchishoCVSMultiCoverBuilder(INonyuTsuchishoCVSMultiCoverEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSMultiCoverSource}
     */
    @Override
    public NonyuTsuchishoCVSMultiCoverSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSMultiCoverSource())
                .join(coverEditor).buildSource();
    }

}
