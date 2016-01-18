/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * 認定調査依頼一覧表ボディEditorです。
 */
class ChosaIraiIchiranhyoBodyEditor implements IChosaIraiIchiranhyoEditor {

    private final ChosaIraiIchiranhyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaIraiIchiranhyoBodyItem}
     */
    protected ChosaIraiIchiranhyoBodyEditor(ChosaIraiIchiranhyoBodyItem item) {
        this.item = item;
    }

    @Override
    public ChosaIraiIchiranhyoReportSource edit(ChosaIraiIchiranhyoReportSource source) {
        return editBody(source);
    }

    private ChosaIraiIchiranhyoReportSource editBody(ChosaIraiIchiranhyoReportSource source) {
        source.listIchiranhyo_1 = item.getListIchiranhyo_1();
        source.listIchiranhyo_2 = item.getListIchiranhyo_2();
        source.listIchiranhyo_3 = item.getListIchiranhyo_3();
        source.listIchiranhyo_4 = new RDate(item.getListIchiranhyo_4().toString()).wareki().fillType(FillType.ZERO).toDateString();
        source.listIchiranhyo_5 = item.getListIchiranhyo_5();
        source.listIchiranhyo_6 = item.getListIchiranhyo_6();
        source.listIchiranhyo_7 = item.getListIchiranhyo_7();
        source.listIchiranhyo_8 = item.getListIchiranhyo_8();
        source.listIchiranhyo_9 = new RDate(item.getListIchiranhyo_9().toString()).wareki().fillType(FillType.ZERO).toDateString();
        source.listIchiranhyo_10 = item.getListIchiranhyo_10();
        source.listIchiranhyo_11 = item.getListIchiranhyo_11();
        source.listIchiranhyo_12 = new RDate(item.getListIchiranhyo_12().toString()).wareki().fillType(FillType.ZERO).toDateString();
        return source;
    }
}
