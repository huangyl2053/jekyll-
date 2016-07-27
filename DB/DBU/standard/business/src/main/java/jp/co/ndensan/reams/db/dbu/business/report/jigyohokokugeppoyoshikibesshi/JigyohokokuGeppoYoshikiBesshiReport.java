/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshikibesshi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiChange;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiData;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（別紙） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-090 dangjingjing
 */
public class JigyohokokuGeppoYoshikiBesshiReport extends Report<JigyohokokuGeppoYoshikiBesshiReportSource> {

    private final JigyohokokuGeppoYoshikiBesshiData data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuGeppoYoshikiBesshiReport(JigyohokokuGeppoYoshikiBesshiData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuGeppoYoshikiBesshiReportSource> reportSourceWriter) {
        for (JigyohokokuGeppoYoshikiBesshiChange change : getList()) {
            IJigyohokokuGeppoYoshikiBesshiEditor editor = new JigyohokokuGeppoYoshikiBesshiEditor(data, change);
            IJigyohokokuGeppoYoshikiBesshiBuilder builder = new JigyohokokuGeppoYoshikiBesshiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuGeppoYoshikiBesshiChange> getList() {
        List<JigyohokokuGeppoYoshikiBesshiChange> list = new ArrayList<>();
        list.add(new JigyohokokuGeppoYoshikiBesshiChange(data.get前月末現在の集計結果値_1(),
                data.get当月中増の集計結果値_1(),
                data.get当月中減の集計結果値_1(),
                data.get当月末現在の集計結果値_1()));
        return list;
    }
}
