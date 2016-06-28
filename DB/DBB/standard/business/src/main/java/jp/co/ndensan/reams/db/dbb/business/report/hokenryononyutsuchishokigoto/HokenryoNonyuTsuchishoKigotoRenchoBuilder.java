/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【期毎タイプ】HokenryoNonyuTsuchishoKigotoRenchoBuilder
 *
 * @reamsid_L DBB-9110-080 huangh
 */
public class HokenryoNonyuTsuchishoKigotoRenchoBuilder implements IHokenryoNonyuTsuchishoKigotoRenchoBuilder {

    private final IHokenryoNonyuTsuchishoKigotoRenchoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoNonyuTsuchishoKigotoRenchoEditor}
     */
    public HokenryoNonyuTsuchishoKigotoRenchoBuilder(IHokenryoNonyuTsuchishoKigotoRenchoEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuTsuchishoKigotoRenchoSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuTsuchishoKigotoRenchoSource()).join(editor).buildSource();
    }

}
