/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100107;

import jp.co.ndensan.reams.db.dbc.definition.core.chohyomongon.ChohyoMongonYoshiki;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.JigyouKetteiTutisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100107.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス等支給（不支給）決定通知書（単）のEditorです。
 *
 * @reamsid_L DBC-5160-050 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor implements IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor {

    private final JigyouKetteiTutisyoEntity 決定通知書Entity;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final NinshoshaSource 認証者情報;

    /**
     * インスタンスを生成します。
     *
     * @param 決定通知書Entity JigyouKetteiTutisyoEntity
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 認証者情報 NinshoshaSource
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor(JigyouKetteiTutisyoEntity 決定通知書Entity,
            ChohyoSeigyoKyotsu 帳票制御共通, NinshoshaSource 認証者情報) {
        this.決定通知書Entity = 決定通知書Entity;
        this.帳票制御共通 = 帳票制御共通;
        this.認証者情報 = 認証者情報;
    }

    @Override
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource edit(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        return editSource(source);
    }

    private KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource editSource(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        setCompSofubutsuAtesaki(source);
        setCompNinshosha(source);
        setレイヤ1(source);
        if (帳票制御共通 != null && 帳票制御共通.get定型文文字サイズ() != null) {
            if (ChohyoMongonYoshiki.フォント小.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
                setレイヤ1通知文(source);
            } else if (ChohyoMongonYoshiki.フォント大.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
                setレイヤフォント大(source);
            } else if (ChohyoMongonYoshiki.フォント混在_上小_下大.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
                setレイヤフォント混在(source);
            } else if (ChohyoMongonYoshiki.フォント混在_上大_下小.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
                setレイヤフォント混在2(source);
            }
        }
        return source;
    }

    private void setCompSofubutsuAtesaki(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.yubinNo = 決定通知書Entity.get郵便番号();
        source.gyoseiku = 決定通知書Entity.get行政区();
        source.jusho1 = 決定通知書Entity.get住所１();
        source.jusho2 = 決定通知書Entity.get住所２();
        source.jusho3 = 決定通知書Entity.get住所３();
        source.jushoText = 決定通知書Entity.get住所();
        source.katagaki1 = 決定通知書Entity.get方書１();
        source.katagaki2 = 決定通知書Entity.get方書２();
        source.katagakiSmall1 = 決定通知書Entity.get方書小1();
        source.katagakiSmall2 = 決定通知書Entity.get方書小2();
        source.katagakiText = 決定通知書Entity.get方書();
        source.shimei1 = 決定通知書Entity.get氏名1();
        source.shimei2 = 決定通知書Entity.get氏名2();
        source.shimeiSmall1 = 決定通知書Entity.get小氏名1();
        source.shimeiSmall2 = 決定通知書Entity.get小氏名2();
        source.shimeiText = 決定通知書Entity.get氏名();
        source.meishoFuyo1 = 決定通知書Entity.get名称付与1();
        source.meishoFuyo2 = 決定通知書Entity.get名称付与2();
        source.dainoKubunMei = 決定通知書Entity.get代納区分名();
        source.samaBun1 = 決定通知書Entity.get様文1();
        source.samaBun2 = 決定通知書Entity.get様文2();
        source.samabunShimei1 = 決定通知書Entity.get様文氏名1();
        source.samabunShimei2 = 決定通知書Entity.get様文氏名2();
        source.samabunShimeiSmall1 = 決定通知書Entity.get小様文氏名1();
        source.samabunShimeiSmall2 = 決定通知書Entity.get小様文氏名2();
        source.samabunShimeiText = 決定通知書Entity.get様文氏名();
        source.kakkoLeft1 = 決定通知書Entity.get左括弧1();
        source.kakkoLeft2 = 決定通知書Entity.get左括弧2();
        source.kakkoRight1 = 決定通知書Entity.get右括弧1();
        source.kakkoRight2 = 決定通知書Entity.get右括弧2();
        source.customerBarCode = 決定通知書Entity.getカスタマバーコード();
    }

    private void setCompNinshosha(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.denshiKoin = 認証者情報.denshiKoin;
        source.hakkoYMD = 認証者情報.hakkoYMD;
        source.koinMojiretsu = 認証者情報.koinMojiretsu;
        source.koinShoryaku = 認証者情報.koinShoryaku;
        source.ninshoshaShimeiKakenai = 認証者情報.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = 認証者情報.ninshoshaShimeiKakeru;
        source.ninshoshaYakushokuMei = 認証者情報.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = 認証者情報.ninshoshaYakushokuMei1;
        source.ninshoshaYakushokuMei2 = 認証者情報.ninshoshaYakushokuMei2;

    }

    private void setレイヤ1(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.bunshoNo = 決定通知書Entity.get文書番号();
        source.sakuseiYmd = 決定通知書Entity.get作成年月日();
        source.title = 決定通知書Entity.getﾀｲﾄﾙ();
        source.tsuchibun1 = 決定通知書Entity.get文言1();
        source.hihokenshaName = 決定通知書Entity.get被保険者氏名();
        source.hihokenshaNo1 = 決定通知書Entity.get被保険者番号１();
        source.hihokenshaNo2 = 決定通知書Entity.get被保険者番号２();
        source.hihokenshaNo3 = 決定通知書Entity.get被保険者番号３();
        source.hihokenshaNo4 = 決定通知書Entity.get被保険者番号４();
        source.hihokenshaNo5 = 決定通知書Entity.get被保険者番号５();
        source.hihokenshaNo6 = 決定通知書Entity.get被保険者番号６();
        source.hihokenshaNo7 = 決定通知書Entity.get被保険者番号７();
        source.hihokenshaNo8 = 決定通知書Entity.get被保険者番号８();
        source.hihokenshaNo9 = 決定通知書Entity.get被保険者番号９();
        source.hihokenshaNo10 = 決定通知書Entity.get被保険者番号１０();
        source.uketsukeYMD = 決定通知書Entity.get受付年月日();
        source.ketteiYMD = 決定通知書Entity.get決定年月日();
        source.honninShiharaiGaku = 決定通知書Entity.get本人支払額();
        source.taishoYM = 決定通知書Entity.get対象年月();
        source.kyufuShu1 = 決定通知書Entity.get給付の種類１();
        source.kyufuShu2 = 決定通知書Entity.get給付の種類２();
        source.kyufuShu3 = 決定通知書Entity.get給付の種類３();
        source.kekka = 決定通知書Entity.get支給();
        source.ketteiGaku = 決定通知書Entity.get支給金額ﾀｲﾄﾙ();
        source.shikyuGaku = 決定通知書Entity.get支給金額();
        source.riyuTitle = 決定通知書Entity.get理由ﾀｲﾄﾙ();
        source.riyu1 = 決定通知書Entity.get理由１();
        source.riyu2 = 決定通知書Entity.get理由２();
        source.riyu3 = 決定通知書Entity.get理由３();
        source.torikeshi1 = 決定通知書Entity.get取消１();
        source.torikeshi2 = 決定通知書Entity.get取消２();
        source.mochimono1 = 決定通知書Entity.get持物１();
        source.mochimono2 = 決定通知書Entity.get持物２();
        source.mochimono3 = 決定通知書Entity.get持物３();
        source.shiharaiBasho = 決定通知書Entity.get支払場所();
        source.shiharaiStartYMD = 決定通知書Entity.get支払期間開始年月日();
        source.shiharaiEndYMD = 決定通知書Entity.get支払期間終了年月日();
        source.shiharaiStartHMS = 決定通知書Entity.get支払期間開始時間();
        source.karaFugo = 決定通知書Entity.get支払期間_２();
        source.shiharaiEndHMS = 決定通知書Entity.get支払期間終了時間();
        source.bankName = 決定通知書Entity.get金融機関名();
        source.branchBankName = 決定通知書Entity.get金融機関支店名();
        source.shumokuTitle = 決定通知書Entity.get種目ﾀｲﾄﾙ();
        source.kouzaShu = 決定通知書Entity.get口座種別();
        source.bangoTitle = 決定通知書Entity.get番号ﾀｲﾄﾙ();
        source.kouzaNo = 決定通知書Entity.get口座番号();
        source.kouzaMeigi = 決定通知書Entity.get口座名義人();
        source.tsuchiNo = 決定通知書Entity.get通知書番号() == null ? RString.EMPTY : 決定通知書Entity.get通知書番号().value();
        source.remban = 決定通知書Entity.get連番();
        source.title2_1 = 決定通知書Entity.getﾀｲﾄﾙ_2_1_取消し線用();
        source.title2_2_1 = 決定通知書Entity.getﾀｲﾄﾙ_2_2_1_取消し線用();
        source.title2_2_2 = 決定通知書Entity.getﾀｲﾄﾙ_2_2_2_取消し線用();
        source.title2_3_1 = 決定通知書Entity.getﾀｲﾄﾙ_2_3_1_取消し線用();
        source.title2_3_2 = 決定通知書Entity.getﾀｲﾄﾙ_2_3_2_取消し線用();
        source.title2_4 = 決定通知書Entity.getﾀｲﾄﾙ_2_4_取消し線用();
        source.title3_1 = 決定通知書Entity.getﾀｲﾄﾙ_3_1_取消し線用_調整用();
        source.title3_2_1 = 決定通知書Entity.getﾀｲﾄﾙ_3_2_1_取消し線用_調整用();
        source.title3_2_2 = 決定通知書Entity.getﾀｲﾄﾙ_3_2_2_取消し線用_調整用();
        source.title3_3_1 = 決定通知書Entity.getﾀｲﾄﾙ_3_3_1_取消し線用_調整用();
        source.title3_3_2 = 決定通知書Entity.getﾀｲﾄﾙ_3_3_2_取消し線用_調整用();
        source.title3_4 = 決定通知書Entity.getﾀｲﾄﾙ_3_4_取消し線用_調整用();
        source.torikeshiMochimono1 = 決定通知書Entity.get持ち物1_取り消し用();
        source.torikeshiMochimono2 = 決定通知書Entity.get持ち物2_取り消し用();
        source.torikeshiShiharaibasho = 決定通知書Entity.get支払場所_取り消し用();
        source.torikeshiShiharaikikan = 決定通知書Entity.get支払期間_取り消し用();
    }

    private void setレイヤ1通知文(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.toiawasesaki = 決定通知書Entity.get通知文1();
    }

    private void setレイヤフォント大(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunLarge = 決定通知書Entity.get通知文2大();
    }

    private void setレイヤフォント混在(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMix1 = 決定通知書Entity.get通知文3_上小();
        source.tsuchibunMix2 = 決定通知書Entity.get通知文4_下大();
    }

    private void setレイヤフォント混在2(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMixTwo1 = 決定通知書Entity.get通知文5_上大();
        source.tsuchibunMixTwo1 = 決定通知書Entity.get通知文6_下小();
    }

}
