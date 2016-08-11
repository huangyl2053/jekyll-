/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5320001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd550003.YokaigodoHenkoTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5320001.NinteiKekkaTsutishoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.YokaigodoHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiIkatusHakkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * バッチ設計_DBD5320001_要介護度変更通知書発行_process処理クラスです。
 *
 * @reamsid_L DBD-1430-020 lit
 */
public class YokaigoHenkoTsutishoProcess extends BatchProcessBase<YokaigoNinteiIkatusHakkoEntity> {

    private static final RString MYBATIS_MAPPER_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteijoho."
                    + "IYokaigoNinteiTsutishoMapper.get一括発行要介護度変更通知書情報");

    private NinteiKekkaTsutishoProcessParameter parameter;

    private static final ReportIdDBD REPORT_ID = ReportIdDBD.DBD550003;

    private YokaigoNinteiIkatusHakkoEntity 最新Entity;
    private YokaigoNinteiIkatusHakkoEntity 最新以外Entity;
    private int index = 0;

    @BatchWriter
    private BatchPermanentTableWriter<DbT4001JukyushaDaichoEntity> dbT4001tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7022tableWriter;
    @BatchWriter
    private BatchReportWriter<YokaigodoHenkoTshuchishoReportSource> batchReportWrite;
    private ReportSourceWriter<YokaigodoHenkoTshuchishoReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_MAPPER_ID, parameter.toTsutishoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT4001tableWriter = new BatchPermanentTableWriter<>(DbT4001JukyushaDaichoEntity.class);
        dbT7022tableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
        batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(YokaigoNinteiIkatusHakkoEntity entity) {
        if (null == 最新Entity) {
            最新Entity = entity;
        } else {
            最新以外Entity = entity;
        }
    }

    @Override
    protected void afterExecute() {
        if (null == 最新Entity) {
            return;
        }

        YokaigodoHenkoTshuchishoReport report = createYokaigodoHenkoTshuchishoReport();
        report.writeBy(reportSourceWriter);

        DbT4001JukyushaDaichoEntity jukyushaDaichoEntity = createJukyushaDaichoEntity();
        dbT4001tableWriter.insert(jukyushaDaichoEntity);

        DbT7022ShoriDateKanriEntity shoriDateKanriEntity = createShoriDateKanriEntity();
        dbT7022tableWriter.insert(shoriDateKanriEntity);

        バッチ出力条件リストの出力();
    }

    private DbT7022ShoriDateKanriEntity createShoriDateKanriEntity() {
        // TODO. コピーしたデータの意味はわからない。
        DbT7022ShoriDateKanriEntity result = new DbT7022ShoriDateKanriEntity();
        return result;
    }

    private DbT4001JukyushaDaichoEntity createJukyushaDaichoEntity() {
        DbT4001JukyushaDaichoEntity result = 最新Entity.get受給者台帳Entity();
        result.setRirekiNo(new RString(String.format("%04d", Integer.parseInt(result.getRirekiNo().toString()) + 1)));
        result.setNinteiKekkaTsuchishoHakkoYMD(parameter.get発行日());
        return result;
    }

    private YokaigodoHenkoTshuchishoReport createYokaigodoHenkoTshuchishoReport() {
        YokaigodoHenkoTsuchishoEntity reportEntity = createYokaigodoHenkoTsuchishoEntity();
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, REPORT_ID.getReportId(),
                parameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        YokaigodoHenkoTshuchishoReport report
                = new YokaigodoHenkoTshuchishoReport(reportEntity, TsutishoHakkoCommonProcess.get帳票共通情報(REPORT_ID.getReportId()), ninshoshaSource);
        return report;
    }

    private YokaigodoHenkoTsuchishoEntity createYokaigodoHenkoTsuchishoEntity() {
        ChohyoSeigyoKyotsu 帳票共通情報 = TsutishoHakkoCommonProcess.get帳票共通情報(REPORT_ID.getReportId());
        FlexibleDate 発行日 = parameter.get発行日();
        SofubutsuAtesakiSource 送付物宛先情報 = TsutishoHakkoCommonProcess.get送付物宛先情報(帳票共通情報);

        YokaigodoHenkoTsuchishoEntity printEntity = new YokaigodoHenkoTsuchishoEntity();

        printEntity.setBunshoNo(TsutishoHakkoCommonProcess.get文書番号(parameter.get文書番号(), REPORT_ID.getReportId(), 発行日));
        printEntity.setTitle(TsutishoHakkoCommonProcess.getタイトル(ConfigNameDBA.サービス変更通知書));
        printEntity.setTsuchibun1(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_1,
                        TsutishoHakkoCommonProcess.通知文_項目番号_1)
                .concat(TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_1,
                                TsutishoHakkoCommonProcess.通知文_項目番号_2)));
        printEntity.setTsuchibun2(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_1,
                        TsutishoHakkoCommonProcess.通知文_項目番号_3));
        printEntity.setTsuchibun3(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_1,
                        TsutishoHakkoCommonProcess.通知文_項目番号_4));
        printEntity.setTsuchibun4(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_1,
                        TsutishoHakkoCommonProcess.通知文_項目番号_5));
        AtenaMeisho 被保険者氏名 = 最新Entity.get被保険者氏名();
        printEntity.setHihokenshaName(null != 被保険者氏名 ? 被保険者氏名.value() : RString.EMPTY);
        RString 被保険者番号 = 最新Entity.get被保険者番号();
        if (null != 被保険者番号 && !被保険者番号.isEmpty()) {
            printEntity.setHihokenshaNo1(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo2(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo3(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo4(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo5(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo6(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo7(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo8(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo9(get被保険者番号の某桁(被保険者番号));
            printEntity.setHihokenshaNo10(get被保険者番号の某桁(被保険者番号));
            index = 0;
        }
        printEntity.setKosho1(new RString("今までの要介護状態区分"));
        printEntity.setKosho2(new RString("これからの要介護状態区分"));
        printEntity.setBeforeYokaigoKubun(TsutishoHakkoCommonProcess.getサービス種類(最新以外Entity));
        printEntity.setAfterYokaigoKubun(TsutishoHakkoCommonProcess.getサービス種類(最新Entity));
        printEntity.setHenkoYmd(最新Entity.get認定年月日());
        printEntity.setYukoKaishiYMD(最新Entity.get認定有効期間開始年月日());
        printEntity.setYukoShuryoYMD(最新Entity.get認定有効期間終了年月日());
        printEntity.setKigenKosho(new RString("被保険者証提出期限"));
        printEntity.setKigenYMD(FlexibleDate.EMPTY);

        printEntity.setTsuchibun5(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_2,
                        TsutishoHakkoCommonProcess.通知文_項目番号_5));
        printEntity.setTsuchibun6(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_3,
                        TsutishoHakkoCommonProcess.通知文_項目番号_5));
        printEntity.setTsuchibun7(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_3,
                        TsutishoHakkoCommonProcess.通知文_項目番号_6));
        printEntity.setTsuchibun8(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_4,
                        TsutishoHakkoCommonProcess.通知文_項目番号_5));
        printEntity.setTsuchibun9(
                TsutishoHakkoCommonProcess.get通知文情報通知文(REPORT_ID.getReportId(), TsutishoHakkoCommonProcess.通知文_パターン番号_4,
                        TsutishoHakkoCommonProcess.通知文_項目番号_6));
        printEntity.setYubinNo(送付物宛先情報.yubinNo);
        printEntity.setGyoseiku(送付物宛先情報.gyoseiku);
        printEntity.setJushoText(送付物宛先情報.jushoText);
        printEntity.setJusho1(送付物宛先情報.jusho1);
        printEntity.setJusho2(送付物宛先情報.jusho2);
        printEntity.setJusho3(送付物宛先情報.jusho3);
        printEntity.setKatagakiText(送付物宛先情報.katagakiText);
        printEntity.setKatagaki1(送付物宛先情報.katagaki1);
        printEntity.setKatagaki2(送付物宛先情報.katagaki2);
        printEntity.setKatagakiSmall1(送付物宛先情報.katagakiSmall1);
        printEntity.setKatagakiSmall2(送付物宛先情報.katagakiSmall2);
        printEntity.setDainoKubunMei(送付物宛先情報.dainoKubunMei);
        printEntity.setShimeiText(送付物宛先情報.shimeiText);
        printEntity.setShimei1(送付物宛先情報.shimei1);
        printEntity.setShimei2(送付物宛先情報.shimei2);
        printEntity.setShimeiSmall1(送付物宛先情報.shimeiSmall1);
        printEntity.setShimeiSmall2(送付物宛先情報.shimeiSmall2);
        printEntity.setSamabunShimeiText(送付物宛先情報.samabunShimeiText);
        printEntity.setSamabunShimei1(送付物宛先情報.samabunShimei1);
        printEntity.setSamabunShimei2(送付物宛先情報.samabunShimei2);
        printEntity.setSamabunShimeiSmall1(送付物宛先情報.samabunShimeiSmall1);
        printEntity.setSamabunShimeiSmall2(送付物宛先情報.samabunShimeiSmall2);
        printEntity.setMeishoFuyo1(送付物宛先情報.meishoFuyo1);
        printEntity.setMeishoFuyo2(送付物宛先情報.meishoFuyo2);
        printEntity.setSamaBun1(送付物宛先情報.samaBun1);
        printEntity.setSamaBun2(送付物宛先情報.samaBun2);
        printEntity.setKakkoLeft1(送付物宛先情報.kakkoLeft1);
        printEntity.setKakkoLeft2(送付物宛先情報.kakkoLeft2);
        printEntity.setKakkoRight1(送付物宛先情報.kakkoRight1);
        printEntity.setKakkoRight2(送付物宛先情報.kakkoRight2);
        printEntity.setCustomerBarCode(送付物宛先情報.customerBarCode);
        return printEntity;
    }

    private RString get被保険者番号の某桁(RString 被保険者番号) {
        index = index + 1;
        return 被保険者番号.substring(index - 1, index);
    }

    private void バッチ出力条件リストの出力() {
        Association association = TsutishoHakkoCommonProcess.get地方公共団体();
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString CSV出力有無 = new RString("無し");
        RString CSVファイル名 = new RString("無し");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        if (null != parameter.get開始日時() && !parameter.get開始日時().isEmpty()) {
            builder.append(new RString("今回の開始日時:"));
            builder.append(parameter.get開始日時());
            出力条件.add(builder.toRString());
        }
        if (null != parameter.get終了日時() && !parameter.get終了日時().isEmpty()) {
            builder.append(new RString("今回の終了日時:"));
            builder.append(parameter.get終了日時());
            出力条件.add(builder.toRString());
        }
        if (null != parameter.get文書番号() && !parameter.get文書番号().isEmpty()) {
            builder.append(new RString("文書番号:"));
            builder.append(parameter.get文書番号());
            出力条件.add(builder.toRString());
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                REPORT_ID.getReportId().value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                REPORT_ID.getReportName(),
                出力ページ数,
                CSV出力有無,
                CSVファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
