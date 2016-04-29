/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import java.util.List;

/**
 * 適用除外者台帳クラスパラメータクラスです。
 *
 * @reamsid_L DBA-0412-040 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyojogaishaDaichoReportJoho {

    private final List<TekiyojogaishaDaichoItem> itemList;

    /**
     * コンストラクタを作成します。
     *
     * @param itemList 適用除外者台帳ボディリスト
     */
    public TekiyojogaishaDaichoReportJoho(
            List<TekiyojogaishaDaichoItem> itemList) {

        this.itemList = itemList;
    }
}
