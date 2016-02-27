/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmultirenchonofusho;

import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】納付書のBuilder
 *
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder implements IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder {

    private final IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoEditor nofushoEditor;

    /**
     * インスタンスを生成します。
     *
     * @param nofushoEditor nofushoEditor
     */
    public KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder(
            IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoEditor nofushoEditor) {

        this.nofushoEditor = nofushoEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoSource()).join(nofushoEditor).buildSource();

    }

}
