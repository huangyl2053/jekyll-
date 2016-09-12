/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki25;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki25.JigyohokokuCompYoshiki25;
import jp.co.ndensan.reams.db.dbu.entity.report.JigyohokokuCompYoshiki25.JigyohokokuCompYoshiki25ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 介護事業状況報告月報（様式2-5）のReportです。
 *
 * @reamsid_L DBU-5600-260 guoqilin
 */
public class JigyohokokuCompYoshiki25Report extends Report<JigyohokokuCompYoshiki25ReportSource> {

    private final JigyohokokuCompYoshiki25 data;
    private final RString empty = RString.EMPTY;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki25
     */
    public JigyohokokuCompYoshiki25Report(JigyohokokuCompYoshiki25 data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki25ReportSource> writer) {
        for (JigyohokokuGeppoYoshiki25BodyData dataBody : getBodyData()) {
            IJigyohokokuCompYoshiki25Editor editor = new JigyohokokuCompYoshiki25Editor(data);
            IJigyohokokuCompYoshiki25Editor bodyEditor = new JigyohokokuCompYoshiki25BodyEditor(dataBody);
            IJigyohokokuCompYoshiki25Builder builder = new JigyohokokuCompYoshiki25Builder(editor, bodyEditor);
            writer.writeLine(builder);
        }
    }

    private List<JigyohokokuGeppoYoshiki25BodyData> getBodyData() {
        List<JigyohokokuGeppoYoshiki25BodyData> dataBodyList = new ArrayList<>();
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_1(), data.get件数_要支援2_1(), data.get件数_要支援計_1(),
                data.get件数_経過的要介護_1(), data.get件数_要介護1_1(), data.get件数_要介護2_1(), data.get件数_要介護3_1(),
                data.get件数_要介護4_1(), data.get件数_要介護5_1(), data.get件数_要介護計_1(), data.get件数_合計_1(),
                empty, data.get給付費_要支援1_1(), data.get給付費_要支援2_1(), data.get給付費_要支援計_1(),
                data.get給付費_経過的要介護_1(), data.get給付費_要介護1_1(), data.get給付費_要介護2_1(),
                data.get給付費_要介護3_1(), data.get給付費_要介護4_1(), data.get給付費_要介護5_1(),
                data.get給付費_要介護計_1(), data.get給付費_合計_1()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_2(), data.get件数_要支援2_2(), data.get件数_要支援計_2(),
                data.get件数_経過的要介護_2(), data.get件数_要介護1_2(), data.get件数_要介護2_2(), data.get件数_要介護3_2(),
                data.get件数_要介護4_2(), data.get件数_要介護5_2(), data.get件数_要介護計_2(), data.get件数_合計_2(),
                empty, data.get給付費_要支援1_2(), data.get給付費_要支援2_2(), data.get給付費_要支援計_2(),
                data.get給付費_経過的要介護_2(), data.get給付費_要介護1_2(), data.get給付費_要介護2_2(),
                data.get給付費_要介護3_2(), data.get給付費_要介護4_2(), data.get給付費_要介護5_2(),
                data.get給付費_要介護計_2(), data.get給付費_合計_2()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_3(), data.get件数_要支援2_3(), data.get件数_要支援計_3(),
                data.get件数_経過的要介護_3(), data.get件数_要介護1_3(), data.get件数_要介護2_3(), data.get件数_要介護3_3(),
                data.get件数_要介護4_3(), data.get件数_要介護5_3(), data.get件数_要介護計_3(), data.get件数_合計_3(),
                empty, data.get給付費_要支援1_3(), data.get給付費_要支援2_3(), data.get給付費_要支援計_3(),
                data.get給付費_経過的要介護_3(), data.get給付費_要介護1_3(), data.get給付費_要介護2_3(),
                data.get給付費_要介護3_3(), data.get給付費_要介護4_3(), data.get給付費_要介護5_3(),
                data.get給付費_要介護計_3(), data.get給付費_合計_3()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_4(), data.get件数_要支援2_4(),
                data.get件数_要支援計_4(), data.get件数_経過的要介護_4(),
                data.get件数_要介護1_4(), data.get件数_要介護2_4(), data.get件数_要介護3_4(),
                data.get件数_要介護4_4(), data.get件数_要介護5_4(), data.get件数_要介護計_4(), data.get件数_合計_4(),
                empty, data.get給付費_要支援1_4(), data.get給付費_要支援2_4(), data.get給付費_要支援計_4(),
                data.get給付費_経過的要介護_4(), data.get給付費_要介護1_4(),
                data.get給付費_要介護2_4(), data.get給付費_要介護3_4(), data.get給付費_要介護4_4(),
                data.get給付費_要介護5_4(), data.get給付費_要介護計_4(), data.get給付費_合計_4()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_5(), data.get件数_要支援2_5(), data.get件数_要支援計_5(),
                data.get件数_経過的要介護_5(), data.get件数_要介護1_5(), data.get件数_要介護2_5(), data.get件数_要介護3_5(),
                data.get件数_要介護4_5(), data.get件数_要介護5_5(), data.get件数_要介護計_5(), data.get件数_合計_5(),
                empty, data.get給付費_要支援1_5(), data.get給付費_要支援2_5(),
                data.get給付費_要支援計_5(), data.get給付費_経過的要介護_5(),
                data.get給付費_要介護1_5(), data.get給付費_要介護2_5(), data.get給付費_要介護3_5(), data.get給付費_要介護4_5(),
                data.get給付費_要介護5_5(), data.get給付費_要介護計_5(), data.get給付費_合計_5()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_6(), data.get件数_要支援2_6(), data.get件数_要支援計_6(),
                data.get件数_経過的要介護_6(), data.get件数_要介護1_6(), data.get件数_要介護2_6(), data.get件数_要介護3_6(),
                data.get件数_要介護4_6(), data.get件数_要介護5_6(), data.get件数_要介護計_6(), data.get件数_合計_6(),
                empty, data.get給付費_要支援1_6(), data.get給付費_要支援2_6(), data.get給付費_要支援計_6(),
                data.get給付費_経過的要介護_6(), data.get給付費_要介護1_6(), data.get給付費_要介護2_6(),
                data.get給付費_要介護3_6(), data.get給付費_要介護4_6(), data.get給付費_要介護5_6(),
                data.get給付費_要介護計_6(), data.get給付費_合計_6()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_7(), data.get件数_要支援2_7(), data.get件数_要支援計_7(), data.get件数_経過的要介護_7(),
                data.get件数_要介護1_7(), data.get件数_要介護2_7(), data.get件数_要介護3_7(), data.get件数_要介護4_7(),
                data.get件数_要介護5_7(), data.get件数_要介護計_7(), data.get件数_合計_7(),
                empty, data.get給付費_要支援1_7(), data.get給付費_要支援2_7(),
                data.get給付費_要支援計_7(), data.get給付費_経過的要介護_7(),
                data.get給付費_要介護1_7(), data.get給付費_要介護2_7(), data.get給付費_要介護3_7(),
                data.get給付費_要介護4_7(), data.get給付費_要介護5_7(), data.get給付費_要介護計_7(), data.get給付費_合計_7()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_8(), data.get件数_要支援2_8(), data.get件数_要支援計_8(),
                data.get件数_経過的要介護_8(), data.get件数_要介護1_8(), data.get件数_要介護2_8(), data.get件数_要介護3_8(),
                data.get件数_要介護4_8(), data.get件数_要介護5_8(), data.get件数_要介護計_8(), data.get件数_合計_8(),
                empty, data.get給付費_要支援1_8(), data.get給付費_要支援2_8(), data.get給付費_要支援計_8(),
                data.get給付費_経過的要介護_8(), data.get給付費_要介護1_8(), data.get給付費_要介護2_8(), data.get給付費_要介護3_8(),
                data.get給付費_要介護4_8(), data.get給付費_要介護5_8(), data.get給付費_要介護計_8(), data.get給付費_合計_8()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_9(), data.get件数_要支援2_9(), data.get件数_要支援計_9(),
                data.get件数_経過的要介護_9(), data.get件数_要介護1_9(), data.get件数_要介護2_9(), data.get件数_要介護3_9(),
                data.get件数_要介護4_9(), data.get件数_要介護5_9(), data.get件数_要介護計_9(), data.get件数_合計_9(),
                empty, data.get給付費_要支援1_9(), data.get給付費_要支援2_9(), data.get給付費_要支援計_9(),
                data.get給付費_経過的要介護_9(), data.get給付費_要介護1_9(), data.get給付費_要介護2_9(), data.get給付費_要介護3_9(),
                data.get給付費_要介護4_9(), data.get給付費_要介護5_9(), data.get給付費_要介護計_9(), data.get給付費_合計_9()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_10(), data.get件数_要支援2_10(), data.get件数_要支援計_10(),
                data.get件数_経過的要介護_10(), data.get件数_要介護1_10(), data.get件数_要介護2_10(), data.get件数_要介護3_10(),
                data.get件数_要介護4_10(), data.get件数_要介護5_10(), data.get件数_要介護計_10(), data.get件数_合計_10(),
                empty, data.get給付費_要支援1_10(), data.get給付費_要支援2_10(), data.get給付費_要支援計_10(),
                data.get給付費_経過的要介護_10(), data.get給付費_要介護1_10(), data.get給付費_要介護2_10(), data.get給付費_要介護3_10(),
                data.get給付費_要介護4_10(), data.get給付費_要介護5_10(), data.get給付費_要介護計_10(), data.get給付費_合計_10()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_11(), data.get件数_要支援2_11(), data.get件数_要支援計_11(),
                data.get件数_経過的要介護_11(), data.get件数_要介護1_11(), data.get件数_要介護2_11(), data.get件数_要介護3_11(),
                data.get件数_要介護4_11(), data.get件数_要介護5_11(), data.get件数_要介護計_11(), data.get件数_合計_11(),
                empty, data.get給付費_要支援1_11(), data.get給付費_要支援2_11(), data.get給付費_要支援計_11(),
                data.get給付費_経過的要介護_11(), data.get給付費_要介護1_11(), data.get給付費_要介護2_11(), data.get給付費_要介護3_11(),
                data.get給付費_要介護4_11(), data.get給付費_要介護5_11(), data.get給付費_要介護計_11(), data.get給付費_合計_11()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_12(), data.get件数_要支援2_12(), data.get件数_要支援計_12(),
                data.get件数_経過的要介護_12(), data.get件数_要介護1_12(), data.get件数_要介護2_12(), data.get件数_要介護3_12(),
                data.get件数_要介護4_12(), data.get件数_要介護5_12(), data.get件数_要介護計_12(), data.get件数_合計_12(),
                empty, data.get給付費_要支援1_12(), data.get給付費_要支援2_12(), data.get給付費_要支援計_12(),
                data.get給付費_経過的要介護_12(), data.get給付費_要介護1_12(), data.get給付費_要介護2_12(), data.get給付費_要介護3_12(),
                data.get給付費_要介護4_12(), data.get給付費_要介護5_12(), data.get給付費_要介護計_12(), data.get給付費_合計_12()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_13(), data.get件数_要支援2_13(), data.get件数_要支援計_13(),
                data.get件数_経過的要介護_13(), data.get件数_要介護1_13(), data.get件数_要介護2_13(), data.get件数_要介護3_13(),
                data.get件数_要介護4_13(), data.get件数_要介護5_13(), data.get件数_要介護計_13(), data.get件数_合計_13(),
                empty, data.get給付費_要支援1_13(), data.get給付費_要支援2_13(), data.get給付費_要支援計_13(),
                data.get給付費_経過的要介護_13(), data.get給付費_要介護1_13(), data.get給付費_要介護2_13(), data.get給付費_要介護3_13(),
                data.get給付費_要介護4_13(), data.get給付費_要介護5_13(), data.get給付費_要介護計_13(), data.get給付費_合計_13()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_14(), data.get件数_要支援2_14(), data.get件数_要支援計_14(),
                data.get件数_経過的要介護_14(), data.get件数_要介護1_14(), data.get件数_要介護2_14(), data.get件数_要介護3_14(),
                data.get件数_要介護4_14(), data.get件数_要介護5_14(), data.get件数_要介護計_14(), data.get件数_合計_14(),
                empty, data.get給付費_要支援1_14(), data.get給付費_要支援2_14(), data.get給付費_要支援計_14(),
                data.get給付費_経過的要介護_14(), data.get給付費_要介護1_14(), data.get給付費_要介護2_14(), data.get給付費_要介護3_14(),
                data.get給付費_要介護4_14(), data.get給付費_要介護5_14(), data.get給付費_要介護計_14(), data.get給付費_合計_14()
        ));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_15(), data.get件数_要支援2_15(), data.get件数_要支援計_15(),
                data.get件数_経過的要介護_15(), data.get件数_要介護1_15(), data.get件数_要介護2_15(), data.get件数_要介護3_15(),
                data.get件数_要介護4_15(), data.get件数_要介護5_15(), data.get件数_要介護計_15(), data.get件数_合計_15(),
                empty, data.get給付費_要支援1_15(), data.get給付費_要支援2_15(), data.get給付費_要支援計_15(),
                data.get給付費_経過的要介護_15(), data.get給付費_要介護1_15(),
                data.get給付費_要介護2_15(), data.get給付費_要介護3_15(), data.get給付費_要介護4_15(), data.get給付費_要介護5_15(),
                data.get給付費_要介護計_15(), data.get給付費_合計_15()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_16(), data.get件数_要支援2_16(), data.get件数_要支援計_16(),
                data.get件数_経過的要介護_16(), data.get件数_要介護1_16(), data.get件数_要介護2_16(), data.get件数_要介護3_16(),
                data.get件数_要介護4_16(), data.get件数_要介護5_16(), data.get件数_要介護計_16(), data.get件数_合計_16(),
                empty, data.get給付費_要支援1_16(), data.get給付費_要支援2_16(), data.get給付費_要支援計_16(),
                data.get給付費_経過的要介護_16(), data.get給付費_要介護1_16(), data.get給付費_要介護2_16(), data.get給付費_要介護3_16(),
                data.get給付費_要介護4_16(), data.get給付費_要介護5_16(), data.get給付費_要介護計_16(), data.get給付費_合計_16()));
        dataBodyList.add(new JigyohokokuGeppoYoshiki25BodyData(empty,
                data.get件数_要支援1_17(), data.get件数_要支援2_17(), data.get件数_要支援計_17(),
                data.get件数_経過的要介護_17(), data.get件数_要介護1_17(), data.get件数_要介護2_17(), data.get件数_要介護3_17(),
                data.get件数_要介護4_17(), data.get件数_要介護5_17(), data.get件数_要介護計_17(), data.get件数_合計_17(),
                empty, data.get給付費_要支援1_17(), data.get給付費_要支援2_17(), data.get給付費_要支援計_17(),
                data.get給付費_経過的要介護_17(), data.get給付費_要介護1_17(), data.get給付費_要介護2_17(), data.get給付費_要介護3_17(),
                data.get給付費_要介護4_17(), data.get給付費_要介護5_17(), data.get給付費_要介護計_17(), data.get給付費_合計_17()));
        return dataBodyList;
    }
}
