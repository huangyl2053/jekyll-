/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153300007;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307ReportSource;

/**
 * 介護事業状況報告年報・一般状況（様式1-5）のBodyEditorです。
 *
 * @reamsid_L DBU-5600-170 wangrenze
 */
public class JigyohokokuCompYoshiki15307BodyEditor implements IJigyohokokuCompYoshiki15307Editor {

    private final JigyohokokuCompYoshiki15307BodyData item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuCompYoshiki15307BodyData
     */
    protected JigyohokokuCompYoshiki15307BodyEditor(JigyohokokuCompYoshiki15307BodyData item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki15307ReportSource edit(JigyohokokuCompYoshiki15307ReportSource source) {
        source.list_1 = item.getListList_1();
        source.list_2 = item.getListList_2();
        source.list_3 = item.getListList_3();
        source.list_4 = item.getListList_4();
        source.list_5 = item.getListList_6();
        source.list_6 = item.getListList_6();
        source.list_7 = item.getListList_7();
        source.list_8 = item.getListList_8();
        source.list_9 = item.getListList_9();
        source.list_10 = item.getListList_10();
        source.list_11 = item.getListList_11();
        source.list_12 = item.getListList_12();
        return source;
    }
}
