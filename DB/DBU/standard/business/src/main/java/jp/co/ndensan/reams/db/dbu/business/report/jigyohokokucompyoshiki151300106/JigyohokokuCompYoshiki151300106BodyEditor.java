 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151300106;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151300106.JigyohokokuCompYoshiki151300106ReportSource;

/**
 * 介護事業状況報告年報（様式1-5）のEditorです。
 *
 * @reamsid_L DBU-5600-150 lishengli
 */
public class JigyohokokuCompYoshiki151300106BodyEditor implements IJigyohokokuCompYoshiki151300106Editor {

    private final JigyohokokuCompYoshiki151300106Body body;

    /**
     * インスタンスを生成します。
     *
     * @param body JigyohokokuCompYoshiki151300106Body
     */
    protected JigyohokokuCompYoshiki151300106BodyEditor(JigyohokokuCompYoshiki151300106Body body) {
        this.body = body;
    }

    @Override
    public JigyohokokuCompYoshiki151300106ReportSource edit(JigyohokokuCompYoshiki151300106ReportSource source) {
        return editsSource(source);
    }

    private JigyohokokuCompYoshiki151300106ReportSource editsSource(JigyohokokuCompYoshiki151300106ReportSource source) {
        source.list1_1 = body.getList1_1();
        source.list1_2 = body.getList1_2();
        source.list1_3 = body.getList1_3();

        source.list2_1 = body.getList2_1();
        source.list2_2 = body.getList2_2();
        source.list2_3 = body.getList2_3();
        source.list2_4 = body.getList2_4();
        source.list2_5 = body.getList2_5();
        source.list2_6 = body.getList2_6();
        source.list2_7 = body.getList2_7();
        source.list2_8 = body.getList2_8();
        source.list2_9 = body.getList2_9();
        source.list2_10 = body.getList2_10();
        source.list2_11 = body.getList2_11();
        return source;
    }
}
