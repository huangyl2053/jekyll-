/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoshujiiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医医療機関・主治医一覧表ヘッダのITEMです。
 *
 * @reamsid_L DBE-0260-020 zuotao
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoShujiiIchiranHeadItem {

    private final RString iryoKikanCodeFrom;
    private final RString iryoKikanCodeTo;
    private final RString shujiiCodeFrom;
    private final RString shujiiCodeTo;
    private final RString shujiiJokyo;
    private final RString sort;
    private final RString page;

    /**
     * インスタンスを生成します。
     *
     * @param iryoKikanCodeFrom 主治医医療機関コードFrom
     * @param iryoKikanCodeTo 主治医医療機関コードTo
     * @param shujiiCodeFrom 主治医コードFrom
     * @param shujiiCodeTo 主治医コードTo
     * @param shujiiJokyo 主治医の状況判定
     * @param sort 並び順
     * @param page 改頁
     */
    public IkenshoShujiiIchiranHeadItem(
            RString iryoKikanCodeFrom,
            RString iryoKikanCodeTo,
            RString shujiiCodeFrom,
            RString shujiiCodeTo,
            RString shujiiJokyo,
            RString sort,
            RString page) {
        
        this.iryoKikanCodeFrom = iryoKikanCodeFrom;
        this.iryoKikanCodeTo = iryoKikanCodeTo;
        this.shujiiCodeFrom = shujiiCodeFrom;
        this.shujiiCodeTo = shujiiCodeTo;
        this.shujiiJokyo = shujiiJokyo;
        this.sort = sort;
        this.page = page;
    }
}
