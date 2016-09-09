/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiReport;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportProcessParameter;
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
 * 介護事業状況報告月報・一般状況（別紙）のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class JigyouHoukokuTokeiReportDBU300008Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getJigyouHoukokuTokeiTyouhyou");
    private static final RString 項目標題列1 = new RString("前月末現在");
    private static final RString 項目標題列2 = new RString("当月中増");
    private static final RString 項目標題列3 = new RString("当月中減");
    private static final RString 項目標題列4 = new RString("当月末現在");
    private static final RString 集計区分_月報 = new RString("月報");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 過去集計分旧市町村区分 = new RString(1);
    private static final Decimal 列目2 = new Decimal(2);
    private static final Decimal 列目3 = new Decimal(3);
    private static final Decimal 列目4 = new Decimal(4);
    private JigyohokokuGeppoYoshikiBesshiData besshiData;

    private JigyoHokokuGeppoIppanReportProcessParameter processParameter;
    private JigyoHokokuGeppoIppanReportMybatisParameter mybatisParameter;

    @BatchWriter
    private BatchReportWriter<JigyohokokuGeppoYoshikiBesshiReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuGeppoYoshikiBesshiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisParameter = processParameter.toJigyoHokokuGeppoIppanReportMybatisParameter();
        mybatisParameter.setHyonoList(getHyonoList());
        mybatisParameter.setShukeinoList(getShukeinoList());
        besshiData = new JigyohokokuGeppoYoshikiBesshiData();
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

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU300008.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuDataRelateEntity entity) {
        if (Decimal.ONE.equals(entity.getTateNo())) {
            if (Decimal.ONE.equals(entity.getYokoNo())) {
                besshiData.set前月末現在の集計結果値_1(new RString(entity.getSukeiKekkaAtai().longValue()));
            } else if (列目2.equals(entity.getYokoNo())) {
                besshiData.set当月中増の集計結果値_1(new RString(entity.getSukeiKekkaAtai().longValue()));
            } else if (列目3.equals(entity.getYokoNo())) {
                besshiData.set当月中減の集計結果値_1(new RString(entity.getSukeiKekkaAtai().longValue()));
            } else if (列目4.equals(entity.getYokoNo())) {
                besshiData.set当月末現在の集計結果値_1(new RString(entity.getSukeiKekkaAtai().longValue()));
            }
        }
    }

    @Override
    protected void afterExecute() {
        besshiData.set集計区分(集計区分_月報);
        besshiData.set作成日時(getNowDate(processParameter.get処理日時().getRDateTime()));
        besshiData.set集計範囲(processParameter.get集計年月().toDateString());
        besshiData.set項目標題列1(項目標題列1);
        besshiData.set項目標題列2(項目標題列2);
        besshiData.set項目標題列3(項目標題列3);
        besshiData.set項目標題列4(項目標題列4);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        besshiData.set保険者番号(association.get地方公共団体コード().value());
        besshiData.set保険者名(get保険者名(association.get市町村名()));
        JigyohokokuGeppoYoshikiBesshiReport report = new JigyohokokuGeppoYoshikiBesshiReport(besshiData);
        report.writeBy(reportSourceWriter);

    }

    private List<RString> getShukeinoList() {
        List<RString> shukeinoList = new ArrayList<>();
        shukeinoList.add(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード());
        return shukeinoList;
    }

    private List<RString> getHyonoList() {
        List<RString> hyonoList = new ArrayList<>();
        hyonoList.add(HyoNo.現物_一般状況.getコード());
        hyonoList.add(HyoNo.現物_一般状況_旧市町村.getコード());
        return hyonoList;
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

    private RString get保険者名(RString 市町村名) {
        if (過去集計分旧市町村区分.equals(processParameter.get過去集計分旧市町村区分())) {
            return new RString("（旧）").concat(市町村名);
        }
        return 市町村名;
    }

}
