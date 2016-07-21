/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153ReportSource;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）のReportSourceクラスです。
 *
 * @reamsid_L DBU-5550-050 dangjingjing
 */
public class JigyohokokuCompYoshiki153BodyEditor implements IJigyohokokuCompYoshiki153Editor {

    private final JigyohokokuCompYoshiki153Change change;

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuCompYoshiki153Change
     */
    protected JigyohokokuCompYoshiki153BodyEditor(JigyohokokuCompYoshiki153Change change) {
        this.change = change;
    }

    @Override
    public JigyohokokuCompYoshiki153ReportSource edit(JigyohokokuCompYoshiki153ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki153ReportSource editSource(JigyohokokuCompYoshiki153ReportSource source) {
        source.list_1 = change.getList_1();
        source.list_2 = change.getList_2();
        source.list_3 = change.getList_3();
        source.list_4 = change.getList_4();
        source.list_5 = change.getList_5();
        source.list_6 = change.getList_6();
        source.list_7 = change.getList_7();
        source.list_8 = change.getList_8();
        source.list_9 = change.getList_9();
        source.list_10 = change.getList_10();
        source.list_11 = change.getList_11();
        source.list_12 = change.getList_12();
        return source;
    }
}
