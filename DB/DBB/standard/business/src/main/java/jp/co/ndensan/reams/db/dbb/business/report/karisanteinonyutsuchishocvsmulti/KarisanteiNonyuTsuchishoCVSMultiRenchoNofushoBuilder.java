/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti;

import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】RenchoNofushoのBuilder
 *
 * @reamsid_L DBB-9110-050 huangh
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder implements IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder {

    private final IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder(IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KarisanteiNonyuTsuchishoCVSMultiRenchoSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSMultiRenchoSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSMultiRenchoSource())
                .join(coverEditor).buildSource();
    }
}
