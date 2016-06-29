/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.ikenshojissekiichiran.IkenshoJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書作成実績集計表Builderクラスです。
 *
 * @reamsid_L DBE-1690-040 dongyabin
 */
class IkenshoJissekiIchiranBuilder implements IIkenshoJissekiIchiranBuilder {

    private final IIkenshoJissekiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIkenshoJissekiIchiranEditor}
     */
    public IkenshoJissekiIchiranBuilder(IIkenshoJissekiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IkenshoJissekiIchiranReportSource}
     */
    @Override
    public IkenshoJissekiIchiranReportSource build() {
        return ReportEditorJoiner.from(new IkenshoJissekiIchiranReportSource()).join(editor).buildSource();
    }
}
