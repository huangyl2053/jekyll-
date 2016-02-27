/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmultirenchocover;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】（連帳）CoverのBuilder
 *
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
     * @return {@link NonyuTsuchishoCVSMultiRenchoCoverSource}
     */
    @Override
    public NonyuTsuchishoCVSMultiRenchoCoverSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSMultiRenchoCoverSource())
                .join(renchoCoverEditor).buildSource();
    }

}
