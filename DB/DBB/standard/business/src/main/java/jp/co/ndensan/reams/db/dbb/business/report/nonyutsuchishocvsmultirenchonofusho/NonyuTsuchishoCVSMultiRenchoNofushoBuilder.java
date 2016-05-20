/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmultirenchonofusho;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】納付書のBuilder
 *
 * @reamsid_L DBB-9110-110 huangh
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
     * @return {@link NonyuTsuchishoCVSMultiSource}
     */
    @Override
    public NonyuTsuchishoCVSMultiSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoCVSMultiSource()).join(nofushoEditor).buildSource();

    }

}
