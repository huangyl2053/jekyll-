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
public class TsukibetsuSuiihyoHeaderEditorImpl implements ITsukibetsuSuiihyoEditor {

    private final TsukibetsuSuiihyoHeaderItem item;

    /**
     * コンストラクタです。
     *
     * @param item TsukibetsuSuiihyoHeaderItem
     */
    public TsukibetsuSuiihyoHeaderEditorImpl(TsukibetsuSuiihyoHeaderItem item) {
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
        source.printTimeStamp = item.getPrintTimeStamp();
        source.gengo = item.getGengo();
        source.nendo = item.getNendo();
        source.hokenshaNo = item.getHokenshaNo();
        source.hokenshaName = item.getHokenshaName();
        source.listTitle_1 = item.getListTitle_1();
        source.choshuHouhouTitle = item.getChoshuHouhouTitle();
        source.ninsuGokeiTitle = item.getNinsuGokeiTitle();
        source.kingakuGokeiTitle = item.getKingakuGokeiTitle();
        return source;
    }
}
