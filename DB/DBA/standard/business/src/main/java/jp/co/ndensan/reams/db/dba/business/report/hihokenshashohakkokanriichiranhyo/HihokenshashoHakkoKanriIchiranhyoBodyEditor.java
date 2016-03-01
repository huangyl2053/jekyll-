/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;

/**
 *
 * 被保険者証発行管理一覧表ボディEditorです。
 */
public class HihokenshashoHakkoKanriIchiranhyoBodyEditor implements IHihokenshashoHakkoKanriIchiranhyoEditor {

    private final HihokenshashoHakkoKanriIchiranhyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HihokenshashoHakkoKanriIchiranhyoBodyItem}
     */
    protected HihokenshashoHakkoKanriIchiranhyoBodyEditor(HihokenshashoHakkoKanriIchiranhyoBodyItem item) {
        this.item = item;
    }

    /**
     * 被保険者証発行管理一覧表ボディのEdit。
     *
     * @param source 被保険者証発行管理一覧表のReportSourceクラス
     * @return HihokenshashoHakkoKanriIchiranhyoReportSource
     */
    @Override
    public HihokenshashoHakkoKanriIchiranhyoReportSource edit(HihokenshashoHakkoKanriIchiranhyoReportSource source) {
        return editBody(source);
    }

    private HihokenshashoHakkoKanriIchiranhyoReportSource editBody(HihokenshashoHakkoKanriIchiranhyoReportSource source) {
        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
        source.listUpper_8 = item.getListUpper_8();
        source.listLower_1 = item.getListLower_1();
        source.listLower_2 = item.getListLower_2();
        source.listLower_3 = item.getListLower_3();
        source.listLower_4 = item.getListLower_4();
        source.listLower_5 = item.getListLower_5();
        source.listLower_6 = item.getListLower_6();
        source.listLower_7 = item.getListLower_7();
        return source;
    }
}
