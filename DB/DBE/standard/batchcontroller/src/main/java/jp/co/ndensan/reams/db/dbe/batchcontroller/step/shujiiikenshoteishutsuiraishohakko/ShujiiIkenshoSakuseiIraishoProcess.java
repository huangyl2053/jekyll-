/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
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
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 帳票「主治医意見書作成依頼書」の出力バッチフ処理クラスです
 */
public class ShujiiIkenshoSakuseiIraishoProcess extends BatchProcessBase<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper."
            + "get主治医意見書提出依頼書発行");
    private static final ReportId 帳票ID = ReportIdDBE.DBE230001.getReportId();
    private static final RString 文字列0 = new RString("0");
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString 敬称_様 = new RString("様");
    private static final RString 敬称_殿 = new RString("殿");
    private static final RString 記号_星 = new RString("*");
    private static final RString 年号_明治 = new RString("明");
    private static final RString 年号_大正 = new RString("大");
    private static final RString 年号_昭和 = new RString("昭");
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
    private int 宛名連番 = 1;
    private int 連番 = 1;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
    private IShujiiIkenshoTeishutsuIraishoHakkoMapper mapper;
    private ShujiiIkenshoSakuseiIraishoItem item;
    private List<ShujiiIkenshoSakuseiIraishoItem> itemList;
    private ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter processParamter;

    @BatchWriter
    private BatchReportWriter<ShujiiIkenshoSakuseiIraishoReportSource> batchWriter;
    private ReportSourceWriter<ShujiiIkenshoSakuseiIraishoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IShujiiIkenshoTeishutsuIraishoHakkoMapper.class);
        itemList = new ArrayList<>();
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
        setShujiiIkenshoSakuseiIraishoItem(entity);
        itemList.add(item);
    }

    @Override
    protected void afterExecute() {
        if (itemList != null && !itemList.isEmpty()) {
            ShujiiIkenshoSakuseiIraishoReport report = ShujiiIkenshoSakuseiIraishoReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private void setShujiiIkenshoSakuseiIraishoItem(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        item = new ShujiiIkenshoSakuseiIraishoItem();
        set認証者情報();
        item.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, 帳票ID, FlexibleDate.getNowDate()));
        item.setYubinNo1(entity.get医療機関郵便番号());
        item.setJushoText(entity.get医療機関住所());
        item.setKikanNameText(entity.get医療機関名称());
        item.setShimeiText(entity.get主治医氏名());
        RString key = BusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称, SubGyomuCode.DBE認定支援);
        if (文字列0.equals(key)) {
            item.setMeishoFuyo(RString.EMPTY);
        }
        if (文字列1.equals(key)) {
            item.setMeishoFuyo(敬称_様);
        }
        if (文字列2.equals(key)) {
            item.setMeishoFuyo(敬称_殿);
        }
        item.setCustomerBarCode(getカスタマーバーコード(entity));
        item.setSonota(entity.get被保険者氏名());
        get宛名連番();
        item.setTitle(ReportIdDBE.DBE230001.getReportName());
        Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, 帳票ID, KamokuCode.EMPTY, 1);
        item.setTsuchibun1(通知文Map.get(1));
        item.setShinseiKubun(NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分申請時コード()).toRString());
        RString hihokenshaNo = entity.get被保険者番号();
        if (!RString.isNullOrEmpty(hihokenshaNo) && INT10 <= hihokenshaNo.length()) {
            item.setHihokenshaNo1(entity.get被保険者番号().substring(0, 1));
            item.setHihokenshaNo2(entity.get被保険者番号().substring(1, 2));
            item.setHihokenshaNo3(entity.get被保険者番号().substring(2, INT3));
            item.setHihokenshaNo4(entity.get被保険者番号().substring(INT3, INT4));
            item.setHihokenshaNo5(entity.get被保険者番号().substring(INT4, INT5));
            item.setHihokenshaNo6(entity.get被保険者番号().substring(INT5, INT6));
            item.setHihokenshaNo7(entity.get被保険者番号().substring(INT6, INT7));
            item.setHihokenshaNo8(entity.get被保険者番号().substring(INT7, INT8));
            item.setHihokenshaNo9(entity.get被保険者番号().substring(INT8, INT9));
            item.setHihokenshaNo10(entity.get被保険者番号().substring(INT9, INT10));
        }
        RString hokenshaNo = entity.get証記載保険者番号();
        if (!RString.isNullOrEmpty(hokenshaNo) && INT5 <= hokenshaNo.length()) {
            item.setHokenshaNo1(hokenshaNo.substring(0, 1));
            item.setHokenshaNo2(hokenshaNo.substring(1, 2));
            item.setHokenshaNo3(hokenshaNo.substring(2, INT3));
            item.setHokenshaNo4(hokenshaNo.substring(INT3, INT4));
            item.setHokenshaNo5(hokenshaNo.substring(INT4, INT5));
            item.setHokenshaNo6(hokenshaNo.substring(INT5, INT6));
        }
        item.setHihokenshaNameKana(entity.get被保険者氏名カナ());
        if (Seibetsu.男.getコード().equals(entity.get性別())) {
            item.setSeibetsuWoman(記号_星);
        }
        if (Seibetsu.女.getコード().equals(entity.get性別())) {
            item.setSeibetsuMan(記号_星);
        }
        item.setHihokenshaName(entity.get被保険者氏名());
        get年号(new FlexibleDate(entity.get生年月日()));
        item.setBirthYMD(get和暦(entity.get生年月日(), false));
        RString 郵便番号 = entity.get郵便番号();
        if (!RString.isNullOrEmpty(郵便番号)) {
            item.setYubinNo(new YubinNo(entity.get郵便番号()).getEditedYubinNo());
        }
        item.setJusho(entity.get住所());
        item.setShinseiYMD(get和暦(entity.get認定申請年月日(), true));
        set提出期限(entity);
        item.setTsuchibun1(通知文Map.get(2));
        item.setShoriName(IkenshoIraiKubun.toValue(entity.get主治医意見書依頼区分()).get名称());
    }

    private void get宛名連番() {
        RStringBuilder builder = new RStringBuilder();
        builder.append("*");
        builder.append((new RString(String.valueOf(宛名連番++))).padLeft(文字列0, INT6));
        builder.append("#");
        item.setAtenaRenban(builder.toRString());
        item.setRemban(new RString(String.valueOf(連番++)));
    }

    private void set提出期限(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        if (文字列1.equals(BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援))) {
            if (文字列0.equals(processParamter.getTeishutsuKigen())) {
                int 期限日数 = Integer.parseInt(BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                        SubGyomuCode.DBE認定支援).toString());
                FlexibleDate 提出期限 = entity.get主治医意見書作成期限年月日().plusDay(期限日数);
                item.setTeishutsuKigen(get和暦(new RString(提出期限.toString()), true));
            } else if (文字列1.equals(processParamter.getTeishutsuKigen())) {
                item.setTeishutsuKigen(RString.EMPTY);
            } else if (文字列2.equals(processParamter.getTeishutsuKigen())) {
                item.setTeishutsuKigen(!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())
                        ? get和暦(processParamter.getKyotsuHizuke(), true) : RString.EMPTY);
            }
        } else {
            FlexibleDate 主治医意見書作成期限日 = entity.get主治医意見書作成期限年月日();
            if (主治医意見書作成期限日 != null && !主治医意見書作成期限日.isEmpty()) {
                item.setTeishutsuKigen(get和暦(new RString(主治医意見書作成期限日.toString()), true));
            }
        }
    }

    private RString get和暦(RString 日付, boolean 年号フラグ) {
        RString 和暦 = RString.EMPTY;
        if (!RString.isNullOrEmpty(日付)) {
            FlexibleDate flexibleDate = new FlexibleDate(日付);
            if (年号フラグ) {
                和暦 = flexibleDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            } else {
                和暦 = flexibleDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().substring(2);
            }
        }
        return 和暦;
    }

    private void get年号(FlexibleDate 生年月日) {
        RString 年号 = 生年月日.wareki().toDateString();
        if (年号.startsWith(年号_明治)) {
            item.setBirthGengoShowa(記号_星);
            item.setBirthGengoTaisho(記号_星);
        } else if (年号.startsWith(年号_大正)) {
            item.setBirthGengoMeiji(記号_星);
            item.setBirthGengoShowa(記号_星);
        } else if (年号.startsWith(年号_昭和)) {
            item.setBirthGengoMeiji(記号_星);
            item.setBirthGengoTaisho(記号_星);
        } else {
            item.setBirthGengoMeiji(記号_星);
            item.setBirthGengoShowa(記号_星);
            item.setBirthGengoTaisho(記号_星);
        }
    }

    private void set認証者情報() {
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                帳票ID,
                new FlexibleDate(processParamter.getHakkobi()),
                reportSourceWriter);
        item.setHakkoYMD1(ninshoshaSource.hakkoYMD);
        item.setDenshiKoin(ninshoshaSource.denshiKoin);
        item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
        item.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
        item.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
    }

    private void update認定調査依頼情報(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        DbT5301ShujiiIkenshoIraiJohoEntity dbT5301Entity = new DbT5301ShujiiIkenshoIraiJohoEntity();
        dbT5301Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbT5301Entity.setIkenshoIraiRirekiNo(entity.get最大依頼履歴番号());
        dbT5301Entity.setLogicalDeletedFlag(false);
        RString iraiToYMD = processParamter.getIraiToYMD();
        if (!RString.isNullOrEmpty(iraiToYMD)) {
            dbT5301Entity.setIraishoShutsuryokuYMD(new FlexibleDate(iraiToYMD));
            dbT5301Entity.setIkenshoShutsuryokuYMD(new FlexibleDate(iraiToYMD));
        }
        RString 主治医意見書作成期限設定方法 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援);
        if (文字列1.equals(主治医意見書作成期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                            SubGyomuCode.DBE認定支援).toString());
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

    private RString getカスタマーバーコード(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        RString カスタマーバーコード = RString.EMPTY;
        CustomerBarCode barCode = new CustomerBarCode();
        RString 被保険者郵便番号 = entity.get医療機関郵便番号();
        RString 住所 = entity.get医療機関住所();
        if (!RString.isNullOrEmpty(被保険者郵便番号) && !RString.isNullOrEmpty(住所)) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(被保険者郵便番号, 住所);
            if (result != null) {
                カスタマーバーコード = result.getCustomerBarCode();
            }
        }
        return カスタマーバーコード;
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
            builder.append(gridParameter.getNinteichosaItakusakiCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(ISHINO);
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
                ReportIdDBE.DBE230001.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
