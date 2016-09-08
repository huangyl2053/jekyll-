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
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14Data;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14ReportSource;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-4）のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class JigyouHoukokuTokeiReportDBU300004Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getJigyouHoukokuTokeiTyouhyou");
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
    private static final Decimal 数値_102 = new Decimal(102);
    private static final Decimal 数値_202 = new Decimal(202);
    private static final Decimal 数値_302 = new Decimal(302);
    private static final Decimal 数値_402 = new Decimal(402);
    private static final Decimal 数値_502 = new Decimal(502);
    private static final Decimal 数値_103 = new Decimal(103);
    private static final Decimal 数値_203 = new Decimal(203);
    private static final Decimal 数値_303 = new Decimal(303);
    private static final Decimal 数値_403 = new Decimal(403);
    private static final Decimal 数値_503 = new Decimal(503);
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
    private static final Decimal 数値_207 = new Decimal(207);
    private static final Decimal 数値_307 = new Decimal(307);
    private static final Decimal 数値_407 = new Decimal(407);
    private static final Decimal 数値_507 = new Decimal(507);
    private static final Decimal 数値_208 = new Decimal(208);
    private static final Decimal 数値_308 = new Decimal(308);
    private static final Decimal 数値_408 = new Decimal(408);
    private static final Decimal 数値_508 = new Decimal(508);
    private static final Decimal 数値_209 = new Decimal(209);
    private static final Decimal 数値_309 = new Decimal(309);
    private static final Decimal 数値_409 = new Decimal(409);
    private static final Decimal 数値_509 = new Decimal(509);
    private static final Decimal 数値_210 = new Decimal(210);
    private static final Decimal 数値_310 = new Decimal(310);
    private static final Decimal 数値_410 = new Decimal(410);
    private static final Decimal 数値_510 = new Decimal(510);
    private static final Decimal 数値_211 = new Decimal(211);
    private static final Decimal 数値_311 = new Decimal(311);
    private static final Decimal 数値_411 = new Decimal(411);
    private static final Decimal 数値_511 = new Decimal(511);
    private static final Decimal 数値_212 = new Decimal(212);
    private static final Decimal 数値_312 = new Decimal(312);
    private static final Decimal 数値_412 = new Decimal(412);
    private static final Decimal 数値_512 = new Decimal(512);
    private Map<Decimal, Decimal> syukeiNo1040;
    private JigyoHokokuGeppoIppanReportProcessParameter processParameter;
    private JigyoHokokuGeppoIppanReportMybatisParameter mybatisParameter;
    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki14ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki14ReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        syukeiNo1040 = new HashMap<>();
        setMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU300004.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (ShukeiNo.一般状況_9_食費_居住費に係る負担限度額認定_再掲_税制改正による激変緩和措置を受けている者.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1040.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki14Data reportData = new JigyohokokuCompYoshiki14Data();
        reportData.set作成日時(getNowDate(processParameter.get処理日時().getRDateTime()));
        reportData.set集計範囲(processParameter.get集計年月().toDateString());
        reportData.set集計区分(集計区分_月報);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        reportData.set保険者名(get保険者名(association.get市町村名()));
        reportData.set保険者番号(association.get地方公共団体コード().value());
        reportData.set介護老人福祉施設の申請件数(getValue(syukeiNo1040, 数値_101));
        reportData.set介護老人保健施設の申請件数(getValue(syukeiNo1040, 数値_102));
        reportData.set介護療養型医療施設の申請件数(getValue(syukeiNo1040, 数値_103));
        reportData.set地域密着型介護老人福祉施設入居者生活介護の申請件数(getValue(syukeiNo1040, 数値_106));
        reportData.setその他の申請件数(getValue(syukeiNo1040, 数値_104));
        reportData.set合計の申請件数(getValue(syukeiNo1040, 数値_105));
        set介護老人福祉施設(reportData);
        set介護老人保健施設(reportData);
        set介護療養型医療施設(reportData);
        set地域密着型介護老人福祉施設入居者生活介護(reportData);
        setその他(reportData);
        set合計(reportData);

        JigyohokokuCompYoshiki14Report report = new JigyohokokuCompYoshiki14Report(reportData);
        report.writeBy(reportSourceWriter);

    }

    private void set介護老人福祉施設(JigyohokokuCompYoshiki14Data reportData) {
        reportData.set介護老人福祉施設_食費_1(getValue(syukeiNo1040, 数値_201));
        reportData.set介護老人福祉施設_食費_2(getValue(syukeiNo1040, 数値_301));
        reportData.set介護老人福祉施設_食費_3(getValue(syukeiNo1040, 数値_401));
        reportData.set介護老人福祉施設_食費_4(getValue(syukeiNo1040, 数値_501));
        reportData.set介護老人福祉施設_居住費_1(getValue(syukeiNo1040, 数値_202));
        reportData.set介護老人福祉施設_居住費_2(getValue(syukeiNo1040, 数値_302));
        reportData.set介護老人福祉施設_居住費_3(getValue(syukeiNo1040, 数値_402));
        reportData.set介護老人福祉施設_居住費_4(getValue(syukeiNo1040, 数値_502));
    }

    private void set介護老人保健施設(JigyohokokuCompYoshiki14Data reportData) {
        reportData.set介護老人保健施設_食費_1(getValue(syukeiNo1040, 数値_203));
        reportData.set介護老人保健施設_食費_2(getValue(syukeiNo1040, 数値_303));
        reportData.set介護老人保健施設_食費_3(getValue(syukeiNo1040, 数値_403));
        reportData.set介護老人保健施設_食費_4(getValue(syukeiNo1040, 数値_503));
        reportData.set介護老人保健施設_居住費_1(getValue(syukeiNo1040, 数値_204));
        reportData.set介護老人保健施設_居住費_2(getValue(syukeiNo1040, 数値_304));
        reportData.set介護老人保健施設_居住費_3(getValue(syukeiNo1040, 数値_404));
        reportData.set介護老人保健施設_居住費_4(getValue(syukeiNo1040, 数値_504));
    }

    private void set介護療養型医療施設(JigyohokokuCompYoshiki14Data reportData) {
        reportData.set介護療養型医療施設_食費_1(getValue(syukeiNo1040, 数値_205));
        reportData.set介護療養型医療施設_食費_2(getValue(syukeiNo1040, 数値_305));
        reportData.set介護療養型医療施設_食費_3(getValue(syukeiNo1040, 数値_405));
        reportData.set介護療養型医療施設_食費_4(getValue(syukeiNo1040, 数値_505));
        reportData.set介護療養型医療施設_居住費_1(getValue(syukeiNo1040, 数値_206));
        reportData.set介護療養型医療施設_居住費_2(getValue(syukeiNo1040, 数値_306));
        reportData.set介護療養型医療施設_居住費_3(getValue(syukeiNo1040, 数値_406));
        reportData.set介護療養型医療施設_居住費_4(getValue(syukeiNo1040, 数値_506));
    }

    private void set地域密着型介護老人福祉施設入居者生活介護(JigyohokokuCompYoshiki14Data reportData) {
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_1(getValue(syukeiNo1040, 数値_211));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_2(getValue(syukeiNo1040, 数値_311));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_3(getValue(syukeiNo1040, 数値_411));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_4(getValue(syukeiNo1040, 数値_511));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_1(getValue(syukeiNo1040, 数値_212));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_2(getValue(syukeiNo1040, 数値_312));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_3(getValue(syukeiNo1040, 数値_412));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_4(getValue(syukeiNo1040, 数値_512));
    }

    private void setその他(JigyohokokuCompYoshiki14Data reportData) {
        reportData.setその他_食費_1(getValue(syukeiNo1040, 数値_207));
        reportData.setその他_食費_2(getValue(syukeiNo1040, 数値_307));
        reportData.setその他_食費_3(getValue(syukeiNo1040, 数値_407));
        reportData.setその他_食費_4(getValue(syukeiNo1040, 数値_507));
        reportData.setその他_居住費_1(getValue(syukeiNo1040, 数値_208));
        reportData.setその他_居住費_2(getValue(syukeiNo1040, 数値_308));
        reportData.setその他_居住費_3(getValue(syukeiNo1040, 数値_408));
        reportData.setその他_居住費_4(getValue(syukeiNo1040, 数値_508));
    }

    private void set合計(JigyohokokuCompYoshiki14Data reportData) {
        reportData.set合計_食費_1(getValue(syukeiNo1040, 数値_209));
        reportData.set合計_食費_2(getValue(syukeiNo1040, 数値_309));
        reportData.set合計_食費_3(getValue(syukeiNo1040, 数値_409));
        reportData.set合計_食費_4(getValue(syukeiNo1040, 数値_509));
        reportData.set合計_居住費_1(getValue(syukeiNo1040, 数値_210));
        reportData.set合計_居住費_2(getValue(syukeiNo1040, 数値_310));
        reportData.set合計_居住費_3(getValue(syukeiNo1040, 数値_410));
        reportData.set合計_居住費_4(getValue(syukeiNo1040, 数値_510));
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
        shukeinoList.add(ShukeiNo.一般状況_9_食費_居住費に係る負担限度額認定_再掲_税制改正による激変緩和措置を受けている者.getコード());
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
