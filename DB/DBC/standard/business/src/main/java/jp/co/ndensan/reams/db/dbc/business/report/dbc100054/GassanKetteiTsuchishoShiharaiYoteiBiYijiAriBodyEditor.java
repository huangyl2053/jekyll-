/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100054;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchisho;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanketteitsuchishoshiharaiyoteibiyijiari.GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBCMN63004_高額合算支給決定通知書（一括）BodyEditor
 *
 * @reamsid_L DBC-2300-050 jiangxiaolong
 */
public class GassanKetteiTsuchishoShiharaiYoteiBiYijiAriBodyEditor
        implements IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriEditor {

    private final KogakugassanShikyuKetteitsuchisho entity;
    private final NinshoshaSource ninshoshaSource;
    private final List<ChohyoSeigyoHanyo> 帳票制御汎用キー;
    private static final RString アステリスク = new RString("**************");
    private static final RString 接続符 = new RString("～");
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 支給額 = new RString("支給額");
    private static final RString 備考 = new RString("備考");
    private static final RString 不支給の理由 = new RString("不支給の理由");
    private static final RString 区分_00 = new RString("00");
    private static final RString 区分_12 = new RString("12");
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
    private RString ワーク窓口払区分 = 区分_0;
    private RString ワーク口座払区分 = 区分_0;
    private RString ワーク不支給区分 = 区分_0;
    private static final RString 店番 = new RString("店番");
    private static final RString 口座種別 = new RString("口座種別");
    private static final RString 口座番号 = new RString("口座番号");
    private static final RString ゆうちょ銀行店名表示 = new RString("ゆうちょ銀行店名表示");
    private static final RString 持ち物内容文言１ = new RString("持ち物内容文言１");
    private static final RString 持ち物内容文言2 = new RString("持ち物内容文言２");
    private static final RString 持ち物内容文言3 = new RString("持ち物内容文言３");
    private static final RString 支払予定日印字有無 = new RString("支払予定日印字有無");

    /**
     * コンストラクタです
     *
     * @param entity KogakugassanShikyuKetteitsuchisho
     * @param ninshoshaSource NinshoshaSource
     * @param 帳票制御汎用キー List<ChohyoSeigyoHanyo>
     */
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiAriBodyEditor(
            KogakugassanShikyuKetteitsuchisho entity, NinshoshaSource ninshoshaSource, List<ChohyoSeigyoHanyo> 帳票制御汎用キー) {
        this.entity = entity;
        this.ninshoshaSource = ninshoshaSource;
        this.帳票制御汎用キー = 帳票制御汎用キー;
    }

    @Override
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource edit(
            GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        editSource(source);
        source.hihokenshaNo = getColumnValue(entity.get被保険者番号());
        source.shikibetuCode = entity.get識別コード();
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), source.hihokenshaNo);
        return source;
    }

    private void editSource(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        ワーク窓口払区分 = 区分_0;
        ワーク口座払区分 = 区分_0;
        ワーク不支給区分 = 区分_0;
        this.edit送付物宛先(source);
        this.edit文書(source);
        this.edit認証者(source);
        this.edit通知書(source);
        if (entity != null) {
            if (entity.get支給額() != null && entity.get支給区分コード() != null) {
                支払状態判定();
            }
            this.set高額合算支給不支給決定(source);

        }

    }

    private void edit送付物宛先(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        source.yubinNo = entity.get郵便番号();
        source.gyoseiku = entity.get行政区();
        source.jushoText = entity.get住所Text();
        source.jusho1 = entity.get住所1();
        source.jusho2 = entity.get住所2();
        source.jusho3 = entity.get住所3();
        source.katagakiText = entity.get方書Text();
        source.katagaki1 = entity.get方書1();
        source.katagaki2 = entity.get方書2();
        source.katagakiSmall1 = entity.get方書Small1();
        source.katagakiSmall2 = entity.get方書Small2();
        source.dainoKubunMei = entity.get代納人区分();
        source.shimeiText = entity.get氏名Text();
        source.shimei1 = entity.get氏名1();
        source.shimei2 = entity.get氏名2();
        source.shimeiSmall1 = entity.get氏名Small1();
        source.shimeiSmall2 = entity.get氏名Small2();
        source.samabunShimeiText = entity.get氏名samabunText();
        source.samabunShimei1 = entity.get氏名samabun1();
        source.samabunShimei2 = entity.get氏名samabun2();
        source.samabunShimeiSmall1 = entity.get氏名samabunSmall1();
        source.samabunShimeiSmall2 = entity.get氏名samabunSmall2();
        source.meishoFuyo1 = entity.get名称付与1();
        source.meishoFuyo2 = entity.get名称付与2();
        source.samaBun1 = entity.get様文1();
        source.samaBun2 = entity.get様文2();
        source.kakkoLeft1 = entity.get括弧Left1();
        source.kakkoLeft2 = entity.get括弧Left2();
        source.kakkoRight1 = entity.get括弧Right1();
        source.kakkoRight2 = entity.get括弧Right2();
        source.customerBarCode = entity.getカスタマバーコード();
    }

    private GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource edit文書(
            GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        if (entity.get文書番号() != null) {
            source.bunshoNo = entity.get文書番号();
        }
        return source;
    }

    private void edit認証者(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {

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
    }

    private void edit通知書(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        source.title = entity.getタイトル();
        source.title21 = entity.getタイトル21();
        source.title221 = entity.getタイトル221();
        source.title222 = entity.getタイトル222();
        source.title231 = entity.getタイトル231();
        source.title232 = entity.getタイトル232();
        source.title24 = entity.getタイトル24();
        source.tsuchibun1 = entity.get文書1();
        source.hihokenshaName = entity.get被保険者氏名();
        if (entity.get被保険者番号() != null) {
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
        }
        source.bangoTitle = 口座番号;
        if (is支払予定日印字有無()) {
            source.sihaYoYmd = getパターン12(entity.get支払予定日());
        }
        source.tsuchibun2 = entity.get文書2();
        source.tsuchibun3 = entity.get文書3();
        source.tsuchibun4 = entity.get文書4();
        source.tsuchibun5 = entity.get文書5();
        source.tsuchibun6 = entity.get文書6();
        source.tsuchibun7 = entity.get文書7();
        source.tsuban = new RString(entity.get通番());

    }

    private void 支払状態判定() {
        if (0 <= entity.get支給額().compareTo(Decimal.ZERO) && (区分_1.equals(entity.get支給区分コード()))) {
            if (区分_1.equals(entity.get支給方法区分())) {
                this.ワーク窓口払区分 = 区分_1;
            } else if (区分_2.equals(entity.get支給方法区分())) {
                this.ワーク口座払区分 = 区分_1;
            }
        } else if (entity.get支給額().compareTo(Decimal.ZERO) < 0 && 区分_2.equals(entity.get支給区分コード())) {
            this.ワーク不支給区分 = 区分_1;
        }
    }

    private void set高額合算支給不支給決定(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        RString 計算対象期間開始年月 = getパターン62(entity.get対象計算期間開始年月日());
        RString 計算対象期間終了年月 = getパターン62(entity.get対象計算期間終了年月日());
        source.taisyoStYm = 計算対象期間開始年月;
        source.taisyoEdYm = 計算対象期間終了年月;
        source.shinseiYmd = getパターン12(entity.get申請年月日());
        source.ketteiYmd = getパターン12(entity.get決定年月日());
        source.shiharaiGaku = get共通ポリシー金額1(entity.get計算対象期間中の自己負担額合計額());
        source.shikyuGakuTitle = 支給額;
        source.shikyuGaku = get共通ポリシー金額1(entity.get支給額());
        if (entity.get支給区分コード() != null && 区分_1.equals(entity.get支給区分コード())) {
            source.kekka = 支給;
            source.riyu = 備考;
            this.set理由(source, entity.get備考());
        }
        if (entity.get支給区分コード() != null && 区分_2.equals(entity.get支給区分コード())) {
            source.kekka = 不支給;
            source.riyu = 不支給の理由;
            this.set理由(source, entity.get不支給の理由());
        }
        RString 給付の種類 = entity.get給付の種類();
        if (給付の種類 != null && !給付の種類.isEmpty()) {
            this.set給付の種類(source, 給付の種類);
        }
        if (区分_1.equals(ワーク口座払区分) || 区分_1.equals(ワーク不支給区分)) {
            source.torikeshi1 = アステリスク;
        }
        if (区分_1.equals(ワーク窓口払区分) || 区分_1.equals(ワーク不支給区分)) {
            source.torikeshi2 = アステリスク;
        }

        if (区分_1.equals(ワーク窓口払区分)) {
            this.set窓口払である(source);
        }
        if (区分_1.equals(ワーク口座払区分)) {
            this.set口座払である(source);
        }
        if (entity.get通知書番号() != null) {
            source.tsuchi_no = entity.get通知書番号();
        }
    }

    private void set理由(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source, RString riyu) {
        if (riyu != null && !riyu.isEmpty()) {
            if (riyu.length() <= INT_38) {
                source.riyu1 = riyu.substring(0, riyu.length());
            } else if (riyu.length() > INT_38 && riyu.length() <= INT_76) {
                source.riyu1 = riyu.substring(0, INT_38);
                source.riyu2 = riyu.substring(INT_38, riyu.length());
            } else if (riyu.length() > INT_76 && riyu.length() <= INT_114) {
                source.riyu1 = riyu.substring(0, INT_38);
                source.riyu2 = riyu.substring(INT_38, INT_76);
                source.riyu3 = riyu.substring(INT_76, riyu.length());

            } else {
                source.riyu1 = riyu.substring(0, INT_38);
                source.riyu2 = riyu.substring(INT_38, INT_76);
                source.riyu3 = riyu.substring(INT_76, INT_114);
            }
        }
    }

    private void set給付の種類(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source, RString kyuhuShu) {
        if (kyuhuShu.length() <= INT_38) {
            source.kyuhuShu = kyuhuShu.substring(0, kyuhuShu.length());
        } else if (kyuhuShu.length() > INT_38 && kyuhuShu.length() <= INT_76) {
            source.kyuhuShu = kyuhuShu.substring(0, INT_38);
            source.kyuhuShu2 = kyuhuShu.substring(INT_38, kyuhuShu.length());
        }
    }

    private void set窓口払である(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        this.set持ち物(source);
        this.set支払場所(source);
        FlexibleDate shiharaiKaishiYMD = entity.get支払期間開始年月日();
        FlexibleDate shiharaiShuryoYMD = entity.get支払期間終了年月日();

        if (!is空白(shiharaiKaishiYMD)) {
            RString 開始曜日 = new RString(shiharaiKaishiYMD.getDayOfWeek().getInFullParentheses());
            source.maStYmd = getパターン12(shiharaiKaishiYMD).concat(開始曜日).concat(接続符);
        } else if (!is空白(shiharaiShuryoYMD)) {
            RString 終了曜日 = new RString(shiharaiShuryoYMD.getDayOfWeek().getInFullParentheses());
            source.maStYmd = 接続符.concat(getパターン12(shiharaiShuryoYMD)).concat(終了曜日);
        }
        if (!is空白(shiharaiKaishiYMD) && !is空白(shiharaiShuryoYMD)) {
            RString 終了曜日 = new RString(shiharaiShuryoYMD.getDayOfWeek().getInFullParentheses());
            source.maEdYmd = getパターン12(shiharaiShuryoYMD).concat(終了曜日);
        }
        set支払期間(shiharaiKaishiYMD, shiharaiShuryoYMD, source);
    }

    private void set支払期間(FlexibleDate shiharaiKaishiYMD,
            FlexibleDate shiharaiShuryoYMD, GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        RString kaishiTime = entity.get支払期間開始時間();
        RString shuryoTime = entity.get支払期間終了時間();
        if ((!is空白(shiharaiKaishiYMD) || !is空白(shiharaiShuryoYMD))
                && kaishiTime != null) {
            this.set支払期間時間(source, kaishiTime);

        }
        if ((!is空白(shiharaiKaishiYMD) || !is空白(shiharaiShuryoYMD))
                && ((kaishiTime != null && !kaishiTime.isEmpty())
                || (shuryoTime != null && !shuryoTime.isEmpty()))) {
            source.kara2 = 接続符;
        }
        if ((!is空白(shiharaiKaishiYMD) || !is空白(shiharaiShuryoYMD)) && shuryoTime != null) {
            this.set支払期間時間(source, shuryoTime);
        }
    }

    private void set支払場所(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        if (entity.get支払場所() != null) {

            RString shiharaiBasho = entity.get支払場所();
            if (shiharaiBasho == null || shiharaiBasho.isEmpty()) {
                return;
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
    }

    private void set持ち物(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        for (ChohyoSeigyoHanyo キー : 帳票制御汎用キー) {
            if (null == キー) {
                continue;
            }
            if (持ち物内容文言１.equals(キー.get項目名())) {
                source.mochimono1 = キー.get設定値();
            } else if (持ち物内容文言2.equals(キー.get項目名())) {
                source.mochimono2 = キー.get設定値();
            } else if (持ち物内容文言3.equals(キー.get項目名())) {
                source.mochimono3 = キー.get設定値();
            }
        }
    }

    private boolean is支払予定日印字有無() {
        for (ChohyoSeigyoHanyo キー : 帳票制御汎用キー) {
            if (null == キー) {
                continue;
            }
            if (支払予定日印字有無.equals(キー.get項目名()) && 区分_1.equals(キー.get設定値())) {
                return true;
            }

        }
        return false;
    }

    private void set支払期間時間(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source, RString time) {
        if (time.isEmpty()) {
            return;
        }
        RString hh = time.substring(0, INT_2);
        RString mm = time.substring(INT_2, INT_4);
        if (time.equals(entity.get支払期間開始時間())) {
            if (hh.compareTo(区分_12) < 0) {
                source.maStJikan = 午前.concat(hh).concat(時);
            } else {
                source.maStJikan = 午後.concat(hh).concat(時);
            }
            if (!区分_00.equals(mm)) {
                source.maStJikan = source.maStJikan.concat(mm).concat(分);
            }
        }
        if (time.equals(entity.get支払期間終了時間())) {
            if (hh.compareTo(区分_12) < 0) {
                source.maEdJikan = 午前.concat(hh).concat(時);
            } else {
                source.maEdJikan = 午後.concat(hh).concat(時);
            }
            if (!区分_00.equals(mm)) {
                source.maEdJikan = source.maEdJikan.concat(mm).concat(分);
            }
        }
    }

    private void set口座払である(GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        if (entity.get金融機関名称() != null) {
            source.bankName = entity.get金融機関名称().get金融機関名称();
        }
        if (entity.get金融機関コード() != null && !郵貯銀行.equals(getColumnValue(entity.get金融機関コード()))) {
            if (entity.get支店名称() != null) {
                source.bankShiten = entity.get支店名称().get支店名称();
            }
            source.shumokuTitle = 口座種別;
            if (entity.get預金種別() != null) {
                source.kouzaShu = entity.get預金種別().get預金種別名称();
            }
        } else {

            source.shumokuTitle = 店番;
            if (entity.get支店コード() != null) {
                source.kouzaShu = getColumnValue(entity.get支店コード());
            }
            for (ChohyoSeigyoHanyo キー : 帳票制御汎用キー) {
                if (null == キー) {
                    continue;
                }
                if (ゆうちょ銀行店名表示.equals(キー.get項目名())) {
                    this.set金融機関支店名(キー, source);
                }

            }

        }
        source.kouzaNo1 = entity.get口座番号();
        if (entity.get口座名義人() != null) {
            source.kouzaMeigi = getColumnValue(entity.get口座名義人());
        }
    }

    private void set金融機関支店名(ChohyoSeigyoHanyo キー, GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource source) {
        if (区分_1.equals(キー.get設定値()) && entity.get支店名称() != null) {
            source.bankShiten = entity.get支店名称().get支店名称();
        }
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

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private boolean is空白(FlexibleDate entity) {
        if (null == entity || entity.isEmpty()) {
            return true;
        }
        return false;
    }
}
