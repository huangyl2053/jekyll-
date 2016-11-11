/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shikakushogohyo;

import jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha.KyuSochiNyushoshaTokureiCode;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin.ShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.shikakushogohyo.ShikakuShogohyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護給付費資格照合表IBuilderクラスです。
 *
 * @reamsid_L DBC-2890-030 wangxingpeng
 *
 */
public class ShikakuShogohyoEditor implements IShikakuShogohyoEditor {

    private final ShikakuShogohyoInEntity target;

    private static final RString SAKUSEI = new RString("作成");
    private IYokaigoJotaiKubun 要介護状態区分;
    private static final RString 合計件数 = new RString("合計件数");
    private static final RString 件 = new RString("件");
    private static final RString 期間 = new RString("～");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final int NUM_2 = 2;
    private static final int NUM_100 = 100;
    private final boolean flag;
    private final int 合計;
    private final YMDHMS システム日時;
    private final int 連番;
    private final DonyuKeitaiCode 導入形態コード;

    /**
     * コンストラクタです。
     *
     * @param flag boolean
     * @param 合計 int
     * @param target ShikakuShogohyoInEntity
     * @param システム日時 YMDHMS
     * @param 連番 int
     * @param 導入形態コード DonyuKeitaiCode
     */
    public ShikakuShogohyoEditor(boolean flag,
            int 合計,
            ShikakuShogohyoInEntity target,
            YMDHMS システム日時,
            int 連番,
            DonyuKeitaiCode 導入形態コード) {
        this.flag = flag;
        this.合計 = 合計;
        this.target = target;
        this.システム日時 = システム日時;
        this.連番 = 連番;
        this.導入形態コード = 導入形態コード;

    }

    @Override
    public ShikakuShogohyoSource edit(ShikakuShogohyoSource source) {

        if (システム日時 != null) {
            source.printTimeStamp = パターン12(システム日時);
        }
        if (target.get資格照合表一時() != null) {
            editor編集1(source);
            editor編集2(source);
            if (target.get資格照合表一時().getShinsaYM() != null) {
                source.shinsaYM = パターン56(target.get資格照合表一時().getShinsaYM());
            }
            source.hokenshaNo = target.get資格照合表一時().getHokenshaNo().getColumnValue();
            source.hokenshaName = target.get資格照合表一時().getHokenshaName();
            source.listUpper_1 = new RString(連番);

            if (target.get資格照合表一時().getServiceTeikyoYM() != null) {
                source.listUpper_4 = パターン54(target.get資格照合表一時().getServiceTeikyoYM());
            }
            source.listUpper_5 = target.get資格照合表一時().getServiceShuruiCode().getColumnValue();
            source.listUpper_6 = target.get資格照合表一時().getShubetsu();
            source.listUpper_7 = target.get資格照合表一時().getJigyoshoNo().getColumnValue();
            if (target.get資格照合表一時().getServiceTeikyoYM() != null && target.get資格照合表一時().getYokaigoKubunCode() != null) {
                要介護状態区分 = YokaigoJotaiKubunSupport.toValue(target.get資格照合表一時().getServiceTeikyoYM(),
                        target.get資格照合表一時().getYokaigoKubunCode().getColumnValue());
                source.listUpper_8 = 要介護状態区分.getName();
            }
            if (target.get資格照合表一時().getNinteiYukoKikanKaishiYMD() != null) {
                source.listUpper_9 = パターン4(target.get資格照合表一時().getNinteiYukoKikanKaishiYMD());
            }

            if (target.get資格照合表一時().getNinteiYukoKikanShuryoYMD() != null) {
                source.listUpper_11 = パターン4(target.get資格照合表一時().getNinteiYukoKikanShuryoYMD());
            }
            if (target.get資格照合表一時().getShikyuGendoGaku() != null) {
                source.listUpper_12 = decimal_to_string(target.get資格照合表一時().getShikyuGendoGaku());
            }
            source.listUpper_13 = target.get資格照合表一時().getKyotakuServicePlanSakuseiKubunCode().getColumnValue();

            source.listLower_2 = target.get資格照合表一時().getServiceShuruiMei();
            source.listLower_3 = target.get資格照合表一時().getJigyoshoMei();

            if (target.get資格照合表一時().getKyusochiTokureiCode() != null) {
                source.listLower_4 = KyuSochiNyushoshaTokureiCode.toValue(target.get資格照合表一時().getKyusochiTokureiCode()).get名称();
            }
            if (target.get資格照合表一時().getGendoGakuTekiyoKikanKaishiYMD() != null) {
                source.listLower_5 = パターン4(target.get資格照合表一時().getGendoGakuTekiyoKikanKaishiYMD());
            }

            if (target.get資格照合表一時().getGendoGakuTekiyoKikanShuryoYMD() != null) {
                source.listLower_7 = パターン4(target.get資格照合表一時().getGendoGakuTekiyoKikanShuryoYMD());
            }
            source.listLower_8 = target.get資格照合表一時().getShienJigyoshoNo().getColumnValue();
        }
        editor集計(source);
        if (target.get被保険者一時() != null) {
            source.listLower_1 = target.get被保険者一時().get宛名名称();
            source.shikibetsuCode = target.get被保険者一時().get識別コード();
            source.listUpper_2 = target.get被保険者一時().get登録被保険者番号().getColumnValue();
            source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                    source.listUpper_2);

            if (導入形態コード.is広域()) {
                source.listUpper_3 = target.get被保険者一時().get証記載保険者番号().getColumnValue();
            }
        }

        return source;

    }

    private ShikakuShogohyoSource editor集計(ShikakuShogohyoSource source) {
        if (flag) {
            source.gokeiKensuTitle = 合計件数;
            source.gokeiKensu = decimal_to_string(new Decimal(合計)).concat(件);
        }
        return source;
    }

    private ShikakuShogohyoSource editor編集1(ShikakuShogohyoSource source) {
        if (target.get資格照合表一時().getGendoGakuTekiyoKikanKaishiYMD() != null
                && target.get資格照合表一時().getGendoGakuTekiyoKikanShuryoYMD() != null
                && target.get資格照合表一時().getGendoGakuTekiyoKikanKaishiYMD().isEmpty()
                && target.get資格照合表一時().getGendoGakuTekiyoKikanShuryoYMD().isEmpty()) {
            source.listLower_6 = null;
        } else {
            source.listLower_6 = 期間;
        }
        if (target.get資格照合表一時().getNinteiYukoKikanShuryoYMD() != null
                && target.get資格照合表一時().getNinteiYukoKikanKaishiYMD() != null
                && target.get資格照合表一時().getNinteiYukoKikanKaishiYMD().isEmpty()
                && target.get資格照合表一時().getNinteiYukoKikanShuryoYMD().isEmpty()) {
            source.listUpper_10 = null;
        } else {
            source.listUpper_10 = 期間;
        }
        if (target.get資格照合表一時().getGetsuGakuShokujiFutanGaku() != null) {
            source.listUpper_14 = decimal_to_string(target.get資格照合表一時().getGetsuGakuShokujiFutanGaku());
        }
        if (target.get資格照合表一時().getShokuhiFutanGendoGaku() != null) {
            source.listUpper_15 = decimal_to_string(target.get資格照合表一時().getShokuhiFutanGendoGaku());
        }
        if (target.get資格照合表一時().getKyojuhiFutanGendoGaku2() != null) {
            source.listUpper_16 = decimal_to_string(target.get資格照合表一時().getKyojuhiFutanGendoGaku2());
        }
        if (target.get資格照合表一時().getKyojuhiFutanGendoGaku4() != null) {
            source.listUpper_17 = decimal_to_string(target.get資格照合表一時().getKyojuhiFutanGendoGaku4());
        }
        if (target.get資格照合表一時().getTanisuTanka() != null) {
            source.listUpper_18 = new RString(target.get資格照合表一時().getTanisuTanka().divide(NUM_100).roundHalfUpTo(NUM_2).toString());
        }
        if (target.get資格照合表一時().getHokenKyufuRitsu().getColumnValue() != null) {
            source.listUpper_19 = decimal_to_string(target.get資格照合表一時().getHokenKyufuRitsu().getColumnValue());
        }
        if (target.get資格照合表一時().getKohi2KyufuRitsu() != null) {
            source.listUpper_20 = decimal_to_string(target.get資格照合表一時().getKohi2KyufuRitsu().getColumnValue());
        }

        source.listUpper_21 = new RString(target.get資格照合表一時().getServiceNissuKaisu());

        if (target.get資格照合表一時().getServiceTanisu() != null) {
            source.listUpper_22 = decimal_to_string(target.get資格照合表一時().getServiceTanisu());
        }
        if (target.get資格照合表一時().getRiyoshaFutanGaku() != null) {
            source.listUpper_23 = decimal_to_string(target.get資格照合表一時().getRiyoshaFutanGaku());
        }

        return source;
    }

    private ShikakuShogohyoSource editor編集2(ShikakuShogohyoSource source) {
        if (target.get資格照合表一時().getGetsuGakuShokujiFutanGaku() != null) {
            source.listLower_9 = decimal_to_string(target.get資格照合表一時().getNichiGakuShokujiFutanGaku());
        }
        if (target.get資格照合表一時().getKyojuhiFutanGendoGaku1() != null) {
            source.listLower_10 = decimal_to_string(target.get資格照合表一時().getKyojuhiFutanGendoGaku1());
        }
        if (target.get資格照合表一時().getKyojuhiFutanGendoGaku3() != null) {
            source.listLower_11 = decimal_to_string(target.get資格照合表一時().getKyojuhiFutanGendoGaku3());
        }
        if (target.get資格照合表一時().getKyojuhiFutanGendoGaku5() != null) {
            source.listLower_12 = decimal_to_string(target.get資格照合表一時().getKyojuhiFutanGendoGaku5());
        }
        if (target.get資格照合表一時().getKohi1KyufuRitsu() != null) {
            source.listLower_13 = decimal_to_string(target.get資格照合表一時().getKohi1KyufuRitsu().getColumnValue());
        }
        if (target.get資格照合表一時().getKohi3KyufuRitsu() != null) {
            source.listLower_14 = decimal_to_string(target.get資格照合表一時().getKohi3KyufuRitsu().getColumnValue());
        }
        if (target.get資格照合表一時().getTokuteiNyushoshaKaigoServiceGaku() != null) {
            source.listLower_15 = decimal_to_string(target.get資格照合表一時().getTokuteiNyushoshaKaigoServiceGaku());
        }
        if (target.get資格照合表一時().getShokujiFutanGaku() != null) {
            source.listLower_16 = decimal_to_string(target.get資格照合表一時().getShokujiFutanGaku());
        }
        return source;
    }

    /**
     * 数値からstringに転換する。
     *
     * @param number 数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString パターン12(YMDHMS 作成日時) {
        if (null == 作成日時) {
            return RString.EMPTY;
        } else {
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getRDateTime().getTime().
                    toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
            return 作成日.concat(RString.HALF_SPACE).concat(作成時);
        }
    }

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString パターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString パターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
