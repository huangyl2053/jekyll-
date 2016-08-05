package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo.ShinsaHanteiJokyoItem;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.SinsakaiHanteiJyokyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.SinsakaiHanteiJyokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会判定状況の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class SinsakaiHanteiJyokyoProcess extends BatchProcessBase<SinsakaiHanteiJyokyoHeaderEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getSinsakaiHanteiJyokyoHeader");
    private static final RString 帳票タイトル = new RString("介護認定審査会判定状況表");
    private static final RString JIGYOJYOKYOHOKOKU = new RString("【事業状況報告出力区分】");
    private static final RString JISSIJYOKYOTOKEI = new RString("【実施状況統計出力区分】");
    private static final RString SINSAHANTEIJYOKYO = new RString("【審査判定状況出力区分】");
    private static final RString SINSAKAIKANRENTOKEI = new RString("【審査会関連統計資料作成出力区分】");
    private static final RString CSVSHUTSURYOKU = new RString("【CSV出力区分】");
    private static final RString SHUTSURYOKUFAIRU = new RString("【出力ファイル名】");
    private static final RString HOKENSYANO = new RString("【保険者番号】");
    private static final RString HIHOKENSYAKUBUN = new RString("【被保険者区分】");
    private static final RString GOGITAINO = new RString("【合議体番号】");
    private static final RString TAISHOTSUKIKUBUN = new RString("【対象月編集区分】");
    private static final RString TAISHOYM = new RString("【対象年月】");
    private static final RString KIJYUNYMD = new RString("【基準年月日】");
    private static final RString TAISHOGEPPIKUBUN = new RString("【対象月日編集区分】");
    private static final RString TAISHOGEPPIFROM = new RString("【対象月日開始】");
    private static final RString TAISHOGEPPITO = new RString("【対象月日終了】");
    private static final RString SINSEIKUBUNSINSEITOKI = new RString("【申請区分(申請時)】");
    private static final RString SINSEIKUBUNHOREI = new RString("【申請区分(法令)】");
    private static final DecimalFormat FORMAT = new DecimalFormat("0.0");
    private static final RString コード_非該当 = new RString("01");
    private static final RString コード_要支援1 = new RString("12");
    private static final RString コード_要支援2 = new RString("13");
    private static final RString コード_要介護1 = new RString("21");
    private static final RString コード_要介護2 = new RString("22");
    private static final RString コード_要介護3 = new RString("23");
    private static final RString コード_要介護4 = new RString("24");
    private static final RString コード_要介護5 = new RString("25");
    private static final RString コード_再調査 = new RString("31");
    private static final RString 非該当 = new RString("非該当");
    private static final RString 要支援1 = new RString("要支援1");
    private static final RString 要支援2 = new RString("要支援2");
    private static final RString 要介護1 = new RString("要介護1");
    private static final RString 要介護2 = new RString("要介護2");
    private static final RString 要介護3 = new RString("要介護3");
    private static final RString 要介護4 = new RString("要介護4");
    private static final RString 要介護5 = new RString("要介護5");
    private static final RString 変更者 = new RString("変更者");
    private static final RString 計 = new RString("計");
    private static final RString 割合なし = new RString("0.0%");
    private static final int 割合 = 100;
    private static final RString パーセント = new RString("%");
    private static final RString 全合議体 = new RString("全て合議体");
    private static final RString 全市町村コード = new RString("000000");
    private static final RString 全市町村 = new RString("全市町村");
    List<ShinsaHanteiJokyoItem> itemList;
    private SinsakaiHanteiJyokyoProcessParameter paramter;
    private IHokokuShiryoSakuSeiMapper mapper;

    @BatchWriter
    private BatchReportWriter<ShinsaHanteiJokyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsaHanteiJokyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        itemList = new ArrayList<>();
        mapper = getMapper(IHokokuShiryoSakuSeiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HEADER, paramter.toSinsakaiHanteiJyokyoMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701001.getReportId().value())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(SinsakaiHanteiJyokyoHeaderEntity current) {
        if (0 != current.getShinsakaiKaisaiNoCount()) {
            List<SinsakaiHanteiJyokyoEntity> 審査判定状況 = get審査判定状況(current);
            ShinsaHanteiJokyoItem 一次判定非該当 = get一次判定非該当(審査判定状況, current);
            ShinsaHanteiJokyoItem 一次判定要支援1 = get一次判定要支援1(審査判定状況, current);
            ShinsaHanteiJokyoItem 一次判定要支援2 = get一次判定要支援2(審査判定状況, current);
            ShinsaHanteiJokyoItem 一次判定要介護1 = get一次判定要介護1(審査判定状況, current);
            ShinsaHanteiJokyoItem 一次判定要介護2 = get一次判定要介護2(審査判定状況, current);
            ShinsaHanteiJokyoItem 一次判定要介護3 = get一次判定要介護3(審査判定状況, current);
            ShinsaHanteiJokyoItem 一次判定要介護4 = get一次判定要介護4(審査判定状況, current);
            ShinsaHanteiJokyoItem 一次判定要介護5 = get一次判定要介護5(審査判定状況, current);
            ShinsaHanteiJokyoItem 合計 = get計(current, 一次判定非該当, 一次判定要支援1, 一次判定要支援2, 一次判定要介護1,
                    一次判定要介護2, 一次判定要介護3, 一次判定要介護4, 一次判定要介護5);
            ShinsaHanteiJokyoItem 変更者Item = get変更者(current, 一次判定非該当, 一次判定要支援1, 一次判定要支援2, 一次判定要介護1,
                    一次判定要介護2, 一次判定要介護3, 一次判定要介護4, 一次判定要介護5);
            ShinsaHanteiJokyoItem 割合計 = get割合(current, 合計);
            itemList.add(get判定件数(一次判定非該当, 合計));
            itemList.add(一次判定要支援1);
            itemList.add(一次判定要支援2);
            itemList.add(一次判定要介護1);
            itemList.add(一次判定要介護2);
            itemList.add(一次判定要介護3);
            itemList.add(一次判定要介護4);
            itemList.add(一次判定要介護5);
            itemList.add(合計);
            itemList.add(変更者Item);
            itemList.add(割合計);
        }
    }

    @Override
    protected void afterExecute() {
        //ShinsaHanteiJokyoReport report = ShinsaHanteiJokyoReport.createFrom(itemList);
        //report.writeBy(reportSourceWriter);
        outputJokenhyo();
    }

    private List<SinsakaiHanteiJyokyoEntity> get審査判定状況(SinsakaiHanteiJyokyoHeaderEntity current) {
        SinsakaiHanteiJyokyoMyBatisParameter batisParameter = paramter.toSinsakaiHanteiJyokyoMyBatisParameter();
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        return mapper.getSinsakaiHanteiJyokyo(batisParameter);
    }

    private void outputJokenhyo() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE701001.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                帳票タイトル,
                new RString(reportSourceWriter.pageCount().value()),
                new RString("無し"),
                new RString("ー"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(JIGYOJYOKYOHOKOKU);
        条件.append(paramter.isJigyoJyokyoHokoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(JISSIJYOKYOTOKEI);
        条件.append(paramter.isJissiJyokyoTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAHANTEIJYOKYO);
        条件.append(paramter.isSinsaHanteiJyokyo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAKAIKANRENTOKEI);
        条件.append(paramter.isSinsakaiKanrenTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(CSVSHUTSURYOKU);
        条件.append(paramter.isCsvShutsuryoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SHUTSURYOKUFAIRU);
        条件.append(paramter.getShutsuryokuFairuName());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HOKENSYANO);
        条件.append(paramter.getHokensyaNo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HIHOKENSYAKUBUN);
        条件.append(HihokenshaKubun.toValue(paramter.getHihokenshaKubun()).get名称());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(GOGITAINO);
        条件.append(paramter.isEmptyGogitaiNo() ? RString.EMPTY : new RString(paramter.getGogitaiNo()));
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOTSUKIKUBUN);
        条件.append(paramter.isTaishoTsukiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOYM);
        条件.append(!paramter.isTaishoTsukiKubun() ? RString.EMPTY
                : new RYearMonth(paramter.getTaishoNendoYM()).wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(KIJYUNYMD);
        条件.append(paramter.getKijyunYMD() == null ? RString.EMPTY : paramter.getKijyunYMD().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIKUBUN);
        条件.append(paramter.isTaishoGeppiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIFROM);
        条件.append(paramter.isEmptyTaishoGeppiFrom() ? RString.EMPTY
                : new RDate(paramter.getTaishoGeppiFrom().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPITO);
        条件.append(paramter.isEmptyTaishoGeppiTo() ? RString.EMPTY
                : new RDate(paramter.getTaishoGeppiTo().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNSINSEITOKI);
        条件.append(paramter.isShinseiji());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNHOREI);
        条件.append(paramter.isHorei());
        出力条件.add(条件.toRString());
        return 出力条件;
    }

    private ShinsaHanteiJokyoItem get一次判定非該当(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            SinsakaiHanteiJyokyoHeaderEntity current) {
        int 非該当非該当被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_非該当);
        int 非該当要支援1被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要支援1);
        int 非該当要支援2被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要支援2);
        int 非該当要介護1被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護1);
        int 非該当要介護2被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護2);
        int 非該当要介護3被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護3);
        int 非該当要介護4被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護4);
        int 非該当要介護5被保険者数 = get被保険者数(審査判定状況, コード_非該当, コード_要介護5);
        int 非該当計 = 非該当非該当被保険者数 + 非該当要支援1被保険者数 + 非該当要支援2被保険者数 + 非該当要介護1被保険者数
                + 非該当要介護2被保険者数 + 非該当要介護3被保険者数 + 非該当要介護4被保険者数 + 非該当要介護5被保険者数;
        ShinsaHanteiJokyoItem item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                非該当,
                toRString(非該当非該当被保険者数),
                toRString(非該当要支援1被保険者数),
                toRString(非該当要支援2被保険者数),
                toRString(非該当要介護1被保険者数),
                toRString(非該当要介護2被保険者数),
                toRString(非該当要介護3被保険者数),
                toRString(非該当要介護4被保険者数),
                toRString(非該当要介護5被保険者数),
                new RString(非該当計),
                toRString(get被保険者数(審査判定状況, コード_非該当, コード_再調査)),
                toRString(非該当計 - 非該当非該当被保険者数),
                RString.EMPTY,
                toRString(非該当計 - 非該当非該当被保険者数),
                非該当計 == 0 || 非該当計 == 非該当非該当被保険者数 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(非該当計 - 非該当非該当被保険者数).divide(非該当計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return item;
    }

    private ShinsaHanteiJokyoItem get一次判定要支援1(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            SinsakaiHanteiJyokyoHeaderEntity current) {
        int 要支援1非該当被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_非該当);
        int 要支援1要支援1被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要支援1);
        int 要支援1要支援2被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要支援2);
        int 要支援1要介護1被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護1);
        int 要支援1要介護2被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護2);
        int 要支援1要介護3被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護3);
        int 要支援1要介護4被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護4);
        int 要支援1要介護5被保険者数 = get被保険者数(審査判定状況, コード_要支援1, コード_要介護5);
        int 要支援1計 = 要支援1非該当被保険者数 + 要支援1要支援1被保険者数 + 要支援1要支援2被保険者数 + 要支援1要介護1被保険者数
                + 要支援1要介護2被保険者数 + 要支援1要介護3被保険者数 + 要支援1要介護4被保険者数 + 要支援1要介護5被保険者数;
        ShinsaHanteiJokyoItem item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                要支援1,
                toRString(要支援1非該当被保険者数),
                toRString(要支援1要支援1被保険者数),
                toRString(要支援1要支援2被保険者数),
                toRString(要支援1要介護1被保険者数),
                toRString(要支援1要介護2被保険者数),
                toRString(要支援1要介護3被保険者数),
                toRString(要支援1要介護4被保険者数),
                toRString(要支援1要介護5被保険者数),
                new RString(要支援1計),
                toRString(get被保険者数(審査判定状況, コード_要支援1, コード_再調査)),
                toRString(要支援1計 - 要支援1要支援1被保険者数),
                toRString(要支援1非該当被保険者数),
                toRString(要支援1計 - 要支援1非該当被保険者数 - 要支援1要支援1被保険者数),
                要支援1計 == 0 || 要支援1計 == 要支援1要支援1被保険者数 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(要支援1計 - 要支援1要支援1被保険者数).divide(要支援1計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return item;
    }

    private ShinsaHanteiJokyoItem get一次判定要支援2(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            SinsakaiHanteiJyokyoHeaderEntity current) {
        int 要支援2非該当被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_非該当);
        int 要支援2要支援1被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要支援1);
        int 要支援2要支援2被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要支援2);
        int 要支援2要介護1被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護1);
        int 要支援2要介護2被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護2);
        int 要支援2要介護3被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護3);
        int 要支援2要介護4被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護4);
        int 要支援2要介護5被保険者数 = get被保険者数(審査判定状況, コード_要支援2, コード_要介護5);
        int 要支援2計 = 要支援2非該当被保険者数 + 要支援2要支援1被保険者数 + 要支援2要支援2被保険者数 + 要支援2要介護1被保険者数
                + 要支援2要介護2被保険者数 + 要支援2要介護3被保険者数 + 要支援2要介護4被保険者数 + 要支援2要介護5被保険者数;
        ShinsaHanteiJokyoItem item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                要支援2,
                toRString(要支援2非該当被保険者数),
                toRString(要支援2要支援1被保険者数),
                toRString(要支援2要支援2被保険者数),
                toRString(要支援2要介護1被保険者数),
                toRString(要支援2要介護2被保険者数),
                toRString(要支援2要介護3被保険者数),
                toRString(要支援2要介護4被保険者数),
                toRString(要支援2要介護5被保険者数),
                new RString(要支援2計),
                toRString(get被保険者数(審査判定状況, コード_要支援2, コード_再調査)),
                toRString(要支援2計 - 要支援2要支援2被保険者数 - 要支援2要介護1被保険者数),
                toRString(要支援2非該当被保険者数 + 要支援2要支援1被保険者数),
                toRString(要支援2要介護2被保険者数 + 要支援2要介護3被保険者数 + 要支援2要介護4被保険者数 + 要支援2要介護5被保険者数),
                要支援2計 == 0 || 要支援2計 == 要支援2要支援2被保険者数 + 要支援2要介護1被保険者数 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(要支援2計 - 要支援2要支援2被保険者数 - 要支援2要介護1被保険者数).divide(要支援2計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return item;
    }

    private ShinsaHanteiJokyoItem get一次判定要介護1(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            SinsakaiHanteiJyokyoHeaderEntity current) {
        int 要介護1非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_非該当);
        int 要介護1要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要支援1);
        int 要介護1要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要支援2);
        int 要介護1要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護1);
        int 要介護1要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護2);
        int 要介護1要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護3);
        int 要介護1要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護4);
        int 要介護1要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護1, コード_要介護5);
        int 要介護1計 = 要介護1非該当被保険者数 + 要介護1要支援1被保険者数 + 要介護1要支援2被保険者数 + 要介護1要介護1被保険者数
                + 要介護1要介護2被保険者数 + 要介護1要介護3被保険者数 + 要介護1要介護4被保険者数 + 要介護1要介護5被保険者数;
        ShinsaHanteiJokyoItem item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                要介護1,
                toRString(要介護1非該当被保険者数),
                toRString(要介護1要支援1被保険者数),
                toRString(要介護1要支援2被保険者数),
                toRString(要介護1要介護1被保険者数),
                toRString(要介護1要介護2被保険者数),
                toRString(要介護1要介護3被保険者数),
                toRString(要介護1要介護4被保険者数),
                toRString(要介護1要介護5被保険者数),
                new RString(要介護1計),
                toRString(get被保険者数(審査判定状況, コード_要介護1, コード_再調査)),
                toRString(要介護1計 - 要介護1要介護1被保険者数 - 要介護1要支援2被保険者数),
                toRString(要介護1非該当被保険者数 + 要介護1要支援1被保険者数),
                toRString(要介護1要介護2被保険者数 + 要介護1要介護3被保険者数 + 要介護1要介護4被保険者数 + 要介護1要介護5被保険者数),
                要介護1計 == 0 || 要介護1計 == 要介護1要支援2被保険者数 + 要介護1要介護1被保険者数 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(要介護1計 - 要介護1要支援2被保険者数 - 要介護1要介護1被保険者数).divide(要介護1計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return item;
    }

    private ShinsaHanteiJokyoItem get一次判定要介護2(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            SinsakaiHanteiJyokyoHeaderEntity current) {
        int 要介護2非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_非該当);
        int 要介護2要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要支援1);
        int 要介護2要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要支援2);
        int 要介護2要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護1);
        int 要介護2要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護2);
        int 要介護2要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護3);
        int 要介護2要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護4);
        int 要介護2要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護2, コード_要介護5);
        int 要介護2計 = 要介護2非該当被保険者数 + 要介護2要支援1被保険者数 + 要介護2要支援2被保険者数 + 要介護2要介護1被保険者数
                + 要介護2要介護2被保険者数 + 要介護2要介護3被保険者数 + 要介護2要介護4被保険者数 + 要介護2要介護5被保険者数;
        ShinsaHanteiJokyoItem item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                要介護2,
                toRString(要介護2非該当被保険者数),
                toRString(要介護2要支援1被保険者数),
                toRString(要介護2要支援2被保険者数),
                toRString(要介護2要介護1被保険者数),
                toRString(要介護2要介護2被保険者数),
                toRString(要介護2要介護3被保険者数),
                toRString(要介護2要介護4被保険者数),
                toRString(要介護2要介護5被保険者数),
                new RString(要介護2計),
                toRString(get被保険者数(審査判定状況, コード_要介護2, コード_再調査)),
                toRString(要介護2計 - 要介護2要介護2被保険者数),
                toRString(要介護2非該当被保険者数 + 要介護2要支援1被保険者数 + 要介護2要支援2被保険者数 + 要介護2要介護1被保険者数),
                toRString(要介護2要介護3被保険者数 + 要介護2要介護4被保険者数 + 要介護2要介護5被保険者数),
                要介護2計 == 0 || 要介護2計 == 要介護2要介護2被保険者数 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(要介護2計 - 要介護2要介護2被保険者数).divide(要介護2計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return item;
    }

    private ShinsaHanteiJokyoItem get一次判定要介護3(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            SinsakaiHanteiJyokyoHeaderEntity current) {
        int 要介護3非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_非該当);
        int 要介護3要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要支援1);
        int 要介護3要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要支援2);
        int 要介護3要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護1);
        int 要介護3要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護2);
        int 要介護3要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護3);
        int 要介護3要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護4);
        int 要介護3要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護3, コード_要介護5);
        int 要介護3計 = 要介護3非該当被保険者数 + 要介護3要支援1被保険者数 + 要介護3要支援2被保険者数 + 要介護3要介護1被保険者数
                + 要介護3要介護2被保険者数 + 要介護3要介護3被保険者数 + 要介護3要介護4被保険者数 + 要介護3要介護5被保険者数;
        ShinsaHanteiJokyoItem item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                要介護3,
                toRString(要介護3非該当被保険者数),
                toRString(要介護3要支援1被保険者数),
                toRString(要介護3要支援2被保険者数),
                toRString(要介護3要介護1被保険者数),
                toRString(要介護3要介護2被保険者数),
                toRString(要介護3要介護3被保険者数),
                toRString(要介護3要介護4被保険者数),
                toRString(要介護3要介護5被保険者数),
                new RString(要介護3計),
                toRString(get被保険者数(審査判定状況, コード_要介護3, コード_再調査)),
                toRString(要介護3計 - 要介護3要介護3被保険者数),
                toRString(要介護3非該当被保険者数 + 要介護3要支援1被保険者数
                        + 要介護3要支援2被保険者数 + 要介護3要介護1被保険者数 + 要介護3要介護2被保険者数),
                toRString(要介護3要介護4被保険者数 + 要介護3要介護5被保険者数),
                要介護3計 == 0 || 要介護3計 == 要介護3要介護3被保険者数 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(要介護3計 - 要介護3要介護3被保険者数).divide(要介護3計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return item;
    }

    private ShinsaHanteiJokyoItem get一次判定要介護4(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            SinsakaiHanteiJyokyoHeaderEntity current) {
        int 要介護4非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_非該当);
        int 要介護4要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要支援1);
        int 要介護4要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要支援2);
        int 要介護4要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護1);
        int 要介護4要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護2);
        int 要介護4要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護3);
        int 要介護4要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護4);
        int 要介護4要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護4, コード_要介護5);
        int 要介護4計 = 要介護4非該当被保険者数 + 要介護4要支援1被保険者数 + 要介護4要支援2被保険者数 + 要介護4要介護1被保険者数
                + 要介護4要介護2被保険者数 + 要介護4要介護3被保険者数 + 要介護4要介護4被保険者数 + 要介護4要介護5被保険者数;
        ShinsaHanteiJokyoItem item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                要介護4,
                toRString(要介護4非該当被保険者数),
                toRString(要介護4要支援1被保険者数),
                toRString(要介護4要支援2被保険者数),
                toRString(要介護4要介護1被保険者数),
                toRString(要介護4要介護2被保険者数),
                toRString(要介護4要介護3被保険者数),
                toRString(要介護4要介護4被保険者数),
                toRString(要介護4要介護5被保険者数),
                new RString(要介護4計),
                toRString(get被保険者数(審査判定状況, コード_要介護4, コード_再調査)),
                toRString(要介護4計 - 要介護4要介護4被保険者数),
                toRString(要介護4計 - 要介護4要介護4被保険者数 - 要介護4要介護5被保険者数),
                toRString(要介護4要介護5被保険者数),
                要介護4計 == 0 || 要介護4計 == 要介護4要介護4被保険者数 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(要介護4計 - 要介護4要介護4被保険者数).divide(要介護4計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return item;
    }

    private ShinsaHanteiJokyoItem get一次判定要介護5(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            SinsakaiHanteiJyokyoHeaderEntity current) {
        int 要介護5非該当被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_非該当);
        int 要介護5要支援1被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要支援1);
        int 要介護5要支援2被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要支援2);
        int 要介護5要介護1被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護1);
        int 要介護5要介護2被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護2);
        int 要介護5要介護3被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護3);
        int 要介護5要介護4被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護4);
        int 要介護5要介護5被保険者数 = get被保険者数(審査判定状況, コード_要介護5, コード_要介護5);
        int 要介護5計 = 要介護5非該当被保険者数 + 要介護5要支援1被保険者数 + 要介護5要支援2被保険者数 + 要介護5要介護1被保険者数
                + 要介護5要介護2被保険者数 + 要介護5要介護3被保険者数 + 要介護5要介護4被保険者数 + 要介護5要介護5被保険者数;
        ShinsaHanteiJokyoItem item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                要介護5,
                toRString(要介護5非該当被保険者数),
                toRString(要介護5要支援1被保険者数),
                toRString(要介護5要支援2被保険者数),
                toRString(要介護5要介護1被保険者数),
                toRString(要介護5要介護2被保険者数),
                toRString(要介護5要介護3被保険者数),
                toRString(要介護5要介護4被保険者数),
                toRString(要介護5要介護5被保険者数),
                new RString(要介護5計),
                toRString(get被保険者数(審査判定状況, コード_要介護5, コード_再調査)),
                toRString(要介護5計 - 要介護5要介護5被保険者数),
                toRString(要介護5計 - 要介護5要介護5被保険者数),
                RString.EMPTY,
                要介護5計 == 0 || 要介護5計 == 要介護5要介護5被保険者数 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(要介護5計 - 要介護5要介護5被保険者数).divide(要介護5計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return item;
    }

    private ShinsaHanteiJokyoItem get計(SinsakaiHanteiJyokyoHeaderEntity current,
            ShinsaHanteiJokyoItem 一次判定非該当,
            ShinsaHanteiJokyoItem 一次判定要支援1,
            ShinsaHanteiJokyoItem 一次判定要支援2,
            ShinsaHanteiJokyoItem 一次判定要介護1,
            ShinsaHanteiJokyoItem 一次判定要介護2,
            ShinsaHanteiJokyoItem 一次判定要介護3,
            ShinsaHanteiJokyoItem 一次判定要介護4,
            ShinsaHanteiJokyoItem 一次判定要介護5) {
        int 計非該当 = toInt(一次判定非該当.getListHantei_2()) + toInt(一次判定要支援1.getListHantei_2())
                + toInt(一次判定要支援2.getListHantei_2()) + toInt(一次判定要介護1.getListHantei_2())
                + toInt(一次判定要介護2.getListHantei_2()) + toInt(一次判定要介護3.getListHantei_2())
                + toInt(一次判定要介護4.getListHantei_2()) + toInt(一次判定要介護5.getListHantei_2());
        int 計要支援1 = toInt(一次判定非該当.getListHantei_3()) + toInt(一次判定要支援1.getListHantei_3())
                + toInt(一次判定要支援2.getListHantei_3()) + toInt(一次判定要介護1.getListHantei_3())
                + toInt(一次判定要介護2.getListHantei_3()) + toInt(一次判定要介護3.getListHantei_3())
                + toInt(一次判定要介護4.getListHantei_3()) + toInt(一次判定要介護5.getListHantei_3());
        int 計要支援2 = toInt(一次判定非該当.getListHantei_4()) + toInt(一次判定要支援1.getListHantei_4())
                + toInt(一次判定要支援2.getListHantei_4()) + toInt(一次判定要介護1.getListHantei_4())
                + toInt(一次判定要介護2.getListHantei_4()) + toInt(一次判定要介護3.getListHantei_4())
                + toInt(一次判定要介護4.getListHantei_4()) + toInt(一次判定要介護5.getListHantei_4());
        int 計要介護1 = toInt(一次判定非該当.getListHantei_5()) + toInt(一次判定要支援1.getListHantei_5())
                + toInt(一次判定要支援2.getListHantei_5()) + toInt(一次判定要介護1.getListHantei_5())
                + toInt(一次判定要介護2.getListHantei_5()) + toInt(一次判定要介護3.getListHantei_5())
                + toInt(一次判定要介護4.getListHantei_5()) + toInt(一次判定要介護5.getListHantei_5());
        int 計要介護2 = toInt(一次判定非該当.getListHantei_6()) + toInt(一次判定要支援1.getListHantei_6())
                + toInt(一次判定要支援2.getListHantei_6()) + toInt(一次判定要介護1.getListHantei_6())
                + toInt(一次判定要介護2.getListHantei_6()) + toInt(一次判定要介護3.getListHantei_6())
                + toInt(一次判定要介護4.getListHantei_6()) + toInt(一次判定要介護5.getListHantei_6());
        int 計要介護3 = toInt(一次判定非該当.getListHantei_7()) + toInt(一次判定要支援1.getListHantei_7())
                + toInt(一次判定要支援2.getListHantei_7()) + toInt(一次判定要介護1.getListHantei_7())
                + toInt(一次判定要介護2.getListHantei_7()) + toInt(一次判定要介護3.getListHantei_7())
                + toInt(一次判定要介護4.getListHantei_7()) + toInt(一次判定要介護5.getListHantei_7());
        int 計要介護4 = toInt(一次判定非該当.getListHantei_8()) + toInt(一次判定要支援1.getListHantei_8())
                + toInt(一次判定要支援2.getListHantei_8()) + toInt(一次判定要介護1.getListHantei_8())
                + toInt(一次判定要介護2.getListHantei_8()) + toInt(一次判定要介護3.getListHantei_8())
                + toInt(一次判定要介護4.getListHantei_8()) + toInt(一次判定要介護5.getListHantei_8());
        int 計要介護5 = toInt(一次判定非該当.getListHantei_9()) + toInt(一次判定要支援1.getListHantei_9())
                + toInt(一次判定要支援2.getListHantei_9()) + toInt(一次判定要介護1.getListHantei_9())
                + toInt(一次判定要介護2.getListHantei_9()) + toInt(一次判定要介護3.getListHantei_9())
                + toInt(一次判定要介護4.getListHantei_9()) + toInt(一次判定要介護5.getListHantei_9());
        int 計計 = toInt(一次判定非該当.getListHantei_10()) + toInt(一次判定要支援1.getListHantei_10())
                + toInt(一次判定要支援2.getListHantei_10()) + toInt(一次判定要介護1.getListHantei_10())
                + toInt(一次判定要介護2.getListHantei_10()) + toInt(一次判定要介護3.getListHantei_10())
                + toInt(一次判定要介護4.getListHantei_10()) + toInt(一次判定要介護5.getListHantei_10());
        int 計再調査二次保留分 = toInt(一次判定非該当.getListHantei_11()) + toInt(一次判定要支援1.getListHantei_11())
                + toInt(一次判定要支援2.getListHantei_11()) + toInt(一次判定要介護1.getListHantei_11())
                + toInt(一次判定要介護2.getListHantei_11()) + toInt(一次判定要介護3.getListHantei_11())
                + toInt(一次判定要介護4.getListHantei_11()) + toInt(一次判定要介護5.getListHantei_11());
        int 計判定変更者数 = toInt(一次判定非該当.getListHantei_12()) + toInt(一次判定要支援1.getListHantei_12())
                + toInt(一次判定要支援2.getListHantei_12()) + toInt(一次判定要介護1.getListHantei_12())
                + toInt(一次判定要介護2.getListHantei_12()) + toInt(一次判定要介護3.getListHantei_12())
                + toInt(一次判定要介護4.getListHantei_12()) + toInt(一次判定要介護5.getListHantei_12());
        int 計軽度変更者数 = toInt(一次判定非該当.getListHantei_13()) + toInt(一次判定要支援1.getListHantei_13())
                + toInt(一次判定要支援2.getListHantei_13()) + toInt(一次判定要介護1.getListHantei_13())
                + toInt(一次判定要介護2.getListHantei_13()) + toInt(一次判定要介護3.getListHantei_13())
                + toInt(一次判定要介護4.getListHantei_13()) + toInt(一次判定要介護5.getListHantei_13());
        int 計重度変更者数 = toInt(一次判定非該当.getListHantei_14()) + toInt(一次判定要支援1.getListHantei_14())
                + toInt(一次判定要支援2.getListHantei_14()) + toInt(一次判定要介護1.getListHantei_14())
                + toInt(一次判定要介護2.getListHantei_14()) + toInt(一次判定要介護3.getListHantei_14())
                + toInt(一次判定要介護4.getListHantei_14()) + toInt(一次判定要介護5.getListHantei_14());
        ShinsaHanteiJokyoItem 合計 = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                計,
                new RString(計非該当),
                new RString(計要支援1),
                new RString(計要支援2),
                new RString(計要介護1),
                new RString(計要介護2),
                new RString(計要介護3),
                new RString(計要介護4),
                new RString(計要介護5),
                new RString(計計),
                new RString(計再調査二次保留分),
                new RString(計判定変更者数),
                new RString(計軽度変更者数),
                new RString(計重度変更者数),
                計計 == 0 || 計判定変更者数 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(計判定変更者数).divide(計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return 合計;
    }

    private ShinsaHanteiJokyoItem get変更者(SinsakaiHanteiJyokyoHeaderEntity current,
            ShinsaHanteiJokyoItem 一次判定非該当,
            ShinsaHanteiJokyoItem 一次判定要支援1,
            ShinsaHanteiJokyoItem 一次判定要支援2,
            ShinsaHanteiJokyoItem 一次判定要介護1,
            ShinsaHanteiJokyoItem 一次判定要介護2,
            ShinsaHanteiJokyoItem 一次判定要介護3,
            ShinsaHanteiJokyoItem 一次判定要介護4,
            ShinsaHanteiJokyoItem 一次判定要介護5) {
        int 変更者非該当 = toInt(一次判定要支援1.getListHantei_2())
                + toInt(一次判定要支援2.getListHantei_2()) + toInt(一次判定要介護1.getListHantei_2())
                + toInt(一次判定要介護2.getListHantei_2()) + toInt(一次判定要介護3.getListHantei_2())
                + toInt(一次判定要介護4.getListHantei_2()) + toInt(一次判定要介護5.getListHantei_2());
        int 変更者要支援1 = toInt(一次判定非該当.getListHantei_3())
                + toInt(一次判定要支援2.getListHantei_3()) + toInt(一次判定要介護1.getListHantei_3())
                + toInt(一次判定要介護2.getListHantei_3()) + toInt(一次判定要介護3.getListHantei_3())
                + toInt(一次判定要介護4.getListHantei_3()) + toInt(一次判定要介護5.getListHantei_3());
        int 変更者要支援2 = toInt(一次判定非該当.getListHantei_4()) + toInt(一次判定要支援1.getListHantei_4())
                //                + toInt(一次判定要介護1.getListHantei_4())
                + toInt(一次判定要介護2.getListHantei_4()) + toInt(一次判定要介護3.getListHantei_4())
                + toInt(一次判定要介護4.getListHantei_4()) + toInt(一次判定要介護5.getListHantei_4());
        int 変更者要介護1 = toInt(一次判定非該当.getListHantei_5()) + toInt(一次判定要支援1.getListHantei_5())
                //                + toInt(一次判定要支援2.getListHantei_5())
                + toInt(一次判定要介護2.getListHantei_5()) + toInt(一次判定要介護3.getListHantei_5())
                + toInt(一次判定要介護4.getListHantei_5()) + toInt(一次判定要介護5.getListHantei_5());
        int 変更者要介護2 = toInt(一次判定非該当.getListHantei_6()) + toInt(一次判定要支援1.getListHantei_6())
                + toInt(一次判定要支援2.getListHantei_6()) + toInt(一次判定要介護1.getListHantei_6())
                + toInt(一次判定要介護3.getListHantei_6())
                + toInt(一次判定要介護4.getListHantei_6()) + toInt(一次判定要介護5.getListHantei_6());
        int 変更者要介護3 = toInt(一次判定非該当.getListHantei_7()) + toInt(一次判定要支援1.getListHantei_7())
                + toInt(一次判定要支援2.getListHantei_7()) + toInt(一次判定要介護1.getListHantei_7())
                + toInt(一次判定要介護2.getListHantei_7())
                + toInt(一次判定要介護4.getListHantei_7()) + toInt(一次判定要介護5.getListHantei_7());
        int 変更者要介護4 = toInt(一次判定非該当.getListHantei_8()) + toInt(一次判定要支援1.getListHantei_8())
                + toInt(一次判定要支援2.getListHantei_8()) + toInt(一次判定要介護1.getListHantei_8())
                + toInt(一次判定要介護2.getListHantei_8()) + toInt(一次判定要介護3.getListHantei_8())
                + toInt(一次判定要介護5.getListHantei_8());
        int 変更者要介護5 = toInt(一次判定非該当.getListHantei_9()) + toInt(一次判定要支援1.getListHantei_9())
                + toInt(一次判定要支援2.getListHantei_9()) + toInt(一次判定要介護1.getListHantei_9())
                + toInt(一次判定要介護2.getListHantei_9()) + toInt(一次判定要介護3.getListHantei_9())
                + toInt(一次判定要介護4.getListHantei_9());
        ShinsaHanteiJokyoItem 変更者Item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村コード : paramter.getShichosonCode().value(),
                RDate.getNowDate().toDateString(),
                RString.isNullOrEmpty(paramter.getShichosonCode().value()) ? 全市町村 : paramter.getShichosonName(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                変更者,
                toRString(変更者非該当),
                toRString(変更者要支援1),
                toRString(変更者要支援2),
                toRString(変更者要介護1),
                toRString(変更者要介護2),
                toRString(変更者要介護3),
                toRString(変更者要介護4),
                toRString(変更者要介護5),
                new RString(変更者非該当 + 変更者要支援1 + 変更者要支援2 + 変更者要介護1 + 変更者要介護2 + 変更者要介護3 + 変更者要介護4 + 変更者要介護5),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return 変更者Item;
    }

    private ShinsaHanteiJokyoItem get割合(SinsakaiHanteiJyokyoHeaderEntity current,
            ShinsaHanteiJokyoItem 合計) {
        int 二次判定非該当計 = Integer.parseInt(合計.getListHantei_2().toString());
        int 二次判定要支援1計 = Integer.parseInt(合計.getListHantei_3().toString());
        int 二次判定要支援2計 = Integer.parseInt(合計.getListHantei_4().toString());
        int 二次判定要介護1計 = Integer.parseInt(合計.getListHantei_5().toString());
        int 二次判定要介護2計 = Integer.parseInt(合計.getListHantei_6().toString());
        int 二次判定要介護3計 = Integer.parseInt(合計.getListHantei_7().toString());
        int 二次判定要介護4計 = Integer.parseInt(合計.getListHantei_8().toString());
        int 二次判定要介護5計 = Integer.parseInt(合計.getListHantei_9().toString());
        int 合計計 = Integer.parseInt(合計.getListHantei_10().toString());
        RString shichosonCode;
        RString shichosonName;
        if (RString.isNullOrEmpty(paramter.getShichosonCode().value())) {
            shichosonCode = 全市町村コード;
            shichosonName = 全市町村;
        } else {
            shichosonCode = paramter.getShichosonCode().value();
            shichosonName = paramter.getShichosonName();
        }
        ShinsaHanteiJokyoItem 割合Item = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                paramter.isEmptyGogitaiNo() ? 全合議体 : paramter.getGogitaiName(),
                get対象開始年月日(),
                get対象終了年月日(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                shichosonCode,
                RDate.getNowDate().toDateString(),
                shichosonName,
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                new RString("割合"),
                合計計 == 0 || 二次判定非該当計 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(二次判定非該当計).divide(合計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                合計計 == 0 || 二次判定要支援1計 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(二次判定要支援1計).divide(合計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                合計計 == 0 || 二次判定要支援2計 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(二次判定要支援2計).divide(合計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                合計計 == 0 || 二次判定要介護1計 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(二次判定要介護1計).divide(合計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                合計計 == 0 || 二次判定要介護2計 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(二次判定要介護2計).divide(合計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                合計計 == 0 || 二次判定要介護3計 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(二次判定要介護3計).divide(合計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                合計計 == 0 || 二次判定要介護4計 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(二次判定要介護4計).divide(合計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                合計計 == 0 || 二次判定要介護5計 == 0 ? 割合なし : new RString(
                        FORMAT.format(new Decimal(二次判定要介護5計).divide(合計計).multiply(割合).roundHalfUpTo(1)) + パーセント),
                new RString("100.0%"),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return 割合Item;
    }

    private RString get対象開始年月日() {
        RString 対象開始日 = RString.EMPTY;
        if (paramter.isTaishoTsukiKubun()) {
            FlexibleYearMonth 対象年月 = new FlexibleYearMonth(paramter.getTaishoNendoYM());
            対象開始日 = new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 1).toDateString();
        } else if (paramter.isTaishoGeppiKubun() && !paramter.isEmptyTaishoGeppiFrom()) {
            対象開始日 = paramter.getTaishoGeppiFrom();
        }
        return 対象開始日;
    }

    private RString get対象終了年月日() {
        RString 対象終了日 = RString.EMPTY;
        if (paramter.isTaishoTsukiKubun()) {
            FlexibleYearMonth 対象年月 = new FlexibleYearMonth(paramter.getTaishoNendoYM());
            対象終了日 = new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 対象年月.getLastDay()).toDateString();
        } else if (paramter.isTaishoGeppiKubun() && !paramter.isEmptyTaishoGeppiTo()) {
            対象終了日 = paramter.getTaishoGeppiTo();
        }
        return 対象終了日;
    }

    private ShinsaHanteiJokyoItem get判定件数(ShinsaHanteiJokyoItem 一次判定非該当,
            ShinsaHanteiJokyoItem 合計) {
        return new ShinsaHanteiJokyoItem(
                一次判定非該当.getTitle(),
                一次判定非該当.getGogitaiName(),
                一次判定非該当.getKaisaiKaishiYMD(),
                一次判定非該当.getKaisaiShuryoYMD(),
                一次判定非該当.getKaisaiCount(),
                一次判定非該当.getHokenshaNo(),
                一次判定非該当.getPrintTimeStamp(),
                一次判定非該当.getHokenshaName(),
                一次判定非該当.getListHanteiHeader_1(),
                一次判定非該当.getListHanteiHeader_2(),
                一次判定非該当.getListHanteiHeader_3(),
                一次判定非該当.getListHanteiHeader_4(),
                一次判定非該当.getListHanteiHeader_5(),
                一次判定非該当.getListHanteiHeader_6(),
                一次判定非該当.getListHanteiHeader_7(),
                一次判定非該当.getListHanteiHeader_8(),
                一次判定非該当.getListHanteiHeader_9(),
                一次判定非該当.getListHantei_1(),
                一次判定非該当.getListHantei_2(),
                一次判定非該当.getListHantei_3(),
                一次判定非該当.getListHantei_4(),
                一次判定非該当.getListHantei_5(),
                一次判定非該当.getListHantei_6(),
                一次判定非該当.getListHantei_7(),
                一次判定非該当.getListHantei_8(),
                一次判定非該当.getListHantei_9(),
                一次判定非該当.getListHantei_10(),
                一次判定非該当.getListHantei_11(),
                一次判定非該当.getListHantei_12(),
                一次判定非該当.getListHantei_13(),
                一次判定非該当.getListHantei_14(),
                一次判定非該当.getListHantei_15(),
                合計.getListHantei_12(),
                合計.getListHantei_13(),
                合計.getListHantei_14());
    }

    private int get被保険者数(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            RString 要介護認定一次判定結果コード認知症加算,
            RString 二次判定要介護状態区分コード) {
        for (SinsakaiHanteiJyokyoEntity sinsakaiHanteiJyokyoEntity : 審査判定状況) {
            if (sinsakaiHanteiJyokyoEntity.getIchijiHanteiKekkaNinchishoKasanCode().value().equals(要介護認定一次判定結果コード認知症加算)
                    && sinsakaiHanteiJyokyoEntity.getNijiHanteiYokaigoJotaiKubunCode().value().equals(二次判定要介護状態区分コード)) {
                return sinsakaiHanteiJyokyoEntity.getHihokenshaCount();
            }
        }
        return 0;
    }

    private RString toRString(int 被保険者数) {
        return 被保険者数 == 0 ? RString.EMPTY : new RString(被保険者数);
    }

    private int toInt(RString 被保険者数) {
        return RString.isNullOrEmpty(被保険者数) ? 0 : Integer.parseInt(被保険者数.toString());
    }
}
