/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030100;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpohokenkyufukogaku.JigyoHokokuNenpoHokenkyufuKogakuProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoippangenbutsu.GassanJigyouHoukokuTokeiEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711ReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業状況報告資料（年報）作成　保険給付決定状況(高額分)のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-060 lishengli
 */
public class JigyoHokokuNenpoReportDBU300119Process extends BatchProcessBase<GassanJigyouHoukokuTokeiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpohokenkyufukogaku."
            + "IJigyoHokokuNenpoHokenkyufuKogakuMapper.getJigyouHokokuTokeiReportJyoho");
    private JigyoHokokuNenpoHokenkyufuKogakuProcessParamter processParameter;

    private static final ReportId REPORT_DBU300119 = ReportIdDBU.DBU300119.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final RString 年報月報区分CODE = new RString("2");
    private static final int 数値_10 = 10;
    private static final Decimal 数値_11 = new Decimal(11);
    private static final Decimal 数値_12 = new Decimal(12);
    private static final Decimal 数値_21 = new Decimal(21);
    private static final Decimal 数値_22 = new Decimal(22);

    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo0700;
    private Map<Decimal, Decimal> syukeiNo0701;
    private Map<Decimal, Decimal> syukeiNo0702;
    private Map<Decimal, Decimal> syukeiNo0703;
    private Map<Decimal, Decimal> syukeiNo0704;
    private Map<Decimal, Decimal> syukeiNo0705;
    private Map<Decimal, Decimal> syukeiNo0706;
    private Map<Decimal, Decimal> syukeiNo0707;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki2711ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki2711ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        syukeiNo0700 = new HashMap<>();
        syukeiNo0701 = new HashMap<>();
        syukeiNo0702 = new HashMap<>();
        syukeiNo0703 = new HashMap<>();
        syukeiNo0704 = new HashMap<>();
        syukeiNo0705 = new HashMap<>();
        syukeiNo0706 = new HashMap<>();
        syukeiNo0707 = new HashMap<>();
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        保険者番号 = 地方公共団体.get地方公共団体コード().value();
        if (過去集計分旧市町村区分.equals(processParameter.get過去集計分旧市町村区分())) {
            保険者名 = 固定文字列_旧.concat(地方公共団体.get市町村名());
        } else {
            保険者名 = 地方公共団体.get市町村名();
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSelectReportDataMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300119.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(GassanJigyouHoukokuTokeiEntity entity) {
        if (ShukeiNo.利用者負担第五段階_0700.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0700.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.利用者負担第四段階_0701.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0701.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.利用者負担第三段階_0702.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0702.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.利用者負担第二段階_0703.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0703.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.利用者負担第一段階_0704.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0704.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.合計_07.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0705.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.利用者負担第三段階_0706.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0706.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.利用者負担第二段階_0707.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0707.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki2711 reportData = new JigyohokokuCompYoshiki2711();
        reportData.set年報月報区分(年報月報区分CODE);
        reportData.set処理日時(processParameter.get処理日時());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.set集計年度(new FlexibleYear(processParameter.get集計年度()));
        reportData.set集計期間FROM(new FlexibleYearMonth(processParameter.get集計開始年月()));
        reportData.set集計期間TO(new FlexibleYearMonth(processParameter.get集計終了年月()));
        reportData.set件数_世帯合算_1(getValue(syukeiNo0700, 数値_11));
        reportData.set件数_世帯合算_2(getValue(syukeiNo0701, 数値_11));
        reportData.set件数_世帯合算_3(getValue(syukeiNo0702, 数値_11));
        reportData.set件数_世帯合算_4(getValue(syukeiNo0703, 数値_11));
        reportData.set件数_世帯合算_5(getValue(syukeiNo0704, 数値_11));
        reportData.set件数_世帯合算_6(getValue(syukeiNo0705, 数値_11));
        reportData.set件数_世帯合算_7(getValue(syukeiNo0706, 数値_11));
        reportData.set件数_世帯合算_8(getValue(syukeiNo0707, 数値_11));
        reportData.set件数_その他_1(getValue(syukeiNo0700, 数値_12));
        reportData.set件数_その他_2(getValue(syukeiNo0701, 数値_12));
        reportData.set件数_その他_3(getValue(syukeiNo0702, 数値_12));
        reportData.set件数_その他_4(getValue(syukeiNo0703, 数値_12));
        reportData.set件数_その他_5(getValue(syukeiNo0704, 数値_12));
        reportData.set件数_その他_6(getValue(syukeiNo0705, 数値_12));
        reportData.set件数_その他_7(getValue(syukeiNo0706, 数値_12));
        reportData.set件数_その他_8(getValue(syukeiNo0707, 数値_12));
        reportData.set件数_計_1(get合計値(syukeiNo0700, 数値_11, syukeiNo0700, 数値_12));
        reportData.set件数_計_2(get合計値(syukeiNo0701, 数値_11, syukeiNo0701, 数値_12));
        reportData.set件数_計_3(get合計値(syukeiNo0702, 数値_11, syukeiNo0702, 数値_12));
        reportData.set件数_計_4(get合計値(syukeiNo0703, 数値_11, syukeiNo0703, 数値_12));
        reportData.set件数_計_5(get合計値(syukeiNo0704, 数値_11, syukeiNo0704, 数値_12));
        reportData.set件数_計_6(get合計値(syukeiNo0705, 数値_11, syukeiNo0705, 数値_12));
        reportData.set件数_計_7(get合計値(syukeiNo0706, 数値_11, syukeiNo0706, 数値_12));
        reportData.set件数_計_8(get合計値(syukeiNo0707, 数値_11, syukeiNo0707, 数値_12));
        reportData.set給付額_世帯合算_1(getValue(syukeiNo0700, 数値_21));
        reportData.set給付額_世帯合算_2(getValue(syukeiNo0701, 数値_21));
        reportData.set給付額_世帯合算_3(getValue(syukeiNo0702, 数値_21));
        reportData.set給付額_世帯合算_4(getValue(syukeiNo0703, 数値_21));
        reportData.set給付額_世帯合算_5(getValue(syukeiNo0704, 数値_21));
        reportData.set給付額_世帯合算_6(getValue(syukeiNo0705, 数値_21));
        reportData.set給付額_世帯合算_7(getValue(syukeiNo0706, 数値_21));
        reportData.set給付額_世帯合算_8(getValue(syukeiNo0707, 数値_21));
        reportData.set給付額_その他_1(getValue(syukeiNo0700, 数値_22));
        reportData.set給付額_その他_2(getValue(syukeiNo0701, 数値_22));
        reportData.set給付額_その他_3(getValue(syukeiNo0702, 数値_22));
        reportData.set給付額_その他_4(getValue(syukeiNo0703, 数値_22));
        reportData.set給付額_その他_5(getValue(syukeiNo0704, 数値_22));
        reportData.set給付額_その他_6(getValue(syukeiNo0705, 数値_22));
        reportData.set給付額_その他_7(getValue(syukeiNo0706, 数値_22));
        reportData.set給付額_その他_8(getValue(syukeiNo0707, 数値_22));
        reportData.set給付額_計_1(get合計値(syukeiNo0700, 数値_21, syukeiNo0700, 数値_22));
        reportData.set給付額_計_2(get合計値(syukeiNo0701, 数値_21, syukeiNo0701, 数値_22));
        reportData.set給付額_計_3(get合計値(syukeiNo0702, 数値_21, syukeiNo0702, 数値_22));
        reportData.set給付額_計_4(get合計値(syukeiNo0703, 数値_21, syukeiNo0703, 数値_22));
        reportData.set給付額_計_5(get合計値(syukeiNo0704, 数値_21, syukeiNo0704, 数値_22));
        reportData.set給付額_計_6(get合計値(syukeiNo0705, 数値_21, syukeiNo0705, 数値_22));
        reportData.set給付額_計_7(get合計値(syukeiNo0706, 数値_21, syukeiNo0706, 数値_22));
        reportData.set給付額_計_8(get合計値(syukeiNo0707, 数値_21, syukeiNo0707, 数値_22));
        JigyohokokuCompYoshiki2711Report report = new JigyohokokuCompYoshiki2711Report(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }

    private RString get合計値(Map<Decimal, Decimal> 世帯合算Map, Decimal 世帯合算key, Map<Decimal, Decimal> その他Map, Decimal その他key) {
        Decimal 合計値 = Decimal.ZERO;
        if (世帯合算Map != null && 世帯合算Map.get(世帯合算key) != null) {
            合計値 = 合計値.add(世帯合算Map.get(世帯合算key));
        }
        if (その他Map != null && その他Map.get(その他key) != null) {
            合計値 = 合計値.add(その他Map.get(その他key));
        }
        if (!合計値.equals(Decimal.ZERO)) {
            return new RString(合計値.longValue());
        }
        return RString.EMPTY;
    }
}
