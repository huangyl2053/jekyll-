/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;

/**
 *
 * 月別推移表ヘッダのEditorです。
 */
public class TsukibetsuSuiihyoHeaderEditorImpl implements ITsukibetsuSuiihyoEditor {

    private final TsukibetsuSuiihyoHeaderItem item;

    /**
     * コンストラクタです。
     *
     * @param item 月別推移表ヘッダのITEM
     */
    public TsukibetsuSuiihyoHeaderEditorImpl(TsukibetsuSuiihyoHeaderItem item) {
        this.item = item;
    }

    /**
     * 月別推移表ヘッダエディターです。
     *
     * @param source 月別推移表
     * @return TsukibetsuSuiihyoReportSource
     */
    @Override
    public TsukibetsuSuiihyoReportSource edit(TsukibetsuSuiihyoReportSource source) {
        return editHeader(source);
    }

    private TsukibetsuSuiihyoReportSource editHeader(TsukibetsuSuiihyoReportSource source) {

        source.printTimeStamp = item.getPrintTimeStamp();
        source.gengo = item.getGengo();
        source.nendo = item.getNendo();
        source.hokenshaNo = item.getHokenshaNo();
        source.hokenshaName = item.getHokenshaName();
        source.choshuHouhouTitle = item.getChoshuHouhouTitle();
        source.ninsuGokeiTitle = item.getNinsuGokeiTitle();
        source.kingakuGokeiTitle = item.getKingakuGokeiTitle();

        return source;
    }
}
