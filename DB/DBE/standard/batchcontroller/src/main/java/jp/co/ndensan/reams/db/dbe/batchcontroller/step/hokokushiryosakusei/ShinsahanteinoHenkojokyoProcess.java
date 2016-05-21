package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyo;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.ShinsahanteinoHenkojokyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsahanteinoHenkojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 審査判定の変更状況の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsahanteinoHenkojokyoProcess extends BatchKeyBreakBase<SinsakaiHanteiJyokyoHeaderEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getShinsahanteinoHenkojokyoHeader");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinsahanteinoHenkojokyoReportSource.ReportSourceFields.gogitaiName.name()),
            new RString(ShinsahanteinoHenkojokyoReportSource.ReportSourceFields.shichosonNo.name())));
    private static final RString タイトル = new RString("認定審査会審査判定状況");
    private static final RString 新規区分変更申請 = new RString("0");
    private static final RString 新規申請 = new RString("1");
    private static final RString 更新申請 = new RString("2");
    private static final RString 区分変更申請 = new RString("3");
    private static final RString 要支援要支援 = new RString("0");
    private static final RString 要支援要介護 = new RString("1");
    private static final RString 要介護要支援 = new RString("2");
    private static final RString 要介護要介護 = new RString("3");
    private static final int 有効期間3ヶ月 = 3;
    private static final int 有効期間6ヶ月 = 6;
    private static final int 有効期間12ヶ月 = 12;
    private static final int 有効期間24ヶ月 = 24;
    private static final int 有効期間その他 = 0;
    private static final RString 非該当 = new RString("01");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private static final RString なし = new RString(0);
    private static final RString 実施済 = new RString("2");
    private ShinsahanteinoHenkojokyoProcessParameter paramter;
    private IHokokuShiryoSakuSeiMapper mapper;
    private ShinsahanteinoHenkojokyo henkojokyo;

    @BatchWriter
    private BatchReportWriter<ShinsahanteinoHenkojokyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsahanteinoHenkojokyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        henkojokyo = new ShinsahanteinoHenkojokyo();
        mapper = getMapper(IHokokuShiryoSakuSeiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HEADER, paramter.toShinsahanteinoHenkojokyoMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701006.getReportId().value())
                .addBreak(new BreakerCatalog<ShinsahanteinoHenkojokyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(SinsakaiHanteiJyokyoHeaderEntity headerJoho) {
        if (hasBrek(getBefore(), headerJoho)) {
            ShinsahanteinoHenkojokyoReport report = new ShinsahanteinoHenkojokyoReport(henkojokyo);
            report.writeBy(reportSourceWriter);
            henkojokyo = new ShinsahanteinoHenkojokyo();
        }
    }

    @Override
    protected void usualProcess(SinsakaiHanteiJyokyoHeaderEntity current) {
        setヘッダ情報(current);
        List<SinsakaiHanteiJyokyoEntity> 更新３ヶ月結果情報 = get判定結果情報(current, 更新申請, 有効期間3ヶ月);
        set更新申請３ヶ月(更新３ヶ月結果情報);
        List<SinsakaiHanteiJyokyoEntity> 更新６ヶ月結果情報 = get判定結果情報(current, 更新申請, 有効期間6ヶ月);
        set更新申請６ヶ月(更新６ヶ月結果情報);
        List<SinsakaiHanteiJyokyoEntity> 更新１２ヶ月結果情報 = get判定結果情報(current, 更新申請, 有効期間12ヶ月);
        set更新申請１２ヶ月(更新１２ヶ月結果情報);
        List<SinsakaiHanteiJyokyoEntity> 更新２４ヶ月結果情報 = get判定結果情報(current, 更新申請, 有効期間24ヶ月);
        set更新申請２４ヶ月(更新２４ヶ月結果情報);
        List<SinsakaiHanteiJyokyoEntity> 更新その他結果情報 = get判定結果情報(current, 更新申請, 有効期間その他);
        set更新申請その他(更新その他結果情報);
        set更新申請();
        List<SinsakaiHanteiJyokyoEntity> 新規３ヶ月結果情報 = get判定結果情報(current, 新規申請, 有効期間3ヶ月);
        List<SinsakaiHanteiJyokyoEntity> 新規６ヶ月結果情報 = get判定結果情報(current, 新規申請, 有効期間6ヶ月);
        List<SinsakaiHanteiJyokyoEntity> 新規１２ヶ月結果情報 = get判定結果情報(current, 新規申請, 有効期間12ヶ月);
        List<SinsakaiHanteiJyokyoEntity> 新規２４ヶ月結果情報 = get判定結果情報(current, 新規申請, 有効期間24ヶ月);
        List<SinsakaiHanteiJyokyoEntity> 新規その他結果情報 = get判定結果情報(current, 新規申請, 有効期間その他);
        List<SinsakaiHanteiJyokyoEntity> 区分変更３ヶ月結果情報 = get判定結果情報(current, 区分変更申請, 有効期間3ヶ月);
        List<SinsakaiHanteiJyokyoEntity> 区分変更６ヶ月結果情報 = get判定結果情報(current, 区分変更申請, 有効期間6ヶ月);
        List<SinsakaiHanteiJyokyoEntity> 区分変更１２ヶ月結果情報 = get判定結果情報(current, 区分変更申請, 有効期間12ヶ月);
        List<SinsakaiHanteiJyokyoEntity> 区分変更２４ヶ月結果情報 = get判定結果情報(current, 区分変更申請, 有効期間24ヶ月);
        List<SinsakaiHanteiJyokyoEntity> 区分変更その他結果情報 = get判定結果情報(current, 区分変更申請, 有効期間その他);
        set新規区分変更エリア(新規３ヶ月結果情報, 新規６ヶ月結果情報, 新規１２ヶ月結果情報, 新規２４ヶ月結果情報, 新規その他結果情報,
                区分変更３ヶ月結果情報, 区分変更６ヶ月結果情報, 区分変更１２ヶ月結果情報, 区分変更２４ヶ月結果情報, 区分変更その他結果情報);
        List<SinsakaiHanteiJyokyoEntity> 新規区分変更要支援要支援延長件数 = get有効期間延長件数情報(current, 新規区分変更申請, 要支援要支援);
        List<SinsakaiHanteiJyokyoEntity> 新規区分変更要支援要介護延長件数 = get有効期間延長件数情報(current, 新規区分変更申請, 要支援要介護);
        List<SinsakaiHanteiJyokyoEntity> 新規区分変更要介護要支援延長件数 = get有効期間延長件数情報(current, 新規区分変更申請, 要介護要支援);
        List<SinsakaiHanteiJyokyoEntity> 新規区分変更要介護要介護延長件数 = get有効期間延長件数情報(current, 新規区分変更申請, 要介護要介護);
        List<SinsakaiHanteiJyokyoEntity> 更新申請要支援要支援延長件数 = get有効期間延長件数情報(current, 更新申請, 要支援要支援);
        List<SinsakaiHanteiJyokyoEntity> 更新申請要支援要介護延長件数 = get有効期間延長件数情報(current, 更新申請, 要支援要介護);
        List<SinsakaiHanteiJyokyoEntity> 更新申請要介護要支援延長件数 = get有効期間延長件数情報(current, 更新申請, 要介護要支援);
        List<SinsakaiHanteiJyokyoEntity> 更新申請要介護要介護延長件数 = get有効期間延長件数情報(current, 更新申請, 要介護要介護);
        set認定有効期間延長件数(新規区分変更要支援要支援延長件数, 新規区分変更要支援要介護延長件数, 新規区分変更要介護要支援延長件数, 新規区分変更要介護要介護延長件数,
                更新申請要支援要支援延長件数, 更新申請要支援要介護延長件数, 更新申請要介護要支援延長件数, 更新申請要介護要介護延長件数);
    }

    @Override
    protected void afterExecute() {
        ShinsahanteinoHenkojokyoReport report = new ShinsahanteinoHenkojokyoReport(henkojokyo);
        report.writeBy(reportSourceWriter);
    }

    private boolean hasBrek(SinsakaiHanteiJyokyoHeaderEntity before, SinsakaiHanteiJyokyoHeaderEntity current) {
        return !(before.getGogitaiMei() == current.getGogitaiMei()
                && before.getShichosonCode().equals(current.getShichosonCode()));
    }

    private List<SinsakaiHanteiJyokyoEntity> get判定結果情報(
            SinsakaiHanteiJyokyoHeaderEntity current, RString 認定申請区分, int 認定有効期間) {
        ShinsahanteinoHenkojokyoMyBatisParameter batisParameter = paramter.toShinsahanteinoHenkojokyoMyBatisParameter();
        batisParameter.setGogitaiNo(current.getGogitaiNo());
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        batisParameter.setShichosonCode(current.getShichosonCode());
        batisParameter.setNinteiShinseiKubun(認定申請区分);
        batisParameter.setYukoKikan(認定有効期間);
        return mapper.getShinsahanteinoHenkojokyo(batisParameter);
    }

    private List<SinsakaiHanteiJyokyoEntity> get有効期間延長件数情報(
            SinsakaiHanteiJyokyoHeaderEntity current, RString 認定申請区分, RString 状態変更区分) {
        ShinsahanteinoHenkojokyoMyBatisParameter batisParameter = paramter.toShinsahanteinoHenkojokyoMyBatisParameter();
        batisParameter.setGogitaiNo(current.getGogitaiNo());
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        batisParameter.setShichosonCode(current.getShichosonCode());
        batisParameter.setNinteiShinseiKubun(認定申請区分);
        batisParameter.setJyotaiHenkoKubun(状態変更区分);
        batisParameter.setJissiZumi(実施済.equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援)));
        return mapper.getShinsahanteinoHenkojokyoYukoKikanEntyo(batisParameter);
    }

    private void setヘッダ情報(SinsakaiHanteiJyokyoHeaderEntity current) {
        henkojokyo.setタイトル(タイトル);
        henkojokyo.set合議体番号(new RString(current.getGogitaiNo()));
        henkojokyo.set合議体名称(current.getGogitaiMei());
        henkojokyo.set審査会開始年月日(current.getShinsakaiKaisaiYMDMin());
        henkojokyo.set審査会終了年月日(current.getShinsakaiKaisaiYMDMax());
        henkojokyo.set開催回数(new RString(current.getShinsakaiKaisaiNoCount()));
        henkojokyo.set市町村コード(current.getShichosonCode().value());
        henkojokyo.set市町村名(current.getShichosonMeisho());
        henkojokyo.set発行日時(RDateTime.now());
    }

    private void set更新申請() {
        henkojokyo.set更新申請_二次判定非該当(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定非該当().toString())));
        henkojokyo.set更新申請_二次判定要支援1(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要支援1().toString())));
        henkojokyo.set更新申請_二次判定要支援2(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要支援2().toString())));
        henkojokyo.set更新申請_二次判定要介護1(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護1().toString())));
        henkojokyo.set更新申請_二次判定要介護2(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護2().toString())));
        henkojokyo.set更新申請_二次判定要介護3(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護3().toString())));
        henkojokyo.set更新申請_二次判定要介護4(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護4().toString())));
        henkojokyo.set更新申請_二次判定要介護5(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護5().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護5().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護5().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護5().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護5().toString())));
        henkojokyo.set更新申請_計(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_計().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_計().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_計().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_計().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_計().toString())));
    }

    private void set更新申請３ヶ月(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_３ヶ月_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_３ヶ月_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_３ヶ月_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_３ヶ月_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_３ヶ月_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_３ヶ月_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_３ヶ月_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_３ヶ月_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_３ヶ月_計(new RString(Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_３ヶ月_二次判定要介護5().toString())));
    }

    private void set更新申請６ヶ月(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_６ヶ月_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_６ヶ月_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_６ヶ月_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_６ヶ月_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_６ヶ月_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_６ヶ月_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_６ヶ月_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_６ヶ月_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_６ヶ月_計(new RString(Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_６ヶ月_二次判定要介護5().toString())));
    }

    private void set更新申請１２ヶ月(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_１２ヶ月_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_１２ヶ月_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_１２ヶ月_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_１２ヶ月_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_１２ヶ月_計(new RString(Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_１２ヶ月_二次判定要介護5().toString())));
    }

    private void set更新申請２４ヶ月(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_２４ヶ月_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_２４ヶ月_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_２４ヶ月_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_２４ヶ月_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_２４ヶ月_計(new RString(Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_２４ヶ月_二次判定要介護5().toString())));
    }

    private void set更新申請その他(List<SinsakaiHanteiJyokyoEntity> 変更状況情報) {
        henkojokyo.set更新_その他_二次判定非該当(new RString(get被保険者数(変更状況情報, 非該当)));
        henkojokyo.set更新_その他_二次判定要支援1(new RString(get被保険者数(変更状況情報, 要支援1)));
        henkojokyo.set更新_その他_二次判定要支援2(new RString(get被保険者数(変更状況情報, 要支援2)));
        henkojokyo.set更新_その他_二次判定要介護1(new RString(get被保険者数(変更状況情報, 要介護1)));
        henkojokyo.set更新_その他_二次判定要介護2(new RString(get被保険者数(変更状況情報, 要介護2)));
        henkojokyo.set更新_その他_二次判定要介護3(new RString(get被保険者数(変更状況情報, 要介護3)));
        henkojokyo.set更新_その他_二次判定要介護4(new RString(get被保険者数(変更状況情報, 要介護4)));
        henkojokyo.set更新_その他_二次判定要介護5(new RString(get被保険者数(変更状況情報, 要介護5)));
        henkojokyo.set更新_その他_計(new RString(Integer.parseInt(henkojokyo.get更新_その他_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_その他_二次判定要介護5().toString())));
    }

    private void set認定有効期間延長件数(List<SinsakaiHanteiJyokyoEntity> 新規区分変更要支援要支援延長件数,
            List<SinsakaiHanteiJyokyoEntity> 新規区分変更要支援要介護延長件数,
            List<SinsakaiHanteiJyokyoEntity> 新規区分変更要介護要支援延長件数,
            List<SinsakaiHanteiJyokyoEntity> 新規区分変更要介護要介護延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請要支援要支援延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請要支援要介護延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請要介護要支援延長件数,
            List<SinsakaiHanteiJyokyoEntity> 更新申請要介護要介護延長件数) {
        int 新規区分要支援要支援要支援1 = get被保険者数(新規区分変更要支援要支援延長件数, 要支援1);
        int 新規区分要支援要支援要支援2 = get被保険者数(新規区分変更要支援要支援延長件数, 要支援2);
        int 新規区分要支援要支援要介護1 = get被保険者数(新規区分変更要支援要支援延長件数, 要介護1);
        int 新規区分要支援要支援要介護2 = get被保険者数(新規区分変更要支援要支援延長件数, 要介護3);
        int 新規区分要支援要支援要介護3 = get被保険者数(新規区分変更要支援要支援延長件数, 要介護4);
        int 新規区分要支援要支援要介護4 = get被保険者数(新規区分変更要支援要支援延長件数, 要介護4);
        int 新規区分要支援要支援要介護5 = get被保険者数(新規区分変更要支援要支援延長件数, 要介護5);
        int 新規区分要支援要介護要支援1 = get被保険者数(新規区分変更要支援要介護延長件数, 要支援1);
        int 新規区分要支援要介護要支援2 = get被保険者数(新規区分変更要支援要介護延長件数, 要支援2);
        int 新規区分要支援要介護要介護1 = get被保険者数(新規区分変更要支援要介護延長件数, 要介護1);
        int 新規区分要支援要介護要介護2 = get被保険者数(新規区分変更要支援要介護延長件数, 要介護3);
        int 新規区分要支援要介護要介護3 = get被保険者数(新規区分変更要支援要介護延長件数, 要介護4);
        int 新規区分要支援要介護要介護4 = get被保険者数(新規区分変更要支援要介護延長件数, 要介護4);
        int 新規区分要支援要介護要介護5 = get被保険者数(新規区分変更要支援要介護延長件数, 要介護5);
        int 新規区分要介護要支援要支援1 = get被保険者数(新規区分変更要介護要支援延長件数, 要支援1);
        int 新規区分要介護要支援要支援2 = get被保険者数(新規区分変更要介護要支援延長件数, 要支援2);
        int 新規区分要介護要支援要介護1 = get被保険者数(新規区分変更要介護要支援延長件数, 要介護1);
        int 新規区分要介護要支援要介護2 = get被保険者数(新規区分変更要介護要支援延長件数, 要介護3);
        int 新規区分要介護要支援要介護3 = get被保険者数(新規区分変更要介護要支援延長件数, 要介護4);
        int 新規区分要介護要支援要介護4 = get被保険者数(新規区分変更要介護要支援延長件数, 要介護4);
        int 新規区分要介護要支援要介護5 = get被保険者数(新規区分変更要介護要支援延長件数, 要介護5);
        int 新規区分要介護要介護要支援1 = get被保険者数(新規区分変更要介護要介護延長件数, 要支援1);
        int 新規区分要介護要介護要支援2 = get被保険者数(新規区分変更要介護要介護延長件数, 要支援2);
        int 新規区分要介護要介護要介護1 = get被保険者数(新規区分変更要介護要介護延長件数, 要介護1);
        int 新規区分要介護要介護要介護2 = get被保険者数(新規区分変更要介護要介護延長件数, 要介護3);
        int 新規区分要介護要介護要介護3 = get被保険者数(新規区分変更要介護要介護延長件数, 要介護4);
        int 新規区分要介護要介護要介護4 = get被保険者数(新規区分変更要介護要介護延長件数, 要介護4);
        int 新規区分要介護要介護要介護5 = get被保険者数(新規区分変更要介護要介護延長件数, 要介護5);
        int 更新申請要支援要支援要支援1 = get被保険者数(更新申請要支援要支援延長件数, 要支援1);
        int 更新申請要支援要支援要支援2 = get被保険者数(更新申請要支援要支援延長件数, 要支援2);
        int 更新申請要支援要介護要介護1 = get被保険者数(更新申請要支援要介護延長件数, 要介護1);
        int 更新申請要支援要介護要介護2 = get被保険者数(更新申請要支援要介護延長件数, 要介護3);
        int 更新申請要支援要介護要介護3 = get被保険者数(更新申請要支援要介護延長件数, 要介護4);
        int 更新申請要支援要介護要介護4 = get被保険者数(更新申請要支援要介護延長件数, 要介護4);
        int 更新申請要支援要介護要介護5 = get被保険者数(更新申請要支援要介護延長件数, 要介護5);
        int 更新申請要介護要支援要支援1 = get被保険者数(更新申請要介護要支援延長件数, 要支援1);
        int 更新申請要介護要支援要支援2 = get被保険者数(更新申請要介護要支援延長件数, 要支援2);
        int 更新申請要介護要介護要介護1 = get被保険者数(更新申請要介護要介護延長件数, 要介護1);
        int 更新申請要介護要介護要介護2 = get被保険者数(更新申請要介護要介護延長件数, 要介護3);
        int 更新申請要介護要介護要介護3 = get被保険者数(更新申請要介護要介護延長件数, 要介護4);
        int 更新申請要介護要介護要介護4 = get被保険者数(更新申請要介護要介護延長件数, 要介護4);
        int 更新申請要介護要介護要介護5 = get被保険者数(更新申請要介護要介護延長件数, 要介護5);
        henkojokyo.set更新_認定有効期間延長件数_二次判定非該当(なし);
        henkojokyo.set更新_認定有効期間延長件数_二次判定要支援1(new RString(更新申請要支援要支援要支援1 + 更新申請要介護要支援要支援1));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要支援2(new RString(更新申請要支援要支援要支援2 + 更新申請要介護要支援要支援2));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護1(new RString(更新申請要支援要介護要介護1 + 更新申請要介護要介護要介護1));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護2(new RString(更新申請要支援要介護要介護2 + 更新申請要介護要介護要介護2));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護3(new RString(更新申請要支援要介護要介護3 + 更新申請要介護要介護要介護3));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護4(new RString(更新申請要支援要介護要介護4 + 更新申請要介護要介護要介護4));
        henkojokyo.set更新_認定有効期間延長件数_二次判定要介護5(new RString(更新申請要支援要介護要介護5 + 更新申請要介護要介護要介護5));
        set更新_認定有効期間延長件数_計();
        henkojokyo.set新規_認定有効期間延長件数_二次判定非該当(なし);
        henkojokyo.set新規_認定有効期間延長件数_二次判定要支援1(new RString(
                新規区分要支援要支援要支援1 + 新規区分要支援要介護要支援1 + 新規区分要介護要支援要支援1 + 新規区分要介護要介護要支援1));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要支援2(new RString(
                新規区分要支援要支援要支援2 + 新規区分要支援要介護要支援2 + 新規区分要介護要支援要支援2 + 新規区分要介護要介護要支援2));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護1(new RString(
                新規区分要支援要支援要介護1 + 新規区分要支援要介護要介護1 + 新規区分要介護要支援要介護1 + 新規区分要介護要介護要介護1));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護2(new RString(
                新規区分要支援要支援要介護2 + 新規区分要支援要介護要介護2 + 新規区分要介護要支援要介護2 + 新規区分要介護要介護要介護2));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護3(new RString(
                新規区分要支援要支援要介護3 + 新規区分要支援要介護要介護3 + 新規区分要介護要支援要介護3 + 新規区分要介護要介護要介護3));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護4(new RString(
                新規区分要支援要支援要介護4 + 新規区分要支援要介護要介護4 + 新規区分要介護要支援要介護4 + 新規区分要介護要介護要介護4));
        henkojokyo.set新規_認定有効期間延長件数_二次判定要介護5(new RString(
                新規区分要支援要支援要介護5 + 新規区分要支援要介護要介護5 + 新規区分要介護要支援要介護5 + 新規区分要介護要介護要介護5));
        set新規_認定有効期間延長件数_計();
    }

    private void set更新_認定有効期間延長件数_計() {
        henkojokyo.set更新_認定有効期間延長件数_計(new RString(Integer.parseInt(henkojokyo.get更新_認定有効期間延長件数_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get更新_認定有効期間延長件数_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get更新_認定有効期間延長件数_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get更新_認定有効期間延長件数_二次判定要介護5().toString())));
    }

    private void set新規_認定有効期間延長件数_計() {
        henkojokyo.set新規_認定有効期間延長件数_計(new RString(Integer.parseInt(henkojokyo.get新規_認定有効期間延長件数_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get新規_認定有効期間延長件数_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get新規_認定有効期間延長件数_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get新規_認定有効期間延長件数_二次判定要介護5().toString())));
    }

    private void set新規区分変更エリア(List<SinsakaiHanteiJyokyoEntity> 新規３ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 新規６ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 新規１２ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 新規２４ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 新規その他結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更３ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更６ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更１２ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更２４ヶ月結果情報,
            List<SinsakaiHanteiJyokyoEntity> 区分変更その他結果情報) {
        int 新規３ヶ月非該当 = get被保険者数(新規３ヶ月結果情報, 非該当);
        int 新規３ヶ月要支援1 = get被保険者数(新規３ヶ月結果情報, 要支援1);
        int 新規３ヶ月要支援2 = get被保険者数(新規３ヶ月結果情報, 要支援2);
        int 新規３ヶ月要介護1 = get被保険者数(新規３ヶ月結果情報, 要介護1);
        int 新規３ヶ月要介護2 = get被保険者数(新規３ヶ月結果情報, 要介護2);
        int 新規３ヶ月要介護3 = get被保険者数(新規３ヶ月結果情報, 要介護3);
        int 新規３ヶ月要介護4 = get被保険者数(新規３ヶ月結果情報, 要介護4);
        int 新規３ヶ月要介護5 = get被保険者数(新規３ヶ月結果情報, 要介護5);
        int 新規６ヶ月非該当 = get被保険者数(新規６ヶ月結果情報, 非該当);
        int 新規６ヶ月要支援1 = get被保険者数(新規６ヶ月結果情報, 要支援1);
        int 新規６ヶ月要支援2 = get被保険者数(新規６ヶ月結果情報, 要支援2);
        int 新規６ヶ月要介護1 = get被保険者数(新規６ヶ月結果情報, 要介護1);
        int 新規６ヶ月要介護2 = get被保険者数(新規６ヶ月結果情報, 要介護2);
        int 新規６ヶ月要介護3 = get被保険者数(新規６ヶ月結果情報, 要介護3);
        int 新規６ヶ月要介護4 = get被保険者数(新規６ヶ月結果情報, 要介護4);
        int 新規６ヶ月要介護5 = get被保険者数(新規６ヶ月結果情報, 要介護5);
        int 新規１２ヶ月非該当 = get被保険者数(新規１２ヶ月結果情報, 非該当);
        int 新規１２ヶ月要支援1 = get被保険者数(新規１２ヶ月結果情報, 要支援1);
        int 新規１２ヶ月要支援2 = get被保険者数(新規１２ヶ月結果情報, 要支援2);
        int 新規１２ヶ月要介護1 = get被保険者数(新規１２ヶ月結果情報, 要介護1);
        int 新規１２ヶ月要介護2 = get被保険者数(新規１２ヶ月結果情報, 要介護2);
        int 新規１２ヶ月要介護3 = get被保険者数(新規１２ヶ月結果情報, 要介護3);
        int 新規１２ヶ月要介護4 = get被保険者数(新規１２ヶ月結果情報, 要介護4);
        int 新規１２ヶ月要介護5 = get被保険者数(新規１２ヶ月結果情報, 要介護5);
        int 新規２４ヶ月非該当 = get被保険者数(新規２４ヶ月結果情報, 非該当);
        int 新規２４ヶ月要支援1 = get被保険者数(新規２４ヶ月結果情報, 要支援1);
        int 新規２４ヶ月要支援2 = get被保険者数(新規２４ヶ月結果情報, 要支援2);
        int 新規２４ヶ月要介護1 = get被保険者数(新規２４ヶ月結果情報, 要介護1);
        int 新規２４ヶ月要介護2 = get被保険者数(新規２４ヶ月結果情報, 要介護2);
        int 新規２４ヶ月要介護3 = get被保険者数(新規２４ヶ月結果情報, 要介護3);
        int 新規２４ヶ月要介護4 = get被保険者数(新規２４ヶ月結果情報, 要介護4);
        int 新規２４ヶ月要介護5 = get被保険者数(新規２４ヶ月結果情報, 要介護5);
        int 新規その他非該当 = get被保険者数(新規その他結果情報, 非該当);
        int 新規その他要支援1 = get被保険者数(新規その他結果情報, 要支援1);
        int 新規その他要支援2 = get被保険者数(新規その他結果情報, 要支援2);
        int 新規その他要介護1 = get被保険者数(新規その他結果情報, 要介護1);
        int 新規その他要介護2 = get被保険者数(新規その他結果情報, 要介護2);
        int 新規その他要介護3 = get被保険者数(新規その他結果情報, 要介護3);
        int 新規その他要介護4 = get被保険者数(新規その他結果情報, 要介護4);
        int 新規その他要介護5 = get被保険者数(新規その他結果情報, 要介護5);
        int 区分３ヶ月非該当 = get被保険者数(区分変更３ヶ月結果情報, 非該当);
        int 区分３ヶ月要支援1 = get被保険者数(区分変更３ヶ月結果情報, 要支援1);
        int 区分３ヶ月要支援2 = get被保険者数(区分変更３ヶ月結果情報, 要支援2);
        int 区分３ヶ月要介護1 = get被保険者数(区分変更３ヶ月結果情報, 要介護1);
        int 区分３ヶ月要介護2 = get被保険者数(区分変更３ヶ月結果情報, 要介護2);
        int 区分３ヶ月要介護3 = get被保険者数(区分変更３ヶ月結果情報, 要介護3);
        int 区分３ヶ月要介護4 = get被保険者数(区分変更３ヶ月結果情報, 要介護4);
        int 区分３ヶ月要介護5 = get被保険者数(区分変更３ヶ月結果情報, 要介護5);
        int 区分６ヶ月非該当 = get被保険者数(区分変更６ヶ月結果情報, 非該当);
        int 区分６ヶ月要支援1 = get被保険者数(区分変更６ヶ月結果情報, 要支援1);
        int 区分６ヶ月要支援2 = get被保険者数(区分変更６ヶ月結果情報, 要支援2);
        int 区分６ヶ月要介護1 = get被保険者数(区分変更６ヶ月結果情報, 要介護1);
        int 区分６ヶ月要介護2 = get被保険者数(区分変更６ヶ月結果情報, 要介護2);
        int 区分６ヶ月要介護3 = get被保険者数(区分変更６ヶ月結果情報, 要介護3);
        int 区分６ヶ月要介護4 = get被保険者数(区分変更６ヶ月結果情報, 要介護4);
        int 区分６ヶ月要介護5 = get被保険者数(区分変更６ヶ月結果情報, 要介護5);
        int 区分１２ヶ月非該当 = get被保険者数(区分変更１２ヶ月結果情報, 非該当);
        int 区分１２ヶ月要支援1 = get被保険者数(区分変更１２ヶ月結果情報, 要支援1);
        int 区分１２ヶ月要支援2 = get被保険者数(区分変更１２ヶ月結果情報, 要支援2);
        int 区分１２ヶ月要介護1 = get被保険者数(区分変更１２ヶ月結果情報, 要介護1);
        int 区分１２ヶ月要介護2 = get被保険者数(区分変更１２ヶ月結果情報, 要介護2);
        int 区分１２ヶ月要介護3 = get被保険者数(区分変更１２ヶ月結果情報, 要介護3);
        int 区分１２ヶ月要介護4 = get被保険者数(区分変更１２ヶ月結果情報, 要介護4);
        int 区分１２ヶ月要介護5 = get被保険者数(区分変更１２ヶ月結果情報, 要介護5);
        int 区分２４ヶ月非該当 = get被保険者数(区分変更２４ヶ月結果情報, 非該当);
        int 区分２４ヶ月要支援1 = get被保険者数(区分変更２４ヶ月結果情報, 要支援1);
        int 区分２４ヶ月要支援2 = get被保険者数(区分変更２４ヶ月結果情報, 要支援2);
        int 区分２４ヶ月要介護1 = get被保険者数(区分変更２４ヶ月結果情報, 要介護1);
        int 区分２４ヶ月要介護2 = get被保険者数(区分変更２４ヶ月結果情報, 要介護2);
        int 区分２４ヶ月要介護3 = get被保険者数(区分変更２４ヶ月結果情報, 要介護3);
        int 区分２４ヶ月要介護4 = get被保険者数(区分変更２４ヶ月結果情報, 要介護4);
        int 区分２４ヶ月要介護5 = get被保険者数(区分変更２４ヶ月結果情報, 要介護5);
        int 区分その他非該当 = get被保険者数(区分変更その他結果情報, 非該当);
        int 区分その他要支援1 = get被保険者数(区分変更その他結果情報, 要支援1);
        int 区分その他要支援2 = get被保険者数(区分変更その他結果情報, 要支援2);
        int 区分その他要介護1 = get被保険者数(区分変更その他結果情報, 要介護1);
        int 区分その他要介護2 = get被保険者数(区分変更その他結果情報, 要介護2);
        int 区分その他要介護3 = get被保険者数(区分変更その他結果情報, 要介護3);
        int 区分その他要介護4 = get被保険者数(区分変更その他結果情報, 要介護4);
        int 区分その他要介護5 = get被保険者数(区分変更その他結果情報, 要介護5);
        henkojokyo.set新規申請_二次判定非該当(new RString(新規３ヶ月非該当 + 新規６ヶ月非該当 + 新規１２ヶ月非該当 + 新規２４ヶ月非該当 + 新規その他非該当));
        henkojokyo.set新規申請_二次判定要支援1(new RString(新規３ヶ月要支援1 + 新規６ヶ月要支援1 + 新規１２ヶ月要支援1 + 新規２４ヶ月要支援1 + 新規その他要支援1));
        henkojokyo.set新規申請_二次判定要支援2(new RString(新規３ヶ月要支援2 + 新規６ヶ月要支援2 + 新規１２ヶ月要支援2 + 新規２４ヶ月要支援2 + 新規その他要支援2));
        henkojokyo.set新規申請_二次判定要介護1(new RString(新規３ヶ月要介護1 + 新規６ヶ月要介護1 + 新規１２ヶ月要介護1 + 新規２４ヶ月要介護1 + 新規その他要介護1));
        henkojokyo.set新規申請_二次判定要介護2(new RString(新規３ヶ月要介護2 + 新規６ヶ月要介護2 + 新規１２ヶ月要介護2 + 新規２４ヶ月要介護2 + 新規その他要介護2));
        henkojokyo.set新規申請_二次判定要介護3(new RString(新規３ヶ月要介護3 + 新規６ヶ月要介護3 + 新規１２ヶ月要介護3 + 新規２４ヶ月要介護3 + 新規その他要介護3));
        henkojokyo.set新規申請_二次判定要介護4(new RString(新規３ヶ月要介護4 + 新規６ヶ月要介護4 + 新規１２ヶ月要介護4 + 新規２４ヶ月要介護4 + 新規その他要介護4));
        henkojokyo.set新規申請_二次判定要介護5(new RString(新規３ヶ月要介護5 + 新規６ヶ月要介護5 + 新規１２ヶ月要介護5 + 新規２４ヶ月要介護5 + 新規その他要介護5));
        set新規申請_計();
        henkojokyo.set新規_区分変更申請_二次判定非該当(new RString(区分３ヶ月非該当 + 区分６ヶ月非該当 + 区分１２ヶ月非該当 + 区分２４ヶ月非該当 + 区分その他非該当));
        henkojokyo.set新規_区分変更申請_二次判定要支援1(new RString(区分３ヶ月要支援1 + 区分６ヶ月要支援1 + 区分１２ヶ月要支援1 + 区分２４ヶ月要支援1 + 区分その他要支援1));
        henkojokyo.set新規_区分変更申請_二次判定要支援2(new RString(区分３ヶ月要支援2 + 区分６ヶ月要支援2 + 区分１２ヶ月要支援2 + 区分２４ヶ月要支援2 + 区分その他要支援2));
        henkojokyo.set新規_区分変更申請_二次判定要介護1(new RString(区分３ヶ月要介護1 + 区分６ヶ月要介護1 + 区分１２ヶ月要介護1 + 区分２４ヶ月要介護1 + 区分その他要介護1));
        henkojokyo.set新規_区分変更申請_二次判定要介護2(new RString(区分３ヶ月要介護2 + 区分６ヶ月要介護2 + 区分１２ヶ月要介護2 + 区分２４ヶ月要介護2 + 区分その他要介護2));
        henkojokyo.set新規_区分変更申請_二次判定要介護3(new RString(区分３ヶ月要介護3 + 区分６ヶ月要介護3 + 区分１２ヶ月要介護3 + 区分２４ヶ月要介護3 + 区分その他要介護3));
        henkojokyo.set新規_区分変更申請_二次判定要介護4(new RString(区分３ヶ月要介護4 + 区分６ヶ月要介護4 + 区分１２ヶ月要介護4 + 区分２４ヶ月要介護4 + 区分その他要介護4));
        henkojokyo.set新規_区分変更申請_二次判定要介護5(new RString(区分３ヶ月要介護5 + 区分６ヶ月要介護5 + 区分１２ヶ月要介護5 + 区分２４ヶ月要介護5 + 区分その他要介護5));
        set新規_区分変更申請_計();
        henkojokyo.set新規_３ヶ月_二次判定非該当(new RString(新規３ヶ月非該当 + 区分３ヶ月非該当));
        henkojokyo.set新規_３ヶ月_二次判定要支援1(new RString(新規３ヶ月要支援1 + 区分３ヶ月要支援1));
        henkojokyo.set新規_３ヶ月_二次判定要支援2(new RString(新規３ヶ月要支援2 + 区分３ヶ月要支援2));
        henkojokyo.set新規_３ヶ月_二次判定要介護1(new RString(新規３ヶ月要介護1 + 区分３ヶ月要介護1));
        henkojokyo.set新規_３ヶ月_二次判定要介護2(new RString(新規３ヶ月要介護2 + 区分３ヶ月要介護2));
        henkojokyo.set新規_３ヶ月_二次判定要介護3(new RString(新規３ヶ月要介護3 + 区分３ヶ月要介護3));
        henkojokyo.set新規_３ヶ月_二次判定要介護4(new RString(新規３ヶ月要介護4 + 区分３ヶ月要介護4));
        henkojokyo.set新規_３ヶ月_二次判定要介護5(new RString(新規３ヶ月要介護5 + 区分３ヶ月要介護5));
        set新規_３ヶ月_計();
        henkojokyo.set新規_６ヶ月_二次判定非該当(new RString(新規６ヶ月非該当 + 区分６ヶ月非該当));
        henkojokyo.set新規_６ヶ月_二次判定要支援1(new RString(新規６ヶ月要支援1 + 区分６ヶ月要支援1));
        henkojokyo.set新規_６ヶ月_二次判定要支援2(new RString(新規６ヶ月要支援2 + 区分６ヶ月要支援2));
        henkojokyo.set新規_６ヶ月_二次判定要介護1(new RString(新規６ヶ月要介護1 + 区分６ヶ月要介護1));
        henkojokyo.set新規_６ヶ月_二次判定要介護2(new RString(新規６ヶ月要介護2 + 区分６ヶ月要介護2));
        henkojokyo.set新規_６ヶ月_二次判定要介護3(new RString(新規６ヶ月要介護3 + 区分６ヶ月要介護3));
        henkojokyo.set新規_６ヶ月_二次判定要介護4(new RString(新規６ヶ月要介護4 + 区分６ヶ月要介護4));
        henkojokyo.set新規_６ヶ月_二次判定要介護5(new RString(新規６ヶ月要介護5 + 区分６ヶ月要介護5));
        set新規_６ヶ月_計();
        henkojokyo.set新規_１２ヶ月_二次判定非該当(new RString(新規１２ヶ月非該当 + 区分１２ヶ月非該当));
        henkojokyo.set新規_１２ヶ月_二次判定要支援1(new RString(新規１２ヶ月要支援1 + 区分１２ヶ月要支援1));
        henkojokyo.set新規_１２ヶ月_二次判定要支援2(new RString(新規１２ヶ月要支援2 + 区分１２ヶ月要支援2));
        henkojokyo.set新規_１２ヶ月_二次判定要介護1(new RString(新規１２ヶ月要介護1 + 区分１２ヶ月要介護1));
        henkojokyo.set新規_１２ヶ月_二次判定要介護2(new RString(新規１２ヶ月要介護2 + 区分１２ヶ月要介護2));
        henkojokyo.set新規_１２ヶ月_二次判定要介護3(new RString(新規１２ヶ月要介護3 + 区分１２ヶ月要介護3));
        henkojokyo.set新規_１２ヶ月_二次判定要介護4(new RString(新規１２ヶ月要介護4 + 区分１２ヶ月要介護4));
        henkojokyo.set新規_１２ヶ月_二次判定要介護5(new RString(新規１２ヶ月要介護5 + 区分１２ヶ月要介護5));
        set新規_１２ヶ月_計();
        henkojokyo.set新規_２４ヶ月_二次判定非該当(new RString(新規２４ヶ月非該当 + 区分２４ヶ月非該当));
        henkojokyo.set新規_２４ヶ月_二次判定要支援1(new RString(新規２４ヶ月要支援1 + 区分２４ヶ月要支援1));
        henkojokyo.set新規_２４ヶ月_二次判定要支援2(new RString(新規２４ヶ月要支援2 + 区分２４ヶ月要支援2));
        henkojokyo.set新規_２４ヶ月_二次判定要介護1(new RString(新規２４ヶ月要介護1 + 区分２４ヶ月要介護1));
        henkojokyo.set新規_２４ヶ月_二次判定要介護2(new RString(新規２４ヶ月要介護2 + 区分２４ヶ月要介護2));
        henkojokyo.set新規_２４ヶ月_二次判定要介護3(new RString(新規２４ヶ月要介護3 + 区分２４ヶ月要介護3));
        henkojokyo.set新規_２４ヶ月_二次判定要介護4(new RString(新規２４ヶ月要介護4 + 区分２４ヶ月要介護4));
        henkojokyo.set新規_２４ヶ月_二次判定要介護5(new RString(新規２４ヶ月要介護5 + 区分２４ヶ月要介護5));
        set新規_２４ヶ月_計();
        henkojokyo.set新規_その他_二次判定非該当(new RString(新規その他非該当 + 区分その他非該当));
        henkojokyo.set新規_その他_二次判定要支援1(new RString(新規その他要支援1 + 区分その他要支援1));
        henkojokyo.set新規_その他_二次判定要支援2(new RString(新規その他要支援2 + 区分その他要支援2));
        henkojokyo.set新規_その他_二次判定要介護1(new RString(新規その他要介護1 + 区分その他要介護1));
        henkojokyo.set新規_その他_二次判定要介護2(new RString(新規その他要介護2 + 区分その他要介護2));
        henkojokyo.set新規_その他_二次判定要介護3(new RString(新規その他要介護3 + 区分その他要介護3));
        henkojokyo.set新規_その他_二次判定要介護4(new RString(新規その他要介護4 + 区分その他要介護4));
        henkojokyo.set新規_その他_二次判定要介護5(new RString(新規その他要介護5 + 区分その他要介護5));
        set新規_その他_計();
    }

    private void set新規申請_計() {
        henkojokyo.set新規申請_計(new RString(Integer.parseInt(henkojokyo.get新規申請_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get新規申請_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get新規申請_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get新規申請_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get新規申請_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get新規申請_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get新規申請_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get新規申請_二次判定要介護5().toString())));
    }

    private void set新規_区分変更申請_計() {
        henkojokyo.set新規_区分変更申請_計(new RString(Integer.parseInt(henkojokyo.get新規_区分変更申請_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get新規_区分変更申請_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get新規_区分変更申請_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get新規_区分変更申請_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get新規_区分変更申請_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get新規_区分変更申請_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get新規_区分変更申請_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get新規_区分変更申請_二次判定要介護5().toString())));
    }

    private void set新規_３ヶ月_計() {
        henkojokyo.set新規_３ヶ月_計(new RString(Integer.parseInt(henkojokyo.get新規_３ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get新規_３ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get新規_３ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get新規_３ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get新規_３ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get新規_３ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get新規_３ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get新規_３ヶ月_二次判定要介護5().toString())));
    }

    private void set新規_６ヶ月_計() {
        henkojokyo.set新規_６ヶ月_計(new RString(Integer.parseInt(henkojokyo.get新規_６ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get新規_６ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get新規_６ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get新規_６ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get新規_６ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get新規_６ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get新規_６ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get新規_６ヶ月_二次判定要介護5().toString())));
    }

    private void set新規_１２ヶ月_計() {
        henkojokyo.set新規_１２ヶ月_計(new RString(Integer.parseInt(henkojokyo.get新規_１２ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get新規_１２ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get新規_１２ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get新規_１２ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get新規_１２ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get新規_１２ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get新規_１２ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get新規_１２ヶ月_二次判定要介護5().toString())));
    }

    private void set新規_２４ヶ月_計() {
        henkojokyo.set新規_２４ヶ月_計(new RString(Integer.parseInt(henkojokyo.get新規_２４ヶ月_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get新規_２４ヶ月_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get新規_２４ヶ月_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get新規_２４ヶ月_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get新規_２４ヶ月_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get新規_２４ヶ月_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get新規_２４ヶ月_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get新規_２４ヶ月_二次判定要介護5().toString())));
    }

    private void set新規_その他_計() {
        henkojokyo.set新規_その他_計(new RString(Integer.parseInt(henkojokyo.get新規_その他_二次判定非該当().toString())
                + Integer.parseInt(henkojokyo.get新規_その他_二次判定要支援1().toString())
                + Integer.parseInt(henkojokyo.get新規_その他_二次判定要支援2().toString())
                + Integer.parseInt(henkojokyo.get新規_その他_二次判定要介護1().toString())
                + Integer.parseInt(henkojokyo.get新規_その他_二次判定要介護2().toString())
                + Integer.parseInt(henkojokyo.get新規_その他_二次判定要介護3().toString())
                + Integer.parseInt(henkojokyo.get新規_その他_二次判定要介護4().toString())
                + Integer.parseInt(henkojokyo.get新規_その他_二次判定要介護5().toString())));
    }

    private int get被保険者数(List<SinsakaiHanteiJyokyoEntity> 判定状況, RString 二次判定要介護状態区分コード) {
        for (SinsakaiHanteiJyokyoEntity sinsakaiHanteiJyokyoEntity : 判定状況) {
            if (二次判定要介護状態区分コード.equals(sinsakaiHanteiJyokyoEntity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
                return sinsakaiHanteiJyokyoEntity.getHihokenshaCount();
            }
        }
        return 0;
    }
}
