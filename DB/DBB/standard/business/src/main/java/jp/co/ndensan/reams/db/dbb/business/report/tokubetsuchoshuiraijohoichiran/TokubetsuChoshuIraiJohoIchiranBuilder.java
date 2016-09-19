/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR82001_1_特別徴収依頼情報一覧表
 *
 * @reamsid_L DBB-1840-060 chenyadong
 */
public class TokubetsuChoshuIraiJohoIchiranBuilder implements ITokubetsuChoshuIraiJohoIchiranBuilder {

    private final ITokubetsuChoshuIraiJohoIchiranEditor headerEditor;
    private final ITokubetsuChoshuIraiJohoIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor {@link ITokubetsuChoshuIraiJohoIchiranEditor}
     * @param bodyEditor {@link ITokubetsuChoshuIraiJohoIchiranEditor}
     */
    public TokubetsuChoshuIraiJohoIchiranBuilder(ITokubetsuChoshuIraiJohoIchiranEditor headerEditor,
            ITokubetsuChoshuIraiJohoIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public TokubetsuChoshuIraiJohoIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuIraiJohoIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }
}
