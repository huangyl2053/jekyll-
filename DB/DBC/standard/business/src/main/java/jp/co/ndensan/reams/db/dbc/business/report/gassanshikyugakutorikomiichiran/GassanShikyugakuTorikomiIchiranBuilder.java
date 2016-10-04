/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakutorikomiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakutorikomiichiran.GassanShikyugakuTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC200037_高額合算支給額計算結果連絡票情報取込一覧表のBuilderクラスです。
 *
 * @reamsid_L DBC-2680-030 qinzhen
 */
public class GassanShikyugakuTorikomiIchiranBuilder implements IGassanShikyugakuTorikomiIchiranBuilder {

    private final IGassanShikyugakuTorikomiIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IGassanShikyugakuTorikomiIchiranEditor
     */
    public GassanShikyugakuTorikomiIchiranBuilder(IGassanShikyugakuTorikomiIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public GassanShikyugakuTorikomiIchiranSource build() {
        return ReportEditorJoiner.from(new GassanShikyugakuTorikomiIchiranSource())
                .join(editor).buildSource();
    }
}
