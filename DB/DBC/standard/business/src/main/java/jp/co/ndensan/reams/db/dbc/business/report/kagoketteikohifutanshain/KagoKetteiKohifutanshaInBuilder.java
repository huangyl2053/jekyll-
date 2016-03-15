/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain
        .KagoKetteiKohifutanshaInSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票Builder
 */
public class KagoKetteiKohifutanshaInBuilder implements
        IKagoKetteiKohifutanshaInBuilder {

    private final IKagoKetteiKohifutanshaInEditor headerEditor;
    private final IKagoKetteiKohifutanshaInEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor
     * IKagoKetteiKohifutanshaInEditor
     * @param bodyEditor
     * IKagoKetteiKohifutanshaInEditor
     */
    public KagoKetteiKohifutanshaInBuilder(
            IKagoKetteiKohifutanshaInEditor headerEditor,
            IKagoKetteiKohifutanshaInEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KagoKetteiKohifutanshaInSource build() {
        return ReportEditorJoiner.from(new KagoKetteiKohifutanshaInSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }
}
