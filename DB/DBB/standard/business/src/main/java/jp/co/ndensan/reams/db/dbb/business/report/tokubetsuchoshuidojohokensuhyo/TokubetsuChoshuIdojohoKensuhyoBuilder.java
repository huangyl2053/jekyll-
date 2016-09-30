/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Report
 *
 * @reamsid_L DBB-1840-090 lihang
 */
public class TokubetsuChoshuIdojohoKensuhyoBuilder implements ITokubetsuChoshuIdojohoKensuhyoBuilder {

    private final ITokubetsuChoshuIdojohoKensuhyoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor ITokubetsuChoshuDoteiIchiranEditor
     */
    public TokubetsuChoshuIdojohoKensuhyoBuilder(ITokubetsuChoshuIdojohoKensuhyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public TokubetsuChoshuIdojohoKensuhyoSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuIdojohoKensuhyoSource())
                .join(editor).buildSource();
    }
}
