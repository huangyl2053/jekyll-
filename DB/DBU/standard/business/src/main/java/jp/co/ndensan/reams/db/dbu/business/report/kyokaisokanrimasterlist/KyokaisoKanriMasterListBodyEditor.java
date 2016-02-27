/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist;

import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;

/**
 * 境界層管理マスタリストボディEditorです。
 */
class KyokaisoKanriMasterListBodyEditor implements IKyokaisoKanriMasterListEditor {

    private final KyokaisoKanriMasterListBodyTempItem tempItem;

    /**
     * インスタンスを生成します。
     *
     * @param tempItem {@link KyokaisoKanriMasterListBodyTempItem}
     */
    protected KyokaisoKanriMasterListBodyEditor(KyokaisoKanriMasterListBodyTempItem tempItem) {
        this.tempItem = tempItem;
    }

    /**
     * 境界層管理マスタリストボディEditorです。
     *
     * @param source 境界層管理マスタリストSource
     * @return 境界層管理マスタリストSource
     */
    @Override
    public KyokaisoKanriMasterListReportSource edit(KyokaisoKanriMasterListReportSource source) {
        return editBody(source);
    }

    private KyokaisoKanriMasterListReportSource editBody(KyokaisoKanriMasterListReportSource source) {

        source.listUpper_1 = tempItem.getListUpper_1();
        source.listUpper_2 = tempItem.getListUpper_2();
        source.listUpper_3 = tempItem.getListUpper_3();
        source.listUpper_4 = tempItem.getListUpper_4();
        source.listUpper_5 = tempItem.getListUpper_5();
        source.listUpper_6 = tempItem.getListUpper_6();
        source.listUpper_7 = tempItem.getListUpper_7();
        source.listUpper_8 = tempItem.getListUpper_8();
        source.listUpper_9 = tempItem.getListUpper_9();
        source.listLower_1 = tempItem.getListLower_1();
        source.listLower_2 = tempItem.getListLower_2();
        source.listLower_3 = tempItem.getListLower_3();
        source.listLower_4 = tempItem.getListLower_4();
        source.listLower_5 = tempItem.getListLower_5();
        source.listLower_6 = tempItem.getListLower_6();
        source.listLower_7 = tempItem.getListLower_7();
        source.listLower_8 = tempItem.getListLower_8();
        source.listLower_9 = tempItem.getListLower_9();
        source.listLower_10 = tempItem.getListLower_10();
        return source;
    }
}
