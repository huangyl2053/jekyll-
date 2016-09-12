/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 要介護認定調査票（基本調査）の帳票DBE221012出力処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class ChosahyoKihonchosaProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final ReportId 帳票ID = ReportIdDBE.DBE221012.getReportId();
    private static final RString CONFIGVALUE = new RString("1");
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
    private static final RString IRAIFROMYMD = new RString("【依頼開始日】");
    private static final RString IRAITOYMD = new RString("【依頼終了日】");
    private static final RString NINTEIOCHOSAIRAISHO = new RString("【認定調査依頼書印刷区分】");
    private static final RString NINTEICHOSAHYO = new RString("【認定調査票印刷区分】");
    private static final RString NINTEICHOSAIRAILIST = new RString("【認定調査依頼リスト】");
    private static final RString NINTEICHOSAITAKUSAKICODE = new RString("　　【認定調査委託先コード】");
    private static final RString NINTEICHOSAINCODE = new RString("　　【認定調査員コード】");
    private static final RString SHOKISAIHOKENSHANO = new RString("　　【証記載保険者番号】");
    private static final RString HAKKOBI = new RString("【発行日】");
    private static final RString TEISHUTSUKIGEN = new RString("【提出期限】");
    private static final RString KYOTSUHIZUKE = new RString("【共通日付】");
    private static final RString NINTEICHOSAIRAISYO = new RString("【認定調査依頼書出力区分】");
    private static final RString NINTEICHOSAHYOKIHON = new RString("【認定調査票(基本調査)出力区分】");
    private static final RString NINTEICHOSAHYOTOKKI = new RString("【認定調査票(特記事項)出力区分】");
    private static final RString NINTEICHOSAHYOGAIKYOU = new RString("【認定調査票(概況調査)出力区分】");
    private static final RString NINTEICHOSAHYOOCRKIHON = new RString("【認定調査票OCR(基本調査)出力区分】");
    private static final RString NINTEICHOSAHYOOCRTOKKI = new RString("【認定調査票OCR(特記事項)出力区分】");
    private static final RString NINTEICHOSAHYOOCRGAIKYOU = new RString("【認定調査票OCR(概況調査)出力区分】");
    private static final RString NINTEICHOSACHECKHYO = new RString("【認定調査差異チェック表出力区分】");
    private static final RString NINTEICHOSAIRAICHOHYO = new RString("【認定調査依頼一覧表出力区分】");
    private static final RString ZENKONINTEICHOSAHYO = new RString("【前回認定調査結果との比較表出力区分】");
    private RString 被保険者番号1;
    private RString 被保険者番号2;
    private RString 被保険者番号3;
    private RString 被保険者番号4;
    private RString 被保険者番号5;
    private RString 被保険者番号6;
    private RString 被保険者番号7;
    private RString 被保険者番号8;
    private RString 被保険者番号9;
    private RString 被保険者番号10;
    private RString 証記載保険者番号1;
    private RString 証記載保険者番号2;
    private RString 証記載保険者番号3;
    private RString 証記載保険者番号4;
    private RString 証記載保険者番号5;
    private RString 証記載保険者番号6;
    private RString 申請年1;
    private RString 申請年2;
    private RString 申請月1;
    private RString 申請月2;
    private RString 申請日1;
    private RString 申請日2;
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private List<ChosahyoKihonchosaKatamenItem> itemList;
    private HomonChosaIraishoProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ChosahyoKihonchosaKatamenReportSource> batchReportWriter;
    private ReportSourceWriter<ChosahyoKihonchosaKatamenReportSource> reportSourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201EntityWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        itemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        dbT5201EntityWriter = new BatchPermanentTableWriter(DbT5201NinteichosaIraiJohoEntity.class);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        update認定調査依頼情報(entity);
        itemList.add(setChosahyoKihonchosaKatamenItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (itemList != null && !itemList.isEmpty()) {
            ChosahyoKihonchosaKatamenReport report = ChosahyoKihonchosaKatamenReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private ChosahyoKihonchosaKatamenItem setChosahyoKihonchosaKatamenItem(HomonChosaIraishoRelateEntity entity) {
        get被保険者番号(entity);
        get証記載保険者番号(entity);
        get申請日(entity);
        return new ChosahyoKihonchosaKatamenItem(
                被保険者番号1,
                被保険者番号2,
                被保険者番号3,
                被保険者番号4,
                被保険者番号5,
                被保険者番号6,
                被保険者番号7,
                被保険者番号8,
                被保険者番号9,
                被保険者番号10,
                申請年1,
                申請年2,
                申請月1,
                申請月2,
                申請日1,
                申請日2,
                証記載保険者番号1,
                証記載保険者番号2,
                証記載保険者番号3,
                証記載保険者番号4,
                証記載保険者番号5,
                証記載保険者番号6);
    }

    private void get申請日(HomonChosaIraishoRelateEntity entity) {
        申請年1 = RString.EMPTY;
        申請年2 = RString.EMPTY;
        申請月1 = RString.EMPTY;
        申請月2 = RString.EMPTY;
        申請日1 = RString.EMPTY;
        申請日2 = RString.EMPTY;
        RString 申請日 = entity.get認定申請年月日();
        if (!RString.isNullOrEmpty(申請日)) {
            RString shiseiYMD = new FlexibleDate(申請日).wareki().eraType(EraType.KANJI).toDateString();
            申請年1 = shiseiYMD.substring(2, INT3);
            申請年2 = shiseiYMD.substring(INT3, INT4);
            申請月1 = shiseiYMD.substring(INT5, INT6);
            申請月2 = shiseiYMD.substring(INT6, INT7);
            申請日1 = shiseiYMD.substring(INT8, INT9);
            申請日2 = shiseiYMD.substring(INT9, INT10);
        }
    }

    private void get被保険者番号(HomonChosaIraishoRelateEntity entity) {
        被保険者番号1 = RString.EMPTY;
        被保険者番号2 = RString.EMPTY;
        被保険者番号3 = RString.EMPTY;
        被保険者番号4 = RString.EMPTY;
        被保険者番号5 = RString.EMPTY;
        被保険者番号6 = RString.EMPTY;
        被保険者番号7 = RString.EMPTY;
        被保険者番号8 = RString.EMPTY;
        被保険者番号9 = RString.EMPTY;
        被保険者番号10 = RString.EMPTY;
        RString 被保険者番号 = entity.get被保険者番号();
        if (!RString.isNullOrEmpty(被保険者番号) && INT10 <= 被保険者番号.length()) {
            被保険者番号1 = 被保険者番号.substring(0, 1);
            被保険者番号2 = 被保険者番号.substring(1, 2);
            被保険者番号3 = 被保険者番号.substring(2, INT3);
            被保険者番号4 = 被保険者番号.substring(INT3, INT4);
            被保険者番号5 = 被保険者番号.substring(INT4, INT5);
            被保険者番号6 = 被保険者番号.substring(INT5, INT6);
            被保険者番号7 = 被保険者番号.substring(INT6, INT7);
            被保険者番号8 = 被保険者番号.substring(INT7, INT8);
            被保険者番号9 = 被保険者番号.substring(INT8, INT9);
            被保険者番号10 = 被保険者番号.substring(INT9, INT10);
        }
    }

    private void get証記載保険者番号(HomonChosaIraishoRelateEntity entity) {
        証記載保険者番号1 = RString.EMPTY;
        証記載保険者番号2 = RString.EMPTY;
        証記載保険者番号3 = RString.EMPTY;
        証記載保険者番号4 = RString.EMPTY;
        証記載保険者番号5 = RString.EMPTY;
        証記載保険者番号6 = RString.EMPTY;
        RString 証記載保険者番号 = entity.get証記載保険者番号();
        if (!RString.isNullOrEmpty(証記載保険者番号) && INT6 <= 証記載保険者番号.length()) {
            証記載保険者番号1 = 証記載保険者番号.substring(0, 1);
            証記載保険者番号2 = 証記載保険者番号.substring(1, 2);
            証記載保険者番号3 = 証記載保険者番号.substring(2, INT3);
            証記載保険者番号4 = 証記載保険者番号.substring(INT3, INT4);
            証記載保険者番号5 = 証記載保険者番号.substring(INT4, INT5);
            証記載保険者番号6 = 証記載保険者番号.substring(INT5, INT6);
        }
    }

    private void update認定調査依頼情報(HomonChosaIraishoRelateEntity entity) {

        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = iHomonChosaIraishoMapper.get認定調査依頼情報(entity);
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE.equals(認定調査期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, RDate.getNowDate(),
                            SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 認定調査依頼日 = entity.get認定調査依頼年月日();
                    if (認定調査依頼日 != null && !認定調査依頼日.isEmpty()) {
                        dbT5201Entity.setNinteichosaKigenYMD(認定調査依頼日.plusDay(期限日数));
                    }
                    break;
                case "1":
                    dbT5201Entity.setNinteichosaKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        dbT5201Entity.setNinteichosaKigenYMD(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        RString hakkobi = processParamter.getHakkobi();
        if (!RString.isNullOrEmpty(hakkobi)) {
            dbT5201Entity.setChosahyoTouShutsuryokuYMD(new FlexibleDate(hakkobi));
        } else {
            dbT5201Entity.setChosahyoTouShutsuryokuYMD(FlexibleDate.EMPTY);
        }
        dbT5201EntityWriter.update(dbT5201Entity);
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
        builder.append(NINTEIOCHOSAIRAISHO);
        builder.append(processParamter.getNinteioChosaIraisho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYO);
        builder.append(processParamter.getNinteiChosahyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAILIST);
        出力条件.add(builder.toRString());
        List<GridParameter> ninteiChosaIraiList = processParamter.getNinteiChosaIraiList();
        for (GridParameter gridParameter : ninteiChosaIraiList) {
            builder = new RStringBuilder();
            builder.append(NINTEICHOSAITAKUSAKICODE);
            builder.append(gridParameter.getNinteichosaItakusakiCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(NINTEICHOSAINCODE);
            builder.append(gridParameter.getNinteiChosainCode());
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
        builder.append(NINTEICHOSAIRAICHOHYO);
        builder.append(processParamter.isNinteiChosaIraiChohyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAISYO);
        builder.append(processParamter.isNinteiChosaIraisyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOKIHON);
        builder.append(processParamter.isNinteiChosahyoKihon());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOTOKKI);
        builder.append(processParamter.isNinteiChosahyoTokki());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOGAIKYOU);
        builder.append(processParamter.isNinteiChosahyoGaikyou());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRKIHON);
        builder.append(processParamter.isNinteiChosahyoOCRKihon());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRTOKKI);
        builder.append(processParamter.isNinteiChosahyoOCRTokki());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRGAIKYOU);
        builder.append(processParamter.isNinteiChosahyoOCRGaikyou());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSACHECKHYO);
        builder.append(processParamter.isNinteiChosaCheckHyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(ZENKONINTEICHOSAHYO);
        builder.append(processParamter.isZenkoNinteiChosahyo());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                ReportIdDBE.DBE221012.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
