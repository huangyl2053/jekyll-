/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho.KogakuGassanShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * （高額合算支給（不支給）決定通知書）支払予定日ありのEditorです。
 *
 * @reamsid_L DBC-4850-030 dongqianjing
 */
public class GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriEditor implements
        IGassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriEditor {

    private final KogakuGassanShikyuKetteiTsuchisho entity;
    private final NinshoshaSource ninshoshaSource;
    private final List<ChohyoSeigyoHanyo> 帳票制御汎用キー;
    private static final RString 波線 = new RString("～");
    private static final RString 支給額 = new RString("支給額");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_12 = new RString("12");
    private static final RString 郵貯銀行 = new RString("9900");
    private static final RString 午前 = new RString("午前");
    private static final RString 午後 = new RString("午後");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 支給 = new RString("支給");
    private static final RString 不支給 = new RString("不支給");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_16 = 16;
    private static final int INT_32 = 32;
    private static final int INT_38 = 38;
    private static final int INT_48 = 48;
    private static final int INT_64 = 64;
    private static final int INT_76 = 76;
    private static final int INT_114 = 114;
    private static final RString 備考 = new RString("備考");
    private static final RString 不支給の理由 = new RString("不支給の理由");
    private static final RString HOSHI_14 = new RString("**************");
    private static final RString 持ち物内容文言１ = new RString("持ち物内容文言１");
    private static final RString 持ち物内容文言2 = new RString("持ち物内容文言2");
    private static final RString 持ち物内容文言3 = new RString("持ち物内容文言3");
    private static final RString ゆうちょ銀行店名表示 = new RString("ゆうちょ銀行店名表示");
    private static final RString 店番 = new RString("店番");
    private static final RString 口座種別 = new RString("口座種別");
    private static final RString 口座番号 = new RString("口座番号");
    private RString ワーク窓口払区分;
    private RString ワーク口座払区分;
    private RString ワーク不支給区分;
    private DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity 事業高額合算支給不支給決定;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link KogakuGassanShikyuKetteiTsuchisho}
     * @param ninshoshaSource NinshoshaSource
     * @param 帳票制御汎用キー List<ChohyoSeigyoHanyo>
     */
    protected GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriEditor(KogakuGassanShikyuKetteiTsuchisho entity,
            NinshoshaSource ninshoshaSource, List<ChohyoSeigyoHanyo> 帳票制御汎用キー) {
        this.entity = entity;
        this.ninshoshaSource = ninshoshaSource;
        this.帳票制御汎用キー = 帳票制御汎用キー;
    }

    @Override
    public GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource edit(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        editSource(source);
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource editSource(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        ワーク窓口払区分 = RSTRING_0;
        ワーク口座払区分 = RSTRING_0;
        ワーク不支給区分 = RSTRING_0;
        this.edit送付物宛先(source);
//       TODO   this.edit文書(source);
        this.edit認証者(source);
        this.edit通知書(source);
        if (entity.get事業高額合算支給不支給決定() != null) {
            事業高額合算支給不支給決定 = entity.get事業高額合算支給不支給決定();
            if (Decimal.ZERO.compareTo(事業高額合算支給不支給決定.getShikyugaku()) < 0 && RSTRING_1.equals(事業高額合算支給不支給決定.getShikyuKubunCode())
                    && RSTRING_1.equals(事業高額合算支給不支給決定.getShiharaiHohoKubun())) {
                ワーク窓口払区分 = RSTRING_1;

            }
            if (Decimal.ZERO.compareTo(事業高額合算支給不支給決定.getShikyugaku()) < 0 && RSTRING_1.equals(事業高額合算支給不支給決定
                    .getShikyuKubunCode()) && RSTRING_2.equals(事業高額合算支給不支給決定.getShiharaiHohoKubun())) {
                ワーク口座払区分 = RSTRING_1;

            }
            if (Decimal.ZERO.compareTo(事業高額合算支給不支給決定.getShikyugaku()) >= 0 || RSTRING_2.equals(事業高額合算支給不支給決定
                    .getShikyuKubunCode())) {
                ワーク不支給区分 = RSTRING_1;

            }
            this.set事業高額合算支給不支給決定(source);

        }

        return source;

    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource edit送付物宛先(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        SofubutsuAtesakiSource 送付物宛先 = entity.get送付物宛先();
        if (送付物宛先 != null) {
            source.yubinNo = 送付物宛先.yubinNo;
            source.gyoseiku = 送付物宛先.gyoseiku;
            source.jushoText = 送付物宛先.jushoText;
            source.jusho1 = 送付物宛先.jusho1;
            source.jusho2 = 送付物宛先.jusho2;
            source.jusho3 = 送付物宛先.jusho3;
            source.katagakiText = 送付物宛先.katagaki1;
            source.katagaki1 = 送付物宛先.katagaki2;
            source.katagaki2 = 送付物宛先.katagaki2;
            source.katagakiSmall1 = 送付物宛先.katagakiSmall1;
            source.katagakiSmall2 = 送付物宛先.katagakiSmall2;
            source.customerBarCode = 送付物宛先.customerBarCode;
            source.dainoKubunMei = 送付物宛先.dainoKubunMei;
            source.shimeiText = 送付物宛先.shimeiText;
            source.shimei1 = 送付物宛先.shimei1;
            source.shimei2 = 送付物宛先.shimei2;
            source.shimeiSmall1 = 送付物宛先.shimeiSmall1;
            source.shimeiSmall2 = 送付物宛先.shimeiSmall2;
            source.samabunShimeiText = 送付物宛先.samabunShimeiText;
            source.samabunShimei1 = 送付物宛先.samabunShimei1;
            source.samabunShimei2 = 送付物宛先.samabunShimei2;
            source.samabunShimeiSmall1 = 送付物宛先.samabunShimeiSmall1;
            source.samabunShimeiSmall2 = 送付物宛先.samabunShimeiSmall2;
            source.meishoFuyo1 = 送付物宛先.meishoFuyo1;
            source.meishoFuyo2 = 送付物宛先.meishoFuyo2;
            source.samaBun1 = 送付物宛先.samaBun1;
            source.samaBun2 = 送付物宛先.samaBun2;
            source.kakkoLeft1 = 送付物宛先.kakkoLeft1;
            source.kakkoLeft2 = 送付物宛先.kakkoLeft2;
            source.kakkoRight1 = 送付物宛先.kakkoRight1;
            source.kakkoRight2 = 送付物宛先.kakkoRight2;
        }
        return source;
    }

//    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource edit文書(
//            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
//        if (entity.get文書番号() != null) {
//            //TODO
////            source.bunshoNo = entity.get文書番号();
//        }
//        return source;
//    }
    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource edit認証者(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {

        if (ninshoshaSource != null) {
            source.denshiKoin = ninshoshaSource.denshiKoin;
            source.hakkoYMD = ninshoshaSource.hakkoYMD;
            source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
            source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
            source.koinShoryaku = ninshoshaSource.koinShoryaku;
            source.koinMojiretsu = ninshoshaSource.koinMojiretsu;

        }
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource edit通知書(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        if (entity.getTitle() != null) {
            source.title = entity.getTitle();
        }
        if (entity.getTitle21() != null) {
            //todo
            source.title2_1 = entity.getTitle21();
        }
        if (entity.getTitle221() != null) {
            source.title221 = entity.getTitle221();
        }
        if (entity.getTitle222() != null) {
            source.title222 = entity.getTitle222();
        }
        if (entity.getTitle231() != null) {
            source.title231 = entity.getTitle231();
        }
        if (entity.getTitle232() != null) {
            source.title232 = entity.getTitle232();
        }
        if (entity.getTitle24() != null) {
            source.title24 = entity.getTitle24();
        }
        if (entity.get文書1() != null) {
            source.tsuchibun1 = entity.get文書1();
        }
        if (entity.get被保険者氏名() != null) {
            source.hihokenshaName = entity.get被保険者氏名();
        }
        RString 被保険者番号 = entity.get被保険者番号().getColumnValue();
        if (被保険者番号 != null && INT_10 <= 被保険者番号.length()) {
            source.hihoNo1 = 被保険者番号.substring(0, INT_1);
            source.hihoNo2 = 被保険者番号.substring(INT_1, INT_2);
            source.hihoNo3 = 被保険者番号.substring(INT_2, INT_3);
            source.hihoNo4 = 被保険者番号.substring(INT_3, INT_4);
            source.hihoNo5 = 被保険者番号.substring(INT_4, INT_5);
            source.hihoNo6 = 被保険者番号.substring(INT_5, INT_6);
            source.hihoNo7 = 被保険者番号.substring(INT_6, INT_7);
            source.hihoNo8 = 被保険者番号.substring(INT_7, INT_8);
            source.hihoNo9 = 被保険者番号.substring(INT_8, INT_9);
            source.hihoNo10 = 被保険者番号.substring(INT_9, INT_10);
        }
        source.bangoTitle = 口座番号;
        source.sihaYoYmd = getパターン12(entity.get支払予定日());
        source.tsuchibun2 = entity.get文書2();
        source.tsuchibun3 = entity.get文書3();
        source.tsuchibun4 = entity.get文書4();
        source.tsuchibun5 = entity.get文書5();
        source.tsuchibun6 = entity.get文書6();
        source.tsuchibun7 = entity.get文書7();

        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set事業高額合算支給不支給決定(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        RString 計算対象期間開始年月 = getパターン62(事業高額合算支給不支給決定.getKeisanKaishiYMD());
        RString 計算対象期間終了年月 = getパターン62(事業高額合算支給不支給決定.getKeisanShuryoYMD());
        source.taisyoStYm = 計算対象期間開始年月;
        source.taisyoEdYm = 計算対象期間開始年月.concat(波線).concat(計算対象期間終了年月);
        source.shinseiYmd = getパターン12(事業高額合算支給不支給決定.getShinseiYMD());
        source.ketteiYmd = getパターン12(事業高額合算支給不支給決定.getKetteiYMD());
        source.shiharaiGaku = get共通ポリシー金額1(事業高額合算支給不支給決定.getJikoFutanSogaku());
        source.shikyuGakuTitle = 支給額;
        source.shikyuGaku = get共通ポリシー金額1(事業高額合算支給不支給決定.getShikyugaku());
        if (事業高額合算支給不支給決定.getShikyuKubunCode() != null && RSTRING_1.equals(事業高額合算支給不支給決定.getShikyuKubunCode())) {
            source.kekka = 支給;
            source.riyu = 備考;
            source.riyu1 = 事業高額合算支給不支給決定.getBiko();
            source.riyu2 = 事業高額合算支給不支給決定.getBiko();
            source.riyu3 = 事業高額合算支給不支給決定.getBiko();
        }
        if (事業高額合算支給不支給決定.getShikyuKubunCode() != null && RSTRING_2.equals(事業高額合算支給不支給決定.getShikyuKubunCode())) {
            source.kekka = 不支給;
            source.riyu = 不支給の理由;
            source.riyu1 = 事業高額合算支給不支給決定.getFushikyuRiyu();
            source.riyu2 = 事業高額合算支給不支給決定.getFushikyuRiyu();
            source.riyu3 = 事業高額合算支給不支給決定.getFushikyuRiyu();
        }
        RString kyufuShurui = 事業高額合算支給不支給決定.getKyufuShurui();
        if (kyufuShurui != null && !kyufuShurui.isEmpty()) {
            this.set給付の種類(source, kyufuShurui);
        }
        if (RSTRING_1.equals(ワーク口座払区分) || RSTRING_1.equals(ワーク不支給区分)) {
            source.torikeshi1 = HOSHI_14;
        }
        if (RSTRING_1.equals(ワーク窓口払区分) || RSTRING_1.equals(ワーク不支給区分)) {
            source.torikeshi2 = HOSHI_14;
        }

        if (RSTRING_1.equals(ワーク窓口払区分)) {
            this.set窓口払である(source);
        }
        if (RSTRING_1.equals(ワーク口座払区分)) {
            this.set口座払である(source);
        }
        if (事業高額合算支給不支給決定.getShikyuSeiriNo() != null) {
            source.tsuchiNo = 事業高額合算支給不支給決定.getShikyuSeiriNo();
        }
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set給付の種類(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source, RString kyufuShurui) {
        if (kyufuShurui.length() <= INT_38) {
            source.kyuhuShu = kyufuShurui.substring(0, kyufuShurui.length());
        } else if (kyufuShurui.length() > INT_38 && kyufuShurui.length() <= INT_76) {
            source.kyuhuShu = kyufuShurui.substring(0, INT_38);
            source.kyuhuShu2 = kyufuShurui.substring(INT_38, kyufuShurui.length());
        } else if (kyufuShurui.length() > INT_76 && kyufuShurui.length() <= INT_114) {
            source.kyuhuShu = kyufuShurui.substring(0, INT_38);
            source.kyuhuShu2 = kyufuShurui.substring(INT_38, INT_76);
            source.kyuhuShu3 = kyufuShurui.substring(INT_76, kyufuShurui.length());

        } else {
            source.kyuhuShu = kyufuShurui.substring(0, INT_38);
            source.kyuhuShu2 = kyufuShurui.substring(INT_38, INT_76);
            source.kyuhuShu3 = kyufuShurui.substring(INT_76, INT_114);
        }
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set窓口払である(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        this.set持ち物(source);
        this.set支払場所(source);
        if (事業高額合算支給不支給決定.getShiharaiKaishiYMD() == null || 事業高額合算支給不支給決定.getShiharaiShuryoYMD() == null) {
            return source;
        }
        FlexibleDate shiharaiKaishiYMD = 事業高額合算支給不支給決定.getShiharaiKaishiYMD();
        FlexibleDate shiharaiShuryoYMD = 事業高額合算支給不支給決定.getShiharaiShuryoYMD();
        if (shiharaiKaishiYMD == null || shiharaiShuryoYMD == null) {
            return source;
        }
        if (!shiharaiKaishiYMD.isEmpty()) {
            RString 開始曜日 = new RString(shiharaiKaishiYMD.getDayOfWeek().getMiddleTerm());
            source.maStYmd = getパターン12(shiharaiKaishiYMD).concat(開始曜日).concat(波線);
        } else if (shiharaiKaishiYMD.isEmpty() && !shiharaiShuryoYMD.isEmpty()) {
            RString 終了曜日 = new RString(shiharaiShuryoYMD.getDayOfWeek().getMiddleTerm());
            source.maStYmd = 波線.concat(getパターン12(shiharaiShuryoYMD)).concat(終了曜日);
        }
        if (!shiharaiKaishiYMD.isEmpty() && !shiharaiShuryoYMD.isEmpty()) {
            RString 終了曜日 = new RString(shiharaiShuryoYMD.getDayOfWeek().getMiddleTerm());
            source.maEdYmd = getパターン12(shiharaiShuryoYMD).concat(終了曜日);
        }
        set支払期間(shiharaiKaishiYMD, shiharaiShuryoYMD, source);
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set支払期間(FlexibleDate shiharaiKaishiYMD,
            FlexibleDate shiharaiShuryoYMD, GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        RString kaishiTime = 事業高額合算支給不支給決定.getShiharaiKaishiTime();
        RString shuryoTime = 事業高額合算支給不支給決定.getShiharaiShuryoTime();
        if ((!shiharaiKaishiYMD.isEmpty() || !shiharaiShuryoYMD.isEmpty())
                && kaishiTime != null) {
            this.set支払期間時間(source, kaishiTime);

        }
        if ((!shiharaiKaishiYMD.isEmpty() || !shiharaiShuryoYMD.isEmpty()) && kaishiTime != null) {
            this.set支払期間時間(source, kaishiTime);

        }

        if ((!shiharaiKaishiYMD.isEmpty() || !shiharaiShuryoYMD.isEmpty())
                && ((kaishiTime != null && !kaishiTime.isEmpty())
                || (shuryoTime != null && !shuryoTime.isEmpty()))) {
            source.kara2 = 波線;
        }
        if ((!shiharaiKaishiYMD.isEmpty() || !shiharaiShuryoYMD.isEmpty()) && shuryoTime != null) {
            this.set支払期間時間(source, shuryoTime);
        }
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set支払場所(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        if (事業高額合算支給不支給決定.getShiharaiBasho() != null) {

            RString shiharaiBasho = 事業高額合算支給不支給決定.getShiharaiBasho();
            if (shiharaiBasho == null || shiharaiBasho.isEmpty()) {
                return source;
            }
            if (shiharaiBasho.length() <= INT_16) {
                source.maBasho1 = shiharaiBasho.substring(0, shiharaiBasho.length());
            } else if (shiharaiBasho.length() > INT_16 && shiharaiBasho.length() <= INT_32) {
                source.maBasho1 = shiharaiBasho.substring(0, INT_16);
                source.maBasho2 = shiharaiBasho.substring(INT_16, shiharaiBasho.length());
            } else if (shiharaiBasho.length() > INT_32 && shiharaiBasho.length() <= INT_48) {
                source.maBasho1 = shiharaiBasho.substring(0, INT_16);
                source.maBasho2 = shiharaiBasho.substring(INT_16, INT_32);
                source.maBasho3 = shiharaiBasho.substring(INT_32, shiharaiBasho.length());
            } else if (shiharaiBasho.length() > INT_48 && shiharaiBasho.length() <= INT_64) {
                source.maBasho1 = shiharaiBasho.substring(0, INT_16);
                source.maBasho2 = shiharaiBasho.substring(INT_16, INT_32);
                source.maBasho3 = shiharaiBasho.substring(INT_32, INT_48);
                source.maBasho4 = shiharaiBasho.substring(INT_48, shiharaiBasho.length());
            } else {
                source.maBasho1 = shiharaiBasho.substring(0, INT_16);
                source.maBasho2 = shiharaiBasho.substring(INT_16, INT_32);
                source.maBasho3 = shiharaiBasho.substring(INT_32, INT_48);
                source.maBasho4 = shiharaiBasho.substring(INT_48, INT_64);
            }
        }
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set持ち物(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        for (ChohyoSeigyoHanyo キー : 帳票制御汎用キー) {
            if (持ち物内容文言１.equals(キー.get項目名())) {
                source.mochimono1 = キー.get設定値();
                break;
            } else if (持ち物内容文言2.equals(キー.get項目名())) {
                source.mochimono2 = キー.get設定値();
                break;
            } else if (持ち物内容文言3.equals(キー.get項目名())) {
                source.mochimono3 = キー.get設定値();
                break;
            }
        }
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set支払期間時間(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source, RString time) {
        if (time.isEmpty()) {
            return null;
        }
        RString hh = time.substring(0, INT_2);
        RString mm = time.substring(INT_2, INT_4);
        if (time.equals(事業高額合算支給不支給決定.getShiharaiKaishiTime())) {
            if (hh.compareTo(RSTRING_12) < 0) {
                source.maStJikan = 午前.concat(hh).concat(時);
            } else {
                source.maStJikan = 午後.concat(hh).concat(時);
            }
            if (!RSTRING_00.equals(mm)) {
                source.maStJikan = source.maStJikan.concat(mm).concat(分);
            }
        }
        if (time.equals(事業高額合算支給不支給決定.getShiharaiShuryoTime())) {
            if (hh.compareTo(RSTRING_12) < 0) {
                source.maEdJikan = 午前.concat(hh).concat(時);
            } else {
                source.maEdJikan = 午後.concat(hh).concat(時);
            }
            if (!RSTRING_00.equals(mm)) {
                source.maEdJikan = source.maEdJikan.concat(mm).concat(分);
            }
        }

        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set口座払である(
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        if (entity.get口座情報() == null) {
            return source;
        }
        source.bankName = entity.get口座情報().get金融機関().get金融機関名称();
        if (!郵貯銀行.equals(entity.get口座情報().get金融機関コード().value())) {
            source.bankShiten = entity.get口座情報().get支店().get支店名称();
            source.shumokuTitle = 口座種別;
            source.kouzaShu = new RString(entity.get口座情報().get預金種別().toString());
        } else {

            source.shumokuTitle = 店番;
            source.kouzaShu = entity.get口座情報().get支店コード().value();
            for (ChohyoSeigyoHanyo キー : 帳票制御汎用キー) {
                if (ゆうちょ銀行店名表示.equals(キー.get項目名())) {
                    this.set金融機関支店名(キー, source);
                }

            }

        }
        source.kouzaNo1 = entity.get口座情報().get口座番号();
        source.kouzaMeigi = entity.get口座情報().get口座名義人().value();
        return source;
    }

    private GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource set金融機関支店名(ChohyoSeigyoHanyo キー,
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        if (RSTRING_1.equals(キー.get設定値())) {
            source.bankShiten = entity.get口座情報().get支店().get支店名称();
        }
        return source;
    }

    private static RString getパターン12(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString getパターン62(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.getYearMonth().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString get共通ポリシー金額1(Decimal 金額) {
        if (null == 金額) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }
}
