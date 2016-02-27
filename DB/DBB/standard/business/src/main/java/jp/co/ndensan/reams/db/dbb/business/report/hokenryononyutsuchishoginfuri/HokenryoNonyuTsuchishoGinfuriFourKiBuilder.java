/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_4期 HokenryoNonyuTsuchishoGinfuriFourKiBuilder
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiBuilder implements IHokenryoNonyuTsuchishoGinfuriFourKiBuilder {

    private final IHokenryoNonyuTsuchishoGinfuriFourKiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoNonyuTsuchishoGinfuriFourKiEditor}
     */
    public HokenryoNonyuTsuchishoGinfuriFourKiBuilder(IHokenryoNonyuTsuchishoGinfuriFourKiEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuTsuchishoGinfuriFourKiSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuTsuchishoGinfuriFourKiSource()).join(editor).buildSource();
    }

}
