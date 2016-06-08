/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shoukanbaraijuryoininbaraishinseishochohyo;

import jp.co.ndensan.reams.db.dba.entity.report.shoukanbaraijuryoininbaraishinseishochohyo.ShokanharaiJuryoIninShinseishoReportSource;

/**
 * 介護保険償還払受領委任払申請書のEditorです。
 *
 * @reamsid_L DBA-0540-707 xuyannan
 */
public class ShokanharaiJuryoIninShinseishoEditorImpl implements IShokanharaiJuryoIninShinseishoEditor {

    private final ShokanharaiJuryoIninShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShokanharaiJuryoIninShinseishoItem}
     */
    protected ShokanharaiJuryoIninShinseishoEditorImpl(ShokanharaiJuryoIninShinseishoItem item) {
        this.item = item;
    }

    /**
     * 申請書を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShokanharaiJuryoIninShinseishoReportSource edit(ShokanharaiJuryoIninShinseishoReportSource source) {
        return editSource(source);
    }

    private ShokanharaiJuryoIninShinseishoReportSource editSource(ShokanharaiJuryoIninShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.birthYMD = item.getBirthYMD();
        source.chuiBun = item.getChuiBun();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hokenshaNo = item.getHokenshaNo();
        source.remban = item.getRemban();
        source.seibetsu = item.getSeibetsu();
        source.shiseiBun = item.getShiseiBun();
        source.telNo = item.getTelNo();
        source.yubinNo = item.getYubinNo();
        return source;
    }
}
