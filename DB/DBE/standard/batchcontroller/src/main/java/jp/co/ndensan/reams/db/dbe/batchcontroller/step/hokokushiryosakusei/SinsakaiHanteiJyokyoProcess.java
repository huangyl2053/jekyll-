package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo.ShinsaHanteiJokyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo.ShinsaHanteiJokyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.SinsakaiHanteiJyokyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.SinsakaiHanteiJyokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会判定状況の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class SinsakaiHanteiJyokyoProcess extends BatchKeyBreakBase<SinsakaiHanteiJyokyoHeaderEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getSinsakaiHanteiJyokyoHeader");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinsaHanteiJokyoReportSource.ReportSourceFields.gogitaiName.name()),
            new RString(ShinsaHanteiJokyoReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final RString 帳票タイトル = new RString("介護認定審査会判定状況表");
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
    private static final RString 計 = new RString("計");
    private static final RString 割合なし = new RString(0);
    private static final int 割合 = 100;
    private static final RString パーセント = new RString("%");
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
                .addBreak(new BreakerCatalog<ShinsaHanteiJokyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(SinsakaiHanteiJyokyoHeaderEntity headerJoho) {
        if (hasBrek(getBefore(), headerJoho)) {
            ShinsaHanteiJokyoReport report = ShinsaHanteiJokyoReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
            itemList.clear();
        }
    }

    @Override
    protected void usualProcess(SinsakaiHanteiJyokyoHeaderEntity current) {
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
        ShinsaHanteiJokyoItem 変更者 = get変更者(current, 一次判定非該当, 一次判定要支援1, 一次判定要支援2, 一次判定要介護1,
                一次判定要介護2, 一次判定要介護3, 一次判定要介護4, 一次判定要介護5);
        ShinsaHanteiJokyoItem 割合 = get割合(current, 合計);

        itemList.add(一次判定非該当);
        itemList.add(一次判定要支援1);
        itemList.add(一次判定要支援2);
        itemList.add(一次判定要介護1);
        itemList.add(一次判定要介護2);
        itemList.add(一次判定要介護3);
        itemList.add(一次判定要介護4);
        itemList.add(一次判定要介護5);
        itemList.add(合計);
        itemList.add(変更者);
        itemList.add(割合);

    }

    @Override
    protected void afterExecute() {
        ShinsaHanteiJokyoReport report = ShinsaHanteiJokyoReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
    }

    private boolean hasBrek(SinsakaiHanteiJyokyoHeaderEntity before, SinsakaiHanteiJyokyoHeaderEntity current) {
        return !(before.getGogitaiNo() == current.getGogitaiNo()
                && before.getShoKisaiHokenshaNo().equals(current.getShoKisaiHokenshaNo()));
    }

    private List<SinsakaiHanteiJyokyoEntity> get審査判定状況(SinsakaiHanteiJyokyoHeaderEntity current) {

        SinsakaiHanteiJyokyoMyBatisParameter batisParameter = paramter.toSinsakaiHanteiJyokyoMyBatisParameter();
        batisParameter.setGogitaiNo(current.getGogitaiNo());
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        batisParameter.setShichosonCode(current.getShichosonCode());
        return mapper.getSinsakaiHanteiJyokyo(batisParameter);
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
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                new RString(非該当非該当被保険者数),
                new RString(非該当要支援1被保険者数),
                new RString(非該当要支援2被保険者数),
                new RString(非該当要介護1被保険者数),
                new RString(非該当要介護2被保険者数),
                new RString(非該当要介護3被保険者数),
                new RString(非該当要介護4被保険者数),
                new RString(非該当要介護5被保険者数),
                new RString(非該当計),
                new RString(get被保険者数(審査判定状況, コード_非該当, コード_再調査)),
                new RString(非該当計 - 非該当非該当被保険者数),
                new RString(0),
                new RString(非該当計 - 非該当非該当被保険者数),
                非該当計 == 0 ? 割合なし : new RString(String.valueOf(
                                (非該当計 - 非該当非該当被保険者数) / 非該当計 * 割合) + パーセント),
                new RString(非該当計 - 非該当非該当被保険者数),
                new RString(0),
                new RString(非該当計 - 非該当非該当被保険者数));
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
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                new RString(要支援1非該当被保険者数),
                new RString(要支援1要支援1被保険者数),
                new RString(要支援1要支援2被保険者数),
                new RString(要支援1要介護1被保険者数),
                new RString(要支援1要介護2被保険者数),
                new RString(要支援1要介護3被保険者数),
                new RString(要支援1要介護4被保険者数),
                new RString(要支援1要介護5被保険者数),
                new RString(要支援1計),
                new RString(get被保険者数(審査判定状況, コード_要支援1, コード_再調査)),
                new RString(要支援1計 - 要支援1要支援1被保険者数),
                new RString(要支援1非該当被保険者数),
                new RString(要支援1計 - 要支援1非該当被保険者数 - 要支援1要支援1被保険者数),
                要支援1計 == 0 ? 割合なし : new RString(String.valueOf(
                                (要支援1計 - 要支援1要支援1被保険者数) / 要支援1計 * 割合) + パーセント),
                new RString(要支援1計 - 要支援1要支援1被保険者数),
                new RString(要支援1非該当被保険者数),
                new RString(要支援1計 - 要支援1非該当被保険者数 - 要支援1要支援1被保険者数));
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
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                new RString(要支援2非該当被保険者数),
                new RString(要支援2要支援1被保険者数),
                new RString(要支援2要支援2被保険者数),
                new RString(要支援2要介護1被保険者数),
                new RString(要支援2要介護2被保険者数),
                new RString(要支援2要介護3被保険者数),
                new RString(要支援2要介護4被保険者数),
                new RString(要支援2要介護5被保険者数),
                new RString(要支援2計),
                new RString(get被保険者数(審査判定状況, コード_要支援2, コード_再調査)),
                new RString(要支援2計 - 要支援2要支援2被保険者数),
                new RString(要支援2非該当被保険者数 + 要支援2要支援1被保険者数),
                new RString(要支援2計 - 要支援2非該当被保険者数 - 要支援2要支援1被保険者数 - 要支援2要支援2被保険者数),
                要支援2計 == 0 ? 割合なし : new RString(String.valueOf(
                                (要支援2計 - 要支援2要支援2被保険者数) / 要支援2計 * 割合) + パーセント),
                new RString(要支援2計 - 要支援2要支援2被保険者数),
                new RString(要支援2非該当被保険者数 + 要支援2要支援1被保険者数),
                new RString(要支援2計 - 要支援2非該当被保険者数 - 要支援2要支援1被保険者数 - 要支援2要支援2被保険者数));
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
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                new RString(要介護1非該当被保険者数),
                new RString(要介護1要支援1被保険者数),
                new RString(要介護1要支援2被保険者数),
                new RString(要介護1要介護1被保険者数),
                new RString(要介護1要介護2被保険者数),
                new RString(要介護1要介護3被保険者数),
                new RString(要介護1要介護4被保険者数),
                new RString(要介護1要介護5被保険者数),
                new RString(要介護1計),
                new RString(get被保険者数(審査判定状況, コード_要介護1, コード_再調査)),
                new RString(要介護1計 - 要介護1要介護1被保険者数),
                new RString(要介護1非該当被保険者数 + 要介護1要支援1被保険者数 + 要介護1要支援2被保険者数),
                new RString(要介護1要介護2被保険者数 + 要介護1要介護3被保険者数 + 要介護1要介護4被保険者数 + 要介護1要介護5被保険者数),
                要介護1計 == 0 ? 割合なし : new RString(String.valueOf(
                                (要介護1計 - 要介護1要介護1被保険者数) / 要介護1計 * 割合) + パーセント),
                new RString(要介護1計 - 要介護1要介護1被保険者数),
                new RString(要介護1非該当被保険者数 + 要介護1要支援1被保険者数 + 要介護1要支援2被保険者数),
                new RString(要介護1要介護2被保険者数 + 要介護1要介護3被保険者数 + 要介護1要介護4被保険者数 + 要介護1要介護5被保険者数));
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
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                new RString(要介護2非該当被保険者数),
                new RString(要介護2要支援1被保険者数),
                new RString(要介護2要支援2被保険者数),
                new RString(要介護2要介護1被保険者数),
                new RString(要介護2要介護2被保険者数),
                new RString(要介護2要介護3被保険者数),
                new RString(要介護2要介護4被保険者数),
                new RString(要介護2要介護5被保険者数),
                new RString(要介護2計),
                new RString(get被保険者数(審査判定状況, コード_要介護2, コード_再調査)),
                new RString(要介護2計 - 要介護2要介護2被保険者数),
                new RString(要介護2非該当被保険者数 + 要介護2要支援1被保険者数 + 要介護2要支援2被保険者数 + 要介護2要介護1被保険者数),
                new RString(要介護2要介護3被保険者数 + 要介護2要介護4被保険者数 + 要介護2要介護5被保険者数),
                要介護2計 == 0 ? 割合なし : new RString(String.valueOf(
                                (要介護2計 - 要介護2要介護2被保険者数) / 要介護2計 * 割合) + パーセント),
                new RString(要介護2計 - 要介護2要介護2被保険者数),
                new RString(要介護2非該当被保険者数 + 要介護2要支援1被保険者数 + 要介護2要支援2被保険者数 + 要介護2要介護1被保険者数),
                new RString(要介護2要介護3被保険者数 + 要介護2要介護4被保険者数 + 要介護2要介護5被保険者数));
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
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                new RString(要介護3非該当被保険者数),
                new RString(要介護3要支援1被保険者数),
                new RString(要介護3要支援2被保険者数),
                new RString(要介護3要介護1被保険者数),
                new RString(要介護3要介護2被保険者数),
                new RString(要介護3要介護3被保険者数),
                new RString(要介護3要介護4被保険者数),
                new RString(要介護3要介護5被保険者数),
                new RString(要介護3計),
                new RString(get被保険者数(審査判定状況, コード_要介護3, コード_再調査)),
                new RString(要介護3計 - 要介護3要介護3被保険者数),
                new RString(要介護3非該当被保険者数 + 要介護3要支援1被保険者数
                        + 要介護3要支援2被保険者数 + 要介護3要介護1被保険者数 + 要介護3要介護2被保険者数),
                new RString(要介護3要介護4被保険者数 + 要介護3要介護5被保険者数),
                要介護3計 == 0 ? 割合なし : new RString(String.valueOf(
                                (要介護3計 - 要介護3要介護3被保険者数) / 要介護3計 * 割合) + パーセント),
                new RString(要介護3計 - 要介護3要介護3被保険者数),
                new RString(要介護3非該当被保険者数 + 要介護3要支援1被保険者数
                        + 要介護3要支援2被保険者数 + 要介護3要介護1被保険者数 + 要介護3要介護2被保険者数),
                new RString(要介護3要介護4被保険者数 + 要介護3要介護5被保険者数));
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
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                new RString(要介護4非該当被保険者数),
                new RString(要介護4要支援1被保険者数),
                new RString(要介護4要支援2被保険者数),
                new RString(要介護4要介護1被保険者数),
                new RString(要介護4要介護2被保険者数),
                new RString(要介護4要介護3被保険者数),
                new RString(要介護4要介護4被保険者数),
                new RString(要介護4要介護5被保険者数),
                new RString(要介護4計),
                new RString(get被保険者数(審査判定状況, コード_要介護4, コード_再調査)),
                new RString(要介護4計 - 要介護4要介護4被保険者数),
                new RString(要介護4計 - 要介護4要介護4被保険者数 - 要介護4要介護5被保険者数),
                new RString(要介護4要介護5被保険者数),
                要介護4計 == 0 ? 割合なし : new RString(String.valueOf(
                                (要介護4計 - 要介護4要介護4被保険者数) / 要介護4計 * 割合) + パーセント),
                new RString(要介護4計 - 要介護4要介護4被保険者数),
                new RString(要介護4計 - 要介護4要介護4被保険者数 - 要介護4要介護5被保険者数),
                new RString(要介護4要介護5被保険者数));
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
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                new RString(要介護5非該当被保険者数),
                new RString(要介護5要支援1被保険者数),
                new RString(要介護5要支援2被保険者数),
                new RString(要介護5要介護1被保険者数),
                new RString(要介護5要介護2被保険者数),
                new RString(要介護5要介護3被保険者数),
                new RString(要介護5要介護4被保険者数),
                new RString(要介護5要介護5被保険者数),
                new RString(要介護5計),
                new RString(get被保険者数(審査判定状況, コード_要介護5, コード_再調査)),
                new RString(要介護5計 - 要介護5要介護5被保険者数),
                new RString(要介護5計 - 要介護5要介護5被保険者数),
                new RString(0),
                要介護5計 == 0 ? 割合なし : new RString(String.valueOf(
                                (要介護5計 - 要介護5要介護5被保険者数) / 要介護5計 * 割合) + パーセント),
                new RString(要介護5計 - 要介護5要介護5被保険者数),
                new RString(要介護5計 - 要介護5要介護5被保険者数),
                new RString(0));
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
        int 計計 = Integer.parseInt(一次判定非該当.getListHantei_10().toString())
                + Integer.parseInt(一次判定要支援1.getListHantei_10().toString())
                + Integer.parseInt(一次判定要支援2.getListHantei_10().toString())
                + Integer.parseInt(一次判定要介護1.getListHantei_10().toString())
                + Integer.parseInt(一次判定要介護2.getListHantei_10().toString())
                + Integer.parseInt(一次判定要介護3.getListHantei_10().toString())
                + Integer.parseInt(一次判定要介護4.getListHantei_10().toString())
                + Integer.parseInt(一次判定要介護5.getListHantei_10().toString());
        ShinsaHanteiJokyoItem 合計 = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                一次判定非該当.getListHantei_10(),
                一次判定要支援1.getListHantei_10(),
                一次判定要支援2.getListHantei_10(),
                一次判定要介護1.getListHantei_10(),
                一次判定要介護2.getListHantei_10(),
                一次判定要介護3.getListHantei_10(),
                一次判定要介護4.getListHantei_10(),
                一次判定要介護5.getListHantei_10(),
                new RString(計計),
                new RString(Integer.parseInt(一次判定非該当.getListHantei_11().toString())
                        + Integer.parseInt(一次判定要支援1.getListHantei_11().toString())
                        + Integer.parseInt(一次判定要支援2.getListHantei_11().toString())
                        + Integer.parseInt(一次判定要介護1.getListHantei_11().toString())
                        + Integer.parseInt(一次判定要介護2.getListHantei_11().toString())
                        + Integer.parseInt(一次判定要介護3.getListHantei_11().toString())
                        + Integer.parseInt(一次判定要介護4.getListHantei_11().toString())
                        + Integer.parseInt(一次判定要介護5.getListHantei_11().toString())),
                new RString(Integer.parseInt(一次判定非該当.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要支援1.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要支援2.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護1.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護2.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護3.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護4.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護5.getListHantei_12().toString())),
                new RString(Integer.parseInt(一次判定非該当.getListHantei_13().toString())
                        + Integer.parseInt(一次判定要支援1.getListHantei_13().toString())
                        + Integer.parseInt(一次判定要支援2.getListHantei_13().toString())
                        + Integer.parseInt(一次判定要介護1.getListHantei_13().toString())
                        + Integer.parseInt(一次判定要介護2.getListHantei_13().toString())
                        + Integer.parseInt(一次判定要介護3.getListHantei_13().toString())
                        + Integer.parseInt(一次判定要介護4.getListHantei_13().toString())
                        + Integer.parseInt(一次判定要介護5.getListHantei_13().toString())),
                new RString(Integer.parseInt(一次判定非該当.getListHantei_14().toString())
                        + Integer.parseInt(一次判定要支援1.getListHantei_14().toString())
                        + Integer.parseInt(一次判定要支援2.getListHantei_14().toString())
                        + Integer.parseInt(一次判定要介護1.getListHantei_14().toString())
                        + Integer.parseInt(一次判定要介護2.getListHantei_14().toString())
                        + Integer.parseInt(一次判定要介護3.getListHantei_14().toString())
                        + Integer.parseInt(一次判定要介護4.getListHantei_14().toString())
                        + Integer.parseInt(一次判定要介護5.getListHantei_14().toString())),
                計計 == 0 ? 割合なし
                : new RString(String.valueOf((Integer.parseInt(一次判定非該当.getListHantei_12().toString())
                                + Integer.parseInt(一次判定要支援1.getListHantei_12().toString())
                                + Integer.parseInt(一次判定要支援2.getListHantei_12().toString())
                                + Integer.parseInt(一次判定要介護1.getListHantei_12().toString())
                                + Integer.parseInt(一次判定要介護2.getListHantei_12().toString())
                                + Integer.parseInt(一次判定要介護3.getListHantei_12().toString())
                                + Integer.parseInt(一次判定要介護4.getListHantei_12().toString())
                                + Integer.parseInt(一次判定要介護5.getListHantei_12().toString()))
                                / 計計 * 割合) + パーセント),
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
        ShinsaHanteiJokyoItem 変更者 = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
                非該当,
                要支援1,
                要支援2,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                計,
                new RString("変更者"),
                一次判定非該当.getListHantei_12(),
                一次判定要支援1.getListHantei_12(),
                一次判定要支援2.getListHantei_12(),
                一次判定要介護1.getListHantei_12(),
                一次判定要介護2.getListHantei_12(),
                一次判定要介護3.getListHantei_12(),
                一次判定要介護4.getListHantei_12(),
                一次判定要介護5.getListHantei_12(),
                new RString(Integer.parseInt(一次判定非該当.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要支援1.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要支援2.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護1.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護2.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護3.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護4.getListHantei_12().toString())
                        + Integer.parseInt(一次判定要介護5.getListHantei_12().toString())),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        return 変更者;
    }

    private ShinsaHanteiJokyoItem get割合(SinsakaiHanteiJyokyoHeaderEntity current,
            ShinsaHanteiJokyoItem 合計) {
        int 合計計 = Integer.parseInt(合計.getListHantei_10().toString());
        ShinsaHanteiJokyoItem 変更者 = new ShinsaHanteiJokyoItem(
                帳票タイトル,
                current.getGogitaiMei(),
                current.getShinsakaiKaisaiYMDMin(),
                current.getShinsakaiKaisaiYMDMax(),
                new RString(current.getShinsakaiKaisaiNoCount()),
                current.getShoKisaiHokenshaNo(),
                RDate.getNowDate().toDateString(),
                current.getShichosonMeisho(),
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
                合計計 == 0 ? 割合なし : new RString(String.valueOf(
                                Integer.parseInt(合計.getListHantei_2().toString()) / 合計計 * 割合) + パーセント),
                合計計 == 0 ? 割合なし : new RString(String.valueOf(
                                Integer.parseInt(合計.getListHantei_3().toString()) / 合計計 * 割合) + パーセント),
                合計計 == 0 ? 割合なし : new RString(String.valueOf(
                                Integer.parseInt(合計.getListHantei_4().toString()) / 合計計 * 割合) + パーセント),
                合計計 == 0 ? 割合なし : new RString(String.valueOf(
                                Integer.parseInt(合計.getListHantei_5().toString()) / 合計計 * 割合) + パーセント),
                合計計 == 0 ? 割合なし : new RString(String.valueOf(
                                Integer.parseInt(合計.getListHantei_6().toString()) / 合計計 * 割合) + パーセント),
                合計計 == 0 ? 割合なし : new RString(String.valueOf(
                                Integer.parseInt(合計.getListHantei_7().toString()) / 合計計 * 割合) + パーセント),
                合計計 == 0 ? 割合なし : new RString(String.valueOf(
                                Integer.parseInt(合計.getListHantei_8().toString()) / 合計計 * 割合) + パーセント),
                合計計 == 0 ? 割合なし : new RString(String.valueOf(
                                Integer.parseInt(合計.getListHantei_9().toString()) / 合計計 * 割合) + パーセント),
                new RString("100%"),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                合計.getListHantei_12(),
                合計.getListHantei_13(),
                合計.getListHantei_14());
        return 変更者;
    }

    private int get被保険者数(List<SinsakaiHanteiJyokyoEntity> 審査判定状況,
            RString 要介護認定一次判定結果コード,
            RString 二次判定要介護状態区分コード) {
        for (SinsakaiHanteiJyokyoEntity sinsakaiHanteiJyokyoEntity : 審査判定状況) {
            if (sinsakaiHanteiJyokyoEntity.getIchijiHanteiKekkaCode().value().equals(要介護認定一次判定結果コード)
                    && sinsakaiHanteiJyokyoEntity.getNijiHanteiYokaigoJotaiKubunCode().value().equals(二次判定要介護状態区分コード)) {
                return sinsakaiHanteiJyokyoEntity.getHihokenshaCount();
            }
        }
        return 0;
    }

}
