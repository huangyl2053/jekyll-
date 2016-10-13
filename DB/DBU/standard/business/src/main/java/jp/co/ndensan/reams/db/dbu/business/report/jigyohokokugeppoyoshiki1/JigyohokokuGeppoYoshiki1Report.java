/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki1;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1） のReportです。
 *
 * @reamsid_L DBU-5530-040 dangjingjing
 */
public class JigyohokokuGeppoYoshiki1Report extends Report<JigyohokokuGeppoYoshiki1ReportSource> {

    private final JigyohokokuGeppoYoshiki1Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuGeppoYoshiki1Report(JigyohokokuGeppoYoshiki1Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuGeppoYoshiki1ReportSource> reportSourceWriter) {
        for (JigyohokokuGeppoYoshiki1Change change : getBodyList()) {
            IJigyohokokuGeppoYoshiki1Editor editor = new JigyohokokuGeppoYoshiki1Editor(data);
            IJigyohokokuGeppoYoshiki1Editor bodyEditor = new JigyohokokuGeppoYoshiki1BodyEditor(change);
            IJigyohokokuGeppoYoshiki1Builder builder = new JigyohokokuGeppoYoshiki1Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuGeppoYoshiki1Change> getBodyList() {
        List<JigyohokokuGeppoYoshiki1Change> list = new ArrayList<>();
        list.add(new JigyohokokuGeppoYoshiki1Change(data.get前月末現在_1(),
                data.get当月中増_計_1(),
                data.get当月中減_計_1(),
                data.get当月末現在_1(),
                data.get転入転出_1(),
                data.get職権復活職権喪失_1(),
                data.get歳到達65死亡_1(),
                data.get適用除外非該当適用除外該当_1(),
                data.getその他_1(),
                data.get計_1(),
                data.get自特例適用自特例解除_1(),
                data.get自特例転入_1(),
                data.get他特例居住他特例適用_1(),
                data.get外国人申請国籍喪失_1(),
                data.get帰化_1(),
                data.get左記以外_1()));
        list.add(new JigyohokokuGeppoYoshiki1Change(data.get前月末現在_2(),
                data.get当月中増_計_2(),
                data.get当月中減_計_2(),
                data.get当月末現在_2(),
                data.get転入転出_2(),
                data.get職権復活職権喪失_2(),
                data.get歳到達65死亡_2(),
                data.get適用除外非該当適用除外該当_2(),
                data.getその他_2(),
                data.get計_2(),
                data.get自特例適用自特例解除_2(),
                data.get自特例転入_2(),
                data.get他特例居住他特例適用_2(),
                data.get外国人申請国籍喪失_2(),
                data.get帰化_2(),
                data.get左記以外_2()));
        list.add(new JigyohokokuGeppoYoshiki1Change(data.get前月末現在_3(),
                data.get当月中増_計_3(),
                data.get当月中減_計_3(),
                data.get当月末現在_3(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));
        list.add(new JigyohokokuGeppoYoshiki1Change(data.get前月末現在_4(),
                data.get当月中増_計_4(),
                data.get当月中減_計_4(),
                data.get当月末現在_4(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));
        list.add(new JigyohokokuGeppoYoshiki1Change(data.get前月末現在_5(),
                data.get当月中増_計_5(),
                data.get当月中減_計_5(),
                data.get当月末現在_5(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));
        return list;
    }
}
