/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（本算定）【期毎タイプ】HokenryoNonyuTsuchishoKigotoBuilder
 */
public class HokenryoNonyuTsuchishoKigotoBuilder implements IHokenryoNonyuTsuchishoKigotoBuilder {

    private final IHokenryoNonyuTsuchishoKigotoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHokenryoNonyuTsuchishoKigotoEditor}
     */
    public HokenryoNonyuTsuchishoKigotoBuilder(IHokenryoNonyuTsuchishoKigotoEditor editor) {
        this.editor = editor;
    }

    @Override
    public HokenryoNonyuTsuchishoKigotoSource build() {
        return ReportEditorJoiner.from(new HokenryoNonyuTsuchishoKigotoSource()).join(editor).buildSource();
    }

}
