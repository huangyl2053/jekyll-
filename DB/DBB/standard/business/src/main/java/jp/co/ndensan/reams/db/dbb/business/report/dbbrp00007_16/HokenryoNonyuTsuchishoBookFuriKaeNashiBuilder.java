/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼なし）通知書 HokenryoNonyuTsuchishoBookFuriKaeNashiBuilder
 */
public class HokenryoNonyuTsuchishoBookFuriKaeNashiBuilder implements IHokenryoNonyuTsuchishoBookFuriKaeNashiBuilder {

    private final IHokenryoNonyuTsuchishoBookFuriKaeNashiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoNonyuTsuchishoBookFuriKaeNashiEditor}
     */
    public HokenryoNonyuTsuchishoBookFuriKaeNashiBuilder(IHokenryoNonyuTsuchishoBookFuriKaeNashiEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource()).join(editor).buildSource();
    }

}
