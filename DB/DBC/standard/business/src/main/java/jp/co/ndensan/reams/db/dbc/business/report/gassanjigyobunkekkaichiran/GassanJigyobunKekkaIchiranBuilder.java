/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBCMNN1004_事業分支給額計算 のBuilderクラスです。
 *
 * @reamsid_L DBC-4830-040 qinzhen
 */
public class GassanJigyobunKekkaIchiranBuilder implements IGassanJigyobunKekkaIchiranBuilder {

    private final IGassanJigyobunKekkaIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IGassanJigyobunKekkaIchiranEditor
     */
    public GassanJigyobunKekkaIchiranBuilder(IGassanJigyobunKekkaIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public GassanJigyobunKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new GassanJigyobunKekkaIchiranSource())
                .join(editor).buildSource();
    }
}
