/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulticover;

import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】CoverのBuilder
 *
 */
public class KarisanteiNonyuTsuchishoCVSMultiCoverBuilder implements IKarisanteiNonyuTsuchishoCVSMultiCoverBuilder {

    private final IKarisanteiNonyuTsuchishoCVSMultiCoverEditor coverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param coverEditor coverEditor
     */
    public KarisanteiNonyuTsuchishoCVSMultiCoverBuilder(IKarisanteiNonyuTsuchishoCVSMultiCoverEditor coverEditor) {
        this.coverEditor = coverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KarisanteiNonyuTsuchishoCVSMultiCoverSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSMultiCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSMultiCoverSource())
                .join(coverEditor).buildSource();
    }

}
