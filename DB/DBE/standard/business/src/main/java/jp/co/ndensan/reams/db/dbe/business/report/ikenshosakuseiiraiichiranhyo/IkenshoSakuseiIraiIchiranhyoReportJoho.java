/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import java.util.List;

/**
 * 主治医意見書作成依頼一覧_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoSakuseiIraiIchiranhyoReportJoho {

    private final IkenshoSakuseiIraiIchiranhyoHeadItem headItem;
    private final List<IkenshoSakuseiIraiIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 主治医意見書作成依頼一覧
     * @param bodyItemList 主治医意見書作成依頼一覧リスト
     */
    public IkenshoSakuseiIraiIchiranhyoReportJoho(IkenshoSakuseiIraiIchiranhyoHeadItem headItem,
            List<IkenshoSakuseiIraiIchiranhyoBodyItem> bodyItemList) {
        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
