/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 Builderクラスです。
 *
 * @reamsid_L DBB-0860-060 lijian
 */
public class TokubetsuChoshuHeijunkaKeisanIchiranBuilder implements ITokubetsuChoshuHeijunkaKeisanIchiranBuilder {

    private final ITokubetsuChoshuHeijunkaKeisanIchiranEditor headerEditor;
    private final ITokubetsuChoshuHeijunkaKeisanIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor ITokubetsuChoshuHeijunkaKeisanAugustKekkaIchiranEditor
     * @param bodyEditor ITokubetsuChoshuHeijunkaKeisanAugustKekkaIchiranEditor
     */
    public TokubetsuChoshuHeijunkaKeisanIchiranBuilder(
            ITokubetsuChoshuHeijunkaKeisanIchiranEditor headerEditor,
            ITokubetsuChoshuHeijunkaKeisanIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokubetsuChoshuHeijunkaKeisanIchiranSource}
     */
    @Override
    public TokubetsuChoshuHeijunkaKeisanIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuHeijunkaKeisanIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
