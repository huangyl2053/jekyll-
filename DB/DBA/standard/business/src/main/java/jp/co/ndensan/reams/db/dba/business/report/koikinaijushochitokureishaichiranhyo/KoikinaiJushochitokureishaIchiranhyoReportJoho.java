/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import java.util.List;

/**
 * 広域内住所地特例者一覧表作成_帳票クラスパラメータクラスです。
 *
 * @reamsid_L DBU-1140-060 linghuhang
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiJushochitokureishaIchiranhyoReportJoho {

    private final KoikinaiJushochitokureishaIchiranhyoHead headItem;
    private final List<KoikinaiJushochitokureishaIchiranhyoBody> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 広域内住所地特例者一覧表ヘッダ
     * @param bodyItemList 広域内住所地特例者一覧表ボディリスト
     */
    public KoikinaiJushochitokureishaIchiranhyoReportJoho(
            KoikinaiJushochitokureishaIchiranhyoHead headItem,
            List<KoikinaiJushochitokureishaIchiranhyoBody> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
