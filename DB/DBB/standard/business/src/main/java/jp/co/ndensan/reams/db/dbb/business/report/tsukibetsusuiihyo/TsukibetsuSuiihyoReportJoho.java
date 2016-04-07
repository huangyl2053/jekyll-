/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import java.util.List;

/**
 *
 * 月別推移表票パラメータクラスです。
 *
 * @reamsid_L DBB-0760-050 wangxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuSuiihyoReportJoho {

    private final TsukibetsuSuiihyoHeaderItem headItem;
    private final List<TsukibetsuSuiihyoBodyTitleItem> bodyTitleItem;
    private final List<TsukibetsuSuiihyoBodyItem> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 月別推移表ヘッダのITEM
     * @param bodyTitleItem 月別推移表ボディのTitleItemリスト
     * @param bodyItemList 月別推移表ボディのITEMリスト
     */
    public TsukibetsuSuiihyoReportJoho(
            TsukibetsuSuiihyoHeaderItem headItem,
            List<TsukibetsuSuiihyoBodyTitleItem> bodyTitleItem,
            List<TsukibetsuSuiihyoBodyItem> bodyItemList) {
        this.headItem = headItem;
        this.bodyTitleItem = bodyTitleItem;
        this.bodyItemList = bodyItemList;
    }
}
