/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchihakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200044_給付費通知発行一覧表Builderクラスです。
 *
 * @reamsid_L DBC-2280-080 lizhuoxuan
 *
 */
public class KyufuhiTuchiHakkoIchiranBuilder implements IKyufuhiTuchiHakkoIchiranBuilder {

    private final IKyufuhiTuchiHakkoIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufuhiTuchiHakkoIchiranEditor}
     */
    public KyufuhiTuchiHakkoIchiranBuilder(IKyufuhiTuchiHakkoIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuhiTuchiHakkoIchiranReportSource}
     */
    @Override
    public KyufuhiTuchiHakkoIchiranReportSource build() {
        return ReportEditorJoiner.from(new KyufuhiTuchiHakkoIchiranReportSource()).join(editor).buildSource();
    }
}
