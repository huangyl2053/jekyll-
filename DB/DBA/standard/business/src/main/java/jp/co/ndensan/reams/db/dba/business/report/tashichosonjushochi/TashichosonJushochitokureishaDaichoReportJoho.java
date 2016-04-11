/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi;

import java.util.List;

/**
 * 他市町村住所地特例者台帳クラスパラメータクラスです。
 *
 * @reamsid_L DBA-0402-030 xuyannan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TashichosonJushochitokureishaDaichoReportJoho {

    private final TashichosonJushochitokureishaDaichoHeadItem headItem;
    private final List<TashichosonJushochitokureishaDaichoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 他市町村住所地特例者台帳ヘッダ
     * @param bodyItemList 他市町村住所地特例者台帳ボディリスト
     */
    public TashichosonJushochitokureishaDaichoReportJoho(
            TashichosonJushochitokureishaDaichoHeadItem headItem,
            List<TashichosonJushochitokureishaDaichoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
