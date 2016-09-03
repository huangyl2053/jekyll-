/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200036_高額合算支給額計算結果連絡票情報送付一覧表 Builderクラスです。
 *
 * @reamsid_L DBC-2670-040 lijian
 */
public class GassanShikyugakuKeisankekkaSofuIchiranBuilder implements IGassanShikyugakuKeisankekkaSofuIchiranBuilder {

    private final IGassanShikyugakuKeisankekkaSofuIchiranEditor headerEditor;
    private final IGassanShikyugakuKeisankekkaSofuIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor IGassanShikyugakuKeisankekkaSofuIchiranEditor
     * @param bodyEditor IGassanShikyugakuKeisankekkaSofuIchiranEditor
     */
    public GassanShikyugakuKeisankekkaSofuIchiranBuilder(
            IGassanShikyugakuKeisankekkaSofuIchiranEditor headerEditor,
            IGassanShikyugakuKeisankekkaSofuIchiranEditor bodyEditor) {

        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link GassanShikyugakuKeisankekkaSofuIchiranSource}
     */
    @Override
    public GassanShikyugakuKeisankekkaSofuIchiranSource build() {
        return ReportEditorJoiner.from(new GassanShikyugakuKeisankekkaSofuIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
