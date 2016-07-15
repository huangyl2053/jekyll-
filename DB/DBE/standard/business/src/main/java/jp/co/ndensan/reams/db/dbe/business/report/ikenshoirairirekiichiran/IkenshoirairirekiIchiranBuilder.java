/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * DBE230004_主治医意見書作成依頼履歴一覧表のBuilderクラスです。
 *
 * @reamsid_L DBE-1590-032 zuotao
 */
public class IkenshoirairirekiIchiranBuilder implements IIkenshoirairirekiIchiranBuilder {

    private final IkenshoirairirekiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IkenshoirairirekiIchiranBuilder}
     */
    public IkenshoirairirekiIchiranBuilder(IkenshoirairirekiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IkenshoirairirekiIchiranReportSource}
     */
    @Override
    public IkenshoirairirekiIchiranReportSource build() {
        return ReportEditorJoiner.from(new IkenshoirairirekiIchiranReportSource()).join(editor).buildSource();
    }
}
