/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.shokanbaraishikyuketteitsuchishosealertype;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 償還払い支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）のビジネスです。
 */
public class ShokanBaraiShikyuKetteiTsuchishoSealerType1 {

    private static final RString YEN = new RString("円");
    private static final RString 種別タイトル_口座種別 = new RString("口座種別");
    private static final RString 種別タイトル_店番 = new RString("店番");
    private static final RString 番号タイトル_口座番号 = new RString("口座番号");
    private static final RString 増減の理由タイトル_不支給の理由 = new RString("不支給の理由");
    private static final RString 増減の理由タイトル_増減の理由 = new RString("増減の理由");
    private static final RString 金融機関コード_郵便局 = new RString("9900");
    private static final RString 抽出モード_受け日 = new RString("1");
    private static final RString 抽出モード_決定日 = new RString("2");
    private static final RString KARA = new RString("～");
    private static final RString 抽出条件_受付日 = new RString("【抽出条件】 受付日：");
    private static final RString 抽出条件_決定日 = new RString("【抽出条件】 決定日：");
    private static final RString 抽出条件_決定者受付年月 = new RString("【抽出条件】 決定者受付年月：");
    private static final RString 記号_星 = new RString("**************");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final RString 汎用キー_文書番号 = new RString("文書番号");
    private static final int パターン番号_5 = 5;

    /**
     * 帳票データを作成します。
     *
     * @param businessList 償還払支給（不支給）決定通知書情報Entityリスト
     * @param batchPram バッチパラメータ
     * @param reportSourceWriter ReportSourceWriter
     * @return 伝送データEntity
     */
    public TensoData shokanBaraiShikyuKetteiTsuchishoSealerType1(List<ShokanKetteiTsuchiShoShiharai> businessList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, ReportSourceWriter reportSourceWriter) {
        return 伝送データ作成(businessList, batchPram, reportSourceWriter);
    }

    private TensoData 伝送データ作成(List<ShokanKetteiTsuchiShoShiharai> businessList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, ReportSourceWriter reportSourceWriter) {

        _NinshoshaManager ninshoshaManager = new _NinshoshaManager();
        Ninshosha ninshosha = ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), batchPram.getHakkoYMD());
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu chohyoSeigyoKyotsu = chohyoSeigyoKyotsuManager.get帳票制御共通(
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100004.getReportId());
        boolean is公印に掛ける = false;
        boolean is公印を省略 = false;
        if (chohyoSeigyoKyotsu != null) {
            is公印に掛ける = chohyoSeigyoKyotsu.get首長名印字位置().equals(new RString("1"));
            is公印を省略 = !chohyoSeigyoKyotsu.is電子公印印字有無();
        }
        NinshoshaSource ninshoshaSource = NinshoshaSourceBuilderFactory.createInstance(ninshosha, 導入団体クラス,
                reportSourceWriter.getImageFolderPath(), new RDate(batchPram.getHakkoYMD().toString()),
                is公印に掛ける, is公印を省略, KenmeiFuyoKubunType.付与なし).buildSource();

        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = bushoFineder.get文書番号管理(ReportIdDBC.DBC100004.getReportId(), batchPram.getHakkoYMD());
        RString 文書番号 = RString.EMPTY;
        if (bushoNo != null) {
            文書番号 = get文書番号(bushoNo);
        }

        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(batchPram.getHakkoYMD());
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        List<IAtesaki> 宛先s = ShikibetsuTaishoService.getAtesakiFinder().get宛先s(宛先builder.build());
        SofubutsuAtesakiSource atesakiSource
                = new SofubutsuAtesakiSourceBuilder(new SofubutsuAtesakiEditorBuilder(宛先s.get(ZERO)).build()).buildSource();

        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo info = tsuchishoTeikeibunManager.get通知書定型文項目(SubGyomuCode.DBE認定支援,
                ReportIdDBC.DBC100004.getReportId(), KamokuCode.EMPTY, パターン番号_5);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100004.getReportId());
        List<TsuchishoTeikeibunEntity> tsuchishoTeikeibunList = info.get通知書定型文List();
        int 項目番号;
        RString 情報文 = RString.EMPTY;
        RString 通知文 = RString.EMPTY;
        RString タイトル = RString.EMPTY;
        for (TsuchishoTeikeibunEntity tsuchishoTeikeibun : tsuchishoTeikeibunList) {
            項目番号 = tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentenceNo();
            if (項目番号 == THREE) {
                情報文 = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            } else if (項目番号 == TWO) {
                通知文 = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            } else if (項目番号 == ONE) {
                タイトル = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            }
        }

        List<ShokanKetteiTsuchiShoSealer> 帳票ソースデータ = new ArrayList<>();
        List<RString> 重複キーリスト = new ArrayList<>();
        for (ShokanKetteiTsuchiShoShiharai shiharai : businessList) {
            RString key = getJufukuKey(shiharai);
            if (重複キーリスト.contains(key)) {
                continue;
            }
            重複キーリスト.add(key);
            int pageCount = 0;
            HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
            if (!被保険者番号.equals(shiharai.get被保険者番号())) {
                pageCount++;
            }
            帳票ソースデータ.add(create帳票ソースデータ(ninshoshaSource, shiharai, batchPram, 文書番号, 通知文,
                    情報文, タイトル, atesakiSource, pageCount));
        }
        List<RString> 帳票名 = new ArrayList<>();
        帳票名.add(ReportIdDBC.DBC100004.getReportName());
        List<RString> 抽出条件 = new ArrayList<>();
        RStringBuilder 抽出条件Builder = new RStringBuilder();
        if (抽出モード_受け日.equals(batchPram.getChusyutuMode())) {
            抽出条件Builder.append(抽出条件_受付日);
            if (batchPram.getDataFrom() != null) {
                抽出条件Builder.append(batchPram.getDataFrom().wareki().
                        eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString());
            }
            抽出条件Builder.append(KARA);
            if (batchPram.getDataFrom() != null) {
                抽出条件Builder.append(batchPram.getDataTo().wareki().
                        eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString());
            }
        } else if (抽出モード_決定日.equals(batchPram.getChusyutuMode())) {
            抽出条件Builder.append(抽出条件_決定日);
            if (batchPram.getDataFrom() != null) {
                抽出条件Builder.append(batchPram.getDataFrom().wareki().
                        eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString());
            }
            抽出条件Builder.append(KARA);
            if (batchPram.getDataFrom() != null) {
                抽出条件Builder.append(batchPram.getDataTo().wareki().
                        eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString());
            }
        } else {
            抽出条件Builder.append(抽出条件_決定者受付年月);
            抽出条件Builder.append(batchPram.getKetteishaUketukeYM().wareki().
                    eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
        }
        抽出条件.add(抽出条件Builder.toRString());
        List<Decimal> ページ数 = new ArrayList<>();
        ページ数.add(Decimal.ONE);
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().
                get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100004.getReportId(),
                        Long.parseLong(batchPram.getSyutujunId().toString()));
        List<RString> 出力順項目 = new ArrayList<>();
        List<RString> 改ページ項目 = new ArrayList<>();
        for (ISetSortItem sortItem : outputOrder.get設定項目リスト()) {
            出力順項目.add(sortItem.get項目ID());
            if (sortItem.is改頁項目()) {
                改ページ項目.add(sortItem.get項目ID());
            }
        }
        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBC介護給付,
                導入団体クラス.getLasdecCode_(), 導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC100004.getReportName(),
                ReportIdDBC.DBC100004.getReportId().value(),
                帳票名, ページ数, 抽出条件,
                出力順項目, 改ページ項目, null);
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        return new TensoData(帳票ソースデータ, daikoPrint);
    }

    private RString get文書番号(BunshoNo bushoNo) {
        RString 文書番号 = RString.EMPTY;
        RString 文書番号発番方法 = bushoNo.get文書番号発番方法();
        if (BunshoNoHatsubanHoho.固定.getCode().equalsIgnoreCase(文書番号発番方法)) {
            文書番号 = bushoNo.edit文書番号();
        } else if (BunshoNoHatsubanHoho.手入力.getCode().equalsIgnoreCase(文書番号発番方法)) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("文書番号情報の取得"));
        } else if (BunshoNoHatsubanHoho.自動採番.getCode().equalsIgnoreCase(文書番号発番方法)) {
            CountedItem 採番 = Saiban.get(SubGyomuCode.DBC介護給付, 汎用キー_文書番号,
                    new FlexibleYear(RDate.getNowDate().getYear().toDateString()));
            文書番号 = bushoNo.edit文書番号(採番.nextString());
        }
        return 文書番号;
    }

    private RString getJufukuKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder key = new RStringBuilder();
        key.append(shiharai.get提供年月().wareki().toDateString());
        key.append(shiharai.get整理番号());
        key.append(shiharai.get被保険者番号().value());
        key.append(shiharai.get種類());
        return key.toRString();
    }

    private ShokanKetteiTsuchiShoSealer create帳票ソースデータ(NinshoshaSource ninshoshaSource, ShokanKetteiTsuchiShoShiharai business,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, RString 文書番号, RString 通知文, RString 情報文, RString タイトル,
            SofubutsuAtesakiSource atesaki, int pageCount) {

        RString 増減の理由タイトル;
        RString 種別タイトル = RString.EMPTY;
        if (ShikyuFushikyuKubun.不支給.getコード().equals(business.get支給不支給決定区分())) {
            増減の理由タイトル = 増減の理由タイトル_不支給の理由;
            if (ShiharaiHohoKubun.窓口払.getコード().equals(business.get支払方法区分コード())) {
                種別タイトル = 種別タイトル_口座種別;
            } else if (ShiharaiHohoKubun.口座払.getコード().equals(business.get支払方法区分コード())) {
                if (金融機関コード_郵便局.equals(business.get金融機関コード().value())) {
                    種別タイトル = 種別タイトル_店番;
                } else {
                    種別タイトル = 種別タイトル_口座種別;
                }
            }
        } else {
            増減の理由タイトル = 増減の理由タイトル_増減の理由;
            種別タイトル = 種別タイトル_口座種別;
        }

        RString タイトル2_2_1 = RString.EMPTY;
        RString タイトル2_2_2 = RString.EMPTY;
        RString タイトル2_3_1 = RString.EMPTY;
        RString タイトル2_3_2 = RString.EMPTY;
        if (ShikyuFushikyuKubun.支給.getコード().equals(business.get支給不支給決定区分())) {
            // TODO QA696 帳票制御汎用関連資料無
            タイトル2_2_1 = RString.EMPTY;
            タイトル2_3_1 = RString.EMPTY;
        } else {
            タイトル2_2_2 = RString.EMPTY;
            // TODO QA696 帳票制御汎用関連資料無
            タイトル2_3_2 = RString.EMPTY;
        }

        RString 被保険者番号 = business.get被保険者番号().value();
        ShokanKetteiTsuchiShoSealer ketteiTsuchiShoSealer = new ShokanKetteiTsuchiShoSealer();
        ketteiTsuchiShoSealer.setBunshoNo(文書番号);
        ketteiTsuchiShoSealer.setHihokenshaName(business.get被保険者氏名());
        ketteiTsuchiShoSealer.setHihokenshaNo(被保険者番号);
        ketteiTsuchiShoSealer.setUketsukeYMD(business.get受付年月日() == null ? RString.EMPTY : business.get受付年月日().wareki().eraType(
                EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ketteiTsuchiShoSealer.setKetteiYMD(business.get決定年月日() == null ? RString.EMPTY : business.get決定年月日().wareki().eraType(
                EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ketteiTsuchiShoSealer.setShiharaiGaku(new RString(business.get本人支払額().toString()));
        ketteiTsuchiShoSealer.setTaishoYM(business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().firstYear(
                FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());

        // QA696 帳票フォームにで、項目「種類」なし
        ketteiTsuchiShoSealer.setKyufuShurui1(business.get種類());
        ketteiTsuchiShoSealer.setKyufuShurui2(business.get種類());
        ketteiTsuchiShoSealer.setKyufuShurui3(business.get種類());
        ketteiTsuchiShoSealer.setKekka(ShikyuFushikyuKubun.toValue(business.get支給不支給決定区分()).get名称());
        ketteiTsuchiShoSealer.setShikyuGaku(new RString(business.get支給額().toString()));
        ketteiTsuchiShoSealer.set増減の理由(business.get増減理由等());
        ketteiTsuchiShoSealer.setShiharaiBasho(batchPram.getShiharaiBasho());
        ketteiTsuchiShoSealer.setShiharaiStartYMD(business.get支払期間開始年月日() == null
                ? RString.EMPTY : business.get支払期間開始年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ketteiTsuchiShoSealer.setShiharaiEndYMD(business.get支払期間終了年月日() == null
                ? RString.EMPTY : business.get支払期間終了年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RStringBuilder 支払窓口開始時間Builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(business.get支払窓口開始時間())) {
            RTime 支払窓口開始時間 = new RTime(business.get支払窓口開始時間());
            支払窓口開始時間Builder.append(String.format("%02d", 支払窓口開始時間.getHour()));
            支払窓口開始時間Builder.append(new RString("時"));
            支払窓口開始時間Builder.append(String.format("%02d", 支払窓口開始時間.getMinute()));
            支払窓口開始時間Builder.append(new RString("分"));
            支払窓口開始時間Builder.append(String.format("%02d", 支払窓口開始時間.getSecond()));
            支払窓口開始時間Builder.append(new RString("秒"));
        }
        ketteiTsuchiShoSealer.setShiharaiStartHMS(支払窓口開始時間Builder.toRString());
        RStringBuilder 支払窓口終了期間Builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(business.get支払窓口終了期間())) {
            RTime 支払窓口終了期間 = new RTime(business.get支払窓口終了期間());
            支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getHour()));
            支払窓口終了期間Builder.append(new RString("時"));
            支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getMinute()));
            支払窓口終了期間Builder.append(new RString("分"));
            支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getSecond()));
            支払窓口終了期間Builder.append(new RString("秒"));
        }
        ketteiTsuchiShoSealer.setShiharaiEndHMS(支払窓口終了期間Builder.toRString());
        if (!RString.isNullOrEmpty(business.get支払窓口開始時間()) && !RString.isNullOrEmpty(business.get支払窓口終了期間())) {
            ketteiTsuchiShoSealer.setKaraFugo(KARA);
        }
        ketteiTsuchiShoSealer.setBankName(business.get金融機関名称());
        ketteiTsuchiShoSealer.setBranchBankName(business.get支店名称());
        ketteiTsuchiShoSealer.setKouzaShu(business.get預金種別名称());
        ketteiTsuchiShoSealer.setKouzaNo(business.get口座番号());
        ketteiTsuchiShoSealer.setKouzaMeigi(business.get口座名義人漢字());
        ketteiTsuchiShoSealer.setShiharaiYoteiYMD(batchPram.getHurikomiYMD() == null
                ? RString.EMPTY : batchPram.getHurikomiYMD().seireki().toDateString());
        ketteiTsuchiShoSealer.set整理番号(business.get整理番号());
        ketteiTsuchiShoSealer.set決定通知書番号(business.get決定通知No());
        ketteiTsuchiShoSealer.setTsuban(RString.EMPTY);
        // QA696 帳票制御汎用関連
        ketteiTsuchiShoSealer.setTitle1(RString.EMPTY);
        ketteiTsuchiShoSealer.setTitle2(RString.EMPTY);
        ketteiTsuchiShoSealer.setTitle(タイトル);
        ketteiTsuchiShoSealer.setPage(new RString(String.valueOf(pageCount)));
        ketteiTsuchiShoSealer.setHihokenshaName2(business.get被保険者氏名());
        ketteiTsuchiShoSealer.setTsuchibun1(通知文);
        ketteiTsuchiShoSealer.setInfo(情報文);
        ketteiTsuchiShoSealer.setYen1(YEN);
        ketteiTsuchiShoSealer.setYen2(YEN);
        ketteiTsuchiShoSealer.setYen3(YEN);
        ketteiTsuchiShoSealer.setYen4(YEN);
        ketteiTsuchiShoSealer.setRiyuTitle(増減の理由タイトル);
        ketteiTsuchiShoSealer.setShumokuTitle(種別タイトル);
        ketteiTsuchiShoSealer.setBangoTitle(番号タイトル_口座番号);
        ketteiTsuchiShoSealer.setHakkoYMD(ninshoshaSource.hakkoYMD);
        ketteiTsuchiShoSealer.setDenshiKoin(ninshoshaSource.denshiKoin);
        ketteiTsuchiShoSealer.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
        ketteiTsuchiShoSealer.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
        ketteiTsuchiShoSealer.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        ketteiTsuchiShoSealer.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
        ketteiTsuchiShoSealer.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        ketteiTsuchiShoSealer.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        ketteiTsuchiShoSealer.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        ketteiTsuchiShoSealer.setYubinNo(atesaki.yubinNo);
        ketteiTsuchiShoSealer.setGyoseiku1(atesaki.gyoseiku);
        ketteiTsuchiShoSealer.setGyoseiku2(atesaki.gyoseiku);
        ketteiTsuchiShoSealer.setJusho4(atesaki.jusho1);
        ketteiTsuchiShoSealer.setJushoText(atesaki.jushoText);
        ketteiTsuchiShoSealer.setJusho5(atesaki.jusho2);
        ketteiTsuchiShoSealer.setJusho6(atesaki.jusho3);
        ketteiTsuchiShoSealer.setKatagakiText(atesaki.katagakiText);
        ketteiTsuchiShoSealer.setKatagaki3(atesaki.katagaki1);
        ketteiTsuchiShoSealer.setKatagaki4(atesaki.katagaki2);
        ketteiTsuchiShoSealer.setKatagakiSmall2(atesaki.katagakiSmall2);
        ketteiTsuchiShoSealer.setKatagakiSmall1(atesaki.katagakiSmall1);
        ketteiTsuchiShoSealer.setShimeiSmall2(atesaki.shimeiSmall2);
        ketteiTsuchiShoSealer.setShimeiText(atesaki.shimeiText);
        ketteiTsuchiShoSealer.setMeishoFuyo2(atesaki.meishoFuyo2);
        ketteiTsuchiShoSealer.setShimeiSmall1(atesaki.shimeiSmall1);
        ketteiTsuchiShoSealer.setDainoKubunMei(atesaki.dainoKubunMei);
        ketteiTsuchiShoSealer.setShimei5(atesaki.shimei1);
        ketteiTsuchiShoSealer.setShimei6(atesaki.shimei2);
        ketteiTsuchiShoSealer.setMeishoFuyo1(atesaki.meishoFuyo1);
        ketteiTsuchiShoSealer.setSamabunShimeiText(atesaki.samabunShimeiText);
        ketteiTsuchiShoSealer.setSamaBun2(atesaki.samaBun2);
        ketteiTsuchiShoSealer.setKakkoLeft2(atesaki.kakkoLeft2);
        ketteiTsuchiShoSealer.setSamabunShimei2(atesaki.samabunShimei2);
        ketteiTsuchiShoSealer.setSamabunShimeiSmall2(atesaki.samabunShimeiSmall2);
        ketteiTsuchiShoSealer.setKakkoRight2(atesaki.kakkoRight2);
        ketteiTsuchiShoSealer.setKakkoLeft1(atesaki.kakkoLeft1);
        ketteiTsuchiShoSealer.setSamabunShimei1(atesaki.samabunShimei1);
        ketteiTsuchiShoSealer.setSamaBun1(atesaki.samaBun1);
        ketteiTsuchiShoSealer.setKakkoRight1(atesaki.kakkoRight1);
        ketteiTsuchiShoSealer.setSamabunShimeiSmall1(atesaki.samabunShimeiSmall1);
        ketteiTsuchiShoSealer.setCustomerBarCode(atesaki.customerBarCode);
        // TODO QA696 帳票制御汎用関連
        ketteiTsuchiShoSealer.setTitle2_1(RString.EMPTY);
        ketteiTsuchiShoSealer.setTitle2_2_1(タイトル2_2_1);
        ketteiTsuchiShoSealer.setTitle2_2_2(タイトル2_2_2);
        ketteiTsuchiShoSealer.setTitle2_3_1(タイトル2_3_1);
        ketteiTsuchiShoSealer.setTitle2_3_2(タイトル2_3_2);
        ketteiTsuchiShoSealer.setTitle2_4(RString.EMPTY);
        ketteiTsuchiShoSealer.setShoHokenshaNo(business.get証記載保険者番号());
        ketteiTsuchiShoSealer.setServiceYM(business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().firstYear(
                FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ketteiTsuchiShoSealer.setTsuban2(RString.EMPTY);
        if (ShiharaiHohoKubun.窓口払.getコード().equals(business.get支払方法区分コード())) {
            ketteiTsuchiShoSealer.setTorikeshi1(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshi2(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshiMochimono1(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshiMochimono2(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshiShiharaibasho(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshiShiharaikikan(RString.EMPTY);
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(business.get支払方法区分コード())) {
            ketteiTsuchiShoSealer.setTorikeshi1(記号_星);
            ketteiTsuchiShoSealer.setTorikeshi2(記号_星);
            ketteiTsuchiShoSealer.setTorikeshiMochimono1(記号_星);
            ketteiTsuchiShoSealer.setTorikeshiMochimono2(記号_星);
            ketteiTsuchiShoSealer.setTorikeshiShiharaibasho(記号_星);
            ketteiTsuchiShoSealer.setTorikeshiShiharaikikan(記号_星);
        }

        // QA696 帳票制御汎用関連
        ketteiTsuchiShoSealer.setMochimono1(RString.EMPTY);
        ketteiTsuchiShoSealer.setMochimono2(RString.EMPTY);
        ketteiTsuchiShoSealer.setMochimono3(RString.EMPTY);
        被保険者番号 = 被保険者番号.padRight(RString.HALF_SPACE, TEN);
        ketteiTsuchiShoSealer.setHihokenshaNo1(被保険者番号.substring(ZERO, ONE));
        ketteiTsuchiShoSealer.setHihokenshaNo2(被保険者番号.substring(ONE, TWO));
        ketteiTsuchiShoSealer.setHihokenshaNo3(被保険者番号.substring(TWO, THREE));
        ketteiTsuchiShoSealer.setHihokenshaNo4(被保険者番号.substring(THREE, FOUR));
        ketteiTsuchiShoSealer.setHihokenshaNo5(被保険者番号.substring(FOUR, FIVE));
        ketteiTsuchiShoSealer.setHihokenshaNo6(被保険者番号.substring(FIVE, SIX));
        ketteiTsuchiShoSealer.setHihokenshaNo7(被保険者番号.substring(SIX, SEVEN));
        ketteiTsuchiShoSealer.setHihokenshaNo8(被保険者番号.substring(SEVEN, EIGHT));
        ketteiTsuchiShoSealer.setHihokenshaNo9(被保険者番号.substring(EIGHT, NINE));
        ketteiTsuchiShoSealer.setHihokenshaNo10(被保険者番号.substring(NINE));
        return ketteiTsuchiShoSealer;
    }
}
