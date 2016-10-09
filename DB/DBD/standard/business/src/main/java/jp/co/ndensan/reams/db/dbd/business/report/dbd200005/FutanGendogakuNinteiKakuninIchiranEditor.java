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
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogaku.ikkatsunintei.FutanGengaokuNintteiKakuninListEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static final RString 負担限度額認定一括確認リスト = new RString("負担限度額認定（一括）確認リスト");
    private static final RString 作成 = new RString("作成");
    private static final RString 星 = new RString("*");
    private static final RString 申 = new RString("申");
    private static final RString 認 = new RString("認");
    private static final RString 承認1 = new RString("承認");
    private static final RString 該当 = new RString("該当");
    private static final RString 却下 = new RString("却下");
    private static final RString 非該当 = new RString("非該当");

    private final FutanGengaokuNintteiKakuninListEntity 負担限度額認定確認リスト;
    private final Association 導入団体;
    private final IOutputOrder 帳票出力順;
    private final RDateTime 作成日時;

    /**
     * インスタンスを生成します。
     *
     * @param 負担限度額認定確認リスト FutanGengaokuNintteiKakuninListEntity
     * @param 導入団体 Association
     * @param 帳票出力順 IOutputOrder
     * @param 作成日時 RDateTime
     */
    public FutanGendogakuNinteiKakuninIchiranEditor(FutanGengaokuNintteiKakuninListEntity 負担限度額認定確認リスト,
            Association 導入団体, IOutputOrder 帳票出力順, RDateTime 作成日時) {
        this.負担限度額認定確認リスト = 負担限度額認定確認リスト;
        this.導入団体 = 導入団体;
        this.帳票出力順 = 帳票出力順;
        this.作成日時 = 作成日時;
    }

    @Override
    public FutanGendogakuNinteiKakuninIchiranReportSource edit(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        setHead(source);
        setHihokenshaStep1(source);
        setHihokenshaStep2(source);
        setKonkai1(source);
        setKonkai2(source);
        setZenkai(source);
        return source;
    }

    private void setHead(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        source.printTimeStamp = new RStringBuilder()
                .append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString())
                .append(RString.FULL_SPACE)
                .append(作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒))
                .append(RString.FULL_SPACE)
                .append(作成).toRString();
        source.title = 負担限度額認定一括確認リスト;
        if (null != this.導入団体) {
            if (null != this.導入団体.get地方公共団体コード()) {
                source.hokenshaNo = this.導入団体.get地方公共団体コード().value();
            }
            if (null != this.導入団体.get市町村名()) {
                source.hokenshaName = this.導入団体.get市町村名();
            }
        }
        if (null != this.帳票出力順 && null != this.帳票出力順.get設定項目リスト()) {
            List<ISetSortItem> 設定項目リスト = this.帳票出力順.get設定項目リスト();
            source = set出力順改頁(source, 設定項目リスト);
        }
        source.hdrGekihenKanwa = RString.EMPTY;
    }

    private void setHihokenshaStep1(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        if (null != this.負担限度額認定確認リスト) {
            if (null != this.負担限度額認定確認リスト.getAtesakiEntity()) {
                IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(this.負担限度額認定確認リスト.getAtesakiEntity());
                get名称(source, 宛名);
            }
            if (null != this.負担限度額認定確認リスト.get被保険者番号()) {
                source.list1_1 = this.負担限度額認定確認リスト.get被保険者番号().value();
            }
            if (null != this.負担限度額認定確認リスト.get資格取得日()) {
                source.list2_1 = this.負担限度額認定確認リスト.get資格取得日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (null != this.負担限度額認定確認リスト.get資格喪失日()) {
                source.list2_2 = this.負担限度額認定確認リスト.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (null != this.負担限度額認定確認リスト.get認定開始日()) {
                source.list2_3 = this.負担限度額認定確認リスト.get認定開始日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (null != this.負担限度額認定確認リスト.get認定終了日()) {
                source.list2_4 = this.負担限度額認定確認リスト.get認定終了日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (null != this.負担限度額認定確認リスト.get要介護状態区分コード()
                    && null != this.負担限度額認定確認リスト.get厚労省IF識別コード()) {
                source.list2_5 = get要介護度();
            }
            DbT4018KaigoHokenFutanGendogakuNinteiEntity 今回認定結果 = this.負担限度額認定確認リスト.get今回認定結果();
            if (null != 今回認定結果) {
                get申請理由区分名称(source, 今回認定結果);
            }
            if (this.負担限度額認定確認リスト.is旧措置()) {
                source.list2_6 = 星;
            }
            if (null != this.負担限度額認定確認リスト.get利用軽減()
                    && Boolean.valueOf(this.負担限度額認定確認リスト.get利用軽減().toString())) {
                source.list4_1 = 申;
            } else if (this.負担限度額認定確認リスト.get利用軽減().isEmpty()) {
                source.list4_1 = RString.EMPTY;
            } else {
                source.list4_1 = 認;
            }
            if (null != this.負担限度額認定確認リスト.get社福軽減()
                    && Boolean.valueOf(this.負担限度額認定確認リスト.get社福軽減().toString())) {
                source.list4_2 = 申;
            } else if (this.負担限度額認定確認リスト.get社福軽減().isEmpty()) {
                source.list4_2 = RString.EMPTY;
            } else {
                source.list4_2 = 認;
            }
        }
    }

    private void setHihokenshaStep2(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        if (null != this.負担限度額認定確認リスト) {
            if (null != this.負担限度額認定確認リスト.get訪問減額()
                    && Boolean.valueOf(this.負担限度額認定確認リスト.get訪問減額().toString())) {
                source.list4_3 = 申;
            } else if (this.負担限度額認定確認リスト.get訪問減額().isEmpty()) {
                source.list4_3 = RString.EMPTY;
            } else {
                source.list4_3 = 認;
            }
            if (null != this.負担限度額認定確認リスト.get特地減免()
                    && Boolean.valueOf(this.負担限度額認定確認リスト.get特地減免().toString())) {
                source.list4_4 = 申;
            } else if (this.負担限度額認定確認リスト.get特地減免().isEmpty()) {
                source.list4_4 = RString.EMPTY;
            } else {
                source.list4_4 = 認;
            }

            if (this.負担限度額認定確認リスト.is生活保護受給者()) {
                source.list1_4 = 星;
            }
            if (this.負担限度額認定確認リスト.is老齢福祉年金受給者()) {
                source.list1_5 = 星;
            }
            if (null != this.負担限度額認定確認リスト.get合計所得金額()) {
                source.list2_7 = DecimalFormatter.toコンマ区切りRString(this.負担限度額認定確認リスト.get合計所得金額(), 0);
            }
            source.list3_1 = RString.EMPTY;
            if (null != this.負担限度額認定確認リスト.get世帯課税区分()
                    && !this.負担限度額認定確認リスト.get世帯課税区分().isEmpty()) {
                RString 世帯課税 = this.負担限度額認定確認リスト.get世帯課税区分();
                RString 世帯課税名称 = RString.EMPTY;
                世帯課税名称 = SetaiKazeiKubun.toValue(世帯課税).get名称();
                source.list3_2 = 世帯課税名称;
            }
            source.list3_3 = RString.EMPTY;
            if (null != this.負担限度額認定確認リスト.getAtesakiEntity()) {
                IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(this.負担限度額認定確認リスト.getAtesakiEntity());
                get登録異動年月日(source, 宛名);
            }
            DbT4018KaigoHokenFutanGendogakuNinteiEntity 今回認定結果 = this.負担限度額認定確認リスト.get今回認定結果();
            if (null != 今回認定結果) {
                get配偶者課税区分名称(source, 今回認定結果);
                get預貯金等合計(source, 今回認定結果);

            }
        }
    }

    private void setKonkai1(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        DbT4018KaigoHokenFutanGendogakuNinteiEntity 今回認定結果 = this.負担限度額認定確認リスト.get今回認定結果();
        if (null != 今回認定結果) {
            FlexibleDate shinseiYMD = 今回認定結果.getShinseiYMD();
            source.list1_6 = (shinseiYMD == null || shinseiYMD.isEmpty()) ? RString.EMPTY : shinseiYMD.wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            FlexibleDate ketteiYMD = 今回認定結果.getKetteiYMD();
            source.list3_4 = (ketteiYMD == null || ketteiYMD.isEmpty()) ? RString.EMPTY : ketteiYMD.wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 決定区分 = 今回認定結果.getKetteiKubun();
            RString 承認 = KetteiKubun.承認する.getコード();
            RString 承認しない = KetteiKubun.承認しない.getコード();
            if (承認.equals(決定区分)) {
                source.list2_8 = 承認1;
            } else if (承認しない.equals(決定区分)) {
                source.list2_8 = 却下;
            }
            FlexibleDate tekiyoKaishiYMD = 今回認定結果.getTekiyoKaishiYMD();
            source.list1_7 = (tekiyoKaishiYMD == null || tekiyoKaishiYMD.isEmpty()) ? RString.EMPTY : tekiyoKaishiYMD.
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
            FlexibleDate tekiyoShuryoYMD = 今回認定結果.getTekiyoShuryoYMD();
            source.list2_9 = (tekiyoShuryoYMD == null || tekiyoShuryoYMD.isEmpty()) ? RString.EMPTY : tekiyoShuryoYMD.
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
            if (null != 今回認定結果.getKyusochishaKubun()) {
                source.list3_5 = 今回認定結果.getKyusochishaKubun();
            }
            RString 利用者負担段階今回 = 今回認定結果.getRiyoshaFutanDankai();
            DbT4018KaigoHokenFutanGendogakuNinteiEntity 前回認定結果 = this.負担限度額認定確認リスト.get前回認定結果();
            if (利用者負担段階今回 != null && 利用者負担段階今回 != 前回認定結果.getRiyoshaFutanDankai()
                    && 前回認定結果.getRiyoshaFutanDankai() != null) {
                source.list1_8 = 星;
            }
        }
    }

    private void setKonkai2(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        DbT4018KaigoHokenFutanGendogakuNinteiEntity 今回認定結果 = this.負担限度額認定確認リスト.get今回認定結果();
        if (null != 今回認定結果) {
            if (null != 今回認定結果.getRiyoshaFutanDankai()) {
                source.list1_9 = 今回認定結果.getRiyoshaFutanDankai();
            }
            if (null != 今回認定結果.getShokuhiFutanGendogaku()) {
                source.list2_10 = DecimalFormatter.toコンマ区切りRString(今回認定結果.getShokuhiFutanGendogaku(), 0);
            }
            if (null != 今回認定結果.getUnitTypeKoshitsu()) {
                source.list3_6 = DecimalFormatter.toコンマ区切りRString(今回認定結果.getUnitTypeKoshitsu(), 0);
            }
            if (null != 今回認定結果.getUnitTypeJunKoshitsu()) {
                source.list1_10 = DecimalFormatter.toコンマ区切りRString(今回認定結果.getUnitTypeJunKoshitsu(), 0);
            }
            if (null != 今回認定結果.getJuraiTypeKoshitsu_Tokuyo()) {
                source.list2_11 = DecimalFormatter.toコンマ区切りRString(今回認定結果.getJuraiTypeKoshitsu_Tokuyo(), 0);
            }
            if (null != 今回認定結果.getJuraiTypeKoshitsu_Roken_Ryoyo()) {
                source.list3_7 = DecimalFormatter.toコンマ区切りRString(今回認定結果.getJuraiTypeKoshitsu_Roken_Ryoyo(), 0);
            }
            if (null != 今回認定結果.getTashoshitsu()) {
                source.list1_11 = DecimalFormatter.toコンマ区切りRString(今回認定結果.getTashoshitsu(), 0);
            }
            if (null != 今回認定結果.getRiyoshaFutanDankai()
                    && (RiyoshaFutanDankai.課税層第三段階.getコード().equals(今回認定結果.getRiyoshaFutanDankai()))) {
                source.list2_12 = 該当;
            } else {
                source.list2_12 = 非該当;
            }
        }
    }

    private void setZenkai(FutanGendogakuNinteiKakuninIchiranReportSource source) {
        DbT4018KaigoHokenFutanGendogakuNinteiEntity 前回認定結果 = this.負担限度額認定確認リスト.get前回認定結果();
        if (null != 前回認定結果) {
            FlexibleDate shinseiYMD = 前回認定結果.getShinseiYMD();
            source.list1_12 = (shinseiYMD == null || shinseiYMD.isEmpty()) ? RString.EMPTY : shinseiYMD.
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            FlexibleDate ketteiYMD = 前回認定結果.getKetteiYMD();
            source.list2_13 = (ketteiYMD == null || ketteiYMD.isEmpty()) ? RString.EMPTY : ketteiYMD.
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 決定区分 = 前回認定結果.getKetteiKubun();
            RString 承認 = KetteiKubun.承認する.getコード();
            RString 承認しない = KetteiKubun.承認しない.getコード();
            if (承認.equals(決定区分)) {
                source.list2_13 = 承認1;
            } else if (承認しない.equals(決定区分)) {
                source.list2_13 = 却下;
            } else {
                source.list2_13 = RString.EMPTY;
            }
            FlexibleDate tekiyoKaishiYMD = 前回認定結果.getTekiyoKaishiYMD();
            source.list1_13 = (tekiyoKaishiYMD == null || tekiyoKaishiYMD.isEmpty()) ? RString.EMPTY : tekiyoKaishiYMD.
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            FlexibleDate tekiyoShuryoYMD = 前回認定結果.getTekiyoShuryoYMD();
            source.list2_14 = (tekiyoShuryoYMD == null || tekiyoShuryoYMD.isEmpty()) ? RString.EMPTY : tekiyoShuryoYMD.
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            get前回認定(source, 前回認定結果);
            if (null != 前回認定結果.getRiyoshaFutanDankai()
                    && (RiyoshaFutanDankai.課税層第三段階.getコード().equals(前回認定結果.getRiyoshaFutanDankai()))) {
                source.list2_17 = 該当;
            } else {
                source.list2_17 = 非該当;
            }
        }
    }

    private void get前回認定(FutanGendogakuNinteiKakuninIchiranReportSource source,
            DbT4018KaigoHokenFutanGendogakuNinteiEntity 前回認定結果) {
        if (null != 前回認定結果.getKyusochishaKubun()) {
            source.list3_9 = 前回認定結果.getKyusochishaKubun();
        }
        if (null != 前回認定結果.getRiyoshaFutanDankai()) {
            source.list1_14 = 前回認定結果.getRiyoshaFutanDankai();
        }
        if (null != 前回認定結果.getShokuhiFutanGendogaku()) {
            source.list2_15 = DecimalFormatter.toコンマ区切りRString(前回認定結果.getShokuhiFutanGendogaku(), 0);
        }
        if (null != 前回認定結果.getUnitTypeKoshitsu()) {
            source.list3_10 = DecimalFormatter.toコンマ区切りRString(前回認定結果.getUnitTypeKoshitsu(), 0);
        }
        if (null != 前回認定結果.getUnitTypeJunKoshitsu()) {
            source.list1_15 = DecimalFormatter.toコンマ区切りRString(前回認定結果.getUnitTypeJunKoshitsu(), 0);
        }
        if (null != 前回認定結果.getJuraiTypeKoshitsu_Tokuyo()) {
            source.list2_16 = DecimalFormatter.toコンマ区切りRString(前回認定結果.getJuraiTypeKoshitsu_Tokuyo(), 0);
        }
        if (null != 前回認定結果.getJuraiTypeKoshitsu_Roken_Ryoyo()) {
            source.list3_11 = DecimalFormatter.toコンマ区切りRString(前回認定結果.getJuraiTypeKoshitsu_Roken_Ryoyo(), 0);
        }
        if (null != 前回認定結果.getTashoshitsu()) {
            source.list1_16 = DecimalFormatter.toコンマ区切りRString(前回認定結果.getTashoshitsu(), 0);
        }
    }

    private void get名称(FutanGendogakuNinteiKakuninIchiranReportSource source, IKojin 宛名) {
        if (null != 宛名.get名称()) {
            source.list1_2 = 宛名.get名称().getName().value();
        }
    }

    private RString get要介護度() {
        RString 要介護認定状態区分コード = this.負担限度額認定確認リスト.get要介護状態区分コード();
        KoroshoInterfaceShikibetsuCode 厚労省IF識別コード = KoroshoInterfaceShikibetsuCode.
                toValue(this.負担限度額認定確認リスト.get厚労省IF識別コード());
        return YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護認定状態区分コード).getName();
    }

    private FutanGendogakuNinteiKakuninIchiranReportSource set出力順改頁(FutanGendogakuNinteiKakuninIchiranReportSource source,
            List<ISetSortItem> 設定項目リスト) {

        if (設定項目リスト.size() > LISTINDEX_0) {
            source.shutsuryokujun1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            if (設定項目リスト.get(LISTINDEX_0).is改頁項目()) {
                source.kaiPege1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_1) {
            source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            if (設定項目リスト.get(LISTINDEX_1).is改頁項目()) {
                source.kaiPege2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_2) {
            source.shutsuryokujun3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            if (設定項目リスト.get(LISTINDEX_2).is改頁項目()) {
                source.kaiPege3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_3) {
            source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            if (設定項目リスト.get(LISTINDEX_3).is改頁項目()) {
                source.kaiPege4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_4) {
            source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            if (設定項目リスト.get(LISTINDEX_4).is改頁項目()) {
                source.kaiPege5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
        return source;
    }

    private void get預貯金等合計(FutanGendogakuNinteiKakuninIchiranReportSource source,
            DbT4018KaigoHokenFutanGendogakuNinteiEntity 今回認定結果) {
        Decimal 有価証券評価概算額 = Decimal.ZERO;
        Decimal 預貯金額 = Decimal.ZERO;
        Decimal その他金額 = Decimal.ZERO;
        if (null != 今回認定結果.getYochokinGaku()) {
            預貯金額 = 今回認定結果.getYochokinGaku();
        }
        if (null != 今回認定結果.getYukashoukenGaisangaku()) {
            有価証券評価概算額 = 今回認定結果.getYukashoukenGaisangaku();
        }
        if (null != 今回認定結果.getSonotaKingaku()) {
            その他金額 = 今回認定結果.getSonotaKingaku();
        }
        Decimal 合計 = Decimal.ZERO;
        合計.add(預貯金額).add(有価証券評価概算額).add(その他金額);
        source.list6_2 = DecimalFormatter.toコンマ区切りRString(合計, 0);
    }

    private void get申請理由区分名称(FutanGendogakuNinteiKakuninIchiranReportSource source,
            DbT4018KaigoHokenFutanGendogakuNinteiEntity 今回認定結果) {
        RString 申請理由区分 = 今回認定結果.getShinseiRiyuKubun();
        if (null != 申請理由区分 && !申請理由区分.isEmpty()) {
            RString 申請理由区分名称 = RString.EMPTY;
            申請理由区分名称 = ShinseiRiyuKubun.toValue(申請理由区分).get名称();
            source.list1_3 = 申請理由区分名称;
        }
    }

    private void get登録異動年月日(FutanGendogakuNinteiKakuninIchiranReportSource source, IKojin 宛名) {
        if (null != 宛名.get登録異動年月日()) {
            source.list5_1 = 宛名.get登録異動年月日().wareki().toDateString();
        }
    }

    private void get配偶者課税区分名称(FutanGendogakuNinteiKakuninIchiranReportSource source,
            DbT4018KaigoHokenFutanGendogakuNinteiEntity 今回認定結果) {
        RString 配偶者課税区分 = 今回認定結果.getHaigushaKazeiKubun();
        if (null != 配偶者課税区分 && !配偶者課税区分.isEmpty()) {
            RString 配偶者課税区分名称 = RString.EMPTY;
            配偶者課税区分名称 = HaigushaKazeiKubun.toValue(配偶者課税区分).get名称();
            source.list3_2 = 配偶者課税区分名称;
        }
    }
}
