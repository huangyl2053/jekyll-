package jp.co.ndensan.reams.db.dbb.business.report.karisanteiidokekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 仮算定異動（一括）結果一覧表Editorです。
 *
 * @reamsid_L DBB-0850-030 zhaowei
 */
public class KarisanteiIdoKekkaIchiranEditor implements IKarisanteiIdoKekkaIchiranEditor {

    private final KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private final KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;
    private final FlexibleYear 賦課年度;
    private final YMDHMS 調定日時;
    private final Association association;
    private final RString 住所編集;
    private final List<RString> 出力順項目リスト;
    private final List<RString> 改頁項目リスト;
    private final List<Integer> 月List;
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
    private static final int NUM_13 = 13;
    private static final int NUM_14 = 14;
    private static final RString RSTZERO = new RString("0");
    private static final RString RSTONE = new RString("1");
    private static final RString 現金 = new RString("現金");
    private static final RString 口座 = new RString("口座");
    private final RString 特別徴収 = new RString("特別徴収");
    private final RString 普通徴収 = new RString("普通徴収");
    private final RString 併用徴収 = new RString("併用徴収");
    private static final RString 作成 = new RString("作成");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");
    private static final RString 年度 = new RString("年度");

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座_更正前Entity KeisanjohoAtenaKozaEntity
     * @param 計算後情報_宛名_口座_更正後Entity KeisanjohoAtenaKozaEntity
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param association Association
     * @param 住所編集 RString
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     */
    public KarisanteiIdoKekkaIchiranEditor(KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity,
            KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity,
            YMDHMS 調定日時,
            FlexibleYear 賦課年度,
            Association association,
            RString 住所編集,
            List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト) {
        this.計算後情報_宛名_口座_更正前Entity = 計算後情報_宛名_口座_更正前Entity;
        this.計算後情報_宛名_口座_更正後Entity = 計算後情報_宛名_口座_更正後Entity;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.association = association;
        this.住所編集 = 住所編集;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.月List = new ArrayList<>();
    }

    @Override
    public KarisanteiIdoKekkaIchiranSource edit(KarisanteiIdoKekkaIchiranSource source) {
        edit作成日時(source);
        edit賦課年度(source);
        edit市町村情報(source);
        edit出力順(source);
        edit改ページ(source);
        if (計算後情報_宛名_口座_更正前Entity != null) {
            edit更正前情報(source);
        }
        if (計算後情報_宛名_口座_更正後Entity != null) {
            edit更正後情報(source);
        }
        return source;
    }

    private void edit更正後情報(KarisanteiIdoKekkaIchiranSource source) {
        source.listLower_1 = 計算後情報_宛名_口座_更正後Entity.get調定日時().getDate().wareki().toDateString();
        source.listLower_2 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get特徴期別金額01()
                .add(計算後情報_宛名_口座_更正後Entity.get特徴期別金額02())
                .add(計算後情報_宛名_口座_更正後Entity.get特徴期別金額03()));
        source.listLower_3 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get普徴期別金額01()
                .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額02())
                .add(計算後情報_宛名_口座_更正後Entity.get普徴期別金額03()));
        source.listLower_4 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get減免額());
        source.listLower_5 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get特徴期別金額01());
        source.listLower_6 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get特徴期別金額02());
        source.listLower_7 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get特徴期別金額03());
        if (月List.contains(NUM_1)) {
            source.listLower_8 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get普徴期別金額01());
        }
        if (月List.contains(NUM_2)) {
            source.listLower_9 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get普徴期別金額02());
        }
        if (月List.contains(NUM_3)) {
            source.listLower_10 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get普徴期別金額03());
        }
        if (月List.contains(NUM_4)) {
            source.listLower_11 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get普徴期別金額04());
        }
        if (月List.contains(NUM_5)) {
            source.listLower_12 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get普徴期別金額05());
        }
        if (月List.contains(NUM_6)) {
            source.listLower_13 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get普徴期別金額06());
        }
        if (月List.contains(NUM_7)) {
            source.listLower_14 = 金額Formatter(計算後情報_宛名_口座_更正後Entity.get普徴期別金額07());
        }
        source.listLower_15 = 口座異動編集(計算後情報_宛名_口座_更正後Entity);
        source.listLower_16 = 徴収方法編集(計算後情報_宛名_口座_更正後Entity);
        source.listChoteijiyu1_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由1();
        source.listChoteiJiyu2_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由2();
        source.listChoteijiyu3_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由3();
        source.listChoteijiyu4_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由4();
    }

    private void edit更正前情報(KarisanteiIdoKekkaIchiranSource source) {
        if (計算後情報_宛名_口座_更正前Entity.get通知書番号() != null) {
            source.listUpper_1 = new RString(計算後情報_宛名_口座_更正前Entity.get通知書番号().toString());
        }
        AtenaMeisho 氏名 = 計算後情報_宛名_口座_更正前Entity.get宛名Entity().getKanjiShimei();
        if (氏名 != null) {
            source.listUpper_2 = 氏名.value();
        }
        source.listUpper_3 = 住所編集;
        口座情報編集(source);
        普徴期編集(source);
        source.listCenter_1 = 計算後情報_宛名_口座_更正前Entity.get調定日時().getDate().wareki().toDateString();
        source.listCenter_2 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01()
                .add(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02())
                .add(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03()));
        source.listCenter_3 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01()
                .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02())
                .add(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03()));
        source.listCenter_4 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get減免額());
        source.listCenter_5 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01());
        source.listCenter_6 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02());
        source.listCenter_7 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03());
        if (月List.contains(NUM_1)) {
            source.listCenter_8 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01());
        }
        if (月List.contains(NUM_2)) {
            source.listCenter_9 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02());
        }
        if (月List.contains(NUM_3)) {
            source.listCenter_10 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03());
        }
        if (月List.contains(NUM_4)) {
            source.listCenter_11 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04());
        }
        if (月List.contains(NUM_5)) {
            source.listCenter_12 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05());
        }
        if (月List.contains(NUM_6)) {
            source.listCenter_13 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06());
        }
        if (月List.contains(NUM_7)) {
            source.listCenter_14 = 金額Formatter(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07());
        }
        source.listCenter_15 = 口座異動編集(計算後情報_宛名_口座_更正前Entity);
        source.listCenter_16 = 徴収方法編集(計算後情報_宛名_口座_更正前Entity);
    }

    private void edit作成日時(KarisanteiIdoKekkaIchiranSource source) {
        if (調定日時 != null) {
            RString 帳票作成年月日 = 調定日時.getRDateTime().getDate().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時)
                    .concat(RString.HALF_SPACE).concat(作成);
        }
    }

    private void edit賦課年度(KarisanteiIdoKekkaIchiranSource source) {
        if (賦課年度 != null) {
            source.nendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .fillType(FillType.BLANK).getYear().concat(年度);
        }
    }

    private void edit市町村情報(KarisanteiIdoKekkaIchiranSource source) {
        source.hokenshaNo = association.get地方公共団体コード().code市町村RString();
        source.hokenshaName = association.get市町村名();
    }

    private void 口座情報編集(KarisanteiIdoKekkaIchiranSource source) {
        IKoza koza = new Koza(計算後情報_宛名_口座_更正前Entity.get口座Entity());
        if (koza.get金融機関コード() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4 && ゆうちょ銀行
                    .equals(koza.get金融機関コード().value().substring(NUM_0, NUM_4))) {
                金融機関コードHander1(source, koza);
            } else {
                金融機関コードHander2(source, koza);
            }
        }
    }

    private void 金融機関コードHander1(KarisanteiIdoKekkaIchiranSource source, IKoza koza) {
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
            source.listUpper_4 = 金融機関コード.concat(RString.FULL_SPACE)
                    .concat(通帳記号)
                    .concat(HYPHEN).concat(通帳番号)
                    .concat(RString.FULL_SPACE).concat(koza.get口座名義人漢字().toString());
        }
    }

    private void 金融機関コードHander2(KarisanteiIdoKekkaIchiranSource source, IKoza koza) {
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
            source.listUpper_4 = 金融機関コード.concat(HYPHEN)
                    .concat(支店コード).concat(RString.FULL_SPACE)
                    .concat(預金種別略称)
                    .concat(HYPHEN).concat(口座番号).concat(RString.FULL_SPACE)
                    .concat(koza.get口座名義人漢字().toString());
        }
    }

    private RString 徴収方法編集(KeisanjohoAtenaKozaEntity entity) {
        Decimal 仮算定特徴期合計 = nullTOZero(entity.get特徴期別金額01())
                .add(nullTOZero(entity.get特徴期別金額02()))
                .add(nullTOZero(entity.get特徴期別金額03()));
        Decimal 仮算定普徴期合計 = get仮算定普徴期合計(entity);
        if ((仮算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                && 仮算定普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
            return RString.EMPTY;
        }
        if ((仮算定特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                && 仮算定普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 特別徴収;
        }
        if ((仮算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                && 仮算定普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
            return 普通徴収;
        }
        if ((仮算定特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                && 仮算定普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
            return 併用徴収;
        }
        return RString.EMPTY;
    }

    private Decimal get仮算定普徴期合計(KeisanjohoAtenaKozaEntity entity) {
        Decimal 仮算定普徴期合計 = new Decimal(0);
        if (月List.contains(NUM_1)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額01()));
        }
        if (月List.contains(NUM_2)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額02()));
        }
        if (月List.contains(NUM_3)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額03()));
        }
        if (月List.contains(NUM_4)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額04()));
        }
        if (月List.contains(NUM_5)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額05()));
        }
        if (月List.contains(NUM_6)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額06()));
        }
        if (月List.contains(NUM_7)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額07()));
        }
        if (月List.contains(NUM_8)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額08()));
        }
        if (月List.contains(NUM_9)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額09()));
        }
        if (月List.contains(NUM_10)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額10()));
        }
        if (月List.contains(NUM_11)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額11()));
        }
        if (月List.contains(NUM_12)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額12()));
        }
        if (月List.contains(NUM_13)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額13()));
        }
        if (月List.contains(NUM_14)) {
            仮算定普徴期合計 = 仮算定普徴期合計.add(nullTOZero(entity.get普徴期別金額14()));
        }

        return 仮算定普徴期合計;
    }

    private void 普徴期編集(KarisanteiIdoKekkaIchiranSource source) {
        List<RString> 期月リスト = set普徴期();
        source.listFuchoki_1 = 期月リスト.get(NUM_0);
        source.listFuchoki_2 = 期月リスト.get(NUM_1);
        source.listFuchoki_3 = 期月リスト.get(NUM_2);
        source.listFuchoki_4 = 期月リスト.get(NUM_3);
        source.listFuchoki_5 = 期月リスト.get(NUM_4);
        source.listFuchoki_6 = 期月リスト.get(NUM_5);
        source.listFuchoki_7 = 期月リスト.get(NUM_6);
    }

    private RString 口座異動編集(KeisanjohoAtenaKozaEntity entity) {
        if (RSTZERO.equals(entity.get口座区分())) {
            return 現金;
        }
        if (RSTONE.equals(entity.get口座区分())) {
            return 口座;
        }
        return RString.EMPTY;
    }

    private void edit出力順(KarisanteiIdoKekkaIchiranSource source) {
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

    private void edit改ページ(KarisanteiIdoKekkaIchiranSource source) {
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
        KitsukiList 期月リスト_普徴 = new FuchoKiUtil().get期月リスト();
        List<Kitsuki> 期月リスト = 期月リスト_普徴.filtered仮算定期間().toList();
        Kitsuki 最終法定納期 = 期月リスト_普徴.get最終法定納期();
        List<RString> 期の表記 = new ArrayList<>();
        for (Kitsuki 期 : 期月リスト) {
            if (期.get期AsInt() <= 最終法定納期.get期AsInt()) {
                月List.add(期.get月AsInt());
            }
            期の表記.add(期.get表記().asX期());
        }
        return 期の表記;
    }

    private Decimal nullTOZero(Decimal decimal) {
        if (decimal == null) {
            return Decimal.ZERO;
        }
        return decimal;
    }

    private RString 金額Formatter(Decimal 金額) {
        if (金額 != null) {
            return new RString(金額.toString());
        }
        return RString.EMPTY;
    }
}
