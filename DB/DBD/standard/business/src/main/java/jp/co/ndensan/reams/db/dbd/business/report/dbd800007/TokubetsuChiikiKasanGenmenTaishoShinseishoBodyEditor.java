/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800007;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800007.TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource;

/**
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書ボディEditorです。
 *
 * @reamsid_L DBA-0540-700 suguangjun
 */
public class TokubetsuChiikiKasanGenmenTaishoShinseishoBodyEditor implements ITokubetsuChiikiKasanGenmenTaishoShinseishoEditor {

    private final TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書
     */
    public TokubetsuChiikiKasanGenmenTaishoShinseishoBodyEditor(TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem item) {
        this.item = item;
    }

    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書ボディEditorです。
     *
     * @param source 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Source
     * @return 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Source
     */
    @Override
    public TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource edit(TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource source) {
        return bodyEdit(source);
    }

    private TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource bodyEdit(TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.kakuninNo = item.getKakuninNo();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.tsuchiBun = item.getTsuchiBun1();
        return source;
    }
}
