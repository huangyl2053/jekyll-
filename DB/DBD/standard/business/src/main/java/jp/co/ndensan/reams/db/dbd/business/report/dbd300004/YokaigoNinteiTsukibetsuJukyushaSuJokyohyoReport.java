/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoReportEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定月別受給者数状況表（統計表）のReportです。
 *
 * @reamsid_L DBD-1771-034 b_liuyang2
 */
public final class YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport extends
        Report<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource> {

    private static final int NOCOUNT_80 = 80;
    private final FlexibleDate 基準日;
    private final RString 年齢;
    private final RString 地区;
    private final RString 集計単位;
    private final FlexibleYear 年度;
    private final List<YokaigoNinteiJisshiJokyohyoReportEntity> 受給状況Entityリスト;

    /**
     * インスタンスを生成します。
     *
     * @param 基準日 FlexibleDate
     * @param 年齢 RString
     * @param 地区 RString
     * @param 集計単位 Code
     * @param 年度 FlexibleYear
     * @param 受給状況Entityリスト List<YokaigoNinteiJisshiJokyohyoEntity>
     * @return 要介護認定月別受給者数状況表（統計表）
     */
    public static YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport createReport(FlexibleDate 基準日, RString 年齢, RString 地区,
            RString 集計単位, FlexibleYear 年度, List<YokaigoNinteiJisshiJokyohyoReportEntity> 受給状況Entityリスト) {
        return new YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport(基準日, 年齢, 地区, 集計単位, 年度, 受給状況Entityリスト);
    }

    private YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport(FlexibleDate 基準日, RString 年齢, RString 地区,
            RString 集計単位, FlexibleYear 年度, List<YokaigoNinteiJisshiJokyohyoReportEntity> 受給状況Entityリスト) {
        this.基準日 = 基準日;
        this.年齢 = 年齢;
        this.地区 = 地区;
        this.集計単位 = 集計単位;
        this.年度 = 年度;
        this.受給状況Entityリスト = 受給状況Entityリスト;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource> writer) {
        for (int index = 0; index < NOCOUNT_80; index++) {
            IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoEditor bodyEditor
                    = new YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEditor(基準日, 年齢, 地区, 集計単位, 年度, 受給状況Entityリスト, index);
            IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoBuilder builder = new YokaigoNinteiTsukibetsuJukyushaSuJokyohyoBuilder(bodyEditor);
            writer.writeLine(builder);
        }
    }
}
