/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表 Builder クラスです。
 *
 * @reamsid_L DBB-1840-080 liuxiaoyu
 */
public class TokubetsuChoshuIdojohoIchiranBuilder implements ITokubetsuChoshuIdojohoIchiranBuilder {

    private final ITokubetsuChoshuIdojohoIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor ITokubetsuChoshuIdojohoIchiranEditor
     */
    public TokubetsuChoshuIdojohoIchiranBuilder(
            ITokubetsuChoshuIdojohoIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokubetsuChoshuIdojohoIchiranSource}
     */
    @Override
    public TokubetsuChoshuIdojohoIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuIdojohoIchiranSource()).join(editor).buildSource();
    }
}
