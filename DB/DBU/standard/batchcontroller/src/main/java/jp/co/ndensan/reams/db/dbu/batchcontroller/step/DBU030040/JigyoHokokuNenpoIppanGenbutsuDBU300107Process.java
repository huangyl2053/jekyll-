/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030040;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoippangenbutsu.JigyoHokokuNenpoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoippangenbutsu.GassanJigyouHoukokuTokeiEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206ReportSource;
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
 * 帳票設計_DBU300107_介護事業状況報告年報・一般状況帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-040 lishengli
 */
public class JigyoHokokuNenpoIppanGenbutsuDBU300107Process extends BatchProcessBase<GassanJigyouHoukokuTokeiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoippangenbutsu."
            + "IJigyoHokokuNenpoIppanGenbutsuMapper.getJigyouHokokuTokeiReportJyoho");
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final int 数値_10 = 10;
    private static final Decimal 数値_11 = new Decimal(11);
    private static final Decimal 数値_12 = new Decimal(12);
    private static final Decimal 数値_13 = new Decimal(13);
    private static final Decimal 数値_21 = new Decimal(21);
    private static final Decimal 数値_22 = new Decimal(22);
    private static final Decimal 数値_23 = new Decimal(23);
    private static final Decimal 数値_31 = new Decimal(31);
    private static final Decimal 数値_32 = new Decimal(32);
    private static final Decimal 数値_33 = new Decimal(33);
    private static final Decimal 数値_41 = new Decimal(41);
    private static final Decimal 数値_42 = new Decimal(42);
    private static final Decimal 数値_43 = new Decimal(43);
    private static final Decimal 数値_51 = new Decimal(51);
    private static final Decimal 数値_52 = new Decimal(52);
    private static final Decimal 数値_53 = new Decimal(53);
    private static final Decimal 数値_61 = new Decimal(61);
    private static final Decimal 数値_62 = new Decimal(62);
    private static final Decimal 数値_63 = new Decimal(63);
    private static final Decimal 数値_71 = new Decimal(71);
    private static final Decimal 数値_72 = new Decimal(72);
    private static final Decimal 数値_73 = new Decimal(73);
    private static final Decimal 数値_81 = new Decimal(81);
    private static final Decimal 数値_82 = new Decimal(82);
    private static final Decimal 数値_83 = new Decimal(83);
    private static final Decimal 数値_91 = new Decimal(91);
    private static final Decimal 数値_92 = new Decimal(92);
    private static final Decimal 数値_93 = new Decimal(93);
    private static final Decimal 数値_101 = new Decimal(101);
    private static final Decimal 数値_102 = new Decimal(102);
    private static final Decimal 数値_103 = new Decimal(103);
    private static final Decimal 数値_111 = new Decimal(111);
    private static final Decimal 数値_112 = new Decimal(112);
    private static final Decimal 数値_113 = new Decimal(113);
    private static final Decimal 数値_121 = new Decimal(121);
    private static final Decimal 数値_122 = new Decimal(122);
    private static final Decimal 数値_123 = new Decimal(123);
    private static final ReportId REPORT_DBU300107 = ReportIdDBU.DBU300107.getReportId();
    private JigyoHokokuNenpoIppanGenbutsuProcessParamter processParameter;
    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo1200;
    private Map<Decimal, Decimal> syukeiNo1400;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki15206ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki15206ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        syukeiNo1200 = new HashMap<>();
        syukeiNo1400 = new HashMap<>();
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
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300107.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(GassanJigyouHoukokuTokeiEntity entity) {
        if (ShukeiNo.一般状況_12_居宅介護_介護予防_サービス受給者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1200.put(entity.getYokoNo().multiply(数値_10).add(entity.getTateNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_13_地域密着型_介護予防_サービス受給者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1400.put(entity.getYokoNo().multiply(数値_10).add(entity.getTateNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki15206Entity reportData = new JigyohokokuCompYoshiki15206Entity();
        reportData.set作成日時(processParameter.get処理日時());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.set集計年度(new FlexibleYear(processParameter.get集計年度()));
        reportData.set集計期間FROM(new FlexibleYearMonth(processParameter.get集計開始年月()));
        reportData.set集計期間TO(new FlexibleYearMonth(processParameter.get集計終了年月()));
        reportData.set給付集計区分(processParameter.get給付集計区分());
        reportData.set居宅介護_要支援1_1(getValue(syukeiNo1200, 数値_91));
        reportData.set居宅介護_要支援1_2(getValue(syukeiNo1200, 数値_92));
        reportData.set居宅介護_要支援1_3(getValue(syukeiNo1200, 数値_93));
        reportData.set居宅介護_要支援2_1(getValue(syukeiNo1200, 数値_101));
        reportData.set居宅介護_要支援2_2(getValue(syukeiNo1200, 数値_102));
        reportData.set居宅介護_要支援2_3(getValue(syukeiNo1200, 数値_103));
        reportData.set居宅介護_予防給付計_1(getValue(syukeiNo1200, 数値_111));
        reportData.set居宅介護_予防給付計_2(getValue(syukeiNo1200, 数値_112));
        reportData.set居宅介護_予防給付計_3(getValue(syukeiNo1200, 数値_113));
        reportData.set居宅介護_経過的要介護_1(getValue(syukeiNo1200, 数値_11));
        reportData.set居宅介護_経過的要介護_2(getValue(syukeiNo1200, 数値_12));
        reportData.set居宅介護_経過的要介護_3(getValue(syukeiNo1200, 数値_13));
        reportData.set居宅介護_要介護1_1(getValue(syukeiNo1200, 数値_21));
        reportData.set居宅介護_要介護1_2(getValue(syukeiNo1200, 数値_22));
        reportData.set居宅介護_要介護1_3(getValue(syukeiNo1200, 数値_23));
        reportData.set居宅介護_要介護2_1(getValue(syukeiNo1200, 数値_31));
        reportData.set居宅介護_要介護2_2(getValue(syukeiNo1200, 数値_32));
        reportData.set居宅介護_要介護2_3(getValue(syukeiNo1200, 数値_33));
        reportData.set居宅介護_要介護3_1(getValue(syukeiNo1200, 数値_41));
        reportData.set居宅介護_要介護3_2(getValue(syukeiNo1200, 数値_42));
        reportData.set居宅介護_要介護3_3(getValue(syukeiNo1200, 数値_43));
        reportData.set居宅介護_要介護4_1(getValue(syukeiNo1200, 数値_51));
        reportData.set居宅介護_要介護4_2(getValue(syukeiNo1200, 数値_52));
        reportData.set居宅介護_要介護4_3(getValue(syukeiNo1200, 数値_53));
        reportData.set居宅介護_要介護5_1(getValue(syukeiNo1200, 数値_61));
        reportData.set居宅介護_要介護5_2(getValue(syukeiNo1200, 数値_62));
        reportData.set居宅介護_要介護5_3(getValue(syukeiNo1200, 数値_63));
        reportData.set居宅介護_介護給付計_1(getValue(syukeiNo1200, 数値_71));
        reportData.set居宅介護_介護給付計_2(getValue(syukeiNo1200, 数値_72));
        reportData.set居宅介護_介護給付計_3(getValue(syukeiNo1200, 数値_73));
        reportData.set居宅介護_合計1(getValue(syukeiNo1200, 数値_121));
        reportData.set居宅介護_合計2(getValue(syukeiNo1200, 数値_122));
        reportData.set居宅介護_合計3(getValue(syukeiNo1200, 数値_123));
        reportData.set地域密着型_要支援1_1(getValue(syukeiNo1400, 数値_91));
        reportData.set地域密着型_要支援1_2(getValue(syukeiNo1400, 数値_92));
        reportData.set地域密着型_要支援1_3(getValue(syukeiNo1400, 数値_93));
        reportData.set地域密着型_要支援2_1(getValue(syukeiNo1400, 数値_101));
        reportData.set地域密着型_要支援2_2(getValue(syukeiNo1400, 数値_102));
        reportData.set地域密着型_要支援2_3(getValue(syukeiNo1400, 数値_103));
        reportData.set地域密着型_予防給付計_1(getValue(syukeiNo1400, 数値_111));
        reportData.set地域密着型_予防給付計_2(getValue(syukeiNo1400, 数値_112));
        reportData.set地域密着型_予防給付計_3(getValue(syukeiNo1400, 数値_113));
        reportData.set地域密着型_経過的要介護_1(getValue(syukeiNo1400, 数値_11));
        reportData.set地域密着型_経過的要介護_2(getValue(syukeiNo1400, 数値_12));
        reportData.set地域密着型_経過的要介護_3(getValue(syukeiNo1400, 数値_13));
        reportData.set地域密着型_要介護1_1(getValue(syukeiNo1400, 数値_21));
        reportData.set地域密着型_要介護1_2(getValue(syukeiNo1400, 数値_22));
        reportData.set地域密着型_要介護1_3(getValue(syukeiNo1400, 数値_23));
        reportData.set地域密着型_要介護2_1(getValue(syukeiNo1400, 数値_31));
        reportData.set地域密着型_要介護2_2(getValue(syukeiNo1400, 数値_32));
        reportData.set地域密着型_要介護2_3(getValue(syukeiNo1400, 数値_33));
        reportData.set地域密着型_要介護3_1(getValue(syukeiNo1400, 数値_41));
        reportData.set地域密着型_要介護3_2(getValue(syukeiNo1400, 数値_42));
        reportData.set地域密着型_要介護3_3(getValue(syukeiNo1400, 数値_43));
        reportData.set地域密着型_要介護4_1(getValue(syukeiNo1400, 数値_51));
        reportData.set地域密着型_要介護4_2(getValue(syukeiNo1400, 数値_52));
        reportData.set地域密着型_要介護4_3(getValue(syukeiNo1400, 数値_53));
        reportData.set地域密着型_要介護5_1(getValue(syukeiNo1400, 数値_61));
        reportData.set地域密着型_要介護5_2(getValue(syukeiNo1400, 数値_62));
        reportData.set地域密着型_要介護5_3(getValue(syukeiNo1400, 数値_63));
        reportData.setその他1(getValue(syukeiNo1400, 数値_71));
        reportData.setその他2(getValue(syukeiNo1400, 数値_72));
        reportData.setその他3(getValue(syukeiNo1400, 数値_73));
        reportData.set地域密着型_介護給付計_1(getValue(syukeiNo1400, 数値_81));
        reportData.set地域密着型_介護給付計_2(getValue(syukeiNo1400, 数値_82));
        reportData.set地域密着型_介護給付計_3(getValue(syukeiNo1400, 数値_83));
        reportData.set地域密着型_合計1(getValue(syukeiNo1400, 数値_121));
        reportData.set地域密着型_合計2(getValue(syukeiNo1400, 数値_122));
        reportData.set地域密着型_合計3(getValue(syukeiNo1400, 数値_123));
        JigyohokokuCompYoshiki15206Report report = new JigyohokokuCompYoshiki15206Report(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }
}
