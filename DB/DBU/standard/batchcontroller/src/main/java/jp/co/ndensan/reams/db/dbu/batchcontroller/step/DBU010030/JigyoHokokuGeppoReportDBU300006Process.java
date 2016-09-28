/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.JigyouHoukokuTokTyhyouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152ReportSource;
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
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 *
 */
public class JigyoHokokuGeppoReportDBU300006Process extends BatchProcessBase<JigyouHoukokuTokTyhyouRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu."
            + "IJigyoHokokuGeppoIppanGenbutsuMapper.getJigyouHoukokuTokeiTyouhyou");
    private static final ReportId REPORT_DBU300006 = ReportIdDBU.DBU300006.getReportId();
    private static final RString 年報月報区分 = new RString("1");
    private static final int 数値_100 = 10;
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
    private Map<Decimal, Decimal> syukeiNo1200;
    private Map<Decimal, Decimal> syukeiNo1400;
    private JigyoHokokuGeppoIppanGenbutsuProcessParamter processParameter;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki152ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki152ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        syukeiNo1200 = new HashMap<>();
        syukeiNo1400 = new HashMap<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.to事業報告統計データ_12_13MybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300006.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyouHoukokuTokTyhyouRelateEntity entity) {
        if (ShukeiNo.一般状況_12_居宅介護_介護予防_サービス受給者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1200.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_13_地域密着型_介護予防_サービス受給者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1400.put(entity.getTateNo().multiply(数値_100).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki152Data reportData = new JigyohokokuCompYoshiki152Data();
        // TODO  内部QA：1757 Redmine：#102256(保険者番号,保険者名の取得方式が知らない)
        reportData.set年報月報区分(年報月報区分);
        reportData.set処理日時(processParameter.get処理日時());
        reportData.set給付区分(processParameter.get給付集計区分());
        reportData.set集計期間FROM(null);
        reportData.set集計期間TO(null);
        reportData.set集計年月(processParameter.get集計年月());
        reportData.set予防給付_居宅介護_要支援1_1(getValue(syukeiNo1200, 数値_101));
        reportData.set予防給付_居宅介護_要支援1_2(getValue(syukeiNo1200, 数値_201));
        reportData.set予防給付_居宅介護_要支援1_3(getValue(syukeiNo1200, 数値_301));
        reportData.set予防給付_居宅介護_要支援2_1(getValue(syukeiNo1200, 数値_102));
        reportData.set予防給付_居宅介護_要支援2_2(getValue(syukeiNo1200, 数値_202));
        reportData.set予防給付_居宅介護_要支援2_3(getValue(syukeiNo1200, 数値_302));
        reportData.set予防給付_居宅介護_要支援合計_1(getValue(syukeiNo1200, 数値_103));
        reportData.set予防給付_居宅介護_要支援合計_2(getValue(syukeiNo1200, 数値_203));
        reportData.set予防給付_居宅介護_要支援合計_3(getValue(syukeiNo1200, 数値_303));
        reportData.set介護給付_居宅介護_経過的要介護_1(getValue(syukeiNo1200, 数値_104));
        reportData.set介護給付_居宅介護_経過的要介護_2(getValue(syukeiNo1200, 数値_204));
        reportData.set介護給付_居宅介護_経過的要介護_3(getValue(syukeiNo1200, 数値_304));
        reportData.set介護給付_居宅介護_要介護1_1(getValue(syukeiNo1200, 数値_105));
        reportData.set介護給付_居宅介護_要介護1_2(getValue(syukeiNo1200, 数値_205));
        reportData.set介護給付_居宅介護_要介護1_3(getValue(syukeiNo1200, 数値_305));
        reportData.set介護給付_居宅介護_要介護2_1(getValue(syukeiNo1200, 数値_106));
        reportData.set介護給付_居宅介護_要介護2_2(getValue(syukeiNo1200, 数値_206));
        reportData.set介護給付_居宅介護_要介護2_3(getValue(syukeiNo1200, 数値_306));
        reportData.set介護給付_居宅介護_要介護3_1(getValue(syukeiNo1200, 数値_107));
        reportData.set介護給付_居宅介護_要介護3_2(getValue(syukeiNo1200, 数値_207));
        reportData.set介護給付_居宅介護_要介護3_3(getValue(syukeiNo1200, 数値_307));
        reportData.set介護給付_居宅介護_要介護4_1(getValue(syukeiNo1200, 数値_108));
        reportData.set介護給付_居宅介護_要介護4_2(getValue(syukeiNo1200, 数値_208));
        reportData.set介護給付_居宅介護_要介護4_3(getValue(syukeiNo1200, 数値_308));
        reportData.set介護給付_居宅介護_要介護5_1(getValue(syukeiNo1200, 数値_109));
        reportData.set介護給付_居宅介護_要介護5_2(getValue(syukeiNo1200, 数値_209));
        reportData.set介護給付_居宅介護_要介護5_3(getValue(syukeiNo1200, 数値_309));
        reportData.set介護給付_居宅介護_要介護合計_1(getValue(syukeiNo1200, 数値_110));
        reportData.set介護給付_居宅介護_要介護合計_2(getValue(syukeiNo1200, 数値_210));
        reportData.set介護給付_居宅介護_要介護合計_3(getValue(syukeiNo1200, 数値_310));
        reportData.set居宅介護_サービス受給者数合計_1(getValue(syukeiNo1200, 数値_111));
        reportData.set居宅介護_サービス受給者数合計_2(getValue(syukeiNo1200, 数値_211));
        reportData.set居宅介護_サービス受給者数合計_3(getValue(syukeiNo1200, 数値_311));
        reportData.set予防給付_地域密着型_要支援1_1(getValue(syukeiNo1400, 数値_101));
        reportData.set予防給付_地域密着型_要支援1_2(getValue(syukeiNo1400, 数値_201));
        reportData.set予防給付_地域密着型_要支援1_3(getValue(syukeiNo1400, 数値_301));
        reportData.set予防給付_地域密着型_要支援2_1(getValue(syukeiNo1400, 数値_102));
        reportData.set予防給付_地域密着型_要支援2_2(getValue(syukeiNo1400, 数値_202));
        reportData.set予防給付_地域密着型_要支援2_3(getValue(syukeiNo1400, 数値_302));
        reportData.set予防給付_地域密着型_要支援合計_1(getValue(syukeiNo1400, 数値_103));
        reportData.set予防給付_地域密着型_要支援合計_2(getValue(syukeiNo1400, 数値_203));
        reportData.set予防給付_地域密着型_要支援合計_3(getValue(syukeiNo1400, 数値_303));
        reportData.set介護給付_地域密着型_経過的要介護_1(getValue(syukeiNo1400, 数値_104));
        reportData.set介護給付_地域密着型_経過的要介護_2(getValue(syukeiNo1400, 数値_204));
        reportData.set介護給付_地域密着型_経過的要介護_3(getValue(syukeiNo1400, 数値_304));
        reportData.set介護給付_地域密着型_要介護1_1(getValue(syukeiNo1400, 数値_105));
        reportData.set介護給付_地域密着型_要介護1_2(getValue(syukeiNo1400, 数値_205));
        reportData.set介護給付_地域密着型_要介護1_3(getValue(syukeiNo1400, 数値_305));
        reportData.set介護給付_地域密着型_要介護2_1(getValue(syukeiNo1400, 数値_106));
        reportData.set介護給付_地域密着型_要介護2_2(getValue(syukeiNo1400, 数値_206));
        reportData.set介護給付_地域密着型_要介護2_3(getValue(syukeiNo1400, 数値_306));
        reportData.set介護給付_地域密着型_要介護3_1(getValue(syukeiNo1400, 数値_107));
        reportData.set介護給付_地域密着型_要介護3_2(getValue(syukeiNo1400, 数値_207));
        reportData.set介護給付_地域密着型_要介護3_3(getValue(syukeiNo1400, 数値_307));
        reportData.set介護給付_地域密着型_要介護4_1(getValue(syukeiNo1400, 数値_108));
        reportData.set介護給付_地域密着型_要介護4_2(getValue(syukeiNo1400, 数値_208));
        reportData.set介護給付_地域密着型_要介護4_3(getValue(syukeiNo1400, 数値_308));
        reportData.set介護給付_地域密着型_要介護5_1(getValue(syukeiNo1400, 数値_109));
        reportData.set介護給付_地域密着型_要介護5_2(getValue(syukeiNo1400, 数値_209));
        reportData.set介護給付_地域密着型_要介護5_3(getValue(syukeiNo1400, 数値_309));
        reportData.set介護給付_地域密着型_その他_1(getValue(syukeiNo1400, 数値_110));
        reportData.set介護給付_地域密着型_その他_2(getValue(syukeiNo1400, 数値_210));
        reportData.set介護給付_地域密着型_その他_3(getValue(syukeiNo1400, 数値_310));
        reportData.set介護給付_地域密着型_要介護合計_1(getValue(syukeiNo1400, 数値_111));
        reportData.set介護給付_地域密着型_要介護合計_2(getValue(syukeiNo1400, 数値_211));
        reportData.set介護給付_地域密着型_要介護合計_3(getValue(syukeiNo1400, 数値_311));
        reportData.set地域密着型_サービス受給者数合計_1(getValue(syukeiNo1400, 数値_112));
        reportData.set地域密着型_サービス受給者数合計_2(getValue(syukeiNo1400, 数値_212));
        reportData.set地域密着型_サービス受給者数合計_3(getValue(syukeiNo1400, 数値_312));
        JigyohokokuCompYoshiki152Report report = new JigyohokokuCompYoshiki152Report(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }
}
