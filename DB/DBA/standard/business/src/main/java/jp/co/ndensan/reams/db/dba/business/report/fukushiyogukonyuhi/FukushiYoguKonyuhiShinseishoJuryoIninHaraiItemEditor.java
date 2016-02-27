/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.fukushiyogukonyuhi;

import jp.co.ndensan.reams.db.dba.entity.report.fukushiyogukonyuhi.FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource;

/**
 *
 * 介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書のEditorです。
 */
public class FukushiYoguKonyuhiShinseishoJuryoIninHaraiItemEditor implements IFukushiYoguKonyuhiShinseishoJuryoIninHaraiEditor {

    private final FukushiYoguKonyuhiShinseishoJuryoIninHaraiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link FukushiYoguKonyuhiShinseishoJuryoIninHaraiItem}
     */
    protected FukushiYoguKonyuhiShinseishoJuryoIninHaraiItemEditor(FukushiYoguKonyuhiShinseishoJuryoIninHaraiItem item) {
        this.item = item;
    }

    @Override
    public FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource edit(FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource source) {
        return editSource(source);
    }

    private FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource editSource(FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource source) {
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.birthYMD = item.getBirthYMD();
        source.chuiBun = item.getChuiBun();
        source.douiBun = item.getDouiBun();
        source.hihokenshaJusho = item.getHihokenshaJusho();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hokenshaNo = item.getHokenshaNo();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.remban = item.getRemban();
        source.shiseiBun = item.getShiseiBun();
        source.telNo = item.getTelNo();
        source.yubinNo = item.getYubinNo();
        return source;
    }
}
