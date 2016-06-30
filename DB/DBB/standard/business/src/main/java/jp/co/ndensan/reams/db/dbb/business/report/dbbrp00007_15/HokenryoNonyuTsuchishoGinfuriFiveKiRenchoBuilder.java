/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_15;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_15.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_5期_連帳 HokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder
 *
 * @reamsid_L DBB-9110-150 wangjie2
 */
public class HokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder implements IHokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder {

    private final IHokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor}
     */
    public HokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder(IHokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource()).join(editor).buildSource();
    }

}
