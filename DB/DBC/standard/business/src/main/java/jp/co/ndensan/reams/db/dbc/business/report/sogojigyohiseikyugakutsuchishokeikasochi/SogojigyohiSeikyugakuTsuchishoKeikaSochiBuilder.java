/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi;

import jp.co.ndensan.reams.db.dbc.entity.report.source.SogojigyohiSeiDoIchiranhyoSakusei.SogojigyohiSeikyugakuTsuchishoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費（経過措置）請求額通知書一覧表帳票Builder
 *
 * @reamsid_L DBC-2480-031 jiangxiaolong
 */
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiBuilder implements ISogojigyohiSeikyugakuTsuchishoKeikaSochiBuilder {

    private final ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor headerEditor;
    private final ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor
     * @param bodyEditor ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor
     */
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiBuilder(
            ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor headerEditor,
            ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiSource build() {
        return ReportEditorJoiner.from(new SogojigyohiSeikyugakuTsuchishoKeikaSochiSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
