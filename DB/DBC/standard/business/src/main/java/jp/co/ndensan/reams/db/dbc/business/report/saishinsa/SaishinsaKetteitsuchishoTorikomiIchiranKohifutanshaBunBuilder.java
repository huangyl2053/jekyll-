/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsa;

import jp.co.ndensan.reams.db.dbc.entity.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）帳票Builder
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
public class SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder
        implements ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder {

    private final ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor headerEditor;
    private final ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor HeaderEditor
     * @param bodyEditor BodyEditor
     */
    public SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder(
            ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor headerEditor,
            ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource build() {
        return ReportEditorJoiner.from(new SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
