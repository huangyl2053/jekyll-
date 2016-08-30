/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyoshikakushogohyoin;

import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費資格照合表Builder
 *
 * @reamsid_L DBC-2890-032 wangxue
 */
public class SogojigyohiShikakuShogohyoBuilder implements ISogojigyohiShikakuShogohyoBuilder {

    private final ISogojigyohiShikakuShogohyoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor ISogojigyohiShikakuShogohyoEditor
     */
    public SogojigyohiShikakuShogohyoBuilder(ISogojigyohiShikakuShogohyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public SogojigyohiShikakuShogohyoInSource build() {
        return ReportEditorJoiner.from(new SogojigyohiShikakuShogohyoInSource()).
                join(editor).
                buildSource();
    }

}
