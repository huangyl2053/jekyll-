/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import java.util.List;

/**
 *
 * 認定調査スケジュール表(時間管理)クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoJikankanriReportJoho {

    private final ChosaSchedulehyoJikankanriHeadItem headItem;
    private final List<ChosaSchedulehyoJikankanriBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 認定調査スケジュール表(時間管理)ヘッダ
     * @param bodyItemList 認定調査スケジュール表(時間管理)ィリスト
     */
    public ChosaSchedulehyoJikankanriReportJoho(
            ChosaSchedulehyoJikankanriHeadItem headItem,
            List<ChosaSchedulehyoJikankanriBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
