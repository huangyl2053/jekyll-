/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN62006_高額合算自己負担額計算結果一覧表Builderクラスです。
 *
 * @reamsid_L DBC-2060-040 surun
 */
public class GassanJikofutangakuKeisanKekkaIchiranBuilder implements IGassanJikofutangakuKeisanKekkaIchiranBuilder {

    private final IGassanJikofutangakuKeisanKekkaIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IGassanJikofutangakuKeisanKekkaIchiranEditor
     */
    public GassanJikofutangakuKeisanKekkaIchiranBuilder(IGassanJikofutangakuKeisanKekkaIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public GassanJikofutangakuKeisanKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new GassanJikofutangakuKeisanKekkaIchiranSource())
                .join(editor).buildSource();
    }

}
