/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunjikofutangakukeisankekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJigyobunJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護給付費等請求額通知書一覧表帳票Builderクラスです
 *
 * @reamsid_L DBC-2480-030 jiangwenkai
 */
public class GassanJigyobunJikofutangakuKeisanKekkaIchiranBuilder implements IGassanJigyobunJikofutangakuKeisanKekkaIchiranBuilder {

    private final IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor headerEditor;
    private final IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor
     * @param bodyEditor IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor
     */
    public GassanJigyobunJikofutangakuKeisanKekkaIchiranBuilder(
            IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor headerEditor,
            IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public GassanJigyobunJikofutangakuKeisanKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new GassanJigyobunJikofutangakuKeisanKekkaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
