/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼なし）通知書_連帳 KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder
 */
public class KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder
        implements IKarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder {

    private final IKarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor}
     */
    public KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverBuilder(IKarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverEditor editor) {
        this.editor = editor;
    }

    @Override
    public KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource build() {
        return ReportEditorJoiner.from(new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource()).join(editor).buildSource();
    }

}
