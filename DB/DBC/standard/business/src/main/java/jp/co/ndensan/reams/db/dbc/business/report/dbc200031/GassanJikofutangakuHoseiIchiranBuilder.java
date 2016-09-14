/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200031;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200031.GassanJikofutangakuHoseiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN62002_高額合算自己負担額補正結果一覧表 Builder
 *
 * @reamsid_L DBC-2320-040 jiangxiaolong
 */
public class GassanJikofutangakuHoseiIchiranBuilder
        implements IGassanJikofutangakuHoseiIchiranBuilder {

    private final IGassanJikofutangakuHoseiIchiranEditor headerEditor;
    private final IGassanJikofutangakuHoseiIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor HeaderEditor
     * @param bodyEditor BodyEditor
     */
    public GassanJikofutangakuHoseiIchiranBuilder(
            IGassanJikofutangakuHoseiIchiranEditor headerEditor,
            IGassanJikofutangakuHoseiIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public GassanJikofutangakuHoseiIchiranSource build() {
        return ReportEditorJoiner.from(new GassanJikofutangakuHoseiIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
