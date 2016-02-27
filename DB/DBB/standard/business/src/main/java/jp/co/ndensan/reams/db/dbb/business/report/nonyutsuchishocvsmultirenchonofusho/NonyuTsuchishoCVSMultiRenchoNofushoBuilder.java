/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmultirenchonofusho;

import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】納付書のBuilder
 *
 */
public class NonyuTsuchishoCVSMultiRenchoNofushoBuilder implements INonyuTsuchishoCVSMultiRenchoNofushoBuilder {

    private final INonyuTsuchishoCVSMultiRenchoNofushoEditor nofushoEditor;

    /**
     * インスタンスを生成します。
     *
     * @param nofushoEditor nofushoEditor
     */
    public NonyuTsuchishoCVSMultiRenchoNofushoBuilder(
            INonyuTsuchishoCVSMultiRenchoNofushoEditor nofushoEditor) {

        this.nofushoEditor = nofushoEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NonyuTsuchishoCVSMultiRenchoNofushoSource}
     */
    @Override
    public NonyuTsuchishoCVSMultiRenchoNofushoSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSMultiRenchoNofushoSource()).join(nofushoEditor).buildSource();

    }

}
