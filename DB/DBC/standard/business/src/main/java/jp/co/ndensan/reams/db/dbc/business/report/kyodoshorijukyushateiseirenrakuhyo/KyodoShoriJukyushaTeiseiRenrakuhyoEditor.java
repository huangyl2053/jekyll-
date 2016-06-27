/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodoshorijukyushateiseirenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
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
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_4 = new RString("4");
    private static final RString SPIT = new RString("-");
    private static final RString FORMAT_MARU = new RString("○");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_32 = 32;
    private static final int INDEX_38 = 38;

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
        source.yubinNo = get郵便番号(郵便番号);
        if (targets.get一時差止金額() != null) {
            source.ichiSashiKingaku = DecimalFormatter
                    .toコンマ区切りRString(targets.get一時差止金額(), 0);
        }
        HihokenshaNo 世帯主被保険者番号 = targets.get世帯主被保険者番号();
        source.setainushiHihokenshaNo = 世帯主被保険者番号 != null ? 世帯主被保険者番号.value() : RString.EMPTY;

    }

    private void set異動年月日(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        FlexibleDate 異動年月日 = FlexibleDate.EMPTY;
        if (targets.get基本送付情報_異動年月日() != null && !targets.get基本送付情報_異動年月日().isEmpty()) {
            異動年月日 = targets.get基本送付情報_異動年月日();
        } else if (targets.get償還送付情報_異動年月日() != null && !targets.get償還送付情報_異動年月日().isEmpty()) {
            異動年月日 = targets.get償還送付情報_異動年月日();
        } else if (targets.get高額送付情報_異動年月日() != null && !targets.get高額送付情報_異動年月日().isEmpty()) {
            異動年月日 = targets.get高額送付情報_異動年月日();
        }
        FillTypeFormatted 異動年月日Format = dateFormat(異動年月日);
        if (異動年月日Format != null) {
            source.idoGG = 異動年月日Format.getEra();
            RString 異動年 = 異動年月日Format.getYear();
            source.idoYY = getYear(異動年);
            source.idoMM = 異動年月日Format.getMonth();
            source.idoDD = 異動年月日Format.getDay();
        }

        FillTypeFormatted 訂正年月日 = dateFormat(targets.get訂正年月日());
        if (訂正年月日 != null) {
            source.teiseiGG = 訂正年月日.getEra();
            RString 訂正年 = 訂正年月日.getYear();
            source.teiseiYY = getYear(訂正年);
            source.teiseiMM = 訂正年月日.getMonth();
            source.teiseiDD = 訂正年月日.getDay();
        }

    }

    private void set住所(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        RString 住所カナ = targets.get住所カナ();
        if (住所カナ != null) {
            source.jushoKana1 = (住所カナ.length() >= INDEX_38
                    ? 住所カナ.substring(INDEX_0, INDEX_38) : 住所カナ.substring(INDEX_0, 住所カナ.length()));
            source.jushoKana2 = (住所カナ.length() >= INDEX_38
                    ? 住所カナ.substring(INDEX_38, 住所カナ.length()) : RString.EMPTY);
        }
        source.shutsuryokujunCode = targets.get帳票出力順序コード();
        RString 住所 = targets.get住所();
        if (住所 != null) {
            source.jusho1 = (住所.length() >= INDEX_32
                    ? 住所.substring(INDEX_0, INDEX_32) : 住所.substring(INDEX_0, 住所.length()));
            source.jusho2 = (住所.length() >= INDEX_32
                    ? 住所.substring(INDEX_32, 住所.length()) : RString.EMPTY);
        }
    }

    private void set年月日(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        FillTypeFormatted 作成年月日 = dateFormat(targets.get作成年月日());
        if (作成年月日 != null) {
            source.sakuseiGG = 作成年月日.getEra();
            RString 作成年 = 作成年月日.getYear();
            source.sakuseiYY = getYear(作成年);
            source.sakuseiMM = 作成年月日.getMonth();
            source.sakuseiDD = 作成年月日.getDay();
        }
        FillTypeFormatted 開始年月日 = dateFormat(targets.get開始年月日());
        if (開始年月日 != null) {
            source.kaishiGG = 開始年月日.getEra();
            RString 開始年 = 開始年月日.getYear();
            source.kaishiYY = getYear(開始年);
            source.kaishiMM = 開始年月日.getMonth();
            source.kaishiDD = 開始年月日.getDay();
        }
        FillTypeFormatted 終了年月日 = dateFormat(targets.get終了年月日());
        if (終了年月日 != null) {
            source.shuryoGG = 終了年月日.getEra();
            RString 終了年 = 終了年月日.getYear();
            source.shuryoYY = getYear(終了年);
            source.shuryoMM = 終了年月日.getMonth();
            source.shuryoDD = 終了年月日.getDay();
        }
    }

    private void set訂正区分(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        if (定数_2.equals(targets.get訂正区分())) {
            source.teiseiKbn1 = FORMAT_MARU;
        } else if (定数_3.equals(targets.get訂正区分())) {
            source.teiseiKbn2 = FORMAT_MARU;
        }
        if (定数_1.equals(targets.get区分())) {
            source.ichiSashiKbn1 = FORMAT_MARU;
        } else if (定数_2.equals(targets.get区分())) {
            source.ichiSashiKbn2 = FORMAT_MARU;
        }
    }

    private void set世帯所得区分(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        if (定数_1.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn1 = FORMAT_MARU;
        } else if (定数_2.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn2 = FORMAT_MARU;
        } else if (定数_3.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn3 = FORMAT_MARU;
        } else if (定数_4.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn4 = FORMAT_MARU;
        }
        if (定数_1.equals(targets.get所得区分())) {
            source.shotokuKbn1 = FORMAT_MARU;
        } else if (定数_2.equals(targets.get所得区分())) {
            source.shotokuKbn2 = FORMAT_MARU;
        } else if (定数_3.equals(targets.get所得区分())) {
            source.shotokuKbn3 = FORMAT_MARU;
        } else if (定数_4.equals(targets.get所得区分())) {
            source.shotokuKbn4 = FORMAT_MARU;
        }

    }

    private void set利用者負担(KyodoShoriJukyushaTeiseiRenrakuhyoSource source) {
        // QA:865
        if (!targets.is利用者負担第２段階()) {
            source.riyoshaFutan1 = FORMAT_MARU;
        } else {
            source.riyoshaFutan2 = FORMAT_MARU;
        }
        if (!targets.is老齢福祉年金受給の有無()) {
            source.roreiUmu1 = FORMAT_MARU;
        } else {
            source.roreiUmu2 = FORMAT_MARU;
        }
        if (!targets.is支給申請書出力の有無()) {
            source.shikyuUmu1 = FORMAT_MARU;
        } else {
            source.shikyuUmu2 = FORMAT_MARU;
        }
    }

    private FillTypeFormatted dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO);
    }

    private RString getYear(RString 年) {
        RString year = RString.EMPTY;
        if (年 != null && INDEX_2 <= 年.length()) {
            year = 年.substring(年.length() - INDEX_2, 年.length());
        }
        return year;
    }

    private RString get郵便番号(YubinNo 郵便番号) {
        if (郵便番号 == null) {
            return RString.EMPTY;
        }
        RString 郵便番号format = RString.EMPTY;
        if (郵便番号.value().length() > INDEX_3) {
            郵便番号format = 郵便番号.value().substring(INDEX_0, INDEX_3).concat(SPIT)
                    .concat(郵便番号.value().substring(INDEX_3, 郵便番号.value().length()));
        } else if (郵便番号.value().length() == INDEX_3) {
            郵便番号format = 郵便番号.value();
        }
        return 郵便番号format;
    }
}
