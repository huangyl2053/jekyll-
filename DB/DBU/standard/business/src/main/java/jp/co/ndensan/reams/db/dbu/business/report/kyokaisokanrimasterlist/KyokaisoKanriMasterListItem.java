/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist;

import lombok.Getter;

/**
 * 境界層管理マスタリストのITEMです。
 *
 * @reamsid_L DBU-1050-060 linghuhang
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyokaisoKanriMasterListItem {

    private final KyokaisoKanriMasterListHeadItem headItem;
    private final KyokaisoKanriMasterListBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 境界層管理マスタリスト
     * @param bodyItem 境界層管理マスタリスト
     */
    public KyokaisoKanriMasterListItem(
            KyokaisoKanriMasterListHeadItem headItem,
            KyokaisoKanriMasterListBodyItem bodyItem) {
        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
