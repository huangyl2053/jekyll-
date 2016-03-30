/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import java.util.List;

/**
 * 適用除外者台帳クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyojogaishaDaichoReportJoho {

    private final TekiyojogaishaDaichoHeadItem headItem;
    private final List<TekiyojogaishaDaichoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 適用除外者台帳ヘッダ
     * @param bodyItemList 適用除外者台帳ボディリスト
     */
    public TekiyojogaishaDaichoReportJoho(
            TekiyojogaishaDaichoHeadItem headItem,
            List<TekiyojogaishaDaichoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
