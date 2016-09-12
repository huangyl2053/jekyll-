/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichosahyojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.chosahyojissekiichiran.ChosahyoJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票出力用認定調査実績集計表Builderクラスです。
 *
 * @reamsid_L DBE-1691-030 dangjingjing
 */
class ChosahyoJissekiIchiranBuilder implements IChosahyoJissekiIchiranBuilder {

    private final IChosahyoJissekiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosahyoJissekiIchiranEditor}
     */
    public ChosahyoJissekiIchiranBuilder(IChosahyoJissekiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosahyoJissekiIchiranReportSource}
     */
    @Override
    public ChosahyoJissekiIchiranReportSource build() {
        return ReportEditorJoiner.from(new ChosahyoJissekiIchiranReportSource()).join(editor).buildSource();
    }
}
