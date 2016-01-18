/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import lombok.Getter;

/**
 * 認定調査スケジュール登録・認定調査スケジュール表(事務所)のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoItem {

    private final ChosaSchedulehyoHeadItem headItem;
    private final ChosaSchedulehyoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール登録・認定調査スケジュール表(事務所)ヘッダのITEM
     * @param bodyItem 認定調査スケジュール登録・認定調査スケジュール表(事務所)ボディのITEM
     */
    public ChosaSchedulehyoItem(
            ChosaSchedulehyoHeadItem headItem,
            ChosaSchedulehyoBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
