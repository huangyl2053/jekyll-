/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmentorikesitsuchisho.KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険料減免取消通知書 B5横タイプEditorするクラスです。
 *
 * @reamsid_L DBB-0740-060 chenaoqi
 */
public class GemmenTorikesiTsuchiShoB5YokoEditor implements IGemmenTorikesiTsuchiShoB5YokoEditor {

    private final RString 文書番号;
    private final GemmenTorikesiTsuchiShoJoho 減免取消通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final List<KoseiZengoKiwariGaku> 更正前後期割額リスト;
    private final List<RString> 随時リスト;
    private final EditedAtesaki 編集後宛先;
    private final int i;
    private static final RString YEAR = new RString("年度");
    private static final RString RSTRING_0 = new RString("0");

    /**
     * コンストラクタです。
     *
     *
     * @param 文書番号 RString
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param sourceBuilder NinshoshaSource
     * @param 表示コード HyojiCodes
     * @param 更正前後期割額リスト List<KoseiZengoKiwariGaku>
     * @param 随時リスト List<RString>
     * @param 編集後宛先 EditedAtesaki
     * @param i int
     */
    public GemmenTorikesiTsuchiShoB5YokoEditor(
            RString 文書番号,
            GemmenTorikesiTsuchiShoJoho 減免取消通知書情報,
            RString 通知書定型文,
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder,
            HyojiCodes 表示コード,
            List<KoseiZengoKiwariGaku> 更正前後期割額リスト,
            List<RString> 随時リスト,
            EditedAtesaki 編集後宛先,
            int i) {

        this.文書番号 = 文書番号;
        this.減免取消通知書情報 = 減免取消通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.更正前後期割額リスト = 更正前後期割額リスト;
        this.随時リスト = 随時リスト;
        this.編集後宛先 = 編集後宛先;
        this.i = i;
    }

    @Override
    public KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource edit(KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource source) {
        source.bunshoNo = 文書番号;
        source.bikoTitle = 通知書定型文;
        source.biko = 通知書定型文;
        set表示コード(source);
        set減免の情報(source);
        set更正前後期割額リスト(source);
        set編集後宛先(source);
        set認証者ソース(source);
        set介護問合せ先ソースビルダー(source);
        return source;
    }

    private void set表示コード(KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource source) {
        if (表示コード != null) {
            source.hyojicodeName1 = 表示コード.get表示コード名１();
            source.hyojicodeName2 = 表示コード.get表示コード名２();
            source.hyojicodeName3 = 表示コード.get表示コード名３();
            source.hyojicode1 = 表示コード.get表示コード１();
            source.hyojicode2 = 表示コード.get表示コード２();
            source.hyojicode3 = 表示コード.get表示コード３();
        }
    }

    private void set減免の情報(KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource source) {
        if (減免取消通知書情報.get減免の情報更正後() != null) {
            FlexibleYear 調定年度 = 減免取消通知書情報.get減免の情報更正後().get調定年度();
            source.choteiNendo = (調定年度 != null ? 調定年度.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN).toDateString() : RString.EMPTY);
            FlexibleYear 賦課年度 = 減免取消通知書情報.get減免の情報更正後().get賦課年度();
            source.fukaNendo = (賦課年度 != null ? 賦課年度.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN).toDateString().concat(YEAR) : RString.EMPTY);
            TsuchishoNo 通知書番号 = 減免取消通知書情報.get減免の情報更正後().get通知書番号();
            source.tsuchishoNo = (通知書番号 != null ? 通知書番号.value() : RString.EMPTY);
            SetaiCode 世帯コード = 減免取消通知書情報.get宛名().get世帯コード();
            source.setaiCode = (世帯コード != null ? 世帯コード.value() : RString.EMPTY);
            HihokenshaNo 被保険者番号 = 減免取消通知書情報.get減免の情報更正後().get被保険者番号();
            source.hihokenshaNo = (被保険者番号 != null ? 被保険者番号.value() : RString.EMPTY);
            ShikibetsuCode 識別コード = 減免取消通知書情報.get減免の情報更正後().get識別コード();
            source.shikibetsuCode = (識別コード != null ? 識別コード.value() : RString.EMPTY);
            FlexibleDate 減免取消年月日 = 減免取消通知書情報.get減免の情報更正後().get減免取消日();
            source.genmenTorikeshiYMD = (減免取消年月日 != null ? 減免取消年月日.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString() : RString.EMPTY);
            Decimal 取消減免額 = 減免取消通知書情報.get減免の情報更正後().get取消減免額();
            source.torikeshiGenmenGaku = (取消減免額 != null ? DecimalFormatter
                    .toコンマ区切りRString(取消減免額, 0) : RSTRING_0);
            if (減免取消通知書情報.get賦課の情報更正前() != null) {
                Decimal 取消前保険料額 = 減免取消通知書情報.get賦課の情報更正前().get確定介護保険料_年額();
                source.torikeshiMaeHokenryoGaku = (取消前保険料額 != null ? DecimalFormatter
                        .toコンマ区切りRString(取消前保険料額, 0) : RSTRING_0);
            }
            Decimal 取消後保険料額 = 減免取消通知書情報.get減免の情報更正後().get確定介護保険料_年額();
            source.torikeshiAtoHokenryoGaku = (取消後保険料額 != null ? DecimalFormatter
                    .toコンマ区切りRString(取消後保険料額, 0) : RSTRING_0);
            Code 減免取消種類コード = 減免取消通知書情報.get減免の情報更正後().get減免種類コード();
            RString 取消理由1 = RString.EMPTY;
            if (減免取消種類コード != null) {
                取消理由1 = CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.保険料減免取消種類.getコード(),
                        減免取消種類コード, FlexibleDate.getNowDate());
            }
            source.torikeshiRiyu1 = 取消理由1;
            source.torikeshiRiyu2 = 減免取消通知書情報.get減免の情報更正後().get減免事由();
        }
    }

    private void set更正前後期割額リスト(KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource source) {
        if (更正前後期割額リスト != null && !更正前後期割額リスト.isEmpty()) {
            source.listKibetsu_1 = 更正前後期割額リスト.get(i).get特徴期();
            source.listKibetsu_2 = 更正前後期割額リスト.get(i).get特徴月();
            source.listKibetsu_3 = 更正前後期割額リスト.get(i).get特徴期別金額取消前();
            source.listKibetsu_4 = 更正前後期割額リスト.get(i).get特徴減免取消額();
            source.listKibetsu_5 = 更正前後期割額リスト.get(i).get特徴期別金額取消後();
            source.listKibetsu_6 = 更正前後期割額リスト.get(i).get普徴期();
            source.listKibetsu_7 = 更正前後期割額リスト.get(i).get普徴月();
            source.listKibetsu_8 = 更正前後期割額リスト.get(i).get普徴期別金額取消前();
            source.listKibetsu_9 = 更正前後期割額リスト.get(i).get普徴減免取消額();
            source.listKibetsu_10 = 更正前後期割額リスト.get(i).get普徴期別金額取消後();
            source.listZuiji_1 = 随時リスト.get(i);
        }
    }

    private void set編集後宛先(KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource source) {
        if (編集後宛先 != null) {
            KaigoSofubutsuAtesakiSource 送付物宛先 = 編集後宛先.getSofubutsuAtesakiSource();
            if (送付物宛先 != null && 送付物宛先.get送付物宛先ソース() != null) {
                source.yubinNo = 送付物宛先.get送付物宛先ソース().yubinNo;
                source.gyoseiku = 送付物宛先.get送付物宛先ソース().gyoseiku;
                source.jusho3 = 送付物宛先.get送付物宛先ソース().jusho3;
                source.jushoText = 送付物宛先.get送付物宛先ソース().jushoText;
                source.jusho1 = 送付物宛先.get送付物宛先ソース().jusho1;
                source.jusho2 = 送付物宛先.get送付物宛先ソース().jusho2;
                source.katagakiText = 送付物宛先.get送付物宛先ソース().katagakiText;
                source.katagaki2 = 送付物宛先.get送付物宛先ソース().katagaki2;
                source.katagakiSmall2 = 送付物宛先.get送付物宛先ソース().katagakiSmall2;
                source.katagaki1 = 送付物宛先.get送付物宛先ソース().katagaki1;
                source.katagakiSmall1 = 送付物宛先.get送付物宛先ソース().katagakiSmall1;
                source.kakkoRight2 = 送付物宛先.get送付物宛先ソース().kakkoRight2;
                source.kakkoRight1 = 送付物宛先.get送付物宛先ソース().kakkoRight1;
                source.shimei2 = 送付物宛先.get送付物宛先ソース().shimei2;
                source.shimeiSmall2 = 送付物宛先.get送付物宛先ソース().shimeiSmall2;
                source.shimeiText = 送付物宛先.get送付物宛先ソース().shimeiText;
                source.meishoFuyo2 = 送付物宛先.get送付物宛先ソース().meishoFuyo2;
                source.shimeiSmall1 = 送付物宛先.get送付物宛先ソース().shimeiSmall1;
                source.dainoKubunMei = 送付物宛先.get送付物宛先ソース().dainoKubunMei;
                source.shimei1 = 送付物宛先.get送付物宛先ソース().shimei1;
                source.meishoFuyo1 = 送付物宛先.get送付物宛先ソース().meishoFuyo1;
                source.samabunShimeiText = 送付物宛先.get送付物宛先ソース().samabunShimeiText;
                source.samabunShimeiSmall2 = 送付物宛先.get送付物宛先ソース().samabunShimeiSmall2;
                source.samaBun2 = 送付物宛先.get送付物宛先ソース().samaBun2;
                source.kakkoLeft2 = 送付物宛先.get送付物宛先ソース().kakkoLeft2;
                source.samabunShimei2 = 送付物宛先.get送付物宛先ソース().samabunShimei2;
                source.kakkoLeft1 = 送付物宛先.get送付物宛先ソース().kakkoLeft1;
                source.samabunShimei1 = 送付物宛先.get送付物宛先ソース().samabunShimei1;
                source.samaBun1 = 送付物宛先.get送付物宛先ソース().samaBun1;
                source.samabunShimeiSmall1 = 送付物宛先.get送付物宛先ソース().samabunShimeiSmall1;
                source.customerBarCode = 送付物宛先.get送付物宛先ソース().customerBarCode;
                // TODO世帯主名 様方
            }
        }
    }

    private void set認証者ソース(KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource source) {
        if (sourceBuilder != null) {
            source.denshiKoin = sourceBuilder.denshiKoin;
            source.hakkoYMD = sourceBuilder.hakkoYMD;
            source.ninshoshaYakushokuMei = sourceBuilder.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = sourceBuilder.ninshoshaYakushokuMei1;
            source.koinMojiretsu = sourceBuilder.koinMojiretsu;
            source.ninshoshaYakushokuMei2 = sourceBuilder.ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = sourceBuilder.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = sourceBuilder.ninshoshaShimeiKakeru;
            source.koinShoryaku = sourceBuilder.koinShoryaku;
        }
    }

    private void set介護問合せ先ソースビルダー(KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource source) {
        if (介護問合せ先ソースビルダー != null) {
            CompKaigoToiawasesakiSource buildSource = 介護問合せ先ソースビルダー.buildSource();
            source.yubinBango = buildSource.yubinBango;
            source.shozaichi = buildSource.shozaichi;
            source.choshaBushoName = buildSource.choshaBushoName;
            source.tantoName = buildSource.tantoName;
            source.naisenNo = buildSource.naisenNo;
            source.naisenLabel = buildSource.naisenLabel;
            source.telNo = buildSource.telNo;
        }
    }
}
