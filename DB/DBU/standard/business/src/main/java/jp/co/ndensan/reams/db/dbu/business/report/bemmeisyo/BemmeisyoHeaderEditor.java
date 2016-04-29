/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

import jp.co.ndensan.reams.db.dbu.entity.report.bemmeisyo.BemmeisyoReportSource;

/**
 * 弁明書ヘッダEditorです。
 *
 * @reamsid_L DBU-1080-150 linghuhang
 */
class BemmeisyoHeaderEditor implements IBemmeisyoEditor {

    private final BemmeisyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link BemmeisyoItem}
     */
    protected BemmeisyoHeaderEditor(BemmeisyoHeadItem item) {
        this.item = item;
    }

    @Override
    public BemmeisyoReportSource edit(BemmeisyoReportSource source) {
        return editHeader(source);
    }

    private BemmeisyoReportSource editHeader(BemmeisyoReportSource source) {

        source.sofusakiYubinNo = item.getSofusakiYubinNo();
        source.sofusakiJusho = item.getSofusakiJusho();
        source.sofusakiName = item.getSofusakiName();
        source.midashi = item.getMidashi();
        source.bemmeisyoName = item.getBemmeisyoName();
        source.bemmeiNaiyo = item.getBemmeiNaiyo();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenshaJusho = item.getHihokenshaJusho();
        source.hakkoYMD = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinShoryaku = item.getKoinShoryaku();
        return source;
    }
}
