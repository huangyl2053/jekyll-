/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpoyoshiki1of1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1of1.JigyohokokuGeppoYoshikiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1of1.JigyohokokuToukeiData;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki1of1.JigyohokokuNenpoYoshiki1of1ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業状況報告年報（様式１・２　被保険者数）のReportです。
 *
 * @reamsid_L DBU-5610-040 sunhaidi
 */
public class JigyohokokuGeppoYoshikiReport extends Report<JigyohokokuNenpoYoshiki1of1ReportSource> {

    private final JigyohokokuGeppoYoshikiEntity entity;

    private static final int 横番号_1 = 1;
    private static final int 横番号_2 = 2;
    private static final int 横番号_3 = 3;
    private static final int 横番号_4 = 4;
    private static final int 横番号_5 = 5;
    private static final int 横番号_6 = 6;
    private static final int 縦番号 = 5;

    /**
     * インスタンスを生成します。
     *
     * @param entity 申請に関する帳票発行
     */
    public JigyohokokuGeppoYoshikiReport(JigyohokokuGeppoYoshikiEntity entity) {
        this.entity = entity;
    }

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuGeppoYoshikiEntity
     * @return JigyohokokuGeppoYoshikiReport
     */
    public static JigyohokokuGeppoYoshikiReport createReport(JigyohokokuGeppoYoshikiEntity entity) {
        return new JigyohokokuGeppoYoshikiReport(entity);
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuNenpoYoshiki1of1ReportSource> reportSourceWriter) {
        for (JigyohokokuGeppoYoshikiData dataBody : getBodyData()) {
            IJigyohokokuGeppoYoshikiEditor editor = new JigyohokokuGeppoYoshikiEditor(entity);
            IJigyohokokuGeppoYoshikiEditor bodyEditor = new JigyohokokuGeppoYoshikiBodyEditor(dataBody);
            IJigyohokokuGeppoYoshikiBuilder builder = new JigyohokokuGeppoYoshikiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuGeppoYoshikiData> getBodyData() {
        List<JigyohokokuGeppoYoshikiData> dataBodyList = new ArrayList<>();
        List<JigyohokokuToukeiData> dataList = entity.getDataList();
        Collections.sort(dataList, new DataCompare());
        for (int i = 1; i <= 縦番号; i++) {
            JigyohokokuGeppoYoshikiData yoshikiData = new JigyohokokuGeppoYoshikiData();
            for (JigyohokokuToukeiData data : dataList) {
                if (new RString("0100").equals(data.get表番号())) {
                    if (横番号_1 == data.get横番号()) {
                        yoshikiData.setList1_1(data.get集計結果値());
                    } else if (横番号_2 == data.get横番号()) {
                        yoshikiData.setList1_2(data.get集計結果値());
                    } else if (横番号_3 == data.get横番号()) {
                        yoshikiData.setList1_3(data.get集計結果値());
                    } else if (横番号_4 == data.get横番号()) {
                        yoshikiData.setList1_4(data.get集計結果値());
                    }
                } else if (new RString("0200").equals(data.get表番号())) {
                    if (横番号_1 == data.get横番号()) {
                        yoshikiData.setList2_1(data.get集計結果値());
                    } else if (横番号_2 == data.get横番号()) {
                        yoshikiData.setList2_2(data.get集計結果値());
                    } else if (縦番号 == data.get縦番号() && 横番号_3 == data.get横番号()) {
                        yoshikiData.setList2_3(data.get集計結果値());
                    } else if (縦番号 == data.get縦番号() && 横番号_4 == data.get横番号()) {
                        yoshikiData.setList2_4(data.get集計結果値());
                    }
                } else if (i <= data.get縦番号() && new RString("0301").equals(data.get表番号())) {
                    setList3Upper(data, yoshikiData);
                } else if (i <= data.get縦番号() && new RString("0302").equals(data.get表番号())) {
                    setList3Lower(data, yoshikiData);
                }
            }

            dataBodyList.add(yoshikiData);
        }
        return dataBodyList;
    }

    private void setList3Upper(JigyohokokuToukeiData data, JigyohokokuGeppoYoshikiData yoshikiData) {
        if (横番号_1 == data.get横番号()) {
            yoshikiData.setList3Upper_1(data.get集計結果値());
        } else if (横番号_2 == data.get横番号()) {
            yoshikiData.setList3Upper_2(data.get集計結果値());
        } else if (横番号_3 == data.get横番号()) {
            yoshikiData.setList3Upper_3(data.get集計結果値());
        } else if (横番号_4 == data.get横番号()) {
            yoshikiData.setList3Upper_4(data.get集計結果値());
        } else if (横番号_5 == data.get横番号()) {
            yoshikiData.setList3Upper_5(data.get集計結果値());
        } else if (横番号_6 == data.get横番号()) {
            yoshikiData.setList3Upper_6(data.get集計結果値());
        }
    }

    private void setList3Lower(JigyohokokuToukeiData data, JigyohokokuGeppoYoshikiData yoshikiData) {
        if (横番号_1 == data.get横番号()) {
            yoshikiData.setList3Lower_1(data.get集計結果値());
        } else if (横番号_2 == data.get横番号()) {
            yoshikiData.setList3Lower_2(data.get集計結果値());
        } else if (横番号_3 == data.get横番号()) {
            yoshikiData.setList3Lower_3(data.get集計結果値());
        } else if (横番号_4 == data.get横番号()) {
            yoshikiData.setList3Lower_4(data.get集計結果値());
        } else if (横番号_5 == data.get横番号()) {
            yoshikiData.setList3Lower_5(data.get集計結果値());
        } else if (横番号_6 == data.get横番号()) {
            yoshikiData.setList3Lower_6(data.get集計結果値());
        }
    }

    private static class DataCompare implements Comparator<JigyohokokuToukeiData>, Serializable {

        private static final long serialVersionUID = -5854152609876964411L;

        @Override
        public int compare(JigyohokokuToukeiData o1, JigyohokokuToukeiData o2) {
            if (RString.isNullOrEmpty(o1.get表番号()) || RString.isNullOrEmpty(o2.get表番号())) {
                return 0;
            }
            if (o1.get表番号().compareTo(o2.get表番号()) < 0) {
                return -1;
            } else if (0 < o1.get表番号().compareTo(o2.get表番号())) {
                return 1;
            }
            if (o1.get横番号() < o2.get縦番号()) {
                return -1;
            } else if (o2.get縦番号() < o1.get横番号()) {
                return 1;
            }
            if (o1.get縦番号() < o2.get縦番号()) {
                return -1;
            } else if (o2.get縦番号() < o1.get縦番号()) {
                return 1;
            }
            return 0;
        }
    }
}
