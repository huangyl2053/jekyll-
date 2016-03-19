/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 過誤決定通知書情報取込一覧表（保険者分） 帳票Builder
 */
public class KagoKetteitsuchishoTorikomiIchiranHokenshaBunBuilder implements IKagoKetteitsuchishoTorikomiIchiranHokenshaBunBuilder {

    private final IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor headerEditor;
    private final IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor
     * @param bodyEditor IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor
     */
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunBuilder(IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor headerEditor,
            IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource build() {
        return ReportEditorJoiner.from(new KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
