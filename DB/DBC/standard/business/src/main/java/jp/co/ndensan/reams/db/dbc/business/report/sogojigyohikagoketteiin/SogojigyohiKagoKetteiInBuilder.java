/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin;

import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費（経過措置）過誤決定通知書情報取込一覧表帳票Builder。
 *
 * @reamsid_L DBC-2550-030　jianglaisheng
 */
public class SogojigyohiKagoKetteiInBuilder implements
        ISogojigyohiKagoKetteiInBuilder {

    private final ISogojigyohiKagoKetteiInEditor headerEditor;

    private final ISogojigyohiKagoKetteiInEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor ISogojigyohiKagoKetteiInEditor
     * @param bodyEditor ISogojigyohiKagoKetteiInEditor
     */
    public SogojigyohiKagoKetteiInBuilder(
            ISogojigyohiKagoKetteiInEditor headerEditor,
            ISogojigyohiKagoKetteiInEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiKagoKetteiInSource build() {
        return ReportEditorJoiner.from(new SogojigyohiKagoKetteiInSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
