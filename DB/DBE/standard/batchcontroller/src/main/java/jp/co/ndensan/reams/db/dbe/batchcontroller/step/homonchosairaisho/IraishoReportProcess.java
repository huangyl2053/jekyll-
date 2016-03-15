/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
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
 * 訪問調査依頼書発行_バッチフ処理クラスです
 */
public class IraishoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final ReportId 帳票ID = ReportIdDBE.DBE220001.getReportId();
    private static final RString CONFIGVALUE = new RString("1");
    private static final RString 年号_明治 = new RString("明");
    private static final RString 年号_大正 = new RString("大");
    private static final RString 年号_昭和 = new RString("昭");
    private static final RString 記号_星 = new RString("*");
    private final RString 汎用キー_文書番号 = new RString("文書番号");
    private static final RString 文字列1 = new RString("1");
    private static final int HIHOKENSHANOLENGTH = 10;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
//    private static final RString CSV出力有無 = new RString("なし");
//    private static final RString CSVファイル名 = new RString("-");
    private static RString 被保険者番号1 = RString.EMPTY;
    private static RString 被保険者番号2 = RString.EMPTY;
    private static RString 被保険者番号3 = RString.EMPTY;
    private static RString 被保険者番号4 = RString.EMPTY;
    private static RString 被保険者番号5 = RString.EMPTY;
    private static RString 被保険者番号6 = RString.EMPTY;
    private static RString 被保険者番号7 = RString.EMPTY;
    private static RString 被保険者番号8 = RString.EMPTY;
    private static RString 被保険者番号9 = RString.EMPTY;
    private static RString 被保険者番号10 = RString.EMPTY;
    private static RString 通知文1 = RString.EMPTY;
    private static RString 通知文2 = RString.EMPTY;
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private ChosaIraishoHeadItem chosaIraishoHeadItem;
    private HomonChosaIraishoProcessParamter processParamter;
    private RString 誕生日明治;
    private RString 誕生日大正;
    private RString 誕生日昭和;
    private RString 性別_男;
    private RString 性別_女;
    @BatchWriter
    private BatchReportWriter<ChosaIraishoReportSource> iraishoBatchReportWriter;
    private ReportSourceWriter<ChosaIraishoReportSource> iraishoReportSourceWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        iraishoBatchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        iraishoReportSourceWriter = new ReportSourceWriter<>(iraishoBatchReportWriter);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        // 内部QA：614　Redmine：＃75422　排他制限の確認
        update認定調査依頼情報(entity);
        get通知書定型文();
        getカスタマーバーコード(entity);
        chosaIraishoHeadItem = setChosaIraishoHeadItem(entity);
    }

    @Override
    protected void afterExecute() {
        //set出力条件表();
        if (chosaIraishoHeadItem != null) {
            ChosaIraishoReport report = ChosaIraishoReport.createFrom(chosaIraishoHeadItem);
            report.writeBy(iraishoReportSourceWriter);
        }
    }

    private ChosaIraishoHeadItem setChosaIraishoHeadItem(HomonChosaIraishoRelateEntity entity) {
        NinshoshaSource ninshoshaSource = get認証者();
        if (entity.get生年月日() != null && !entity.get生年月日().isEmpty()) {
            get年号(new FlexibleDate(entity.get生年月日()));
        }
        get性別(entity.get性別コード());
        get被保険者番号(entity);
        return new ChosaIraishoHeadItem(ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.koinShoryaku,
                get文書番号(),
                new RString("宛名郵便番号"),
                new RString("宛名住所"),
                new RString("宛名機関名"),
                new RString("宛名氏名"),
                new RString("宛名名称付与"),
                getカスタマーバーコード(entity),
                RString.EMPTY,
                文字列1,
                通知文1,
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
                entity.get被保険者氏名カナ(),
                誕生日明治,
                誕生日大正,
                誕生日昭和,
                entity.get生年月日(),
                entity.get被保険者氏名(),
                性別_男,
                性別_女,
                entity.get被保険者住所_郵便番号() != null ? new YubinNo(entity.get被保険者住所_郵便番号()).getEditedYubinNo() : RString.EMPTY,
                entity.get被保険者住所(),
                entity.get被保険者電話番号(),
                entity.get訪問調査先住所_郵便番号() != null ? new YubinNo(entity.get訪問調査先住所_郵便番号()).getEditedYubinNo() : RString.EMPTY,
                entity.get訪問調査先住所(),
                RString.EMPTY,
                entity.get訪問調査先名称(),
                entity.get訪問調査先電話番号(),
                entity.get要介護認定_更新申請日(),
                entity.get要介護認定調査表提出期限() != null ? new RString(entity.get要介護認定調査表提出期限().toString()) : RString.EMPTY,
                通知文2,
                文字列1);
    }

    private void get性別(RString 性別コード) {
        if (性別コード.equals(Seibetsu.男.getコード())) {
            性別_男 = Seibetsu.男.get名称();
            性別_女 = 記号_星;
        } else if (性別コード.equals(Seibetsu.女.getコード())) {
            性別_男 = 記号_星;
            性別_女 = Seibetsu.女.get名称();
        }
    }

    private void get被保険者番号(HomonChosaIraishoRelateEntity entity) {
        RString 被保険者番号 = entity.get被保険者番号();
        if (RString.isNullOrEmpty(被保険者番号) && HIHOKENSHANOLENGTH <= 被保険者番号.length()) {
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

    private void get年号(FlexibleDate 生年月日) {
        RString 年号 = 生年月日.wareki().toDateString();
        if (年号.startsWith(年号_明治)) {
            誕生日明治 = 年号_明治;
            誕生日大正 = 記号_星;
            誕生日昭和 = 記号_星;
        } else if (年号.startsWith(年号_大正)) {
            誕生日明治 = 記号_星;
            誕生日大正 = 年号_大正;
            誕生日昭和 = 記号_星;
        } else if (年号.startsWith(年号_昭和)) {
            誕生日明治 = 記号_星;
            誕生日大正 = 記号_星;
            誕生日昭和 = 年号_昭和;
        } else {
            誕生日明治 = 記号_星;
            誕生日大正 = 記号_星;
            誕生日昭和 = 記号_星;
        }
    }

    private void update認定調査依頼情報(HomonChosaIraishoRelateEntity entity) {
        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = new DbT5201NinteichosaIraiJohoEntity();
        RString 認定調査期限設定方法 = BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE.equals(認定調査期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(BusinessConfig.get(ConfigNameDBE.認定調査期限日数,
                            SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 認定調査依頼日 = entity.get認定調査依頼年月日();
                    if (認定調査依頼日 != null && !認定調査依頼日.isEmpty()) {
                        entity.set要介護認定調査表提出期限(認定調査依頼日.plusDay(期限日数));
                    }
                    break;
                case "1":
                    entity.set要介護認定調査表提出期限(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        entity.set要介護認定調査表提出期限(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        dbT5201Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbT5201Entity.setNinteichosaIraiRirekiNo(entity.get最大依頼履歴番号());
        dbT5201Entity.setLogicalDeletedFlag(false);
        dbT5201Entity.setIraishoShutsuryokuYMD(new FlexibleDate(processParamter.getHakkobi()));
        dbT5201Entity.setNinteichosaKigenYMD(entity.get要介護認定調査表提出期限());
        iHomonChosaIraishoMapper.update認定調査依頼情報(dbT5201Entity);
    }

    private RString getカスタマーバーコード(HomonChosaIraishoRelateEntity entity) {
        RString カスタマーバーコード = RString.EMPTY;
        CustomerBarCode barCode = new CustomerBarCode();
        RString 郵便番号 = entity.get被保険者住所_郵便番号();
        RString 住所 = entity.get被保険者住所();
        if (RString.isNullOrEmpty(郵便番号) && RString.isNullOrEmpty(住所)) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(郵便番号, 住所);
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
                iraishoBatchReportWriter.getImageFolderPath(),
                new RDate(processParamter.getHakkobi().toString()), true, true, KenmeiFuyoKubunType.付与なし);
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

//    private void set出力条件表() {
//        List 出力条件 = new ArrayList();
//        出力条件.add(processParamter.getIraiFromYMD());
//        出力条件.add(processParamter.getIraiToYMD());
//        出力条件.add(processParamter.getHihokenshaNo());
//        出力条件.add(processParamter.getNinteiChosaIraisyo());
//        出力条件.add(processParamter.getNinteiChosahyo());
//        出力条件.add(processParamter.getNinteiChosaItakusakiCodeList());
//        出力条件.add(processParamter.getNinteiChosainNoList());
//        出力条件.add(processParamter.getHakkobi());
//        出力条件.add(processParamter.getTeishutsuKigen());
//        出力条件.add(processParamter.getKyotsuHizuke());
//        出力条件.add(processParamter.getNinteioChosaIraiIchiranhyo());
//        出力条件.add(processParamter.getNinteiChosaIrai());
//        Association association = AssociationFinderFactory.createInstance().getAssociation();
//        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
//                = new ReportOutputJokenhyoItem(
//                        帳票ID.value(),
//                        association.getLasdecCode_().getColumnValue(),
//                        association.get市町村名(),
//                        new RString("【ジョブ番号】").concat(String.valueOf(JobContextHolder.getJobId())),
//                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, 帳票ID.value()),
//                        new RString(String.valueOf(iraishoReportSourceWriter.pageCount().value())),
//                        CSV出力有無,
//                        CSVファイル名,
//                        出力条件);
//        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
//    }
}
