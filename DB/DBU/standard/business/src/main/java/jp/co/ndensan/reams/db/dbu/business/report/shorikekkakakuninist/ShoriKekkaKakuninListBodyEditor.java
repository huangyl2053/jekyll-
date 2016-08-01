/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;

/**
 * 処理確認リストボディEditorです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
class ShoriKekkaKakuninListBodyEditor implements IShoriKekkaKakuninListEditor {

    private final ShoriKekkaKakuninListEntity tempItem;

    /**
     * インスタンスを生成します。
     *
     * @param tempItem {@link ShoriKekkaKakuninListBodyTempItem}
     */
    protected ShoriKekkaKakuninListBodyEditor(ShoriKekkaKakuninListEntity tempItem) {
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

        source.listUpper_1 = tempItem.getプログラムID();
        source.listUpper_2 = tempItem.get項目値1();
        source.listUpper_3 = tempItem.get項目値2();
        source.listUpper_4 = tempItem.get項目値3();
        source.listUpper_5 = tempItem.get項目値4();
        source.listUpper_6 = tempItem.get項目値5();
        source.listUpper_7 = tempItem.get内容1();
        source.listLower_1 = tempItem.get処理名称();
        source.listLower_2 = tempItem.get内容2();
        return source;
    }

}
