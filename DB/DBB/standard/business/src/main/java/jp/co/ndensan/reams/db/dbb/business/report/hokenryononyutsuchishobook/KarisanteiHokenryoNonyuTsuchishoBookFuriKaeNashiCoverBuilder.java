/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼なし）通知書 KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder
        implements IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder {

    private final IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor}
     */
    public KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverBuilder(IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource()).join(editor).buildSource();
    }

}
