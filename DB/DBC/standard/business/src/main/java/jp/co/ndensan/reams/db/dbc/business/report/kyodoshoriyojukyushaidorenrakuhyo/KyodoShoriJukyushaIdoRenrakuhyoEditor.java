/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodoshoriyojukyushaidorenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushaidorenrakuhyo.KyodoShoriJukyushaIdoRenrakuhyoSource;
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
 * 帳票設計_DBCMN81003_共同処理用受給者異動連絡票（紙媒体）Editorのインターフェースクラスです。
 *
 * @reamsid_L DBC-1950-050 chenaoqi
 */
public class KyodoShoriJukyushaIdoRenrakuhyoEditor implements IKyodoShoriJukyushaIdoRenrakuhyoEditor {

    private final KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity targets;
    private final List<KoikiZenShichosonJoho> 広域市町村情報List;
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_4 = new RString("4");
    private static final RString 定数_01 = new RString("01");
    private static final RString 定数_02 = new RString("02");
    private static final RString 定数_03 = new RString("03");
    private static final RString 定数_99 = new RString("99");
    private static final RString セット = new RString("○");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_32 = 32;
    private static final int INDEX_38 = 38;

    /**
     * インスタンスを生成します。
     *
     * @param targets {@link KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity}
     * @param 広域市町村情報List List<KoikiZenShichosonJoho>
     */
    protected KyodoShoriJukyushaIdoRenrakuhyoEditor(KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity targets,
            List<KoikiZenShichosonJoho> 広域市町村情報List) {
        this.targets = targets;
        this.広域市町村情報List = 広域市町村情報List;
    }

    @Override
    public KyodoShoriJukyushaIdoRenrakuhyoSource edit(KyodoShoriJukyushaIdoRenrakuhyoSource source) {

        return editSource(source);
    }

    private KyodoShoriJukyushaIdoRenrakuhyoSource editSource(KyodoShoriJukyushaIdoRenrakuhyoSource source) {
        set被保険者(source);
        set住所(source);
        set異動年月日(source);
        set年月日(source);
        set異動事由区分(source);
        set世帯所得区分(source);
        set利用者負担(source);
        return source;
    }

    private void set被保険者(KyodoShoriJukyushaIdoRenrakuhyoSource source) {
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
        source.yubinNo = 郵便番号 != null ? 郵便番号.value() : RString.EMPTY;
        source.ichiSashiKingaku = DecimalFormatter
                .toコンマ区切りRString(targets.get一時差止金額(), 0);
        HihokenshaNo 世帯主被保険者番号 = targets.get世帯主被保険者番号();
        source.setainushiHihokenshaNo = 世帯主被保険者番号 != null ? 世帯主被保険者番号.value() : RString.EMPTY;

    }

    private void set異動年月日(KyodoShoriJukyushaIdoRenrakuhyoSource source) {
        FlexibleDate 異動年月日 = FlexibleDate.EMPTY;
        if (targets.get基本送付情報_異動年月日() != null && !targets.get基本送付情報_異動年月日().isEmpty()) {
            異動年月日 = targets.get基本送付情報_異動年月日();
        } else if (targets.get償還送付情報_異動年月日() != null && !targets.get償還送付情報_異動年月日().isEmpty()) {
            異動年月日 = targets.get償還送付情報_異動年月日();
        } else if (targets.get高額送付情報_異動年月日() != null && !targets.get高額送付情報_異動年月日().isEmpty()) {
            異動年月日 = targets.get高額送付情報_異動年月日();
        }
        FillTypeFormatted 異動年月日Format = dateFormat(異動年月日);
        source.idoGG = 異動年月日Format != null ? 異動年月日Format.getEra() : RString.EMPTY;
        RString 異動年 = 異動年月日Format != null ? 異動年月日Format.getYear() : null;
        source.idoYY = (異動年 != null && 異動年.length() >= INDEX_2)
                ? 異動年.substring(異動年.length() - INDEX_2, 異動年.length()) : RString.EMPTY;
        source.idoMM = 異動年月日Format != null ? 異動年月日Format.getMonth() : RString.EMPTY;
        source.idoDD = 異動年月日Format != null ? 異動年月日Format.getDay() : RString.EMPTY;

    }

    private void set住所(KyodoShoriJukyushaIdoRenrakuhyoSource source) {
        RString 住所カナ = targets.get住所カナ();
        source.jushoKana1 = (住所カナ != null && 住所カナ.length() >= INDEX_38)
                ? 住所カナ.substring(INDEX_0, INDEX_38) : RString.EMPTY;
        source.jushoKana2 = (住所カナ != null && 住所カナ.length() >= INDEX_38)
                ? 住所カナ.substring(INDEX_38, 住所カナ.length()) : RString.EMPTY;
        source.shutsuryokujunCode = targets.get帳票出力順序コード();
        RString 住所 = targets.get住所();
        source.jusho1 = (住所 != null && 住所.length() >= INDEX_32)
                ? 住所.substring(INDEX_0, INDEX_32) : RString.EMPTY;
        source.jusho2 = (住所 != null && 住所.length() >= INDEX_32)
                ? 住所.substring(INDEX_32, 住所.length()) : RString.EMPTY;
    }

    private void set年月日(KyodoShoriJukyushaIdoRenrakuhyoSource source) {
        FillTypeFormatted 作成年月日 = dateFormat(targets.get作成年月日());
        source.sakuseiGG = 作成年月日 != null ? 作成年月日.getEra() : RString.EMPTY;
        RString 作成年 = 作成年月日 != null ? 作成年月日.getYear() : null;
        source.sakuseiYY = (作成年 != null && 作成年.length() >= INDEX_2)
                ? 作成年.substring(作成年.length() - INDEX_2, 作成年.length()) : RString.EMPTY;
        source.sakuseiMM = 作成年月日 != null ? 作成年月日.getMonth() : RString.EMPTY;
        source.sakuseiDD = 作成年月日 != null ? 作成年月日.getDay() : RString.EMPTY;
        FillTypeFormatted 開始年月日 = dateFormat(targets.get開始年月日());
        source.kaishiGG = 開始年月日 != null ? 開始年月日.getEra() : RString.EMPTY;
        RString 開始年 = 開始年月日 != null ? 開始年月日.getYear() : null;
        source.kaishiYY = (開始年 != null && 開始年.length() >= INDEX_2)
                ? 開始年.substring(開始年.length() - INDEX_2, 開始年.length()) : RString.EMPTY;
        source.kaishiMM = 開始年月日 != null ? 開始年月日.getMonth() : RString.EMPTY;
        source.kaishiDD = 開始年月日 != null ? 開始年月日.getDay() : RString.EMPTY;
        FillTypeFormatted 終了年月日 = dateFormat(targets.get終了年月日());
        source.shuryoGG = 終了年月日 != null ? 終了年月日.getEra() : RString.EMPTY;
        RString 終了年 = 終了年月日 != null ? 終了年月日.getYear() : null;
        source.shuryoYY = (終了年 != null && 終了年.length() >= INDEX_2)
                ? 終了年.substring(終了年.length() - INDEX_2, 終了年.length()) : RString.EMPTY;
        source.shuryoMM = 終了年月日 != null ? 終了年月日.getMonth() : RString.EMPTY;
        source.shuryoDD = 終了年月日 != null ? 終了年月日.getDay() : RString.EMPTY;
    }

    private void set異動事由区分(KyodoShoriJukyushaIdoRenrakuhyoSource source) {
        if (定数_1.equals(targets.get異動区分())) {
            source.ichiSashiKbn1 = セット;
            source.idoKbn1 = セット;
        } else if (定数_2.equals(targets.get区分())) {
            source.ichiSashiKbn2 = セット;
            source.idoKbn2 = セット;
        }
        if (定数_01.equals(targets.get異動事由())) {
            source.idoJiyu1 = セット;
        } else if (定数_02.equals(targets.get異動事由())) {
            source.idoJiyu2 = セット;
        } else if (定数_03.equals(targets.get異動事由())) {
            source.idoJiyu3 = セット;
        } else if (定数_99.equals(targets.get異動事由())) {
            source.idoJiyu4 = セット;
        }
    }

    private void set世帯所得区分(KyodoShoriJukyushaIdoRenrakuhyoSource source) {
        if (定数_1.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn1 = セット;
        } else if (定数_2.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn2 = セット;
        } else if (定数_3.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn3 = セット;
        } else if (定数_4.equals(targets.get世帯所得区分())) {
            source.setaiShotokuKbn4 = セット;
        }
        if (定数_1.equals(targets.get所得区分())) {
            source.shotokuKbn1 = セット;
        } else if (定数_2.equals(targets.get所得区分())) {
            source.shotokuKbn2 = セット;
        } else if (定数_3.equals(targets.get所得区分())) {
            source.shotokuKbn3 = セット;
        } else if (定数_4.equals(targets.get所得区分())) {
            source.shotokuKbn4 = セット;
        }

    }

    private void set利用者負担(KyodoShoriJukyushaIdoRenrakuhyoSource source) {
        if (!targets.is利用者負担第２段階()) {
            source.riyoshaFutan1 = セット;
        } else {
            source.riyoshaFutan2 = セット;
        }
        if (!targets.is老齢福祉年金受給の有無()) {
            source.roreiUmu1 = セット;
        } else {
            source.roreiUmu2 = セット;
        }
        if (!targets.is支給申請書出力の有無()) {
            source.shikyuUmu1 = セット;
        } else {
            source.shikyuUmu2 = セット;
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
}
