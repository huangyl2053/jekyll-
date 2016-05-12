/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo.ShinsakaishukeihyoBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo.ShinsakaishukeihyoReportSource;

/**
 * 介護認定審査会集計表（判定別）のEditorです。
 *
 * @reamsid_L DBE-1450-070 dongyabin
 */
public class ShinsakaishukeihyoBodyEditor implements IShinsakaishukeihyoBodyEditor {

    private final ShinsakaishukeihyoBody item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected ShinsakaishukeihyoBodyEditor(ShinsakaishukeihyoBody item) {
        this.item = item;
    }

    @Override
    public ShinsakaishukeihyoReportSource edit(ShinsakaishukeihyoReportSource source) {
        return editSource(source);
    }

    private ShinsakaishukeihyoReportSource editSource(ShinsakaishukeihyoReportSource source) {
        source.listHantei1_1 = item.getListHantei1_1();
        source.listHantei1_2 = item.getListHantei1_2();
        source.listHantei1_3 = item.getListHantei1_3();
        source.listHantei1_4 = item.getListHantei1_4();
        source.listHantei1_5 = item.getListHantei1_5();
        source.listHantei1_6 = item.getListHantei1_6();
        source.listHantei1_7 = item.getListHantei1_7();
        source.listHantei1_8 = item.getListHantei1_8();
        source.listHantei1_9 = item.getListHantei1_9();
        source.listHantei1_10 = item.getListHantei1_10();
        return source;
    }
}
