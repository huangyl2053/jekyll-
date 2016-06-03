/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo;

import jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReportSource;

/**
 * 審査判定の変更状況のEditorです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
public class ShinsahanteinoHenkojokyoBodyEditor implements IShinsahanteinoHenkojokyoBodyEditor {

    private final ShinsahanteinoHenkojokyoBody item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected ShinsahanteinoHenkojokyoBodyEditor(ShinsahanteinoHenkojokyoBody item) {
        this.item = item;
    }

    @Override
    public ShinsahanteinoHenkojokyoReportSource edit(ShinsahanteinoHenkojokyoReportSource source) {
        return editSource(source);
    }

    private ShinsahanteinoHenkojokyoReportSource editSource(ShinsahanteinoHenkojokyoReportSource source) {
        source.listKoshinkensu_1 = item.getListKoshinkensu_1();
        source.listKoshinkensu_2 = item.getListKoshinkensu_2();
        source.listKoshinkensu_3 = item.getListKoshinkensu_3();
        source.listKoshinkensu_4 = item.getListKoshinkensu_4();
        source.listKoshinkensu_5 = item.getListKoshinkensu_5();
        source.listKoshinkensu_6 = item.getListKoshinkensu_6();
        source.listKoshinkensu_7 = item.getListKoshinkensu_7();
        source.listKoshinkensu_8 = item.getListKoshinkensu_8();
        source.listKoshinkensu_9 = item.getListKoshinkensu_9();
        source.listShinkikuhenkensu_1 = item.getListShinkikuhenkensu_1();
        source.listShinkikuhenkensu_2 = item.getListShinkikuhenkensu_2();
        source.listShinkikuhenkensu_3 = item.getListShinkikuhenkensu_3();
        source.listShinkikuhenkensu_4 = item.getListShinkikuhenkensu_4();
        source.listShinkikuhenkensu_5 = item.getListShinkikuhenkensu_5();
        source.listShinkikuhenkensu_6 = item.getListShinkikuhenkensu_6();
        source.listShinkikuhenkensu_7 = item.getListShinkikuhenkensu_7();
        source.listShinkikuhenkensu_8 = item.getListShinkikuhenkensu_8();
        source.listShinkikuhenkensu_9 = item.getListShinkikuhenkensu_9();
        return source;
    }
}
