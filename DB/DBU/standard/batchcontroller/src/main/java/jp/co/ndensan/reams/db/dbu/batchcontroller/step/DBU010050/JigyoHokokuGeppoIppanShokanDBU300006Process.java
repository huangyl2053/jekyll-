/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldReport;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldData;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldReportSource;
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
public class JigyoHokokuGeppoIppanShokanDBU300006Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippanshokanketteiym."
            + "IJigyoHokokuGeppoIppanShokanMapper.getJigyouHoukokuTokeiTyouhyou");
    private JigyoHokokuGeppoIppanShokanProcessParamter processParameter;
    private static final ReportId REPORT_DBU300006 = ReportIdDBU.DBU300006.getReportId();
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
    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo1200;
    private Map<Decimal, Decimal> syukeiNo1400;

    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki152OldReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki152OldReportSource> reportSourceWriter;

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
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.tocreate事業報告統計データ_12_13MybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300006.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (ShukeiNo.一般状況_12_居宅介護_介護予防_サービス受給者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1200.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_13_地域密着型_介護予防_サービス受給者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo1400.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki152OldData reportData = new JigyohokokuCompYoshiki152OldData();
        reportData.setプリント日時(processParameter.get処理日時());
        reportData.set集計区分(年報月報区分);
        reportData.set集計範囲(processParameter.get決定年月());
        reportData.set集計区分(保険者番号);
        reportData.set集計区分(保険者名);
        reportData.set給付区分(processParameter.get給付集計区分());
        reportData.set予防給付_居宅介護_要支援1_1(getValue(syukeiNo1200, 数値_101));
        reportData.set予防給付_居宅介護_要支援1_2(getValue(syukeiNo1200, 数値_201));
        reportData.set予防給付_居宅介護_要支援1_3(getValue(syukeiNo1200, 数値_301));
        reportData.set予防給付_居宅介護_要支援2_1(getValue(syukeiNo1200, 数値_102));
        reportData.set予防給付_居宅介護_要支援2_2(getValue(syukeiNo1200, 数値_202));
        reportData.set予防給付_居宅介護_要支援2_3(getValue(syukeiNo1200, 数値_302));
        reportData.set予防給付_居宅介護_予防給付の計_1(getValue(syukeiNo1200, 数値_103));
        reportData.set予防給付_居宅介護_予防給付の計_2(getValue(syukeiNo1200, 数値_203));
        reportData.set予防給付_居宅介護_予防給付の計_3(getValue(syukeiNo1200, 数値_303));
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
        reportData.set介護給付_居宅介護_介護給付の計_1(getValue(syukeiNo1200, 数値_110));
        reportData.set介護給付_居宅介護_介護給付の計_2(getValue(syukeiNo1200, 数値_210));
        reportData.set介護給付_居宅介護_介護給付の計_3(getValue(syukeiNo1200, 数値_310));
        reportData.set介護給付_居宅介護_合計_1(getValue(syukeiNo1200, 数値_111));
        reportData.set介護給付_居宅介護_合計_2(getValue(syukeiNo1200, 数値_211));
        reportData.set介護給付_居宅介護_合計_3(getValue(syukeiNo1200, 数値_311));
        reportData.set予防給付_地域密着型_要支援1_1(getValue(syukeiNo1400, 数値_101));
        reportData.set予防給付_地域密着型_要支援1_2(getValue(syukeiNo1400, 数値_201));
        reportData.set予防給付_地域密着型_要支援1_3(getValue(syukeiNo1400, 数値_301));
        reportData.set予防給付_地域密着型_要支援2_1(getValue(syukeiNo1400, 数値_102));
        reportData.set予防給付_地域密着型_要支援2_2(getValue(syukeiNo1400, 数値_202));
        reportData.set予防給付_地域密着型_要支援2_3(getValue(syukeiNo1400, 数値_302));
        reportData.set予防給付_地域密着型_予防給付の計_1(getValue(syukeiNo1400, 数値_103));
        reportData.set予防給付_地域密着型_予防給付の計_2(getValue(syukeiNo1400, 数値_203));
        reportData.set予防給付_地域密着型_予防給付の計_3(getValue(syukeiNo1400, 数値_303));
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
        reportData.set介護給付_地域密着型_介護給付の計_1(getValue(syukeiNo1400, 数値_111));
        reportData.set介護給付_地域密着型_介護給付の計_2(getValue(syukeiNo1400, 数値_211));
        reportData.set介護給付_地域密着型_介護給付の計_3(getValue(syukeiNo1400, 数値_311));
        reportData.set介護給付_地域密着型_合計_1(getValue(syukeiNo1400, 数値_112));
        reportData.set介護給付_地域密着型_合計_2(getValue(syukeiNo1400, 数値_212));
        reportData.set介護給付_地域密着型_合計_3(getValue(syukeiNo1400, 数値_312));
        JigyohokokuCompYoshiki152OldReport report = new JigyohokokuCompYoshiki152OldReport(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }
}
