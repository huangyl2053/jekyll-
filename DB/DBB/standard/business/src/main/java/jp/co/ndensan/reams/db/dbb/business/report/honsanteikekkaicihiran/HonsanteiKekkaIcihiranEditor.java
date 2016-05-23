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
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteiFukaExtraBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt310FindKozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 「本算定賦課計算」ボディEditorです。
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranEditor implements IHonsanteiKekkaIcihiranEditor {

    private final List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座EntityList;
    private final HonsanteiFukaExtraBatchParameter バッチパラメータ;
    private final FlexibleYear 賦課年度;
    private final RDate 調定日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final RString 住所編集;
    private final List<RString> 出力順項目リスト;
    private final List<RString> 改頁項目リスト;
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
    private static final RString 半角ハイフン = new RString("_");
    private static final RString DATA_9900 = new RString("9900");
    private static final RString HEI = new RString("平");
    private final RString 特別徴収 = new RString("特別徴収");
    private final RString 普通徴収 = new RString("普通徴収");
    private final RString 併用徴収 = new RString("併用徴収");
    private final RString 本算定賦課なし = new RString("本算定賦課なし");
    private final RString 本算定前半普徴 = new RString("本算定前半普徴");

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座EntityList List<KeisangojohoAtenaKozaEntity>
     * @param バッチパラメータ HonsanteiFukaBatchParameter
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 RDate
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param 住所編集 RString
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     */
    public HonsanteiKekkaIcihiranEditor(List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座EntityList,
            HonsanteiFukaExtraBatchParameter バッチパラメータ,
            FlexibleYear 賦課年度,
            RDate 調定日時,
            RString 市町村コード,
            RString 市町村名,
            RString 住所編集,
            List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト) {
        this.計算後情報_宛名_口座EntityList = 計算後情報_宛名_口座EntityList;
        this.バッチパラメータ = バッチパラメータ;
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
        for (KeisangojohoAtenaKozaEntity entity : 計算後情報_宛名_口座EntityList) {

            source.printTimeStamp = 調定日時.wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK)
                    .toDateString();
            source.nendo = 賦課年度.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK)
                    .toDateString();
            source.hokenshaNo = 市町村コード;
            source.hokenshaName = 市町村名;
            source.shutsuryokujun1 = set出力順();
            source.shutsuryokujun2 = set出力順();
            source.shutsuryokujun3 = set出力順();
            source.shutsuryokujun4 = set出力順();
            source.shutsuryokujun5 = set出力順();
            source.kaipage1 = set改ページ();
            source.kaipage2 = set改ページ();
            source.kaipage3 = set改ページ();
            source.kaipage4 = set改ページ();
            source.kaipage5 = set改ページ();
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
            source.listUpper_1 = new RString(entity.get通知書番号().toString());
            AtenaMeisho 氏名 = entity.get宛名Entity().getKanjiShimei();
            if (氏名 != null) {
                source.listUpper_2 = 氏名.value();
            }
            FlexibleDate 生年月日 = entity.get宛名Entity().getSeinengappiYMD();
            if (生年月日 != null) {
                RString 生年月日_first = new RString(生年月日.toString().substring(NUM_0, NUM_1));
                if (HEI.equals(生年月日_first)) {
                    source.listUpper_3 = 生年月日.wareki().eraType(EraType.KANJI)
                            .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                            .fillType(FillType.BLANK).toDateString();
                } else {
                    source.listUpper_3 = 生年月日.seireki().toDateString();
                }
            }
            source.listUpper_4 = entity.get宛名Entity().getSeibetsuCode();
            if (entity.get世帯コード() != null) {
                source.listUpper_5 = entity.get世帯コード().value();
            }
            if (entity.get識別コード() != null) {
                source.listUpper_6 = entity.get識別コード().value();
            }
            ChoikiCode 町域コード = entity.get宛名Entity().getChoikiCode();
            if (町域コード != null) {
                source.listUpper_7 = 町域コード.value();
            }
            YubinNo 郵便番号 = entity.get宛名Entity().getYubinNo();
            if (郵便番号 != null) {
                source.listUpper_8 = 郵便番号.value();
            }
            source.listUpper_9 = 住所編集;
            source.listUpper_10 = set口座の情報(entity);
            source.listCenter_1 = new RString(entity.get被保険者番号().toString());
            source.listCenter_2 = entity.get資格取得日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            source.listCenter_3 = entity.get資格喪失日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            ShikakuKikan shikakuKikan = new ShikakuKikan();
            ShikakuKikanJoho shikakuKikanJoho = shikakuKikan.get資格期間(賦課年度, entity.get資格取得日(), entity.get資格喪失日());
            if (shikakuKikanJoho.get月数() != 0) {
                source.listCenter_4 = new RString(String.valueOf(shikakuKikanJoho.get月数()));
            }
            source.listCenter_5 = new RString(entity.get確定介護保険料_年額().toString());
            source.listCenter_6 = new RString(entity.get減免前介護保険料_年額().toString());
            source.listCenter_7 = new RString(entity.get減免額().toString());
            source.listCenter_8 = set徴収方法(entity);
            set月別取得段階(entity, source);
            source.listCenter_21 = set備考1(entity);
            source.listLower_1 = DecimalFormatter.toコンマ区切りRString(entity.get特徴期別金額01(), 0);
            source.listLower_2 = DecimalFormatter.toコンマ区切りRString(entity.get特徴期別金額02(), 0);
            source.listLower_3 = DecimalFormatter.toコンマ区切りRString(entity.get特徴期別金額03(), 0);
            source.listLower_4 = DecimalFormatter.toコンマ区切りRString(entity.get特徴期別金額04(), 0);
            source.listLower_5 = DecimalFormatter.toコンマ区切りRString(entity.get特徴期別金額05(), 0);
            source.listLower_6 = DecimalFormatter.toコンマ区切りRString(entity.get特徴期別金額06(), 0);
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額01(), 0);
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額02(), 0);
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額03(), 0);
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額04(), 0);
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額05(), 0);
            source.listLower_12 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額06(), 0);
            source.listLower_13 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額07(), 0);
            source.listLower_14 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額08(), 0);
            source.listLower_15 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額09(), 0);
            source.listLower_16 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額10(), 0);
            source.listLower_17 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額11(), 0);
            source.listLower_18 = DecimalFormatter.toコンマ区切りRString(entity.get普徴期別金額12(), 0);
        }
        return source;
    }

    private RString set出力順() {
        if (出力順項目リスト != null && !出力順項目リスト.isEmpty()) {
            if (出力順項目リスト.size() > NUM_0) {
                return 出力順項目リスト.get(NUM_0);
            } else if (出力順項目リスト.size() > NUM_1) {
                return 出力順項目リスト.get(NUM_1);
            } else if (出力順項目リスト.size() > NUM_2) {
                return 出力順項目リスト.get(NUM_2);
            } else if (出力順項目リスト.size() > NUM_3) {
                return 出力順項目リスト.get(NUM_3);
            } else if (出力順項目リスト.size() > NUM_4) {
                return 出力順項目リスト.get(NUM_4);
            }
        }
        return RString.EMPTY;
    }

    private RString set改ページ() {
        if (改頁項目リスト != null && !改頁項目リスト.isEmpty()) {
            if (改頁項目リスト.size() > NUM_0) {
                return 改頁項目リスト.get(NUM_0);
            } else if (改頁項目リスト.size() > NUM_1) {
                return 改頁項目リスト.get(NUM_1);
            } else if (改頁項目リスト.size() > NUM_2) {
                return 改頁項目リスト.get(NUM_2);
            } else if (改頁項目リスト.size() > NUM_3) {
                return 改頁項目リスト.get(NUM_3);
            } else if (改頁項目リスト.size() > NUM_4) {
                return 改頁項目リスト.get(NUM_4);
            }
        }
        return RString.EMPTY;
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

    private RString set口座の情報(KeisangojohoAtenaKozaEntity entity) {
        RString 金融機関コード = entity.get口座Entity().get金融機関コード().getColumnValue().substring(NUM_0, NUM_4);
        RString 通帳記号 = entity.get口座Entity().get通帳記号().substring(NUM_0, NUM_5);
        RString 通帳番号 = entity.get口座Entity().get通帳番号().substring(NUM_0, NUM_8);
        RString 口座名義人漢字 = entity.get口座Entity().get口座名義人漢字().value();
        RString 支店コード = entity.get口座Entity().get支店コード().getColumnValue().substring(NUM_0, NUM_3);
        IKoza koza = HonsanteiKekkaIcihiranEditor.to口座(entity.get口座Entity());
        RString 口座種別 = koza.get預金種別().get預金種別略称();

        RString 口座番号 = entity.get口座Entity().get口座番号().substring(NUM_0, NUM_7);
        RStringBuilder builder_ゆうちょ銀行 = new RStringBuilder();
        builder_ゆうちょ銀行.append(RString.HALF_SPACE).append(金融機関コード).append(通帳記号)
                .append(半角ハイフン).append(RString.HALF_SPACE).append(通帳番号).append(口座名義人漢字);
        RStringBuilder builder_ゆうちょ銀行以外 = new RStringBuilder();
        builder_ゆうちょ銀行以外.append(金融機関コード).append(半角ハイフン).append(支店コード).append(RString.HALF_SPACE)
                .append(口座種別).append(半角ハイフン).append(口座番号).append(RString.HALF_SPACE).append(口座名義人漢字);
        if (DATA_9900.equals(金融機関コード)) {
            return builder_ゆうちょ銀行.toRString();
        } else {
            return builder_ゆうちょ銀行以外.toRString();
        }
    }

    private RString set徴収方法(KeisangojohoAtenaKozaEntity entity) {
        Decimal 特徴期の期別金額の合計 = entity.get特徴期別金額04().add(entity.get特徴期別金額05()).add(entity.get特徴期別金額06());
        Decimal 普徴期の期別金額の合計 = entity.get普徴期別金額01().add(entity.get普徴期別金額02().add(entity.get普徴期別金額03()))
                .add(entity.get普徴期別金額04()).add(entity.get普徴期別金額05()).add(entity.get普徴期別金額06())
                .add(entity.get普徴期別金額07()).add(entity.get普徴期別金額08()).add(entity.get普徴期別金額09())
                .add(entity.get普徴期別金額10()).add(entity.get普徴期別金額11()).add(entity.get普徴期別金額12())
                .add(entity.get普徴期別金額13()).add(entity.get普徴期別金額14());
        if (特徴期の期別金額の合計 == Decimal.ZERO && 普徴期の期別金額の合計 == Decimal.ZERO) {
            return RString.EMPTY;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) == 1 && 普徴期の期別金額の合計 == Decimal.ZERO) {
            return 特別徴収;
        } else if (特徴期の期別金額の合計 == Decimal.ZERO && 普徴期の期別金額の合計.compareTo(Decimal.ONE) == 1) {
            return 普通徴収;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) == 1 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) == 1) {
            return 併用徴収;
        } else {
            return null;
        }
    }

    private RString set備考1(KeisangojohoAtenaKozaEntity entity) {
        Decimal 特徴期の期別金額の合計 = entity.get特徴期別金額04().add(entity.get特徴期別金額05()).add(entity.get特徴期別金額06());
        Decimal 普徴期の期別金額の合計 = entity.get普徴期別金額01().add(entity.get普徴期別金額02().add(entity.get普徴期別金額03()))
                .add(entity.get普徴期別金額04()).add(entity.get普徴期別金額05()).add(entity.get普徴期別金額06())
                .add(entity.get普徴期別金額07()).add(entity.get普徴期別金額08()).add(entity.get普徴期別金額09())
                .add(entity.get普徴期別金額10()).add(entity.get普徴期別金額11()).add(entity.get普徴期別金額12())
                .add(entity.get普徴期別金額13()).add(entity.get普徴期別金額14());
        if (特徴期の期別金額の合計 == Decimal.ZERO && 普徴期の期別金額の合計 == Decimal.ZERO) {
            return 本算定賦課なし;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) == 1 && 普徴期の期別金額の合計 == Decimal.ZERO) {
            return 本算定前半普徴;
        } else if (特徴期の期別金額の合計 == Decimal.ZERO && 普徴期の期別金額の合計.compareTo(Decimal.ONE) == 1) {
            return RString.EMPTY;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) == 1 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) == 1) {
            return RString.EMPTY;
        } else {
            return null;
        }
    }

    private static IKoza to口座(UaFt310FindKozaEntity uaFt310Entity) {
        // TODO インターフェースを提供しない。
        KozaRelateEntity relateEntity = new KozaRelateEntity();
        UaT0310KozaEntity kozaEntity = new UaT0310KozaEntity();
        kozaEntity.setKozaId(uaFt310Entity.get口座ID().longValue());
        kozaEntity.setKozaMeiginin(uaFt310Entity.get口座名義人());
        kozaEntity.setKozaMeigininKanji(uaFt310Entity.get口座名義人漢字());
        kozaEntity.setKozaMeigininShikibetsuCode(uaFt310Entity.get口座名義人識別コード());
        kozaEntity.setKozaNo(uaFt310Entity.get口座番号());
        kozaEntity.setKozaTorokuNo(uaFt310Entity.get口座登録番号());
        kozaEntity.setKozaHyojiKubun(uaFt310Entity.get口座表示区分());
        kozaEntity.setTemban(uaFt310Entity.get店番());
        kozaEntity.setKinyuKikanShitenCode(uaFt310Entity.get支店コード());
        kozaEntity.setKensakuyoMeiginin(uaFt310Entity.get検索用名義人());
        kozaEntity.setGyomuKoyuKey(uaFt310Entity.get業務固有キー());
        kozaEntity.setYotoKubun(new KozaYotoKubunCodeValue(uaFt310Entity.get用途区分()));
        kozaEntity.setShuryoYMD(new FlexibleDate(uaFt310Entity.get終了年月日().toDateString()));
        kozaEntity.setShikibetsuCode(uaFt310Entity.get識別コード());
        kozaEntity.setTsuchoNo(uaFt310Entity.get通帳番号());
        kozaEntity.setTsuchoKigo(uaFt310Entity.get通帳記号());
        kozaEntity.setKinyuKikanCode(uaFt310Entity.get金融機関コード());
        kozaEntity.setKaishiYMD(new FlexibleDate(uaFt310Entity.get開始年月日().toDateString()));
        kozaEntity.setYokinShubetsu(uaFt310Entity.get預金種別());

        relateEntity.setUaT0310KozaEntity(kozaEntity);
        return new Koza(relateEntity);
    }

    private void set月別取得段階(KeisangojohoAtenaKozaEntity entity, HonsanteiKekkaIcihiranReportSource source) {
        List<Integer> 月List = new ArrayList<>();
        月List.add(NUM_1);
        月List.add(NUM_2);
        月List.add(NUM_3);
        月List.add(NUM_4);
        月List.add(NUM_5);
        月List.add(NUM_6);
        月List.add(NUM_7);
        月List.add(NUM_8);
        月List.add(NUM_9);
        月List.add(NUM_10);
        月List.add(NUM_11);
        月List.add(NUM_12);

        FlexibleDate 月割開始年月1 = entity.get月割開始年月1();
        int 開始月1 = 月割開始年月1.getMonthValue();
        FlexibleDate 月割終了年月1 = entity.get月割終了年月1();
        int 終了月1 = 月割終了年月1.getMonthValue();
        RString 保険料算定段階1 = entity.get保険料算定段階1().substring(NUM_0, NUM_2);
        RString 保険料算定段階2 = entity.get保険料算定段階2().substring(NUM_0, NUM_2);
        for (int i = 0; i < 月List.size(); i++) {
            if (開始月1 <= 終了月1) {
                取得段階1(i, 月List, 保険料算定段階1, 保険料算定段階2, 開始月1, 終了月1, source);
            } else {
                取得段階2(i, 月List, 保険料算定段階1, 保険料算定段階2, 開始月1, 終了月1, source);
            }
        }
    }

    private void 取得段階1(int i, List<Integer> 月List,
            RString 保険料算定段階1,
            RString 保険料算定段階2,
            int 開始月1,
            int 終了月1,
            HonsanteiKekkaIcihiranReportSource source) {
        if (月List.get(i) >= 開始月1 && 月List.get(i) <= 終了月1) {
            set月別取得段階1(保険料算定段階1, 月List.get(i), source);
        } else {
            set月別取得段階2(保険料算定段階2, 月List.get(i), source);
        }
    }

    private void 取得段階2(int i, List<Integer> 月List,
            RString 保険料算定段階1,
            RString 保険料算定段階2,
            int 開始月1,
            int 終了月1,
            HonsanteiKekkaIcihiranReportSource source) {
        if (月List.get(i) < 開始月1 || 月List.get(i) > 終了月1) {
            set月別取得段階1(保険料算定段階1, 月List.get(i), source);
        } else {
            set月別取得段階2(保険料算定段階2, 月List.get(i), source);
        }
    }

    private void set月別取得段階1(RString 保険料算定段階1, int 月別, HonsanteiKekkaIcihiranReportSource source) {
        switch (月別) {
            case NUM_4:
                source.listCenter_9 = 保険料算定段階1;
                break;
            case NUM_5:
                source.listCenter_10 = 保険料算定段階1;
                break;
            case NUM_6:
                source.listCenter_11 = 保険料算定段階1;
                break;
            case NUM_7:
                source.listCenter_12 = 保険料算定段階1;
                break;
            case NUM_8:
                source.listCenter_13 = 保険料算定段階1;
                break;
            case NUM_9:
                source.listCenter_14 = 保険料算定段階1;
                break;
            case NUM_10:
                source.listCenter_15 = 保険料算定段階1;
                break;
            case NUM_11:
                source.listCenter_16 = 保険料算定段階1;
                break;
            case NUM_12:
                source.listCenter_17 = 保険料算定段階1;
                break;
            case NUM_1:
                source.listCenter_18 = 保険料算定段階1;
                break;
            case NUM_2:
                source.listCenter_19 = 保険料算定段階1;
                break;
            case NUM_3:
                source.listCenter_20 = 保険料算定段階1;
                break;
            default:
                break;
        }
    }

    private void set月別取得段階2(RString 保険料算定段階2, int 月別, HonsanteiKekkaIcihiranReportSource source) {
        switch (月別) {
            case NUM_4:
                source.listCenter_9 = 保険料算定段階2;
                break;
            case NUM_5:
                source.listCenter_10 = 保険料算定段階2;
                break;
            case NUM_6:
                source.listCenter_11 = 保険料算定段階2;
                break;
            case NUM_7:
                source.listCenter_12 = 保険料算定段階2;
                break;
            case NUM_8:
                source.listCenter_13 = 保険料算定段階2;
                break;
            case NUM_9:
                source.listCenter_14 = 保険料算定段階2;
                break;
            case NUM_10:
                source.listCenter_15 = 保険料算定段階2;
                break;
            case NUM_11:
                source.listCenter_16 = 保険料算定段階2;
                break;
            case NUM_12:
                source.listCenter_17 = 保険料算定段階2;
                break;
            case NUM_1:
                source.listCenter_18 = 保険料算定段階2;
                break;
            case NUM_2:
                source.listCenter_19 = 保険料算定段階2;
                break;
            case NUM_3:
                source.listCenter_20 = 保険料算定段階2;
                break;
            default:
                break;
        }
    }

}
