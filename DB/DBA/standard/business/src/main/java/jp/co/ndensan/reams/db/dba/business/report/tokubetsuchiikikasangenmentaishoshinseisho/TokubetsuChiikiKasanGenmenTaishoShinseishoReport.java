/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasangenmentaishoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasangenmentaishoshinseisho.TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書のReportです。
 */
public final class TokubetsuChiikiKasanGenmenTaishoShinseishoReport extends Report<TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource> {

    private final TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書
     * @return 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書
     */
    public static TokubetsuChiikiKasanGenmenTaishoShinseishoReport createReport(@NonNull TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem bodyItem) {
        return new TokubetsuChiikiKasanGenmenTaishoShinseishoReport(bodyItem);
    }

    private TokubetsuChiikiKasanGenmenTaishoShinseishoReport(TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource> writer) {
        ITokubetsuChiikiKasanGenmenTaishoShinseishoEditor bodyEditor = new TokubetsuChiikiKasanGenmenTaishoShinseishoBodyEditor(bodyItem);
        ITokubetsuChiikiKasanGenmenTaishoShinseishoBuilder builder = new TokubetsuChiikiKasanGenmenTaishoShinseishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
