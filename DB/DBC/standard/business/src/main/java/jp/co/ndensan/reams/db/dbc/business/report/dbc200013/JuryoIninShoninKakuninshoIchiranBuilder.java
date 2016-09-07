/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200013;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200013.JuryoIninShoninKakuninshoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN32002_受領委任契約承認確認書発行一覧表Builder
 *
 * @reamsid_L DBC-1910-070 jiangxiaolong
 */
public class JuryoIninShoninKakuninshoIchiranBuilder
        implements IJuryoIninShoninKakuninshoIchiranBuilder {

    private final IJuryoIninShoninKakuninshoIchiranEditor headerEditor;
    private final IJuryoIninShoninKakuninshoIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor HeaderEditor
     * @param bodyEditor BodyEditor
     */
    public JuryoIninShoninKakuninshoIchiranBuilder(
            IJuryoIninShoninKakuninshoIchiranEditor headerEditor,
            IJuryoIninShoninKakuninshoIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public JuryoIninShoninKakuninshoIchiranSource build() {
        return ReportEditorJoiner.from(new JuryoIninShoninKakuninshoIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
