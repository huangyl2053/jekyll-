 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.core.chohyomongon.ChohyoMongonYoshiki;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchisho.KijunShunyugakuTekiyoKetteiTsuchishoSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
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
    private static final int INT_40 = 40;
    private final ChohyoSeigyoKyotsu 帳票制御共通;

    /**
     * コンストラクタです
     *
     * @param 基準収入額適用決定通知書パラメータ KijunShunyugakuTekiyoKetteiTsuchisho
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     */
    protected KijunShunyugakuTekiyoKetteiTsuchishoEditor(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書パラメータ,
            ChohyoSeigyoKyotsu 帳票制御共通) {
        this.基準収入額適用決定通知書パラメータ = 基準収入額適用決定通知書パラメータ;
        this.帳票制御共通 = 帳票制御共通;
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
            RString 被保険者名カナ１ = 基準収入額適用決定通知書パラメータ.get被保険者名カナ１().value();
            if (被保険者名カナ１.length() > INT_40) {
                被保険者名カナ１ = 被保険者名カナ１.substring(INT_0, INT_40);
            }
            source.hihokenshaNameKana1 = 被保険者名カナ１;
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者氏名１() != null) {
            source.hihokenshaName1 = 基準収入額適用決定通知書パラメータ.get被保険者氏名１().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者番号２() != null) {
            source.hihokenshaNo2 = 基準収入額適用決定通知書パラメータ.get被保険者番号２().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者名カナ２() != null) {
            RString 被保険者名カナ２ = 基準収入額適用決定通知書パラメータ.get被保険者名カナ２().value();
            if (被保険者名カナ２.length() > INT_40) {
                被保険者名カナ２ = 被保険者名カナ２.substring(INT_0, INT_40);
            }
            source.hihokenshaNameKana2 = 被保険者名カナ２;
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者氏名２() != null) {

            source.hihokenshaName2 = 基準収入額適用決定通知書パラメータ.get被保険者氏名２().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者番号３() != null) {
            source.hihokenshaNo3 = 基準収入額適用決定通知書パラメータ.get被保険者番号３().value();
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者名カナ３() != null) {
            RString 被保険者名カナ３ = 基準収入額適用決定通知書パラメータ.get被保険者名カナ３().value();
            if (被保険者名カナ３.length() > INT_40) {
                被保険者名カナ３ = 被保険者名カナ３.substring(INT_0, INT_40);
            }
            source.hihokenshaNameKana3 = 被保険者名カナ３;
        }
        if (基準収入額適用決定通知書パラメータ.get被保険者氏名３() != null) {
            source.hihokenshaName2 = 基準収入額適用決定通知書パラメータ.get被保険者氏名３().value();
        }
        source.sonotaHihokensha = 基準収入額適用決定通知書パラメータ.getその他被保険者();
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
        set帳票制御共通(source);
        source.拡張情報A1 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.hihokenshaNo1));
        source.拡張情報A2 = new ExpandedInformation(new Code("0004"), new RString("被保険者氏名"), get非空文字列(source.hihokenshaName1));
        source.拡張情報B1 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.hihokenshaNo2));
        source.拡張情報B2 = new ExpandedInformation(new Code("0004"), new RString("被保険者氏名"), get非空文字列(source.hihokenshaName2));
        source.拡張情報C1 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.hihokenshaNo3));
        source.拡張情報C2 = new ExpandedInformation(new Code("0004"), new RString("被保険者氏名"), get非空文字列(source.hihokenshaName3));
        return source;
    }

    private void set帳票制御共通(KijunShunyugakuTekiyoKetteiTsuchishoSource source) {
        if (帳票制御共通 != null) {
            if (ChohyoMongonYoshiki.フォント小.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
                source.tsuchibun1 = 基準収入額適用決定通知書パラメータ.get通知文１();
                source.tsuchibun2 = 基準収入額適用決定通知書パラメータ.get通知文２();
            } else if (ChohyoMongonYoshiki.フォント大.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
                source.tsuchibunLarge = 基準収入額適用決定通知書パラメータ.get通知文３_大();
            } else if (ChohyoMongonYoshiki.フォント混在_上小_下大.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
                source.tsuchibunMix1 = 基準収入額適用決定通知書パラメータ.get通知文4_上小();
                source.tsuchibunMix2 = 基準収入額適用決定通知書パラメータ.get通知文5_下大();
            } else if (ChohyoMongonYoshiki.フォント混在_上大_下小.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
                source.tsuchibunMixTwo1 = 基準収入額適用決定通知書パラメータ.get通知文6_上大();
                source.tsuchibunMixTwo2 = 基準収入額適用決定通知書パラメータ.get通知文7_下小();
            }
        }
    }

    private void set算定基準額(KijunShunyugakuTekiyoKetteiTsuchishoSource source) {
        if (基準収入額適用決定通知書パラメータ.get算定基準額() != null) {
            source.santeiKijunGaku = DecimalFormatter.toコンマ区切りRString(基準収入額適用決定通知書パラメータ.get算定基準額(), INT_0);
        }
    }

    private void set適用開始年月(KijunShunyugakuTekiyoKetteiTsuchishoSource source) {
        if (基準収入額適用決定通知書パラメータ.get適用開始年月() != null) {
            source.tekiyouStartYM = 基準収入額適用決定通知書パラメータ.get適用開始年月().wareki().toDateString();
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

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }
}
