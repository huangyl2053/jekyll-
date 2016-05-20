package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo.Shinsakaishukeihyo;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo.ShinsakaishukeihyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.SinsakaiHanteiJyokyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.SinsakaiHanteiJyokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo.ShinsakaishukeihyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 審査判定の変更状況の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsakaishukeihyoHanteiBetsuProcess extends BatchKeyBreakBase<SinsakaiHanteiJyokyoHeaderEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getShinsakaishukeihyoHanteiBetsuHeader");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinsakaishukeihyoReportSource.ReportSourceFields.shichosonNo.name())));
    private static final RString タイトル = new RString("介護認定審査会集計表（判定別）");
    private static final RString 非該当タイトル = new RString("非該当");
    private static final RString 要支援1タイトル = new RString("要支援1");
    private static final RString 要支援2タイトル = new RString("要支援2");
    private static final RString 要介護1タイトル = new RString("要介護1");
    private static final RString 要介護2タイトル = new RString("要介護2");
    private static final RString 要介護3タイトル = new RString("要介護3");
    private static final RString 要介護4タイトル = new RString("要介護4");
    private static final RString 要介護5タイトル = new RString("要介護5");
    private static final RString 計タイトル = new RString("計");
    private static final RString 非該当 = new RString("01");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private SinsakaiHanteiJyokyoProcessParameter paramter;
    private IHokokuShiryoSakuSeiMapper mapper;
    private Shinsakaishukeihyo shinsakaishukeihyo;

    @BatchWriter
    private BatchReportWriter<ShinsakaishukeihyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaishukeihyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        shinsakaishukeihyo = new Shinsakaishukeihyo();
        mapper = getMapper(IHokokuShiryoSakuSeiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HEADER, paramter.toSinsakaiHanteiJyokyoMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701007.getReportId().value())
                .addBreak(new BreakerCatalog<ShinsakaishukeihyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(SinsakaiHanteiJyokyoHeaderEntity headerJoho) {
        if (hasBrek(getBefore(), headerJoho)) {
            ShinsakaishukeihyoReport report = new ShinsakaishukeihyoReport(shinsakaishukeihyo);
            report.writeBy(reportSourceWriter);
            shinsakaishukeihyo = new Shinsakaishukeihyo();
        }
    }

    @Override
    protected void usualProcess(SinsakaiHanteiJyokyoHeaderEntity current) {
        setヘッダ情報(current);
        List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表 = get集計表(current);
        set前回非該当(審査会集計表);
        set前回要支援1(審査会集計表);
        set前回要支援2(審査会集計表);
        set前回要介護1(審査会集計表);
        set前回要介護2(審査会集計表);
        set前回要介護3(審査会集計表);
        set前回要介護4(審査会集計表);
        set前回要介護5(審査会集計表);
        set計();
        ShinsakaishukeihyoReport report = new ShinsakaishukeihyoReport(shinsakaishukeihyo);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        batchWriter.close();
    }

    private boolean hasBrek(SinsakaiHanteiJyokyoHeaderEntity before, SinsakaiHanteiJyokyoHeaderEntity current) {
        return !(before.getShichosonCode().equals(current.getShichosonCode()));
    }

    private List<ShinsakaishukeihyoHanteiBetsuEntity> get集計表(SinsakaiHanteiJyokyoHeaderEntity current) {
        SinsakaiHanteiJyokyoMyBatisParameter batisParameter = paramter.toSinsakaiHanteiJyokyoMyBatisParameter();
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        batisParameter.setShichosonCode(current.getShichosonCode());
        return mapper.getShinsakaishukeihyoHanteiBetsu(batisParameter);
    }

    private void setヘッダ情報(SinsakaiHanteiJyokyoHeaderEntity current) {
        shinsakaishukeihyo.setタイトル(タイトル);
        shinsakaishukeihyo.set合議体番号(new RString(current.getGogitaiNo()));
        shinsakaishukeihyo.set審査会開始年月日(current.getShinsakaiKaisaiYMDMin());
        shinsakaishukeihyo.set審査会終了年月日(current.getShinsakaiKaisaiYMDMax());
        shinsakaishukeihyo.set開催回数(new RString(current.getShinsakaiKaisaiNoCount()));
        shinsakaishukeihyo.set市町村コード(current.getShichosonCode().value());
        shinsakaishukeihyo.set市町村名(current.getShichosonMeisho());
        shinsakaishukeihyo.set発行日時(RDateTime.now());
        shinsakaishukeihyo.set二次判定非該当タイトル(非該当タイトル);
        shinsakaishukeihyo.set二次判定要支援1タイトル(要支援1タイトル);
        shinsakaishukeihyo.set二次判定要支援2タイトル(要支援2タイトル);
        shinsakaishukeihyo.set二次判定要介護1タイトル(要介護1タイトル);
        shinsakaishukeihyo.set二次判定要介護2タイトル(要介護2タイトル);
        shinsakaishukeihyo.set二次判定要介護3タイトル(要介護3タイトル);
        shinsakaishukeihyo.set二次判定要介護4タイトル(要介護4タイトル);
        shinsakaishukeihyo.set二次判定要介護5タイトル(要介護5タイトル);
        shinsakaishukeihyo.set前回二次判定_計タイトル(計タイトル);
    }

    private void set前回非該当(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定非該当タイトル(非該当タイトル);
        shinsakaishukeihyo.set前回二次判定非該当_二次判定非該当(new RString(get被保険者数(審査会集計表, 非該当, 非該当)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要支援1(new RString(get被保険者数(審査会集計表, 非該当, 要支援1)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要支援2(new RString(get被保険者数(審査会集計表, 非該当, 要支援2)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護1(new RString(get被保険者数(審査会集計表, 非該当, 要介護1)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護2(new RString(get被保険者数(審査会集計表, 非該当, 要介護2)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護3(new RString(get被保険者数(審査会集計表, 非該当, 要介護3)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護4(new RString(get被保険者数(審査会集計表, 非該当, 要介護4)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護5(new RString(get被保険者数(審査会集計表, 非該当, 要介護5)));
        set前回二次判定非該当_計();
    }

    private void set前回二次判定非該当_計() {
        shinsakaishukeihyo.set前回二次判定非該当_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護5().toString())));
    }

    private void set前回要支援1(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要支援1タイトル(要支援1タイトル);
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定非該当(new RString(get被保険者数(審査会集計表, 要支援1, 非該当)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要支援1, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要支援1, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要支援1, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要支援1, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要支援1, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要支援1, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要支援1, 要介護5)));
        set前回二次判定要支援1_計();
    }

    private void set前回二次判定要支援1_計() {
        shinsakaishukeihyo.set前回二次判定要支援1_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護5().toString())));
    }

    private void set前回要支援2(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要支援2タイトル(要支援2タイトル);
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定非該当(new RString(get被保険者数(審査会集計表, 要支援2, 非該当)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要支援2, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要支援2, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要支援2, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要支援2, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要支援2, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要支援2, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要支援2, 要介護5)));
        set前回二次判定要支援2_計();
    }

    private void set前回二次判定要支援2_計() {
        shinsakaishukeihyo.set前回二次判定要支援2_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護5().toString())));
    }

    private void set前回要介護1(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護1タイトル(要介護1タイトル);
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護1, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護1, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護1, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護1, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護1, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護1, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護1, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護1, 要介護5)));
        set前回二次判定要介護1_計();
    }

    private void set前回二次判定要介護1_計() {
        shinsakaishukeihyo.set前回二次判定要介護1_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護5().toString())));
    }

    private void set前回要介護2(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護2タイトル(要介護2タイトル);
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護2, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護2, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護2, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護2, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護2, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護2, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護2, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護2, 要介護5)));
        set前回二次判定要介護2_計();
    }

    private void set前回二次判定要介護2_計() {
        shinsakaishukeihyo.set前回二次判定要介護2_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護5().toString())));
    }

    private void set前回要介護3(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護3タイトル(要介護3タイトル);
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護3, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護3, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護3, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護3, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護3, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護3, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護3, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護3, 要介護5)));
        set前回二次判定要介護3_計();
    }

    private void set前回二次判定要介護3_計() {
        shinsakaishukeihyo.set前回二次判定要介護3_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護5().toString())));
    }

    private void set前回要介護4(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護4タイトル(要介護4タイトル);
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護4, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護4, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護4, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護4, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護4, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護4, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護4, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護4, 要介護5)));
        set前回二次判定要介護4_計();
    }

    private void set前回二次判定要介護4_計() {
        shinsakaishukeihyo.set前回二次判定要介護4_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護5().toString())));
    }

    private void set前回要介護5(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護5タイトル(要介護5タイトル);
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護5, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護5, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護5, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護5, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護5, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護5, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護5, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護5, 要介護5)));
        set前回二次判定要介護5_計();
    }

    private void set前回二次判定要介護5_計() {
        shinsakaishukeihyo.set前回二次判定要介護5_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護5().toString())));
    }

    private void set計() {
        shinsakaishukeihyo.set計タイトル(計タイトル);
        shinsakaishukeihyo.set計_二次判定非該当(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定非該当().toString())));
        shinsakaishukeihyo.set計_二次判定要支援1(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要支援1().toString())));
        shinsakaishukeihyo.set計_二次判定要支援2(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要支援2().toString())));
        shinsakaishukeihyo.set計_二次判定要介護1(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護1().toString())));
        shinsakaishukeihyo.set計_二次判定要介護2(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護2().toString())));
        shinsakaishukeihyo.set計_二次判定要介護3(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護3().toString())));
        shinsakaishukeihyo.set計_二次判定要介護4(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護4().toString())));
        shinsakaishukeihyo.set計_二次判定要介護5(new RString(
                Integer.parseInt(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護5().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護5().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護5().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護5().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護5().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護5().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護5().toString())
                + Integer.parseInt(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護5().toString())));
        set計_計();
    }

    private void set計_計() {
        shinsakaishukeihyo.set計_計(new RString(
                Integer.parseInt(shinsakaishukeihyo.get計_二次判定非該当().toString())
                + Integer.parseInt(shinsakaishukeihyo.get計_二次判定要支援1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get計_二次判定要支援2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get計_二次判定要介護1().toString())
                + Integer.parseInt(shinsakaishukeihyo.get計_二次判定要介護2().toString())
                + Integer.parseInt(shinsakaishukeihyo.get計_二次判定要介護3().toString())
                + Integer.parseInt(shinsakaishukeihyo.get計_二次判定要介護4().toString())
                + Integer.parseInt(shinsakaishukeihyo.get計_二次判定要介護5().toString())));
    }

    private int get被保険者数(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表,
            RString 前回二次判定結果コード, RString 今回二次判定結果コード) {
        for (ShinsakaishukeihyoHanteiBetsuEntity entity : 審査会集計表) {
            if (entity.getZenkaiNijiHantei().value().equals(前回二次判定結果コード)
                    && entity.getKonkaiNijiHantei().value().equals(今回二次判定結果コード)) {
                return entity.getHihokenshaCount();
            }
        }
        return 0;
    }
}
