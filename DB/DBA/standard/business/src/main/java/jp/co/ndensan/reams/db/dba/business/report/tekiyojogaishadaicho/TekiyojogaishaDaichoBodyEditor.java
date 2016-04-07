/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.db.dba.entity.report.source.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;

/**
 * 適用除外者台帳ボディEditorです。
 *
 * @reamsid_L DBE-3000-140 lishengli
 */
class TekiyojogaishaDaichoBodyEditor implements ITekiyojogaishaDaichoEditor {

    private final TekiyojogaishaDaichoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TekiyojogaishaDaichoBodyItem}
     */
    protected TekiyojogaishaDaichoBodyEditor(TekiyojogaishaDaichoBodyItem item) {
        this.item = item;
    }

    /**
     * 適用除外者台帳ボディEditorです。
     *
     * @param source 適用除外者台帳Source
     * @return 適用除外者台帳Source
     */
    @Override
    public TekiyojogaishaDaichoReportSource edit(TekiyojogaishaDaichoReportSource source) {
        return editBody(source);
    }

    private TekiyojogaishaDaichoReportSource editBody(TekiyojogaishaDaichoReportSource source) {
        source.listNo_1 = item.getListNo_1();
        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
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
