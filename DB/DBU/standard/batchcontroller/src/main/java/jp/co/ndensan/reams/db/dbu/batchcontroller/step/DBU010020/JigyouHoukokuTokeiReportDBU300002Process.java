/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12Data;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12ReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-2）のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class JigyouHoukokuTokeiReportDBU300002Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getJigyouHoukokuTokeiTyouhyou");
    private static final FlexibleYearMonth 制度改正月 = new FlexibleYearMonth("200510");
    private static final RString 集計区分_月報 = new RString("月報");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final int 数値_100 = 100;
    private static final Decimal 数値_101 = new Decimal(101);
    private static final Decimal 数値_201 = new Decimal(201);
    private static final Decimal 数値_301 = new Decimal(301);
    private static final Decimal 数値_401 = new Decimal(401);
    private static final Decimal 数値_501 = new Decimal(501);
    private static final Decimal 数値_601 = new Decimal(601);
    private static final Decimal 数値_701 = new Decimal(701);
    private static final Decimal 数値_102 = new Decimal(102);
    private static final Decimal 数値_202 = new Decimal(202);
    private static final Decimal 数値_302 = new Decimal(302);
    private static final Decimal 数値_402 = new Decimal(402);
    private static final Decimal 数値_502 = new Decimal(502);
    private static final Decimal 数値_602 = new Decimal(602);
    private static final Decimal 数値_702 = new Decimal(702);
    private static final Decimal 数値_103 = new Decimal(103);
    private static final Decimal 数値_203 = new Decimal(203);
    private static final Decimal 数値_303 = new Decimal(303);
    private static final Decimal 数値_403 = new Decimal(403);
    private static final Decimal 数値_503 = new Decimal(503);
    private static final Decimal 数値_603 = new Decimal(603);
    private static final Decimal 数値_703 = new Decimal(703);
    private static final Decimal 数値_104 = new Decimal(104);
    private static final Decimal 数値_204 = new Decimal(204);
    private static final Decimal 数値_304 = new Decimal(304);
    private static final Decimal 数値_404 = new Decimal(404);
    private static final Decimal 数値_504 = new Decimal(504);
    private static final Decimal 数値_604 = new Decimal(604);
    private static final Decimal 数値_704 = new Decimal(704);
    private static final Decimal 数値_105 = new Decimal(105);
    private static final Decimal 数値_106 = new Decimal(106);
    private static final Decimal 数値_205 = new Decimal(205);
    private static final Decimal 数値_305 = new Decimal(305);
    private static final Decimal 数値_405 = new Decimal(405);
    private static final Decimal 数値_505 = new Decimal(505);
    private static final Decimal 数値_605 = new Decimal(605);
    private static final Decimal 数値_705 = new Decimal(705);
    private static final Decimal 数値_206 = new Decimal(206);
    private static final Decimal 数値_306 = new Decimal(306);
    private static final Decimal 数値_406 = new Decimal(406);
    private static final Decimal 数値_506 = new Decimal(506);
    private static final Decimal 数値_606 = new Decimal(606);
    private static final Decimal 数値_706 = new Decimal(706);
    private static final Decimal 数値_207 = new Decimal(207);
    private static final Decimal 数値_307 = new Decimal(307);
    private static final Decimal 数値_407 = new Decimal(407);
    private static final Decimal 数値_507 = new Decimal(507);
    private static final Decimal 数値_607 = new Decimal(607);
    private static final Decimal 数値_707 = new Decimal(707);
    private static final Decimal 数値_208 = new Decimal(208);
    private static final Decimal 数値_308 = new Decimal(308);
    private static final Decimal 数値_408 = new Decimal(408);
    private static final Decimal 数値_508 = new Decimal(508);
    private static final Decimal 数値_608 = new Decimal(608);
    private static final Decimal 数値_708 = new Decimal(708);
    private static final Decimal 数値_209 = new Decimal(209);
    private static final Decimal 数値_309 = new Decimal(309);
    private static final Decimal 数値_409 = new Decimal(409);
    private static final Decimal 数値_509 = new Decimal(509);
    private static final Decimal 数値_609 = new Decimal(609);
    private static final Decimal 数値_709 = new Decimal(709);
    private static final Decimal 数値_210 = new Decimal(210);
    private static final Decimal 数値_310 = new Decimal(310);
    private static final Decimal 数値_410 = new Decimal(410);
    private static final Decimal 数値_510 = new Decimal(510);
    private static final Decimal 数値_610 = new Decimal(610);
    private static final Decimal 数値_710 = new Decimal(710);
    private static final Decimal 数値_211 = new Decimal(211);
    private static final Decimal 数値_311 = new Decimal(311);
    private static final Decimal 数値_411 = new Decimal(411);
    private static final Decimal 数値_511 = new Decimal(511);
    private static final Decimal 数値_611 = new Decimal(611);
    private static final Decimal 数値_711 = new Decimal(711);
    private static final Decimal 数値_212 = new Decimal(212);
    private static final Decimal 数値_312 = new Decimal(312);
    private static final Decimal 数値_412 = new Decimal(412);
    private static final Decimal 数値_512 = new Decimal(512);
    private static final Decimal 数値_612 = new Decimal(612);
    private static final Decimal 数値_712 = new Decimal(712);

    private Map<Decimal, Decimal> syukeiNo0600;
    private Map<Decimal, Decimal> syukeiNo0702;
    private Map<Decimal, Decimal> syukeiNo0710;
    private Map<Decimal, Decimal> syukeiNo0720;

    private JigyoHokokuGeppoIppanReportProcessParameter processParameter;
    private JigyoHokokuGeppoIppanReportMybatisParameter mybatisParameter;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki12ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki12ReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        syukeiNo0600 = new HashMap<>();
        syukeiNo0702 = new HashMap<>();
        syukeiNo0710 = new HashMap<>();
        syukeiNo0720 = new HashMap<>();
        setMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU300002.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (ShukeiNo.一般状況_4_利用者負担減額_免除認定_総数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0600.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_5_介護老人福祉施設旧措置入所者に係る減額_免除認定_総数_利用者負担.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0702.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_3_食費_居住費に係る負担限度額認定_総数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0710.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_5_介護老人福祉施設旧措置入所者に係る減額_免除認定_総数_特定負担限度額.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0720.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki12Data reportData = new JigyohokokuCompYoshiki12Data();
        reportData.set様式(new RString("（様式１の２）"));
        reportData.set作成日時(getNowDate(processParameter.get処理日時().getRDateTime()));
        reportData.set集計範囲(processParameter.get集計年月().toDateString());
        reportData.set集計区分(集計区分_月報);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        reportData.set保険者名(get保険者名(association.get市町村名()));
        reportData.set保険者番号(association.get地方公共団体コード().value());
        reportData.set表1のタイトル(new RString("（３）食費・居住費に係る負担限度額認定（総数）"));
        reportData.set介護老人福祉施設の申請件数(getValue(syukeiNo0710, 数値_101));
        reportData.set介護老人保健施設の申請件数(getValue(syukeiNo0710, 数値_102));
        reportData.set介護療養型医療施設の申請件数(getValue(syukeiNo0710, 数値_103));
        reportData.set地域密着型介護老人福祉施設入居者生活介護の申請件数(getValue(syukeiNo0710, 数値_106));
        reportData.setその他の申請件数(getValue(syukeiNo0710, 数値_104));
        reportData.set合計の申請件数(getValue(syukeiNo0710, 数値_105));
        set介護老人福祉施設(reportData);
        set介護老人保健施設(reportData);
        set介護療養型医療施設(reportData);
        set地域密着型介護老人福祉施設入居者生活介護(reportData);
        setその他(reportData);
        set合計(reportData);
        reportData.set左下表2のタイトル1(new RString("（４）利用者負担減額・免除認定"));
        reportData.set右下表3のタイトル(new RString("（５）介護老人福祉施設旧措置入所者に係る減額・免除認定（総数）"));
        reportData.set左下表2のタイトル2(new RString("　　　　　　　　　　　（総数）"));
        set利用者負担減額_免除認定表の利用者負担(reportData);
        set介護老人福祉施設旧措置入所者に係る減額_減免認定表の特定負担限度額(reportData);
        set介護老人福祉施設旧措置入所者に係る減額_免除認定表の利用者負担(reportData);

        JigyohokokuCompYoshiki12Report report = new JigyohokokuCompYoshiki12Report(reportData);
        report.writeBy(reportSourceWriter);

    }

    private void set介護老人福祉施設(JigyohokokuCompYoshiki12Data reportData) {
        reportData.set介護老人福祉施設_食費_1(getValue(syukeiNo0710, 数値_201));
        reportData.set介護老人福祉施設_食費_2(getValue(syukeiNo0710, 数値_301));
        reportData.set介護老人福祉施設_食費_3(getValue(syukeiNo0710, 数値_401));
        reportData.set介護老人福祉施設_食費_4(getValue(syukeiNo0710, 数値_501));
        reportData.set介護老人福祉施設_食費_5(getValue(syukeiNo0710, 数値_601));
        reportData.set介護老人福祉施設_食費_6(getValue(syukeiNo0710, 数値_701));
        reportData.set介護老人福祉施設_居住費_1(getValue(syukeiNo0710, 数値_202));
        reportData.set介護老人福祉施設_居住費_2(getValue(syukeiNo0710, 数値_302));
        reportData.set介護老人福祉施設_居住費_3(getValue(syukeiNo0710, 数値_402));
        reportData.set介護老人福祉施設_居住費_4(getValue(syukeiNo0710, 数値_502));
        reportData.set介護老人福祉施設_居住費_5(getValue(syukeiNo0710, 数値_602));
        reportData.set介護老人福祉施設_居住費_6(getValue(syukeiNo0710, 数値_702));
    }

    private void set介護老人保健施設(JigyohokokuCompYoshiki12Data reportData) {
        reportData.set介護老人保健施設_食費_1(getValue(syukeiNo0710, 数値_203));
        reportData.set介護老人保健施設_食費_2(getValue(syukeiNo0710, 数値_303));
        reportData.set介護老人保健施設_食費_3(getValue(syukeiNo0710, 数値_403));
        reportData.set介護老人保健施設_食費_4(getValue(syukeiNo0710, 数値_503));
        reportData.set介護老人保健施設_食費_5(getValue(syukeiNo0710, 数値_603));
        reportData.set介護老人保健施設_食費_6(getValue(syukeiNo0710, 数値_703));
        reportData.set介護老人保健施設_居住費_1(getValue(syukeiNo0710, 数値_204));
        reportData.set介護老人保健施設_居住費_2(getValue(syukeiNo0710, 数値_304));
        reportData.set介護老人保健施設_居住費_3(getValue(syukeiNo0710, 数値_404));
        reportData.set介護老人保健施設_居住費_4(getValue(syukeiNo0710, 数値_504));
        reportData.set介護老人保健施設_居住費_5(getValue(syukeiNo0710, 数値_604));
        reportData.set介護老人保健施設_居住費_6(getValue(syukeiNo0710, 数値_704));
    }

    private void set介護療養型医療施設(JigyohokokuCompYoshiki12Data reportData) {
        reportData.set介護療養型医療施設_食費_1(getValue(syukeiNo0710, 数値_205));
        reportData.set介護療養型医療施設_食費_2(getValue(syukeiNo0710, 数値_305));
        reportData.set介護療養型医療施設_食費_3(getValue(syukeiNo0710, 数値_405));
        reportData.set介護療養型医療施設_食費_4(getValue(syukeiNo0710, 数値_505));
        reportData.set介護療養型医療施設_食費_5(getValue(syukeiNo0710, 数値_605));
        reportData.set介護療養型医療施設_食費_6(getValue(syukeiNo0710, 数値_705));
        reportData.set介護療養型医療施設_居住費_1(getValue(syukeiNo0710, 数値_206));
        reportData.set介護療養型医療施設_居住費_2(getValue(syukeiNo0710, 数値_306));
        reportData.set介護療養型医療施設_居住費_3(getValue(syukeiNo0710, 数値_406));
        reportData.set介護療養型医療施設_居住費_4(getValue(syukeiNo0710, 数値_506));
        reportData.set介護療養型医療施設_居住費_5(getValue(syukeiNo0710, 数値_606));
        reportData.set介護療養型医療施設_居住費_6(getValue(syukeiNo0710, 数値_706));
    }

    private void set地域密着型介護老人福祉施設入居者生活介護(JigyohokokuCompYoshiki12Data reportData) {
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_1(getValue(syukeiNo0710, 数値_211));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_2(getValue(syukeiNo0710, 数値_311));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_3(getValue(syukeiNo0710, 数値_411));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_4(getValue(syukeiNo0710, 数値_511));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_5(getValue(syukeiNo0710, 数値_611));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_6(getValue(syukeiNo0710, 数値_711));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_1(getValue(syukeiNo0710, 数値_212));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_2(getValue(syukeiNo0710, 数値_312));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_3(getValue(syukeiNo0710, 数値_412));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_4(getValue(syukeiNo0710, 数値_512));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_5(getValue(syukeiNo0710, 数値_612));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_6(getValue(syukeiNo0710, 数値_712));
    }

    private void setその他(JigyohokokuCompYoshiki12Data reportData) {
        reportData.setその他_食費_1(getValue(syukeiNo0710, 数値_207));
        reportData.setその他_食費_2(getValue(syukeiNo0710, 数値_307));
        reportData.setその他_食費_3(getValue(syukeiNo0710, 数値_407));
        reportData.setその他_食費_4(getValue(syukeiNo0710, 数値_507));
        reportData.setその他_食費_5(getValue(syukeiNo0710, 数値_607));
        reportData.setその他_食費_6(getValue(syukeiNo0710, 数値_707));
        reportData.setその他_居住費_1(getValue(syukeiNo0710, 数値_208));
        reportData.setその他_居住費_2(getValue(syukeiNo0710, 数値_308));
        reportData.setその他_居住費_3(getValue(syukeiNo0710, 数値_408));
        reportData.setその他_居住費_4(getValue(syukeiNo0710, 数値_508));
        reportData.setその他_居住費_5(getValue(syukeiNo0710, 数値_608));
        reportData.setその他_居住費_6(getValue(syukeiNo0710, 数値_708));
    }

    private void set合計(JigyohokokuCompYoshiki12Data reportData) {
        reportData.set合計_食費_1(getValue(syukeiNo0710, 数値_209));
        reportData.set合計_食費_2(getValue(syukeiNo0710, 数値_309));
        reportData.set合計_食費_3(getValue(syukeiNo0710, 数値_409));
        reportData.set合計_食費_4(getValue(syukeiNo0710, 数値_509));
        reportData.set合計_食費_5(getValue(syukeiNo0710, 数値_609));
        reportData.set合計_食費_6(getValue(syukeiNo0710, 数値_709));
        reportData.set合計_居住費_1(getValue(syukeiNo0710, 数値_210));
        reportData.set合計_居住費_2(getValue(syukeiNo0710, 数値_310));
        reportData.set合計_居住費_3(getValue(syukeiNo0710, 数値_410));
        reportData.set合計_居住費_4(getValue(syukeiNo0710, 数値_510));
        reportData.set合計_居住費_5(getValue(syukeiNo0710, 数値_610));
        reportData.set合計_居住費_6(getValue(syukeiNo0710, 数値_710));
    }

    private void set利用者負担減額_免除認定表の利用者負担(JigyohokokuCompYoshiki12Data reportData) {
        reportData.set利用者負担減額_免除認定表の利用者負担_1(getValue(syukeiNo0600, 数値_101));
        reportData.set利用者負担減額_免除認定表の利用者負担_2(getValue(syukeiNo0600, 数値_201));
        reportData.set利用者負担減額_免除認定表の利用者負担_3(getValue(syukeiNo0600, 数値_301));
        reportData.set利用者負担減額_免除認定表の利用者負担_4(getValue(syukeiNo0600, 数値_401));
        reportData.set利用者負担減額_免除認定表の利用者負担_5(getValue(syukeiNo0600, 数値_501));
    }

    private void set介護老人福祉施設旧措置入所者に係る減額_減免認定表の特定負担限度額(JigyohokokuCompYoshiki12Data reportData) {
        reportData.set特定負担限度額の申請件数(getValue(syukeiNo0720, 数値_101));
        reportData.set減免認定表の特定負担限度額_食費_1(getValue(syukeiNo0720, 数値_201));
        reportData.set減免認定表の特定負担限度額_食費_2(getValue(syukeiNo0720, 数値_301));
        reportData.set減免認定表の特定負担限度額_食費_3(getValue(syukeiNo0720, 数値_401));
        reportData.set減免認定表の特定負担限度額_食費_4(getValue(syukeiNo0720, 数値_501));
        reportData.set減免認定表の特定負担限度額_食費_5(getValue(syukeiNo0720, 数値_601));
        reportData.set減免認定表の特定負担限度額_食費_6(getValue(syukeiNo0720, 数値_701));
        reportData.set減免認定表の特定負担限度額_居住費_1(getValue(syukeiNo0720, 数値_202));
        reportData.set減免認定表の特定負担限度額_居住費_2(getValue(syukeiNo0720, 数値_302));
        reportData.set減免認定表の特定負担限度額_居住費_3(getValue(syukeiNo0720, 数値_402));
        reportData.set減免認定表の特定負担限度額_居住費_4(getValue(syukeiNo0720, 数値_502));
        reportData.set減免認定表の特定負担限度額_居住費_5(getValue(syukeiNo0720, 数値_602));
        reportData.set減免認定表の特定負担限度額_居住費_6(getValue(syukeiNo0720, 数値_702));
    }

    private void set介護老人福祉施設旧措置入所者に係る減額_免除認定表の利用者負担(JigyohokokuCompYoshiki12Data reportData) {
        reportData.set免除認定表の利用者負担_1(getValue(syukeiNo0702, 数値_101));
        reportData.set免除認定表の利用者負担_2(getValue(syukeiNo0702, 数値_201));
        reportData.set免除認定表の利用者負担_3(getValue(syukeiNo0702, 数値_301));
        reportData.set免除認定表の利用者負担_4(getValue(syukeiNo0702, 数値_401));
        reportData.set免除認定表の利用者負担_5(getValue(syukeiNo0702, 数値_501));
    }

    private RString getNowDate(RDateTime 処理日時) {
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(処理日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", 処理日時.getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", 処理日時.getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", 処理日時.getSecond()));
        printTimeStamp.append(DATE_秒);
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(DATE_作成);
        return printTimeStamp.toRString();
    }

    private void setMybatisParameter() {
        mybatisParameter = processParameter.toJigyoHokokuGeppoIppanReportMybatisParameter();
        mybatisParameter.setHyonoList(getHyonoList());
        mybatisParameter.setShukeinoList(getShukeinoList());
        List<RString> shichosoncodeList = new ArrayList<>();
        if (PrintControlKubun.集計後印刷.getコード().equals(processParameter.getプリントコントロール区分())) {
            shichosoncodeList.add(processParameter.get市町村コード());
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(processParameter.getプリントコントロール区分())) {
            if (processParameter.get過去市町村コードList() == null || processParameter.get過去市町村コードList().isEmpty()) {
                shichosoncodeList.add(processParameter.get市町村コード());
            } else {
                shichosoncodeList.addAll(processParameter.get過去市町村コードList());
            }
        }
        mybatisParameter.setShichosoncodeList(shichosoncodeList);
    }

    private RString get保険者名(RString 市町村名) {
        if (過去集計分旧市町村区分.equals(processParameter.get過去集計分旧市町村区分())) {
            return new RString("（旧）").concat(市町村名);
        }
        return 市町村名;
    }

    private List<RString> getShukeinoList() {
        List<RString> shukeinoList = new ArrayList<>();
        shukeinoList.add(ShukeiNo.一般状況_4_利用者負担減額_免除認定_総数.getコード());
        shukeinoList.add(ShukeiNo.一般状況_5_介護老人福祉施設旧措置入所者に係る減額_免除認定_総数_利用者負担.getコード());
        if (制度改正月.isBeforeOrEquals(processParameter.get集計年月())) {
            shukeinoList.add(ShukeiNo.一般状況_3_食費_居住費に係る負担限度額認定_総数.getコード());
            shukeinoList.add(ShukeiNo.一般状況_5_介護老人福祉施設旧措置入所者に係る減額_免除認定_総数_特定負担限度額.getコード());
        }
        return shukeinoList;
    }

    private List<RString> getHyonoList() {
        List<RString> hyonoList = new ArrayList<>();
        hyonoList.add(HyoNo.現物_一般状況.getコード());
        hyonoList.add(HyoNo.現物_一般状況_旧市町村.getコード());
        return hyonoList;
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }
}
