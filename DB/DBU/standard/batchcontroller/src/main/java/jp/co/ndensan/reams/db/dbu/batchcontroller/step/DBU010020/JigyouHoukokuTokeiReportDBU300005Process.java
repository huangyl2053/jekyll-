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
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151Data;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151ReportSource;
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
 * 介護事業状況報告月報・一般状況（様式1-3）のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class JigyouHoukokuTokeiReportDBU300005Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

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
    private static final Decimal 数値_105 = new Decimal(105);
    private static final Decimal 数値_106 = new Decimal(106);
    private static final Decimal 数値_205 = new Decimal(205);
    private static final Decimal 数値_305 = new Decimal(305);
    private static final Decimal 数値_405 = new Decimal(405);
    private static final Decimal 数値_505 = new Decimal(505);
    private static final Decimal 数値_206 = new Decimal(206);
    private static final Decimal 数値_306 = new Decimal(306);
    private static final Decimal 数値_406 = new Decimal(406);
    private static final Decimal 数値_506 = new Decimal(506);
    private static final Decimal 数値_107 = new Decimal(107);
    private static final Decimal 数値_207 = new Decimal(207);
    private static final Decimal 数値_307 = new Decimal(307);
    private static final Decimal 数値_407 = new Decimal(407);
    private static final Decimal 数値_507 = new Decimal(507);
    private static final Decimal 数値_109 = new Decimal(109);
    private static final Decimal 数値_209 = new Decimal(209);
    private static final Decimal 数値_309 = new Decimal(309);
    private static final Decimal 数値_409 = new Decimal(409);
    private static final Decimal 数値_509 = new Decimal(509);
    private static final Decimal 数値_110 = new Decimal(110);
    private static final Decimal 数値_210 = new Decimal(210);
    private static final Decimal 数値_310 = new Decimal(310);
    private static final Decimal 数値_410 = new Decimal(410);
    private static final Decimal 数値_510 = new Decimal(510);
    private static final Decimal 数値_111 = new Decimal(111);
    private static final Decimal 数値_211 = new Decimal(211);
    private static final Decimal 数値_311 = new Decimal(311);
    private static final Decimal 数値_411 = new Decimal(411);
    private static final Decimal 数値_511 = new Decimal(511);
    private static final Decimal 数値_112 = new Decimal(112);
    private static final Decimal 数値_212 = new Decimal(212);
    private static final Decimal 数値_312 = new Decimal(312);
    private static final Decimal 数値_412 = new Decimal(412);
    private static final Decimal 数値_512 = new Decimal(512);
    private Map<Decimal, Decimal> syukeiNo1030;
    private Map<Decimal, Decimal> syukeiNo1100;
    private JigyoHokokuGeppoIppanReportProcessParameter processParameter;
    private JigyoHokokuGeppoIppanReportMybatisParameter mybatisParameter;
    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki151ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki151ReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        syukeiNo1030 = new HashMap<>();
        syukeiNo1100 = new HashMap<>();
        setMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU300005.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (ShukeiNo.一般状況_11_要介護_要支援_認定者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1100.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_10_利用者負担第4段階における_食費_居住費の特例減額措置.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1030.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki151Data reportData = new JigyohokokuCompYoshiki151Data();
        reportData.set作成日時(getNowDate(processParameter.get処理日時().getRDateTime()));
        reportData.set集計範囲(processParameter.get集計年月().toDateString());
        reportData.set集計区分(集計区分_月報);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        reportData.set保険者名(get保険者名(association.get市町村名()));
        reportData.set保険者番号(association.get地方公共団体コード().value());
        set食費居住費の特例減額措置_第1号被保険者(reportData);
        set食費居住費の特例減額措置_第2号被保険者(reportData);
        set食費居住費の特例減額措置_合計(reportData);
        set要支援認定者数_要支援1(reportData);
        set要支援認定者数_要支援2(reportData);
        set要支援認定者数_計(reportData);
        set要介護認定者数_経過的要介護(reportData);
        set要介護認定者数_要介護1(reportData);
        set要介護認定者数_要介護2(reportData);
        set要介護認定者数_要介護3(reportData);
        set要介護認定者数_要介護4(reportData);
        set要介護認定者数_要介護5(reportData);
        set要介護認定者数_計(reportData);
        set要介護認定者数_合計(reportData);
        JigyohokokuCompYoshiki151Report report = new JigyohokokuCompYoshiki151Report(reportData);
        report.writeBy(reportSourceWriter);

    }

    private void set食費居住費の特例減額措置_第1号被保険者(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set食費居住費の特例減額措置_第1号被保険者_1(getValue(syukeiNo1030, 数値_101));
        reportData.set食費居住費の特例減額措置_第1号被保険者_2(getValue(syukeiNo1030, 数値_201));
        reportData.set食費居住費の特例減額措置_第1号被保険者_3(getValue(syukeiNo1030, 数値_301));
        reportData.set食費居住費の特例減額措置_第1号被保険者_4(getValue(syukeiNo1030, 数値_401));
        reportData.set食費居住費の特例減額措置_第1号被保険者_5(getValue(syukeiNo1030, 数値_501));
        reportData.set食費居住費の特例減額措置_第1号被保険者_6(getValue(syukeiNo1030, 数値_601));
        reportData.set食費居住費の特例減額措置_第1号被保険者_7(getValue(syukeiNo1030, 数値_701));
    }

    private void set食費居住費の特例減額措置_第2号被保険者(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set食費居住費の特例減額措置_第2号被保険者_1(getValue(syukeiNo1030, 数値_102));
        reportData.set食費居住費の特例減額措置_第2号被保険者_2(getValue(syukeiNo1030, 数値_202));
        reportData.set食費居住費の特例減額措置_第2号被保険者_3(getValue(syukeiNo1030, 数値_302));
        reportData.set食費居住費の特例減額措置_第2号被保険者_4(getValue(syukeiNo1030, 数値_402));
        reportData.set食費居住費の特例減額措置_第2号被保険者_5(getValue(syukeiNo1030, 数値_502));
        reportData.set食費居住費の特例減額措置_第2号被保険者_6(getValue(syukeiNo1030, 数値_602));
        reportData.set食費居住費の特例減額措置_第2号被保険者_7(getValue(syukeiNo1030, 数値_702));
    }

    private void set食費居住費の特例減額措置_合計(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set食費居住費の特例減額措置_合計_1(getValue(syukeiNo1030, 数値_103));
        reportData.set食費居住費の特例減額措置_合計_2(getValue(syukeiNo1030, 数値_203));
        reportData.set食費居住費の特例減額措置_合計_3(getValue(syukeiNo1030, 数値_303));
        reportData.set食費居住費の特例減額措置_合計_4(getValue(syukeiNo1030, 数値_403));
        reportData.set食費居住費の特例減額措置_合計_5(getValue(syukeiNo1030, 数値_503));
        reportData.set食費居住費の特例減額措置_合計_6(getValue(syukeiNo1030, 数値_603));
        reportData.set食費居住費の特例減額措置_合計_7(getValue(syukeiNo1030, 数値_703));
    }

    private void set要支援認定者数_要支援1(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要支援認定者数_要支援1_1(getValue(syukeiNo1100, 数値_109));
        reportData.set要支援認定者数_要支援1_2(getValue(syukeiNo1100, 数値_209));
        reportData.set要支援認定者数_要支援1_3(getValue(syukeiNo1100, 数値_309));
        reportData.set要支援認定者数_要支援1_4(getValue(syukeiNo1100, 数値_409));
        reportData.set要支援認定者数_要支援1_5(getValue(syukeiNo1100, 数値_509));
    }

    private void set要支援認定者数_要支援2(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要支援認定者数_要支援2_1(getValue(syukeiNo1100, 数値_110));
        reportData.set要支援認定者数_要支援2_2(getValue(syukeiNo1100, 数値_210));
        reportData.set要支援認定者数_要支援2_3(getValue(syukeiNo1100, 数値_310));
        reportData.set要支援認定者数_要支援2_4(getValue(syukeiNo1100, 数値_410));
        reportData.set要支援認定者数_要支援2_5(getValue(syukeiNo1100, 数値_510));
    }

    private void set要支援認定者数_計(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要支援認定者数_計_1(getValue(syukeiNo1100, 数値_111));
        reportData.set要支援認定者数_計_2(getValue(syukeiNo1100, 数値_211));
        reportData.set要支援認定者数_計_3(getValue(syukeiNo1100, 数値_311));
        reportData.set要支援認定者数_計_4(getValue(syukeiNo1100, 数値_411));
        reportData.set要支援認定者数_計_5(getValue(syukeiNo1100, 数値_511));
    }

    private void set要介護認定者数_経過的要介護(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要介護認定者数_経過的要介護_1(getValue(syukeiNo1100, 数値_101));
        reportData.set要介護認定者数_経過的要介護_2(getValue(syukeiNo1100, 数値_201));
        reportData.set要介護認定者数_経過的要介護_3(getValue(syukeiNo1100, 数値_301));
        reportData.set要介護認定者数_経過的要介護_4(getValue(syukeiNo1100, 数値_401));
        reportData.set要介護認定者数_経過的要介護_5(getValue(syukeiNo1100, 数値_501));
    }

    private void set要介護認定者数_要介護1(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要介護認定者数_要介護1_1(getValue(syukeiNo1100, 数値_102));
        reportData.set要介護認定者数_要介護1_2(getValue(syukeiNo1100, 数値_202));
        reportData.set要介護認定者数_要介護1_3(getValue(syukeiNo1100, 数値_302));
        reportData.set要介護認定者数_要介護1_4(getValue(syukeiNo1100, 数値_402));
        reportData.set要介護認定者数_要介護1_5(getValue(syukeiNo1100, 数値_502));
    }

    private void set要介護認定者数_要介護2(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要介護認定者数_要介護2_1(getValue(syukeiNo1100, 数値_103));
        reportData.set要介護認定者数_要介護2_2(getValue(syukeiNo1100, 数値_203));
        reportData.set要介護認定者数_要介護2_3(getValue(syukeiNo1100, 数値_303));
        reportData.set要介護認定者数_要介護2_4(getValue(syukeiNo1100, 数値_403));
        reportData.set要介護認定者数_要介護2_5(getValue(syukeiNo1100, 数値_503));
    }

    private void set要介護認定者数_要介護3(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要介護認定者数_要介護3_1(getValue(syukeiNo1100, 数値_104));
        reportData.set要介護認定者数_要介護3_2(getValue(syukeiNo1100, 数値_204));
        reportData.set要介護認定者数_要介護3_3(getValue(syukeiNo1100, 数値_304));
        reportData.set要介護認定者数_要介護3_4(getValue(syukeiNo1100, 数値_404));
        reportData.set要介護認定者数_要介護3_5(getValue(syukeiNo1100, 数値_504));
    }

    private void set要介護認定者数_要介護4(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要介護認定者数_要介護4_1(getValue(syukeiNo1100, 数値_105));
        reportData.set要介護認定者数_要介護4_2(getValue(syukeiNo1100, 数値_205));
        reportData.set要介護認定者数_要介護4_3(getValue(syukeiNo1100, 数値_305));
        reportData.set要介護認定者数_要介護4_4(getValue(syukeiNo1100, 数値_405));
        reportData.set要介護認定者数_要介護4_5(getValue(syukeiNo1100, 数値_505));
    }

    private void set要介護認定者数_要介護5(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要介護認定者数_要介護5_1(getValue(syukeiNo1100, 数値_106));
        reportData.set要介護認定者数_要介護5_2(getValue(syukeiNo1100, 数値_206));
        reportData.set要介護認定者数_要介護5_3(getValue(syukeiNo1100, 数値_306));
        reportData.set要介護認定者数_要介護5_4(getValue(syukeiNo1100, 数値_406));
        reportData.set要介護認定者数_要介護5_5(getValue(syukeiNo1100, 数値_506));
    }

    private void set要介護認定者数_計(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要介護認定者数_計_1(getValue(syukeiNo1100, 数値_107));
        reportData.set要介護認定者数_計_2(getValue(syukeiNo1100, 数値_207));
        reportData.set要介護認定者数_計_3(getValue(syukeiNo1100, 数値_307));
        reportData.set要介護認定者数_計_4(getValue(syukeiNo1100, 数値_407));
        reportData.set要介護認定者数_計_5(getValue(syukeiNo1100, 数値_507));
    }

    private void set要介護認定者数_合計(JigyohokokuCompYoshiki151Data reportData) {
        reportData.set要介護認定者数_合計_1(getValue(syukeiNo1100, 数値_112));
        reportData.set要介護認定者数_合計_2(getValue(syukeiNo1100, 数値_212));
        reportData.set要介護認定者数_合計_3(getValue(syukeiNo1100, 数値_312));
        reportData.set要介護認定者数_合計_4(getValue(syukeiNo1100, 数値_412));
        reportData.set要介護認定者数_合計_5(getValue(syukeiNo1100, 数値_512));
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
        shukeinoList.add(ShukeiNo.一般状況_11_要介護_要支援_認定者数.getコード());
        if (制度改正月.isBeforeOrEquals(processParameter.get集計年月())) {
            shukeinoList.add(ShukeiNo.一般状況_10_利用者負担第4段階における_食費_居住費の特例減額措置.getコード());
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
