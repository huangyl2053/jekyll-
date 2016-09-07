/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800006;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800006.ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人等利用者負担軽減対象確認申請書ヘッダEditorです。
 *
 * @reamsid_L DBA-0540-698 zhangguopeng
 */
class ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoEditorImpl implements IShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoEditor {

    private final ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoItem}
     */
    protected ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoEditorImpl(
            ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoItem item) {
        this.item = item;
    }

    @Override
    public ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource edit(
            ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource source) {
        return editHeader(source);
    }

    private ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource editHeader(
            ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = item.get認証者();
        source.hihokenshaNameKana = item.getフリガナ();
        source.hihokenshaName = item.get被保険者氏名();
        source.kakuninNo = item.get確認番号();
        source.hihokenshaNo = item.get被保険者番号();
        source.birthYMD = item.get生年月日();
        source.seibetsu = item.get性別();
        source.hihokenshaYubinNo = item.get郵便番号();
        source.hihokenJusho = item.get住所();
        source.hihokenshaTelNo = item.get電話番号();
        source.hihokenJusho1 = item.get通知文();
        source.remban = new RString("1");
        return source;
    }
}
