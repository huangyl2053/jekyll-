/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashokoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashokoufushinseisho.HihokenshashokoufuShinseishoReportSource;

/**
 * 介護保険被保険者証交付申請書（第2号被保険者）Editorです。
 */
public class HihokenshashokoufuShinseishoEditor implements IHihokenshashokoufuShinseishoEditor {

    private final HihokenshashokoufuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HihokenshashokoufuShinseishoItem}
     */
    protected HihokenshashokoufuShinseishoEditor(HihokenshashokoufuShinseishoItem item) {
        this.item = item;
    }

    /**
     * 介護保険被保険者証交付申請書（第2号被保険者）のデータ設定処理です。
     * @param source 介護保険被保険者証交付申請書（第2号被保険者）の帳票データ
     * @return 介護保険被保険者証交付申請書
     */
    @Override
    public HihokenshashokoufuShinseishoReportSource edit(HihokenshashokoufuShinseishoReportSource source) {
        return editSource(source);
    }

    private HihokenshashokoufuShinseishoReportSource editSource(HihokenshashokoufuShinseishoReportSource source) {

        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.seibetsu = item.getSeibetsu();
        source.birthYMD = item.getBirthYMD();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        return source;
    }
}
