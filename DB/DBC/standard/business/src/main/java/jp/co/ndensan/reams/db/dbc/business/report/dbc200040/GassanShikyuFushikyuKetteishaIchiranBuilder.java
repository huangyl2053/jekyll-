/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200040;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200040.GassanShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額合算支給決定者一覧表Builder
 *
 * @reamsid_L DBC-2300-045 jiangxiaolong
 */
public class GassanShikyuFushikyuKetteishaIchiranBuilder
        implements IGassanShikyuFushikyuKetteishaIchiranBuilder {

    private final IGassanShikyuFushikyuKetteishaIchiranEditor headerEditor;
    private final IGassanShikyuFushikyuKetteishaIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor HeaderEditor
     * @param bodyEditor BodyEditor
     */
    public GassanShikyuFushikyuKetteishaIchiranBuilder(
            IGassanShikyuFushikyuKetteishaIchiranEditor headerEditor,
            IGassanShikyuFushikyuKetteishaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public GassanShikyuFushikyuKetteishaIchiranSource build() {
        return ReportEditorJoiner.from(new GassanShikyuFushikyuKetteishaIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
