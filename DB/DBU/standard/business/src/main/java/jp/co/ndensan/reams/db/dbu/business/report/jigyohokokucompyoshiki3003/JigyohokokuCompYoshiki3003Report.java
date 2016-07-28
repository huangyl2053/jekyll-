/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki3003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki3003.JigyohokokuCompYoshiki3003Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki3003.JigyohokokuCompYoshiki3003Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki3003.JigyohokokuCompYoshiki3003ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-3） のReportです。
 *
 * @reamsid_L DBU-5530-060 dangjingjing
 */
public class JigyohokokuCompYoshiki3003Report extends Report<JigyohokokuCompYoshiki3003ReportSource> {

    private final JigyohokokuCompYoshiki3003Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki3003Report(JigyohokokuCompYoshiki3003Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki3003ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki3003Change change : getBodyList()) {
            IJigyohokokuCompYoshiki3003Editor editor = new JigyohokokuCompYoshiki3003Editor(data);
            IJigyohokokuCompYoshiki3003Editor bodyEditor = new JigyohokokuCompYoshiki3003BodyEditor(change);
            IJigyohokokuCompYoshiki3003Builder builder = new JigyohokokuCompYoshiki3003Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki3003Change> getBodyList() {
        List<JigyohokokuCompYoshiki3003Change> changes = new ArrayList<>();
        changes.add(new JigyohokokuCompYoshiki3003Change(data.get介護老人福祉施設_食費_1(),
                data.get介護老人福祉施設_居住費_1(),
                data.get介護老人保健施設_食費_1(),
                data.get介護老人保健施設_居住費_1(),
                data.get介護療養型医療施設_食費_1(),
                data.get介護療養型医療施設_居住費_1(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_1(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_1(),
                data.getその他_食費_1(),
                data.getその他_居住費_1(),
                data.get合計_食費_1(),
                data.get合計_居住費_1(),
                data.get利用者負担減額免除認定表の利用者負担_1(),
                data.get減額減免認定表の特定負担限度額_食費_1(),
                data.get減額減免認定表の特定負担限度額_居住費_1(),
                data.get減額免除認定表の利用者負担_1()));
        changes.add(new JigyohokokuCompYoshiki3003Change(data.get介護老人福祉施設_食費_2(),
                data.get介護老人福祉施設_居住費_2(),
                data.get介護老人保健施設_食費_2(),
                data.get介護老人保健施設_居住費_2(),
                data.get介護療養型医療施設_食費_2(),
                data.get介護療養型医療施設_居住費_2(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_2(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_2(),
                data.getその他_食費_2(),
                data.getその他_食費_2(),
                data.get合計_食費_2(),
                data.get合計_居住費_2(),
                data.get利用者負担減額免除認定表の利用者負担_2(),
                data.get減額減免認定表の特定負担限度額_食費_2(),
                data.get減額減免認定表の特定負担限度額_居住費_2(),
                data.get減額免除認定表の利用者負担_2()));
        changes.add(new JigyohokokuCompYoshiki3003Change(data.get介護老人福祉施設_食費_3(),
                data.get介護老人福祉施設_居住費_3(),
                data.get介護老人保健施設_食費_3(),
                data.get介護老人保健施設_居住費_3(),
                data.get介護療養型医療施設_食費_3(),
                data.get介護療養型医療施設_居住費_3(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_3(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_3(),
                data.getその他_食費_3(),
                data.getその他_食費_3(),
                data.get合計_食費_3(),
                data.get合計_居住費_3(),
                data.get利用者負担減額免除認定表の利用者負担_3(),
                data.get減額減免認定表の特定負担限度額_食費_3(),
                data.get減額減免認定表の特定負担限度額_居住費_3(),
                data.get減額免除認定表の利用者負担_3()));
        changes.add(new JigyohokokuCompYoshiki3003Change(data.get介護老人福祉施設_食費_4(),
                data.get介護老人福祉施設_居住費_4(),
                data.get介護老人保健施設_食費_4(),
                data.get介護老人保健施設_居住費_4(),
                data.get介護療養型医療施設_食費_4(),
                data.get介護療養型医療施設_居住費_4(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_4(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_4(),
                data.getその他_食費_4(),
                data.getその他_食費_4(),
                data.get合計_食費_4(),
                data.get合計_居住費_4(),
                data.get利用者負担減額免除認定表の利用者負担_4(),
                data.get減額減免認定表の特定負担限度額_食費_4(),
                data.get減額減免認定表の特定負担限度額_居住費_4(),
                data.get減額免除認定表の利用者負担_4()));
        changes.add(new JigyohokokuCompYoshiki3003Change(data.get介護老人福祉施設_食費_5(),
                data.get介護老人福祉施設_居住費_5(),
                data.get介護老人保健施設_食費_5(),
                data.get介護老人保健施設_居住費_5(),
                data.get介護療養型医療施設_食費_5(),
                data.get介護療養型医療施設_居住費_5(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_5(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_5(),
                data.getその他_食費_5(),
                data.getその他_食費_5(),
                data.get合計_食費_5(),
                data.get合計_居住費_5(),
                data.get利用者負担減額免除認定表の利用者負担_5(),
                data.get減額減免認定表の特定負担限度額_食費_5(),
                data.get減額減免認定表の特定負担限度額_居住費_5(),
                data.get減額免除認定表の利用者負担_5()));
        changes.add(new JigyohokokuCompYoshiki3003Change(data.get介護老人福祉施設_食費_6(),
                data.get介護老人福祉施設_居住費_6(),
                data.get介護老人保健施設_食費_6(),
                data.get介護老人保健施設_居住費_6(),
                data.get介護療養型医療施設_食費_6(),
                data.get介護療養型医療施設_居住費_6(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_6(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_6(),
                data.getその他_食費_6(),
                data.getその他_食費_6(),
                data.get合計_食費_6(),
                data.get合計_居住費_6(),
                data.get利用者負担減額免除認定表の利用者負担_6(),
                data.get減額減免認定表の特定負担限度額_食費_6(),
                data.get減額減免認定表の特定負担限度額_居住費_6(),
                data.get減額免除認定表の利用者負担_6()));
        return changes;
    }
}
