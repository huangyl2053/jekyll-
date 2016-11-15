/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoYokoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険料減免決定通知書 B5横タイプEditorクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class GenmenKetteiTsuchiShoYokoEditor implements IGenmenKetteiTsuchiShoYokoEditor {

    private static final CodeShubetsu コード種別 = DBBCodeShubetsu.保険料減免種類.getコード();
    private final KoseiZengoKiwariGaku 更正前後期割額;
    private final RString 随時;
    private final RString 文書番号;
    private final GenmenKetteiTsuchiShoJoho 減免決定通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final KaigoSofubutsuAtesakiSource kaigoSofubutsuAtesakiSource;

    /**
     * コンストラクタです。
     *
     * @param 更正前後期割額 KoseiZengoKiwariGaku
     * @param 随時 RString
     * @param 文書番号 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param sourceBuilder NinshoshaSource
     * @param 表示コード HyojiCodes
     * @param kaigoSofubutsuAtesakiSource KaigoSofubutsuAtesakiSource
     */
    public GenmenKetteiTsuchiShoYokoEditor(KoseiZengoKiwariGaku 更正前後期割額, RString 随時, RString 文書番号,
            GenmenKetteiTsuchiShoJoho 減免決定通知書情報, RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder, HyojiCodes 表示コード, KaigoSofubutsuAtesakiSource kaigoSofubutsuAtesakiSource) {
        this.更正前後期割額 = 更正前後期割額;
        this.随時 = 随時;
        this.文書番号 = 文書番号;
        this.減免決定通知書情報 = 減免決定通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.kaigoSofubutsuAtesakiSource = kaigoSofubutsuAtesakiSource;
    }

    @Override
    public KaigoHokenryoGenmenKetteiTsuchishoYokoSource edit(KaigoHokenryoGenmenKetteiTsuchishoYokoSource source) {
        source.bunshoNo = 文書番号;

        if (減免決定通知書情報.get減免の情報更正後() != null) {
            FlexibleYear 調定年度 = 減免決定通知書情報.get減免の情報更正後().get調定年度();
            if (調定年度 != null) {
                source.choteiNendo = 調定年度.wareki().eraType(EraType.KANJI).toDateString();
            }
            FlexibleYear 賦課年度 = 減免決定通知書情報.get減免の情報更正後().get賦課年度();
            if (賦課年度 != null) {
                source.fukaNendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString();
            }
            source.ketteiKekka = GemmenChoshuYuyoStateKubun.toValue(減免決定通知書情報.get減免の情報更正後().get減免状態区分()).get名称()
                    .replace(new RString("決定_"), RString.EMPTY);
        }
        if (表示コード != null) {
            source.hyojicodeName1 = 表示コード.get表示コード名１();
            source.hyojicodeName2 = 表示コード.get表示コード名２();
            source.hyojicodeName3 = 表示コード.get表示コード名３();
            source.hyojicode1 = 表示コード.get表示コード１();
            source.hyojicode2 = 表示コード.get表示コード２();
            source.hyojicode3 = 表示コード.get表示コード３();
        }
        set減免の情報(source, 減免決定通知書情報);
        source.bikoTitle = 通知書定型文;
        source.biko = 通知書定型文;

        if (sourceBuilder != null) {
            source.hakkoYMD = sourceBuilder.hakkoYMD;
            source.denshiKoin = sourceBuilder.denshiKoin;
            source.ninshoshaYakushokuMei = sourceBuilder.ninshoshaYakushokuMei;
            source.koinMojiretsu = sourceBuilder.koinMojiretsu;
            source.ninshoshaShimeiKakenai = sourceBuilder.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = sourceBuilder.ninshoshaShimeiKakeru;
            source.koinShoryaku = sourceBuilder.koinShoryaku;
        }

        if (isNotNull(介護問合せ先ソースビルダー)) {

            CompKaigoToiawasesakiSource buildSource = 介護問合せ先ソースビルダー.buildSource();
            source.yubinBango = buildSource.yubinBango;
            source.shozaichi = buildSource.shozaichi;
            source.choshaBushoName = buildSource.choshaBushoName;
            source.tantoName = buildSource.tantoName;
            source.telNo = buildSource.telNo;
            source.naisenLabel = buildSource.naisenLabel;
            source.naisenNo = buildSource.naisenNo;
        }
        set送付物宛先ソース(source);
        source.listKibetsu_1 = 更正前後期割額.get特徴期();
        source.listKibetsu_2 = 更正前後期割額.get特徴月();
        source.listKibetsu_3 = 更正前後期割額.get特徴期別金額更正前();
        source.listKibetsu_4 = 更正前後期割額.get特徴期別金額更正後();
        source.listKibetsu_5 = 更正前後期割額.get普徴期();
        source.listKibetsu_6 = 更正前後期割額.get普徴月();
        source.listKibetsu_7 = 更正前後期割額.get普徴期別金額更正前();
        source.listKibetsu_8 = 更正前後期割額.get普徴期別金額更正後();
        source.listZuiji_1 = 随時;
        return source;
    }

    private void set減免の情報(KaigoHokenryoGenmenKetteiTsuchishoYokoSource source, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        if (isNotNull(減免決定通知書情報.get減免の情報更正後())) {
            TsuchishoNo 通知書番号 = 減免決定通知書情報.get減免の情報更正後().get通知書番号();
            source.tsuchishoNo = 通知書番号 != null ? 通知書番号.value() : RString.EMPTY;
            SetaiCode 世帯コード = 減免決定通知書情報.get宛名().get世帯コード();
            source.setaiCode = 世帯コード != null ? 世帯コード.value() : RString.EMPTY;
            HihokenshaNo 被保険者番号 = 減免決定通知書情報.get減免の情報更正後().get被保険者番号();
            source.hihokenshaNo = 被保険者番号 != null ? 被保険者番号.value() : RString.EMPTY;
            ShikibetsuCode 識別コード = 減免決定通知書情報.get減免の情報更正後().get識別コード();
            source.shikibetsuCode = 識別コード != null ? 識別コード.value() : RString.EMPTY;
            FlexibleDate 減免決定日 = 減免決定通知書情報.get減免の情報更正後().get減免決定日();
            if (減免決定日 != null) {
                source.genmenKetteiYMD = 減免決定日.wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.genmenGakuAto = DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get減免の情報更正後().get減免額(), 0);
            source.hokenSanshutsuAto = DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get減免の情報更正後().get減免前介護保険料_年額(), 0);
            source.hokenGakuAto = DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get減免の情報更正後().get確定介護保険料_年額(), 0);
            Code 減免種類コード = 減免決定通知書情報.get減免の情報更正後().get減免種類コード();
            if (減免種類コード != null) {
                source.genmenRiyu1 = CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課, コード種別,
                        減免種類コード, FlexibleDate.getNowDate());
            }
            source.genmenRiyu2 = 減免決定通知書情報.get減免の情報更正後().get減免事由();
        }
        if (isNotNull(減免決定通知書情報.get賦課の情報更正前())) {
            source.genmenGakuMae = DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get賦課の情報更正前().get減免額(), 0);
            source.hokenSanshutsuMae = DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get賦課の情報更正前().get減免前介護保険料_年額(), 0);
            source.hokenGakuMae = DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get賦課の情報更正前().get確定介護保険料_年額(), 0);
        }
    }

    private void set送付物宛先ソース(KaigoHokenryoGenmenKetteiTsuchishoYokoSource source) {
        if (kaigoSofubutsuAtesakiSource != null) {
            source.yubinNo = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().yubinNo;
            source.gyoseiku = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().gyoseiku;
            source.jusho3 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().jusho3;
            source.jushoText = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().jushoText;
            source.jusho1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().jusho1;
            source.jusho2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().jusho2;
            source.katagakiText = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().katagakiText;
            source.katagaki2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().katagaki2;
            source.katagakiSmall2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().katagakiSmall2;
            source.katagaki1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().katagaki1;
            source.katagakiSmall1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().katagakiSmall1;
            source.kakkoRight2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().kakkoRight2;
            source.kakkoRight1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().kakkoRight1;
            source.shimei2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().shimei2;
            source.shimeiSmall2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().shimeiSmall2;
            source.shimeiText = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().shimeiText;
            source.meishoFuyo2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().meishoFuyo2;
            source.shimeiSmall1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().shimeiSmall1;
            source.dainoKubunMei = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().dainoKubunMei;
            source.shimei1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().shimei1;
            source.meishoFuyo1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().meishoFuyo1;
            source.samabunShimeiText = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiText;
            source.samabunShimeiSmall2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiSmall2;
            source.samaBun2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().samaBun2;
            source.kakkoLeft2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().kakkoLeft2;
            source.samabunShimei2 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().samabunShimei2;
            source.kakkoLeft1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().kakkoLeft1;
            source.samabunShimei1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().samabunShimei1;
            source.samaBun1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().samaBun1;
            source.samabunShimeiSmall1 = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiSmall1;
            source.customerBarCode = kaigoSofubutsuAtesakiSource.get送付物宛先ソース().customerBarCode;
        }
    }

    /**
     * 判断をnull対象 します。
     *
     * @param object Object
     * @return boolean
     */
    private boolean isNotNull(Object object) {
        return object != null;
    }

}
