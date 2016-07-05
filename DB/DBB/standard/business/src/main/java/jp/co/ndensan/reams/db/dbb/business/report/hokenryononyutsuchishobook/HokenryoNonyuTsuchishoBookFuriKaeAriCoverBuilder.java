/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【ブックタイプ】（口振依頼あり）通知書 HokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder
 *
 * @reamsid_L DBB-9110-010 huangh
 */
public class HokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder implements IHokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder {

    private final IHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor}
     */
    public HokenryoNonyuTsuchishoBookFuriKaeAriCoverBuilder(IHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource()).join(editor).buildSource();
    }

}
