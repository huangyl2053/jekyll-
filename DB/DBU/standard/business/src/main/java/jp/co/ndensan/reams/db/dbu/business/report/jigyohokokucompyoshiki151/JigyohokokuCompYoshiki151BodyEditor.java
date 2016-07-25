 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151ReportSource;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-080 dangjingjing
 */
public class JigyohokokuCompYoshiki151BodyEditor implements IJigyohokokuCompYoshiki151Editor {

    private final JigyohokokuCompYoshiki151Change change;

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuCompYoshiki151Change
     */
    protected JigyohokokuCompYoshiki151BodyEditor(JigyohokokuCompYoshiki151Change change) {
        this.change = change;
    }

    @Override
    public JigyohokokuCompYoshiki151ReportSource edit(JigyohokokuCompYoshiki151ReportSource source) {
        return editsSource(source);
    }

    private JigyohokokuCompYoshiki151ReportSource editsSource(JigyohokokuCompYoshiki151ReportSource source) {
        source.list1_1 = change.getList1_1();
        source.list1_2 = change.getList1_2();
        source.list1_3 = change.getList1_3();

        source.list2_1 = change.getList2_1();
        source.list2_2 = change.getList2_2();
        source.list2_3 = change.getList2_3();
        source.list2_4 = change.getList2_4();
        source.list2_5 = change.getList2_5();
        source.list2_6 = change.getList2_6();
        source.list2_7 = change.getList2_7();
        source.list2_8 = change.getList2_8();
        source.list2_9 = change.getList2_9();
        source.list2_10 = change.getList2_10();
        source.list2_11 = change.getList2_11();
        return source;
    }
}
