/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会集計表（現在の状況別）のEditorです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoEditor implements IShinsakaiShukeiGenzainojokyoEditor {

    private static final int 数字6 = 6;
    private final ShinsakaiShukeiGenzainojokyo item;
    private final int count;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaiShukeiGenzainojokyo}
     * @param count {@link int}
     */
    protected ShinsakaiShukeiGenzainojokyoEditor(ShinsakaiShukeiGenzainojokyo item, int count) {
        this.item = item;
        this.count = count;
    }

    @Override
    public ShinsakaiShukeiGenzainojokyoReportSource edit(ShinsakaiShukeiGenzainojokyoReportSource source) {
        return editSource(source);
    }

    private ShinsakaiShukeiGenzainojokyoReportSource editSource(ShinsakaiShukeiGenzainojokyoReportSource source) {
        source.listShukei1_1 = get集計値(item.getListShukei1_1());
        source.listShukei1_2 = get集計値(item.getListShukei1_2());
        source.listShukei1_3 = get集計値(item.getListShukei1_3());
        source.listShukei1_4 = get集計値(item.getListShukei1_4());
        source.listShukei1_5 = get集計値(item.getListShukei1_5());
        source.listShukei1_6 = get集計値(item.getListShukei1_6());
        source.listShukei1_7 = get集計値(item.getListShukei1_7());
        source.listShukei1_8 = get集計値(item.getListShukei1_8());
        source.listShukei2_1 = get集計値(item.getListShukei2_1());
        source.listShukei2_2 = get集計値(item.getListShukei2_2());
        source.listShukei2_3 = get集計値(item.getListShukei2_3());
        source.listShukei2_4 = get集計値(item.getListShukei2_4());
        source.listShukei2_5 = get集計値(item.getListShukei2_5());
        source.listShukei2_6 = get集計値(item.getListShukei2_6());
        source.listShukei2_7 = get集計値(item.getListShukei2_7());
        source.listShukei2_8 = get集計値(item.getListShukei2_8());
        source.listShukei3_1 = get集計値(item.getListShukei3_1());
        source.listShukei3_2 = get集計値(item.getListShukei3_2());
        source.listShukei3_3 = get集計値(item.getListShukei3_3());
        source.listShukei3_4 = get集計値(item.getListShukei3_4());
        source.listShukei3_5 = get集計値(item.getListShukei3_5());
        source.listShukei3_6 = get集計値(item.getListShukei3_6());
        source.listShukei3_7 = get集計値(item.getListShukei3_7());
        source.listShukei3_8 = get集計値(item.getListShukei3_8());
        source.listShukei4_1 = get集計値(item.getListShukei4_1());
        source.listShukei4_2 = get集計値(item.getListShukei4_2());
        source.listShukei4_3 = get集計値(item.getListShukei4_3());
        source.listShukei4_4 = get集計値(item.getListShukei4_4());
        source.listShukei4_5 = get集計値(item.getListShukei4_5());
        source.listShukei4_6 = get集計値(item.getListShukei4_6());
        source.listShukei4_7 = get集計値(item.getListShukei4_7());
        source.listShukei4_8 = get集計値(item.getListShukei4_8());
        if (count < 数字6) {
            source.listShukei5_1 = get集計値(item.getListShukei5_1());
            source.listShukei5_2 = get集計値(item.getListShukei5_2());
            source.listShukei5_3 = get集計値(item.getListShukei5_3());
            source.listShukei5_4 = get集計値(item.getListShukei5_4());
            source.listShukei5_5 = get集計値(item.getListShukei5_5());
            source.listShukei5_6 = get集計値(item.getListShukei5_6());
            source.listShukei5_7 = get集計値(item.getListShukei5_7());
            source.listShukei5_8 = get集計値(item.getListShukei5_8());
        }
        return source;
    }
    
    private RString get集計値(RString shukei) {
        return !RString.isNullOrEmpty(shukei) ? shukei : new RString("0");
    }

}
