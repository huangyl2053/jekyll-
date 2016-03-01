/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import java.util.List;
import lombok.Getter;

/**
 *
 * 被保険者証発行管理一覧表_帳票クラスパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshashoHakkoKanriIchiranhyoReportJoho {

    private final HihokenshashoHakkoKanriIchiranhyoHeadItem headItem;
    private final List<HihokenshashoHakkoKanriIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 被保険者証発行管理一覧表ヘッダ
     * @param bodyItemList 被保険者証発行管理一覧表ボディリスト
     */
    public HihokenshashoHakkoKanriIchiranhyoReportJoho(HihokenshashoHakkoKanriIchiranhyoHeadItem headItem,
            List<HihokenshashoHakkoKanriIchiranhyoBodyItem> bodyItemList) {
        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }

}
