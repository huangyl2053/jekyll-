/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.db.dba.entity.report.source.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoReportSource;

/**
 * 介護保険他市町村住所地特例者連絡票Editorです。
 */
class TashichosonJushochitokureishaRenrakuhyoEditor implements ITashichosonJushochitokureishaRenrakuhyoEditor {

    private final TashichosonJushochitokureishaRenrakuhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TashichosonJushochitokureishaRenrakuhyoItem}
     */
    protected TashichosonJushochitokureishaRenrakuhyoEditor(TashichosonJushochitokureishaRenrakuhyoItem item) {
        this.item = item;
    }

    @Override
    public TashichosonJushochitokureishaRenrakuhyoReportSource edit(TashichosonJushochitokureishaRenrakuhyoReportSource source) {
        source.hokenshaYubinNo = item.getHokenshaYubinNo();
        source.bunshoNo = item.getBunshoNo();
        source.hokenshaJusho = item.getHokenshaJusho();
        source.hakkoYMD = item.getHakkoYMD();
        source.hokenshaName = item.getHokenshaName();
        source.tantoBushoName = item.getTantoBushoName();
        source.barcode = item.getBarcode();
        source.midashi = item.getMidashi();
        source.tennyuYMD = item.getTennyuYMD();
        source.nyushoYMD = item.getNyushoYMD();
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
        source.tennyumaeYubinNo = item.getTennyumaeYubinNo();
        source.tennyumaeJusho = item.getTennyumaeJusho();
        source.shisetsuName = item.getShisetsuName();
        source.shisetsuTelNo = item.getShisetsuTelNo();
        source.shisetsuFaxNo = item.getShisetsuFaxNo();
        source.shisetsuYubinNo = item.getShisetsuYubinNo();
        source.shisetsuJusho = item.getShisetsuJusho();
        source.denshiKoin = item.getDenshiKoin();
        source.shomeiHakkoYMD = item.getShomeiHakkoYMD();
        source.shuchoMei = item.getShuchoMei();
        source.shichosonMei = item.getShichosonMei();
        source.koinShoryaku = item.getKoinShoryaku();
        return source;
    }
}
