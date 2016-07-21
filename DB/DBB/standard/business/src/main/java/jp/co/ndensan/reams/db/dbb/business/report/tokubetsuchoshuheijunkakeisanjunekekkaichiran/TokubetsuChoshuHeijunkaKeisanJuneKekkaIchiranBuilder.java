/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0810-030 yebangqiang
 */
class TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder implements ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder {

    private final ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor headerEditor;
    private final ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor headerEditor
     * @param bodyEditor bodyEditor
     */
    public TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder(ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor headerEditor,
            ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource}
     */
    @Override
    public TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
