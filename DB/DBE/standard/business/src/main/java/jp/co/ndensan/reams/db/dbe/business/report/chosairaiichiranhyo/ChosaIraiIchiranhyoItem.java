/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import lombok.Getter;

/**
 *
 * 認定調査依頼一覧表のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoItem {

    private final ChosaIraiIchiranhyoHeadItem headItem;
    private final ChosaIraiIchiranhyoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査依頼一覧表ヘッダのITEM
     * @param bodyItem 認定調査依頼一覧表ボディのITEM
     */
    public ChosaIraiIchiranhyoItem(
            ChosaIraiIchiranhyoHeadItem headItem,
            ChosaIraiIchiranhyoBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
