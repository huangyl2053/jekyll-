/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200005;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.HaigushaKazeiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteikakunin.FutanGendogakuNinteiKakunin;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteikakunin.KonkaiNinteiKekka;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteikakunin.ZenkaiNinteiKekka;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 負担限度額認定（一括）確認リストEditorです
 *
 * @reamsid_L DBD-3710-100 b_liuyang2
 */
public class FutanGendogakuNinteiKakuninIchiranEditor implements IFutanGendogakuNinteiKakuninIchiranEditor {

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;

    private final List<FutanGendogakuNinteiKakunin> 負担限度額認定確認リスト;
    private final Association 導入団体;
    private final IOutputOrder 帳票出力順;
    private final int index;
    private final FutanGendogakuNinteiKakunin 負担限度額認定宛名Entity;

    /**
     * インスタンスを生成します。
     *
     * @param 負担限度額認定確認リスト List<FutanGendogakuNinteiKakunin>
     * @param 導入団体 Association
     * @param 帳票出力順 IOutputOrder
     * @param index int
     * @param 負担限度額認定宛名Entity FutanGendogakuNinteiKakunin
     */
    public FutanGendogakuNinteiKakuninIchiranEditor(List<FutanGendogakuNinteiKakunin> 負担限度額認定確認リスト,
            Association 導入団体, IOutputOrder 帳票出力順, int index, FutanGendogakuNinteiKakunin 負担限度額認定宛名Entity) {
        this.負担限度額認定確認リスト = 負担限度額認定確認リスト;
        this.導入団体 = 導入団体;
        this.帳票出力順 = 帳票出力順;
        this.index = index;
        this.負担限度額認定宛名Entity = 負担限度額認定宛名Entity;
    }

    @Override
    public FutanGendogakuNinteiKakuninIchiranReportSource edit(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        return editSource(source);
    }

    private FutanGendogakuNinteiKakuninIchiranReportSource editSource(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        setHead(source);
        setHihokenshaStep1(負担限度額認定宛名Entity, source);
        setHihokenshaStep2(source);
        setKonkai1(source);
        setKonkai2(source);
        setZenkai(source);
        return source;
    }

    private void setHead(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        source.printTimeStamp = get印刷日時();
        source.title = new RString("負担限度額認定（一括）確認リスト");
        //TODO導入団体にgetShichosonCode_()がないです。
//        source.hokenshaNo = this.導入団体.getShichosonCode_();
        if (導入団体 != null) {
            source.hokenshaName = this.導入団体.getShichosonName_();
        }
        if (this.帳票出力順 != null) {
            List<ISetSortItem> 設定項目リスト = this.帳票出力順.get設定項目リスト();
            source.shutsuryokujun1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            source.shutsuryokujun3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            if (設定項目リスト.get(LISTINDEX_0).is改頁項目()) {
                source.kaiPege1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            }
            if (設定項目リスト.get(LISTINDEX_1).is改頁項目()) {
                source.kaiPege2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            }
            if (設定項目リスト.get(LISTINDEX_2).is改頁項目()) {
                source.kaiPege3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            }
            if (設定項目リスト.get(LISTINDEX_3).is改頁項目()) {
                source.kaiPege4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
            if (設定項目リスト.get(LISTINDEX_4).is改頁項目()) {
                source.kaiPege5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
        source.hdrGekihenKanwa = RString.EMPTY;
    }

    private void setHihokenshaStep1(FutanGendogakuNinteiKakunin 負担限度額認定宛名Entity,
            FutanGendogakuNinteiKakuninIchiranReportSource source) {
        FutanGendogakuNinteiKakunin 負担限度額認定確認 = this.負担限度額認定確認リスト.get(index);
        if (負担限度額認定確認.get被保番号() != null) {
            source.list1_1 = 負担限度額認定確認.get被保番号().value();
        }
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(負担限度額認定宛名Entity.get宛名Entity());
        if (宛名.get名称() != null) {
            source.list1_2 = 宛名.get名称().getName().value();
        }
        if (負担限度額認定確認.get資格取得日() != null) {
            source.list2_1 = 負担限度額認定確認.get資格取得日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (負担限度額認定確認.get資格喪失日() != null) {
            source.list2_2 = 負担限度額認定確認.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (負担限度額認定確認.get認定開始日() != null) {
            source.list2_3 = 負担限度額認定確認.get認定開始日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (負担限度額認定確認.get認定終了日() != null) {
            source.list2_4 = 負担限度額認定確認.get認定終了日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.list2_5 = get要介護度();
        RString 申請理由区分 = 負担限度額認定確認.get今回認定結果().get申請理由区分().getコード();
        RString 申請理由区分名称 = RString.EMPTY;
        if (null != 申請理由区分 && !申請理由区分.isEmpty()) {
            申請理由区分名称 = ShinseiRiyuKubun.toValue(申請理由区分).get名称();
        }
        source.list1_3 = 申請理由区分名称;

        if (負担限度額認定確認.is旧措置フラグ()) {
            source.list2_6 = new RString("*");
        } else {
            source.list2_6 = RString.EMPTY;
        }
        if (負担限度額認定確認.get利用軽減() != null
                && !負担限度額認定確認.get利用軽減().isEmpty()
                && Boolean.valueOf(負担限度額認定確認.get利用軽減().toString())) {
            source.list4_1 = new RString("申");
        } else if (負担限度額認定確認.get利用軽減().isEmpty()) {
            source.list4_1 = RString.EMPTY;
        } else {
            source.list4_1 = new RString("認");
        }
        if (負担限度額認定確認.get社福軽減() != null
                && !負担限度額認定確認.get社福軽減().isEmpty()
                && Boolean.valueOf(負担限度額認定確認.get社福軽減().toString())) {
            source.list4_2 = new RString("申");
        } else if (負担限度額認定確認.get社福軽減().isEmpty()) {
            source.list4_2 = RString.EMPTY;
        } else {
            source.list4_2 = new RString("認");
        }
    }

    private void setHihokenshaStep2(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        FutanGendogakuNinteiKakunin 負担限度額認定確認 = this.負担限度額認定確認リスト.get(index);
        if (負担限度額認定確認.get訪問減額() != null
                && !負担限度額認定確認.get訪問減額().isEmpty()
                && Boolean.valueOf(負担限度額認定確認.get訪問減額().toString())) {
            source.list4_3 = new RString("申");
        } else if (負担限度額認定確認.get訪問減額().isEmpty()) {
            source.list4_3 = RString.EMPTY;
        } else {
            source.list4_3 = new RString("認");
        }
        //TODO判断条件が違いますが、編集元が同じ、判断の意味がない,そして、利社対地はなんですか
//        if (Boolean.valueOf(負担限度額認定確認.get特地減免().toString())) {
//                source.list4_4 = 負担限度額認定確認.利社対地
//        } else if (負担限度額認定確認.get特地減免().isEmpty()) {
//                source.list4_4 = 負担限度額認定確認.利社対地
//        } else {
//                source.list4_4 = 負担限度額認定確認.利社対地
//        }

        if (負担限度額認定確認.is生活保護受給者()) {
            source.list1_4 = new RString("*");
        } else {
            source.list1_4 = RString.EMPTY;
        }
        if (負担限度額認定確認.is老齢福祉年金受給者()) {
            source.list1_5 = new RString("*");
        } else {
            source.list1_5 = RString.EMPTY;
        }
        if (負担限度額認定確認.get合計所得金額() != null) {
            source.list2_7 = DecimalFormatter.toコンマ区切りRString(負担限度額認定確認.get合計所得金額(), 0);
        }
        source.list3_1 = RString.EMPTY;
        RString 世帯課税 = 負担限度額認定確認.get世帯課税().getコード();
        RString 世帯課税名称 = RString.EMPTY;
        if (null != 世帯課税 && !世帯課税.isEmpty()) {
            世帯課税名称 = SetaiKazeiKubun.toValue(世帯課税).get名称();
        }
        source.list3_2 = 世帯課税名称;
        source.list3_3 = RString.EMPTY;
        if (負担限度額認定確認.get住民となった日() != null) {
            source.list5_1 = 負担限度額認定確認.get住民となった日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        RString 配偶者課税区分 = 負担限度額認定確認.get今回認定結果().get配偶者課税区分().getコード();
        RString 配偶者課税区分名称 = RString.EMPTY;
        if (null != 配偶者課税区分 && !配偶者課税区分.isEmpty()) {
            配偶者課税区分名称 = HaigushaKazeiKubun.toValue(配偶者課税区分).get名称();
        }
        source.list3_2 = 配偶者課税区分名称;
        Decimal 預貯金額 = 負担限度額認定確認.get預貯金額();
        Decimal 有価証券評価概算額 = 負担限度額認定確認.get有価証券評価概算額();
        Decimal その他金額 = 負担限度額認定確認.getその他金額();
        if (預貯金額 != null || 有価証券評価概算額 != null || その他金額 != null) {
            source.list6_2 = DecimalFormatter.toコンマ区切りRString(預貯金額.add(有価証券評価概算額).add(その他金額), 0);
        }
    }

    private void setKonkai1(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        if (負担限度額認定確認リスト.get(index).get今回認定結果() != null) {
            KonkaiNinteiKekka 今回認定結果 = 負担限度額認定確認リスト.get(index).get今回認定結果();
            if (今回認定結果.get申請年月日() != null) {
                source.list1_6 = 今回認定結果.get申請年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (今回認定結果.get決定年月日() != null) {
                source.list3_4 = 今回認定結果.get決定年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            RString 決定区分 = 今回認定結果.get決定区分().getコード();
            RString 承認 = KetteiKubun.承認する.getコード();
            RString 承認しない = KetteiKubun.承認しない.getコード();
            if (決定区分.equals(承認)) {
                source.list2_8 = new RString("承認");
            } else if (決定区分.equals(承認しない)) {
                source.list2_8 = new RString("却下");
            } else {
                source.list2_8 = RString.EMPTY;
            }
            if (今回認定結果.get適用日開始年月日() != null) {
                source.list1_7 = 今回認定結果.get適用日開始年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (今回認定結果.get適用終了年月日() != null) {
                source.list2_9 = 今回認定結果.get適用終了年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (今回認定結果.get旧措置者区分() != null) {
                source.list3_5 = 今回認定結果.get旧措置者区分().getコード();
            }
            RiyoshaFutanDankai 利用者負担段階今回 = 今回認定結果.get利用者負担段階();
            ZenkaiNinteiKekka 前回認定結果 = 負担限度額認定確認リスト.get(index).get前回認定結果();
            if (利用者負担段階今回 != null && 利用者負担段階今回 != 前回認定結果.get利用者負担段階()
                    && 前回認定結果.get利用者負担段階() != null) {
                source.list1_8 = new RString("*");
            } else {
                source.list1_8 = RString.EMPTY;
            }
        }
    }

    private void setKonkai2(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        if (負担限度額認定確認リスト.get(index).get今回認定結果() != null) {
            KonkaiNinteiKekka 今回認定結果 = 負担限度額認定確認リスト.get(index).get今回認定結果();
            if (今回認定結果.get利用者負担段階() != null) {
                source.list1_9 = 今回認定結果.get利用者負担段階().getコード();
            }
            if (今回認定結果.get食費負担額() != null) {
                source.list2_10 = DecimalFormatter.toコンマ区切りRString(今回認定結果.get食費負担額(), 0);
            }
            if (今回認定結果.getユニット型個室() != null) {
                source.list3_6 = DecimalFormatter.toコンマ区切りRString(今回認定結果.getユニット型個室(), 0);
            }
            if (今回認定結果.getユニット型準個室() != null) {
                source.list1_10 = DecimalFormatter.toコンマ区切りRString(今回認定結果.getユニット型準個室(), 0);
            }
            if (今回認定結果.get従来型個室特養() != null) {
                source.list2_11 = DecimalFormatter.toコンマ区切りRString(今回認定結果.get従来型個室特養(), 0);
            }
            if (今回認定結果.get従来型個室老健療養() != null) {
                source.list3_7 = DecimalFormatter.toコンマ区切りRString(今回認定結果.get従来型個室老健療養(), 0);
            }
            if (今回認定結果.get多床室() != null) {
                source.list1_11 = DecimalFormatter.toコンマ区切りRString(今回認定結果.get多床室(), 0);
            }
            RiyoshaFutanDankai 利用者負担段階今回 = 今回認定結果.get利用者負担段階();
            if (利用者負担段階今回 != null && 利用者負担段階今回.equals(RiyoshaFutanDankai.課税層第三段階)) {
                source.list2_12 = new RString("該当");
            } else {
                source.list2_12 = new RString("非該当");
            }
        }

    }

    private void setZenkai(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        if (負担限度額認定確認リスト.get(index).get前回認定結果() != null) {
            ZenkaiNinteiKekka 前回認定結果 = 負担限度額認定確認リスト.get(index).get前回認定結果();
            if (前回認定結果.get申請年月日() != null) {
                source.list1_12 = 前回認定結果.get申請年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (前回認定結果.get決定年月日() != null) {
                source.list2_13 = 前回認定結果.get決定年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            RString 決定区分 = 前回認定結果.get決定区分().getコード();
            RString 承認 = KetteiKubun.承認する.getコード();
            RString 承認しない = KetteiKubun.承認しない.getコード();
            if (決定区分.equals(承認)) {
                source.list2_13 = new RString("承認");
            } else if (決定区分.equals(承認しない)) {
                source.list2_13 = new RString("却下");
            } else {
                source.list2_13 = RString.EMPTY;
            }
            if (前回認定結果.get適用日開始年月日() != null) {
                source.list1_13 = 前回認定結果.get適用日開始年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (前回認定結果.get適用終了年月日() != null) {
                source.list2_14 = 前回認定結果.get適用終了年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (前回認定結果.get旧措置者区分() != null) {
                source.list3_9 = 前回認定結果.get旧措置者区分().getコード();
            }
            if (前回認定結果.get利用者負担段階() != null) {
                source.list1_14 = 前回認定結果.get利用者負担段階().getコード();
            }
            if (前回認定結果.get食費負担額() != null) {
                source.list2_15 = DecimalFormatter.toコンマ区切りRString(前回認定結果.get食費負担額(), 0);
            }
            if (前回認定結果.getユニット型個室() != null) {
                source.list3_10 = DecimalFormatter.toコンマ区切りRString(前回認定結果.getユニット型個室(), 0);
            }
            if (前回認定結果.getユニット型準個室() != null) {
                source.list1_15 = DecimalFormatter.toコンマ区切りRString(前回認定結果.getユニット型準個室(), 0);
            }
            if (前回認定結果.get従来型個室特養() != null) {
                source.list2_16 = DecimalFormatter.toコンマ区切りRString(前回認定結果.get従来型個室特養(), 0);
            }
            if (前回認定結果.get従来型個室老健療養() != null) {
                source.list3_11 = DecimalFormatter.toコンマ区切りRString(前回認定結果.get従来型個室老健療養(), 0);
            }
            if (前回認定結果.get多床室() != null) {
                source.list1_16 = DecimalFormatter.toコンマ区切りRString(前回認定結果.get多床室(), 0);
            }

            if (前回認定結果.get利用者負担段階() != null
                    && 前回認定結果.get利用者負担段階().equals(RiyoshaFutanDankai.課税層第三段階)) {
                source.list2_17 = new RString("該当");
            } else {
                source.list2_17 = new RString("非該当");
            }
        }
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        RString 印刷日時 = 年月日.concat("").concat(時分秒).concat("").concat("作成");
        return 印刷日時;
    }

    private RString get要介護度() {
        FutanGendogakuNinteiKakunin 負担限度額認定確認 = this.負担限度額認定確認リスト.get(index);
        RString 要介護認定状態区分コード = 負担限度額認定確認.get要介護認定状態区分コード();
        KoroshoInterfaceShikibetsuCode 厚労省IF識別コード = KoroshoInterfaceShikibetsuCode.
                toValue(負担限度額認定確認.get厚労省IF識別コード());
        RString 要介護度 = YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護認定状態区分コード).getName();
        return 要介護度;
    }
}
