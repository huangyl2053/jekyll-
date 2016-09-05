/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki26.JigyohokokuCompYoshiki26Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpohokenkyufugenbutsu.JigyoHokokuNenpoHokenkyufuGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki26.JigyohokokuCompYoshiki26;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoippangenbutsu.GassanJigyouHoukokuTokeiEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.JigyohokokuCompYoshiki26.JigyohokokuCompYoshiki26ReportSource;
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
 * 介護事業状況報告年報（様式2-5）帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-050 lishengli
 */
public class JigyoHokokuNenpoReportDBU300117Process extends BatchProcessBase<GassanJigyouHoukokuTokeiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpohokenkyufugenbutsu."
            + "IJigyoHokokuNenpoHokenkyufuGenbutsuMapper.getJigyouHokokuTokeiReportJyoho");
    private JigyoHokokuNenpoHokenkyufuGenbutsuProcessParamter processParameter;

    private static final ReportId REPORT_DBU300117 = ReportIdDBU.DBU300117.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final RString 年報月報区分CODE = new RString("2");
    private static final RString 現物分 = new RString("1");
    private static final RString 償還審査分 = new RString("2");
    private static final RString 償還決定分 = new RString("3");
    private static final int 数値_100 = 100;
    private static final Decimal 数値_201 = new Decimal(201);
    private static final Decimal 数値_202 = new Decimal(202);
    private static final Decimal 数値_203 = new Decimal(203);
    private static final Decimal 数値_204 = new Decimal(204);
    private static final Decimal 数値_205 = new Decimal(205);
    private static final Decimal 数値_206 = new Decimal(206);
    private static final Decimal 数値_207 = new Decimal(207);
    private static final Decimal 数値_208 = new Decimal(208);
    private static final Decimal 数値_209 = new Decimal(209);
    private static final Decimal 数値_210 = new Decimal(210);
    private static final Decimal 数値_211 = new Decimal(211);
    private static final Decimal 数値_212 = new Decimal(212);
    private static final Decimal 数値_213 = new Decimal(213);
    private static final Decimal 数値_214 = new Decimal(214);
    private static final Decimal 数値_215 = new Decimal(215);
    private static final Decimal 数値_216 = new Decimal(216);
    private static final Decimal 数値_217 = new Decimal(217);
    private static final Decimal 数値_301 = new Decimal(301);
    private static final Decimal 数値_302 = new Decimal(302);
    private static final Decimal 数値_303 = new Decimal(303);
    private static final Decimal 数値_304 = new Decimal(304);
    private static final Decimal 数値_305 = new Decimal(305);
    private static final Decimal 数値_306 = new Decimal(306);
    private static final Decimal 数値_307 = new Decimal(307);
    private static final Decimal 数値_308 = new Decimal(308);
    private static final Decimal 数値_309 = new Decimal(309);
    private static final Decimal 数値_310 = new Decimal(310);
    private static final Decimal 数値_311 = new Decimal(311);
    private static final Decimal 数値_312 = new Decimal(312);
    private static final Decimal 数値_313 = new Decimal(313);
    private static final Decimal 数値_314 = new Decimal(314);
    private static final Decimal 数値_315 = new Decimal(315);
    private static final Decimal 数値_316 = new Decimal(316);
    private static final Decimal 数値_317 = new Decimal(317);
    private static final Decimal 数値_401 = new Decimal(401);
    private static final Decimal 数値_402 = new Decimal(402);
    private static final Decimal 数値_403 = new Decimal(403);
    private static final Decimal 数値_404 = new Decimal(404);
    private static final Decimal 数値_405 = new Decimal(405);
    private static final Decimal 数値_406 = new Decimal(406);
    private static final Decimal 数値_407 = new Decimal(407);
    private static final Decimal 数値_408 = new Decimal(408);
    private static final Decimal 数値_409 = new Decimal(409);
    private static final Decimal 数値_410 = new Decimal(410);
    private static final Decimal 数値_411 = new Decimal(411);
    private static final Decimal 数値_412 = new Decimal(412);
    private static final Decimal 数値_413 = new Decimal(413);
    private static final Decimal 数値_414 = new Decimal(414);
    private static final Decimal 数値_415 = new Decimal(415);
    private static final Decimal 数値_416 = new Decimal(416);
    private static final Decimal 数値_417 = new Decimal(417);
    private static final Decimal 数値_501 = new Decimal(501);
    private static final Decimal 数値_502 = new Decimal(502);
    private static final Decimal 数値_503 = new Decimal(503);
    private static final Decimal 数値_504 = new Decimal(504);
    private static final Decimal 数値_505 = new Decimal(505);
    private static final Decimal 数値_506 = new Decimal(506);
    private static final Decimal 数値_507 = new Decimal(507);
    private static final Decimal 数値_508 = new Decimal(508);
    private static final Decimal 数値_509 = new Decimal(509);
    private static final Decimal 数値_510 = new Decimal(510);
    private static final Decimal 数値_511 = new Decimal(511);
    private static final Decimal 数値_512 = new Decimal(512);
    private static final Decimal 数値_513 = new Decimal(513);
    private static final Decimal 数値_514 = new Decimal(514);
    private static final Decimal 数値_515 = new Decimal(515);
    private static final Decimal 数値_516 = new Decimal(516);
    private static final Decimal 数値_517 = new Decimal(517);
    private static final Decimal 数値_601 = new Decimal(601);
    private static final Decimal 数値_602 = new Decimal(602);
    private static final Decimal 数値_603 = new Decimal(603);
    private static final Decimal 数値_604 = new Decimal(604);
    private static final Decimal 数値_605 = new Decimal(605);
    private static final Decimal 数値_606 = new Decimal(606);
    private static final Decimal 数値_607 = new Decimal(607);
    private static final Decimal 数値_608 = new Decimal(608);
    private static final Decimal 数値_609 = new Decimal(609);
    private static final Decimal 数値_610 = new Decimal(610);
    private static final Decimal 数値_611 = new Decimal(611);
    private static final Decimal 数値_612 = new Decimal(612);
    private static final Decimal 数値_613 = new Decimal(613);
    private static final Decimal 数値_614 = new Decimal(614);
    private static final Decimal 数値_615 = new Decimal(615);
    private static final Decimal 数値_616 = new Decimal(616);
    private static final Decimal 数値_617 = new Decimal(617);
    private static final Decimal 数値_701 = new Decimal(701);
    private static final Decimal 数値_702 = new Decimal(702);
    private static final Decimal 数値_703 = new Decimal(703);
    private static final Decimal 数値_704 = new Decimal(704);
    private static final Decimal 数値_705 = new Decimal(705);
    private static final Decimal 数値_706 = new Decimal(706);
    private static final Decimal 数値_707 = new Decimal(707);
    private static final Decimal 数値_708 = new Decimal(708);
    private static final Decimal 数値_709 = new Decimal(709);
    private static final Decimal 数値_710 = new Decimal(710);
    private static final Decimal 数値_711 = new Decimal(711);
    private static final Decimal 数値_712 = new Decimal(712);
    private static final Decimal 数値_713 = new Decimal(713);
    private static final Decimal 数値_714 = new Decimal(714);
    private static final Decimal 数値_715 = new Decimal(715);
    private static final Decimal 数値_716 = new Decimal(716);
    private static final Decimal 数値_717 = new Decimal(717);
    private static final Decimal 数値_801 = new Decimal(801);
    private static final Decimal 数値_802 = new Decimal(802);
    private static final Decimal 数値_803 = new Decimal(803);
    private static final Decimal 数値_804 = new Decimal(804);
    private static final Decimal 数値_805 = new Decimal(805);
    private static final Decimal 数値_806 = new Decimal(806);
    private static final Decimal 数値_807 = new Decimal(807);
    private static final Decimal 数値_808 = new Decimal(808);
    private static final Decimal 数値_809 = new Decimal(809);
    private static final Decimal 数値_810 = new Decimal(810);
    private static final Decimal 数値_811 = new Decimal(811);
    private static final Decimal 数値_812 = new Decimal(812);
    private static final Decimal 数値_813 = new Decimal(813);
    private static final Decimal 数値_814 = new Decimal(814);
    private static final Decimal 数値_815 = new Decimal(815);
    private static final Decimal 数値_816 = new Decimal(816);
    private static final Decimal 数値_817 = new Decimal(817);
    private static final Decimal 数値_901 = new Decimal(901);
    private static final Decimal 数値_902 = new Decimal(902);
    private static final Decimal 数値_903 = new Decimal(903);
    private static final Decimal 数値_904 = new Decimal(904);
    private static final Decimal 数値_905 = new Decimal(905);
    private static final Decimal 数値_906 = new Decimal(906);
    private static final Decimal 数値_907 = new Decimal(907);
    private static final Decimal 数値_908 = new Decimal(908);
    private static final Decimal 数値_909 = new Decimal(909);
    private static final Decimal 数値_910 = new Decimal(910);
    private static final Decimal 数値_911 = new Decimal(911);
    private static final Decimal 数値_912 = new Decimal(912);
    private static final Decimal 数値_913 = new Decimal(913);
    private static final Decimal 数値_914 = new Decimal(914);
    private static final Decimal 数値_915 = new Decimal(915);
    private static final Decimal 数値_916 = new Decimal(916);
    private static final Decimal 数値_917 = new Decimal(917);
    private static final Decimal 数値_1001 = new Decimal(1001);
    private static final Decimal 数値_1002 = new Decimal(1002);
    private static final Decimal 数値_1003 = new Decimal(1003);
    private static final Decimal 数値_1004 = new Decimal(1004);
    private static final Decimal 数値_1005 = new Decimal(1005);
    private static final Decimal 数値_1006 = new Decimal(1006);
    private static final Decimal 数値_1007 = new Decimal(1007);
    private static final Decimal 数値_1008 = new Decimal(1008);
    private static final Decimal 数値_1009 = new Decimal(1009);
    private static final Decimal 数値_1010 = new Decimal(1010);
    private static final Decimal 数値_1011 = new Decimal(1011);
    private static final Decimal 数値_1012 = new Decimal(1012);
    private static final Decimal 数値_1013 = new Decimal(1013);
    private static final Decimal 数値_1014 = new Decimal(1014);
    private static final Decimal 数値_1015 = new Decimal(1015);
    private static final Decimal 数値_1016 = new Decimal(1016);
    private static final Decimal 数値_1017 = new Decimal(1017);
    private static final Decimal 数値_1101 = new Decimal(1101);
    private static final Decimal 数値_1102 = new Decimal(1102);
    private static final Decimal 数値_1103 = new Decimal(1103);
    private static final Decimal 数値_1104 = new Decimal(1104);
    private static final Decimal 数値_1105 = new Decimal(1105);
    private static final Decimal 数値_1106 = new Decimal(1106);
    private static final Decimal 数値_1107 = new Decimal(1107);
    private static final Decimal 数値_1108 = new Decimal(1108);
    private static final Decimal 数値_1109 = new Decimal(1109);
    private static final Decimal 数値_1110 = new Decimal(1110);
    private static final Decimal 数値_1111 = new Decimal(1111);
    private static final Decimal 数値_1112 = new Decimal(1112);
    private static final Decimal 数値_1113 = new Decimal(1113);
    private static final Decimal 数値_1114 = new Decimal(1114);
    private static final Decimal 数値_1115 = new Decimal(1115);
    private static final Decimal 数値_1116 = new Decimal(1116);
    private static final Decimal 数値_1117 = new Decimal(1117);
    private static final Decimal 数値_1201 = new Decimal(1201);
    private static final Decimal 数値_1202 = new Decimal(1202);
    private static final Decimal 数値_1203 = new Decimal(1203);
    private static final Decimal 数値_1204 = new Decimal(1204);
    private static final Decimal 数値_1205 = new Decimal(1205);
    private static final Decimal 数値_1206 = new Decimal(1206);
    private static final Decimal 数値_1207 = new Decimal(1207);
    private static final Decimal 数値_1208 = new Decimal(1208);
    private static final Decimal 数値_1209 = new Decimal(1209);
    private static final Decimal 数値_1210 = new Decimal(1210);
    private static final Decimal 数値_1211 = new Decimal(1211);
    private static final Decimal 数値_1212 = new Decimal(1212);
    private static final Decimal 数値_1213 = new Decimal(1213);
    private static final Decimal 数値_1214 = new Decimal(1214);
    private static final Decimal 数値_1215 = new Decimal(1215);
    private static final Decimal 数値_1216 = new Decimal(1216);
    private static final Decimal 数値_1217 = new Decimal(1217);

    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo0105;
    private Map<Decimal, Decimal> syukeiNo0106;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki26ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki26ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        syukeiNo0105 = new HashMap<>();
        syukeiNo0106 = new HashMap<>();
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
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300117.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(GassanJigyouHoukokuTokeiEntity entity) {
        if (ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_件数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0105.put(entity.getYokoNo().multiply(数値_100).add(entity.getTateNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_給付費.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0106.put(entity.getYokoNo().multiply(数値_100).add(entity.getTateNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki26 reportData = new JigyohokokuCompYoshiki26();
        reportData.set様式(new RString("様式２の５"));
        reportData.set処理日時(processParameter.get処理日時());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.set年報月報区分(年報月報区分CODE);
        reportData.set集計年度(new FlexibleYear(processParameter.get集計年度()));
        reportData.set集計期間FROM(new FlexibleYearMonth(processParameter.get集計開始年月()));
        reportData.set集計期間TO(new FlexibleYearMonth(processParameter.get集計終了年月()));
        reportData.setタイトル1(getタイトル1(processParameter.get給付集計区分()));
        reportData.setタイトル2(new RString("①総　数"));
        reportData.set給付集計区分(processParameter.get給付集計区分());
        reportData = set件数集計結果(reportData);
        reportData = set給付額集計結果(reportData);
        JigyohokokuCompYoshiki26Report report = new JigyohokokuCompYoshiki26Report(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }

    private RString getタイトル1(RString 給付集計区分) {
        RString タイトル1 = RString.EMPTY;
        if (現物分.equals(給付集計区分)) {
            タイトル1 = new RString("（２）特定入所者介護（介護予防）サービス費（別掲）（現物分）");
        } else if (償還審査分.equals(給付集計区分)) {
            タイトル1 = new RString("（２）特定入所者介護（介護予防）サービス費（別掲）（償還分）");
        } else if (償還決定分.equals(給付集計区分)) {
            タイトル1 = new RString("（２）特定入所者介護（介護予防）サービス費（別掲）（償還分）");
        }
        return タイトル1;
    }

    private JigyohokokuCompYoshiki26 set件数集計結果(JigyohokokuCompYoshiki26 reportData) {
        reportData.set件数_要支援1_1(getValue(syukeiNo0105, 数値_901));
        reportData.set件数_要支援1_2(getValue(syukeiNo0105, 数値_904));
        reportData.set件数_要支援1_3(getValue(syukeiNo0105, 数値_905));
        reportData.set件数_要支援1_4(getValue(syukeiNo0105, 数値_906));
        reportData.set件数_要支援1_5(getValue(syukeiNo0105, 数値_916));
        reportData.set件数_要支援1_6(getValue(syukeiNo0105, 数値_907));
        reportData.set件数_要支援1_7(getValue(syukeiNo0105, 数値_908));
        reportData.set件数_要支援1_8(getValue(syukeiNo0105, 数値_909));
        reportData.set件数_要支援1_9(getValue(syukeiNo0105, 数値_902));
        reportData.set件数_要支援1_10(getValue(syukeiNo0105, 数値_910));
        reportData.set件数_要支援1_11(getValue(syukeiNo0105, 数値_911));
        reportData.set件数_要支援1_12(getValue(syukeiNo0105, 数値_912));
        reportData.set件数_要支援1_13(getValue(syukeiNo0105, 数値_917));
        reportData.set件数_要支援1_14(getValue(syukeiNo0105, 数値_913));
        reportData.set件数_要支援1_15(getValue(syukeiNo0105, 数値_914));
        reportData.set件数_要支援1_16(getValue(syukeiNo0105, 数値_915));
        reportData.set件数_要支援1_17(getValue(syukeiNo0105, 数値_903));
        reportData.set件数_要支援2_1(getValue(syukeiNo0105, 数値_1001));
        reportData.set件数_要支援2_2(getValue(syukeiNo0105, 数値_1004));
        reportData.set件数_要支援2_3(getValue(syukeiNo0105, 数値_1005));
        reportData.set件数_要支援2_4(getValue(syukeiNo0105, 数値_1006));
        reportData.set件数_要支援2_5(getValue(syukeiNo0105, 数値_1016));
        reportData.set件数_要支援2_6(getValue(syukeiNo0105, 数値_1007));
        reportData.set件数_要支援2_7(getValue(syukeiNo0105, 数値_1008));
        reportData.set件数_要支援2_8(getValue(syukeiNo0105, 数値_1009));
        reportData.set件数_要支援2_9(getValue(syukeiNo0105, 数値_1002));
        reportData.set件数_要支援2_10(getValue(syukeiNo0105, 数値_1010));
        reportData.set件数_要支援2_11(getValue(syukeiNo0105, 数値_1011));
        reportData.set件数_要支援2_12(getValue(syukeiNo0105, 数値_1012));
        reportData.set件数_要支援2_13(getValue(syukeiNo0105, 数値_1017));
        reportData.set件数_要支援2_14(getValue(syukeiNo0105, 数値_1013));
        reportData.set件数_要支援2_15(getValue(syukeiNo0105, 数値_1014));
        reportData.set件数_要支援2_16(getValue(syukeiNo0105, 数値_1015));
        reportData.set件数_要支援2_17(getValue(syukeiNo0105, 数値_1003));
        reportData.set件数_要支援計_1(getValue(syukeiNo0105, 数値_1101));
        reportData.set件数_要支援計_2(getValue(syukeiNo0105, 数値_1104));
        reportData.set件数_要支援計_3(getValue(syukeiNo0105, 数値_1105));
        reportData.set件数_要支援計_4(getValue(syukeiNo0105, 数値_1106));
        reportData.set件数_要支援計_5(getValue(syukeiNo0105, 数値_1116));
        reportData.set件数_要支援計_6(getValue(syukeiNo0105, 数値_1107));
        reportData.set件数_要支援計_7(getValue(syukeiNo0105, 数値_1108));
        reportData.set件数_要支援計_8(getValue(syukeiNo0105, 数値_1109));
        reportData.set件数_要支援計_9(getValue(syukeiNo0105, 数値_1102));
        reportData.set件数_要支援計_10(getValue(syukeiNo0105, 数値_1110));
        reportData.set件数_要支援計_11(getValue(syukeiNo0105, 数値_1111));
        reportData.set件数_要支援計_12(getValue(syukeiNo0105, 数値_1112));
        reportData.set件数_要支援計_13(getValue(syukeiNo0105, 数値_1117));
        reportData.set件数_要支援計_14(getValue(syukeiNo0105, 数値_1113));
        reportData.set件数_要支援計_15(getValue(syukeiNo0105, 数値_1114));
        reportData.set件数_要支援計_16(getValue(syukeiNo0105, 数値_1115));
        reportData.set件数_要支援計_17(getValue(syukeiNo0105, 数値_1103));
        reportData.set件数_経過的要介護_1(getValue(syukeiNo0105, 数値_201));
        reportData.set件数_経過的要介護_2(getValue(syukeiNo0105, 数値_204));
        reportData.set件数_経過的要介護_3(getValue(syukeiNo0105, 数値_205));
        reportData.set件数_経過的要介護_4(getValue(syukeiNo0105, 数値_206));
        reportData.set件数_経過的要介護_5(getValue(syukeiNo0105, 数値_216));
        reportData.set件数_経過的要介護_6(getValue(syukeiNo0105, 数値_207));
        reportData.set件数_経過的要介護_7(getValue(syukeiNo0105, 数値_208));
        reportData.set件数_経過的要介護_8(getValue(syukeiNo0105, 数値_209));
        reportData.set件数_経過的要介護_9(getValue(syukeiNo0105, 数値_202));
        reportData.set件数_経過的要介護_10(getValue(syukeiNo0105, 数値_210));
        reportData.set件数_経過的要介護_11(getValue(syukeiNo0105, 数値_211));
        reportData.set件数_経過的要介護_12(getValue(syukeiNo0105, 数値_212));
        reportData.set件数_経過的要介護_13(getValue(syukeiNo0105, 数値_217));
        reportData.set件数_経過的要介護_14(getValue(syukeiNo0105, 数値_213));
        reportData.set件数_経過的要介護_15(getValue(syukeiNo0105, 数値_214));
        reportData.set件数_経過的要介護_16(getValue(syukeiNo0105, 数値_215));
        reportData.set件数_経過的要介護_17(getValue(syukeiNo0105, 数値_203));
        reportData.set件数_要介護1_1(getValue(syukeiNo0105, 数値_301));
        reportData.set件数_要介護1_2(getValue(syukeiNo0105, 数値_304));
        reportData.set件数_要介護1_3(getValue(syukeiNo0105, 数値_305));
        reportData.set件数_要介護1_4(getValue(syukeiNo0105, 数値_306));
        reportData.set件数_要介護1_5(getValue(syukeiNo0105, 数値_316));
        reportData.set件数_要介護1_6(getValue(syukeiNo0105, 数値_307));
        reportData.set件数_要介護1_7(getValue(syukeiNo0105, 数値_308));
        reportData.set件数_要介護1_8(getValue(syukeiNo0105, 数値_309));
        reportData.set件数_要介護1_9(getValue(syukeiNo0105, 数値_302));
        reportData.set件数_要介護1_10(getValue(syukeiNo0105, 数値_310));
        reportData.set件数_要介護1_11(getValue(syukeiNo0105, 数値_311));
        reportData.set件数_要介護1_12(getValue(syukeiNo0105, 数値_312));
        reportData.set件数_要介護1_13(getValue(syukeiNo0105, 数値_317));
        reportData.set件数_要介護1_14(getValue(syukeiNo0105, 数値_313));
        reportData.set件数_要介護1_15(getValue(syukeiNo0105, 数値_314));
        reportData.set件数_要介護1_16(getValue(syukeiNo0105, 数値_315));
        reportData.set件数_要介護1_17(getValue(syukeiNo0105, 数値_303));
        reportData.set件数_要介護2_1(getValue(syukeiNo0105, 数値_401));
        reportData.set件数_要介護2_2(getValue(syukeiNo0105, 数値_404));
        reportData.set件数_要介護2_3(getValue(syukeiNo0105, 数値_405));
        reportData.set件数_要介護2_4(getValue(syukeiNo0105, 数値_406));
        reportData.set件数_要介護2_5(getValue(syukeiNo0105, 数値_416));
        reportData.set件数_要介護2_6(getValue(syukeiNo0105, 数値_407));
        reportData.set件数_要介護2_7(getValue(syukeiNo0105, 数値_408));
        reportData.set件数_要介護2_8(getValue(syukeiNo0105, 数値_409));
        reportData.set件数_要介護2_9(getValue(syukeiNo0105, 数値_402));
        reportData.set件数_要介護2_10(getValue(syukeiNo0105, 数値_410));
        reportData.set件数_要介護2_11(getValue(syukeiNo0105, 数値_411));
        reportData.set件数_要介護2_12(getValue(syukeiNo0105, 数値_412));
        reportData.set件数_要介護2_13(getValue(syukeiNo0105, 数値_417));
        reportData.set件数_要介護2_14(getValue(syukeiNo0105, 数値_413));
        reportData.set件数_要介護2_15(getValue(syukeiNo0105, 数値_414));
        reportData.set件数_要介護2_16(getValue(syukeiNo0105, 数値_415));
        reportData.set件数_要介護2_17(getValue(syukeiNo0105, 数値_403));
        reportData.set件数_要介護3_1(getValue(syukeiNo0105, 数値_501));
        reportData.set件数_要介護3_2(getValue(syukeiNo0105, 数値_504));
        reportData.set件数_要介護3_3(getValue(syukeiNo0105, 数値_505));
        reportData.set件数_要介護3_4(getValue(syukeiNo0105, 数値_506));
        reportData.set件数_要介護3_5(getValue(syukeiNo0105, 数値_516));
        reportData.set件数_要介護3_6(getValue(syukeiNo0105, 数値_507));
        reportData.set件数_要介護3_7(getValue(syukeiNo0105, 数値_508));
        reportData.set件数_要介護3_8(getValue(syukeiNo0105, 数値_509));
        reportData.set件数_要介護3_9(getValue(syukeiNo0105, 数値_502));
        reportData.set件数_要介護3_10(getValue(syukeiNo0105, 数値_510));
        reportData.set件数_要介護3_11(getValue(syukeiNo0105, 数値_511));
        reportData.set件数_要介護3_12(getValue(syukeiNo0105, 数値_512));
        reportData.set件数_要介護3_13(getValue(syukeiNo0105, 数値_517));
        reportData.set件数_要介護3_14(getValue(syukeiNo0105, 数値_513));
        reportData.set件数_要介護3_15(getValue(syukeiNo0105, 数値_514));
        reportData.set件数_要介護3_16(getValue(syukeiNo0105, 数値_515));
        reportData.set件数_要介護3_17(getValue(syukeiNo0105, 数値_503));
        return set件数集計結果イ(reportData);
    }

    private JigyohokokuCompYoshiki26 set件数集計結果イ(JigyohokokuCompYoshiki26 reportData) {
        reportData.set件数_要介護4_1(getValue(syukeiNo0105, 数値_601));
        reportData.set件数_要介護4_2(getValue(syukeiNo0105, 数値_604));
        reportData.set件数_要介護4_3(getValue(syukeiNo0105, 数値_605));
        reportData.set件数_要介護4_4(getValue(syukeiNo0105, 数値_606));
        reportData.set件数_要介護4_5(getValue(syukeiNo0105, 数値_616));
        reportData.set件数_要介護4_6(getValue(syukeiNo0105, 数値_607));
        reportData.set件数_要介護4_7(getValue(syukeiNo0105, 数値_608));
        reportData.set件数_要介護4_8(getValue(syukeiNo0105, 数値_609));
        reportData.set件数_要介護4_9(getValue(syukeiNo0105, 数値_602));
        reportData.set件数_要介護4_10(getValue(syukeiNo0105, 数値_610));
        reportData.set件数_要介護4_11(getValue(syukeiNo0105, 数値_611));
        reportData.set件数_要介護4_12(getValue(syukeiNo0105, 数値_612));
        reportData.set件数_要介護4_13(getValue(syukeiNo0105, 数値_617));
        reportData.set件数_要介護4_14(getValue(syukeiNo0105, 数値_613));
        reportData.set件数_要介護4_15(getValue(syukeiNo0105, 数値_614));
        reportData.set件数_要介護4_16(getValue(syukeiNo0105, 数値_615));
        reportData.set件数_要介護4_17(getValue(syukeiNo0105, 数値_603));
        reportData.set件数_要介護5_1(getValue(syukeiNo0105, 数値_701));
        reportData.set件数_要介護5_2(getValue(syukeiNo0105, 数値_704));
        reportData.set件数_要介護5_3(getValue(syukeiNo0105, 数値_705));
        reportData.set件数_要介護5_4(getValue(syukeiNo0105, 数値_706));
        reportData.set件数_要介護5_5(getValue(syukeiNo0105, 数値_716));
        reportData.set件数_要介護5_6(getValue(syukeiNo0105, 数値_707));
        reportData.set件数_要介護5_7(getValue(syukeiNo0105, 数値_708));
        reportData.set件数_要介護5_8(getValue(syukeiNo0105, 数値_709));
        reportData.set件数_要介護5_9(getValue(syukeiNo0105, 数値_702));
        reportData.set件数_要介護5_10(getValue(syukeiNo0105, 数値_710));
        reportData.set件数_要介護5_11(getValue(syukeiNo0105, 数値_711));
        reportData.set件数_要介護5_12(getValue(syukeiNo0105, 数値_712));
        reportData.set件数_要介護5_13(getValue(syukeiNo0105, 数値_717));
        reportData.set件数_要介護5_14(getValue(syukeiNo0105, 数値_713));
        reportData.set件数_要介護5_15(getValue(syukeiNo0105, 数値_714));
        reportData.set件数_要介護5_16(getValue(syukeiNo0105, 数値_715));
        reportData.set件数_要介護5_17(getValue(syukeiNo0105, 数値_703));
        reportData.set件数_要介護計_1(getValue(syukeiNo0105, 数値_801));
        reportData.set件数_要介護計_2(getValue(syukeiNo0105, 数値_804));
        reportData.set件数_要介護計_3(getValue(syukeiNo0105, 数値_805));
        reportData.set件数_要介護計_4(getValue(syukeiNo0105, 数値_806));
        reportData.set件数_要介護計_5(getValue(syukeiNo0105, 数値_816));
        reportData.set件数_要介護計_6(getValue(syukeiNo0105, 数値_807));
        reportData.set件数_要介護計_7(getValue(syukeiNo0105, 数値_808));
        reportData.set件数_要介護計_8(getValue(syukeiNo0105, 数値_809));
        reportData.set件数_要介護計_9(getValue(syukeiNo0105, 数値_802));
        reportData.set件数_要介護計_10(getValue(syukeiNo0105, 数値_810));
        reportData.set件数_要介護計_11(getValue(syukeiNo0105, 数値_811));
        reportData.set件数_要介護計_12(getValue(syukeiNo0105, 数値_812));
        reportData.set件数_要介護計_13(getValue(syukeiNo0105, 数値_817));
        reportData.set件数_要介護計_14(getValue(syukeiNo0105, 数値_813));
        reportData.set件数_要介護計_15(getValue(syukeiNo0105, 数値_814));
        reportData.set件数_要介護計_16(getValue(syukeiNo0105, 数値_815));
        reportData.set件数_要介護計_17(getValue(syukeiNo0105, 数値_803));
        reportData.set件数_合計_1(getValue(syukeiNo0105, 数値_1201));
        reportData.set件数_合計_2(getValue(syukeiNo0105, 数値_1204));
        reportData.set件数_合計_3(getValue(syukeiNo0105, 数値_1205));
        reportData.set件数_合計_4(getValue(syukeiNo0105, 数値_1206));
        reportData.set件数_合計_5(getValue(syukeiNo0105, 数値_1216));
        reportData.set件数_合計_6(getValue(syukeiNo0105, 数値_1207));
        reportData.set件数_合計_7(getValue(syukeiNo0105, 数値_1208));
        reportData.set件数_合計_8(getValue(syukeiNo0105, 数値_1209));
        reportData.set件数_合計_9(getValue(syukeiNo0105, 数値_1202));
        reportData.set件数_合計_10(getValue(syukeiNo0105, 数値_1210));
        reportData.set件数_合計_11(getValue(syukeiNo0105, 数値_1211));
        reportData.set件数_合計_12(getValue(syukeiNo0105, 数値_1212));
        reportData.set件数_合計_13(getValue(syukeiNo0105, 数値_1217));
        reportData.set件数_合計_14(getValue(syukeiNo0105, 数値_1213));
        reportData.set件数_合計_15(getValue(syukeiNo0105, 数値_1214));
        reportData.set件数_合計_16(getValue(syukeiNo0105, 数値_1215));
        reportData.set件数_合計_17(getValue(syukeiNo0105, 数値_1203));
        return reportData;
    }

    private JigyohokokuCompYoshiki26 set給付額集計結果(JigyohokokuCompYoshiki26 reportData) {
        reportData.set給付費_要支援1_1(getValue(syukeiNo0106, 数値_901));
        reportData.set給付費_要支援1_2(getValue(syukeiNo0106, 数値_904));
        reportData.set給付費_要支援1_3(getValue(syukeiNo0106, 数値_905));
        reportData.set給付費_要支援1_4(getValue(syukeiNo0106, 数値_906));
        reportData.set給付費_要支援1_5(getValue(syukeiNo0106, 数値_916));
        reportData.set給付費_要支援1_6(getValue(syukeiNo0106, 数値_907));
        reportData.set給付費_要支援1_7(getValue(syukeiNo0106, 数値_908));
        reportData.set給付費_要支援1_8(getValue(syukeiNo0106, 数値_909));
        reportData.set給付費_要支援1_9(getValue(syukeiNo0106, 数値_902));
        reportData.set給付費_要支援1_10(getValue(syukeiNo0106, 数値_910));
        reportData.set給付費_要支援1_11(getValue(syukeiNo0106, 数値_911));
        reportData.set給付費_要支援1_12(getValue(syukeiNo0106, 数値_912));
        reportData.set給付費_要支援1_13(getValue(syukeiNo0106, 数値_917));
        reportData.set給付費_要支援1_14(getValue(syukeiNo0106, 数値_913));
        reportData.set給付費_要支援1_15(getValue(syukeiNo0106, 数値_914));
        reportData.set給付費_要支援1_16(getValue(syukeiNo0106, 数値_915));
        reportData.set給付費_要支援1_17(getValue(syukeiNo0106, 数値_903));
        reportData.set給付費_要支援2_1(getValue(syukeiNo0106, 数値_1001));
        reportData.set給付費_要支援2_2(getValue(syukeiNo0106, 数値_1004));
        reportData.set給付費_要支援2_3(getValue(syukeiNo0106, 数値_1005));
        reportData.set給付費_要支援2_4(getValue(syukeiNo0106, 数値_1006));
        reportData.set給付費_要支援2_5(getValue(syukeiNo0106, 数値_1016));
        reportData.set給付費_要支援2_6(getValue(syukeiNo0106, 数値_1007));
        reportData.set給付費_要支援2_7(getValue(syukeiNo0106, 数値_1008));
        reportData.set給付費_要支援2_8(getValue(syukeiNo0106, 数値_1009));
        reportData.set給付費_要支援2_9(getValue(syukeiNo0106, 数値_1002));
        reportData.set給付費_要支援2_10(getValue(syukeiNo0106, 数値_1010));
        reportData.set給付費_要支援2_11(getValue(syukeiNo0106, 数値_1011));
        reportData.set給付費_要支援2_12(getValue(syukeiNo0106, 数値_1012));
        reportData.set給付費_要支援2_13(getValue(syukeiNo0106, 数値_1017));
        reportData.set給付費_要支援2_14(getValue(syukeiNo0106, 数値_1013));
        reportData.set給付費_要支援2_15(getValue(syukeiNo0106, 数値_1014));
        reportData.set給付費_要支援2_16(getValue(syukeiNo0106, 数値_1015));
        reportData.set給付費_要支援2_17(getValue(syukeiNo0106, 数値_1003));
        reportData.set給付費_要支援計_1(getValue(syukeiNo0106, 数値_1101));
        reportData.set給付費_要支援計_2(getValue(syukeiNo0106, 数値_1104));
        reportData.set給付費_要支援計_3(getValue(syukeiNo0106, 数値_1105));
        reportData.set給付費_要支援計_4(getValue(syukeiNo0106, 数値_1106));
        reportData.set給付費_要支援計_5(getValue(syukeiNo0106, 数値_1116));
        reportData.set給付費_要支援計_6(getValue(syukeiNo0106, 数値_1107));
        reportData.set給付費_要支援計_7(getValue(syukeiNo0106, 数値_1108));
        reportData.set給付費_要支援計_8(getValue(syukeiNo0106, 数値_1109));
        reportData.set給付費_要支援計_9(getValue(syukeiNo0106, 数値_1102));
        reportData.set給付費_要支援計_10(getValue(syukeiNo0106, 数値_1110));
        reportData.set給付費_要支援計_11(getValue(syukeiNo0106, 数値_1111));
        reportData.set給付費_要支援計_12(getValue(syukeiNo0106, 数値_1112));
        reportData.set給付費_要支援計_13(getValue(syukeiNo0106, 数値_1117));
        reportData.set給付費_要支援計_14(getValue(syukeiNo0106, 数値_1113));
        reportData.set給付費_要支援計_15(getValue(syukeiNo0106, 数値_1114));
        reportData.set給付費_要支援計_16(getValue(syukeiNo0106, 数値_1115));
        reportData.set給付費_要支援計_17(getValue(syukeiNo0106, 数値_1103));
        reportData.set給付費_経過的要介護_1(getValue(syukeiNo0106, 数値_201));
        reportData.set給付費_経過的要介護_2(getValue(syukeiNo0106, 数値_204));
        reportData.set給付費_経過的要介護_3(getValue(syukeiNo0106, 数値_205));
        reportData.set給付費_経過的要介護_4(getValue(syukeiNo0106, 数値_206));
        reportData.set給付費_経過的要介護_5(getValue(syukeiNo0106, 数値_216));
        reportData.set給付費_経過的要介護_6(getValue(syukeiNo0106, 数値_207));
        reportData.set給付費_経過的要介護_7(getValue(syukeiNo0106, 数値_208));
        reportData.set給付費_経過的要介護_8(getValue(syukeiNo0106, 数値_209));
        reportData.set給付費_経過的要介護_9(getValue(syukeiNo0106, 数値_202));
        reportData.set給付費_経過的要介護_10(getValue(syukeiNo0106, 数値_210));
        reportData.set給付費_経過的要介護_11(getValue(syukeiNo0106, 数値_211));
        reportData.set給付費_経過的要介護_12(getValue(syukeiNo0106, 数値_212));
        reportData.set給付費_経過的要介護_13(getValue(syukeiNo0106, 数値_217));
        reportData.set給付費_経過的要介護_14(getValue(syukeiNo0106, 数値_213));
        reportData.set給付費_経過的要介護_15(getValue(syukeiNo0106, 数値_214));
        reportData.set給付費_経過的要介護_16(getValue(syukeiNo0106, 数値_215));
        reportData.set給付費_経過的要介護_17(getValue(syukeiNo0106, 数値_203));
        reportData.set給付費_要介護1_1(getValue(syukeiNo0106, 数値_301));
        reportData.set給付費_要介護1_2(getValue(syukeiNo0106, 数値_304));
        reportData.set給付費_要介護1_3(getValue(syukeiNo0106, 数値_305));
        reportData.set給付費_要介護1_4(getValue(syukeiNo0106, 数値_306));
        reportData.set給付費_要介護1_5(getValue(syukeiNo0106, 数値_316));
        reportData.set給付費_要介護1_6(getValue(syukeiNo0106, 数値_307));
        reportData.set給付費_要介護1_7(getValue(syukeiNo0106, 数値_308));
        reportData.set給付費_要介護1_8(getValue(syukeiNo0106, 数値_309));
        reportData.set給付費_要介護1_9(getValue(syukeiNo0106, 数値_302));
        reportData.set給付費_要介護1_10(getValue(syukeiNo0106, 数値_310));
        reportData.set給付費_要介護1_11(getValue(syukeiNo0106, 数値_311));
        reportData.set給付費_要介護1_12(getValue(syukeiNo0106, 数値_312));
        reportData.set給付費_要介護1_13(getValue(syukeiNo0106, 数値_317));
        reportData.set給付費_要介護1_14(getValue(syukeiNo0106, 数値_313));
        reportData.set給付費_要介護1_15(getValue(syukeiNo0106, 数値_314));
        reportData.set給付費_要介護1_16(getValue(syukeiNo0106, 数値_315));
        reportData.set給付費_要介護1_17(getValue(syukeiNo0106, 数値_303));
        reportData.set給付費_要介護2_1(getValue(syukeiNo0106, 数値_401));
        reportData.set給付費_要介護2_2(getValue(syukeiNo0106, 数値_404));
        reportData.set給付費_要介護2_3(getValue(syukeiNo0106, 数値_405));
        reportData.set給付費_要介護2_4(getValue(syukeiNo0106, 数値_406));
        reportData.set給付費_要介護2_5(getValue(syukeiNo0106, 数値_416));
        reportData.set給付費_要介護2_6(getValue(syukeiNo0106, 数値_407));
        reportData.set給付費_要介護2_7(getValue(syukeiNo0106, 数値_408));
        reportData.set給付費_要介護2_8(getValue(syukeiNo0106, 数値_409));
        reportData.set給付費_要介護2_9(getValue(syukeiNo0106, 数値_402));
        reportData.set給付費_要介護2_10(getValue(syukeiNo0106, 数値_410));
        reportData.set給付費_要介護2_11(getValue(syukeiNo0106, 数値_411));
        reportData.set給付費_要介護2_12(getValue(syukeiNo0106, 数値_412));
        reportData.set給付費_要介護2_13(getValue(syukeiNo0106, 数値_417));
        reportData.set給付費_要介護2_14(getValue(syukeiNo0106, 数値_413));
        reportData.set給付費_要介護2_15(getValue(syukeiNo0106, 数値_414));
        reportData.set給付費_要介護2_16(getValue(syukeiNo0106, 数値_415));
        reportData.set給付費_要介護2_17(getValue(syukeiNo0106, 数値_403));
        reportData.set給付費_要介護3_1(getValue(syukeiNo0106, 数値_501));
        reportData.set給付費_要介護3_2(getValue(syukeiNo0106, 数値_504));
        reportData.set給付費_要介護3_3(getValue(syukeiNo0106, 数値_505));
        reportData.set給付費_要介護3_4(getValue(syukeiNo0106, 数値_506));
        reportData.set給付費_要介護3_5(getValue(syukeiNo0106, 数値_516));
        reportData.set給付費_要介護3_6(getValue(syukeiNo0106, 数値_507));
        reportData.set給付費_要介護3_7(getValue(syukeiNo0106, 数値_508));
        reportData.set給付費_要介護3_8(getValue(syukeiNo0106, 数値_509));
        reportData.set給付費_要介護3_9(getValue(syukeiNo0106, 数値_502));
        reportData.set給付費_要介護3_10(getValue(syukeiNo0106, 数値_510));
        reportData.set給付費_要介護3_11(getValue(syukeiNo0106, 数値_511));
        reportData.set給付費_要介護3_12(getValue(syukeiNo0106, 数値_512));
        reportData.set給付費_要介護3_13(getValue(syukeiNo0106, 数値_517));
        reportData.set給付費_要介護3_14(getValue(syukeiNo0106, 数値_513));
        reportData.set給付費_要介護3_15(getValue(syukeiNo0106, 数値_514));
        reportData.set給付費_要介護3_16(getValue(syukeiNo0106, 数値_515));
        reportData.set給付費_要介護3_17(getValue(syukeiNo0106, 数値_503));
        reportData.set給付費_要介護4_1(getValue(syukeiNo0106, 数値_601));
        reportData.set給付費_要介護4_2(getValue(syukeiNo0106, 数値_604));
        reportData.set給付費_要介護4_3(getValue(syukeiNo0106, 数値_605));
        reportData.set給付費_要介護4_4(getValue(syukeiNo0106, 数値_606));
        reportData.set給付費_要介護4_5(getValue(syukeiNo0106, 数値_616));
        reportData.set給付費_要介護4_6(getValue(syukeiNo0106, 数値_607));
        reportData.set給付費_要介護4_7(getValue(syukeiNo0106, 数値_608));
        reportData.set給付費_要介護4_8(getValue(syukeiNo0106, 数値_609));
        reportData.set給付費_要介護4_9(getValue(syukeiNo0106, 数値_602));
        reportData.set給付費_要介護4_10(getValue(syukeiNo0106, 数値_610));
        reportData.set給付費_要介護4_11(getValue(syukeiNo0106, 数値_611));
        reportData.set給付費_要介護4_12(getValue(syukeiNo0106, 数値_612));
        reportData.set給付費_要介護4_13(getValue(syukeiNo0106, 数値_617));
        reportData.set給付費_要介護4_14(getValue(syukeiNo0106, 数値_613));
        reportData.set給付費_要介護4_15(getValue(syukeiNo0106, 数値_614));
        reportData.set給付費_要介護4_16(getValue(syukeiNo0106, 数値_615));
        reportData.set給付費_要介護4_17(getValue(syukeiNo0106, 数値_603));
        return set給付額集計結果イ(reportData);
    }

    private JigyohokokuCompYoshiki26 set給付額集計結果イ(JigyohokokuCompYoshiki26 reportData) {
        reportData.set給付費_要介護5_1(getValue(syukeiNo0106, 数値_701));
        reportData.set給付費_要介護5_2(getValue(syukeiNo0106, 数値_704));
        reportData.set給付費_要介護5_3(getValue(syukeiNo0106, 数値_705));
        reportData.set給付費_要介護5_4(getValue(syukeiNo0106, 数値_706));
        reportData.set給付費_要介護5_5(getValue(syukeiNo0106, 数値_716));
        reportData.set給付費_要介護5_6(getValue(syukeiNo0106, 数値_707));
        reportData.set給付費_要介護5_7(getValue(syukeiNo0106, 数値_708));
        reportData.set給付費_要介護5_8(getValue(syukeiNo0106, 数値_709));
        reportData.set給付費_要介護5_9(getValue(syukeiNo0106, 数値_702));
        reportData.set給付費_要介護5_10(getValue(syukeiNo0106, 数値_710));
        reportData.set給付費_要介護5_11(getValue(syukeiNo0106, 数値_711));
        reportData.set給付費_要介護5_12(getValue(syukeiNo0106, 数値_712));
        reportData.set給付費_要介護5_13(getValue(syukeiNo0106, 数値_717));
        reportData.set給付費_要介護5_14(getValue(syukeiNo0106, 数値_713));
        reportData.set給付費_要介護5_15(getValue(syukeiNo0106, 数値_714));
        reportData.set給付費_要介護5_16(getValue(syukeiNo0106, 数値_715));
        reportData.set給付費_要介護5_17(getValue(syukeiNo0106, 数値_703));
        reportData.set給付費_要介護計_1(getValue(syukeiNo0106, 数値_801));
        reportData.set給付費_要介護計_2(getValue(syukeiNo0106, 数値_804));
        reportData.set給付費_要介護計_3(getValue(syukeiNo0106, 数値_805));
        reportData.set給付費_要介護計_4(getValue(syukeiNo0106, 数値_806));
        reportData.set給付費_要介護計_5(getValue(syukeiNo0106, 数値_816));
        reportData.set給付費_要介護計_6(getValue(syukeiNo0106, 数値_807));
        reportData.set給付費_要介護計_7(getValue(syukeiNo0106, 数値_808));
        reportData.set給付費_要介護計_8(getValue(syukeiNo0106, 数値_809));
        reportData.set給付費_要介護計_9(getValue(syukeiNo0106, 数値_802));
        reportData.set給付費_要介護計_10(getValue(syukeiNo0106, 数値_810));
        reportData.set給付費_要介護計_11(getValue(syukeiNo0106, 数値_811));
        reportData.set給付費_要介護計_12(getValue(syukeiNo0106, 数値_812));
        reportData.set給付費_要介護計_13(getValue(syukeiNo0106, 数値_817));
        reportData.set給付費_要介護計_14(getValue(syukeiNo0106, 数値_813));
        reportData.set給付費_要介護計_15(getValue(syukeiNo0106, 数値_814));
        reportData.set給付費_要介護計_16(getValue(syukeiNo0106, 数値_815));
        reportData.set給付費_要介護計_17(getValue(syukeiNo0106, 数値_803));
        reportData.set給付費_合計_1(getValue(syukeiNo0106, 数値_1201));
        reportData.set給付費_合計_2(getValue(syukeiNo0106, 数値_1204));
        reportData.set給付費_合計_3(getValue(syukeiNo0106, 数値_1205));
        reportData.set給付費_合計_4(getValue(syukeiNo0106, 数値_1206));
        reportData.set給付費_合計_5(getValue(syukeiNo0106, 数値_1216));
        reportData.set給付費_合計_6(getValue(syukeiNo0106, 数値_1207));
        reportData.set給付費_合計_7(getValue(syukeiNo0106, 数値_1208));
        reportData.set給付費_合計_8(getValue(syukeiNo0106, 数値_1209));
        reportData.set給付費_合計_9(getValue(syukeiNo0106, 数値_1202));
        reportData.set給付費_合計_10(getValue(syukeiNo0106, 数値_1210));
        reportData.set給付費_合計_11(getValue(syukeiNo0106, 数値_1211));
        reportData.set給付費_合計_12(getValue(syukeiNo0106, 数値_1212));
        reportData.set給付費_合計_13(getValue(syukeiNo0106, 数値_1217));
        reportData.set給付費_合計_14(getValue(syukeiNo0106, 数値_1213));
        reportData.set給付費_合計_15(getValue(syukeiNo0106, 数値_1214));
        reportData.set給付費_合計_16(getValue(syukeiNo0106, 数値_1215));
        reportData.set給付費_合計_17(getValue(syukeiNo0106, 数値_1203));
        return reportData;
    }
}
