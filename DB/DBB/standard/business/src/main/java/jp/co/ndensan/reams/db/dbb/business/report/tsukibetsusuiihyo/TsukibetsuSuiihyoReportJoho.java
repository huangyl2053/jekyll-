/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import java.util.List;

/**
 *
 * 月別推移表票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuSuiihyoReportJoho {

    public final TsukibetsuSuiihyoHeaderItem headItem;
    public final List<TsukibetsuSuiihyoBodyItem> bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 月別推移表ヘッダのITEM
     * @param bodyItem 月別推移表ボディのITEM
     */
    public TsukibetsuSuiihyoReportJoho(
            TsukibetsuSuiihyoHeaderItem headItem,
            List<TsukibetsuSuiihyoBodyItem> bodyItem) {
        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
