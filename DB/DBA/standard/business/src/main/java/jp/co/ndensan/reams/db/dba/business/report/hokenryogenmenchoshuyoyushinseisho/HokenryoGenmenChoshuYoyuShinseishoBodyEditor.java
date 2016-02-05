/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hokenryogenmenchoshuyoyushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.hokenryogenmenchoshuyoyushinseisho.HokenryoGenmenChoshuYoyuShinseishoReportSource;

/**
 *
 * 介護保険料減免申請書ボディEditorです。
 */
public class HokenryoGenmenChoshuYoyuShinseishoBodyEditor implements IHokenryoGenmenChoshuYoyuShinseishoEditor {

    private final HokenryoGenmenChoshuYoyuShinseishoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険料減免申請書情報
     */
    public HokenryoGenmenChoshuYoyuShinseishoBodyEditor(HokenryoGenmenChoshuYoyuShinseishoBodyItem item) {
        this.item = item;
    }

    /**
     * 介護保険料減免申請書ボディEditorです。
     *
     * @param source 介護保険料減免申請書Source
     * @return 介護保険料減免申請書Source
     */
    @Override
    public HokenryoGenmenChoshuYoyuShinseishoReportSource edit(HokenryoGenmenChoshuYoyuShinseishoReportSource source) {
        return bodyEdit(source);
    }

    private HokenryoGenmenChoshuYoyuShinseishoReportSource bodyEdit(HokenryoGenmenChoshuYoyuShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.hokenshaNo = item.getHokenshaNo();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.remban = item.getRemban();
        return source;
    }
}
