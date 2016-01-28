/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 調査委託先・調査員一覧表ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItakusakiChosainIchiranHeadItem {
    
    private final RString iryoKikanCodeFrom;
    private final RString iryoKikanCodeTo;
    private final RString shujiiCodeFrom;
    private final RString shujiiCodeTo;
    private final RString shujiiJokyo;
    private final RString cityCode;
    private final RString cityName;
    private final RString sort;
    private final RString page;

    
    /**
     * インスタンスを生成します。
     * @param iryoKikanCodeFrom 認定調査委託先コードFrom
     * @param iryoKikanCodeTo 認定調査委託先コードTo
     * @param shujiiCodeFrom 調査員コードFrom
     * @param shujiiCodeTo 調査員コードTo
     * @param shujiiJokyo 調査員の状況判定
     * @param cityCode 市町村コード
     * @param cityName 市町村名
     * @param sort 並び順
     * @param page 改頁
     */
    public ItakusakiChosainIchiranHeadItem(RString iryoKikanCodeFrom,
            RString iryoKikanCodeTo,
            RString shujiiCodeFrom,
            RString shujiiCodeTo,
            RString shujiiJokyo,
            RString cityCode,
            RString cityName,
            RString sort,
            RString page) {
        this.iryoKikanCodeFrom = iryoKikanCodeFrom;
        this.iryoKikanCodeTo = iryoKikanCodeTo;
        this.shujiiCodeFrom = shujiiCodeFrom;
        this.shujiiCodeTo = shujiiCodeTo;
        this.shujiiJokyo = shujiiJokyo;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.sort = sort;
        this.page = page;
    }
    
}
