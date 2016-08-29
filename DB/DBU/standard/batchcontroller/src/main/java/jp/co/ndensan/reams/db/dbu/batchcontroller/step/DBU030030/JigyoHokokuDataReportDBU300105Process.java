/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030;

import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14300105.JigyohokokuCompYoshiki14300105Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyojokyohokokushiryonemposakuseiiti.JigyoJokyoHokokuShiryoNempoSakuseiItiProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14300105.JigyohokokuCompYoshiki14300105Data;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki14300105.JigyohokokuCompYoshiki14300105ReportSource;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告年報（様式1-4）帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-030 dingyi
 *
 */
public class JigyoHokokuDataReportDBU300105Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoJokyoHokokuShiryoNempoSakuseiItiMapper.getJigyouHokokuTokeiReportJyoho");
    private JigyoJokyoHokokuShiryoNempoSakuseiItiProcessParamter processParameter;

    private static final ReportId REPORT_DBU300105 = ReportIdDBU.DBU300105.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final RString 年報月報区分 = new RString("年報");
    private static final int 数値_100 = 100;
    private static final Decimal 数値_101 = new Decimal(101);
    private static final Decimal 数値_102 = new Decimal(102);
    private static final Decimal 数値_103 = new Decimal(103);
    private static final Decimal 数値_104 = new Decimal(104);
    private static final Decimal 数値_105 = new Decimal(105);
    private static final Decimal 数値_106 = new Decimal(106);
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

    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo1040;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki14300105ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki14300105ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
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
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300105.value()).create();
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
        JigyohokokuCompYoshiki14300105Data reportData = new JigyohokokuCompYoshiki14300105Data();
        reportData.set年報月報区分(年報月報区分);
        reportData.set処理日時(RDateTime.parse(processParameter.get処理日時()));
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.set集計年度(new FlexibleYear(processParameter.get集計年度()));
        reportData.set集計期間FROM(new FlexibleYearMonth(processParameter.get集計開始年月()));
        reportData.set集計期間TO(new FlexibleYearMonth(processParameter.get集計終了年月()));
        reportData.set介護老人福祉施設の申請件数(new RString(syukeiNo1040.get(数値_101).longValue()));
        reportData.set介護老人保健施設の申請件数(new RString(syukeiNo1040.get(数値_102).longValue()));
        reportData.set介護療養型医療施設の申請件数(new RString(syukeiNo1040.get(数値_103).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護の申請件数(new RString(syukeiNo1040.get(数値_106).longValue()));
        reportData.setその他の申請件数(new RString(syukeiNo1040.get(数値_104).longValue()));
        reportData.set合計の申請件数(new RString(syukeiNo1040.get(数値_105).longValue()));
        reportData.set介護老人福祉施設_食費_1(new RString(syukeiNo1040.get(数値_201).longValue()));
        reportData.set介護老人福祉施設_食費_2(new RString(syukeiNo1040.get(数値_301).longValue()));
        reportData.set介護老人福祉施設_食費_3(new RString(syukeiNo1040.get(数値_401).longValue()));
        reportData.set介護老人福祉施設_食費_4(new RString(syukeiNo1040.get(数値_501).longValue()));
        reportData.set介護老人福祉施設_居住費_1(new RString(syukeiNo1040.get(数値_202).longValue()));
        reportData.set介護老人福祉施設_居住費_2(new RString(syukeiNo1040.get(数値_302).longValue()));
        reportData.set介護老人福祉施設_居住費_3(new RString(syukeiNo1040.get(数値_402).longValue()));
        reportData.set介護老人福祉施設_居住費_4(new RString(syukeiNo1040.get(数値_502).longValue()));
        reportData.set介護老人保健施設_食費_1(new RString(syukeiNo1040.get(数値_203).longValue()));
        reportData.set介護老人保健施設_食費_2(new RString(syukeiNo1040.get(数値_303).longValue()));
        reportData.set介護老人保健施設_食費_3(new RString(syukeiNo1040.get(数値_403).longValue()));
        reportData.set介護老人保健施設_食費_4(new RString(syukeiNo1040.get(数値_503).longValue()));
        reportData.set介護老人保健施設_居住費_1(new RString(syukeiNo1040.get(数値_204).longValue()));
        reportData.set介護老人保健施設_居住費_2(new RString(syukeiNo1040.get(数値_304).longValue()));
        reportData.set介護老人保健施設_居住費_3(new RString(syukeiNo1040.get(数値_404).longValue()));
        reportData.set介護老人保健施設_居住費_4(new RString(syukeiNo1040.get(数値_504).longValue()));
        reportData.set介護療養型医療施設_食費_1(new RString(syukeiNo1040.get(数値_205).longValue()));
        reportData.set介護療養型医療施設_食費_2(new RString(syukeiNo1040.get(数値_305).longValue()));
        reportData.set介護療養型医療施設_食費_3(new RString(syukeiNo1040.get(数値_405).longValue()));
        reportData.set介護療養型医療施設_食費_4(new RString(syukeiNo1040.get(数値_505).longValue()));
        reportData.set介護療養型医療施設_居住費_1(new RString(syukeiNo1040.get(数値_206).longValue()));
        reportData.set介護療養型医療施設_居住費_2(new RString(syukeiNo1040.get(数値_306).longValue()));
        reportData.set介護療養型医療施設_居住費_3(new RString(syukeiNo1040.get(数値_406).longValue()));
        reportData.set介護療養型医療施設_居住費_4(new RString(syukeiNo1040.get(数値_506).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_1(new RString(syukeiNo1040.get(数値_211).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_2(new RString(syukeiNo1040.get(数値_311).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_3(new RString(syukeiNo1040.get(数値_411).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_食費_4(new RString(syukeiNo1040.get(数値_511).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_1(new RString(syukeiNo1040.get(数値_212).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_2(new RString(syukeiNo1040.get(数値_312).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_3(new RString(syukeiNo1040.get(数値_412).longValue()));
        reportData.set地域密着型介護老人福祉施設入居者生活介護_居住費_4(new RString(syukeiNo1040.get(数値_512).longValue()));
        reportData.setその他_食費_1(new RString(syukeiNo1040.get(数値_207).longValue()));
        reportData.setその他_食費_2(new RString(syukeiNo1040.get(数値_307).longValue()));
        reportData.setその他_食費_3(new RString(syukeiNo1040.get(数値_407).longValue()));
        reportData.setその他_食費_4(new RString(syukeiNo1040.get(数値_507).longValue()));
        reportData.setその他_居住費_1(new RString(syukeiNo1040.get(数値_208).longValue()));
        reportData.setその他_居住費_2(new RString(syukeiNo1040.get(数値_308).longValue()));
        reportData.setその他_居住費_3(new RString(syukeiNo1040.get(数値_408).longValue()));
        reportData.setその他_居住費_4(new RString(syukeiNo1040.get(数値_508).longValue()));
        reportData.set合計_食費_1(new RString(syukeiNo1040.get(数値_209).longValue()));
        reportData.set合計_食費_2(new RString(syukeiNo1040.get(数値_309).longValue()));
        reportData.set合計_食費_3(new RString(syukeiNo1040.get(数値_409).longValue()));
        reportData.set合計_食費_4(new RString(syukeiNo1040.get(数値_509).longValue()));
        reportData.set合計_居住費_1(new RString(syukeiNo1040.get(数値_210).longValue()));
        reportData.set合計_居住費_2(new RString(syukeiNo1040.get(数値_310).longValue()));
        reportData.set合計_居住費_3(new RString(syukeiNo1040.get(数値_410).longValue()));
        reportData.set合計_居住費_4(new RString(syukeiNo1040.get(数値_510).longValue()));
        JigyohokokuCompYoshiki14300105Report report = new JigyohokokuCompYoshiki14300105Report(reportData);
        report.writeBy(reportSourceWriter);
    }
}
