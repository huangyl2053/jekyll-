/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.tokuteifutangendogakushinseisho.TokuteiFutangendogakuShinseishoReportSource;

/**
 * 介護保険特定負担限度額申請書Editorです。
 */
public class TokuteiFutangendogakuShinseishoEditor implements ITokuteiFutangendogakuShinseishoEditor {

    private final TokuteiFutangendogakuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TokuteiFutangendogakuShinseishoItem}
     */
    protected TokuteiFutangendogakuShinseishoEditor(TokuteiFutangendogakuShinseishoItem item) {
        this.item = item;
    }

    /**
     * 介護保険特定負担限度額申請書の帳票データの設定処理です。
     * @param source 護保険特定負担限度額申請書の帳票データ
     * @return 護保険特定負担限度額申請書の帳票データ
     */
    @Override
    public TokuteiFutangendogakuShinseishoReportSource edit(TokuteiFutangendogakuShinseishoReportSource source) {
        return editSource(source);
    }

    private TokuteiFutangendogakuShinseishoReportSource editSource(TokuteiFutangendogakuShinseishoReportSource source) {

        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.hokenshaNo = item.getHokenshaNo();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.shisetsuYubinNo = item.getShisetsuYubinNo();
        source.shisetsuJusho = item.getShisetsuJusho();
        source.shisetsuMeisho = item.getShisetsuMeisho();
        source.shisetsuTelNo = item.getShisetsuTelNo();
        source.remban = item.getRemban();

        return source;
    }
}
