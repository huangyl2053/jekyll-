/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkeisankekkarenrakuhyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
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
    private final JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity dataEntity;
    private final NinshoshaSource 認証者;
    private final Association 地方公共団体;
    private final IShikibetsuTaisho 宛名データ;
    private final ToiawasesakiSource 問い合わせ先;
    private final boolean flag;
    private final boolean isBreak;
    private static final RString FORMAT = new RString("※");
    private static final RString 小計 = new RString("小計");
    private static final int INDEX_0 = 0;
    private static final int INDEX_14 = 14;
    private static final int INDEX_15 = 15;
    private static final int INDEX_25 = 25;
    private static final int INDEX_50 = 50;
    private static final int INDEX_75 = 75;
    private static final RString 文_被保険者番号 = new RString("被保険者番号");
    private static final RString NENDO = new RString("年度");

    /**
     * コンストラクタです
     *
     * @param 通知書定型文1 RString
     * @param 通知書定型文2 RString
     * @param dataEntity JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity
     * @param 認証者 NinshoshaSource
     * @param 地方公共団体 Association
     * @param 宛名データ IShikibetsuTaisho
     * @param 問い合わせ先 IToiawasesakiSourceBuilder
     * @param flag boolean
     * @param isBreak boolean
     */
    public GassanJigyobunKeisanKekkaRenrakuhyoEditor(RString 通知書定型文1, RString 通知書定型文2,
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity dataEntity, NinshoshaSource 認証者,
            Association 地方公共団体,
            IShikibetsuTaisho 宛名データ,
            ToiawasesakiSource 問い合わせ先, boolean flag, boolean isBreak) {
        this.通知書定型文1 = 通知書定型文1;
        this.通知書定型文2 = 通知書定型文2;
        this.dataEntity = dataEntity;
        this.認証者 = 認証者;
        this.地方公共団体 = 地方公共団体;
        this.宛名データ = 宛名データ;
        this.問い合わせ先 = 問い合わせ先;
        this.flag = flag;
        this.isBreak = isBreak;

    }

    @Override
    public GassanJigyobunKeisanKekkaRenrakuhyoSource edit(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        source.title = 通知書定型文1;
        edit結果連絡先住所(source);
        edit保険者住所(source);
        edit問い合わせ先(source);

        editレイヤ１(source);
        if (isBreak) {
            RString fullspace = RString.FULL_SPACE;
            RString full3space = RString.FULL_SPACE.concat(fullspace).concat(fullspace);
            RString 小計表示 = full3space.concat(FORMAT).concat(fullspace).concat(小計).concat(fullspace).concat(FORMAT).concat(full3space);
            source.List1_3 = 小計表示;
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
            }
            if (dataEntity.getDbt3172Entity().getHihokenshaNo() != null) {
                HihokenshaNo 被保険者番号 = dataEntity.getDbt3172Entity().getHihokenshaNo();
                PersonalData personalData = PersonalData.of(宛名データ.get識別コード(),
                        new ExpandedInformation(new Code("003"), 文_被保険者番号, 被保険者番号.getColumnValue()));
                AccessLogger.log(AccessLogType.照会, personalData);
            }
        }

        return source;
    }

    private void edit問い合わせ先(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (問い合わせ先 != null) {
            source.yubinBango = 問い合わせ先.yubinBango;
            source.shozaichi = 問い合わせ先.shozaichi;
            source.choshaBushoName = 問い合わせ先.choshaBushoName;
            source.tantoName = 問い合わせ先.tantoName;
            source.telNo = 問い合わせ先.telNo;
        }
    }

    private void edit計(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (null == dataEntity || null == dataEntity.getDbt3172Entity()) {
            return;
        }
        if (dataEntity.getDbt3172Entity().getOver70_FutangakuGokei() != null) {
            source.Over70_Futangaku_Gokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getOver70_FutangakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getOver70_ShikyugakuGokei() != null) {
            source.Over70_Shikyugaku_Gokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getOver70_ShikyugakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getUnder70_FutangakuGokei() != null) {
            source.Under70_Futangaku_Gokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getUnder70_FutangakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getFutangakuGokei() != null) {
            source.Futangaku_Gokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getFutangakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getUnder70_ShikyugakuGokei() != null) {
            source.Under70_Shikyugaku_Gokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getUnder70_ShikyugakuGokei(), 0);
        }
        if (dataEntity.getDbt3172Entity().getShikyugakuGokei() != null) {
            source.Shikyugaku_Gokei = DecimalFormatter.toコンマ区切りRString(dataEntity.getDbt3172Entity().getShikyugakuGokei(), 0);
        }
    }

    private void edit計算結果の内訳(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (null == dataEntity || null == dataEntity.getDbt3173Entity()) {
            return;
        }
        source.List1_1 = dataEntity.getDbt3173Entity().getUchiwakeHokenshaMei();
        source.List1_2 = dataEntity.getDbt3173Entity().getJikoFutanSeiriNo();
        source.List1_3 = dataEntity.getDbt3173Entity().getTaishoshaShimei();
        source.List1_4 = dataEntity.getDbt3173Entity().getUchiwakeHokenshaNo();
        source.List1_5 = dataEntity.getDbt3173Entity().getKokuho_HihokenshaShoKigo();
        source.List1_6 = dataEntity.getDbt3173Entity().getHiHokenshaShoNo();
        RString over70futangaku = dataEntity.getDbt3173Entity().getOver70_Futangaku();
        if (over70futangaku != null) {
            source.List1_7 = DecimalFormatter.toコンマ区切りRString(new Decimal(over70futangaku.toString()), 0);
        }
        source.List1_8 = dataEntity.getDbt3173Entity().getOver70_AmbunRitsu();
        RString over70shikyugaku = dataEntity.getDbt3173Entity().getOver70_Shikyugaku();
        if (over70shikyugaku != null) {
            source.List1_9 = DecimalFormatter.toコンマ区切りRString(new Decimal(over70shikyugaku.toString()), 0);
        }
        RString under70futangaku = dataEntity.getDbt3173Entity().getUnder70_Futangaku();
        if (under70futangaku != null) {
            source.List1_10 = DecimalFormatter.toコンマ区切りRString(new Decimal(under70futangaku.toString()), 0);
        }
        RString futangaku = dataEntity.getDbt3173Entity().getFutangaku();
        if (futangaku != null) {
            source.List1_11 = DecimalFormatter.toコンマ区切りRString(new Decimal(futangaku.toString()), 0);
        }
        source.List1_12 = dataEntity.getDbt3173Entity().getAmbunRitsu();
        RString under70shikyugaku = dataEntity.getDbt3173Entity().getUnder70_Shikyugaku();
        if (under70shikyugaku != null) {
            source.List1_13 = DecimalFormatter.toコンマ区切りRString(new Decimal(under70shikyugaku.toString()), 0);
        }
        RString shikyugaku = dataEntity.getDbt3173Entity().getShikyugaku();
        if (shikyugaku != null) {
            source.List1_14 = DecimalFormatter.toコンマ区切りRString(new Decimal(shikyugaku.toString()), 0);
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
            source.HihokenshaNo = 被保険者番号.getColumnValue();
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
        source.shotokuKbn = dataEntity.getDbt3172Entity().getShotokuKubun();
        source.over70ShotokuKbn = dataEntity.getDbt3172Entity().getOver70_ShotokuKubun();
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
        source.List1_7 = dataEntity.getDbt3173Entity().getOver70_Futangaku();
        source.List1_9 = dataEntity.getDbt3173Entity().getOver70_Shikyugaku();
        source.List1_10 = dataEntity.getDbt3173Entity().getUnder70_Futangaku();
        source.List1_11 = dataEntity.getDbt3173Entity().getFutangaku();
        source.List1_13 = dataEntity.getDbt3173Entity().getUnder70_Shikyugaku();
        source.List1_14 = dataEntity.getDbt3173Entity().getShikyugaku();
    }

    private void edit保険者住所(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (認証者 != null) {
            source.denshiKoin = 認証者.denshiKoin;
            source.kouin = 認証者.koinMojiretsu;
        }
        source.hakkosha = 通知書定型文2;
        if (地方公共団体 == null || 地方公共団体.get市町村名() == null) {
            return;
        }
        int 市町村length = 地方公共団体.get市町村名().toString().toCharArray().length;
        if (市町村length <= INDEX_14) {
            source.shichosonmeisho1 = 地方公共団体.get市町村名();
        } else if (INDEX_15 <= 市町村length) {
            source.shichosonmeisho2 = 地方公共団体.get市町村名();
        }

        //TODO QA1609
//        source.shuchomei = 帳票制御共通.get首長名印字位置();
    }

    private void edit結果連絡先住所(GassanJigyobunKeisanKekkaRenrakuhyoSource source) {
        if (dataEntity == null || dataEntity.getDbt3172Entity() == null || dataEntity.getDbt3172Entity().getKekkaRenrakusakiJusho() == null) {
            return;
        }
        YubinNo yubinNo = dataEntity.getDbt3172Entity().getKekkaRenrakusakiYubinNo();
        if (yubinNo != null) {
            source.kekkaRenrakuYubinNO = yubinNo.value();
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

}
