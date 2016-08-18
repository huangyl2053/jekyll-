/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120840;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc120840.SogojigyohiKagoKetteiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費過誤決定通知書情報取込（保険者分)帳票Builder
 *
 * @reamsid_L DBC-2550-011 jiangxiaolong
 */
public class SogojigyohiKagoKetteiHokenshaBunBuilder
        implements ISogojigyohiKagoKetteiHokenshaBunBuilder {

    private final ISogojigyohiKagoKetteiHokenshaBunEditor headerEditor;
    private final ISogojigyohiKagoKetteiHokenshaBunEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor HeaderEditor
     * @param bodyEditor BodyEditor
     */
    public SogojigyohiKagoKetteiHokenshaBunBuilder(
            ISogojigyohiKagoKetteiHokenshaBunEditor headerEditor,
            ISogojigyohiKagoKetteiHokenshaBunEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiKagoKetteiTorikomiIchiranSource build() {
        return ReportEditorJoiner.from(new SogojigyohiKagoKetteiTorikomiIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
