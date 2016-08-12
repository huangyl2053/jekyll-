 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchisho.KijunShunyugakuTekiyoKetteiTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票Editorクラスです。
 *
 * @reamsid_L DBC-4610-040 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchishoEditor implements
        IKijunShunyugakuTekiyoKetteiTsuchishoEditor {

    private final KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書パラメータ;
    private static final int INT_0 = 0;

    /**
     * コンストラクタです
     *
     * @param 基準収入額適用決定通知書パラメータ KijunShunyugakuTekiyoKetteiTsuchisho
     */
    protected KijunShunyugakuTekiyoKetteiTsuchishoEditor(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書パラメータ) {
        this.基準収入額適用決定通知書パラメータ = 基準収入額適用決定通知書パラメータ;
    }

    @Override
    public KijunShunyugakuTekiyoKetteiTsuchishoSource edit(KijunShunyugakuTekiyoKetteiTsuchishoSource source) {
        source.bunshoNo = 基準収入額適用決定通知書パラメータ.get文書番号();
        source.title = 基準収入額適用決定通知書パラメータ.getタイトル();
        set申請年月日(source);
        set決定年月日(source);
        set適用開始年月(source);
        set算定基準額(source);
        if (基準収入額適用決定通知書パラメータ.get被保険者番号１() != null) {
            source.hihokenshaNo1 = 基準収入額適用決定通知書パラメータ.get被保険者番号１().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者名カナ１() != null) {
            source.hihokenshaNameKana1 = 基準収入額適用決定通知書パラメータ.get被保険者名カナ１().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者氏名１() != null) {
            source.hihokenshaName1 = 基準収入額適用決定通知書パラメータ.get被保険者氏名１().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者番号２() != null) {
            source.hihokenshaNo2 = 基準収入額適用決定通知書パラメータ.get被保険者番号２().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者名カナ２() != null) {
            source.hihokenshaNameKana2 = 基準収入額適用決定通知書パラメータ.get被保険者名カナ２().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者氏名２() != null) {
            source.hihokenshaName2 = 基準収入額適用決定通知書パラメータ.get被保険者氏名２().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者番号３() != null) {
            source.hihokenshaNo3 = 基準収入額適用決定通知書パラメータ.get被保険者番号３().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者名カナ３() != null) {
            source.hihokenshaNameKana3 = 基準収入額適用決定通知書パラメータ.get被保険者名カナ３().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者氏名３() != null) {
            source.hihokenshaName3 = 基準収入額適用決定通知書パラメータ.get被保険者氏名３().value();
        }
        source.sonotaHihokensha = 基準収入額適用決定通知書パラメータ.getその他被保険者();
        source.tsuchibun1 = 基準収入額適用決定通知書パラメータ.get通知文１();
        source.tsuchibun2 = 基準収入額適用決定通知書パラメータ.get通知文２();
        source.tsuchibunLarge = 基準収入額適用決定通知書パラメータ.get通知文３_大();
        source.tsuchibunMix1 = 基準収入額適用決定通知書パラメータ.get通知文4_上小();
        source.tsuchibunMix2 = 基準収入額適用決定通知書パラメータ.get通知文5_下大();
        source.tsuchibunMixTwo1 = 基準収入額適用決定通知書パラメータ.get通知文6_上大();
        source.tsuchibunMixTwo2 = 基準収入額適用決定通知書パラメータ.get通知文7_下小();
        if (基準収入額適用決定通知書パラメータ.getCompNinshoshaソース() != null) {
            source.hakkoYMD = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().hakkoYMD;
            source.denshiKoin = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().denshiKoin;
            source.ninshoshaYakushokuMei = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().ninshoshaYakushokuMei1;
            source.koinMojiretsu = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().koinMojiretsu;
            source.ninshoshaYakushokuMei2 = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().ninshoshaShimeiKakeru;
            source.koinShoryaku = 基準収入額適用決定通知書パラメータ.getCompNinshoshaソース().koinShoryaku;
        }
        if (基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース() != null) {
            source.yubinNo = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().yubinNo;
            source.gyoseiku2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().gyoseiku;
            source.jusho4 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().jusho1;
            source.jushoText = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().jushoText;
            source.jusho5 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().jusho2;
            source.jusho6 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().jusho3;
            source.katagakiText = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().katagakiText;
            source.katagaki3 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().katagaki1;
            source.katagakiSmall2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().katagakiSmall2;
            source.katagaki4 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().katagaki2;
            source.katagakiSmall1 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().katagakiSmall1;
            source.shimei5 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().shimei1;
            source.shimeiSmall2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().shimeiSmall2;
            source.shimeiText = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().shimeiText;
            source.meishoFuyo2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().meishoFuyo2;
            source.shimeiSmall1 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().shimeiSmall1;
            source.dainoKubunMei = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().dainoKubunMei;
            source.shimei6 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().shimei2;
            source.meishoFuyo1 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().meishoFuyo1;
            source.samabunShimeiText = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().samabunShimeiText;
            source.kakkoLeft2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().kakkoLeft2;
            source.samabunShimei2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().samabunShimei2;
            source.samabunShimeiSmall2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().samabunShimeiSmall2;
            source.samaBun2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().samaBun2;
            source.kakkoRight2 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().kakkoRight2;
            source.kakkoLeft1 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().kakkoLeft1;
            source.samabunShimei1 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().samabunShimei1;
            source.samaBun1 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().samaBun1;
            source.kakkoRight1 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().kakkoRight1;
            source.samabunShimeiSmall1 = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().samabunShimeiSmall1;
            source.customerBarCode = 基準収入額適用決定通知書パラメータ.getCompSofubutsuAtesakiソース().customerBarCode;
        }
        if (基準収入額適用決定通知書パラメータ.get識別コード１() != null) {
            source.shikibetsuCode1 = 基準収入額適用決定通知書パラメータ.get識別コード１().value();
        }
        if (基準収入額適用決定通知書パラメータ.get識別コード２() != null) {
            source.shikibetsuCode2 = 基準収入額適用決定通知書パラメータ.get識別コード２().value();
        }
        if (基準収入額適用決定通知書パラメータ.get識別コード３() != null) {
            source.shikibetsuCode3 = 基準収入額適用決定通知書パラメータ.get識別コード３().value();
        }
        return source;
    }

    private void set算定基準額(KijunShunyugakuTekiyoKetteiTsuchishoSource source) {
        if (基準収入額適用決定通知書パラメータ.get算定基準額() != null) {
            source.santeiKijunGaku = DecimalFormatter.toコンマ区切りRString(基準収入額適用決定通知書パラメータ.get算定基準額(), INT_0);
        }
    }

    private void set適用開始年月(KijunShunyugakuTekiyoKetteiTsuchishoSource source) {
        if (基準収入額適用決定通知書パラメータ.get適用開始年月() != null) {
            source.tekiyouStartYM = 基準収入額適用決定通知書パラメータ.get適用開始年月().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
    }

    private void set決定年月日(KijunShunyugakuTekiyoKetteiTsuchishoSource source) {
        if (基準収入額適用決定通知書パラメータ.get決定年月日() != null) {
            source.ketteiYMD = 基準収入額適用決定通知書パラメータ.get決定年月日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
    }

    private void set申請年月日(KijunShunyugakuTekiyoKetteiTsuchishoSource source) {
        if (基準収入額適用決定通知書パラメータ.get申請年月日() != null) {
            source.shinseiYMD = 基準収入額適用決定通知書パラメータ.get申請年月日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
    }
}
