/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.riyojokyoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyoichiran.RiyoJokyoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200004_利用状況一覧表Builderクラスです。
 *
 * @reamsid_L DBC-3500-040 lizhuoxuan
 *
 */
public class RiyoJokyoIchiranBuilder implements IRiyoJokyoIchiranBuilder {

    private final IRiyoJokyoIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IRiyoJokyoIchiranEditor}
     */
    public RiyoJokyoIchiranBuilder(IRiyoJokyoIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link RiyoJokyoIchiranReportSource}
     */
    @Override
    public RiyoJokyoIchiranReportSource build() {
        return ReportEditorJoiner.from(new RiyoJokyoIchiranReportSource()).join(editor).buildSource();
    }
}
