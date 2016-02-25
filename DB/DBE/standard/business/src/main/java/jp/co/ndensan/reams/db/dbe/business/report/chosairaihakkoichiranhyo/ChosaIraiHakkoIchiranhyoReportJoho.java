/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import java.util.List;

/**
 * 認定調査依頼発行一覧表作成_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiHakkoIchiranhyoReportJoho {

    private final ChosaIraiHakkoIchiranhyoHeadItem headItem;
    private final List<ChosaIraiHakkoIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 主治医意見書作成依頼発行一覧情報ヘッダ
     * @param bodyItemList 主治医意見書作成依頼発行一覧情報ボディリスト
     */
    public ChosaIraiHakkoIchiranhyoReportJoho(
            ChosaIraiHakkoIchiranhyoHeadItem headItem,
            List<ChosaIraiHakkoIchiranhyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
