/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.chosairairirekiichiran.ChosairairirekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査依頼履歴一覧表のBuilderのクラスです。
 *
 * @reamsid_L DBE-1590-031 sunhaidi
 */
public class ChosairairirekiIchiranBuilderImpl implements IChosairairirekiIchiranBuilder {

    private final IChosairairirekiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosairairirekiIchiranEditor}
     */
    public ChosairairirekiIchiranBuilderImpl(IChosairairirekiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosairairirekiIchiranReportSource}
     */
    @Override
    public ChosairairirekiIchiranReportSource build() {
        return ReportEditorJoiner.from(new ChosairairirekiIchiranReportSource()).join(editor).buildSource();
    }
}
