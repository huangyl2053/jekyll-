/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
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
    private static final RString 文字列1 = new RString("1");
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
    private final RString 汎用キー_文書番号 = new RString("文書番号");
    private static final RString 主治医意見書作成依頼書 = new RString("主治医意見書作成依頼書");
    private IShujiiIkenshoTeishutsuIraishoHakkoMapper mapper;
    private ShujiiIkenshoSakuseiIraishoItem item;
    private ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter processParamter;
    private static RString 通知文1 = RString.EMPTY;
    private static RString 通知文2 = RString.EMPTY;

    @BatchWriter
    private BatchReportWriter<ShujiiIkenshoSakuseiIraishoReportSource> batchWriter;
    private ReportSourceWriter<ShujiiIkenshoSakuseiIraishoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IShujiiIkenshoTeishutsuIraishoHakkoMapper.class);
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
        get通知書定型文();
        setShujiiIkenshoSakuseiIraishoItem(entity);

    }

    @Override
    protected void afterExecute() {
        if (item != null) {
            ShujiiIkenshoSakuseiIraishoReport report = ShujiiIkenshoSakuseiIraishoReport.createFrom(item);
            report.writeBy(reportSourceWriter);
        }
    }

    private void setShujiiIkenshoSakuseiIraishoItem(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        item = new ShujiiIkenshoSakuseiIraishoItem();
        set出力項目();
        item.setTitle(主治医意見書作成依頼書);
        item.setTsuchibun1(通知文1);
        item.setTsuchibun1(通知文2);
        item.setBunshoNo(get文書番号());
        item.setHakkoYMD1(processParamter.getHakkobi());
        item.setAtenaRenban(文字列1);
        item.setCustomerBarCode(getカスタマーバーコード(entity));
        //TODO 内部QA789　下記の項目取得
        item.setYubinNo1(new RString("宛名郵便番号"));
        item.setJushoText(new RString("宛名住所"));
        item.setKikanNameText(new RString("宛名機関名"));
        item.setShimeiText(new RString("宛名氏名"));
        item.setMeishoFuyo(new RString("宛名名称付与"));
        item.setSonota(RString.EMPTY);
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
        item.setHihokenshaNameKana(entity.get被保険者氏名カナ());
        item.setHihokenshaName(entity.get被保険者氏名());
        item.setJusho(entity.get住所());
        item.setBirthYMD(entity.get生年月日());
        item.setYubinNo(new YubinNo(entity.get郵便番号()).getEditedYubinNo());
//        RString hokenshaNo = processParamter.getHihokenshaNo();
//        if (!RString.isNullOrEmpty(hokenshaNo) && INT5 <= hokenshaNo.length()) {
//            item.setHokenshaNo1(processParamter.getHihokenshaNo().substring(0, 1));
//            item.setHokenshaNo2(processParamter.getHihokenshaNo().substring(1, 2));
//            item.setHokenshaNo3(processParamter.getHihokenshaNo().substring(2, INT3));
//            item.setHokenshaNo4(processParamter.getHihokenshaNo().substring(INT3, INT4));
//            item.setHokenshaNo5(processParamter.getHihokenshaNo().substring(INT4, INT5));
//        }
        item.setShinseiKubun(NinteiShinseiShinseijiKubunCode.toValue(entity.get申請区分コード()).toRString());
        item.setRemban(文字列1);
    }

    private void set出力項目() {
        NinshoshaSource ninshoshaSource = get認証者();
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
        RString hakkobi = processParamter.getHakkobi();
        if (!RString.isNullOrEmpty(hakkobi)) {
            dbT5301Entity.setIraishoShutsuryokuYMD(new FlexibleDate(hakkobi));
            dbT5301Entity.setIkenshoShutsuryokuYMD(new FlexibleDate(hakkobi));
        }
        RString 主治医意見書作成期限設定方法 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援);
        if (文字列1.equals(主治医意見書作成期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                            SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 作成依頼日 = entity.get主治医意見書作成依頼年月日();
                    if (作成依頼日 != null && !作成依頼日.isEmpty()) {
                        dbT5301Entity.setIkenshoSakuseiKigenYMD(作成依頼日.plusDay(期限日数));
                    }
                    break;
                case "1":
                    dbT5301Entity.setIkenshoSakuseiKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
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
        //TODO 内部QA789　郵便番号の取得方式
        RString 被保険者郵便番号 = entity.get郵便番号();
        RString 住所 = entity.get医療機関所在地();
        if (RString.isNullOrEmpty(被保険者郵便番号) && RString.isNullOrEmpty(住所)) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(被保険者郵便番号, 住所);
            if (result != null) {
                カスタマーバーコード = result.getCustomerBarCode();
            }
        }
        return カスタマーバーコード;
    }

    private NinshoshaSource get認証者() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        INinshoshaManager iNinshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = iNinshoshaManager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                new FlexibleDate(processParamter.getHakkobi()));
        INinshoshaSourceBuilder iNinshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(ninshosha,
                association,
                reportSourceWriter.getImageFolderPath(),
                new RDate(processParamter.getHakkobi().toString()),
                true,
                true,
                KenmeiFuyoKubunType.付与なし);
        return iNinshoshaSourceBuilder.buildSource();
    }

    private void get通知書定型文() {
        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchishoTeikeibunManager.get通知書定型文項目(SubGyomuCode.DBE認定支援,
                帳票ID, KamokuCode.EMPTY, 1);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBE認定支援, 帳票ID);
        List<TsuchishoTeikeibunEntity> tsuchishoTeikeibunList = tsuchishoTeikeibunInfo.get通知書定型文List();
        int 項目番号;
        for (TsuchishoTeikeibunEntity tsuchishoTeikeibun : tsuchishoTeikeibunList) {
            項目番号 = tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentenceNo();
            if (項目番号 == 1) {
                通知文1 = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            } else if (項目番号 == 2) {
                通知文2 = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            }
        }
    }

    private RString get文書番号() {
        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = bushoFineder.get文書番号管理(帳票ID, FlexibleDate.getNowDate());
        RString 文書番号 = RString.EMPTY;
        if (bushoNo != null) {
            RString 文書番号発番方法 = bushoNo.get文書番号発番方法();
            if (BunshoNoHatsubanHoho.固定.getCode().equalsIgnoreCase(文書番号発番方法)) {
                文書番号 = bushoNo.edit文書番号();
            } else if (BunshoNoHatsubanHoho.手入力.getCode().equalsIgnoreCase(文書番号発番方法)) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("文書番号情報の取得"));
            } else if (BunshoNoHatsubanHoho.自動採番.getCode().equalsIgnoreCase(文書番号発番方法)) {
                CountedItem 採番 = Saiban.get(SubGyomuCode.DBE認定支援, 汎用キー_文書番号, new FlexibleYear(RDate.getNowDate().getYear().toDateString()));
                文書番号 = bushoNo.edit文書番号(採番.nextString());
            }
        }
        return 文書番号;
    }
}
