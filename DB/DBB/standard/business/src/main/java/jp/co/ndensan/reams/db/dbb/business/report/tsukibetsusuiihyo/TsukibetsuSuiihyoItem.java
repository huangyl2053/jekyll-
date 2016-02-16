/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

/**
 *
 * 月別推移表のITEMです。
 */
public class TsukibetsuSuiihyoItem {

    public final TsukibetsuSuiihyoHeaderItem headItem;
    public final TsukibetsuSuiihyoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 月別推移表ヘッダのITEM
     * @param bodyItem 月別推移表ボディのITEM
     */
    public TsukibetsuSuiihyoItem(
            TsukibetsuSuiihyoHeaderItem headItem,
            TsukibetsuSuiihyoBodyItem bodyItem) {
        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
