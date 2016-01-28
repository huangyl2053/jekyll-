/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran;

import lombok.Getter;

/**
 * 主治医医療機関・主治医一覧表のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoShujiiIchiranItem {

    private final IkenshoShujiiIchiranHeadItem headItem;
    private final IkenshoShujiiIchiranBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医医療機関・主治医一覧表ヘッダのITEM
     * @param bodyItem 主治医医療機関・主治医一覧表ボディのITEM
     */
    public IkenshoShujiiIchiranItem(
            IkenshoShujiiIchiranHeadItem headItem,
            IkenshoShujiiIchiranBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
