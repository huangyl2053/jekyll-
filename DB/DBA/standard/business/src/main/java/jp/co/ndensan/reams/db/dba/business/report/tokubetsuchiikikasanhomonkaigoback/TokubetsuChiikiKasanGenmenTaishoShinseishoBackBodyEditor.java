/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasanhomonkaigoback;

import jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasanhomonkaigoback.TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource;

/**
 *
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書ボディEditorです。
 */
public class TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyEditor implements ITokubetsuChiikiKasanGenmenTaishoShinseishoBackEditor {

    private final TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書
     */
    public TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyEditor(TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem item) {
        this.item = item;
    }

    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書ボディEditorです。
     *
     * @param source 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Source
     * @return 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Source
     */
    @Override
    public TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource edit(TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource source) {
        return bodyEdit(source);
    }

    private TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource bodyEdit(TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource source) {
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.tsuchiBun = item.getTsuchiBun2();
        return source;
    }
}
