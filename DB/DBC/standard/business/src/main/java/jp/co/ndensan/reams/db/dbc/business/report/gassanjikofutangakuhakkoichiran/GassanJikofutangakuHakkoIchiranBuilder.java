/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakuhakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjikofutangakuhakkoichiran.GassanJikofutangakuHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC200035_高額合算自己負担額証明書発行一覧表 のBuilderクラスです。
 *
 * @reamsid_L DBC-2380-040 qinzhen
 */
public class GassanJikofutangakuHakkoIchiranBuilder implements IGassanJikofutangakuHakkoIchiranBuilder {

    private final IGassanJikofutangakuHakkoIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IGassanJikofutangakuHakkoIchiranEditor
     */
    public GassanJikofutangakuHakkoIchiranBuilder(IGassanJikofutangakuHakkoIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public GassanJikofutangakuHakkoIchiranSource build() {
        return ReportEditorJoiner.from(new GassanJikofutangakuHakkoIchiranSource())
                .join(editor).buildSource();
    }
}
