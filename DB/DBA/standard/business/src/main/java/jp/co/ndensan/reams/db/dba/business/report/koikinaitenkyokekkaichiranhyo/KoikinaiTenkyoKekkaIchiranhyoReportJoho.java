/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo;

import java.util.List;

/**
 * 広域内転居結果一覧表作成_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiTenkyoKekkaIchiranhyoReportJoho {

    private final KoikinaiTenkyoKekkaIchiranhyoHeadItem headItem;
    private final List<KoikinaiTenkyoKekkaIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 広域内転居結果一覧表ヘッダ
     * @param bodyItemList 広域内転居結果一覧表ボディリスト
     */
    public KoikinaiTenkyoKekkaIchiranhyoReportJoho(
            KoikinaiTenkyoKekkaIchiranhyoHeadItem headItem,
            List<KoikinaiTenkyoKekkaIchiranhyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
