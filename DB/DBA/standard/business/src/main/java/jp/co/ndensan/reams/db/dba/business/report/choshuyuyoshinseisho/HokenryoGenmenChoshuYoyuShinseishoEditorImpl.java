/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.choshuyuyoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.choshuyuyoshinseisho.HokenryoGenmenChoshuYoyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険料徴収猶予申請書のEditorです。
 *
 * @reamsid_L DBA-0540-693 xuyannan
 */
public class HokenryoGenmenChoshuYoyuShinseishoEditorImpl implements IHokenryoGenmenChoshuYoyuShinseishoEditor {

    private final HokenryoGenmenChoshuYoyuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HokenryoGenmenChoshuYoyuShinseishoItem}
     */
    protected HokenryoGenmenChoshuYoyuShinseishoEditorImpl(HokenryoGenmenChoshuYoyuShinseishoItem item) {
        this.item = item;
    }

    /**
     * 帳票データを編集します。
     *
     * @param source 帳票ソース
     * @return HokenryoGenmenChoshuYoyuShinseishoReportSource
     */
    @Override
    public HokenryoGenmenChoshuYoyuShinseishoReportSource edit(HokenryoGenmenChoshuYoyuShinseishoReportSource source) {
        return editSource(source);
    }

    private HokenryoGenmenChoshuYoyuShinseishoReportSource editSource(HokenryoGenmenChoshuYoyuShinseishoReportSource source) {
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
        source.remban = new RString(String.valueOf(1));
        return source;
    }
}
