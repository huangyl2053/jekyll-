/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiSeikyugakuTsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120890.SogojigyohiSeikyugakuTsuchishoInSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費等請求額通知書帳票Builder
 *
 * @reamsid_L DBC-2480-032 sunqingzhu
 */
public class SogojigyohiSeikyugakuTsuchishoInBuilder implements ISogojigyohiSeikyugakuTsuchishoInBuilder {

    private final ISogojigyohiSeikyugakuTsuchishoInEditor headerEditor;
    private final ISogojigyohiSeikyugakuTsuchishoInEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor ISogojigyohiSeikyugakuTsuchishoInEditor
     * @param bodyEditor ISogojigyohiSeikyugakuTsuchishoInEditor
     */
    public SogojigyohiSeikyugakuTsuchishoInBuilder(
            ISogojigyohiSeikyugakuTsuchishoInEditor headerEditor,
            ISogojigyohiSeikyugakuTsuchishoInEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiSeikyugakuTsuchishoInSource build() {
        return ReportEditorJoiner.from(new SogojigyohiSeikyugakuTsuchishoInSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
