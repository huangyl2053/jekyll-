/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import lombok.Getter;

/**
 *
 * 認定調査スケジュール表(調査員)のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoTyousayinItem {

    private final ChosaSchedulehyoTyousayinHeadItem headItem;
    private final ChosaSchedulehyoTyousayinBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール表(調査員)ヘッダのITEM
     * @param bodyItem 認定調査スケジュール表(調査員)ボディのITEM
     */
    public ChosaSchedulehyoTyousayinItem(
            ChosaSchedulehyoTyousayinHeadItem headItem,
            ChosaSchedulehyoTyousayinBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
