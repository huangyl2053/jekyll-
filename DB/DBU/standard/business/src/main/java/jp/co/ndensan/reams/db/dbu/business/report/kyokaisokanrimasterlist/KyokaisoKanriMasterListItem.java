/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyokaisokanrimasterlist;

import lombok.Getter;

/**
 * 境界層管理マスタリストのITEMです。
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
