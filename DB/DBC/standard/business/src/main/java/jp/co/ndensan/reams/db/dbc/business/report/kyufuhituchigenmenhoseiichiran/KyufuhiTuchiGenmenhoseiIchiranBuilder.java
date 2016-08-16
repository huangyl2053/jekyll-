/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchigenmenhoseiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * DBC200043_給付費通知減免補正一覧表 Builderクラスです。
 *
 * @reamsid_L DBC-2470-030 surun
 */
public class KyufuhiTuchiGenmenhoseiIchiranBuilder implements IKyufuhiTuchiGenmenhoseiIchiranBuilder {

    private final IKyufuhiTuchiGenmenhoseiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufuhiTuchiGenmenhoseiIchiranEditor}
     */
    KyufuhiTuchiGenmenhoseiIchiranBuilder(IKyufuhiTuchiGenmenhoseiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufuhiTuchiGenmenhoseiIchiranSource}
     */
    @Override
    public KyufuhiTuchiGenmenhoseiIchiranReportSource build() {
        return ReportEditorJoiner.from(new KyufuhiTuchiGenmenhoseiIchiranReportSource()).join(editor).buildSource();
    }
}
