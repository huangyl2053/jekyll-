/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.ShikakuKikan;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.ShikakuKikanJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 「本算定賦課計算」ボディEditorです。
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranEditor implements IHonsanteiKekkaIcihiranEditor {

    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity;
    private final FlexibleYear 賦課年度;
    private final YMDHMS 調定日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final RString 住所編集;
    private final List<RString> 出力順項目リスト;
    private final List<RString> 改頁項目リスト;
    private static final int NUM_負1 = -1;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final char CHAR_0 = '0';
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
    private final RString 特別徴収 = new RString("特別徴収");
    private final RString 普通徴収 = new RString("普通徴収");
    private final RString 併用徴収 = new RString("併用徴収");
    private final RString 本算定賦課なし = new RString("本算定賦課なし");
    private final RString 本算定前半普徴 = new RString("本算定前半普徴");
    private static final RString 作成 = new RString("作成");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座Entity KeisangojohoAtenaKozaEntity
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param 住所編集 RString
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     */
    public HonsanteiKekkaIcihiranEditor(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 市町村コード,
            RString 市町村名,
            RString 住所編集,
            List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト) {
        this.計算後情報_宛名_口座Entity = 計算後情報_宛名_口座Entity;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.住所編集 = 住所編集;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
    }

    @Override
    public HonsanteiKekkaIcihiranReportSource edit(HonsanteiKekkaIcihiranReportSource source) {
        return editSource(source);
    }

    private HonsanteiKekkaIcihiranReportSource editSource(HonsanteiKekkaIcihiranReportSource source) {

        editorSource_partONE(計算後情報_宛名_口座Entity, source);
        editorSource_partTWO(計算後情報_宛名_口座Entity, source);
        editorSource_partTHREE(計算後情報_宛名_口座Entity, source);
        return source;
    }

    private void editorSource_partONE(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity,
            HonsanteiKekkaIcihiranReportSource source) {
        if (調定日時 != null) {
            RString 帳票作成年月日 = 調定日時.getRDateTime().getDate().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時)
                    .concat(RString.HALF_SPACE).concat(作成);
        }
        if (賦課年度 != null) {
            source.nendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .fillType(FillType.BLANK).getYear();
        }
        source.hokenshaNo = 市町村コード;
        source.hokenshaName = 市町村名;
        set出力順(source);
        set改ページ(source);
        List<RString> 期の表記 = set普徴期();
        source.fuchoKi1 = 期の表記.get(NUM_0);
        source.fuchoKi2 = 期の表記.get(NUM_1);
        source.fuchoKi3 = 期の表記.get(NUM_2);
        source.fuchoKi4 = 期の表記.get(NUM_3);
        source.fuchoKi5 = 期の表記.get(NUM_4);
        source.fuchoKi6 = 期の表記.get(NUM_5);
        source.fuchoKi7 = 期の表記.get(NUM_6);
        source.fuchoKi8 = 期の表記.get(NUM_7);
        source.fuchoKi9 = 期の表記.get(NUM_8);
        source.fuchoKi10 = 期の表記.get(NUM_9);
        source.fuchoKi11 = 期の表記.get(NUM_10);
        source.fuchoKi12 = 期の表記.get(NUM_11);

        if (計算後情報_宛名_口座Entity.get通知書番号() != null) {
            source.listUpper_1 = new RString(計算後情報_宛名_口座Entity.get通知書番号().toString());
        }
        AtenaMeisho 氏名 = 計算後情報_宛名_口座Entity.get宛名Entity().getKanjiShimei();
        if (氏名 != null) {
            source.listUpper_2 = 氏名.value();
        }
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(計算後情報_宛名_口座Entity.get宛名Entity());
        FlexibleDate 生年月日 = 計算後情報_宛名_口座Entity.get宛名Entity().getSeinengappiYMD();
        if (生年月日 != null) {
            if (宛名.is日本人()) {
                source.listUpper_3 = 生年月日.wareki().toDateString();
            } else {
                source.listUpper_3 = 生年月日.seireki().toDateString();
            }
        }
        if (宛名.get性別() != null) {
            source.listUpper_4 = 宛名.get性別().code();
        }
        if (計算後情報_宛名_口座Entity.get世帯コード() != null) {
            source.listUpper_5 = 計算後情報_宛名_口座Entity.get世帯コード().value();
        }
        if (計算後情報_宛名_口座Entity.get識別コード() != null) {
            source.listUpper_6 = 計算後情報_宛名_口座Entity.get識別コード().value();
        }
        ChoikiCode 町域コード = 計算後情報_宛名_口座Entity.get宛名Entity().getChoikiCode();
        if (町域コード != null) {
            source.listUpper_7 = 町域コード.value();
        }
        YubinNo 郵便番号 = 計算後情報_宛名_口座Entity.get宛名Entity().getYubinNo();
        if (郵便番号 != null) {
            source.listUpper_8 = 郵便番号.value();
        }
        source.listUpper_9 = 住所編集;
        kozaJoho(source, 計算後情報_宛名_口座Entity);

    }

    private void editorSource_partTWO(KeisangojohoAtenaKozaEntity entity,
            HonsanteiKekkaIcihiranReportSource source) {
        if (entity.get被保険者番号() != null) {
            source.listCenter_1 = entity.get被保険者番号().value();
        }
        if (entity.get資格取得日() != null) {
            source.listCenter_2 = entity.get資格取得日().wareki().toDateString();
        }
        if (entity.get資格喪失日() != null) {
            source.listCenter_3 = entity.get資格喪失日().wareki().toDateString();
        }
        ShikakuKikan shikakuKikan = new ShikakuKikan();
        ShikakuKikanJoho shikakuKikanJoho = shikakuKikan.get資格期間(賦課年度,
                entity.get資格取得日(), entity.get資格喪失日());
        source.listCenter_4 = new RString(String.valueOf(shikakuKikanJoho.get月数()));
        if (entity.get確定介護保険料_年額() != null) {
            source.listCenter_5 = DecimalFormatter.toコンマ区切りRString(entity.get確定介護保険料_年額(), 0);
        }
        if (entity.get減免前介護保険料_年額() != null) {
            source.listCenter_6 = DecimalFormatter.toコンマ区切りRString(entity.get減免前介護保険料_年額(), 0);
        }
        if (entity.get減免額() != null) {
            source.listCenter_7 = DecimalFormatter.toコンマ区切りRString(entity.get減免額(), 0);
        }
        source.listCenter_8 = set徴収方法(entity);
        set月別取得段階(entity, source);
        source.listCenter_21 = set備考1(entity);

    }

    private void editorSource_partTHREE(KeisangojohoAtenaKozaEntity entity,
            HonsanteiKekkaIcihiranReportSource source) {
        source.listLower_1 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get特徴期別金額01()), 0);
        source.listLower_2 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get特徴期別金額02()), 0);
        source.listLower_3 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get特徴期別金額03()), 0);
        source.listLower_4 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get特徴期別金額04()), 0);
        source.listLower_5 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get特徴期別金額05()), 0);
        source.listLower_6 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get特徴期別金額06()), 0);
        set普徴額_x期(entity, source);
    }

    private void set普徴額_x期(KeisangojohoAtenaKozaEntity entity,
            HonsanteiKekkaIcihiranReportSource source) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList kitsukiList = 期月リスト_普徴.filtered本算定期間();
        Kitsuki 最終法定納期 = kitsukiList.get最終法定納期();
        if (最終法定納期.get期AsInt() == NUM_1) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
        } else {
            source.listLower_7 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_2) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
        } else {
            source.listLower_8 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_3) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
        } else {
            source.listLower_9 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_4) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
        } else {
            source.listLower_10 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_5) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0);
        } else {
            source.listLower_11 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_6) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0);
            source.listLower_12 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0);
        } else {
            source.listLower_12 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_7) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0);
            source.listLower_12 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0);
            source.listLower_13 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0);
        } else {
            source.listLower_13 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_8) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0);
            source.listLower_12 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0);
            source.listLower_13 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0);
            source.listLower_14 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0);
        } else {
            source.listLower_14 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_9) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0);
            source.listLower_12 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0);
            source.listLower_13 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0);
            source.listLower_14 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0);
            source.listLower_15 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0);
        } else {
            source.listLower_15 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_10) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0);
            source.listLower_12 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0);
            source.listLower_13 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0);
            source.listLower_14 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0);
            source.listLower_15 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0);
            source.listLower_16 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額10()), 0);
        } else {
            source.listLower_16 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_11) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0);
            source.listLower_12 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0);
            source.listLower_13 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0);
            source.listLower_14 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0);
            source.listLower_15 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0);
            source.listLower_16 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額10()), 0);
            source.listLower_17 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額11()), 0);
        } else {
            source.listLower_17 = RString.EMPTY;
        }
        if (最終法定納期.get期AsInt() == NUM_12) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0);
            source.listLower_12 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0);
            source.listLower_13 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0);
            source.listLower_14 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0);
            source.listLower_15 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0);
            source.listLower_16 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額10()), 0);
            source.listLower_17 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額11()), 0);
            source.listLower_18 = DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額12()), 0);
        } else {
            source.listLower_18 = RString.EMPTY;
        }
    }

    private void set出力順(HonsanteiKekkaIcihiranReportSource source) {
        if (出力順項目リスト != null && !出力順項目リスト.isEmpty()) {
            if (出力順項目リスト.size() > NUM_0) {
                source.shutsuryokujun1 = 出力順項目リスト.get(NUM_0);
            }
            if (出力順項目リスト.size() > NUM_1) {
                source.shutsuryokujun2 = 出力順項目リスト.get(NUM_1);
            }
            if (出力順項目リスト.size() > NUM_2) {
                source.shutsuryokujun3 = 出力順項目リスト.get(NUM_2);
            }
            if (出力順項目リスト.size() > NUM_3) {
                source.shutsuryokujun4 = 出力順項目リスト.get(NUM_3);
            }
            if (出力順項目リスト.size() > NUM_4) {
                source.shutsuryokujun5 = 出力順項目リスト.get(NUM_4);
            }
        }
    }

    private void set改ページ(HonsanteiKekkaIcihiranReportSource source) {
        if (改頁項目リスト != null && !改頁項目リスト.isEmpty()) {
            if (改頁項目リスト.size() > NUM_0) {
                source.kaipage1 = 改頁項目リスト.get(NUM_0);
            }
            if (改頁項目リスト.size() > NUM_1) {
                source.kaipage2 = 改頁項目リスト.get(NUM_1);
            }
            if (改頁項目リスト.size() > NUM_2) {
                source.kaipage3 = 改頁項目リスト.get(NUM_2);
            }
            if (改頁項目リスト.size() > NUM_3) {
                source.kaipage4 = 改頁項目リスト.get(NUM_3);
            }
            if (改頁項目リスト.size() > NUM_4) {
                source.kaipage5 = 改頁項目リスト.get(NUM_4);
            }
        }
    }

    private List<RString> set普徴期() {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 表記リスト = 期月リスト_普徴.toList();
        Kitsuki 最終法定納期 = 期月リスト_普徴.get最終法定納期();
        List<RString> 期の表記 = new ArrayList<>();
        for (Kitsuki 期 : 表記リスト) {
            if (期.get期AsInt() <= 最終法定納期.get期AsInt()) {
                期の表記.add(期.get表記().asX期());
            } else {
                期の表記.add(RString.EMPTY);
            }
        }
        return 期の表記;
    }

    private void kozaJoho(HonsanteiKekkaIcihiranReportSource source, KeisangojohoAtenaKozaEntity entity) {
        KozaRelateEntity releteEntity = entity.get口座Entity();
        IKoza koza = new Koza(releteEntity);
        if (koza.get金融機関コード() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4 && ゆうちょ銀行
                    .equals(koza.get金融機関コード().value().substring(NUM_0, NUM_4))) {
                金融機関コードHander1(source, koza);
            } else {
                金融機関コードHander2(source, koza);
            }
        }
    }

    private void 金融機関コードHander1(HonsanteiKekkaIcihiranReportSource source, IKoza koza) {
        RString 金融機関コード;
        RString 通帳記号;
        RString 通帳番号;
        if (koza.getEdited通帳記号() != null && koza.getEdited通帳番号() != null && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コード = koza.get金融機関コード().value().substring(NUM_0, NUM_4);
            } else {
                金融機関コード = koza.get金融機関コード().value();
            }
            if (koza.getEdited通帳記号().length() >= NUM_5) {
                通帳記号 = koza.getEdited通帳記号().substring(NUM_0, NUM_5);
            } else {
                通帳記号 = koza.getEdited通帳記号();
            }
            if (koza.get通帳番号().length() >= NUM_8) {
                通帳番号 = koza.getEdited通帳番号().substring(NUM_0, NUM_8);
            } else {
                通帳番号 = koza.getEdited通帳番号();
            }
            source.listUpper_10 = 金融機関コード.concat(RString.FULL_SPACE)
                    .concat(通帳記号)
                    .concat(HYPHEN).concat(通帳番号)
                    .concat(RString.FULL_SPACE).concat(koza.get口座名義人漢字().toString());
        }
    }

    private void 金融機関コードHander2(HonsanteiKekkaIcihiranReportSource source, IKoza koza) {
        RString 金融機関コード;
        RString 預金種別略称;
        RString 支店コード;
        RString 口座番号;
        if (koza.get支店コード() != null && koza.get口座番号() != null && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コード = koza.get金融機関コード().value().substring(NUM_0, NUM_4);
            } else {
                金融機関コード = koza.get金融機関コード().value();
            }
            if (koza.get支店コード().value().length() >= NUM_5) {
                支店コード = koza.get支店コード().value().substring(NUM_0, NUM_5);
            } else {
                支店コード = koza.get支店コード().value();
            }
            if (koza.get預金種別() != null && koza.get預金種別().get預金種別略称().length() >= NUM_2) {
                預金種別略称 = koza.get預金種別().get預金種別略称().substring(NUM_0, NUM_2);
            } else {
                預金種別略称 = koza.get預金種別().get預金種別略称();
            }
            if (koza.get口座番号().length() >= NUM_7) {
                口座番号 = koza.get口座番号().substring(NUM_0, NUM_7);
            } else {
                口座番号 = koza.get口座番号();
            }
            source.listUpper_10 = 金融機関コード.concat(HYPHEN)
                    .concat(支店コード).concat(RString.FULL_SPACE)
                    .concat(預金種別略称)
                    .concat(HYPHEN).concat(口座番号).concat(RString.FULL_SPACE)
                    .concat(koza.get口座名義人漢字().toString());
        }
    }

    private RString set徴収方法(KeisangojohoAtenaKozaEntity entity) {
        Decimal 特徴期の期別金額の合計 = nullTOZero(entity.get特徴期別金額04())
                .add(nullTOZero(entity.get特徴期別金額05()))
                .add(nullTOZero(entity.get特徴期別金額06()));
        Decimal 普徴期の期別金額の合計 = nullTOZero(entity.get普徴期別金額01())
                .add(nullTOZero(entity.get普徴期別金額02()).add(nullTOZero(entity.get普徴期別金額03())))
                .add(nullTOZero(entity.get普徴期別金額04())).add(nullTOZero(entity.get普徴期別金額05()))
                .add(nullTOZero(entity.get普徴期別金額06())).add(nullTOZero(entity.get普徴期別金額07()))
                .add(nullTOZero(entity.get普徴期別金額08())).add(nullTOZero(entity.get普徴期別金額09()))
                .add(nullTOZero(entity.get普徴期別金額10())).add(nullTOZero(entity.get普徴期別金額11()))
                .add(nullTOZero(entity.get普徴期別金額12())).add(nullTOZero(entity.get普徴期別金額13()))
                .add(nullTOZero(entity.get普徴期別金額14()));
        if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0 && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return RString.EMPTY;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1 && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 特別徴収;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1) {
            return 普通徴収;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1) {
            return 併用徴収;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set備考1(KeisangojohoAtenaKozaEntity entity) {
        Decimal 特徴期の期別金額の合計 = nullTOZero(entity.get特徴期別金額04())
                .add(nullTOZero(entity.get特徴期別金額05()))
                .add(nullTOZero(entity.get特徴期別金額06()));
        Decimal 普徴期の期別金額の合計 = nullTOZero(entity.get普徴期別金額01())
                .add(nullTOZero(entity.get普徴期別金額02()).add(nullTOZero(entity.get普徴期別金額03())))
                .add(nullTOZero(entity.get普徴期別金額04())).add(nullTOZero(entity.get普徴期別金額05()))
                .add(nullTOZero(entity.get普徴期別金額06())).add(nullTOZero(entity.get普徴期別金額07()))
                .add(nullTOZero(entity.get普徴期別金額08())).add(nullTOZero(entity.get普徴期別金額09()))
                .add(nullTOZero(entity.get普徴期別金額10())).add(nullTOZero(entity.get普徴期別金額11()))
                .add(nullTOZero(entity.get普徴期別金額12())).add(nullTOZero(entity.get普徴期別金額13()))
                .add(nullTOZero(entity.get普徴期別金額14()));
        if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0 && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 本算定賦課なし;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1 && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 本算定前半普徴;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) == NUM_負1) {
            return RString.EMPTY;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) == NUM_負1) {
            return RString.EMPTY;
        } else {
            return RString.EMPTY;
        }
    }

    private Decimal nullTOZero(Decimal 特徴普徴期別金額) {
        if (特徴普徴期別金額 == null) {
            return Decimal.ZERO;
        }
        return 特徴普徴期別金額;
    }

    private void set月別取得段階(KeisangojohoAtenaKozaEntity entity, HonsanteiKekkaIcihiranReportSource source) {
        RString 更正前後区分 = entity.get更正前後区分();
        FlexibleYearMonth 月割開始年月1 = entity.get月割開始年月1();
        int 開始月1 = 月割開始年月1.getMonthValue();
        FlexibleYearMonth 月割終了年月1 = entity.get月割終了年月1();
        int 終了月1 = 月割終了年月1.getMonthValue();
        if (entity.get保険料算定段階1().length() >= NUM_2) {
            RString 保険料算定段階1 = entity.get保険料算定段階1().substring(NUM_0, NUM_2).trimStart(CHAR_0);
            set月別取得段階(source, 開始月1, 終了月1, 保険料算定段階1, 更正前後区分);
        }
        FlexibleYearMonth 月割開始年月2 = entity.get月割開始年月2();
        int 開始月2 = 月割開始年月2.getMonthValue();
        FlexibleYearMonth 月割終了年月2 = entity.get月割終了年月2();
        int 終了月2 = 月割終了年月2.getMonthValue();
        if (entity.get保険料算定段階2().length() >= NUM_2) {
            RString 保険料算定段階2 = entity.get保険料算定段階2().substring(NUM_0, NUM_2).trimStart(CHAR_0);
            if (!月割開始年月2.isEmpty() && !月割終了年月2.isEmpty() && !保険料算定段階2.isEmpty()) {
                set月別取得段階(source, 開始月2, 終了月2, 保険料算定段階2, 更正前後区分);
            }
        }
    }

    private void set月別取得段階(HonsanteiKekkaIcihiranReportSource source, int 開始月, int 終了月,
            RString 保険料算定段階, RString 更正前後区分) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + NUM_12) : 終了月); i++) {
            int currentMonth = (i - 1) % NUM_12 + 1;
            if (更正前後区分_更正前.equals(更正前後区分)) {
                set更正前_保険料算定段階(source, currentMonth, 保険料算定段階);
            } else if (更正前後区分_更正後.equals(更正前後区分)) {
                set更正後_保険料算定段階(source, currentMonth, 保険料算定段階);
            }
        }
    }

    private void set更正前_保険料算定段階(HonsanteiKekkaIcihiranReportSource source,
            int currentMonth, RString 保険料算定段階) {
        switch (currentMonth) {
            case NUM_1:
                source.listCenter_18 = 保険料算定段階;
                break;
            case NUM_2:
                source.listCenter_19 = 保険料算定段階;
                break;
            case NUM_3:
                source.listCenter_20 = 保険料算定段階;
                break;
            case NUM_4:
                source.listCenter_9 = 保険料算定段階;
                break;
            case NUM_5:
                source.listCenter_10 = 保険料算定段階;
                break;
            case NUM_6:
                source.listCenter_11 = 保険料算定段階;
                break;
            case NUM_7:
                source.listCenter_12 = 保険料算定段階;
                break;
            case NUM_8:
                source.listCenter_13 = 保険料算定段階;
                break;
            case NUM_9:
                source.listCenter_14 = 保険料算定段階;
                break;
            case NUM_10:
                source.listCenter_15 = 保険料算定段階;
                break;
            case NUM_11:
                source.listCenter_16 = 保険料算定段階;
                break;
            case NUM_12:
                source.listCenter_17 = 保険料算定段階;
                break;
            default:
                break;
        }
    }

    private void set更正後_保険料算定段階(HonsanteiKekkaIcihiranReportSource source,
            int currentMonth, RString 保険料算定段階) {
        switch (currentMonth) {
            case NUM_1:
                source.listCenter_18 = 保険料算定段階;
                break;
            case NUM_2:
                source.listCenter_19 = 保険料算定段階;
                break;
            case NUM_3:
                source.listCenter_20 = 保険料算定段階;
                break;
            case NUM_4:
                source.listCenter_9 = 保険料算定段階;
                break;
            case NUM_5:
                source.listCenter_10 = 保険料算定段階;
                break;
            case NUM_6:
                source.listCenter_11 = 保険料算定段階;
                break;
            case NUM_7:
                source.listCenter_12 = 保険料算定段階;
                break;
            case NUM_8:
                source.listCenter_13 = 保険料算定段階;
                break;
            case NUM_9:
                source.listCenter_14 = 保険料算定段階;
                break;
            case NUM_10:
                source.listCenter_15 = 保険料算定段階;
                break;
            case NUM_11:
                source.listCenter_16 = 保険料算定段階;
                break;
            case NUM_12:
                source.listCenter_17 = 保険料算定段階;
                break;
            default:
                break;
        }
    }

}
