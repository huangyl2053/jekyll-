/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import java.util.List;
import lombok.Getter;

/**
 *
 * 調査委託先・調査員一覧表作成_帳票クラスパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItakusakiChosainIchiranReportJoho {
    
    private final ItakusakiChosainIchiranHeadItem headItem;
    private final List<ItakusakiChosainIchiranBodyItem> bodyItemList;
    
    /**
     * コンストラクタを作成します。
     * @param headItem 調査委託先・調査員一覧表ヘッダ
     * @param bodyItemList 調査委託先・調査員一覧表ボディリスト
     */
    public ItakusakiChosainIchiranReportJoho(ItakusakiChosainIchiranHeadItem headItem,
            List<ItakusakiChosainIchiranBodyItem> bodyItemList) {
        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
    
    
}
