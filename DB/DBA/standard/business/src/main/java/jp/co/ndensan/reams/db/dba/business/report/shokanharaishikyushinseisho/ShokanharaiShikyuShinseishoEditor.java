/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shokanharaishikyushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.shokanharaishikyushinseisho.ShokanharaiShikyuShinseishoReportSource;

/**
 *
 * 介護保険償還払支給申請書Editorです。
 */
public class ShokanharaiShikyuShinseishoEditor implements IShokanharaiShikyuShinseishoEditor {

    private final ShokanharaiShikyuShinseishoItem joho;

    /**
     * コンストラクタです。
     *
     * @param joho 介護保険償還払支給申請書Itemです
     */
    public ShokanharaiShikyuShinseishoEditor(ShokanharaiShikyuShinseishoItem joho) {
        this.joho = joho;
    }

    /**
     * 介護保険償還払支給申請書editです。
     *
     * @param source 介護保険償還払支給申請書Source
     * @return 介護保険償還払支給申請書
     */
    @Override
    public ShokanharaiShikyuShinseishoReportSource edit(ShokanharaiShikyuShinseishoReportSource source) {
        return editBody(source);
    }

    private ShokanharaiShikyuShinseishoReportSource editBody(ShokanharaiShikyuShinseishoReportSource source) {
        source.hihokenshaNameKana = joho.getHihokenshaNameKana();
        source.hokenshaNo = joho.getHokenshaNo();
        source.hihokenshaName = joho.getHihokenshaName();
        source.hihokenshaNo = joho.getHihokenshaNo();
        source.birthYMD = joho.getBirthYMD();
        source.seibetsu = joho.getSeibetsu();
        source.telNo = joho.getTelNo();
        source.yubinNo = joho.getYubinNo();
        source.hihokenJusho = joho.getHihokenJusho();
        source.shiseiBun = joho.getShiseiBun();
        source.chuiBun = joho.getChuiBun();
        source.remban = joho.getRemban();
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        return source;
    }

}
