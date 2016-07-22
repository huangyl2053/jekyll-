/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153Variables;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式 のReportSourceクラスです。
 *
 * @reamsid_L DBU-5540-060 dangjingjing
 */
public class JigyohokokuCompYoshiki153Report extends Report<JigyohokokuCompYoshiki153ReportSource> {

    private final JigyohokokuCompYoshiki153Variables variables;

    /**
     * インスタンスを生成します。
     *
     * @param variables 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki153Report(JigyohokokuCompYoshiki153Variables variables) {
        this.variables = variables;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki153ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki153Change change : getListVariables()) {
            IJigyohokokuCompYoshiki153Editor editor = new JigyohokokuCompYoshiki153Editor(variables);
            IJigyohokokuCompYoshiki153Editor bodyEditor = new JigyohokokuCompYoshiki153BodyEditor(change);
            IJigyohokokuCompYoshiki153Builder builder = new JigyohokokuCompYoshiki153Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki153Change> getListVariables() {
        List<JigyohokokuCompYoshiki153Change> listVariables = new ArrayList<>();
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_1(),
                variables.get予防給付_要支援2_1(),
                variables.get要支援合計_1(),
                variables.get介護給付_経過的要介護_1(),
                variables.get介護給付_要介護1_1(),
                variables.get介護給付_要介護2_1(),
                variables.get介護給付_要介護3_1(),
                variables.get介護給付_要介護4_1(),
                variables.get介護給付_要介護5_1(),
                variables.get介護給付_その他_1(),
                variables.get要介護合計_1(),
                variables.getサービス受給者数合計_1()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_2(),
                variables.get予防給付_要支援2_2(),
                variables.get要支援合計_2(),
                variables.get介護給付_経過的要介護_2(),
                variables.get介護給付_要介護1_2(),
                variables.get介護給付_要介護2_2(),
                variables.get介護給付_要介護3_2(),
                variables.get介護給付_要介護4_2(),
                variables.get介護給付_要介護5_2(),
                variables.get介護給付_その他_2(),
                variables.get要介護合計_2(),
                variables.getサービス受給者数合計_2()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_3(),
                variables.get予防給付_要支援2_3(),
                variables.get要支援合計_3(),
                variables.get介護給付_経過的要介護_3(),
                variables.get介護給付_要介護1_3(),
                variables.get介護給付_要介護2_3(),
                variables.get介護給付_要介護3_3(),
                variables.get介護給付_要介護4_3(),
                variables.get介護給付_要介護5_3(),
                variables.get介護給付_その他_3(),
                variables.get要介護合計_3(),
                variables.getサービス受給者数合計_3()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_4(),
                variables.get予防給付_要支援2_4(),
                variables.get要支援合計_4(),
                variables.get介護給付_経過的要介護_4(),
                variables.get介護給付_要介護1_4(),
                variables.get介護給付_要介護2_4(),
                variables.get介護給付_要介護3_4(),
                variables.get介護給付_要介護4_4(),
                variables.get介護給付_要介護5_4(),
                variables.get介護給付_その他_4(),
                variables.get要介護合計_4(),
                variables.getサービス受給者数合計_4()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_5(),
                variables.get予防給付_要支援2_5(),
                variables.get要支援合計_5(),
                variables.get介護給付_経過的要介護_5(),
                variables.get介護給付_要介護1_5(),
                variables.get介護給付_要介護2_5(),
                variables.get介護給付_要介護3_5(),
                variables.get介護給付_要介護4_5(),
                variables.get介護給付_要介護5_5(),
                variables.get介護給付_その他_5(),
                variables.get要介護合計_5(),
                variables.getサービス受給者数合計_5()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_6(),
                variables.get予防給付_要支援2_6(),
                variables.get要支援合計_6(),
                variables.get介護給付_経過的要介護_6(),
                variables.get介護給付_要介護1_6(),
                variables.get介護給付_要介護2_6(),
                variables.get介護給付_要介護3_6(),
                variables.get介護給付_要介護4_6(),
                variables.get介護給付_要介護5_6(),
                variables.get介護給付_その他_6(),
                variables.get要介護合計_6(),
                variables.getサービス受給者数合計_6()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_7(),
                variables.get予防給付_要支援2_7(),
                variables.get要支援合計_7(),
                variables.get介護給付_経過的要介護_7(),
                variables.get介護給付_要介護1_7(),
                variables.get介護給付_要介護2_7(),
                variables.get介護給付_要介護3_7(),
                variables.get介護給付_要介護4_7(),
                variables.get介護給付_要介護5_7(),
                variables.get介護給付_その他_7(),
                variables.get要介護合計_7(),
                variables.getサービス受給者数合計_7()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_8(),
                variables.get予防給付_要支援2_8(),
                variables.get要支援合計_8(),
                variables.get介護給付_経過的要介護_8(),
                variables.get介護給付_要介護1_8(),
                variables.get介護給付_要介護2_8(),
                variables.get介護給付_要介護3_8(),
                variables.get介護給付_要介護4_8(),
                variables.get介護給付_要介護5_8(),
                variables.get介護給付_その他_8(),
                variables.get要介護合計_8(),
                variables.getサービス受給者数合計_8()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_9(),
                variables.get予防給付_要支援2_9(),
                variables.get要支援合計_9(),
                variables.get介護給付_経過的要介護_9(),
                variables.get介護給付_要介護1_9(),
                variables.get介護給付_要介護2_9(),
                variables.get介護給付_要介護3_9(),
                variables.get介護給付_要介護4_9(),
                variables.get介護給付_要介護5_9(),
                variables.get介護給付_その他_9(),
                variables.get要介護合計_9(),
                variables.getサービス受給者数合計_9()));
        listVariables.add(new JigyohokokuCompYoshiki153Change(variables.get予防給付_要支援1_10(),
                variables.get予防給付_要支援2_10(),
                variables.get要支援合計_10(),
                variables.get介護給付_経過的要介護_10(),
                variables.get介護給付_要介護1_10(),
                variables.get介護給付_要介護2_10(),
                variables.get介護給付_要介護3_10(),
                variables.get介護給付_要介護4_10(),
                variables.get介護給付_要介護5_10(),
                variables.get介護給付_その他_10(),
                variables.get要介護合計_10(),
                variables.getサービス受給者数合計_10()));
        return listVariables;
    }
}
