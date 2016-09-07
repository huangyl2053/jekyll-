/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha;

import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費過誤決定通知書情報取込（公費負担者分）一覧表帳票Builder。
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
public class SogojigyohiKagoKetteitsuchishoTorikomiBuilder implements
        ISogojigyohiKagoKetteitsuchishoTorikomiBuilder {

    private final ISogojigyohiKagoKetteitsuchishoTorikomiEditor headerEditor;

    private final ISogojigyohiKagoKetteitsuchishoTorikomiEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor ISogojigyohiKagoKetteiInEditor
     * @param bodyEditor ISogojigyohiKagoKetteiInEditor
     */
    public SogojigyohiKagoKetteitsuchishoTorikomiBuilder(
            ISogojigyohiKagoKetteitsuchishoTorikomiEditor headerEditor,
            ISogojigyohiKagoKetteitsuchishoTorikomiEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource build() {
        return ReportEditorJoiner.from(new SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
