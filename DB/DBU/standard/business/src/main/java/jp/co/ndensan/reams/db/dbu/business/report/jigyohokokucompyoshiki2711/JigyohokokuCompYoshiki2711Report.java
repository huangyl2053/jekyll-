/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2711;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 介護事業状況報告年報（様式2-7)のレーポトです。
 *
 * @reamsid_L DBU-5600-280 guoqilin
 */
public class JigyohokokuCompYoshiki2711Report extends Report<JigyohokokuCompYoshiki2711ReportSource> {

    private final JigyohokokuCompYoshiki2711 data;

    /**
     * インスタンスを生成します。
     *
     * @param data 帳票発行のdataList
     */
    public JigyohokokuCompYoshiki2711Report(JigyohokokuCompYoshiki2711 data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki2711ReportSource> writer) {
        for (JigyohokokuCompYoshiki2711Change change : getData()) {
            IJigyohokokuCompYoshiki2711Editor editor = new JigyohokokuCompYoshiki2711Editor(data, change);
            IJigyohokokuCompYoshiki2711Builder builder = new JigyohokokuCompYoshiki2711Builder(editor);
            writer.writeLine(builder);
        }

    }

    private Iterable<JigyohokokuCompYoshiki2711Change> getData() {
        List<JigyohokokuCompYoshiki2711Change> dataList = new ArrayList<>();
        dataList.add(new JigyohokokuCompYoshiki2711Change(data.get件数_世帯合算_1(), data.get件数_その他_1(),
                data.get件数_計_1(), data.get給付額_世帯合算_1(), data.get給付額_その他_1(), data.get給付額_計_1()));
        dataList.add(new JigyohokokuCompYoshiki2711Change(data.get件数_世帯合算_2(), data.get件数_その他_2(),
                data.get件数_計_2(), data.get給付額_世帯合算_2(), data.get給付額_その他_2(), data.get給付額_計_2()));
        dataList.add(new JigyohokokuCompYoshiki2711Change(data.get件数_世帯合算_3(), data.get件数_その他_3(),
                data.get件数_計_3(), data.get給付額_世帯合算_3(), data.get給付額_その他_3(), data.get給付額_計_3()));
        dataList.add(new JigyohokokuCompYoshiki2711Change(data.get件数_世帯合算_4(), data.get件数_その他_4(),
                data.get件数_計_4(), data.get給付額_世帯合算_4(), data.get給付額_その他_4(), data.get給付額_計_4()));
        dataList.add(new JigyohokokuCompYoshiki2711Change(data.get件数_世帯合算_5(), data.get件数_その他_5(),
                data.get件数_計_5(), data.get給付額_世帯合算_5(), data.get給付額_その他_5(), data.get給付額_計_5()));
        dataList.add(new JigyohokokuCompYoshiki2711Change(data.get件数_世帯合算_6(), data.get件数_その他_6(),
                data.get件数_計_6(), data.get給付額_世帯合算_6(), data.get給付額_その他_6(), data.get給付額_計_6()));
        dataList.add(new JigyohokokuCompYoshiki2711Change(data.get件数_世帯合算_7(), data.get件数_その他_7(),
                data.get件数_計_7(), data.get給付額_世帯合算_7(), data.get給付額_その他_7(), data.get給付額_計_7()));
        dataList.add(new JigyohokokuCompYoshiki2711Change(data.get件数_世帯合算_8(), data.get件数_その他_8(),
                data.get件数_計_8(), data.get給付額_世帯合算_8(), data.get給付額_その他_8(), data.get給付額_計_8()));
        return dataList;
    }

}
