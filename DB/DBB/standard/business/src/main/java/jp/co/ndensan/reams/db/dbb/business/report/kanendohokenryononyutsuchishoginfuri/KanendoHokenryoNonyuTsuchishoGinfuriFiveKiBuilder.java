/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_5期 HokenryoNonyuTsuchishoGinfuriFiveKiBuilder
 *
 * @reamsid_L DBB-9110-150 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoGinfuriFiveKiBuilder implements IKanendoHokenryoNonyuTsuchishoGinfuriFiveKiBuilder {

    private final IKanendoHokenryoNonyuTsuchishoGinfuriFiveKiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKanendoHokenryoNonyuTsuchishoGinfuriFiveKiEditor}
     */
    public KanendoHokenryoNonyuTsuchishoGinfuriFiveKiBuilder(IKanendoHokenryoNonyuTsuchishoGinfuriFiveKiEditor editor) {
        this.editor = editor;
    }

    @Override
    public KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource build() {
        return ReportEditorJoiner.from(new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource()).join(editor).buildSource();
    }

}
