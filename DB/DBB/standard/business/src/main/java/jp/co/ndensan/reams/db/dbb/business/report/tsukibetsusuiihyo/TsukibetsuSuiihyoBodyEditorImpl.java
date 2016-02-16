/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;

/**
 *
 * @author soft863
 */
public class TsukibetsuSuiihyoBodyEditorImpl implements ITsukibetsuSuiihyoEditor {

    private final TsukibetsuSuiihyoBodyItem item;

    /**
     * コンストラクタです。
     *
     * @param item TsukibetsuSuiihyoHeaderItem
     */
    public TsukibetsuSuiihyoBodyEditorImpl(TsukibetsuSuiihyoBodyItem item) {
        this.item = item;
    }

    /**
     * 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書エディターです。
     *
     * @param source 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書
     * @return TsukibetsuSuiihyoReportSource
     */
    @Override
    public TsukibetsuSuiihyoReportSource edit(TsukibetsuSuiihyoReportSource source) {
        return editBody(source);
    }

    private TsukibetsuSuiihyoReportSource editBody(TsukibetsuSuiihyoReportSource source) {

        source.list_1 = item.getList_1();
        source.list_2 = item.getList_2();
        source.list_3 = item.getList_3();
        source.list_4 = item.getList_4();
        source.list_5 = item.getList_5();
        source.list_6 = item.getList_6();
        source.list_7 = item.getList_7();
        source.list_8 = item.getList_8();
        source.list_9 = item.getList_9();
        source.list_10 = item.getList_10();
        source.list_11 = item.getList_11();
        source.list_12 = item.getList_12();
        source.list_13 = item.getList_13();
        source.list_14 = item.getList_14();
        source.list_15 = item.getList_15();
        source.list_16 = item.getList_16();

        return source;
    }
}
