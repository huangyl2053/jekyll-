/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030040;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoippangenbutsu.JigyoHokokuNenpoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoippangenbutsu.GassanJigyouHoukokuTokeiEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307ReportSource;
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
 * 帳票設計_DBU300108_介護事業状況報告年報・一般状況のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-040 lishengli
 */
public class JigyoHokokuNenpoIppanGenbutsuDBU300108Process extends BatchProcessBase<GassanJigyouHoukokuTokeiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoippangenbutsu."
            + "IJigyoHokokuNenpoIppanGenbutsuMapper.getJigyouHokokuTokeiReportJyoho");
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final int 数値_10 = 10;
    private static final Decimal 数値_11 = new Decimal(11);
    private static final Decimal 数値_12 = new Decimal(12);
    private static final Decimal 数値_13 = new Decimal(13);
    private static final Decimal 数値_14 = new Decimal(14);
    private static final Decimal 数値_21 = new Decimal(21);
    private static final Decimal 数値_22 = new Decimal(22);
    private static final Decimal 数値_23 = new Decimal(23);
    private static final Decimal 数値_24 = new Decimal(24);
    private static final Decimal 数値_31 = new Decimal(31);
    private static final Decimal 数値_32 = new Decimal(32);
    private static final Decimal 数値_33 = new Decimal(33);
    private static final Decimal 数値_34 = new Decimal(34);
    private static final Decimal 数値_41 = new Decimal(41);
    private static final Decimal 数値_42 = new Decimal(42);
    private static final Decimal 数値_43 = new Decimal(43);
    private static final Decimal 数値_44 = new Decimal(44);
    private static final Decimal 数値_51 = new Decimal(51);
    private static final Decimal 数値_52 = new Decimal(52);
    private static final Decimal 数値_53 = new Decimal(53);
    private static final Decimal 数値_54 = new Decimal(54);
    private static final Decimal 数値_61 = new Decimal(61);
    private static final Decimal 数値_62 = new Decimal(62);
    private static final Decimal 数値_63 = new Decimal(63);
    private static final Decimal 数値_64 = new Decimal(64);
    private static final Decimal 数値_71 = new Decimal(71);
    private static final Decimal 数値_72 = new Decimal(72);
    private static final Decimal 数値_73 = new Decimal(73);
    private static final Decimal 数値_74 = new Decimal(74);
    private static final Decimal 数値_81 = new Decimal(81);
    private static final Decimal 数値_82 = new Decimal(82);
    private static final Decimal 数値_83 = new Decimal(83);
    private static final Decimal 数値_84 = new Decimal(84);
    private static final Decimal 数値_91 = new Decimal(91);
    private static final Decimal 数値_92 = new Decimal(92);
    private static final Decimal 数値_93 = new Decimal(93);
    private static final Decimal 数値_94 = new Decimal(94);
    private static final Decimal 数値_101 = new Decimal(101);
    private static final Decimal 数値_102 = new Decimal(102);
    private static final Decimal 数値_103 = new Decimal(103);
    private static final Decimal 数値_104 = new Decimal(104);
    private static final Decimal 数値_111 = new Decimal(111);
    private static final Decimal 数値_112 = new Decimal(112);
    private static final Decimal 数値_113 = new Decimal(113);
    private static final Decimal 数値_114 = new Decimal(114);
    private static final Decimal 数値_121 = new Decimal(121);
    private static final Decimal 数値_122 = new Decimal(122);
    private static final Decimal 数値_123 = new Decimal(123);
    private static final Decimal 数値_124 = new Decimal(124);
    private static final ReportId REPORT_DBU300108 = ReportIdDBU.DBU300108.getReportId();
    private JigyoHokokuNenpoIppanGenbutsuProcessParamter processParameter;
    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo1391;
    private Map<Decimal, Decimal> syukeiNo1392;
    private Map<Decimal, Decimal> syukeiNo1393;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki15307ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki15307ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        syukeiNo1391 = new HashMap<>();
        syukeiNo1392 = new HashMap<>();
        syukeiNo1393 = new HashMap<>();
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
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300108.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(GassanJigyouHoukokuTokeiEntity entity) {
        if (ShukeiNo.一般状況_14_施設介護サービス受給者数_介護老人福祉施設.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1391.put(entity.getYokoNo().multiply(数値_10).add(entity.getTateNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_15_施設介護サービス受給者数_介護老人保健施設.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1392.put(entity.getYokoNo().multiply(数値_10).add(entity.getTateNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_16_施設介護サービス受給者数_介護療養型医療施設_総数含む.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1393.put(entity.getYokoNo().multiply(数値_10).add(entity.getTateNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki15307Entity reportData = new JigyohokokuCompYoshiki15307Entity();
        reportData.set作成日時(processParameter.get処理日時());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.set集計年度(new FlexibleYear(processParameter.get集計年度()));
        reportData.set集計期間FROM(new FlexibleYearMonth(processParameter.get集計開始年月()));
        reportData.set集計期間TO(new FlexibleYearMonth(processParameter.get集計終了年月()));
        reportData.set給付集計区分(processParameter.get給付集計区分());
        reportData.set要支援1_1(getValue(syukeiNo1391, 数値_93));
        reportData.set要支援1_2(getValue(syukeiNo1391, 数値_91));
        reportData.set要支援1_3(getValue(syukeiNo1391, 数値_92));
        reportData.set要支援1_4(getValue(syukeiNo1392, 数値_93));
        reportData.set要支援1_5(getValue(syukeiNo1392, 数値_91));
        reportData.set要支援1_6(getValue(syukeiNo1392, 数値_92));
        reportData.set要支援1_7(getValue(syukeiNo1393, 数値_93));
        reportData.set要支援1_8(getValue(syukeiNo1393, 数値_91));
        reportData.set要支援1_9(getValue(syukeiNo1393, 数値_92));
        reportData.set要支援1_10(getValue(syukeiNo1393, 数値_94));
        reportData.set要支援2_1(getValue(syukeiNo1391, 数値_103));
        reportData.set要支援2_2(getValue(syukeiNo1391, 数値_101));
        reportData.set要支援2_3(getValue(syukeiNo1391, 数値_102));
        reportData.set要支援2_4(getValue(syukeiNo1392, 数値_103));
        reportData.set要支援2_5(getValue(syukeiNo1392, 数値_101));
        reportData.set要支援2_6(getValue(syukeiNo1392, 数値_102));
        reportData.set要支援2_7(getValue(syukeiNo1393, 数値_103));
        reportData.set要支援2_8(getValue(syukeiNo1393, 数値_101));
        reportData.set要支援2_9(getValue(syukeiNo1393, 数値_102));
        reportData.set要支援2_10(getValue(syukeiNo1393, 数値_104));
        reportData.set予防給付計_1(getValue(syukeiNo1391, 数値_113));
        reportData.set予防給付計_2(getValue(syukeiNo1391, 数値_111));
        reportData.set予防給付計_3(getValue(syukeiNo1391, 数値_112));
        reportData.set予防給付計_4(getValue(syukeiNo1392, 数値_113));
        reportData.set予防給付計_5(getValue(syukeiNo1392, 数値_111));
        reportData.set予防給付計_6(getValue(syukeiNo1392, 数値_112));
        reportData.set予防給付計_7(getValue(syukeiNo1393, 数値_113));
        reportData.set予防給付計_8(getValue(syukeiNo1393, 数値_111));
        reportData.set予防給付計_9(getValue(syukeiNo1393, 数値_112));
        reportData.set予防給付計_10(getValue(syukeiNo1393, 数値_114));
        reportData.set経過的要介護_1(getValue(syukeiNo1391, 数値_13));
        reportData.set経過的要介護_2(getValue(syukeiNo1391, 数値_11));
        reportData.set経過的要介護_3(getValue(syukeiNo1391, 数値_12));
        reportData.set経過的要介護_4(getValue(syukeiNo1392, 数値_13));
        reportData.set経過的要介護_5(getValue(syukeiNo1392, 数値_11));
        reportData.set経過的要介護_6(getValue(syukeiNo1392, 数値_12));
        reportData.set経過的要介護_7(getValue(syukeiNo1393, 数値_13));
        reportData.set経過的要介護_8(getValue(syukeiNo1393, 数値_11));
        reportData.set経過的要介護_9(getValue(syukeiNo1393, 数値_12));
        reportData.set経過的要介護_10(getValue(syukeiNo1393, 数値_14));
        reportData.set要介護1_1(getValue(syukeiNo1391, 数値_23));
        reportData.set要介護1_2(getValue(syukeiNo1391, 数値_21));
        reportData.set要介護1_3(getValue(syukeiNo1391, 数値_22));
        reportData.set要介護1_4(getValue(syukeiNo1392, 数値_23));
        reportData.set要介護1_5(getValue(syukeiNo1392, 数値_21));
        reportData.set要介護1_6(getValue(syukeiNo1392, 数値_22));
        reportData.set要介護1_7(getValue(syukeiNo1393, 数値_23));
        reportData.set要介護1_8(getValue(syukeiNo1393, 数値_21));
        reportData.set要介護1_9(getValue(syukeiNo1393, 数値_22));
        reportData.set要介護1_10(getValue(syukeiNo1393, 数値_24));
        reportData.set要介護2_1(getValue(syukeiNo1391, 数値_33));
        reportData.set要介護2_2(getValue(syukeiNo1391, 数値_31));
        reportData.set要介護2_3(getValue(syukeiNo1391, 数値_32));
        reportData.set要介護2_4(getValue(syukeiNo1392, 数値_33));
        reportData.set要介護2_5(getValue(syukeiNo1392, 数値_31));
        reportData.set要介護2_6(getValue(syukeiNo1392, 数値_32));
        reportData.set要介護2_7(getValue(syukeiNo1393, 数値_33));
        reportData.set要介護2_8(getValue(syukeiNo1393, 数値_31));
        reportData.set要介護2_9(getValue(syukeiNo1393, 数値_32));
        reportData.set要介護2_10(getValue(syukeiNo1393, 数値_34));
        reportData.set要介護3_1(getValue(syukeiNo1391, 数値_43));
        reportData.set要介護3_2(getValue(syukeiNo1391, 数値_41));
        reportData.set要介護3_3(getValue(syukeiNo1391, 数値_42));
        reportData.set要介護3_4(getValue(syukeiNo1392, 数値_43));
        reportData.set要介護3_5(getValue(syukeiNo1392, 数値_41));
        reportData.set要介護3_6(getValue(syukeiNo1392, 数値_42));
        reportData.set要介護3_7(getValue(syukeiNo1393, 数値_43));
        reportData.set要介護3_8(getValue(syukeiNo1393, 数値_41));
        reportData.set要介護3_9(getValue(syukeiNo1393, 数値_42));
        reportData.set要介護3_10(getValue(syukeiNo1393, 数値_44));
        reportData.set要介護4_1(getValue(syukeiNo1391, 数値_53));
        reportData.set要介護4_2(getValue(syukeiNo1391, 数値_51));
        reportData.set要介護4_3(getValue(syukeiNo1391, 数値_52));
        reportData.set要介護4_4(getValue(syukeiNo1392, 数値_53));
        reportData.set要介護4_5(getValue(syukeiNo1392, 数値_51));
        reportData.set要介護4_6(getValue(syukeiNo1392, 数値_52));
        reportData.set要介護4_7(getValue(syukeiNo1393, 数値_53));
        reportData.set要介護4_8(getValue(syukeiNo1393, 数値_51));
        reportData.set要介護4_9(getValue(syukeiNo1393, 数値_52));
        reportData.set要介護4_10(getValue(syukeiNo1393, 数値_54));
        reportData.set要介護5_1(getValue(syukeiNo1391, 数値_63));
        reportData.set要介護5_2(getValue(syukeiNo1391, 数値_61));
        reportData.set要介護5_3(getValue(syukeiNo1391, 数値_62));
        reportData.set要介護5_4(getValue(syukeiNo1392, 数値_63));
        reportData.set要介護5_5(getValue(syukeiNo1392, 数値_61));
        reportData.set要介護5_6(getValue(syukeiNo1392, 数値_62));
        reportData.set要介護5_7(getValue(syukeiNo1393, 数値_63));
        reportData.set要介護5_8(getValue(syukeiNo1393, 数値_61));
        reportData.set要介護5_9(getValue(syukeiNo1393, 数値_62));
        reportData.set要介護5_10(getValue(syukeiNo1393, 数値_64));
        reportData.setその他1(getValue(syukeiNo1391, 数値_73));
        reportData.setその他2(getValue(syukeiNo1391, 数値_71));
        reportData.setその他3(getValue(syukeiNo1391, 数値_72));
        reportData.setその他4(getValue(syukeiNo1392, 数値_73));
        reportData.setその他5(getValue(syukeiNo1392, 数値_71));
        reportData.setその他6(getValue(syukeiNo1392, 数値_72));
        reportData.setその他7(getValue(syukeiNo1393, 数値_73));
        reportData.setその他8(getValue(syukeiNo1393, 数値_71));
        reportData.setその他9(getValue(syukeiNo1393, 数値_72));
        reportData.setその他10(getValue(syukeiNo1393, 数値_74));
        reportData.set介護給付計_1(getValue(syukeiNo1391, 数値_83));
        reportData.set介護給付計_2(getValue(syukeiNo1391, 数値_81));
        reportData.set介護給付計_3(getValue(syukeiNo1391, 数値_82));
        reportData.set介護給付計_4(getValue(syukeiNo1392, 数値_83));
        reportData.set介護給付計_5(getValue(syukeiNo1392, 数値_81));
        reportData.set介護給付計_6(getValue(syukeiNo1392, 数値_82));
        reportData.set介護給付計_7(getValue(syukeiNo1393, 数値_83));
        reportData.set介護給付計_8(getValue(syukeiNo1393, 数値_81));
        reportData.set介護給付計_9(getValue(syukeiNo1393, 数値_82));
        reportData.set介護給付計_10(getValue(syukeiNo1393, 数値_84));
        reportData.set合計1(getValue(syukeiNo1391, 数値_123));
        reportData.set合計2(getValue(syukeiNo1391, 数値_121));
        reportData.set合計3(getValue(syukeiNo1391, 数値_122));
        reportData.set合計4(getValue(syukeiNo1392, 数値_123));
        reportData.set合計5(getValue(syukeiNo1392, 数値_121));
        reportData.set合計6(getValue(syukeiNo1392, 数値_122));
        reportData.set合計7(getValue(syukeiNo1393, 数値_123));
        reportData.set合計8(getValue(syukeiNo1393, 数値_121));
        reportData.set合計9(getValue(syukeiNo1393, 数値_122));
        reportData.set合計10(getValue(syukeiNo1393, 数値_124));
        JigyohokokuCompYoshiki15307Report report = new JigyohokokuCompYoshiki15307Report(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }

}
