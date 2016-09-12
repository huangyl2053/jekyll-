/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800007;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800007.TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Builderクラスです。
 *
 * @reamsid_L DBA-0540-700 suguangjun
 */
public class TokubetsuChiikiKasanGenmenTaishoShinseishoBuilderImpl implements ITokubetsuChiikiKasanGenmenTaishoShinseishoBuilder {

    private final ITokubetsuChiikiKasanGenmenTaishoShinseishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link ITokubetsuChiikiKasanGenmenTaishoShinseishoEditor}
     */
    TokubetsuChiikiKasanGenmenTaishoShinseishoBuilderImpl(ITokubetsuChiikiKasanGenmenTaishoShinseishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link RiyoshaFutangakuGengakuMenjyoShinseishoReportSource}
     */
    @Override
    public TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource build() {
        return ReportEditorJoiner.from(new TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource())
                .join(bodyEditor).buildSource();
    }

}
