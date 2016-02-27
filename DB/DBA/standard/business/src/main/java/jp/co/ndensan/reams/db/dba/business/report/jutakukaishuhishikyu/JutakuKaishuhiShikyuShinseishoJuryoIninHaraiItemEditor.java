/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jutakukaishuhishikyu;

import jp.co.ndensan.reams.db.dba.entity.report.jutakukaishuhishikyu.JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource;

/**
 *
 * 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書のEditorです。
 */
public class JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItemEditor implements IJutakuKaishuhiShikyuShinseishoJuryoIninHaraiEditor {

    private final JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem}
     */
    protected JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItemEditor(JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem item) {
        this.item = item;
    }

    @Override
    public JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource edit(JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource source) {
        return editSource(source);
    }

    private JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource editSource(JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource source) {
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.birthYMD = item.getBirthYMD();
        source.chuiBun = item.getChuiBun();
        source.douiBun = item.getDouiBun();
        source.hihokenJusho = item.getHihokenJusho();
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
