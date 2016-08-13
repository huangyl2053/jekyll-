/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokohi;

import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費等請求額通知書（公費負担者分）帳票Builder
 *
 * @reamsid_L DBC-4700-040 zhangyaru
 */
public class SogojigyohiSeikyugakuTsuchishoKohiBuilder implements ISogojigyohiSeikyugakuTsuchishoKohiBuilder {

    private final ISogojigyohiSeikyugakuTsuchishoKohiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ISogojigyohiSeikyugakuTsuchishoKohiEditor}
     */
    public SogojigyohiSeikyugakuTsuchishoKohiBuilder(ISogojigyohiSeikyugakuTsuchishoKohiEditor editor) {
        this.editor = editor;
    }

    @Override
    public SogojigyohiSeikyugakuTsuchishoKohiSource build() {
        return ReportEditorJoiner.from(new SogojigyohiSeikyugakuTsuchishoKohiSource())
                .join(editor).buildSource();
    }
}
