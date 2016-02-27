/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import java.util.List;

/**
 *
 * 認定調査依頼一覧表作成_帳票パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoReportJoho {

    private final ChosaIraiIchiranhyoHeadItem headItem;
    private final List<ChosaIraiIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 認定調査依頼一覧情報ヘッダ
     * @param bodyItemList 認定調査依頼一覧情報ボディリスト
     */
    public ChosaIraiIchiranhyoReportJoho(
            ChosaIraiIchiranhyoHeadItem headItem,
            List<ChosaIraiIchiranhyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
