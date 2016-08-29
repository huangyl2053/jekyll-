/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshikibesshi;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiChange;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiData;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護事業状況報告月報・一般状況（別紙） のEditorです。
 *
 * @reamsid_L DBU-5530-090 dangjingjing
 */
public class JigyohokokuGeppoYoshikiBesshiEditor implements IJigyohokokuGeppoYoshikiBesshiEditor {

    private static final int 年度 = 4;
    private final JigyohokokuGeppoYoshikiBesshiData data;
    private final JigyohokokuGeppoYoshikiBesshiChange change;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuGeppoYoshikiBesshiData
     * @param change JigyohokokuGeppoYoshikiBesshiChange
     */
    protected JigyohokokuGeppoYoshikiBesshiEditor(JigyohokokuGeppoYoshikiBesshiData data, JigyohokokuGeppoYoshikiBesshiChange change) {
        this.data = data;
        this.change = change;
    }

    @Override
    public JigyohokokuGeppoYoshikiBesshiReportSource edit(JigyohokokuGeppoYoshikiBesshiReportSource source) {
        return editSource(source);
    }

    private JigyohokokuGeppoYoshikiBesshiReportSource editSource(JigyohokokuGeppoYoshikiBesshiReportSource source) {
        source.printTimeStamp = data.get作成日時();
        source.shukeiKubun = data.get集計区分();
        source.shuukeiHani = set集計範囲(data);
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.komokuHyodaiRetsu1 = data.get項目標題列1();
        source.komokuHyodaiRetsu2 = data.get項目標題列2();
        source.komokuHyodaiRetsu3 = data.get項目標題列3();
        source.komokuHyodaiRetsu4 = data.get項目標題列4();
        source.list_1 = change.getList_1();
        source.list_2 = change.getList_2();
        source.list_3 = change.getList_3();
        source.list_4 = change.getList_4();
        return source;
    }

    private RString set集計範囲(JigyohokokuGeppoYoshikiBesshiData data) {
        RStringBuilder 集計範囲 = new RStringBuilder();
        if (new RString("1").equals(data.get年報月報区分())) {
            集計範囲.append("（");
            集計範囲.append(data.get集計年月());
            集計範囲.append("分）");
        }
        if (new RString("2").equals(data.get年報月報区分())) {
            集計範囲.append("（");
            集計範囲.append(data.get集計年度());
            集計範囲.append("分）");
            集計範囲.append(data.get集計期間FROM());
            集計範囲.append("~");
            集計範囲.append(data.get集計期間TO());
        }
        return 集計範囲.toRString();
    }

}
