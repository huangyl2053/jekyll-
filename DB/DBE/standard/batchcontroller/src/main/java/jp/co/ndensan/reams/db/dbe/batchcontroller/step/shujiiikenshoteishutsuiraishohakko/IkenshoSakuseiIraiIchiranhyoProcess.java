/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票「主治医意見書作成依頼一覧表」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
public class IkenshoSakuseiIraiIchiranhyoProcess extends BatchProcessBase<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper."
            + "get主治医意見書提出依頼書発行");
    private static final ReportId 帳票ID = ReportIdDBE.DBE230002.getReportId();
    private static final RString 文字列0 = new RString("0");
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString IRAIFROMYMD = new RString("【依頼開始日】");
    private static final RString IRAITOYMD = new RString("【依頼終了日】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAI = new RString("【主治医意見書作成依頼印刷区分】");
    private static final RString SHUJIIIKENSHO = new RString("【意見書印刷区分】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAILIST = new RString("【主治医意見書作成依頼リスト】");
    private static final RString SHUJIIIRYOKIKANCODE = new RString("　　【主治医医療機関コード】");
    private static final RString ISHINO = new RString("　　【主治医コード】");
    private static final RString SHOKISAIHOKENSHANO = new RString("　　【証記載保険者番号】");
    private static final RString HAKKOBI = new RString("【発行日】");
    private static final RString TEISHUTSUKIGEN = new RString("【提出期限】");
    private static final RString KYOTSUHIZUKE = new RString("【共通日付】");
    private static final RString IKENSHOSAKUSEIIRAI = new RString("【主治医意見書作成依頼一覧表出力区分】");
    private static final RString IKENSHOSAKUSEISEIKYUU = new RString("【主治医意見書作成料請求一覧表出力区分】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAISHO = new RString("【主治医意見書作成依頼書出力区分】");
    private static final RString IKENSHOKINYUU = new RString("【主治医意見書記入用紙出力区分】");
    private static final RString IKENSHOKINYUUOCR = new RString("【主治医意見書記入用紙OCR出力区分】");
    private static final RString IKENSHOSAKUSEISEIKYUUSHO = new RString("【主治医意見書作成料請求書出力区分】");
    private static final RString IKENSHOTEISHUTU = new RString("【介護保険指定医依頼兼主治医意見書提出意見依頼書出力区分】");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private RDate 基準日;
    private RString 郵便番号 = RString.EMPTY;
    private RString 住所 = RString.EMPTY;
    private RString 機関名称 = RString.EMPTY;
    private RString 氏名 = RString.EMPTY;
    private IShujiiIkenshoTeishutsuIraishoHakkoMapper mapper;
    private List<IkenshoSakuseiIraiIchiranhyoItem> bodyItemList;
    private ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter processParamter;

    @BatchWriter
    private BatchReportWriter<IkenshoSakuseiIraiIchiranhyoReportSource> batchWriter;
    private ReportSourceWriter<IkenshoSakuseiIraiIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IShujiiIkenshoTeishutsuIraishoHakkoMapper.class);
        bodyItemList = new ArrayList<>();
        基準日 = RDate.getNowDate();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        update認定調査依頼情報(entity);
        郵便番号 = entity.get医療機関郵便番号();
        住所 = entity.get医療機関住所();
        機関名称 = entity.get医療機関名称();
        氏名 = entity.get代表者名();
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            IkenshoSakuseiIraiIchiranhyoReport report = IkenshoSakuseiIraiIchiranhyoReport.createFrom(bodyItemList);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private IkenshoSakuseiIraiIchiranhyoItem setBodyItem(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                帳票ID,
                new FlexibleDate(processParamter.getHakkobi()),
                reportSourceWriter);
        Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, 帳票ID, KamokuCode.EMPTY, 1);
        return new IkenshoSakuseiIraiIchiranhyoItem(
                ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.koinShoryaku,
                郵便番号,
                住所,
                機関名称,
                氏名,
                get名称付与(),
                get印刷日時(),
                通知文Map.get(1),
                entity.get主治医氏名(),
                entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get被保険者氏名カナ(),
                entity.get住所(),
                get和暦(entity.get生年月日()),
                Seibetsu.toValue(entity.get性別()).get名称(),
                get提出期限(entity));
    }

    private RString get提出期限(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        RString 提出期限 = RString.EMPTY;
        if (文字列1.equals(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, 基準日, SubGyomuCode.DBE認定支援))) {
            if (文字列0.equals(processParamter.getTeishutsuKigen())) {
                int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                        基準日, SubGyomuCode.DBE認定支援).toString());
                提出期限 = get和暦(new RString(entity.get主治医意見書作成期限年月日().plusDay(期限日数).toString()));
            } else if (文字列1.equals(processParamter.getTeishutsuKigen())) {
                提出期限 = RString.EMPTY;
            } else if (文字列2.equals(processParamter.getTeishutsuKigen())) {
                提出期限 = !RString.isNullOrEmpty(processParamter.getKyotsuHizuke())
                        ? get和暦(processParamter.getKyotsuHizuke()) : RString.EMPTY;
            }
        } else {
            FlexibleDate 主治医意見書作成期限日 = entity.get主治医意見書作成期限年月日();
            if (主治医意見書作成期限日 != null && !主治医意見書作成期限日.isEmpty()) {
                提出期限 = get和暦(new RString(主治医意見書作成期限日.toString()));
            }
        }
        return 提出期限;
    }

    private RString get印刷日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        return printTimeStampSb.toRString();
    }

    private RString get名称付与() {
        RString key = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称, 基準日, SubGyomuCode.DBE認定支援);
        RString 名称付与 = RString.EMPTY;
        if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
            名称付与 = RString.EMPTY;
        }
        if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
            名称付与 = ChohyoAtesakiKeisho.様.get名称();
        }
        if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
            名称付与 = ChohyoAtesakiKeisho.殿.get名称();
        }
        return 名称付与;
    }

    private RString get和暦(RString 日付) {
        RString 和暦 = RString.EMPTY;
        if (!RString.isNullOrEmpty(日付)) {
            FlexibleDate flexibleDate = new FlexibleDate(日付);
            和暦 = flexibleDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 和暦;
    }

    private void update認定調査依頼情報(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        DbT5301ShujiiIkenshoIraiJohoEntity dbT5301Entity = new DbT5301ShujiiIkenshoIraiJohoEntity();
        dbT5301Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbT5301Entity.setIkenshoIraiRirekiNo(entity.get最大依頼履歴番号());
        dbT5301Entity.setLogicalDeletedFlag(false);
        RString hakkobi = processParamter.getHakkobi();
        if (!RString.isNullOrEmpty(hakkobi)) {
            dbT5301Entity.setIraishoShutsuryokuYMD(new FlexibleDate(hakkobi));
            dbT5301Entity.setIkenshoShutsuryokuYMD(new FlexibleDate(hakkobi));
        }
        RString 主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, 基準日, SubGyomuCode.DBE認定支援);
        if (文字列1.equals(主治医意見書作成期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                            基準日, SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 作成依頼日 = entity.get主治医意見書作成依頼年月日();
                    dbT5301Entity.setIkenshoSakuseiKigenYMD(作成依頼日.plusDay(期限日数));
                    break;
                case "1":
                    dbT5301Entity.setIkenshoSakuseiKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        dbT5301Entity.setIkenshoSakuseiKigenYMD(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        mapper.update主治医意見書作成依頼情報(dbT5301Entity);
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("－");
        RString ジョブ番号 = new RString("56");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(IRAIFROMYMD);
        builder.append(processParamter.getIraiFromYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IRAITOYMD);
        builder.append(processParamter.getIraiToYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAI);
        builder.append(processParamter.getShujiiikenshoSakuseiIrai());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHO);
        builder.append(processParamter.getShujiiIkensho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAILIST);
        出力条件.add(builder.toRString());
        List<GridParameter> shujiiIkenshoSakuseiIraiList = processParamter.getShujiiIkenshoSakuseiIraiList();
        for (GridParameter gridParameter : shujiiIkenshoSakuseiIraiList) {
            builder = new RStringBuilder();
            builder.append(SHUJIIIRYOKIKANCODE);
            builder.append(gridParameter.getShujiiIryoKikanCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(ISHINO);
            builder.append(gridParameter.getIshiNo());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(SHOKISAIHOKENSHANO);
            builder.append(gridParameter.getShoKisaiHokenshaNo());
            出力条件.add(builder.toRString());
        }
        builder = new RStringBuilder();
        builder.append(HAKKOBI);
        builder.append(processParamter.getHakkobi());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TEISHUTSUKIGEN);
        builder.append(processParamter.getTeishutsuKigen());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(KYOTSUHIZUKE);
        builder.append(processParamter.getKyotsuHizuke());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEIIRAI);
        builder.append(processParamter.isIkenshoSakuseiirai());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEISEIKYUU);
        builder.append(processParamter.isIkenshoSakuseiSeikyuu());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAISHO);
        builder.append(processParamter.isShujiiIkenshoSakuseiIraisho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOKINYUU);
        builder.append(processParamter.isIkenshoKinyuu());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOKINYUUOCR);
        builder.append(processParamter.isIkenshoKinyuuOCR());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEISEIKYUUSHO);
        builder.append(processParamter.isIkenshoSakuseiSeikyuusho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOTEISHUTU);
        builder.append(processParamter.isIkenshoTeishutu());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                ReportIdDBE.DBE230002.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
