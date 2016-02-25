/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasanhomonkaigoback;

import jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasanhomonkaigoback.TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書のReportです。
 */
public final class TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport extends Report<TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource> {

    private final TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書
     * @return 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書
     */
    public static TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport createReport(@NonNull TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem bodyItem) {
        return new TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport(bodyItem);
    }

    private TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport(TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource> writer) {
        ITokubetsuChiikiKasanGenmenTaishoShinseishoBackEditor bodyEditor = new TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyEditor(bodyItem);
        ITokubetsuChiikiKasanGenmenTaishoShinseishoBackBuilder builder = new TokubetsuChiikiKasanGenmenTaishoShinseishoBackBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
