/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100020;

import jp.co.ndensan.reams.db.dbd.business.report.hanyo.HokenshaNameOutput;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KyoshitsuShubetsu;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100020.FutanGendogakuNinteishoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 負担限度額認定証ボディEditorです。
 *
 * @reamsid_L DBD-3540-040 wangchao
 */
public class FutanGendogakuNinteishoBodyEditor implements IFutanGendogakuNinteishoEditor {

    private final RString ハイフン = new RString("-");
    private final RString 金額単位 = new RString("円");
    private final RString ホシ = new RString("＊");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_10 = 10;
    private final FutanGendogakuNinteishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 負担限度額認定証
     */
    public FutanGendogakuNinteishoBodyEditor(FutanGendogakuNinteishoItem item) {
        this.item = item;
    }

    /**
     * 負担限度額認定証ボディEditorです。
     *
     * @param source 負担限度額認定証Source
     * @return 負担限度額認定証Source
     */
    @Override
    public FutanGendogakuNinteishoReportSource edit(FutanGendogakuNinteishoReportSource source) {
        return bodyEdit(source);
    }

    private FutanGendogakuNinteishoReportSource bodyEdit(FutanGendogakuNinteishoReportSource source) {
        source.kofuGengo = setWareki(item.get交付日()).substring(INDEX_0, INDEX_2);
        source.kofuYYYY = setWareki(item.get交付日()).substring(INDEX_2, INDEX_4);
        source.kofuMM = setWareki(item.get交付日()).substring(INDEX_5, INDEX_7);
        source.kofuDD = setWareki(item.get交付日()).substring(INDEX_8, INDEX_10);
        source.hihokenshaNo = item.get負担限度額認定().get被保険者番号().getColumnValue();

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通(), item.get地方公共団体());
        source.jusho = 編集後個人.get編集後住所();
        source.hihokenshaNameKana = new RString(編集後個人.get名称().getKana().toString());
        source.hihokenshaName = new RString(編集後個人.get名称().getName().toString());

        RString 元号 = setWareki(item.getIKojin().get生年月日().toFlexibleDate().toRDate()).substring(INDEX_0, INDEX_2);
        if (item.getIKojin().is日本人()) {
            if (new RString("明治").equals(元号)) {
                source.birthGengoMeiji = RString.EMPTY;
                source.birthGengoTaisho = ホシ;
                source.birthGengoShowa = ホシ;
            } else if (new RString("大正").equals(元号)) {
                source.birthGengoTaisho = RString.EMPTY;
                source.birthGengoMeiji = ホシ;
                source.birthGengoShowa = ホシ;
            } else if (new RString("昭和").equals(元号)) {
                source.birthGengoShowa = RString.EMPTY;
                source.birthGengoMeiji = ホシ;
                source.birthGengoTaisho = ホシ;
            } else {
                source.birthGengoMeiji = ホシ;
                source.birthGengoTaisho = ホシ;
                source.birthGengoShowa = ホシ;
            }
            source.birthYYYY = setWareki(item.getIKojin().get生年月日().toFlexibleDate().toRDate()).substring(INDEX_2, INDEX_4);
            source.birthMM = setWareki(item.getIKojin().get生年月日().toFlexibleDate().toRDate()).substring(INDEX_5, INDEX_7);
            source.birthDD = setWareki(item.getIKojin().get生年月日().toFlexibleDate().toRDate()).substring(INDEX_8, INDEX_10);
        } else {
            source.birthGengoMeiji = ホシ;
            source.birthGengoTaisho = ホシ;
            source.birthGengoShowa = ホシ;
            RString 生年月日 = item.getIKojin().get生年月日().toFlexibleDate().seireki().toDateString();
            source.birthYYYY = 生年月日.substring(INDEX_0, INDEX_4);
            source.birthMM = 生年月日.substring(INDEX_5, INDEX_7);
            source.birthDD = 生年月日.substring(INDEX_8, INDEX_10);
        }
        if (Gender.MALE.equals(item.getIKojin().get性別())) {
            source.man = RString.EMPTY;
            source.woman = ホシ;
        } else {
            source.man = ホシ;
            source.woman = RString.EMPTY;
        }

        source.tekiyoGengo = setWareki(item.get負担限度額認定().get適用開始年月日().toRDate()).substring(INDEX_0, INDEX_2);
        source.tekiyoYYYY = setWareki(item.get負担限度額認定().get適用開始年月日().toRDate()).substring(INDEX_2, INDEX_4);
        source.tekiyoMM = setWareki(item.get負担限度額認定().get適用開始年月日().toRDate()).substring(INDEX_5, INDEX_7);
        source.tekiyoDD = setWareki(item.get負担限度額認定().get適用開始年月日().toRDate()).substring(INDEX_8, INDEX_10);
        source.yukoGengo = setWareki(item.get負担限度額認定().get適用終了年月日().toRDate()).substring(INDEX_0, INDEX_2);
        source.yukoYYYY = setWareki(item.get負担限度額認定().get適用終了年月日().toRDate()).substring(INDEX_2, INDEX_4);
        source.yukoMM = setWareki(item.get負担限度額認定().get適用終了年月日().toRDate()).substring(INDEX_5, INDEX_7);
        source.yukoDD = setWareki(item.get負担限度額認定().get適用終了年月日().toRDate()).substring(INDEX_8, INDEX_10);

        setKyojuhiName(source, item);
        setFutanGaku(source, item);

        source.hokenshaNo1 = item.get負担限度額認定().get証記載保険者番号().getColumnValue().substring(INDEX_0, INDEX_1);
        source.hokenshaNo2 = item.get負担限度額認定().get証記載保険者番号().getColumnValue().substring(INDEX_1, INDEX_2);
        source.hokenshaNo3 = item.get負担限度額認定().get証記載保険者番号().getColumnValue().substring(INDEX_2, INDEX_3);
        source.hokenshaNo4 = item.get負担限度額認定().get証記載保険者番号().getColumnValue().substring(INDEX_3, INDEX_4);
        source.hokenshaNo5 = item.get負担限度額認定().get証記載保険者番号().getColumnValue().substring(INDEX_4, INDEX_5);
        source.hokenshaNo6 = item.get負担限度額認定().get証記載保険者番号().getColumnValue().substring(INDEX_5, INDEX_6);

        for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
            if (new RString(ChohyoSeigyoHanyoKeysDBD100020.保険者名表示.name()).equals(entity.getKomokuName())
                    && HokenshaNameOutput.印字する.getコード().equals(entity.getKomokuValue())) {
                source.hokenshaJusho = DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.hokenshaName1 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.hokenshaTelNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.denshiKoin = item.getNinshoshaSource().denshiKoin;
                break;
            }
        }

        source.shikibetsuCode = item.getIKojin().get識別コード().getColumnValue();

        return source;
    }

    private void setKyojuhiName(FutanGendogakuNinteishoReportSource source, FutanGendogakuNinteishoItem item) {
        source.kyojuhiName1 = KyoshitsuShubetsu.ユニット型個室.get名称();
        source.kyojuhiName2 = KyoshitsuShubetsu.ユニット型準個室.get名称();
        if (KyuSochishaKubun.非該当.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            source.kyojuhiName3 = KyoshitsuShubetsu.従来型個室.get名称().concat(new RString("（特養等）"));
        } else {
            source.kyojuhiName3 = KyoshitsuShubetsu.従来型個室.get名称();
        }

        if (KyuSochishaKubun.旧措置者.getコード().equals(item.get負担限度額認定().get旧措置者区分())
                || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            source.kyojuhiName4 = KyoshitsuShubetsu.多床室.get名称();
            source.kyojuhiName5 = RString.EMPTY;
        } else {
            source.kyojuhiName4 = KyoshitsuShubetsu.従来型個室_老健_療養等.get名称();
            source.kyojuhiName5 = KyoshitsuShubetsu.多床室.get名称();
        }
    }

    private void setFutanGaku(FutanGendogakuNinteishoReportSource source, FutanGendogakuNinteishoItem item) {
        if (!Decimal.ZERO.equals(item.get負担限度額認定().get食費負担限度額()) && (item.get負担限度額認定().get食費負担限度額() != null)) {
            source.shokujiGendoGaku = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get食費負担限度額(), 0);
            source.en1 = 金額単位;

        } else {
            if (item.get負担限度額認定().is境界層該当者区分()) {
                source.shokujiGendoGaku = ハイフン;
            } else {
                source.shokujiGendoGaku = RString.EMPTY;
            }
            source.en1 = RString.EMPTY;
        }

        if (!Decimal.ZERO.equals(item.get負担限度額認定().getユニット型個室()) && (item.get負担限度額認定().getユニット型個室() != null)) {
            source.kyojuhiGendoGaku1 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().getユニット型個室(), 0);
            source.en2 = 金額単位;
        } else {
            if (item.get負担限度額認定().is境界層該当者区分()
                    || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
                source.kyojuhiGendoGaku1 = ハイフン;
            } else {
                source.kyojuhiGendoGaku1 = RString.EMPTY;
            }
            source.en2 = RString.EMPTY;
        }

        if (!Decimal.ZERO.equals(item.get負担限度額認定().getユニット型準個室()) && (item.get負担限度額認定().getユニット型準個室() != null)) {
            source.kyojuhiGendoGaku2 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().getユニット型準個室(), 0);
            source.en3 = 金額単位;
        } else {
            if (item.get負担限度額認定().is境界層該当者区分()
                    || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
                source.kyojuhiGendoGaku2 = ハイフン;
            } else {
                source.kyojuhiGendoGaku2 = RString.EMPTY;
            }
            source.en3 = RString.EMPTY;
        }

        if (!Decimal.ZERO.equals(item.get負担限度額認定().get従来型個室_特養等()) && (item.get負担限度額認定().get従来型個室_特養等() != null)) {
            source.kyojuhiGendoGaku3 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get従来型個室_特養等(), 0);
            source.en4 = 金額単位;
        } else {
            if (item.get負担限度額認定().is境界層該当者区分()
                    || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
                source.kyojuhiGendoGaku3 = ハイフン;
            } else {
                source.kyojuhiGendoGaku3 = RString.EMPTY;
            }
            source.en4 = RString.EMPTY;
        }

        if (KyuSochishaKubun.旧措置者.getコード().equals(item.get負担限度額認定().get旧措置者区分())
                || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            if (!Decimal.ZERO.equals(item.get負担限度額認定().get多床室()) && (item.get負担限度額認定().get多床室() != null)) {
                source.kyojuhiGendoGaku4 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get多床室(), 0);
                source.en5 = 金額単位;
            } else {
                if (item.get負担限度額認定().is境界層該当者区分()
                        || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
                    source.kyojuhiGendoGaku4 = ハイフン;
                } else {
                    source.kyojuhiGendoGaku4 = RString.EMPTY;
                }
                source.en5 = RString.EMPTY;
            }
        } else {
            if (!Decimal.ZERO.equals(item.get負担限度額認定().get従来型個室_老健_療養等()) && (item.get負担限度額認定().get従来型個室_老健_療養等() != null)) {
                source.kyojuhiGendoGaku4 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get従来型個室_老健_療養等(), 0);
                source.en5 = 金額単位;
            } else {
                if (item.get負担限度額認定().is境界層該当者区分()) {
                    source.kyojuhiGendoGaku4 = ハイフン;
                } else {
                    source.kyojuhiGendoGaku4 = RString.EMPTY;
                }
                source.en5 = RString.EMPTY;
            }
        }
        if (KyuSochishaKubun.旧措置者.getコード().equals(item.get負担限度額認定().get旧措置者区分())
                || KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(item.get負担限度額認定().get旧措置者区分())) {
            source.kyojuhiGendoGaku5 = RString.EMPTY;
            source.en6 = RString.EMPTY;
        } else {
            if (!Decimal.ZERO.equals(item.get負担限度額認定().get多床室()) && (item.get負担限度額認定().get多床室() != null)) {
                source.kyojuhiGendoGaku5 = DecimalFormatter.toコンマ区切りRString(item.get負担限度額認定().get多床室(), 0);
                source.en6 = 金額単位;
            } else {
                if (item.get負担限度額認定().is境界層該当者区分()) {
                    source.kyojuhiGendoGaku5 = ハイフン;
                } else {
                    source.kyojuhiGendoGaku5 = RString.EMPTY;
                }
                source.en6 = RString.EMPTY;
            }
        }
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(kojin, 帳票制御共通, 地方公共団体);
    }

    private RString setWareki(RDate 日付) {
        return 日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }
}
