/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe5910001;

import java.util.List;

/**
 * 医療機関・主治医一覧表作成_帳票クラスパラメータクラスです。
 */
@lombok.Getter
public class IkenshoShujiiIchiranReportJoho {

    private final IkenshoShujiiIchiranHeadItem headItem;
    private final List<IkenshoShujiiIchiranBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 主治医一覧情報ヘッダ
     * @param bodyItemList 主治医一覧情報ボディリスト
     */
    public IkenshoShujiiIchiranReportJoho(
            IkenshoShujiiIchiranHeadItem headItem,
            List<IkenshoShujiiIchiranBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
