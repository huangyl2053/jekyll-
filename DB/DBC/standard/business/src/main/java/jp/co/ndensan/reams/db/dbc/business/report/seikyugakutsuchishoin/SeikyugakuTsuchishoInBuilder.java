/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishoin.SeikyugakuTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護給付費等請求額通知書一覧表帳票Builderクラスです
 *
 * @reamsid_L DBC-2480-030 jiangwenkai
 */
public class SeikyugakuTsuchishoInBuilder implements ISeikyugakuTsuchishoInBuilder {

    private final ISeikyugakuTsuchishoInEditor headerEditor;
    private final ISeikyugakuTsuchishoInEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor ISeikyugakuTsuchishoInEditor
     * @param bodyEditor ISeikyugakuTsuchishoInEditor
     */
    public SeikyugakuTsuchishoInBuilder(
            ISeikyugakuTsuchishoInEditor headerEditor,
            ISeikyugakuTsuchishoInEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SeikyugakuTsuchishoSource build() {
        return ReportEditorJoiner.from(new SeikyugakuTsuchishoSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
