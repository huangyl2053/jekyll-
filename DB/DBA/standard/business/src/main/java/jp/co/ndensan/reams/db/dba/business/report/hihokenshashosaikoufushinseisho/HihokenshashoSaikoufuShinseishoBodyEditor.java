/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashosaikoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashosaikoufushinseisho.HihokenshashoSaikoufuShinseishoReportSource;

/**
 *
 * 介護保険被保険者証等再交付申請書ボディEditorです。
 */
public class HihokenshashoSaikoufuShinseishoBodyEditor implements IHihokenshashoSaikoufuShinseishoEditor {

    private final HihokenshashoSaikoufuShinseishoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 受給資格証明書情報
     */
    public HihokenshashoSaikoufuShinseishoBodyEditor(HihokenshashoSaikoufuShinseishoBodyItem item) {
        this.item = item;
    }

    /**
     * 受給資格証明書ボディEditorです。
     *
     * @param source 受給資格証明書Source
     * @return 受給資格証明書Source
     */
    @Override
    public HihokenshashoSaikoufuShinseishoReportSource edit(HihokenshashoSaikoufuShinseishoReportSource source) {
        return bodyEdit(source);
    }

    private HihokenshashoSaikoufuShinseishoReportSource bodyEdit(HihokenshashoSaikoufuShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        return source;
    }
}
