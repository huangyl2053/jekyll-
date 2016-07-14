/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR81003_1_特別徴収同定一覧表のBuilder
 *
 * @reamsid_L DBB-1860-060 liuyang
 */
public class TokubetsuChoshuDoteiIchiranBuilder implements ITokubetsuChoshuDoteiIchiranBuilder {

    private final ITokubetsuChoshuDoteiIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor ITokubetsuChoshuDoteiIchiranEditor
     */
    public TokubetsuChoshuDoteiIchiranBuilder(ITokubetsuChoshuDoteiIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public TokubetsuChoshuDoteiIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuDoteiIchiranSource())
                .join(editor).buildSource();
    }

}
