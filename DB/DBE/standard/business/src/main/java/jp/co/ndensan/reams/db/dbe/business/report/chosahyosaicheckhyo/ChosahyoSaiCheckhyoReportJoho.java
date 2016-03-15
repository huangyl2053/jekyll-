/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo;

import java.util.List;

/**
 * 前回認定調査結果との比較表_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoSaiCheckhyoReportJoho {

    private final List<ChosahyoSaiCheckhyoItem> itemList;

    /**
     * コンストラクタを作成します。
     *
     * @param itemList 前回認定調査結果との比較表itemList
     */
    public ChosahyoSaiCheckhyoReportJoho(List<ChosahyoSaiCheckhyoItem> itemList) {
        this.itemList = itemList;
    }
}
