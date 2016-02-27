/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import lombok.Getter;

/**
 *
 * 認定調査スケジュール表(時間管理)のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoJikankanriItem {

    private final ChosaSchedulehyoJikankanriHeadItem headItem;
    private final ChosaSchedulehyoJikankanriBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール表(時間管理)ヘッダのITEM
     * @param bodyItem 認定調査スケジュール表(時間管理)ボディのITEM
     */
    public ChosaSchedulehyoJikankanriItem(
            ChosaSchedulehyoJikankanriHeadItem headItem,
            ChosaSchedulehyoJikankanriBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
