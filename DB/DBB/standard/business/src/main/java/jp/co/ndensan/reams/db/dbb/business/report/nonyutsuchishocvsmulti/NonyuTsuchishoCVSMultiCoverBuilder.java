/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】CoverのBuilder
 *
 * @reamsid_L DBB-9110-110 huangh
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
     * @return {@link NonyuTsuchishoCVSMultiSource}
     */
    @Override
    public NonyuTsuchishoCVSMultiSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSMultiSource())
                .join(coverEditor).buildSource();
    }

}
