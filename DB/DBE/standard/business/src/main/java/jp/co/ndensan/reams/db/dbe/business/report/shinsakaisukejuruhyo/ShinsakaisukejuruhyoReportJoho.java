/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import java.util.List;

/**
 * 介護認定審査会スケジュール表_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaisukejuruhyoReportJoho {

    private final ShinsakaisukejuruhyoHeadItem headItem;
    private final List<ShinsakaisukejuruhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 介護認定審査会スケジュール表ヘッダ
     * @param bodyItemList 介護認定審査会スケジュール表ボディリスト
     */
    public ShinsakaisukejuruhyoReportJoho(
            ShinsakaisukejuruhyoHeadItem headItem,
            List<ShinsakaisukejuruhyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
