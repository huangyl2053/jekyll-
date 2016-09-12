/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohifutanshabun;

import jp.co.ndensan.reams.db.dbc.entity.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200067_介護給付費等請求額通知書（公費負担者分）Builderするクラスです。
 *
 * @reamsid_L DBC-2790-030 lijian
 */
public class SeikyugakuTsuchishoKohifutanshabunBuilder implements
        ISeikyugakuTsuchishoKohifutanshabunBuilder {

    private final ISeikyugakuTsuchishoKohifutanshabunEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor ISeikyugakuTsuchishoKohifutanshabunEditor
     */
    public SeikyugakuTsuchishoKohifutanshabunBuilder(ISeikyugakuTsuchishoKohifutanshabunEditor editor) {
        this.editor = editor;
    }

    @Override
    public SeikyugakuTsuchishoKohifutanshabunSource build() {
        return ReportEditorJoiner.from(new SeikyugakuTsuchishoKohifutanshabunSource()).join(editor).buildSource();
    }
}
