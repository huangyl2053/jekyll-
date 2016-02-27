/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import java.util.List;

/**
 * 広域内住所地特例者一覧表作成_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiJushochitokureishaIchiranhyoReportJoho {

    private final KoikinaiJushochitokureishaIchiranhyoHeadItem headItem;
    private final List<KoikinaiJushochitokureishaIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 広域内住所地特例者一覧表ヘッダ
     * @param bodyItemList 広域内住所地特例者一覧表ボディリスト
     */
    public KoikinaiJushochitokureishaIchiranhyoReportJoho(
            KoikinaiJushochitokureishaIchiranhyoHeadItem headItem,
            List<KoikinaiJushochitokureishaIchiranhyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
