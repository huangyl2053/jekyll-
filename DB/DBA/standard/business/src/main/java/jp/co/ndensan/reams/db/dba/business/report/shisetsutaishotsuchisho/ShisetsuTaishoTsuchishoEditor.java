/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReportSource;

/**
 * 介護保険住所地特例施設退所通知書Editorです。
 *
 * @reamsid_L DBA-0380-060 duanzhanli
 */
class ShisetsuTaishoTsuchishoEditor implements IShisetsuTaishoTsuchishoEditor {

    private final ShisetsuTaishoTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShisetsuTaishoTsuchishoItem}
     */
    protected ShisetsuTaishoTsuchishoEditor(ShisetsuTaishoTsuchishoItem item) {
        this.item = item;
    }

    /**
     * 介護保険住所地特例施設退所通知書Editorです。
     *
     * @param source 介護保険住所地特例施設退所通知書Source
     * @return 介護保険住所地特例施設退所通知書
     */
    @Override
    public ShisetsuTaishoTsuchishoReportSource edit(ShisetsuTaishoTsuchishoReportSource source) {
        source.hokenshaYubinNo = item.getHokenshaYubinNo();
        source.bunshoNo = item.getBunshoNo();
        source.hokenshaJusho = item.getHokenshaJusho();
        source.hakkoYMD = item.getHakkoYMD();
        source.hokenshaName = item.getHokenshaName();
        source.tantoBushoName = item.getTantoBushoName();
        source.barcode = item.getBarcode();
        source.midashi = item.getMidashi();
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
        source.taishogoYubinNo = item.getTaishogoYubinNo();
        source.taishogoJusho = item.getTaishogoJusho();
        source.taishoYMD = item.getTaishoYMD();
        source.taishoJiyu = item.getTaishoJiyu();
        source.shisetsuName = item.getShisetsuName();
        source.shisetsuTelNo = item.getShisetsuTelNo();
        source.shisetsuFaxNo = item.getShisetsuFaxNo();
        source.shisetsuYubinNo = item.getShisetsuYubinNo();
        source.shisetsuJusho = item.getShisetsuJusho();
        source.denshiKoin = item.getDenshiKoin();
        source.hakkoYMD1 = item.getHakkoYMD1();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.koinShoryaku = item.getKoinShoryaku();
        return source;
    }
}
