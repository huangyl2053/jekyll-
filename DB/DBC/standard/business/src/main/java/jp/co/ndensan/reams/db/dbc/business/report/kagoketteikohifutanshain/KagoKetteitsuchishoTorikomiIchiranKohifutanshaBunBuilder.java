/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitsuchishotorikomiichirankohifutanshabun.KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票Builder
 */
public class KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder implements
        IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder {

    private final IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor headerEditor;
    private final IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor
     * IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor
     * @param bodyEditor
     * IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor
     */
    public KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder(
            IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor headerEditor,
            IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource build() {
        return ReportEditorJoiner.from(new KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
