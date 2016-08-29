/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030;

import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyojokyohokokushiryonemposakuseiiti.JigyoJokyoHokokuShiryoNempoSakuseiItiProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1Data;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1ReportSource;
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
 * 介護事業状況報告月報・一般状況（様式1）帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-030 dingyi
 *
 */
public class JigyoHokokuDataReportDBU300001Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoJokyoHokokuShiryoNempoSakuseiItiMapper.getJigyouHokokuTokeiReportJyoho");
    private JigyoJokyoHokokuShiryoNempoSakuseiItiProcessParamter processParameter;

    private static final ReportId REPORT_DBU300001 = ReportIdDBU.DBU300001.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final RString 年報月報区分 = new RString("年報");
    private static final int 数値_10 = 10;
    private static final Decimal 数値_11 = new Decimal(11);
    private static final Decimal 数値_21 = new Decimal(21);
    private static final Decimal 数値_31 = new Decimal(31);
    private static final Decimal 数値_41 = new Decimal(41);
    private static final Decimal 数値_51 = new Decimal(51);
    private static final Decimal 数値_12 = new Decimal(12);
    private static final Decimal 数値_22 = new Decimal(22);
    private static final Decimal 数値_32 = new Decimal(32);
    private static final Decimal 数値_42 = new Decimal(42);
    private static final Decimal 数値_52 = new Decimal(52);
    private static final Decimal 数値_13 = new Decimal(13);
    private static final Decimal 数値_23 = new Decimal(23);
    private static final Decimal 数値_33 = new Decimal(33);
    private static final Decimal 数値_43 = new Decimal(43);
    private static final Decimal 数値_53 = new Decimal(53);
    private static final Decimal 数値_14 = new Decimal(14);
    private static final Decimal 数値_24 = new Decimal(24);
    private static final Decimal 数値_34 = new Decimal(34);
    private static final Decimal 数値_44 = new Decimal(44);
    private static final Decimal 数値_54 = new Decimal(54);
    private static final Decimal 数値_15 = new Decimal(15);
    private static final Decimal 数値_16 = new Decimal(16);
    private static final Decimal 数値_25 = new Decimal(25);
    private static final Decimal 数値_26 = new Decimal(26);

    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo0200;
    private Map<Decimal, Decimal> syukeiNo0301;
    private Map<Decimal, Decimal> syukeiNo0302;

    @BatchWriter
    private BatchReportWriter<JigyohokokuGeppoYoshiki1ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuGeppoYoshiki1ReportSource> reportSourceWriter;

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
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300001.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (ShukeiNo.一般状況_1_第1号被保険者数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0200.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_2_第1号被保険者増減内訳_当月中増.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0301.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        } else if (ShukeiNo.一般状況_2_第2号被保険者増減内訳_当月中減.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0302.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuGeppoYoshiki1Data reportData = new JigyohokokuGeppoYoshiki1Data();
        reportData.set集計区分(年報月報区分);
        reportData.set作成日時(processParameter.get処理日時());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        // TODO
        reportData.set集計範囲(processParameter.get集計開始年月());
        reportData.set第1号被保険者数_項目標題列1(new RString("前年度末現在"));
        reportData.set第1号被保険者数_項目標題列2(new RString("当年度中増"));
        reportData.set第1号被保険者数_項目標題列3(new RString("当年度中減"));
        reportData.set第1号被保険者数_項目標題列4(new RString("当年度末現在"));
        reportData.set第1号被保険者増減内訳_項目標題行1(new RString("当年度中増"));
        reportData.set第1号被保険者増減内訳_項目標題行2(new RString("当年度中減"));

        reportData.set前月末現在_1(new RString(syukeiNo0200.get(数値_11).longValue()));
        reportData.set前月末現在_2(new RString(syukeiNo0200.get(数値_21).longValue()));
        reportData.set前月末現在_3(new RString(syukeiNo0200.get(数値_31).longValue()));
        reportData.set前月末現在_4(new RString(syukeiNo0200.get(数値_41).longValue()));
        reportData.set前月末現在_5(new RString(syukeiNo0200.get(数値_51).longValue()));
        reportData.set当月中増_計_1(new RString(syukeiNo0200.get(数値_12).longValue()));
        reportData.set当月中増_計_2(new RString(syukeiNo0200.get(数値_22).longValue()));
        reportData.set当月中増_計_3(new RString(syukeiNo0200.get(数値_32).longValue()));
        reportData.set当月中増_計_4(new RString(syukeiNo0200.get(数値_42).longValue()));
        reportData.set当月中増_計_5(new RString(syukeiNo0200.get(数値_52).longValue()));
        reportData.set当月中減_計_1(new RString(syukeiNo0200.get(数値_13).longValue()));
        reportData.set当月中減_計_2(new RString(syukeiNo0200.get(数値_23).longValue()));
        reportData.set当月中減_計_3(new RString(syukeiNo0200.get(数値_33).longValue()));
        reportData.set当月中減_計_4(new RString(syukeiNo0200.get(数値_43).longValue()));
        reportData.set当月中減_計_5(new RString(syukeiNo0200.get(数値_53).longValue()));
        reportData.set当月末現在_1(new RString(syukeiNo0200.get(数値_14).longValue()));
        reportData.set当月末現在_2(new RString(syukeiNo0200.get(数値_24).longValue()));
        reportData.set当月末現在_3(new RString(syukeiNo0200.get(数値_34).longValue()));
        reportData.set当月末現在_4(new RString(syukeiNo0200.get(数値_44).longValue()));
        reportData.set当月末現在_5(new RString(syukeiNo0200.get(数値_54).longValue()));

        reportData.set転入転出_1(new RString(syukeiNo0301.get(数値_11).longValue()));
        reportData.set職権復活職権喪失_1(new RString(syukeiNo0301.get(数値_12).longValue()));
        reportData.set歳到達65死亡_1(new RString(syukeiNo0301.get(数値_13).longValue()));
        reportData.set適用除外非該当適用除外該当_1(new RString(syukeiNo0301.get(数値_14).longValue()));
        reportData.setその他_1(new RString(syukeiNo0301.get(数値_15).longValue()));
        reportData.set計_1(new RString(syukeiNo0301.get(数値_16).longValue()));
        reportData.set自特例適用自特例解除_1(new RString(syukeiNo0301.get(数値_21).longValue()));
        reportData.set自特例転入_1(new RString(syukeiNo0301.get(数値_22).longValue()));
        reportData.set他特例居住他特例適用_1(new RString(syukeiNo0301.get(数値_23).longValue()));
        reportData.set外国人申請国籍喪失_1(new RString(syukeiNo0301.get(数値_24).longValue()));
        reportData.set帰化_1(new RString(syukeiNo0301.get(数値_25).longValue()));
        reportData.set左記以外_1(new RString(syukeiNo0301.get(数値_26).longValue()));

        reportData.set転入転出_2(new RString(syukeiNo0302.get(数値_11).longValue()));
        reportData.set職権復活職権喪失_2(new RString(syukeiNo0302.get(数値_12).longValue()));
        reportData.set歳到達65死亡_2(new RString(syukeiNo0302.get(数値_13).longValue()));
        reportData.set適用除外非該当適用除外該当_2(new RString(syukeiNo0302.get(数値_14).longValue()));
        reportData.setその他_2(new RString(syukeiNo0302.get(数値_15).longValue()));
        reportData.set計_2(new RString(syukeiNo0302.get(数値_16).longValue()));
        reportData.set自特例適用自特例解除_2(new RString(syukeiNo0302.get(数値_21).longValue()));
        reportData.set自特例転入_2(new RString(syukeiNo0302.get(数値_22).longValue()));
        reportData.set他特例居住他特例適用_2(new RString(syukeiNo0302.get(数値_23).longValue()));
        reportData.set外国人申請国籍喪失_2(new RString(syukeiNo0302.get(数値_24).longValue()));
        reportData.set帰化_2(new RString(syukeiNo0302.get(数値_25).longValue()));
        reportData.set左記以外_2(new RString(syukeiNo0302.get(数値_26).longValue()));
        JigyohokokuGeppoYoshiki1Report report = new JigyohokokuGeppoYoshiki1Report(reportData);
        report.writeBy(reportSourceWriter);
    }
}
