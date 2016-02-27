/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmultirenchocover;

import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】（連帳）CoverのBuilder
 *
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder implements IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder {

    private final IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor;

    /**
     * インスタンスを生成します。
     *
     * @param renchoCoverEditor renchoCoverEditor
     */
    public KarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder(IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor) {
        this.renchoCoverEditor = renchoCoverEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource}
     */
    @Override
    public KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource())
                .join(renchoCoverEditor).buildSource();
    }

}
