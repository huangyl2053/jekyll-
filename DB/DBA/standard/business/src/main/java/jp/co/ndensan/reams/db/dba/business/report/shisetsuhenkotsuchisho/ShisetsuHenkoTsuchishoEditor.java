/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReportSource;

/**
 * 介護保険住所地特例施設変更通知書Editorです。
 *
 * @reamsid_L DBA-0380-070 duanzhanli
 */
class ShisetsuHenkoTsuchishoEditor implements IShisetsuHenkoTsuchishoEditor {

    private final ShisetsuHenkoTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShisetsuHenkoTsuchishoItem}
     */
    protected ShisetsuHenkoTsuchishoEditor(ShisetsuHenkoTsuchishoItem item) {
        this.item = item;
    }

    /**
     * 介護保険住所地特例施設変更通知書Editorです。
     *
     * @param source 介護保険住所地特例施設変更通知書Source
     * @return 介護保険住所地特例施設変更通知書
     */
    @Override
    public ShisetsuHenkoTsuchishoReportSource edit(ShisetsuHenkoTsuchishoReportSource source) {
        source.hokenshaYubinNo = item.getHokenshaYubinNo();
        source.bunshoNo = item.getBunshoNo();
        source.hokenshaJusho = item.getHokenshaJusho();
        source.hakkoYMD = item.getHakkoYMD();
        source.hokenshaName = item.getHokenshaName();
        source.tantoBushoName = item.getTantoBushoName();
        source.barcode = item.getBarcode();
        source.midashi1 = item.getMidashi1();
        source.midashi2 = item.getMidashi2();
        source.midashi3 = item.getMidashi3();
        source.hihokenshaNo1 = item.getHihokenshaNo1();
        source.hihokenshaNo2 = item.getHihokenshaNo2();
        source.hihokenshaNo3 = item.getHihokenshaNo3();
        source.hihokenshaNo4 = item.getHihokenshaNo4();
        source.hihokenshaNo5 = item.getHihokenshaNo5();
        source.hihokenshaNo6 = item.getHihokenshaNo6();
        source.hihokenshaNo7 = item.getHihokenshaNo7();
        source.hihokenshaNo8 = item.getHihokenshaNo8();
        source.hihokenshaNo9 = item.getHihokenshaNo9();
        source.hihokenshaNo10 = item.getHihokenshaNo10();
        source.taishoshaNameKana = item.getTaishoshaNameKana();
        source.taishoshaName = item.getTaishoshaName();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.henkoYMD = item.getHenkoYMD();
        source.henkomaeShisetsuName = item.getHenkomaeShisetsuName();
        source.henkomaeShisetsuTelNo = item.getHenkomaeShisetsuTelNo();
        source.henkomaeShisetsuFaxNo = item.getHenkomaeShisetsuFaxNo();
        source.henkomaeShisetsuYubinNo = item.getHenkomaeShisetsuYubinNo();
        source.henkomaeShisetsuJusho = item.getHenkomaeShisetsuJusho();
        source.henkogoShisetsuName = item.getHenkogoShisetsuName();
        source.henkogoShisetsuTelNo = item.getHenkogoShisetsuTelNo();
        source.henkogoShisetsuFaxNo = item.getHenkogoShisetsuFaxNo();
        source.henkogoShisetsuYubinNo = item.getHenkogoShisetsuYubinNo();
        source.henkogoShisetsuJusho = item.getHenkogoShisetsuJusho();
        source.denshiKoin = item.getDenshiKoin();
        source.shomeiHakkoYMD = item.getShomeiHakkoYMD();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.koinShoryaku = item.getKoinShoryaku();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        return source;
    }
}
