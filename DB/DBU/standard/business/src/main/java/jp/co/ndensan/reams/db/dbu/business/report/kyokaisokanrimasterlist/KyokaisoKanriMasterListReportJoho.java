/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist;

import java.util.List;

/**
 * 境界層管理マスタリスト作成_帳票クラスパラメータクラスです。
 *
 * @reamsid_L DBU-1050-060 linghuhang
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyokaisoKanriMasterListReportJoho {

    private final KyokaisoKanriMasterListHeadItem headItem;
    private final List<KyokaisoKanriMasterListBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 境界層管理マスタリストヘッダ
     * @param bodyItemList 境界層管理マスタリストボディリスト
     */
    public KyokaisoKanriMasterListReportJoho(
            KyokaisoKanriMasterListHeadItem headItem,
            List<KyokaisoKanriMasterListBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}
