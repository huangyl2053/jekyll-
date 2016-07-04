/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae;

import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeNashiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼なし）通知書 HokenryoNonyuTsuchishoBookFuriKaeNashiBuilder
 *
 * @reamsid_L DBB-9110-160 wangjie2
 */
public class KanendoNonyuTsuchishoBookFuriKaeNashiBuilder implements IKanendoNonyuTsuchishoBookFuriKaeNashiBuilder {

    private final IKanendoNonyuTsuchishoBookFuriKaeNashiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKanendoNonyuTsuchishoBookFuriKaeNashiEditor}
     */
    public KanendoNonyuTsuchishoBookFuriKaeNashiBuilder(IKanendoNonyuTsuchishoBookFuriKaeNashiEditor editor) {
        this.editor = editor;
    }

    @Override
    public KanendoNonyuTsuchishoBookFuriKaeNashiSource build() {
        return ReportEditorJoiner.from(new KanendoNonyuTsuchishoBookFuriKaeNashiSource()).join(editor).buildSource();
    }

}
