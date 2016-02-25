/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * 認定調査依頼発行一覧表_帳票パラメータクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiHakkoIchiranhyoItem {

    private final ChosaIraiHakkoIchiranhyoHeadItem headItem;
    private final ChosaIraiHakkoIchiranhyoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医意見書作成依頼発行一覧表ヘッダのITEM
     * @param bodyItem 主治医意見書作成依頼発行一覧表ボディのITEM
     */
    public ChosaIraiHakkoIchiranhyoItem(
            ChosaIraiHakkoIchiranhyoHeadItem headItem,
            ChosaIraiHakkoIchiranhyoBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
