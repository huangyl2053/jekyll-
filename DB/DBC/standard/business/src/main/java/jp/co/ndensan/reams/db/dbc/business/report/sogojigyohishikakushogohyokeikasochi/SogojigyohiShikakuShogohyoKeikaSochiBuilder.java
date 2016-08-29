/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishikakushogohyokeikasochi;

import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohishikakushogohyokeikasochi.SogojigyohiShikakuShogohyoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費（経過措置）資格照合表Builderクラスです。
 *
 * @reamsid_L DBC-2890-031 wangxingpeng
 */
public class SogojigyohiShikakuShogohyoKeikaSochiBuilder
        implements ISogojigyohiShikakuShogohyoKeikaSochiBuilder {

    private final ISogojigyohiShikakuShogohyoKeikaSochiEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor SogojigyohiShikakuShogohyoKeikaSochiEditor
     */
    public SogojigyohiShikakuShogohyoKeikaSochiBuilder(ISogojigyohiShikakuShogohyoKeikaSochiEditor editor) {
        this.editor = editor;
    }

    @Override
    public SogojigyohiShikakuShogohyoKeikaSochiSource build() {
        return ReportEditorJoiner.from(new SogojigyohiShikakuShogohyoKeikaSochiSource())
                .join(editor).buildSource();
    }
}
