/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae;

import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeAriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書 NonyuTsuchishoBookFuriKaeAriCoverBuilder
 *
 * @reamsid_L DBB-9110-160 wangjie2
 */
public class KanendoNonyuTsuchishoBookFuriKaeAriBuilder implements IKanendoNonyuTsuchishoBookFuriKaeAriBuilder {

    private final IKanendoNonyuTsuchishoBookFuriKaeAriEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKanendoNonyuTsuchishoBookFuriKaeAriEditor}
     */
    public KanendoNonyuTsuchishoBookFuriKaeAriBuilder(IKanendoNonyuTsuchishoBookFuriKaeAriEditor editor) {
        this.editor = editor;
    }

    @Override
    public KanendoNonyuTsuchishoBookFuriKaeAriSource build() {
        return ReportEditorJoiner.from(new KanendoNonyuTsuchishoBookFuriKaeAriSource()).join(editor).buildSource();
    }

}
