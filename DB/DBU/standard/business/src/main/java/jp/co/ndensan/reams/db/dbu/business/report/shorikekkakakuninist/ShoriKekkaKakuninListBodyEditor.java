/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;

/**
 * 処理確認リストボディEditorです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
class ShoriKekkaKakuninListBodyEditor implements IShoriKekkaKakuninListEditor {

    private final ShoriKekkaKakuninListBodyItem tempItem;

    /**
     * インスタンスを生成します。
     *
     * @param tempItem {@link ShoriKekkaKakuninListBodyItem}
     */
    protected ShoriKekkaKakuninListBodyEditor(ShoriKekkaKakuninListBodyItem tempItem) {
        this.tempItem = tempItem;
    }

    /**
     * 処理確認リストボディEditorです。
     *
     * @param source 処理確認リストSource
     * @return 処理確認リストSource
     */
    @Override
    public ShoriKekkaKakuninListReportSource edit(ShoriKekkaKakuninListReportSource source) {
        return editBody(source);
    }

    private ShoriKekkaKakuninListReportSource editBody(ShoriKekkaKakuninListReportSource source) {
        source.listUpper_1 = tempItem.getListUpper_1();
        source.listUpper_2 = tempItem.getListUpper_2();
        source.listUpper_3 = tempItem.getListUpper_3();
        source.listUpper_4 = tempItem.getListUpper_4();
        source.listUpper_5 = tempItem.getListUpper_5();
        source.listUpper_6 = tempItem.getListUpper_6();
        source.listUpper_7 = tempItem.getListUpper_7();
        source.listLower_1 = tempItem.getListLower_1();
        source.listLower_2 = tempItem.getListLower_2();
        return source;
    }

}
