/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151300106.JigyohokokuCompYoshiki151300106Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyojokyohokokushiryonemposakuseiiti.JigyoJokyoHokokuShiryoNempoSakuseiItiProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki151300106.JigyohokokuCompYoshiki151300106Data;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151300106.JigyohokokuCompYoshiki151300106ReportSource;
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
 * 介護事業状況報告年報（様式1-5）帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-030 dingyi
 *
 */
public class JigyoHokokuDataReportDBU300106Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoJokyoHokokuShiryoNempoSakuseiItiMapper.getJigyouHokokuTokeiReportJyoho");
    private JigyoJokyoHokokuShiryoNempoSakuseiItiProcessParameter processParameter;

    private static final ReportId REPORT_DBU300106 = ReportIdDBU.DBU300106.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final RString 年報月報区分CODE = new RString("2");
    private static final int 数値_100 = 100;
    private static final Decimal 数値_101 = new Decimal(101);
    private static final Decimal 数値_102 = new Decimal(102);
    private static final Decimal 数値_103 = new Decimal(103);
    private static final Decimal 数値_104 = new Decimal(104);
    private static final Decimal 数値_105 = new Decimal(105);
    private static final Decimal 数値_106 = new Decimal(106);
    private static final Decimal 数値_107 = new Decimal(107);
    private static final Decimal 数値_109 = new Decimal(109);
    private static final Decimal 数値_110 = new Decimal(110);
    private static final Decimal 数値_111 = new Decimal(111);
    private static final Decimal 数値_112 = new Decimal(112);
    private static final Decimal 数値_201 = new Decimal(201);
    private static final Decimal 数値_202 = new Decimal(202);
    private static final Decimal 数値_203 = new Decimal(203);
    private static final Decimal 数値_204 = new Decimal(204);
    private static final Decimal 数値_205 = new Decimal(205);
    private static final Decimal 数値_206 = new Decimal(206);
    private static final Decimal 数値_207 = new Decimal(207);
    private static final Decimal 数値_209 = new Decimal(209);
    private static final Decimal 数値_210 = new Decimal(210);
    private static final Decimal 数値_211 = new Decimal(211);
    private static final Decimal 数値_212 = new Decimal(212);
    private static final Decimal 数値_301 = new Decimal(301);
    private static final Decimal 数値_302 = new Decimal(302);
    private static final Decimal 数値_303 = new Decimal(303);
    private static final Decimal 数値_304 = new Decimal(304);
    private static final Decimal 数値_305 = new Decimal(305);
    private static final Decimal 数値_306 = new Decimal(306);
    private static final Decimal 数値_307 = new Decimal(307);
    private static final Decimal 数値_309 = new Decimal(309);
    private static final Decimal 数値_310 = new Decimal(310);
    private static final Decimal 数値_311 = new Decimal(311);
    private static final Decimal 数値_312 = new Decimal(312);
    private static final Decimal 数値_401 = new Decimal(401);
    private static final Decimal 数値_402 = new Decimal(402);
    private static final Decimal 数値_403 = new Decimal(403);
    private static final Decimal 数値_404 = new Decimal(404);
    private static final Decimal 数値_405 = new Decimal(405);
    private static final Decimal 数値_406 = new Decimal(406);
    private static final Decimal 数値_407 = new Decimal(407);
    private static final Decimal 数値_409 = new Decimal(409);
    private static final Decimal 数値_410 = new Decimal(410);
    private static final Decimal 数値_411 = new Decimal(411);
    private static final Decimal 数値_412 = new Decimal(412);
    private static final Decimal 数値_501 = new Decimal(501);
    private static final Decimal 数値_502 = new Decimal(502);
    private static final Decimal 数値_503 = new Decimal(503);
    private static final Decimal 数値_504 = new Decimal(504);
    private static final Decimal 数値_505 = new Decimal(505);
    private static final Decimal 数値_506 = new Decimal(506);
    private static final Decimal 数値_507 = new Decimal(507);
    private static final Decimal 数値_509 = new Decimal(509);
    private static final Decimal 数値_510 = new Decimal(510);
    private static final Decimal 数値_511 = new Decimal(511);
    private static final Decimal 数値_512 = new Decimal(512);
    private static final Decimal 数値_601 = new Decimal(601);
    private static final Decimal 数値_602 = new Decimal(602);
    private static final Decimal 数値_603 = new Decimal(603);
    private static final Decimal 数値_604 = new Decimal(604);
    private static final Decimal 数値_605 = new Decimal(605);
    private static final Decimal 数値_606 = new Decimal(606);
    private static final Decimal 数値_607 = new Decimal(607);
    private static final Decimal 数値_609 = new Decimal(609);
    private static final Decimal 数値_610 = new Decimal(610);
    private static final Decimal 数値_611 = new Decimal(611);
    private static final Decimal 数値_612 = new Decimal(612);
    private static final Decimal 数値_701 = new Decimal(701);
    private static final Decimal 数値_702 = new Decimal(702);
    private static final Decimal 数値_703 = new Decimal(703);
    private static final Decimal 数値_704 = new Decimal(704);
    private static final Decimal 数値_705 = new Decimal(705);
    private static final Decimal 数値_706 = new Decimal(706);
    private static final Decimal 数値_707 = new Decimal(707);
    private static final Decimal 数値_709 = new Decimal(709);
    private static final Decimal 数値_710 = new Decimal(710);
    private static final Decimal 数値_711 = new Decimal(711);
    private static final Decimal 数値_712 = new Decimal(712);

    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo1030;
    private Map<Decimal, Decimal> syukeiNo1100;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki151300106ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki151300106ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        syukeiNo1030 = new HashMap<>();
        syukeiNo1100 = new HashMap<>();
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
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300106.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (ShukeiNo.一般状況_10_利用者負担第4段階における_食費_居住費の特例減額措置.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1030.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_11_要介護_要支援_認定者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1100.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki151300106Data reportData = new JigyohokokuCompYoshiki151300106Data();
        reportData.set年報月報区分(年報月報区分CODE);
        reportData.set処理日時(processParameter.get処理日時());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.set集計年度(new FlexibleYear(processParameter.get集計年度()));
        reportData.set集計期間FROM(new FlexibleYearMonth(processParameter.get集計開始年月()));
        reportData.set集計期間TO(new FlexibleYearMonth(processParameter.get集計終了年月()));
        reportData.set食費居住費の特例減額措置_第1号被保険者_1(getValue(syukeiNo1030, 数値_101));
        reportData.set食費居住費の特例減額措置_第1号被保険者_2(getValue(syukeiNo1030, 数値_201));
        reportData.set食費居住費の特例減額措置_第1号被保険者_3(getValue(syukeiNo1030, 数値_301));
        reportData.set食費居住費の特例減額措置_第1号被保険者_4(getValue(syukeiNo1030, 数値_401));
        reportData.set食費居住費の特例減額措置_第1号被保険者_5(getValue(syukeiNo1030, 数値_501));
        reportData.set食費居住費の特例減額措置_第1号被保険者_6(getValue(syukeiNo1030, 数値_601));
        reportData.set食費居住費の特例減額措置_第1号被保険者_7(getValue(syukeiNo1030, 数値_701));
        reportData.set食費居住費の特例減額措置_第2号被保険者_1(getValue(syukeiNo1030, 数値_102));
        reportData.set食費居住費の特例減額措置_第2号被保険者_2(getValue(syukeiNo1030, 数値_202));
        reportData.set食費居住費の特例減額措置_第2号被保険者_3(getValue(syukeiNo1030, 数値_302));
        reportData.set食費居住費の特例減額措置_第2号被保険者_4(getValue(syukeiNo1030, 数値_402));
        reportData.set食費居住費の特例減額措置_第2号被保険者_5(getValue(syukeiNo1030, 数値_502));
        reportData.set食費居住費の特例減額措置_第2号被保険者_6(getValue(syukeiNo1030, 数値_602));
        reportData.set食費居住費の特例減額措置_第2号被保険者_7(getValue(syukeiNo1030, 数値_702));
        reportData.set食費居住費の特例減額措置_合計_1(getValue(syukeiNo1030, 数値_103));
        reportData.set食費居住費の特例減額措置_合計_2(getValue(syukeiNo1030, 数値_203));
        reportData.set食費居住費の特例減額措置_合計_3(getValue(syukeiNo1030, 数値_303));
        reportData.set食費居住費の特例減額措置_合計_4(getValue(syukeiNo1030, 数値_403));
        reportData.set食費居住費の特例減額措置_合計_5(getValue(syukeiNo1030, 数値_503));
        reportData.set食費居住費の特例減額措置_合計_6(getValue(syukeiNo1030, 数値_603));
        reportData.set食費居住費の特例減額措置_合計_7(getValue(syukeiNo1030, 数値_703));

        reportData.set要支援認定者数_要支援1_1(getValue(syukeiNo1100, 数値_109));
        reportData.set要支援認定者数_要支援1_2(getValue(syukeiNo1100, 数値_209));
        reportData.set要支援認定者数_要支援1_3(getValue(syukeiNo1100, 数値_309));
        reportData.set要支援認定者数_要支援1_4(getValue(syukeiNo1100, 数値_409));
        reportData.set要支援認定者数_要支援1_5(getValue(syukeiNo1100, 数値_509));
        reportData.set要支援認定者数_要支援1_6(getValue(syukeiNo1100, 数値_609));
        reportData.set要支援認定者数_要支援1_7(getValue(syukeiNo1100, 数値_709));
        reportData.set要支援認定者数_要支援2_1(getValue(syukeiNo1100, 数値_110));
        reportData.set要支援認定者数_要支援2_2(getValue(syukeiNo1100, 数値_210));
        reportData.set要支援認定者数_要支援2_3(getValue(syukeiNo1100, 数値_310));
        reportData.set要支援認定者数_要支援2_4(getValue(syukeiNo1100, 数値_410));
        reportData.set要支援認定者数_要支援2_5(getValue(syukeiNo1100, 数値_510));
        reportData.set要支援認定者数_要支援2_6(getValue(syukeiNo1100, 数値_610));
        reportData.set要支援認定者数_要支援2_7(getValue(syukeiNo1100, 数値_710));
        reportData.set要支援認定者数_計_1(getValue(syukeiNo1100, 数値_111));
        reportData.set要支援認定者数_計_2(getValue(syukeiNo1100, 数値_211));
        reportData.set要支援認定者数_計_3(getValue(syukeiNo1100, 数値_311));
        reportData.set要支援認定者数_計_4(getValue(syukeiNo1100, 数値_411));
        reportData.set要支援認定者数_計_5(getValue(syukeiNo1100, 数値_511));
        reportData.set要支援認定者数_計_6(getValue(syukeiNo1100, 数値_611));
        reportData.set要支援認定者数_計_7(getValue(syukeiNo1100, 数値_711));

        reportData.set要介護認定者数_経過的要介護_1(getValue(syukeiNo1100, 数値_101));
        reportData.set要介護認定者数_経過的要介護_2(getValue(syukeiNo1100, 数値_201));
        reportData.set要介護認定者数_経過的要介護_3(getValue(syukeiNo1100, 数値_301));
        reportData.set要介護認定者数_経過的要介護_4(getValue(syukeiNo1100, 数値_401));
        reportData.set要介護認定者数_経過的要介護_5(getValue(syukeiNo1100, 数値_501));
        reportData.set要介護認定者数_経過的要介護_6(getValue(syukeiNo1100, 数値_601));
        reportData.set要介護認定者数_経過的要介護_7(getValue(syukeiNo1100, 数値_701));
        reportData.set要介護認定者数_要介護1_1(getValue(syukeiNo1100, 数値_102));
        reportData.set要介護認定者数_要介護1_2(getValue(syukeiNo1100, 数値_202));
        reportData.set要介護認定者数_要介護1_3(getValue(syukeiNo1100, 数値_302));
        reportData.set要介護認定者数_要介護1_4(getValue(syukeiNo1100, 数値_402));
        reportData.set要介護認定者数_要介護1_5(getValue(syukeiNo1100, 数値_502));
        reportData.set要介護認定者数_要介護1_6(getValue(syukeiNo1100, 数値_602));
        reportData.set要介護認定者数_要介護1_7(getValue(syukeiNo1100, 数値_702));
        reportData.set要介護認定者数_要介護2_1(getValue(syukeiNo1100, 数値_103));
        reportData.set要介護認定者数_要介護2_2(getValue(syukeiNo1100, 数値_203));
        reportData.set要介護認定者数_要介護2_3(getValue(syukeiNo1100, 数値_303));
        reportData.set要介護認定者数_要介護2_4(getValue(syukeiNo1100, 数値_403));
        reportData.set要介護認定者数_要介護2_5(getValue(syukeiNo1100, 数値_503));
        reportData.set要介護認定者数_要介護2_6(getValue(syukeiNo1100, 数値_603));
        reportData.set要介護認定者数_要介護2_7(getValue(syukeiNo1100, 数値_703));
        reportData.set要介護認定者数_要介護3_1(getValue(syukeiNo1100, 数値_104));
        reportData.set要介護認定者数_要介護3_2(getValue(syukeiNo1100, 数値_204));
        reportData.set要介護認定者数_要介護3_3(getValue(syukeiNo1100, 数値_304));
        reportData.set要介護認定者数_要介護3_4(getValue(syukeiNo1100, 数値_404));
        reportData.set要介護認定者数_要介護3_5(getValue(syukeiNo1100, 数値_504));
        reportData.set要介護認定者数_要介護3_6(getValue(syukeiNo1100, 数値_604));
        reportData.set要介護認定者数_要介護3_7(getValue(syukeiNo1100, 数値_704));
        reportData.set要介護認定者数_要介護4_1(getValue(syukeiNo1100, 数値_105));
        reportData.set要介護認定者数_要介護4_2(getValue(syukeiNo1100, 数値_205));
        reportData.set要介護認定者数_要介護4_3(getValue(syukeiNo1100, 数値_305));
        reportData.set要介護認定者数_要介護4_4(getValue(syukeiNo1100, 数値_405));
        reportData.set要介護認定者数_要介護4_5(getValue(syukeiNo1100, 数値_505));
        reportData.set要介護認定者数_要介護4_6(getValue(syukeiNo1100, 数値_605));
        reportData.set要介護認定者数_要介護4_7(getValue(syukeiNo1100, 数値_705));
        reportData.set要介護認定者数_要介護5_1(getValue(syukeiNo1100, 数値_106));
        reportData.set要介護認定者数_要介護5_2(getValue(syukeiNo1100, 数値_206));
        reportData.set要介護認定者数_要介護5_3(getValue(syukeiNo1100, 数値_306));
        reportData.set要介護認定者数_要介護5_4(getValue(syukeiNo1100, 数値_406));
        reportData.set要介護認定者数_要介護5_5(getValue(syukeiNo1100, 数値_506));
        reportData.set要介護認定者数_要介護5_6(getValue(syukeiNo1100, 数値_606));
        reportData.set要介護認定者数_要介護5_7(getValue(syukeiNo1100, 数値_706));
        reportData.set要介護認定者数_計_1(getValue(syukeiNo1100, 数値_107));
        reportData.set要介護認定者数_計_2(getValue(syukeiNo1100, 数値_207));
        reportData.set要介護認定者数_計_3(getValue(syukeiNo1100, 数値_307));
        reportData.set要介護認定者数_計_4(getValue(syukeiNo1100, 数値_407));
        reportData.set要介護認定者数_計_5(getValue(syukeiNo1100, 数値_507));
        reportData.set要介護認定者数_計_6(getValue(syukeiNo1100, 数値_607));
        reportData.set要介護認定者数_計_7(getValue(syukeiNo1100, 数値_707));
        reportData.set要介護認定者数_合計_1(getValue(syukeiNo1100, 数値_112));
        reportData.set要介護認定者数_合計_2(getValue(syukeiNo1100, 数値_212));
        reportData.set要介護認定者数_合計_3(getValue(syukeiNo1100, 数値_312));
        reportData.set要介護認定者数_合計_4(getValue(syukeiNo1100, 数値_412));
        reportData.set要介護認定者数_合計_5(getValue(syukeiNo1100, 数値_512));
        reportData.set要介護認定者数_合計_6(getValue(syukeiNo1100, 数値_612));
        reportData.set要介護認定者数_合計_7(getValue(syukeiNo1100, 数値_712));
        JigyohokokuCompYoshiki151300106Report report = new JigyohokokuCompYoshiki151300106Report(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }
}
