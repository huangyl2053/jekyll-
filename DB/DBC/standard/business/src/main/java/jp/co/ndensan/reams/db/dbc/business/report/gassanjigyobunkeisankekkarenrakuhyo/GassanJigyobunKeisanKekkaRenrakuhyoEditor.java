/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkeisankekkarenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanResultEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 事業分計算結果連絡票Editorクラスです。
 *
 * @reamsid_L DBC-4840-030 wangxingpeng
 */
public class GassanJigyobunKeisanKekkaRenrakuhyoEditor implements IGassanJigyobunKeisanKekkaRenrakuhyoEditor {

    private final RString 通知書定型文1;
    private final RString 通知書定型文2;
    private final JigyobunShikyugakuKeisanResultEntity dataEntity;
    private final NinshoshaSource 認証者;
    private final IShikibetsuTaisho 宛名データ;
    private final RString 通知書定型文3;
    private final boolean flag;
    private final boolean isBreak;
    private final int count;
    private static final RString FORMAT = new RString("※");
    private static final RString 小計 = new RString("小計");
    private static final int INDEX_0 = 0;
    private static final int INDEX_3 = 3;
    private static final int INDEX_25 = 25;
    private static final int INDEX_50 = 50;
    private static final int INDEX_75 = 75;
    private static final RString 文_被保険者番号 = new RString("被保険者番号");
    private static final RString NENDO = new RString("年度");
    private final RString 記号 = new RString("-");

    /**
     * コンストラクタです
     *
     * @param 通知書定型文1 RString
     * @param 通知書定型文2 RString
     * @param dataEntity JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity
     * @param 認証者 NinshoshaSource
     * @param 宛名データ IShikibetsuTaisho
     * @param 通知書定型文3 RString
     * @param flag boolean
     * @param isBreak boolean
     * @param count int
     */
    public GassanJigyobunKeisanKekkaRenrakuhyoEditor(RString 通知書定型文1, RString 通知書定型文2,
            JigyobunShikyugakuKeisanResultEntity dataEntity, NinshoshaSource 認証者,
            IShikibetsuTaisho 宛名データ,
            RString 通知書定型文3, boolean flag, boolean isBreak, int count) {
        this.通知書定型文1 = 通知書定型文1;
        this.通知書定型文2 = 通知書定型文2;
        this.dataEntity = dataEntity;
        this.認証者 = 認証者;
        this.宛名データ = 宛名データ;
        this.通知書定型文3 = 通知書定型文3;
        this.flag = flag;
        this.isBreak = isBreak;
        this.count = count;

    }

    @Override
    public GassanJigyobunKeisanKekkaRenrakuhyoSource edit(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {

        source.pageBonbo = new RString(count);
        source.title = 通知書定型文1;
        edit結果連絡先住所(source);
        edit保険者住所(source);
        edit問い合わせ先(source);

        editレイヤ１(source);
        if (isBreak) {
            RString fullspace = RString.FULL_SPACE;
            RString full3space = RString.FULL_SPACE.concat(fullspace).concat(fullspace);
            RString 小計表示 = full3space.concat(FORMAT).concat(fullspace).concat(小計).concat(fullspace).concat(FORMAT).concat(full3space);
            source.list1_3 = 小計表示;
            edit小計(source);
        } else {
            edit計算結果の内訳(source);
        }
        if (flag) {
            edit計(source);
        }

        if (宛名データ != null) {
            if (宛名データ.get識別コード() != null) {
                source.shikibetsuCode = 宛名データ.get識別コード().getColumnValue();
            } else {
                source.shikibetsuCode = RString.EMPTY;
            }
        } else {
            source.shikibetsuCode = RString.EMPTY;
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), 文_被保険者番号, get非空文字列(source.hihokenshaNo));
        return source;
    }

    private void edit問い合わせ先(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (通知書定型文3 != null) {
            source.toiawasesaki = 通知書定型文3;
        }
    }

    private void edit計(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (null == dataEntity || null == dataEntity.getDbt3172Entity()) {
            return;
        }
        if (dataEntity.getDbt3172Entity().getOver70_FutangakuGokei() != null) {
            source.over70FutangakuGokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getOver70_FutangakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getOver70_ShikyugakuGokei() != null) {
            source.over70ShikyugakuGokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getOver70_ShikyugakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getUnder70_FutangakuGokei() != null) {
            source.under70FutangakuGokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getUnder70_FutangakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getFutangakuGokei() != null) {
            source.futangakuGokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getFutangakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getUnder70_ShikyugakuGokei() != null) {
            source.under70ShikyugakuGokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getUnder70_ShikyugakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getShikyugakuGokei() != null) {
            source.shikyugakuGokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getShikyugakuGokei(), 0);
        }
    }

    private void edit計算結果の内訳(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (null == dataEntity || null == dataEntity.getDbt3173Entity()) {
            return;
        }
        source.list1_1 = dataEntity.getDbt3173Entity().getUchiwakeHokenshaMei();
        source.list1_2 = dataEntity.getDbt3173Entity().getJikoFutanSeiriNo();
        source.list1_3 = dataEntity.getDbt3173Entity().getTaishoshaShimei();
        source.list1_4 = dataEntity.getDbt3173Entity().getUchiwakeHokenshaNo();
        source.list1_5 = dataEntity.getDbt3173Entity().getKokuho_HihokenshaShoKigo();
        source.list1_6 = dataEntity.getDbt3173Entity().getHiHokenshaShoNo();
        RString over70futangaku = dataEntity.getDbt3173Entity().getOver70_Futangaku();
        if (over70futangaku != null) {
            source.list1_7 = DecimalFormatter.toコンマ区切りRString(new Decimal(over70futangaku.toString()), 0);
        }
        source.list1_8 = dataEntity.getDbt3173Entity().getOver70_AmbunRitsu();
        RString over70shikyugaku = dataEntity.getDbt3173Entity().getOver70_Shikyugaku();
        if (over70shikyugaku != null) {
            source.list1_9 = DecimalFormatter.toコンマ区切りRString(new Decimal(over70shikyugaku.toString()), 0);
        }
        RString under70futangaku = dataEntity.getDbt3173Entity().getUnder70_Futangaku();
        if (under70futangaku != null) {
            source.list1_10 = DecimalFormatter.toコンマ区切りRString(new Decimal(under70futangaku.toString()), 0);
        }
        RString futangaku = dataEntity.getDbt3173Entity().getFutangaku();
        if (futangaku != null) {
            source.list1_11 = DecimalFormatter.toコンマ区切りRString(new Decimal(futangaku.toString()), 0);
        }
        source.list1_12 = dataEntity.getDbt3173Entity().getAmbunRitsu();
        RString under70shikyugaku = dataEntity.getDbt3173Entity().getUnder70_Shikyugaku();
        if (under70shikyugaku != null) {
            source.list1_13 = DecimalFormatter.toコンマ区切りRString(new Decimal(under70shikyugaku.toString()), 0);
        }
        RString shikyugaku = dataEntity.getDbt3173Entity().getShikyugaku();
        if (shikyugaku != null) {
            source.list1_14 = DecimalFormatter.toコンマ区切りRString(new Decimal(shikyugaku.toString()), 0);
        }

    }

    private void editレイヤ１(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (null == dataEntity || null == dataEntity.getDbt3172Entity()) {
            return;
        }
        source.shikyuSeiriNO = dataEntity.getDbt3172Entity().getShikyuShinseishoSeiriNo();

        edit宛名(source);
        source.jikoFutanSeiriNo = dataEntity.getDbt3172Entity().getJikoFutanSeiriNo();
        if (dataEntity.getDbt3172Entity().getShoKisaiHokenshaNo() != null) {
            source.hokenshaNo = dataEntity.getDbt3172Entity().getShoKisaiHokenshaNo().getColumnValue();
        }

        source.hihokenshaKigo = RString.EMPTY;
        if (dataEntity.getDbt3172Entity().getHihokenshaNo() != null) {
            HihokenshaNo 被保険者番号 = dataEntity.getDbt3172Entity().getHihokenshaNo();
            source.hihokenshaNo = 被保険者番号.getColumnValue();
        }
        source.taishoNendo = dataEntity.getDbt3172Entity().getTaishoNendo().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO);
        FlexibleDate 対象計算期間開始年月日 = dataEntity.getDbt3172Entity().getTaishoKeisanKaishiYMD();
        if (対象計算期間開始年月日 != null) {
            source.keisanSTYMD = 対象計算期間開始年月日.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        FlexibleDate 対象計算期間終了年月日 = dataEntity.getDbt3172Entity().getTaishoKeisanShuryoYMD();
        if (対象計算期間終了年月日 != null) {
            source.keisanEDYMD = 対象計算期間終了年月日.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.biko = dataEntity.getDbt3172Entity().getBiko();
        Decimal setaiFutanSogaku = dataEntity.getDbt3172Entity().getSetaiFutanSogaku();
        if (setaiFutanSogaku != null) {
            source.setaiFutanSogaku = new RString(setaiFutanSogaku.toString());
        }
        Decimal setaiGassanGaku = dataEntity.getDbt3172Entity().getSetaiGassanGaku();
        if (setaiGassanGaku != null) {
            source.setaiGassanFutanGaku = new RString(setaiGassanGaku.toString());
        }
        Decimal over70_SetaiGassanGaku = dataEntity.getDbt3172Entity().getOver70_SetaiGassanGaku();
        if (over70_SetaiGassanGaku != null) {
            source.over70SetaiGassanFutanGaku = new RString(over70_SetaiGassanGaku.toString());
        }
        source.shotokuKbn = KaigoGassan_ShotokuKbn.toValue(dataEntity.getDbt3172Entity().getShotokuKubun()).get名称();
        source.over70ShotokuKbn = KaigoGassan_Over70_ShotokuKbn.toValue(dataEntity.getDbt3172Entity().getOver70_ShotokuKubun()).get名称();
        Decimal santeiKijunGaku = dataEntity.getDbt3172Entity().getSanteiKijunGaku();
        if (santeiKijunGaku != null) {
            source.santeiKijunGaku = new RString(santeiKijunGaku.toString());
        }
        Decimal over70_SanteiKijyunGaku = dataEntity.getDbt3172Entity().getOver70_SanteiKijyunGaku();
        if (over70_SanteiKijyunGaku != null) {
            source.over70SanteiKijunGaku = new RString(over70_SanteiKijyunGaku.toString());
        }
        Decimal setaiShikyuSogaku = dataEntity.getDbt3172Entity().getSetaiShikyuSogaku();
        if (setaiShikyuSogaku != null) {
            source.setaiShikyuGaku = new RString(setaiShikyuSogaku.toString());
        }
        Decimal over70_SetaiShikyuSogaku = dataEntity.getDbt3172Entity().getOver70_SetaiShikyuSogaku();
        if (over70_SetaiShikyuSogaku != null) {
            source.over70SetaiShikyuGaku = new RString(over70_SetaiShikyuSogaku.toString());
        }
        Decimal honninShikyugaku = dataEntity.getDbt3172Entity().getHonninShikyugaku();
        if (honninShikyugaku != null) {
            source.honninShikyuGaku = new RString(honninShikyugaku.toString());
        }
        Decimal over70_honninShikyugaku = dataEntity.getDbt3172Entity().getOver70_honninShikyugaku();
        if (over70_honninShikyugaku != null) {
            source.over70HonninShikyuGaku = new RString(over70_honninShikyugaku.toString());
        }
    }

    private void edit宛名(GassanJigyobunKeisanKekkaRenrakuhyoSource source) throws ClassCastException {
        if (宛名データ == null) {
            return;
        }

        if (宛名データ.get名称().getKana() != null) {
            source.taishoshaNameKana = 宛名データ.get名称().getKana().getColumnValue();
        }
        if (宛名データ.get名称().getName() != null) {
            source.taishoshaName = 宛名データ.get名称().getName().getColumnValue();
        }
        if (宛名データ.to個人() != null) {
            if (宛名データ.to個人().get生年月日() != null) {
                source.birthYMD = 宛名データ.to個人().get生年月日().toFlexibleDate().wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (宛名データ.to個人().get性別() != null) {
                source.seibetsu = 宛名データ.to個人().get性別().getCommonName();
            }
        }
    }

    private void edit小計(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (null == dataEntity || null == dataEntity.getDbt3173Entity()) {
            return;
        }
        source.list1_7 = dataEntity.getDbt3173Entity().getOver70_Futangaku();
        source.list1_9 = dataEntity.getDbt3173Entity().getOver70_Shikyugaku();
        source.list1_10 = dataEntity.getDbt3173Entity().getUnder70_Futangaku();
        source.list1_11 = dataEntity.getDbt3173Entity().getFutangaku();
        source.list1_13 = dataEntity.getDbt3173Entity().getUnder70_Shikyugaku();
        source.list1_14 = dataEntity.getDbt3173Entity().getShikyugaku();
    }

    private void edit保険者住所(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        source.hakkosha = 通知書定型文2;
        if (認証者 != null) {
            source.denshiKoin = 認証者.denshiKoin;
            source.koinShoryaku = 認証者.koinShoryaku;
            source.koinMojiretsu = 認証者.koinMojiretsu;
            source.ninshoshaYakushokuMei = 認証者.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = 認証者.ninshoshaYakushokuMei1;
            source.ninshoshaYakushokuMei2 = 認証者.ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = 認証者.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = 認証者.ninshoshaShimeiKakeru;

        }

    }

    private void edit結果連絡先住所(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (dataEntity == null || dataEntity.getDbt3172Entity() == null || dataEntity.getDbt3172Entity().getKekkaRenrakusakiJusho() == null) {
            return;
        }
        YubinNo yubinNo = dataEntity.getDbt3172Entity().getKekkaRenrakusakiYubinNo();
        if (yubinNo != null) {
            RString 郵便番号1 = yubinNo.value().substring(INDEX_0, INDEX_3);
            RString 郵便番号2 = yubinNo.value().substring(INDEX_3);
            source.kekkaRenrakuYubinNO = 郵便番号1.concat(記号).concat(郵便番号2);
        }
        RString 支給額計算結果連絡先住所 = dataEntity.getDbt3172Entity().getKekkaRenrakusakiJusho();
        if (支給額計算結果連絡先住所 != null) {
            int length = 支給額計算結果連絡先住所.toString().toCharArray().length;
            if (length <= INDEX_25) {
                source.kekkaRenrakuJusho1 = 支給額計算結果連絡先住所;
            }
            if (INDEX_25 < length && length <= INDEX_50) {
                source.kekkaRenrakuJusho1 = 支給額計算結果連絡先住所.substring(INDEX_0, INDEX_25);
                source.kekkaRenrakuJusho2 = 支給額計算結果連絡先住所.substring(INDEX_25);
            }
            if (INDEX_50 < length && length < INDEX_75) {
                source.kekkaRenrakuJusho1 = 支給額計算結果連絡先住所.substring(INDEX_0, INDEX_25);
                source.kekkaRenrakuJusho2 = 支給額計算結果連絡先住所.substring(INDEX_25, INDEX_50);
                source.kekkaRenrakuJusho3 = 支給額計算結果連絡先住所.substring(INDEX_50);
            }
        }
        source.kekkaRenrakuMeisho1 = dataEntity.getDbt3172Entity().getKetteRenrakusakiMeisho1();
        source.kekkaRenrakuMeisho2 = dataEntity.getDbt3172Entity().getKekkaRenrakusakiMeisho2();
        FlexibleDate 通知年月日 = dataEntity.getDbt3172Entity().getTsuchiYMD();
        if (通知年月日 != null) {
            source.tuchiYMD = 通知年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }

}
