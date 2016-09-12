/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表のBuilder
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranBuilder
        implements ITokubetsuChoshuIraikingakuMeisaiIchiranBuilder {

    private final ITokubetsuChoshuIraikingakuMeisaiIchiranEditor headerEditor;
    private final ITokubetsuChoshuIraikingakuMeisaiIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link ITokubetsuChoshuIraikingakuMeisaiIchiranEditor}
     * @param bodyEditor {@link ITokubetsuChoshuIraikingakuMeisaiIchiranEditor}
     */
    public TokubetsuChoshuIraikingakuMeisaiIchiranBuilder(
            ITokubetsuChoshuIraikingakuMeisaiIchiranEditor headerEditor,
            ITokubetsuChoshuIraikingakuMeisaiIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link TokubetsuChoshuIraikingakuMeisaiIchiranSource}
     */
    @Override
    public TokubetsuChoshuIraikingakuMeisaiIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuIraikingakuMeisaiIchiranSource()).join(headerEditor)
                .join(bodyEditor).buildSource();
    }

}
