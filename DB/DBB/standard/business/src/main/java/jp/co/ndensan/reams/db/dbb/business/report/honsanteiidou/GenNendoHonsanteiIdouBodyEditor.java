/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定異動（現年度）結果一覧表帳票BodyEditorクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouBodyEditor implements IGenNendoHonsanteiIdouEditor {

    private final KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private final KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final YMDHMS 調定日時;
    private final FlexibleYear 賦課年度;
    private final Association association;
    private final RString 住所編集;

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

    private static final RString 現金 = new RString("現金");
    private static final RString 口座 = new RString("口座");
    private static final RString 現金_0 = new RString("0");
    private static final RString 口座_1 = new RString("1");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString HYPHEN = new RString("-");
    private static final RString 特別徴収 = new RString("特別徴収");
    private static final RString 普通徴収 = new RString("普通徴収");
    private static final RString 併用徴収 = new RString("併用徴収");

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity {@link GenendoIdouKekkaIchiranInputEntity}
     */
    protected GenNendoHonsanteiIdouBodyEditor(GenendoIdouKekkaIchiranInputEntity inputEntity) {
        this.並び順の１件目 = inputEntity.get並び順の１件目();
        this.並び順の２件目 = inputEntity.get並び順の２件目();
        this.並び順の３件目 = inputEntity.get並び順の３件目();
        this.並び順の４件目 = inputEntity.get並び順の４件目();
        this.並び順の５件目 = inputEntity.get並び順の５件目();
        調定日時 = inputEntity.get調定日時();
        賦課年度 = inputEntity.get賦課年度();
        計算後情報_宛名_口座_更正前Entity = inputEntity.get計算後情報_宛名_口座_更正前Entity();
        計算後情報_宛名_口座_更正後Entity = inputEntity.get計算後情報_宛名_口座_更正後Entity();
        association = inputEntity.getAssociation();
        住所編集 = inputEntity.get住所編集();

    }

    /**
     * 本算定異動（現年度）結果一覧表帳票の項目編集です
     *
     * @param source GenNendoHonsanteiIdouSource
     * @return GenNendoHonsanteiIdouSource
     */
    @Override
    public GenNendoHonsanteiIdouSource edit(GenNendoHonsanteiIdouSource source) {

        RString 帳票作成年月日 = 調定日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        RString 年度 = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).getYear();
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時)
                .concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.nendo = 年度;
        if (association.get地方公共団体コード() != null) {
            source.hokenshaNo = association.get地方公共団体コード().value();
        }
        source.hokenshaName = association.get市町村名();
        if (計算後情報_宛名_口座_更正後Entity != null) {
            edit項目(source);
            source.list1_6 = get調定事由略称(計算後情報_宛名_口座_更正後Entity.get調定事由1());
            if (計算後情報_宛名_口座_更正前Entity != null && 計算後情報_宛名_口座_更正前Entity.get調定日時() != null) {
                source.list2_1 = 計算後情報_宛名_口座_更正前Entity.get調定日時().getDate().wareki().toDateString();
            }
            if (計算後情報_宛名_口座_更正前Entity != null && 計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額() != null) {
                source.list2_2 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity != null && 計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額() != null) {
                source.list2_3 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity != null && 計算後情報_宛名_口座_更正前Entity.get減免額() != null) {
                source.list2_4 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get減免額(), 0);
            }
            set月別取得段階(計算後情報_宛名_口座_更正前Entity, source);
            if (計算後情報_宛名_口座_更正前Entity != null && 計算後情報_宛名_口座_更正前Entity.get口座区分() != null) {
                RString 口座区分 = 計算後情報_宛名_口座_更正前Entity.get口座区分();
                source.list2_17 = 口座区分.equals(現金_0) ? 現金 : 口座;
            }
            source.list2_18 = get調定事由略称(計算後情報_宛名_口座_更正後Entity.get調定事由2());
            if (計算後情報_宛名_口座_更正後Entity.get調定日時() != null) {
                source.list3_1 = 計算後情報_宛名_口座_更正後Entity.get調定日時().getDate().wareki().toDateString();
            }
            if (計算後情報_宛名_口座_更正後Entity.get確定介護保険料_年額() != null) {
                source.list3_2 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get確定介護保険料_年額(), 0);
            }
            edit項目追加(source);
            edit項目追加2(source);
            edit項目追加3(source);
            edit項目追加4(source);
            edit項目追加5(source);
            edit項目追加6(source);
        }
        return source;
    }

    private void edit項目(GenNendoHonsanteiIdouSource source) {
        if (計算後情報_宛名_口座_更正後Entity.get被保険者番号() != null) {
            source.list1_1 = 計算後情報_宛名_口座_更正後Entity.get被保険者番号().value();
        }
        if (計算後情報_宛名_口座_更正後Entity.get通知書番号() != null) {
            source.list1_2 = 計算後情報_宛名_口座_更正後Entity.get通知書番号().value();
        }
        if (計算後情報_宛名_口座_更正後Entity.get宛名Entity() != null) {
            AtenaMeisho 漢字氏名 = 計算後情報_宛名_口座_更正後Entity.get宛名Entity().getKanjiShimei();
            source.list1_3 = 漢字氏名 == null ? null : 漢字氏名.getColumnValue();
        }
        source.list1_4 = 住所編集;
        if (計算後情報_宛名_口座_更正後Entity.get口座Entity() != null) {
            kozaJoho(source);
        }
    }

    /**
     * 本算定異動（現年度）結果一覧表帳票の項目編集です
     *
     * @param source GenNendoHonsanteiIdouSource
     * @return GenNendoHonsanteiIdouSource
     */
    public GenNendoHonsanteiIdouSource edit項目追加(GenNendoHonsanteiIdouSource source) {
        if (計算後情報_宛名_口座_更正後Entity != null) {
            if (計算後情報_宛名_口座_更正後Entity.get減免前介護保険料_年額() != null) {
                source.list3_3 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get減免前介護保険料_年額(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get減免額() != null) {
                source.list3_4 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get減免額(), 0);
            }
            set月別取得段階(計算後情報_宛名_口座_更正後Entity, source);
            if (計算後情報_宛名_口座_更正後Entity.get口座区分() != null) {
                RString 口座区分 = 計算後情報_宛名_口座_更正後Entity.get口座区分();
                source.list3_17 = 口座区分.equals(口座_1) ? 口座 : 現金;
            }
            source.list3_18 = get調定事由略称(計算後情報_宛名_口座_更正後Entity.get調定事由3());

            if (計算後情報_宛名_口座_更正前Entity == null) {
                return source;
            }
            if (計算後情報_宛名_口座_更正前Entity.get特徴期別金額01() != null) {
                source.list4_1 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get特徴期別金額02() != null) {
                source.list4_2 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get特徴期別金額03() != null) {
                source.list4_3 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get特徴期別金額04() != null) {
                source.list4_4 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額04(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get特徴期別金額05() != null) {
                source.list4_5 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額05(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get特徴期別金額06() != null) {
                source.list4_6 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額06(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額01() != null && !source.fuchoKi1.isEmpty()) {
                source.list4_7 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額02() != null && !source.fuchoKi2.isEmpty()) {
                source.list4_8 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額03() != null && !source.fuchoKi3.isEmpty()) {
                source.list4_9 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03(), 0);
            }
        }
        return source;
    }

    /**
     * 本算定異動（現年度）結果一覧表帳票の項目編集です
     *
     * @param source GenNendoHonsanteiIdouSource
     * @return GenNendoHonsanteiIdouSource
     */
    public GenNendoHonsanteiIdouSource edit項目追加2(GenNendoHonsanteiIdouSource source) {
        if (計算後情報_宛名_口座_更正前Entity != null) {
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額11() != null && !source.fuchoKi11.isEmpty()) {
                source.list4_17 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額11(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額12() != null && !source.fuchoKi12.isEmpty()) {
                source.list4_18 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額12(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額13() != null && !source.fuchoKi13.isEmpty()) {
                source.list4_19 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額13(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額14() != null && !source.fuchoKi14.isEmpty()) {
                source.list4_20 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額14(), 0);
            }
            Decimal 本算定特徴期合計 = nullTOZero(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01())
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get特徴期別金額04()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get特徴期別金額05())
                            .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get特徴期別金額06())));
            Decimal 本算定普徴期合計 = nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01())
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05())
                            .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06())))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額08()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額09()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額10())
                            .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額11())))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額12()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額13()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正前Entity.get普徴期別金額14()));
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                    && 本算定普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
                source.list4_21 = RString.EMPTY;
            }
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                    && 本算定普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
                source.list4_21 = 特別徴収;
            }
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                    && 本算定普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
                source.list4_21 = 普通徴収;
            }
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                    && 本算定普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
                source.list4_21 = 併用徴収;
            }
        }
        return source;
    }

    /**
     * 本算定異動（現年度）結果一覧表帳票の項目編集です
     *
     * @param source GenNendoHonsanteiIdouSource
     * @return GenNendoHonsanteiIdouSource
     */
    public GenNendoHonsanteiIdouSource edit項目追加3(GenNendoHonsanteiIdouSource source) {
        if (計算後情報_宛名_口座_更正後Entity != null) {
            source.list4_22 = get調定事由略称(計算後情報_宛名_口座_更正後Entity.get調定事由4());

            if (計算後情報_宛名_口座_更正後Entity.get特徴期別金額01() != null) {
                source.list5_1 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額01(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get特徴期別金額02() != null) {
                source.list5_2 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額02(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get特徴期別金額03() != null) {
                source.list5_3 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額03(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get特徴期別金額04() != null) {
                source.list5_4 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額04(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get特徴期別金額05() != null) {
                source.list5_5 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額05(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get特徴期別金額06() != null) {
                source.list5_6 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額06(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額01() != null && !source.fuchoKi1.isEmpty()) {
                source.list5_7 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額01(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額02() != null && !source.fuchoKi2.isEmpty()) {
                source.list5_8 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額02(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額03() != null && !source.fuchoKi3.isEmpty()) {
                source.list5_9 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額03(), 0);
            }
        }
        return source;
    }

    /**
     * 本算定異動（現年度）結果一覧表帳票の項目編集です
     *
     * @param source GenNendoHonsanteiIdouSource
     * @return GenNendoHonsanteiIdouSource
     */
    public GenNendoHonsanteiIdouSource edit項目追加4(GenNendoHonsanteiIdouSource source) {
        if (計算後情報_宛名_口座_更正後Entity != null) {
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額11() != null && !source.fuchoKi11.isEmpty()) {
                source.list5_17 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額11(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額12() != null && !source.fuchoKi12.isEmpty()) {
                source.list5_18 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額12(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額13() != null && !source.fuchoKi13.isEmpty()) {
                source.list5_19 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額13(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額14() != null && !source.fuchoKi14.isEmpty()) {
                source.list5_20 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額14(), 0);
            }
            Decimal 本算定後特徴期合計 = nullTOZero(計算後情報_宛名_口座_更正後Entity.get特徴期別金額01())
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get特徴期別金額02()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get特徴期別金額03()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get特徴期別金額04()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get特徴期別金額05())
                            .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get特徴期別金額06())));
            Decimal 本算定後普徴期合計 = nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額01())
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額02()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額03()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額04()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額05())
                            .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額06())))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額07()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額08()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額09()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額10())
                            .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額11())))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額12()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額13()))
                    .add(nullTOZero(計算後情報_宛名_口座_更正後Entity.get普徴期別金額14()));
            if ((本算定後特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                    && 本算定後普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
                source.list5_21 = RString.EMPTY;
            }
            if ((本算定後特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                    && 本算定後普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
                source.list5_21 = 特別徴収;
            }
            if ((本算定後特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                    && 本算定後普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
                source.list5_21 = 普通徴収;
            }
            if ((本算定後特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                    && 本算定後普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
                source.list5_21 = 併用徴収;
            }
            source.list5_22 = RString.EMPTY;
            source.shutsuryokujun1 = 並び順の１件目;
            source.shutsuryokujun2 = 並び順の２件目;
            source.shutsuryokujun3 = 並び順の３件目;
            source.shutsuryokujun4 = 並び順の４件目;
            source.shutsuryokujun5 = 並び順の５件目;
        }
        return source;
    }

    /**
     * 本算定異動（現年度）結果一覧表帳票の項目編集です
     *
     * @param source GenNendoHonsanteiIdouSource
     * @return GenNendoHonsanteiIdouSource
     */
    public GenNendoHonsanteiIdouSource edit項目追加5(GenNendoHonsanteiIdouSource source) {
        if (計算後情報_宛名_口座_更正前Entity != null) {
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額04() != null && !source.fuchoKi4.isEmpty()) {
                source.list4_10 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額05() != null && !source.fuchoKi5.isEmpty()) {
                source.list4_11 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額06() != null && !source.fuchoKi6.isEmpty()) {
                source.list4_12 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額07() != null && !source.fuchoKi7.isEmpty()) {
                source.list4_13 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額08() != null && !source.fuchoKi8.isEmpty()) {
                source.list4_14 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額08(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額09() != null && !source.fuchoKi9.isEmpty()) {
                source.list4_15 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額09(), 0);
            }
            if (計算後情報_宛名_口座_更正前Entity.get普徴期別金額10() != null && !source.fuchoKi10.isEmpty()) {
                source.list4_16 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額10(), 0);
            }
        }
        return source;
    }

    /**
     * 本算定異動（現年度）結果一覧表帳票の項目編集です
     *
     * @param source GenNendoHonsanteiIdouSource
     * @return GenNendoHonsanteiIdouSource
     */
    public GenNendoHonsanteiIdouSource edit項目追加6(GenNendoHonsanteiIdouSource source) {
        if (計算後情報_宛名_口座_更正後Entity != null) {
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額04() != null && !source.fuchoKi4.isEmpty()) {
                source.list5_10 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額04(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額05() != null && !source.fuchoKi5.isEmpty()) {
                source.list5_11 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額05(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額06() != null && !source.fuchoKi6.isEmpty()) {
                source.list5_12 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額06(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額07() != null && !source.fuchoKi7.isEmpty()) {
                source.list5_13 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額07(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額08() != null && !source.fuchoKi8.isEmpty()) {
                source.list5_14 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額08(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額09() != null && !source.fuchoKi9.isEmpty()) {
                source.list5_15 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額09(), 0);
            }
            if (計算後情報_宛名_口座_更正後Entity.get普徴期別金額10() != null && !source.fuchoKi10.isEmpty()) {
                source.list5_16 = DecimalFormatter
                        .toコンマ区切りRString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額10(), 0);
            }
        }
        return source;
    }

    private void set月別取得段階(KeisanjohoAtenaKozaEntity entity, GenNendoHonsanteiIdouSource item) {
        if (entity == null) {
            return;
        }
        RString 更正前後区分 = entity.get更正前後区分();
        FlexibleYearMonth 月割開始年月1 = entity.get月割開始年月1();
        if (月割開始年月1 == null || 月割開始年月1.isEmpty()) {
            return;
        }
        int 開始月1 = 月割開始年月1.getMonthValue();
        FlexibleYearMonth 月割終了年月1 = entity.get月割終了年月1();
        int 終了月1;
        if (月割終了年月1 == null || 月割終了年月1.isEmpty()) {
            終了月1 = NUM_3;
        } else {
            終了月1 = 月割終了年月1.getMonthValue();
        }
        if (entity.get保険料算定段階1().length() >= NUM_2) {
            RString 保険料算定段階1 = entity.get保険料算定段階1().substring(NUM_0, NUM_2).trimStart(CHAR_0);
            set月別取得段階(item, 開始月1, 終了月1, 保険料算定段階1, 更正前後区分);
        }
        FlexibleYearMonth 月割開始年月2 = entity.get月割開始年月2();
        if (月割開始年月2 == null || 月割開始年月2.isEmpty()) {
            return;
        }
        int 開始月2 = 月割開始年月2.getMonthValue();
        FlexibleYearMonth 月割終了年月2 = entity.get月割終了年月2();
        int 終了月2;
        if (月割終了年月2 == null || 月割終了年月2.isEmpty()) {
            終了月2 = NUM_3;
        } else {
            終了月2 = 月割終了年月2.getMonthValue();
        }
        if (entity.get保険料算定段階2().length() >= NUM_2) {
            RString 保険料算定段階2 = entity.get保険料算定段階2().substring(NUM_0, NUM_2).trimStart(CHAR_0);
            set月別取得段階(item, 開始月2, 終了月2, 保険料算定段階2, 更正前後区分);
        }
    }

    private void set月別取得段階(GenNendoHonsanteiIdouSource item, int 開始月, int 終了月,
            RString 保険料算定段階, RString 更正前後区分) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + NUM_12) : 終了月); i++) {
            int currentMonth = (i - 1) % NUM_12 + 1;
            if (更正前後区分_更正前.equals(更正前後区分)) {
                set更正前_保険料算定段階(item, currentMonth, 保険料算定段階);
            } else if (更正前後区分_更正後.equals(更正前後区分)) {
                set更正後_保険料算定段階(item, currentMonth, 保険料算定段階);
            }
        }
    }

    private void set更正前_保険料算定段階(GenNendoHonsanteiIdouSource item,
            int currentMonth, RString 保険料算定段階) {
        switch (currentMonth) {
            case NUM_1:
                item.list2_14 = 保険料算定段階;
                break;
            case NUM_2:
                item.list2_15 = 保険料算定段階;
                break;
            case NUM_3:
                item.list2_16 = 保険料算定段階;
                break;
            case NUM_4:
                item.list2_5 = 保険料算定段階;
                break;
            case NUM_5:
                item.list2_6 = 保険料算定段階;
                break;
            case NUM_6:
                item.list2_7 = 保険料算定段階;
                break;
            case NUM_7:
                item.list2_8 = 保険料算定段階;
                break;
            case NUM_8:
                item.list2_9 = 保険料算定段階;
                break;
            case NUM_9:
                item.list2_10 = 保険料算定段階;
                break;
            case NUM_10:
                item.list2_11 = 保険料算定段階;
                break;
            case NUM_11:
                item.list2_12 = 保険料算定段階;
                break;
            case NUM_12:
                item.list2_13 = 保険料算定段階;
                break;
            default:
                break;
        }
    }

    private void set更正後_保険料算定段階(GenNendoHonsanteiIdouSource item,
            int currentMonth, RString 保険料算定段階) {
        switch (currentMonth) {
            case NUM_1:
                item.list3_14 = 保険料算定段階;
                break;
            case NUM_2:
                item.list3_15 = 保険料算定段階;
                break;
            case NUM_3:
                item.list3_16 = 保険料算定段階;
                break;
            case NUM_4:
                item.list3_5 = 保険料算定段階;
                break;
            case NUM_5:
                item.list3_6 = 保険料算定段階;
                break;
            case NUM_6:
                item.list3_7 = 保険料算定段階;
                break;
            case NUM_7:
                item.list3_8 = 保険料算定段階;
                break;
            case NUM_8:
                item.list3_9 = 保険料算定段階;
                break;
            case NUM_9:
                item.list3_10 = 保険料算定段階;
                break;
            case NUM_10:
                item.list3_11 = 保険料算定段階;
                break;
            case NUM_11:
                item.list3_12 = 保険料算定段階;
                break;
            case NUM_12:
                item.list3_13 = 保険料算定段階;
                break;
            default:
                break;
        }
    }

    private void kozaJoho(GenNendoHonsanteiIdouSource source) {
        KozaRelateEntity releteEntity = 計算後情報_宛名_口座_更正後Entity.get口座Entity();
        IKoza koza = new Koza(releteEntity);
        if (koza.get金融機関コード() != null) {
            if (ゆうちょ銀行.equals(koza.get金融機関コード().value().substring(NUM_0, NUM_4)) && koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コードHander1(source, koza);
            } else {
                金融機関コードHander2(source, koza);
            }
        }
    }

    private void 金融機関コードHander1(GenNendoHonsanteiIdouSource source, IKoza koza) {
        RString 金融機関コード;
        RString 通帳記号;
        RString 通帳番号;
        if (koza.get通帳記号() != null && koza.get通帳番号() != null && koza.get口座名義人漢字() != null) {
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
            if (koza.getEdited通帳番号().length() >= NUM_8) {
                通帳番号 = koza.getEdited通帳番号().substring(NUM_0, NUM_8);
            } else {
                通帳番号 = koza.getEdited通帳番号();
            }
            source.list1_5 = 金融機関コード.concat(RString.FULL_SPACE)
                    .concat(通帳記号)
                    .concat(HYPHEN).concat(通帳番号)
                    .concat(RString.FULL_SPACE).concat(koza.get口座名義人漢字().toString());
        }
    }

    private void 金融機関コードHander2(GenNendoHonsanteiIdouSource source, IKoza koza) {
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
            if (koza.get預金種別().get預金種別略称().length() >= NUM_2) {
                預金種別略称 = koza.get預金種別().get預金種別略称().substring(NUM_0, NUM_2);
            } else {
                預金種別略称 = koza.get預金種別().get預金種別略称();
            }
            if (koza.get口座番号().length() >= NUM_7) {
                口座番号 = koza.get口座番号().substring(NUM_0, NUM_7);
            } else {
                口座番号 = koza.get口座番号();
            }
            source.list1_5 = 金融機関コード.concat(HYPHEN)
                    .concat(支店コード).concat(RString.FULL_SPACE)
                    .concat(預金種別略称)
                    .concat(HYPHEN).concat(口座番号).concat(RString.FULL_SPACE)
                    .concat(koza.get口座名義人漢字().toString());
        }
    }

    private RString get調定事由略称(RString 調定事由) {

        if (RString.isNullOrEmpty(調定事由)) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(), new Code(調定事由));
    }

    private Decimal nullTOZero(Decimal 特徴普徴期別金額) {
        if (特徴普徴期別金額 == null) {
            return Decimal.ZERO;
        }
        return 特徴普徴期別金額;
    }

}
