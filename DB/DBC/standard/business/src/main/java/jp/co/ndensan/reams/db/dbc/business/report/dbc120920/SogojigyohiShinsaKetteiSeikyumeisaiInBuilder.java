/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120920;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200084_総合事業費審査決定請求明細表帳票Builder
 *
 * @reamsid_L DBC-2500-032 jiangxiaolong
 */
public class SogojigyohiShinsaKetteiSeikyumeisaiInBuilder
        implements ISogojigyohiShinsaKetteiSeikyumeisaiInBuilder {

    private final ISogojigyohiShinsaKetteiSeikyumeisaiInEditor headerEditor;
    private final ISogojigyohiShinsaKetteiSeikyumeisaiInEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor HeaderEditor
     * @param bodyEditor BodyEditor
     */
    public SogojigyohiShinsaKetteiSeikyumeisaiInBuilder(
            ISogojigyohiShinsaKetteiSeikyumeisaiInEditor headerEditor,
            ISogojigyohiShinsaKetteiSeikyumeisaiInEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiShinsaKetteiSeikyumeisaihyoSource build() {
        return ReportEditorJoiner.from(new SogojigyohiShinsaKetteiSeikyumeisaihyoSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
