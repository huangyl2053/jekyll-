/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200024;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200024.ShokanbaraiSashitomeTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200024_償還払支給差止対象者一覧表のBuilder
 *
 * @reamsid_L DBC-1000-160 liwul
 */
public class ShokanbaraiSashitomeTaishoshaIchiranBuilder implements IShokanbaraiSashitomeTaishoshaIchiranBuilder {

    private final IShokanbaraiSashitomeTaishoshaIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor}
     */
    public ShokanbaraiSashitomeTaishoshaIchiranBuilder(IShokanbaraiSashitomeTaishoshaIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource}
     */
    @Override
    public ShokanbaraiSashitomeTaishoshaIchiranSource build() {
        return ReportEditorJoiner.from(new ShokanbaraiSashitomeTaishoshaIchiranSource()).join(editor).buildSource();
    }
}
