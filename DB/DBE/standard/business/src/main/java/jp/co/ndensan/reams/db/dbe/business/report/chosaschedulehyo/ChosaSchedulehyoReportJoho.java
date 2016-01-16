/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import java.util.List;

/**
 * 認定調査スケジュール登録・認定調査スケジュール表(事務所)作成_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoReportJoho {

    private final ChosaSchedulehyoHeadItem headItem;
    private final List<ChosaSchedulehyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 認定調査スケジュール表(事務所)ヘッダ
     * @param bodyItemList 認定調査スケジュール表(事務所)ボディリスト
     */
    public ChosaSchedulehyoReportJoho(
            ChosaSchedulehyoHeadItem headItem,
            List<ChosaSchedulehyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
