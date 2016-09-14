/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldReport;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldData;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 *
 */
public class JigyoHokokuGeppoIppanShokanDBU300007Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoHokokuGeppoIppanShokanMapper.getJigyouHoukokuTokeiTyouhyou");
    private JigyoHokokuGeppoIppanShokanProcessParamter processParameter;

    private static final ReportId REPORT_DBU300007 = ReportIdDBU.DBU300007.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final RString 年報月報区分 = new RString("月報");
    private static final int 数値_10 = 10;
    private static final Decimal 数値_101 = new Decimal(101);
    private static final Decimal 数値_102 = new Decimal(102);
    private static final Decimal 数値_103 = new Decimal(103);
    private static final Decimal 数値_104 = new Decimal(104);
    private static final Decimal 数値_105 = new Decimal(105);
    private static final Decimal 数値_106 = new Decimal(106);
    private static final Decimal 数値_107 = new Decimal(107);
    private static final Decimal 数値_108 = new Decimal(108);
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
    private static final Decimal 数値_208 = new Decimal(208);
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
    private static final Decimal 数値_308 = new Decimal(308);
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
    private static final Decimal 数値_408 = new Decimal(408);
    private static final Decimal 数値_409 = new Decimal(409);
    private static final Decimal 数値_410 = new Decimal(410);
    private static final Decimal 数値_411 = new Decimal(411);
    private static final Decimal 数値_412 = new Decimal(412);
    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo1391;
    private Map<Decimal, Decimal> syukeiNo1392;
    private Map<Decimal, Decimal> syukeiNo1393;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki153OldReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki153OldReportSource> reportSourceWriter;

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
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.tocreate事業報告統計データ_14MybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300007.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (ShukeiNo.一般状況_14_施設介護サービス受給者数_介護老人福祉施設.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1391.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_15_施設介護サービス受給者数_介護老人保健施設.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1392.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_16_施設介護サービス受給者数_介護療養型医療施設_総数含む.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1393.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki153OldData reportData = new JigyohokokuCompYoshiki153OldData();
        reportData.setプリント日時(processParameter.get処理日時());
        reportData.set集計区分(年報月報区分);
        reportData.set集計範囲(processParameter.get決定年月());
        reportData.set集計区分(保険者番号);
        reportData.set集計区分(保険者名);
        reportData.set給付区分(processParameter.get給付集計区分());
        reportData.set予防給付_要支援1_1(getValue(syukeiNo1391, 数値_101));
        reportData.set予防給付_要支援1_2(getValue(syukeiNo1391, 数値_201));
        reportData.set予防給付_要支援1_3(getValue(syukeiNo1391, 数値_301));
        reportData.set予防給付_要支援1_4(getValue(syukeiNo1392, 数値_101));
        reportData.set予防給付_要支援1_5(getValue(syukeiNo1392, 数値_201));
        reportData.set予防給付_要支援1_6(getValue(syukeiNo1392, 数値_301));
        reportData.set予防給付_要支援1_7(getValue(syukeiNo1393, 数値_101));
        reportData.set予防給付_要支援1_8(getValue(syukeiNo1393, 数値_201));
        reportData.set予防給付_要支援1_9(getValue(syukeiNo1393, 数値_301));
        reportData.set予防給付_要支援1_10(getValue(syukeiNo1393, 数値_401));
        reportData.set予防給付_要支援2_1(getValue(syukeiNo1391, 数値_102));
        reportData.set予防給付_要支援2_2(getValue(syukeiNo1391, 数値_202));
        reportData.set予防給付_要支援2_3(getValue(syukeiNo1391, 数値_302));
        reportData.set予防給付_要支援2_4(getValue(syukeiNo1392, 数値_102));
        reportData.set予防給付_要支援2_5(getValue(syukeiNo1392, 数値_202));
        reportData.set予防給付_要支援2_6(getValue(syukeiNo1392, 数値_302));
        reportData.set予防給付_要支援2_7(getValue(syukeiNo1393, 数値_102));
        reportData.set予防給付_要支援2_8(getValue(syukeiNo1393, 数値_202));
        reportData.set予防給付_要支援2_9(getValue(syukeiNo1393, 数値_302));
        reportData.set予防給付_要支援2_10(getValue(syukeiNo1393, 数値_402));
        reportData.set予防給付の計_1(getValue(syukeiNo1391, 数値_103));
        reportData.set予防給付の計_2(getValue(syukeiNo1391, 数値_203));
        reportData.set予防給付の計_3(getValue(syukeiNo1391, 数値_303));
        reportData.set予防給付の計_4(getValue(syukeiNo1392, 数値_103));
        reportData.set予防給付の計_5(getValue(syukeiNo1392, 数値_203));
        reportData.set予防給付の計_6(getValue(syukeiNo1392, 数値_303));
        reportData.set予防給付の計_7(getValue(syukeiNo1393, 数値_103));
        reportData.set予防給付の計_8(getValue(syukeiNo1393, 数値_203));
        reportData.set予防給付の計_9(getValue(syukeiNo1393, 数値_303));
        reportData.set予防給付の計_10(getValue(syukeiNo1393, 数値_403));
        reportData.set介護給付_経過的要介護_1(getValue(syukeiNo1391, 数値_104));
        reportData.set介護給付_経過的要介護_2(getValue(syukeiNo1391, 数値_204));
        reportData.set介護給付_経過的要介護_3(getValue(syukeiNo1391, 数値_304));
        reportData.set介護給付_経過的要介護_4(getValue(syukeiNo1392, 数値_104));
        reportData.set介護給付_経過的要介護_5(getValue(syukeiNo1392, 数値_204));
        reportData.set介護給付_経過的要介護_6(getValue(syukeiNo1392, 数値_304));
        reportData.set介護給付_経過的要介護_7(getValue(syukeiNo1393, 数値_104));
        reportData.set介護給付_経過的要介護_8(getValue(syukeiNo1393, 数値_204));
        reportData.set介護給付_経過的要介護_9(getValue(syukeiNo1393, 数値_304));
        reportData.set介護給付_経過的要介護_10(getValue(syukeiNo1393, 数値_404));
        reportData.set介護給付_要介護1_1(getValue(syukeiNo1391, 数値_105));
        reportData.set介護給付_要介護1_2(getValue(syukeiNo1391, 数値_205));
        reportData.set介護給付_要介護1_3(getValue(syukeiNo1391, 数値_305));
        reportData.set介護給付_要介護1_4(getValue(syukeiNo1392, 数値_105));
        reportData.set介護給付_要介護1_5(getValue(syukeiNo1392, 数値_205));
        reportData.set介護給付_要介護1_6(getValue(syukeiNo1392, 数値_305));
        reportData.set介護給付_要介護1_7(getValue(syukeiNo1393, 数値_105));
        reportData.set介護給付_要介護1_8(getValue(syukeiNo1393, 数値_205));
        reportData.set介護給付_要介護1_9(getValue(syukeiNo1393, 数値_305));
        reportData.set介護給付_要介護1_10(getValue(syukeiNo1393, 数値_405));
        reportData.set介護給付_要介護2_1(getValue(syukeiNo1391, 数値_106));
        reportData.set介護給付_要介護2_2(getValue(syukeiNo1391, 数値_206));
        reportData.set介護給付_要介護2_3(getValue(syukeiNo1391, 数値_306));
        reportData.set介護給付_要介護2_4(getValue(syukeiNo1392, 数値_106));
        reportData.set介護給付_要介護2_5(getValue(syukeiNo1392, 数値_206));
        reportData.set介護給付_要介護2_6(getValue(syukeiNo1392, 数値_306));
        reportData.set介護給付_要介護2_7(getValue(syukeiNo1393, 数値_106));
        reportData.set介護給付_要介護2_8(getValue(syukeiNo1393, 数値_206));
        reportData.set介護給付_要介護2_9(getValue(syukeiNo1393, 数値_306));
        reportData.set介護給付_要介護2_10(getValue(syukeiNo1393, 数値_406));
        reportData.set介護給付_要介護3_1(getValue(syukeiNo1391, 数値_107));
        reportData.set介護給付_要介護3_2(getValue(syukeiNo1391, 数値_207));
        reportData.set介護給付_要介護3_3(getValue(syukeiNo1391, 数値_307));
        reportData.set介護給付_要介護3_4(getValue(syukeiNo1392, 数値_107));
        reportData.set介護給付_要介護3_5(getValue(syukeiNo1392, 数値_207));
        reportData.set介護給付_要介護3_6(getValue(syukeiNo1392, 数値_307));
        reportData.set介護給付_要介護3_7(getValue(syukeiNo1393, 数値_107));
        reportData.set介護給付_要介護3_8(getValue(syukeiNo1393, 数値_207));
        reportData.set介護給付_要介護3_9(getValue(syukeiNo1393, 数値_307));
        reportData.set介護給付_要介護3_10(getValue(syukeiNo1393, 数値_407));
        reportData.set介護給付_要介護4_1(getValue(syukeiNo1391, 数値_108));
        reportData.set介護給付_要介護4_2(getValue(syukeiNo1391, 数値_208));
        reportData.set介護給付_要介護4_3(getValue(syukeiNo1391, 数値_308));
        reportData.set介護給付_要介護4_4(getValue(syukeiNo1392, 数値_108));
        reportData.set介護給付_要介護4_5(getValue(syukeiNo1392, 数値_208));
        reportData.set介護給付_要介護4_6(getValue(syukeiNo1392, 数値_308));
        reportData.set介護給付_要介護4_7(getValue(syukeiNo1393, 数値_108));
        reportData.set介護給付_要介護4_8(getValue(syukeiNo1393, 数値_208));
        reportData.set介護給付_要介護4_9(getValue(syukeiNo1393, 数値_308));
        reportData.set介護給付_要介護4_10(getValue(syukeiNo1393, 数値_408));
        reportData.set介護給付_要介護5_1(getValue(syukeiNo1391, 数値_109));
        reportData.set介護給付_要介護5_2(getValue(syukeiNo1391, 数値_209));
        reportData.set介護給付_要介護5_3(getValue(syukeiNo1391, 数値_309));
        reportData.set介護給付_要介護5_4(getValue(syukeiNo1392, 数値_109));
        reportData.set介護給付_要介護5_5(getValue(syukeiNo1392, 数値_209));
        reportData.set介護給付_要介護5_6(getValue(syukeiNo1392, 数値_309));
        reportData.set介護給付_要介護5_7(getValue(syukeiNo1393, 数値_109));
        reportData.set介護給付_要介護5_8(getValue(syukeiNo1393, 数値_209));
        reportData.set介護給付_要介護5_9(getValue(syukeiNo1393, 数値_309));
        reportData.set介護給付_要介護5_10(getValue(syukeiNo1393, 数値_409));
        reportData.set介護給付_その他_1(getValue(syukeiNo1391, 数値_110));
        reportData.set介護給付_その他_2(getValue(syukeiNo1391, 数値_210));
        reportData.set介護給付_その他_3(getValue(syukeiNo1391, 数値_310));
        reportData.set介護給付_その他_4(getValue(syukeiNo1392, 数値_110));
        reportData.set介護給付_その他_5(getValue(syukeiNo1392, 数値_210));
        reportData.set介護給付_その他_6(getValue(syukeiNo1392, 数値_310));
        reportData.set介護給付_その他_7(getValue(syukeiNo1393, 数値_110));
        reportData.set介護給付_その他_8(getValue(syukeiNo1393, 数値_210));
        reportData.set介護給付_その他_9(getValue(syukeiNo1393, 数値_310));
        reportData.set介護給付_その他_10(getValue(syukeiNo1393, 数値_410));
        reportData.set介護給付の計_1(getValue(syukeiNo1391, 数値_111));
        reportData.set介護給付の計_2(getValue(syukeiNo1391, 数値_211));
        reportData.set介護給付の計_3(getValue(syukeiNo1391, 数値_311));
        reportData.set介護給付の計_4(getValue(syukeiNo1392, 数値_111));
        reportData.set介護給付の計_5(getValue(syukeiNo1392, 数値_211));
        reportData.set介護給付の計_6(getValue(syukeiNo1392, 数値_311));
        reportData.set介護給付の計_7(getValue(syukeiNo1393, 数値_111));
        reportData.set介護給付の計_8(getValue(syukeiNo1393, 数値_211));
        reportData.set介護給付の計_9(getValue(syukeiNo1393, 数値_311));
        reportData.set介護給付の計_10(getValue(syukeiNo1393, 数値_411));
        reportData.setサービス受給者数合計_1(getValue(syukeiNo1391, 数値_112));
        reportData.setサービス受給者数合計_2(getValue(syukeiNo1391, 数値_212));
        reportData.setサービス受給者数合計_3(getValue(syukeiNo1391, 数値_312));
        reportData.setサービス受給者数合計_4(getValue(syukeiNo1392, 数値_112));
        reportData.setサービス受給者数合計_5(getValue(syukeiNo1392, 数値_212));
        reportData.setサービス受給者数合計_6(getValue(syukeiNo1392, 数値_312));
        reportData.setサービス受給者数合計_7(getValue(syukeiNo1393, 数値_112));
        reportData.setサービス受給者数合計_8(getValue(syukeiNo1393, 数値_212));
        reportData.setサービス受給者数合計_9(getValue(syukeiNo1393, 数値_312));
        reportData.setサービス受給者数合計_10(getValue(syukeiNo1393, 数値_412));
        JigyohokokuCompYoshiki153OldReport report = new JigyohokokuCompYoshiki153OldReport(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }
}
