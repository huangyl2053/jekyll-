/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼あり）通知書 KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder
        implements IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder {

    private final IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor}
     */
    public KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder(IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource()).join(editor).buildSource();
    }

}
