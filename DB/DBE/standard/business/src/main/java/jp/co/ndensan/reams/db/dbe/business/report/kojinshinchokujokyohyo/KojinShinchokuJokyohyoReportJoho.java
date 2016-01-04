/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import java.util.List;

/**
 * 要介護認定個人進捗状況票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KojinShinchokuJokyohyoReportJoho {

    private final KojinShinchokuJokyohyoHeadItem headItem;
    private final List<chousaBodyItem> chousaItemList;
    private final List<shuiBodyItem> shujiItemList;
    private final List<KojinShinchokuJokyohyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 個人情報ヘッダ
     * @param chousaItemList 調査員情報リスト
     * @param shujiItemList 主治医情報リスト
     * @param bodyItemList 状態情報リスト
     */
    public KojinShinchokuJokyohyoReportJoho(
            KojinShinchokuJokyohyoHeadItem headItem,
            List<chousaBodyItem> chousaItemList,
            List<shuiBodyItem> shujiItemList,
            List<KojinShinchokuJokyohyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.chousaItemList = chousaItemList;
        this.shujiItemList = shujiItemList;
        this.bodyItemList = bodyItemList;
    }
}
