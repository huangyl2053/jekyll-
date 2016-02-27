/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmultinofusho;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】納付書のBuilder
 *
 */
public class NonyuTsuchishoCVSMultiNofushoBuilder implements INonyuTsuchishoCVSMultiNofushoBuilder {

    private final INonyuTsuchishoCVSMultiNofushoEditor nofushoEditor;

    /**
     * インスタンスを生成します。
     *
     * @param nofushoEditor nofushoEditor
     */
    public NonyuTsuchishoCVSMultiNofushoBuilder(
            INonyuTsuchishoCVSMultiNofushoEditor nofushoEditor) {

        this.nofushoEditor = nofushoEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSMultiNofushoSource}
     */
    @Override
    public NonyuTsuchishoCVSMultiNofushoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSMultiNofushoSource()).join(nofushoEditor).buildSource();

    }

}
