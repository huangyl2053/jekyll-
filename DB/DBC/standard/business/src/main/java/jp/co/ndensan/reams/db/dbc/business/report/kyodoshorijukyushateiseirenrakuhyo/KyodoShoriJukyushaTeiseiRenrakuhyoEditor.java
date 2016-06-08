/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodoshorijukyushateiseirenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBCMN81004_共同処理用受給者訂正連絡票（紙媒体）Editorのインターフェースクラスです。
 *
 * @reamsid_L DBC-1951-060 chenaoqi
 */
public class KyodoShoriJukyushaTeiseiRenrakuhyoEditor implements IKyodoShoriJukyushaTeiseiRenrakuhyoEditor {

    private final KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity targets;
    private final List<KoikiZenShichosonJoho> 広域市町村情報List;
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString RSTRING_4 = new RString("2");
    private static final RString セット = new RString("○");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_32 = 32;
    private static final int INDEX_38 = 38;
    private static final int INDEX_64 = 64;
    private static final int INDEX_75 = 75;

    /**
     * インスタンスを生成します。
     *
     * @param targets {@link KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity}
     * @param 広域市町村情報List List<KoikiZenShichosonJoho>
     */
    protected KyodoShoriJukyushaTeiseiRenrakuhyoEditor(KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity targets,
            List<KoikiZenShichosonJoho> 広域市町村情報List) {
        this.targets = targets;
        this.広域市町村情報List = 広域市町村情報List;
    }

    @Override
    public KyodoShoriJukyushaTeiseiRenrakuhyoSource edit(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {

        return editSource(source);
    }

    private KyodoShoriJukyushaTeiseiRenrakuhyoSource editSource(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        set被保険者(source);
        set住所(source);
        set異動年月日(source);
        set年月日(source);
        set訂正区分(source);
        set世帯所得区分(source);
        set利用者負担(source);
        return source;
    }

    private void set被保険者(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        if (広域市町村情報List != null && !広域市町村情報List.isEmpty()) {
            source.hokenshaName = 広域市町村情報List.get(INDEX_0).get市町村名称();
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = targets.get証記載保険者番号();
        source.shoHokenshaNo = 証記載保険者番号 != null ? 証記載保険者番号.value() : RString.EMPTY;
        HihokenshaNo 被保険者番号 = targets.get被保険者番号();
        source.hihokenshaNo = 被保険者番号 != null ? 被保険者番号.value() : RString.EMPTY;
        source.hihokenshaName = targets.get氏名();
        TelNo 電話番号 = targets.get電話番号();
        source.telNo = 電話番号 != null ? 電話番号.value() : RString.EMPTY;
        YubinNo 郵便番号 = targets.get郵便番号();
        source.telNo = 郵便番号 != null ? 郵便番号.value() : RString.EMPTY;

        source.ichiSashiKingaku = DecimalFormatter
                .toコンマ区切りRString(targets.get一時差止金額(), 0);
        HihokenshaNo 世帯主被保険者番号 = targets.get世帯主被保険者番号();
        source.setainushiHihokenshaNo = 世帯主被保険者番号 != null ? 世帯主被保険者番号.value() : RString.EMPTY;

    }

    private void set異動年月日(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        FlexibleDate 異動年月日 = FlexibleDate.EMPTY;
        if (targets.get基本送付情報_異動年月日() != null) {
            異動年月日 = targets.get基本送付情報_異動年月日();
        } else if (targets.get償還送付情報_異動年月日() != null) {
            異動年月日 = targets.get償還送付情報_異動年月日();
        } else if (targets.get高額送付情報_異動年月日() != null) {
            異動年月日 = targets.get高額送付情報_異動年月日();
        }
        source.idoGG = 異動年月日 != null ? 異動年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getEra() : RString.EMPTY;
        RString 異動年 = 異動年月日 != null ? 異動年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getYear() : null;
        source.idoYY = (異動年 != null && 異動年.length() >= INDEX_2)
                ? 異動年.substring(異動年.length() - INDEX_2, 異動年.length()) : RString.EMPTY;
        source.idoMM = 異動年月日 != null ? 異動年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getMonth() : RString.EMPTY;
        source.idoDD = 異動年月日 != null ? 異動年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getDay() : RString.EMPTY;

        FlexibleDate 訂正年月日 = targets.get訂正年月日();
        source.teiseiGG = 訂正年月日 != null ? 訂正年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getEra() : RString.EMPTY;
        RString 訂正年 = 訂正年月日 != null ? 訂正年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getYear() : null;
        source.teiseiYY = (訂正年 != null && 訂正年.length() >= INDEX_2)
                ? 訂正年.substring(訂正年.length() - INDEX_2, 訂正年.length()) : RString.EMPTY;
        source.teiseiMM = 訂正年月日 != null ? 訂正年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getMonth() : RString.EMPTY;
        source.teiseiDD = 訂正年月日 != null ? 訂正年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getDay() : RString.EMPTY;

    }

    private void set住所(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        RString 住所カナ = targets.get住所カナ();

        source.jushoKana1 = (住所カナ != null && 住所カナ.length() >= INDEX_38)
                ? 住所カナ.substring(INDEX_0, INDEX_38) : RString.EMPTY;
        source.jushoKana2 = (住所カナ != null && 住所カナ.length() >= INDEX_75)
                ? 住所カナ.substring(INDEX_38, INDEX_75) : RString.EMPTY;
        source.shutsuryokujunCode = targets.get帳票出力順序コード();
        RString 住所 = targets.get住所();
        source.jusho1 = (住所 != null && 住所.length() >= INDEX_32)
                ? 住所.substring(INDEX_0, INDEX_32) : RString.EMPTY;
        source.jusho2 = (住所 != null && 住所.length() >= INDEX_64)
                ? 住所.substring(INDEX_32, INDEX_64) : RString.EMPTY;
    }

    private void set年月日(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        FlexibleDate 作成年月日 = targets.get作成年月日();
        source.sakuseiGG = 作成年月日 != null ? 作成年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getEra() : RString.EMPTY;
        RString 作成年 = 作成年月日 != null ? 作成年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getYear() : null;
        source.sakuseiYY = (作成年 != null && 作成年.length() >= INDEX_2)
                ? 作成年.substring(作成年.length() - INDEX_2, 作成年.length()) : RString.EMPTY;
        source.sakuseiMM = 作成年月日 != null ? 作成年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getMonth() : RString.EMPTY;
        source.sakuseiDD = 作成年月日 != null ? 作成年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getDay() : RString.EMPTY;
        FlexibleDate 開始年月日 = targets.get開始年月日();
        source.kaishiGG = 開始年月日 != null ? 開始年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getEra() : RString.EMPTY;
        RString 開始年 = 開始年月日 != null ? 開始年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getYear() : null;
        source.kaishiYY = (開始年 != null && 開始年.length() >= INDEX_2)
                ? 開始年.substring(開始年.length() - INDEX_2, 開始年.length()) : RString.EMPTY;
        source.kaishiMM = 開始年月日 != null ? 開始年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getMonth() : RString.EMPTY;
        source.kaishiDD = 開始年月日 != null ? 開始年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getDay() : RString.EMPTY;
        FlexibleDate 終了年月日 = targets.get終了年月日();
        source.shuryoGG = 終了年月日 != null ? 終了年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getEra() : RString.EMPTY;
        RString 終了年 = 終了年月日 != null ? 終了年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getYear() : null;
        source.shuryoYY = (終了年 != null && 終了年.length() >= INDEX_2)
                ? 終了年.substring(終了年.length() - INDEX_2, 終了年.length()) : RString.EMPTY;
        source.shuryoMM = 終了年月日 != null ? 終了年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getMonth() : RString.EMPTY;
        source.shuryoDD = 終了年月日 != null ? 終了年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).getDay() : RString.EMPTY;
    }

    private void set訂正区分(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        if (RSTRING_2.equals(targets.get訂正区分())) {
            source.teiseiKbn1 = セット;
        } else {
            source.teiseiKbn1 = RString.EMPTY;
        }
        if (RSTRING_3.equals(targets.get訂正区分())) {
            source.teiseiKbn2 = セット;
        } else {
            source.teiseiKbn2 = RString.EMPTY;
        }
        if (RSTRING_1.equals(targets.get異動区分())) {
            source.ichiSashiKbn1 = セット;
        } else {
            source.ichiSashiKbn1 = RString.EMPTY;
        }
        if (RSTRING_2.equals(targets.get異動区分())) {
            source.ichiSashiKbn2 = セット;
        } else {
            source.ichiSashiKbn2 = RString.EMPTY;
        }
    }

    private void set世帯所得区分(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        if (RSTRING_1.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn1 = セット;
        } else {
            source.setaiShotokuKbn1 = RString.EMPTY;
        }
        if (RSTRING_2.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn2 = セット;
        } else {
            source.setaiShotokuKbn2 = RString.EMPTY;
        }
        if (RSTRING_3.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn3 = セット;
        } else {
            source.setaiShotokuKbn3 = RString.EMPTY;
        }
        if (RSTRING_4.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn4 = セット;
        } else {
            source.setaiShotokuKbn4 = RString.EMPTY;
        }
        if (RSTRING_1.equals(targets.get所得区分())) {
            source.shotokuKbn1 = セット;
        } else {
            source.shotokuKbn1 = RString.EMPTY;
        }
        if (RSTRING_2.equals(targets.get所得区分())) {
            source.shotokuKbn2 = セット;
        } else {
            source.shotokuKbn2 = RString.EMPTY;
        }
        if (RSTRING_3.equals(targets.get所得区分())) {
            source.shotokuKbn3 = セット;
        } else {
            source.shotokuKbn3 = RString.EMPTY;
        }
        if (RSTRING_4.equals(targets.get所得区分())) {
            source.shotokuKbn4 = セット;
        } else {
            source.shotokuKbn4 = RString.EMPTY;
        }

    }

    private void set利用者負担(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        if (!targets.is利用者負担第２段階()) {
            source.riyoshaFutan1 = セット;
            source.riyoshaFutan2 = RString.EMPTY;
        } else {
            source.riyoshaFutan1 = RString.EMPTY;
            source.riyoshaFutan2 = セット;
        }
        if (!targets.is老齢福祉年金受給の有無()) {
            source.roreiUmu1 = セット;
            source.roreiUmu2 = RString.EMPTY;
        } else {
            source.roreiUmu1 = RString.EMPTY;
            source.roreiUmu2 = セット;
        }
        if (!targets.is支給申請書出力の有無()) {
            source.shikyuUmu1 = セット;
            source.shikyuUmu2 = RString.EMPTY;
        } else {
            source.shikyuUmu1 = RString.EMPTY;
            source.shikyuUmu2 = セット;
        }
    }
}
