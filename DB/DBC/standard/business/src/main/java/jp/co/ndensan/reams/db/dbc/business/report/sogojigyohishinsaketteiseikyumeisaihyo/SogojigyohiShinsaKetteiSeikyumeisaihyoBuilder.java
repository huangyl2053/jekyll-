/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC200070_介護予防・日常生活支援総合事業費審査決定請求明細表帳票Builderクラスです
 *
 * @reamsid_L DBC-2500-031 jiangwenkai
 */
public class SogojigyohiShinsaKetteiSeikyumeisaihyoBuilder implements ISogojigyohiShinsaKetteiSeikyumeisaihyoBuilder {

    private final ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor headerEditor;
    private final ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor
     * @param bodyEditor ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor
     */
    public SogojigyohiShinsaKetteiSeikyumeisaihyoBuilder(
            ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor headerEditor,
            ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiShinsaKetteiSeikyumeisaihyoSource build() {
        return ReportEditorJoiner.from(new SogojigyohiShinsaKetteiSeikyumeisaihyoSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
