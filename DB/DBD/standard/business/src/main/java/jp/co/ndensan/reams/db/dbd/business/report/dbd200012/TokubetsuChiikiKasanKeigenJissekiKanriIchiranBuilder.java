/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200012;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別地域加算軽減実績管理リストBuilderクラスです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
public class TokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder implements ITokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder {

    private final ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor}
     */
    TokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder(ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource}
     */
    @Override
    public TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource build() {
        return ReportEditorJoiner.from(new TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource()).join(bodyEditor).buildSource();
    }
}
