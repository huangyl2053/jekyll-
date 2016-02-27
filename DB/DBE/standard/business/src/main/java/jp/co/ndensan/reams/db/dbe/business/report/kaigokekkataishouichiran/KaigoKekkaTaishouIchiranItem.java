/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import lombok.Getter;

/**
 * 要介護認定結果通知書対象者一覧表のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKekkaTaishouIchiranItem {

    private final KaigoKekkaTaishouIchiranHeadItem headItem;
    private final KaigoKekkaTaishouIchiranBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定結果通知書対象者一覧表ヘッダのITEM
     * @param bodyItem 要介護認定結果通知書対象者一覧表ボディのITEM
     */
    public KaigoKekkaTaishouIchiranItem(
            KaigoKekkaTaishouIchiranHeadItem headItem,
            KaigoKekkaTaishouIchiranBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
