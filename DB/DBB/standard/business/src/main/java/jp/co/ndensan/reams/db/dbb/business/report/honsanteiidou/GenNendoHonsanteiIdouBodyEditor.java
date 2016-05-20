/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定異動（現年度）結果一覧表帳票BodyEditorクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouBodyEditor implements IGenNendoHonsanteiIdouEditor {

    private final KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private final KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;
    private final RString shutsuryokujunID;
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
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    private static final RString 現金 = new RString("現金");
    private static final RString 口座 = new RString("口座");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString SAKUSEI = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity {@link GenendoIdouKekkaIchiranInputEntity}
     */
    protected GenNendoHonsanteiIdouBodyEditor(GenendoIdouKekkaIchiranInputEntity inputEntity) {
        shutsuryokujunID = inputEntity.getShutsuryokujunID();
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
        source.printTimeStamp = 帳票作成年月日.concat(" " + 帳票作成時 + " " + SAKUSEI);
        source.nendo = 年度;
        if (association.get地方公共団体コード() != null) {
            source.hokenshaNo = association.get地方公共団体コード().value();
        }
        if (association.get市町村名() != null) {
            source.hokenshaName = association.get市町村名();
        }
        set出力順(source);
        if (計算後情報_宛名_口座_更正後Entity != null) {
            if (計算後情報_宛名_口座_更正後Entity.get被保険者番号() != null) {
                source.list1_1 = 計算後情報_宛名_口座_更正後Entity.get被保険者番号().value();
            }
            if (計算後情報_宛名_口座_更正後Entity.get通知書番号() != null) {
                source.list1_2 = 計算後情報_宛名_口座_更正後Entity.get通知書番号().value();
            }
            AtenaMeisho 漢字氏名 = 計算後情報_宛名_口座_更正後Entity.get宛名Entity().getKanjiShimei();
            if (漢字氏名 != null) {
                source.list1_3 = 漢字氏名.value();
            }
            source.list1_4 = 住所編集;
            KozaRelateEntity releteEntity = 計算後情報_宛名_口座_更正後Entity.get口座Entity();
            IKoza koza = new Koza(releteEntity);
            if (ゆうちょ銀行.equals(koza.get金融機関コード().value().substring(NUM_0, NUM_4))) {
                source.list1_5 = koza.get金融機関コード().value().substring(NUM_0, NUM_4).concat(" " + koza.getEdited通帳記号()
                        .substring(NUM_0, NUM_5)).concat("-" + koza.get通帳番号().substring(NUM_0, NUM_8))
                        .concat(" " + koza.get口座名義人漢字().toString());
            } else {
                source.list1_5 = koza.get金融機関コード().value().substring(NUM_0, NUM_4).concat("-" + koza.get支店コード().value()
                        .substring(NUM_0, NUM_3))//.concat(" " + koza.get預金種別().get預金種別略称().substring(NUM_0, NUM_2))
                        .concat("-" + koza.get口座番号().substring(NUM_0, NUM_7)).concat(" " + koza.get口座名義人漢字().toString());
            }
            source.list1_6 = 計算後情報_宛名_口座_更正後Entity.get調定事由1();
            source.list2_1 = 計算後情報_宛名_口座_更正前Entity.get調定日時().getDate().wareki().toDateString();
            source.list2_2 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額(), 0);
            source.list2_3 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額(), 0);
            source.list2_4 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get減免額(), 0);
            set月別取得段階(計算後情報_宛名_口座_更正前Entity, source);
            if (現金.equals(koza.get口座表示区分().getCode())) {
                source.list2_17 = 現金;
            } else {
                source.list2_17 = 口座;
            }
            source.list2_18 = 計算後情報_宛名_口座_更正後Entity.get調定事由2();
            source.list3_1 = 計算後情報_宛名_口座_更正後Entity.get調定日時().getDate().wareki().toDateString();
            source.list3_2 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額(), 0);
            source.list3_3 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額(), 0);
            source.list3_4 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get減免額(), 0);
            set月別取得段階(計算後情報_宛名_口座_更正前Entity, source);
            if (現金.equals(koza.get口座表示区分().getCode())) {
                source.list3_17 = 現金;
            } else {
                source.list3_17 = 口座;
            }
            source.list3_18 = 計算後情報_宛名_口座_更正後Entity.get調定事由3();
            editAdd(source);
        }
        return source;
    }

    /**
     * 本算定異動（現年度）結果一覧表帳票の項目編集です
     *
     * @param source GenNendoHonsanteiIdouSource
     * @return GenNendoHonsanteiIdouSource
     */
    public GenNendoHonsanteiIdouSource editAdd(GenNendoHonsanteiIdouSource source) {
        if (計算後情報_宛名_口座_更正後Entity != null) {
            source.list4_1 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01(), 0);
            source.list4_2 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02(), 0);
            source.list4_3 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03(), 0);
            source.list4_4 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額04(), 0);
            source.list4_5 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額05(), 0);
            source.list4_6 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額06(), 0);
            source.list4_7 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01(), 0);
            source.list4_8 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02(), 0);
            source.list4_9 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03(), 0);
            source.list4_10 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04(), 0);
            source.list4_11 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05(), 0);
            source.list4_12 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06(), 0);
            source.list4_13 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07(), 0);
            source.list4_14 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額08(), 0);
            source.list4_15 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額09(), 0);
            source.list4_16 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額10(), 0);
            source.list4_17 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額11(), 0);
            source.list4_18 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額12(), 0);
            source.list4_19 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額13(), 0);
            source.list4_20 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額14(), 0);
            Decimal 本算定特徴期合計 = 計算後情報_宛名_口座_更正前Entity.get特徴期別金額01()
                    .add(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02())
                    .add(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03())
                    .add(計算後情報_宛名_口座_更正前Entity.get特徴期別金額04())
                    .add(計算後情報_宛名_口座_更正前Entity.get特徴期別金額05()
                            .add(計算後情報_宛名_口座_更正前Entity.get特徴期別金額06()));
            Decimal 本算定普徴期合計 = 計算後情報_宛名_口座_更正前Entity.get普徴期別金額01()
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02())
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03())
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04())
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05()
                            .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06()))
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07())
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額08())
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額09())
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額10()
                            .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額11()))
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額12())
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額13())
                    .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額14());
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                    && 本算定普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
                source.list4_21 = RString.EMPTY;
            }
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                    && 本算定普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
                source.list4_21 = new RString("特別徴収");
            }
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                    && 本算定普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
                source.list4_21 = new RString("普通徴収");
            }
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                    && 本算定普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
                source.list4_21 = new RString("併用徴収");
            }
            source.list4_22 = 計算後情報_宛名_口座_更正後Entity.get調定事由4();
            source.list5_1 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01(), 0);
            source.list5_2 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02(), 0);
            source.list5_3 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03(), 0);
            source.list5_4 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額04(), 0);
            source.list5_5 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額05(), 0);
            source.list5_6 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額06(), 0);
            source.list5_7 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01(), 0);
            source.list5_8 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02(), 0);
            source.list5_9 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03(), 0);
            source.list5_10 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04(), 0);
            source.list5_11 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05(), 0);
            source.list5_12 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06(), 0);
            source.list5_13 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07(), 0);
            source.list5_14 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額08(), 0);
            source.list5_15 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額09(), 0);
            source.list5_16 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額10(), 0);
            source.list5_17 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額11(), 0);
            source.list5_18 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額12(), 0);
            source.list5_19 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額13(), 0);
            source.list5_20 = DecimalFormatter.toコンマ区切りRString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額14(), 0);
            Decimal 本算定後特徴期合計 = 計算後情報_宛名_口座_更正後Entity.get特徴期別金額01()
                    .add(計算後情報_宛名_口座_更正後Entity.get特徴期別金額02())
                    .add(計算後情報_宛名_口座_更正後Entity.get特徴期別金額03())
                    .add(計算後情報_宛名_口座_更正後Entity.get特徴期別金額04())
                    .add(計算後情報_宛名_口座_更正後Entity.get特徴期別金額05()
                            .add(計算後情報_宛名_口座_更正後Entity.get特徴期別金額06()));
            Decimal 本算定後普徴期合計 = 計算後情報_宛名_口座_更正後Entity.get普徴期別金額01()
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額02())
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額03())
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額04())
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額05()
                            .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額06()))
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額07())
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額08())
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額09())
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額10()
                            .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額11()))
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額12())
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額13())
                    .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額14());
            if ((本算定後特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                    && 本算定後普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
                source.list5_21 = RString.EMPTY;
            }
            if ((本算定後特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                    && 本算定後普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
                source.list5_21 = new RString("特別徴収");
            }
            if ((本算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                    && 本算定後普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
                source.list5_21 = new RString("普通徴収");
            }
            if ((本算定後特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                    && 本算定後普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
                source.list5_21 = new RString("併用徴収");
            }
            source.list5_22 = RString.EMPTY;
        }
        return source;
    }

    private void set月別取得段階(KeisanjohoAtenaKozaEntity entity, GenNendoHonsanteiIdouSource item) {
        RString 更正前後区分 = entity.get更正前後区分();
        FlexibleDate 月割開始年月1 = entity.get月割開始年月1();
        int 開始月1 = 月割開始年月1.getMonthValue();
        FlexibleDate 月割終了年月1 = entity.get月割終了年月1();
        int 終了月1 = 月割終了年月1.getMonthValue();
        RString 保険料算定段階1 = entity.get保険料算定段階1().substring(NUM_0, NUM_2);
        FlexibleDate 月割開始年月2 = entity.get月割開始年月2();
        int 開始月2 = 月割開始年月2.getMonthValue();
        FlexibleDate 月割終了年月2 = entity.get月割終了年月2();
        int 終了月2 = 月割終了年月2.getMonthValue();
        RString 保険料算定段階2 = entity.get保険料算定段階2().substring(NUM_0, NUM_2);

        set月別取得段階(item, 開始月1, 終了月1, 保険料算定段階1, 更正前後区分);
        set月別取得段階(item, 開始月2, 終了月2, 保険料算定段階2, 更正前後区分);
    }

    private void set月別取得段階(GenNendoHonsanteiIdouSource item, int 開始月, int 終了月,
            RString 保険料算定段階, RString 更正前後区分) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + NUM_12) : 終了月); i++) {
            int currentMonth = i;
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

    private void set出力順(GenNendoHonsanteiIdouSource source) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200015.getReportId(),
                        Long.valueOf(shutsuryokujunID.toString()));
        int i = 0;
        RString 並び順の１件目;
        RString 並び順の２件目;
        RString 並び順の３件目;
        RString 並び順の４件目;
        RString 並び順の５件目;
        RString 改頁 = RString.EMPTY;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁 = item.get項目名();
                }
                if (i == INDEX_0) {
                    並び順の１件目 = item.get項目名();
                    source.shutsuryokujun1 = 並び順の１件目;
                } else if (i == INDEX_1) {
                    並び順の２件目 = item.get項目名();
                    source.shutsuryokujun2 = 並び順の２件目;
                } else if (i == INDEX_2) {
                    並び順の３件目 = item.get項目名();
                    source.shutsuryokujun3 = 並び順の３件目;
                } else if (i == INDEX_3) {
                    並び順の４件目 = item.get項目名();
                    source.shutsuryokujun4 = 並び順の４件目;
                } else if (i == INDEX_4) {
                    並び順の５件目 = item.get項目名();
                    source.shutsuryokujun5 = 並び順の５件目;
                }
                i = i + 1;
            }
        }
    }

}
