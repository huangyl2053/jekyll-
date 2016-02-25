/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasangenmentaishoshinseishoback;

import jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasangenmentaishoshinseishoback.TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Builderクラスです。
 */
public class TokubetsuChiikiKasanGenmenTaishoShinseishoBackBuilderImpl implements ITokubetsuChiikiKasanGenmenTaishoShinseishoBackBuilder {

    private final ITokubetsuChiikiKasanGenmenTaishoShinseishoBackEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link ITokubetsuChiikiKasanGenmenTaishoShinseishoBackEditor}
     */
    TokubetsuChiikiKasanGenmenTaishoShinseishoBackBuilderImpl(ITokubetsuChiikiKasanGenmenTaishoShinseishoBackEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource}
     */
    @Override
    public TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource build() {
        return ReportEditorJoiner.from(new TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource())
                .join(bodyEditor).buildSource();
    }
}
