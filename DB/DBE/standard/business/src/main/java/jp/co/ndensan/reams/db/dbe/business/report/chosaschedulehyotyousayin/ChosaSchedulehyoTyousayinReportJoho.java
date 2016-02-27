/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import java.util.List;

/**
 *
 * 認定調査スケジュール表(調査員)作成_帳票パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoTyousayinReportJoho {

    private final ChosaSchedulehyoTyousayinHeadItem headItem;
    private final List<ChosaSchedulehyoTyousayinBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 認定調査スケジュール表(調査員)ヘッダ
     * @param bodyItemList 認定調査スケジュール表(調査員)ボディリスト
     */
    public ChosaSchedulehyoTyousayinReportJoho(
            ChosaSchedulehyoTyousayinHeadItem headItem,
            List<ChosaSchedulehyoTyousayinBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
