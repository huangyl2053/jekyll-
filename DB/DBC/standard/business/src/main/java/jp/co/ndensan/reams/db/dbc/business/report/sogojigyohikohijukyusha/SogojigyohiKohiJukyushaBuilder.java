/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikohijukyusha;

import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費公費受給者別一覧表帳票Builder。
 *
 * @reamsid_L DBC-4710-040 chenjie
 */
public class SogojigyohiKohiJukyushaBuilder implements ISogojigyohiKohiJukyushaBuilder {

    private final ISogojigyohiKohiJukyushaEditor headerEditor;

    private final ISogojigyohiKohiJukyushaEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor ISogojigyohiKagoKetteiInEditor
     * @param bodyEditor ISogojigyohiKagoKetteiInEditor
     */
    public SogojigyohiKohiJukyushaBuilder(
            ISogojigyohiKohiJukyushaEditor headerEditor,
            ISogojigyohiKohiJukyushaEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiKohiJukyushaSource build() {
        return ReportEditorJoiner.from(new SogojigyohiKohiJukyushaSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
