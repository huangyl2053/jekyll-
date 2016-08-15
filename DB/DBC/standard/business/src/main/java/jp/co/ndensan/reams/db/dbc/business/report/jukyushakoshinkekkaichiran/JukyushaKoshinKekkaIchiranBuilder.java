/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 受給者情報更新結果情報取込一覧表帳票Builder
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public class JukyushaKoshinKekkaIchiranBuilder implements IJukyushaKoshinKekkaIchiranBuilder {

    private final IJukyushaKoshinKekkaIchiranEditor headerEditor;
    private final IJukyushaKoshinKekkaIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IKogakuKyufuTaishoshaIchiranEditor
     * @param bodyEditor IKogakuKyufuTaishoshaIchiranEditor
     */
    public JukyushaKoshinKekkaIchiranBuilder(
            IJukyushaKoshinKekkaIchiranEditor headerEditor,
            IJukyushaKoshinKekkaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public JukyushaKoshinKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new JukyushaKoshinKekkaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
