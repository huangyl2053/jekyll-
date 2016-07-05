/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【ブックタイプ】（口振依頼あり）通知書_連帳 HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder
 *
 * @reamsid_L DBB-9110-010 huangh
 */
public class HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder implements IHokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder {

    private final IHokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor}
     */
    public HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder(IHokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource()).join(editor).buildSource();
    }

}
