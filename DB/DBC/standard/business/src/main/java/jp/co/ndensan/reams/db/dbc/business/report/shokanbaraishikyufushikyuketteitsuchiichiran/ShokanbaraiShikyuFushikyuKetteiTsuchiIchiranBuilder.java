/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 償還払支給（不支給）決定通知一覧表覧表Builderクラスです。
 */
public class ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranBuilder implements IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranBuilder {

    private final IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor}
     */
    public ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranBuilder(IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource}
     */
    @Override
    public ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource build() {
        return ReportEditorJoiner.from(new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource()).join(editor).buildSource();
    }
}
