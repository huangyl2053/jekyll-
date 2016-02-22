/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;

/**
 *
 * 認定調査依頼発行一覧表Editorです。
 */
public class ChosaIraiHakkoIchiranhyoEditor implements IChosaIraiHakkoIchiranhyoEditor {

    private final ChosaIraiHakkoIchiranhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaIraiHakkoIchiranhyoItem}
     */
    protected ChosaIraiHakkoIchiranhyoEditor(ChosaIraiHakkoIchiranhyoItem item) {
        this.item = item;
    }

    /**
     * 認定調査依頼発行一覧表編集処理です。
     *
     * @param source 認定調査依頼発行一覧表Sourceクラス
     * @return ChosaIraiHakkoIchiranhyoReportSource 認定調査依頼発行一覧表Sourceクラス
     */
    @Override
    public ChosaIraiHakkoIchiranhyoReportSource edit(ChosaIraiHakkoIchiranhyoReportSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
        source.joken0 = item.getJoken0();
        source.joken1 = item.getJoken1();
        source.joken2 = item.getJoken2();
        source.joken3 = item.getJoken3();
        source.joken4 = item.getJoken4();
        source.joken5 = item.getJoken5();
        source.cityCode = item.getCityCode();
        source.cityName = item.getCityName();
        source.headerHizukeKosho = item.getHeaderHizukeKosho();
        source.listHakkoIchiranhyo_1 = item.getListHakkoIchiranhyo_1();
        source.listHakkoIchiranhyo_2 = item.getListHakkoIchiranhyo_2();
        source.listHakkoIchiranhyo_3 = item.getListHakkoIchiranhyo_3();
        source.listHakkoIchiranhyo_4 = item.getListHakkoIchiranhyo_4();
        source.listHakkoIchiranhyo_5 = item.getListHakkoIchiranhyo_5();
        source.listHakkoIchiranhyo_6 = item.getListHakkoIchiranhyo_6();
        source.listHakkoIchiranhyo_7 = item.getListHakkoIchiranhyo_7();
        source.listHakkoIchiranhyo_8 = item.getListHakkoIchiranhyo_8();
        source.listHakkoIchiranhyo_9 = item.getListHakkoIchiranhyo_9();
        source.listHakkoIchiranhyo_10 = item.getListHakkoIchiranhyo_10();
        return source;
    }
}
