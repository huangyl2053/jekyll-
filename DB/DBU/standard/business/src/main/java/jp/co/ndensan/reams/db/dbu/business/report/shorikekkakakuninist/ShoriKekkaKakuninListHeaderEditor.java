/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;

/**
 * 処理確認リストのヘーダEditorです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
public class ShoriKekkaKakuninListHeaderEditor implements IShoriKekkaKakuninListEditor {

    private final ShoriKekkaKakuninListHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem {@link ShoriKekkaKakuninListHeadItem}
     */
    protected ShoriKekkaKakuninListHeaderEditor(ShoriKekkaKakuninListHeadItem headItem) {
        this.headItem = headItem;
    }

    /**
     * 処理確認リストのヘーダのedit
     *
     * @param source ShoriKekkaKakuninListReportSource
     * @return ShoriKekkaKakuninListReportSource
     */
    @Override
    public ShoriKekkaKakuninListReportSource edit(ShoriKekkaKakuninListReportSource source) {
        return editHeader(source);
    }

    private ShoriKekkaKakuninListReportSource editHeader(ShoriKekkaKakuninListReportSource source) {
        source.printTimeStamp = headItem.getPrintTimeStamp();
        source.shichosonCode = headItem.getShichosonCode();
        source.shichosonName = headItem.getShichosonName();
        source.keyKomoku1 = headItem.getKeyKomoku1();
        source.keyKomoku2 = headItem.getKeyKomoku2();
        source.keyKomoku3 = headItem.getKeyKomoku3();
        source.keyKomoku4 = headItem.getKeyKomoku4();
        return source;
    }

}
