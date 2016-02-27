/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】納付書 KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder
 */
public class KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder implements IKarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder {

    private final IKarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor}
     */
    public KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder(IKarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource()).join(editor).buildSource();
    }

}
