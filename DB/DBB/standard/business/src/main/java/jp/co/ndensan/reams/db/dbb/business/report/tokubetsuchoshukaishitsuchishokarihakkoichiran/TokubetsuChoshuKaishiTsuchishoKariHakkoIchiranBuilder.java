/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Builder
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder implements
        ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder {

    private final ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder(
            ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource())
                .join(editor).buildSource();
    }
}
