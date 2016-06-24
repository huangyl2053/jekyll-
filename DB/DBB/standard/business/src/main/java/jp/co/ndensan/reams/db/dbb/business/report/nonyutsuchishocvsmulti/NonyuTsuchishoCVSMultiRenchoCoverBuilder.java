/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】（連帳）CoverのBuilder
 *
 * @reamsid_L DBB-9110-110 huangh
 */
public class NonyuTsuchishoCVSMultiRenchoCoverBuilder implements INonyuTsuchishoCVSMultiRenchoCoverBuilder {

    private final INonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param renchoCoverEditor renchoCoverEditor
     */
    public NonyuTsuchishoCVSMultiRenchoCoverBuilder(INonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor) {
        this.renchoCoverEditor = renchoCoverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSMultiRenchoSource}
     */
    @Override
    public NonyuTsuchishoCVSMultiRenchoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSMultiRenchoSource())
                .join(renchoCoverEditor).buildSource();
    }

}
