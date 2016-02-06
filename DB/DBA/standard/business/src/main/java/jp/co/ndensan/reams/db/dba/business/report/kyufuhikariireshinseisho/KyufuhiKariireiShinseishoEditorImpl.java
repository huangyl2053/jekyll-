/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikariireshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikariireshinseisho.KyufuhiKariireiShinseishoReportSource;

/**
 * 介護保険給付費借入申請書のEditorです。
 */
public class KyufuhiKariireiShinseishoEditorImpl implements IKyufuhiKariireiShinseishoEditor {

    private final KyufuhiKariireiShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyufuhiKariireiShinseishoItem}
     */
    protected KyufuhiKariireiShinseishoEditorImpl(KyufuhiKariireiShinseishoItem item) {
        this.item = item;
    }

    @Override
    public KyufuhiKariireiShinseishoReportSource edit(KyufuhiKariireiShinseishoReportSource source) {
        return editSource(source);
    }

    private KyufuhiKariireiShinseishoReportSource editSource(KyufuhiKariireiShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.birthYMD = item.getBirthYMD();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.shikibetsu = item.getSeibetsu();
        source.tsuchiBun1 = item.getTsuchiBun1();
        source.tsuchiBun2 = item.getTsuchiBun2();
        return source;
    }
}
