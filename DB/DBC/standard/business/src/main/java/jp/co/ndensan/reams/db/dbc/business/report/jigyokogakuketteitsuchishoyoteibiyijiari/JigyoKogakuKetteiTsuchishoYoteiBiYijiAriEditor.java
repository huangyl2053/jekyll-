/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyoteibiyijiari;

import jp.co.ndensan.reams.db.dbc.business.core.servicenokanribangourendou.JigyouKetteiTutisyoResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.JigyouKetteiTutisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyoteibiyijiari.JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * 新総合事業・事業高額決定通知書（単）(支払予定日あり)帳票Editor
 *
 * @reamsid_L DBC-4760-040 yebangqiang
 */
public class JigyoKogakuKetteiTsuchishoYoteiBiYijiAriEditor implements IJigyoKogakuKetteiTsuchishoYoteiBiYijiAriEditor {

    private final JigyouKetteiTutisyoResult entity;
    private final ChohyoSeigyoKyotsu kyotsu;
    private final NinshoshaSource 認証者情報;
    private static final RString 定型文文字サイズ_レイヤ１ = new RString("1");
    private static final RString 定型文文字サイズ_レイヤフォント大 = new RString("2");
    private static final RString 定型文文字サイズ_レイヤフォント混在 = new RString("3");
    private static final RString 定型文文字サイズ_レイヤフォント混在2 = new RString("4");
    private static final RString 改行 = new RString("\n");

    /**
     * インスタンスを生成します。
     *
     * @param entity 決定通知書Entity
     * @param 認証者情報 NinshoshaSource
     * @param kyotsu 帳票制御共通
     */
    protected JigyoKogakuKetteiTsuchishoYoteiBiYijiAriEditor(JigyouKetteiTutisyoResult entity, NinshoshaSource 認証者情報,
            ChohyoSeigyoKyotsu kyotsu) {
        this.entity = entity;
        this.kyotsu = kyotsu;
        this.認証者情報 = 認証者情報;
    }

    @Override
    public JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource edit(JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource source) {
        final JigyouKetteiTutisyoEntity 決定通知書Entity = entity.get決定通知書Entity();
        if (決定通知書Entity != null) {
            source.yubinNo = 決定通知書Entity.get郵便番号();
            source.koinMojiretsu = 決定通知書Entity.get公印文字列();
            final RString 定型文文字サイズ = kyotsu.get定型文文字サイズ();
            if (定型文文字サイズ_レイヤ１.equals(定型文文字サイズ)) {
                source.bunshoNo = 決定通知書Entity.get文書番号();

            } else if (定型文文字サイズ_レイヤフォント大.equals(定型文文字サイズ)) {
                source.tsuchibunLarge = 決定通知書Entity.get通知文2大();
            } else if (定型文文字サイズ_レイヤフォント混在.equals(定型文文字サイズ)) {
                source.tsuchibunMix1 = 決定通知書Entity.get通知文3_上小();
                source.tsuchibunMix2 = 決定通知書Entity.get通知文4_下大();
            } else if (定型文文字サイズ_レイヤフォント混在2.equals(定型文文字サイズ)) {
                source.tsuchibunMixTwo1 = 決定通知書Entity.get通知文5_上大();
                source.tsuchibunMixTwo2 = 決定通知書Entity.get通知文6_下小();
            }
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
            source.sakuseiYmd = 決定通知書Entity.get作成年月日();
            source.title = 決定通知書Entity.getﾀｲﾄﾙ();
            source.tsuchibun1 = 決定通知書Entity.get文言1();
            source.tsuchibun2 = 決定通知書Entity.get文言2();
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
            source.kyufuShurui = conectRString(決定通知書Entity.get給付の種類１(), 決定通知書Entity.get給付の種類２(), 決定通知書Entity.get給付の種類３());
            source.kekka = 決定通知書Entity.get支給();
            source.ketteiGaku = 決定通知書Entity.get支給金額ﾀｲﾄﾙ();
            source.shikyuGaku = 決定通知書Entity.get支給金額();
            source.riyuTitle = 決定通知書Entity.get理由ﾀｲﾄﾙ();
            source.riyu = conectRString(決定通知書Entity.get理由１(), 決定通知書Entity.get理由２(), 決定通知書Entity.get理由３());
            source.torikeshi1 = 決定通知書Entity.get取消１();
            source.torikeshi2 = 決定通知書Entity.get取消２();
            source.mochimono = conectRString(決定通知書Entity.get持物１(), 決定通知書Entity.get持物２(), 決定通知書Entity.get持物３());
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
            source.sihaYoYmd = 決定通知書Entity.get支払予定日();
            if (決定通知書Entity.get通知書番号() != null) {
                source.tsuchiNo = 決定通知書Entity.get通知書番号().getColumnValue();
            }
            source.remban = 決定通知書Entity.get連番();
            source.toiawasesaki = 決定通知書Entity.get通知文1();
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
        return source;
    }

    private RString conectRString(RString firstLine, RString secendLine, RString thirdLine) {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(firstLine);
        rsb.append(改行);
        rsb.append(secendLine);
        rsb.append(改行);
        rsb.append(thirdLine);
        return rsb.toRString();
    }
}
