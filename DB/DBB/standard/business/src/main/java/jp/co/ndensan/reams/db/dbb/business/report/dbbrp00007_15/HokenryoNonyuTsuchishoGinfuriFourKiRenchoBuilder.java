/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_15;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_15.HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_4期_連帳 HokenryoNonyuTsuchishoGinfuriFourKiRenchoBuilder
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiRenchoBuilder implements IHokenryoNonyuTsuchishoGinfuriFourKiRenchoBuilder {

    private final IHokenryoNonyuTsuchishoGinfuriFourKiRenchoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoNonyuTsuchishoGinfuriFourKiRenchoEditor}
     */
    public HokenryoNonyuTsuchishoGinfuriFourKiRenchoBuilder(IHokenryoNonyuTsuchishoGinfuriFourKiRenchoEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource()).join(editor).buildSource();
    }

}
