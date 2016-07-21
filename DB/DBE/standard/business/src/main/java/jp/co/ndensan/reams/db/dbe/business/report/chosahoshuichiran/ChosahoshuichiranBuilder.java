/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuichiran.ChosahoshuichiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査報酬一覧表Builderのクラスです。
 *
 * @reamsid_L DBE-1940-030 jinjue
 */
public class ChosahoshuichiranBuilder implements IChosahoshuichiranBuilder {

    private final IChosahoshuichiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosahoshuichiranEditor}
     */
    public ChosahoshuichiranBuilder(IChosahoshuichiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosahoshuichiranReportSource}
     */
    @Override
    public ChosahoshuichiranReportSource build() {
        return ReportEditorJoiner.from(new ChosahoshuichiranReportSource()).join(editor).buildSource();
    }
}
