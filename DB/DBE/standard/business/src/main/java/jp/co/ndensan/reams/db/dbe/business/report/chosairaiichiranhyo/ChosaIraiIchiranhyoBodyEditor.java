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

    /**
     *
     * @param source 認定調査依頼一覧表Sourceクラスです
     * @return ChosaIraiIchiranhyoReportSource 認定調査依頼一覧表Sourceクラスです
     */
    @Override
    public ChosaIraiIchiranhyoReportSource edit(ChosaIraiIchiranhyoReportSource source) {
        return editBody(source);
    }

    private ChosaIraiIchiranhyoReportSource editBody(ChosaIraiIchiranhyoReportSource source) {
        source.listIchiranhyo_1 = item.getNo();
        source.listIchiranhyo_2 = item.getTyousayinnmeyi();
        source.listIchiranhyo_3 = item.getHihokennsyabanngou();
        source.listIchiranhyo_4 = new RDate(item.getSinnseyibi().toString()).wareki().fillType(FillType.BLANK).toDateString();
        source.listIchiranhyo_5 = item.getSinnseyikubunn();
        source.listIchiranhyo_6 = item.getHihokennsyameyi();
        source.listIchiranhyo_7 = item.getHihokennsyameyikaya();
        source.listIchiranhyo_8 = item.getSeyibetu();
        source.listIchiranhyo_9 = new RDate(item.getBirthYMD().toString()).wareki().fillType(FillType.BLANK).toDateString();
        source.listIchiranhyo_10 = item.getJyuusyo();
        source.listIchiranhyo_11 = item.getTelNo();
        source.listIchiranhyo_12 = new RDate(item.getTeyisyukigenn().toString()).wareki().fillType(FillType.BLANK).toDateString();
        return source;
    }
}
