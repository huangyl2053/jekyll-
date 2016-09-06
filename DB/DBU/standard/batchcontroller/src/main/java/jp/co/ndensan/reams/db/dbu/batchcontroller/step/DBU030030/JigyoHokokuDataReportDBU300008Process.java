/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiReport;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyojokyohokokushiryonemposakuseiiti.JigyoJokyoHokokuShiryoNempoSakuseiItiProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiData;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（別紙）帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5600-030 dingyi
 *
 */
public class JigyoHokokuDataReportDBU300008Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoJokyoHokokuShiryoNempoSakuseiItiMapper.getJigyouHokokuTokeiReportJyoho");
    private JigyoJokyoHokokuShiryoNempoSakuseiItiProcessParameter processParameter;

    private static final ReportId REPORT_DBU300008 = ReportIdDBU.DBU300008.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final RString 年報月報区分 = new RString("年報");
    private static final int 数値_10 = 10;
    private static final Decimal 数値_11 = new Decimal(11);
    private static final Decimal 数値_12 = new Decimal(12);
    private static final Decimal 数値_13 = new Decimal(13);
    private static final Decimal 数値_14 = new Decimal(14);
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");

    private RString 保険者番号;
    private RString 保険者名;
    private Map<Decimal, Decimal> syukeiNo0100;

    @BatchWriter
    private BatchReportWriter<JigyohokokuGeppoYoshikiBesshiReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuGeppoYoshikiBesshiReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        syukeiNo0100 = new HashMap<>();
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
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300008.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード().equals(entity.getSyukeiNo().value())) {
            syukeiNo0100.put(entity.getTateNo().multiply(数値_10).add(entity.getYokoNo()), entity.getSukeiKekkaAtai());
        }
    }

    @Override
    protected void afterExecute() {
        JigyohokokuGeppoYoshikiBesshiData reportData = new JigyohokokuGeppoYoshikiBesshiData();
        reportData.set集計区分(年報月報区分);
        reportData.set作成日時(get作成日時());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.set集計範囲(getパターン107(processParameter.get集計年度()));
        reportData.set項目標題列1(new RString("前年度末現在"));
        reportData.set項目標題列2(new RString("当年度中増"));
        reportData.set項目標題列3(new RString("当年度中減"));
        reportData.set項目標題列4(new RString("当年度末現在"));
        reportData.set前月末現在の集計結果値_1(getValue(syukeiNo0100, 数値_11));
        reportData.set当月中増の集計結果値_1(getValue(syukeiNo0100, 数値_12));
        reportData.set当月中減の集計結果値_1(getValue(syukeiNo0100, 数値_13));
        reportData.set当月末現在の集計結果値_1(getValue(syukeiNo0100, 数値_14));
        JigyohokokuGeppoYoshikiBesshiReport report = new JigyohokokuGeppoYoshikiBesshiReport(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString getValue(Map<Decimal, Decimal> map, Decimal key) {
        if (map != null && map.get(key) != null) {
            return new RString(map.get(key).longValue());
        }
        return RString.EMPTY;
    }

    private RString get作成日時() {
        RStringBuilder printTimeStamp = new RStringBuilder();
        RDateTime printdate = processParameter.get処理日時();
        printTimeStamp.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", printdate.getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", printdate.getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", printdate.getSecond()));
        printTimeStamp.append(DATE_秒);
        printTimeStamp.append(作成);
        return printTimeStamp.toRString();
    }

    private RString getパターン107(RString 集計年度) {
        if (RString.isNullOrEmpty(集計年度)) {
            return RString.EMPTY;
        }
        return new FlexibleYear(集計年度).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).toDateString();
    }
}
