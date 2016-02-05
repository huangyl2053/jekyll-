/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoReportSource;

/**
 *
 * 要介護認定区分変更申請書のITEMのEditorです。
 */
public class YokaigoNinteikbnHenkoShinseishoItemEditor
        implements IYokaigoNinteikbnHenkoShinseishoEditor {

    private final YokaigoNinteikbnHenkoShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link YokaigoNinteikbnHenkoShinseishoItem}
     */
    protected YokaigoNinteikbnHenkoShinseishoItemEditor(YokaigoNinteikbnHenkoShinseishoItem item) {
        this.item = item;
    }

    @Override
    public YokaigoNinteikbnHenkoShinseishoReportSource edit(
            YokaigoNinteikbnHenkoShinseishoReportSource source) {
        return editSource(source);
    }

    private YokaigoNinteikbnHenkoShinseishoReportSource editSource(
            YokaigoNinteikbnHenkoShinseishoReportSource source) {
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.birthYMD = item.getBirthYMD();
        source.hihokenshaName = item.getHihokenshaName();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.yokaigoKbn = item.getYokaigoKbn();
        source.yoshienKbn = item.getYoshienKbn();
        source.yokoKikanSTYMD = item.getYokoKikanSTYMD();
        source.yokoKikanEDYMD = item.getYokoKikanEDYMD();
        source.tsuchiBun = item.getTsuchiBun();
        source.remban = item.getRemban();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        return source;
    }
}
