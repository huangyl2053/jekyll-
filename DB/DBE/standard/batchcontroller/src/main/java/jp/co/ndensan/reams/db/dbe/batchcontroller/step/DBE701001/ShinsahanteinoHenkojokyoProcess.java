package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.ShinsahanteinoHenkojokyoEditor;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyo;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.ShinsahanteinoHenkojokyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsahanteinoHenkojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 審査判定の変更状況の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsahanteinoHenkojokyoProcess extends BatchProcessBase<SinsakaiHanteiJyokyoHeaderEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getShinsahanteinoHenkojokyoHeader");
    private static final RString タイトル = new RString("認定審査会審査判定状況");
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
    private static final RString 実施済 = new RString("2");
    private static final RString 全合議体 = new RString("全合議体");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString 全市町村コード = new RString("000000");
    private ShinsahanteinoHenkojokyoProcessParameter paramter;
    private IHokokuShiryoSakuSeiMapper mapper;
    private ShinsahanteinoHenkojokyo henkojokyo;
    private boolean isデータあり;
    private boolean is実施済;

    @BatchWriter
    private BatchReportWriter<ShinsahanteinoHenkojokyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsahanteinoHenkojokyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        isデータあり = false;
        is実施済 = 実施済.equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
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
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(SinsakaiHanteiJyokyoHeaderEntity current) {
        if (0 != current.getShinsakaiKaisaiNoCount()) {
            isデータあり = true;
            setヘッダ情報(current);
            ShinsahanteinoHenkojokyoEditor editor = new ShinsahanteinoHenkojokyoEditor(henkojokyo);
            List<SinsakaiHanteiJyokyoEntity> 更新３ヶ月結果情報 = get判定結果情報(current, 更新申請, 有効期間3ヶ月);
            editor.set更新申請３ヶ月(更新３ヶ月結果情報);
            List<SinsakaiHanteiJyokyoEntity> 更新６ヶ月結果情報 = get判定結果情報(current, 更新申請, 有効期間6ヶ月);
            editor.set更新申請６ヶ月(更新６ヶ月結果情報);
            List<SinsakaiHanteiJyokyoEntity> 更新１２ヶ月結果情報 = get判定結果情報(current, 更新申請, 有効期間12ヶ月);
            editor.set更新申請１２ヶ月(更新１２ヶ月結果情報);
            List<SinsakaiHanteiJyokyoEntity> 更新２４ヶ月結果情報 = get判定結果情報(current, 更新申請, 有効期間24ヶ月);
            editor.set更新申請２４ヶ月(更新２４ヶ月結果情報);
            List<SinsakaiHanteiJyokyoEntity> 更新その他結果情報 = get判定結果情報(current, 更新申請, 有効期間その他);
            editor.set更新申請その他(更新その他結果情報);
            editor.set更新申請();
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
            editor.set新規区分変更エリア(新規３ヶ月結果情報, 新規６ヶ月結果情報, 新規１２ヶ月結果情報, 新規２４ヶ月結果情報, 新規その他結果情報,
                    区分変更３ヶ月結果情報, 区分変更６ヶ月結果情報, 区分変更１２ヶ月結果情報, 区分変更２４ヶ月結果情報, 区分変更その他結果情報);
            List<SinsakaiHanteiJyokyoEntity> 新規区分変更延長件数 = get有効期間延長件数情報(current, 新規区分変更申請, RString.EMPTY);
            if (is実施済) {
                List<SinsakaiHanteiJyokyoEntity> 更新申請延長件数 = get有効期間延長件数情報(current, 更新申請, RString.EMPTY);
                editor.set認定有効期間延長件数(新規区分変更延長件数, 更新申請延長件数);
            } else {
                List<SinsakaiHanteiJyokyoEntity> 更新申請要支援要支援延長件数 = get有効期間延長件数情報(current, 更新申請, 要支援要支援);
                List<SinsakaiHanteiJyokyoEntity> 更新申請要支援要介護延長件数 = get有効期間延長件数情報(current, 更新申請, 要支援要介護);
                List<SinsakaiHanteiJyokyoEntity> 更新申請要介護要支援延長件数 = get有効期間延長件数情報(current, 更新申請, 要介護要支援);
                List<SinsakaiHanteiJyokyoEntity> 更新申請要介護要介護延長件数 = get有効期間延長件数情報(current, 更新申請, 要介護要介護);
                editor.set認定有効期間延長件数(新規区分変更延長件数, 更新申請要支援要支援延長件数,
                        更新申請要支援要介護延長件数, 更新申請要介護要支援延長件数, 更新申請要介護要介護延長件数);
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            ShinsahanteinoHenkojokyoReport report = new ShinsahanteinoHenkojokyoReport(henkojokyo);
            report.writeBy(reportSourceWriter);
        }
        outputJokenhyo();
    }

    private List<SinsakaiHanteiJyokyoEntity> get判定結果情報(
            SinsakaiHanteiJyokyoHeaderEntity current, RString 認定申請区分, int 認定有効期間) {
        ShinsahanteinoHenkojokyoMyBatisParameter batisParameter = paramter.toShinsahanteinoHenkojokyoMyBatisParameter();
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        batisParameter.setNinteiShinseiKubun(認定申請区分);
        batisParameter.setYukoKikan(認定有効期間);
        return mapper.getShinsahanteinoHenkojokyo(batisParameter);
    }

    private List<SinsakaiHanteiJyokyoEntity> get有効期間延長件数情報(
            SinsakaiHanteiJyokyoHeaderEntity current, RString 認定申請区分, RString 状態変更区分) {
        ShinsahanteinoHenkojokyoMyBatisParameter batisParameter = paramter.toShinsahanteinoHenkojokyoMyBatisParameter();
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        batisParameter.setNinteiShinseiKubun(認定申請区分);
        batisParameter.setJyotaiHenkoKubun(状態変更区分);
        batisParameter.setJissiZumi(is実施済);
        return mapper.getShinsahanteinoHenkojokyoYukoKikanEntyo(batisParameter);
    }

    private void setヘッダ情報(SinsakaiHanteiJyokyoHeaderEntity current) {
        henkojokyo.setタイトル(タイトル);
        if (paramter.isEmptyGogitaiNo()) {
            henkojokyo.set合議体名称(全合議体);
        } else {
            henkojokyo.set合議体番号(new RString(paramter.getGogitaiNo()));
            henkojokyo.set合議体名称(paramter.getGogitaiName());
        }
        henkojokyo.set審査会開始年月日(current.getShinsakaiKaisaiYMDMin());
        henkojokyo.set審査会終了年月日(current.getShinsakaiKaisaiYMDMax());
        henkojokyo.set開催回数(new RString(current.getShinsakaiKaisaiNoCount()));
        if (RString.isNullOrEmpty(paramter.getShichosonCode().value())) {
            henkojokyo.set市町村名(全市町村);
            henkojokyo.set市町村コード(全市町村コード);
        } else {
            henkojokyo.set市町村名(paramter.getShichosonName());
            henkojokyo.set市町村コード(paramter.getShichosonCode().value());
        }
        henkojokyo.set発行日時(RDateTime.now());
    }

    private void outputJokenhyo() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE701006.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                タイトル,
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
        条件.append(paramter.isJigyoJyokyoHokoku() ? RString.EMPTY : HihokenshaKubun.toValue(
                paramter.getHihokenshaKubun()).get名称());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(GOGITAINO);
        条件.append(paramter.isJigyoJyokyoHokoku() ? RString.EMPTY : new RString(paramter.getGogitaiNo()));
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

}
