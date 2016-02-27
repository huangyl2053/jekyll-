/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou;

import lombok.Getter;

/**
 * 主治医意見書作成依頼発行一覧表のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyujiyikenshosakuseyiraihakouItem {

    private final SyujiyikenshosakuseyiraihakouHeadItem headItem;
    private final SyujiyikenshosakuseyiraihakouBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医意見書作成依頼発行一覧表ヘッダのITEM
     * @param bodyItem 主治医意見書作成依頼発行一覧表ボディのITEM
     */
    public SyujiyikenshosakuseyiraihakouItem(
            SyujiyikenshosakuseyiraihakouHeadItem headItem,
            SyujiyikenshosakuseyiraihakouBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
