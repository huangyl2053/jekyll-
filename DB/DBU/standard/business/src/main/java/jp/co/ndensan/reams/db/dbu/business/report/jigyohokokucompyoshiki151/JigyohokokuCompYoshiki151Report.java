/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-080 dangjingjing
 */
public class JigyohokokuCompYoshiki151Report extends Report<JigyohokokuCompYoshiki151ReportSource> {

    private final JigyohokokuCompYoshiki151Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki151Report(JigyohokokuCompYoshiki151Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki151ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki151Change change : getBodyList()) {
            IJigyohokokuCompYoshiki151Editor editor = new JigyohokokuCompYoshiki151Editor(data);
            IJigyohokokuCompYoshiki151Editor bodyEditor = new JigyohokokuCompYoshiki151BodyEditor(change);
            IJigyohokokuCompYoshiki151Builder builder = new JigyohokokuCompYoshiki151Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki151Change> getBodyList() {
        List<JigyohokokuCompYoshiki151Change> list = new ArrayList<>();
        list.add(new JigyohokokuCompYoshiki151Change(data.get食費居住費の特例減額措置_第1号被保険者_1(),
                data.get食費居住費の特例減額措置_第2号被保険者_1(),
                data.get食費居住費の特例減額措置_合計_1(),
                data.get要支援認定者数_要支援1_1(),
                data.get要支援認定者数_要支援2_1(),
                data.get要支援認定者数_計_1(),
                data.get要介護認定者数_経過的要介護_1(),
                data.get要介護認定者数_要介護1_1(),
                data.get要介護認定者数_要介護2_1(),
                data.get要介護認定者数_要介護3_1(),
                data.get要介護認定者数_要介護4_1(),
                data.get要介護認定者数_要介護5_1(),
                data.get要介護認定者数_計_1(),
                data.get要介護認定者数_合計_1()));

        list.add(new JigyohokokuCompYoshiki151Change(data.get食費居住費の特例減額措置_第1号被保険者_2(),
                data.get食費居住費の特例減額措置_第2号被保険者_2(),
                data.get食費居住費の特例減額措置_合計_2(),
                data.get要支援認定者数_要支援1_2(),
                data.get要支援認定者数_要支援2_2(),
                data.get要支援認定者数_計_2(),
                data.get要介護認定者数_経過的要介護_2(),
                data.get要介護認定者数_要介護1_2(),
                data.get要介護認定者数_要介護2_2(),
                data.get要介護認定者数_要介護3_2(),
                data.get要介護認定者数_要介護4_2(),
                data.get要介護認定者数_要介護5_2(),
                data.get要介護認定者数_計_2(),
                data.get要介護認定者数_合計_2()));

        list.add(new JigyohokokuCompYoshiki151Change(data.get食費居住費の特例減額措置_第1号被保険者_3(),
                data.get食費居住費の特例減額措置_第2号被保険者_3(),
                data.get食費居住費の特例減額措置_合計_3(),
                data.get要支援認定者数_要支援1_3(),
                data.get要支援認定者数_要支援2_3(),
                data.get要支援認定者数_計_3(),
                data.get要介護認定者数_経過的要介護_3(),
                data.get要介護認定者数_要介護1_3(),
                data.get要介護認定者数_要介護2_3(),
                data.get要介護認定者数_要介護3_3(),
                data.get要介護認定者数_要介護4_3(),
                data.get要介護認定者数_要介護5_3(),
                data.get要介護認定者数_計_3(),
                data.get要介護認定者数_合計_3()));

        list.add(new JigyohokokuCompYoshiki151Change(data.get食費居住費の特例減額措置_第1号被保険者_4(),
                data.get食費居住費の特例減額措置_第2号被保険者_4(),
                data.get食費居住費の特例減額措置_合計_4(),
                data.get要支援認定者数_要支援1_4(),
                data.get要支援認定者数_要支援2_4(),
                data.get要支援認定者数_計_4(),
                data.get要介護認定者数_経過的要介護_4(),
                data.get要介護認定者数_要介護1_4(),
                data.get要介護認定者数_要介護2_4(),
                data.get要介護認定者数_要介護3_4(),
                data.get要介護認定者数_要介護4_4(),
                data.get要介護認定者数_要介護5_4(),
                data.get要介護認定者数_計_4(),
                data.get要介護認定者数_合計_4()));

        list.add(new JigyohokokuCompYoshiki151Change(data.get食費居住費の特例減額措置_第1号被保険者_5(),
                data.get食費居住費の特例減額措置_第2号被保険者_5(),
                data.get食費居住費の特例減額措置_合計_5(),
                data.get要支援認定者数_要支援1_5(),
                data.get要支援認定者数_要支援2_5(),
                data.get要支援認定者数_計_5(),
                data.get要介護認定者数_経過的要介護_5(),
                data.get要介護認定者数_要介護1_5(),
                data.get要介護認定者数_要介護2_5(),
                data.get要介護認定者数_要介護3_5(),
                data.get要介護認定者数_要介護4_5(),
                data.get要介護認定者数_要介護5_5(),
                data.get要介護認定者数_計_5(),
                data.get要介護認定者数_合計_5()));

        list.add(new JigyohokokuCompYoshiki151Change(data.get食費居住費の特例減額措置_第1号被保険者_6(),
                data.get食費居住費の特例減額措置_第2号被保険者_6(),
                data.get食費居住費の特例減額措置_合計_6(),
                data.get要支援認定者数_要支援1_6(),
                data.get要支援認定者数_要支援2_6(),
                data.get要支援認定者数_計_6(),
                data.get要介護認定者数_経過的要介護_6(),
                data.get要介護認定者数_要介護1_6(),
                data.get要介護認定者数_要介護2_6(),
                data.get要介護認定者数_要介護3_6(),
                data.get要介護認定者数_要介護4_6(),
                data.get要介護認定者数_要介護5_6(),
                data.get要介護認定者数_計_6(),
                data.get要介護認定者数_合計_6()));

        list.add(new JigyohokokuCompYoshiki151Change(data.get食費居住費の特例減額措置_第1号被保険者_7(),
                data.get食費居住費の特例減額措置_第2号被保険者_7(),
                data.get食費居住費の特例減額措置_合計_7(),
                data.get要支援認定者数_要支援1_7(),
                data.get要支援認定者数_要支援2_7(),
                data.get要支援認定者数_計_7(),
                data.get要介護認定者数_経過的要介護_7(),
                data.get要介護認定者数_要介護1_7(),
                data.get要介護認定者数_要介護2_7(),
                data.get要介護認定者数_要介護3_7(),
                data.get要介護認定者数_要介護4_7(),
                data.get要介護認定者数_要介護5_7(),
                data.get要介護認定者数_計_7(),
                data.get要介護認定者数_合計_7()));

        return list;
    }
}
