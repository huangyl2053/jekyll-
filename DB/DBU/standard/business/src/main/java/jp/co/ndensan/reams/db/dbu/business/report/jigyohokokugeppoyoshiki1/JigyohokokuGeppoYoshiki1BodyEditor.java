/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki1;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1ReportSource;

/**
 * 介護事業状況報告月報・一般状況（様式1） のEditorです。
 *
 * @reamsid_L DBU-5530-040 dangjingjing
 */
public class JigyohokokuGeppoYoshiki1BodyEditor implements IJigyohokokuGeppoYoshiki1Editor {

    private final JigyohokokuGeppoYoshiki1Change change;

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuGeppoYoshiki1Change
     */
    protected JigyohokokuGeppoYoshiki1BodyEditor(JigyohokokuGeppoYoshiki1Change change) {
        this.change = change;
    }

    @Override
    public JigyohokokuGeppoYoshiki1ReportSource edit(JigyohokokuGeppoYoshiki1ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuGeppoYoshiki1ReportSource editSource(JigyohokokuGeppoYoshiki1ReportSource source) {
        source.list1_1 = change.getList1_1();
        source.list1_2 = change.getList1_2();
        source.list1_3 = change.getList1_3();
        source.list1_4 = change.getList1_4();
        source.list2Lower_1 = change.getList2Lower_1();
        source.list2Lower_2 = change.getList2Lower_2();
        source.list2Lower_3 = change.getList2Lower_3();
        source.list2Lower_4 = change.getList2Lower_4();
        source.list2Lower_5 = change.getList2Lower_5();
        source.list2Lower_6 = change.getList2Lower_6();
        source.list2Upper_1 = change.getList2Upper_1();
        source.list2Upper_2 = change.getList2Upper_2();
        source.list2Upper_3 = change.getList2Upper_3();
        source.list2Upper_4 = change.getList2Upper_4();
        source.list2Upper_5 = change.getList2Upper_5();
        source.list2Upper_6 = change.getList2Upper_6();
        return source;
    }
}
