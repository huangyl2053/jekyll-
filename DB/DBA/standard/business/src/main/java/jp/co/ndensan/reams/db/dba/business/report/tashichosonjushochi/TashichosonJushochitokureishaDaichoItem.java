/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi;

import lombok.Getter;
import lombok.Setter;

/**
 * 他市町村住所地特例者台帳パラメータクラスです。
 *
 * @reamsid_L DBA-0402-030 xuyannan
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TashichosonJushochitokureishaDaichoItem {

    private final TashichosonJushochitokureishaDaichoHeadItem headItem;
    private final TashichosonJushochitokureishaDaichoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 他市町村住所地特例者台帳ヘッダのITEM
     * @param bodyItem 他市町村住所地特例者台帳ボディのITEM
     */
    public TashichosonJushochitokureishaDaichoItem(
            TashichosonJushochitokureishaDaichoHeadItem headItem,
            TashichosonJushochitokureishaDaichoBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
