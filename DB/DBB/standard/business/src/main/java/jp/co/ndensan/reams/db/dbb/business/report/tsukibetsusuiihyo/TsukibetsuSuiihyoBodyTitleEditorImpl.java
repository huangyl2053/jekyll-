/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;

/**
 * 月別推移表ボディのTitleEditorです。
 *
 * @reamsid_L DBB-0760-050 wangxiaodong
 */
public class TsukibetsuSuiihyoBodyTitleEditorImpl implements ITsukibetsuSuiihyoEditor {

    private final TsukibetsuSuiihyoBodyTitleItem bodyTitleItem;

    /**
     * コンストラクタです。
     *
     * @param bodyTitleItem 月別推移表ボディのITEM
     */
    public TsukibetsuSuiihyoBodyTitleEditorImpl(TsukibetsuSuiihyoBodyTitleItem bodyTitleItem) {
        this.bodyTitleItem = bodyTitleItem;
    }

    /**
     * 月別推移表ボディエディターです。
     *
     * @param source 月別推移表
     * @return TsukibetsuSuiihyoReportSource
     */
    @Override
    public TsukibetsuSuiihyoReportSource edit(TsukibetsuSuiihyoReportSource source) {
        return editBodyTitle(source);
    }

    private TsukibetsuSuiihyoReportSource editBodyTitle(TsukibetsuSuiihyoReportSource source) {

        source.listTitle_1 = bodyTitleItem.getListTitle_1();

        return source;
    }
}
