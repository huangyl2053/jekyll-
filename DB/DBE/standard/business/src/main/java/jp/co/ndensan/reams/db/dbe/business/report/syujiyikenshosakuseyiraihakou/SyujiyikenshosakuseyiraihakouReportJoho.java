/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou;

import java.util.List;

/**
 * 主治医意見書作成依頼発行一覧表作成_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyujiyikenshosakuseyiraihakouReportJoho {

    private final SyujiyikenshosakuseyiraihakouHeadItem headItem;
    private final List<SyujiyikenshosakuseyiraihakouBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 主治医意見書作成依頼発行一覧情報ヘッダ
     * @param bodyItemList 主治医意見書作成依頼発行一覧情報ボディリスト
     */
    public SyujiyikenshosakuseyiraihakouReportJoho(
            SyujiyikenshosakuseyiraihakouHeadItem headItem,
            List<SyujiyikenshosakuseyiraihakouBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
