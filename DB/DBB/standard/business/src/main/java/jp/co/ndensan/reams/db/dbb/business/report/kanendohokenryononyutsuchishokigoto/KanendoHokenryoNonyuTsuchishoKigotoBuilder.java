/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishokigoto.KanendoHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【期毎タイプ】HokenryoNonyuTsuchishoKigotoBuilder
 *
 * @reamsid_L DBB-9110-140 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoKigotoBuilder implements IKanendoHokenryoNonyuTsuchishoKigotoBuilder {

    private final IKanendoHokenryoNonyuTsuchishoKigotoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKanendoHokenryoNonyuTsuchishoKigotoEditor}
     */
    public KanendoHokenryoNonyuTsuchishoKigotoBuilder(IKanendoHokenryoNonyuTsuchishoKigotoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KanendoHokenryoNonyuTsuchishoKigotoSource build() {
        return ReportEditorJoiner.from(new KanendoHokenryoNonyuTsuchishoKigotoSource()).join(editor).buildSource();
    }

}
