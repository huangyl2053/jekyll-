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
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportProcessParameter;
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
 * 介護事業状況報告月報・一般状況（様式1）のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class JigyouHoukokuTokeiReportDBU300001Process extends BatchProcessBase<JigyoHokokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getJigyouHoukokuTokeiTyouhyou");
    private static final RString 集計区分_月報 = new RString("月報");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 過去集計分旧市町村区分 = new RString("1");
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

    private Map<Decimal, Decimal> syukeiNo0200;
    private Map<Decimal, Decimal> syukeiNo0301;
    private Map<Decimal, Decimal> syukeiNo0302;

    private JigyoHokokuGeppoIppanReportProcessParameter processParameter;
    private JigyoHokokuGeppoIppanReportMybatisParameter mybatisParameter;

    @BatchWriter
    private BatchReportWriter<JigyohokokuGeppoYoshiki1ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuGeppoYoshiki1ReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        syukeiNo0200 = new HashMap<>();
        syukeiNo0301 = new HashMap<>();
        syukeiNo0302 = new HashMap<>();
        setMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU300001.getReportId().value()).create();
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
        reportData.set集計区分(集計区分_月報);
        reportData.set作成日時(getNowDate(processParameter.get処理日時().getRDateTime()));
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        reportData.set保険者名(get保険者名(association.get市町村名()));
        reportData.set保険者番号(association.get地方公共団体コード().value());
        reportData.set集計範囲(processParameter.get集計年月().toDateString());
        reportData.set第1号被保険者数_項目標題列1(new RString("前月末現在"));
        reportData.set第1号被保険者数_項目標題列2(new RString("当月中増"));
        reportData.set第1号被保険者数_項目標題列3(new RString("当月中減"));
        reportData.set第1号被保険者数_項目標題列4(new RString("当月末現在"));
        reportData.set第1号被保険者増減内訳_項目標題行1(new RString("当月中増"));
        reportData.set第1号被保険者増減内訳_項目標題行2(new RString("当月中減"));

        reportData.set前月末現在_1(getValue(syukeiNo0200, 数値_11));
        reportData.set前月末現在_2(getValue(syukeiNo0200, 数値_21));
        reportData.set前月末現在_3(getValue(syukeiNo0200, 数値_31));
        reportData.set前月末現在_4(getValue(syukeiNo0200, 数値_41));
        reportData.set前月末現在_5(getValue(syukeiNo0200, 数値_51));
        reportData.set当月中増_計_1(getValue(syukeiNo0200, 数値_12));
        reportData.set当月中増_計_2(getValue(syukeiNo0200, 数値_22));
        reportData.set当月中増_計_3(getValue(syukeiNo0200, 数値_32));
        reportData.set当月中増_計_4(getValue(syukeiNo0200, 数値_42));
        reportData.set当月中増_計_5(getValue(syukeiNo0200, 数値_52));
        reportData.set当月中減_計_1(getValue(syukeiNo0200, 数値_13));
        reportData.set当月中減_計_2(getValue(syukeiNo0200, 数値_23));
        reportData.set当月中減_計_3(getValue(syukeiNo0200, 数値_33));
        reportData.set当月中減_計_4(getValue(syukeiNo0200, 数値_43));
        reportData.set当月中減_計_5(getValue(syukeiNo0200, 数値_53));
        reportData.set当月末現在_1(getValue(syukeiNo0200, 数値_14));
        reportData.set当月末現在_2(getValue(syukeiNo0200, 数値_24));
        reportData.set当月末現在_3(getValue(syukeiNo0200, 数値_34));
        reportData.set当月末現在_4(getValue(syukeiNo0200, 数値_44));
        reportData.set当月末現在_5(getValue(syukeiNo0200, 数値_54));

        reportData.set転入転出_1(getValue(syukeiNo0301, 数値_11));
        reportData.set職権復活職権喪失_1(getValue(syukeiNo0301, 数値_12));
        reportData.set歳到達65死亡_1(getValue(syukeiNo0301, 数値_13));
        reportData.set適用除外非該当適用除外該当_1(getValue(syukeiNo0301, 数値_14));
        reportData.setその他_1(getValue(syukeiNo0301, 数値_15));
        reportData.set計_1(getValue(syukeiNo0301, 数値_16));
        reportData.set自特例適用自特例解除_1(getValue(syukeiNo0301, 数値_21));
        reportData.set自特例転入_1(getValue(syukeiNo0301, 数値_22));
        reportData.set他特例居住他特例適用_1(getValue(syukeiNo0301, 数値_23));
        reportData.set外国人申請国籍喪失_1(getValue(syukeiNo0301, 数値_24));
        reportData.set帰化_1(getValue(syukeiNo0301, 数値_25));
        reportData.set左記以外_1(getValue(syukeiNo0301, 数値_26));

        reportData.set転入転出_2(getValue(syukeiNo0302, 数値_11));
        reportData.set職権復活職権喪失_2(getValue(syukeiNo0302, 数値_12));
        reportData.set歳到達65死亡_2(getValue(syukeiNo0302, 数値_13));
        reportData.set適用除外非該当適用除外該当_2(getValue(syukeiNo0302, 数値_14));
        reportData.setその他_2(getValue(syukeiNo0302, 数値_15));
        reportData.set計_2(getValue(syukeiNo0302, 数値_16));
        reportData.set自特例適用自特例解除_2(getValue(syukeiNo0302, 数値_21));
        reportData.set自特例転入_2(getValue(syukeiNo0302, 数値_22));
        reportData.set他特例居住他特例適用_2(getValue(syukeiNo0302, 数値_23));
        reportData.set外国人申請国籍喪失_2(getValue(syukeiNo0302, 数値_24));
        reportData.set帰化_2(getValue(syukeiNo0302, 数値_25));
        reportData.set左記以外_2(getValue(syukeiNo0302, 数値_26));
        JigyohokokuGeppoYoshiki1Report report = new JigyohokokuGeppoYoshiki1Report(reportData);
        report.writeBy(reportSourceWriter);

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
        shukeinoList.add(ShukeiNo.一般状況_1_第1号被保険者数.getコード());
        shukeinoList.add(ShukeiNo.一般状況_2_第1号被保険者増減内訳_当月中増.getコード());
        shukeinoList.add(ShukeiNo.一般状況_2_第2号被保険者増減内訳_当月中減.getコード());
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
