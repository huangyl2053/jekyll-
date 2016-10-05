/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo;

import lombok.Getter;

/**
 * 認定調査依頼一覧表のITEMです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoItem {

    private final ChosaIraiIchiranhyoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 認定調査依頼一覧表ボディのITEM
     */
    public ChosaIraiIchiranhyoItem(
            ChosaIraiIchiranhyoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }
}
