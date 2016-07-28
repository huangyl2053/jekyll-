/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300003.YokaigoNinteiJisshiJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定実施状況表（統計表）のReportです。
 *
 * @reamsid_L DBD-1771-030 b_liuyang2
 */
public final class YokaigoNinteiJisshiJokyohyoReport extends Report<YokaigoNinteiJisshiJokyohyoReportSource> {

    private final FlexibleDate 基準日;
    private final RString 年齢;
    private final RString 地区;
    private final Code 集計単位;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist1;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist2;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist3;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist4;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリスト = new ArrayList();

    /**
     * インスタンスを生成します。
     *
     * @param 基準日 FlexibleDate
     * @param 年齢 RString
     * @param 地区 RString
     * @param 集計単位 Code
     * @param 実施状況Entityリストlist1 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist2 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist3 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist4 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @return 要介護認定実施状況表（統計表）
     */
    public static YokaigoNinteiJisshiJokyohyoReport createReport(FlexibleDate 基準日, RString 年齢, RString 地区,
            Code 集計単位, List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist1,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist2,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist3,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist4) {
        return new YokaigoNinteiJisshiJokyohyoReport(基準日, 年齢, 地区, 集計単位, 実施状況Entityリストlist1,
                実施状況Entityリストlist2, 実施状況Entityリストlist3, 実施状況Entityリストlist4);
    }

    private YokaigoNinteiJisshiJokyohyoReport(FlexibleDate 基準日, RString 年齢, RString 地区, Code 集計単位,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist1,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist2,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist3,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist4) {
        this.基準日 = 基準日;
        this.年齢 = 年齢;
        this.地区 = 地区;
        this.集計単位 = 集計単位;
        this.実施状況Entityリストlist1 = 実施状況Entityリストlist1;
        this.実施状況Entityリストlist2 = 実施状況Entityリストlist2;
        this.実施状況Entityリストlist3 = 実施状況Entityリストlist3;
        this.実施状況Entityリストlist4 = 実施状況Entityリストlist4;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiJisshiJokyohyoReportSource> writer) {
        for (int index = 0; index < 実施状況Entityリストlist1.size() && index < 実施状況Entityリストlist2.size()
                && index < 実施状況Entityリストlist3.size() && index < 実施状況Entityリストlist4.size(); index++) {
            IYokaigoNinteiJisshiJokyohyoEditor bodyEditor = new YokaigoNinteiJisshiJokyohyoEditor(基準日, 年齢, 地区,
                    集計単位, 実施状況Entityリスト, 実施状況Entityリストlist1, 実施状況Entityリストlist2,
                    実施状況Entityリストlist3, 実施状況Entityリストlist4, index);
            IYokaigoNinteiJisshiJokyohyoBuilder builder = new YokaigoNinteiJisshiJokyohyoBuilder(bodyEditor);
            writer.writeLine(builder);
        }
    }
}
