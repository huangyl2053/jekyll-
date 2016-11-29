/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.riyojokyoichiran;

import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_DataKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_RiyoJissekiKubun;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyoichiran.RiyoJokyoIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200004_利用状況一覧表のEditorです。
 *
 * @reamsid_L DBC-3500-040 lizhuoxuan
 *
 */
public class RiyoJokyoIchiranEditor implements IRiyoJokyoIchiranEditor {

    private final RiyoJokyoIchiranEntity entity;
    private static final RString KANA = new RString("：");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_1 = new RString("1");
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int SIX = 6;
    private static final int 文字_120 = 120;
    private static final RString 数値 = new RString("0000000000");

    /**
     * インスタンスを生成します。
     *
     * @param entity 利用状況一覧表のEntity
     */
    protected RiyoJokyoIchiranEditor(RiyoJokyoIchiranEntity entity) {
        this.entity = entity;
    }

    @Override
    public RiyoJokyoIchiranReportSource edit(RiyoJokyoIchiranReportSource source) {
        return editSource(source);
    }

    private RiyoJokyoIchiranReportSource editSource(RiyoJokyoIchiranReportSource source) {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        source.printTimeStamp = systemDateTime.toRString();
        source.hokensahNo = entity.get保険者番号();
        source.hokenshaName = entity.get保険者名();
        if (!RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getShoriShichosonCode())) {
            RStringBuilder iryoKikanCodeBulider = new RStringBuilder();
            iryoKikanCodeBulider.append(entity.get帳票出力対象データリスト().getShoriShichosonCode());
            iryoKikanCodeBulider.append(KANA);
            iryoKikanCodeBulider.append(entity.get帳票出力対象データリスト().getShoriShichosonName());
            source.kyuShichoson = iryoKikanCodeBulider.toRString();
        } else if (RString.isNullOrEmpty(entity.get旧市町村コード()) || new RString("000000").equals(entity.get旧市町村コード())) {
            source.kyuShichoson = RString.EMPTY;
        } else if (!RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getKyuShichosonCode())) {
            RStringBuilder stringBuilder = new RStringBuilder();
            stringBuilder.append(entity.get旧市町村コード());
            stringBuilder.append(KANA);
            stringBuilder.append(entity.get旧市町村名());
            source.kyuShichoson = stringBuilder.toRString();
        }
        source.shutsuryokujun1 = entity.get並び順().get(0);
        source.shutsuryokujun2 = entity.get並び順().get(1);
        source.shutsuryokujun3 = entity.get並び順().get(2);
        source.shutsuryokujun4 = entity.get並び順().get(THREE);
        source.shutsuryokujun5 = entity.get並び順().get(FOUR);
        source.kaiPege1 = entity.get改頁().get(0);
        source.kaiPege2 = entity.get改頁().get(1);
        source.kaiPege3 = entity.get改頁().get(2);
        source.kaiPege4 = entity.get改頁().get(THREE);
        source.kaiPege5 = entity.get改頁().get(FOUR);
        source.list1Upper_1 = entity.get帳票出力対象データリスト().getHihokenshaNo();
        if (文字_120 < entity.get帳票出力対象データリスト().getShimeiKana().length()) {
            source.list1Upper_2 = entity.get帳票出力対象データリスト().getShimeiKana().substring(0, 文字_120);
        } else {
            source.list1Upper_2 = entity.get帳票出力対象データリスト().getShimeiKana();
        }
        source.list1Upper_3 = RiyojokyoTokeihyo_DataKubun.toValue(entity.get帳票出力対象データリスト().getDataKubun()).get名称();
        if (区分_2.equals(entity.get帳票出力対象データリスト().getRiyoJissekiFlag())) {
            source.list1Upper_4 = RiyojokyoTokeihyo_RiyoJissekiKubun.toValue(entity.get帳票出力対象データリスト().getRiyoJissekiFlag()).get名称();
        } else {
            source.list1Upper_4 = RString.EMPTY;
        }
        source.list1Lower_1 = entity.get帳票出力対象データリスト().getShikibetsuCode();
        source.list1Lower_2 = entity.get帳票出力対象データリスト().getShimei();
        editSource1(source);
        editSource2(source);
        editSource3(source);
        return source;
    }

    private RiyoJokyoIchiranReportSource editSource1(RiyoJokyoIchiranReportSource source) {
        RStringBuilder iraiDateTime = new RStringBuilder();
        if (区分_2.equals(entity.get帳票出力対象データリスト().getDataKubun())
                && 区分_2.equals(entity.get帳票出力対象データリスト().getServiceKubun())
                && !RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getServiceTeikyoYM())) {
            iraiDateTime.append(new RDate(entity.get帳票出力対象データリスト().getServiceTeikyoYM().toString()).wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).
                    fillType(FillType.BLANK).toDateString());
            source.list1Lower_3 = iraiDateTime.toRString();
        } else {
            source.list1Lower_3 = RString.EMPTY;
        }
        if (区分_1.equals(entity.get帳票出力対象データリスト().getDataKubun())
                && !数値.equals(entity.get帳票出力対象データリスト().getKyotakuServiceJigyoshoNo())) {
            source.list1Lower_4 = entity.get帳票出力対象データリスト().getKyotakuServiceJigyoshoNo();
        } else if (区分_2.equals(entity.get帳票出力対象データリスト().getDataKubun())
                && !数値.equals(entity.get帳票出力対象データリスト().getJigyoshoNo())) {
            source.list1Lower_4 = entity.get帳票出力対象データリスト().getJigyoshoNo();
        } else {
            source.list1Lower_4 = RString.EMPTY;
        }
        if (数値.equals(entity.get帳票出力対象データリスト().getKyotakuServiceJigyoshoName())) {
            source.list1Lower_5 = entity.get帳票出力対象データリスト().getKyotakuServiceJigyoshoName();
            if (区分_2.equals(entity.get帳票出力対象データリスト().getKyotakuServiceSakuseiKubunCode())) {
                source.list1Lower_5 = KyotakuservicekeikakuSakuseikubunCode.
                        toValue(entity.get帳票出力対象データリスト().getKyotakuServiceJigyoshoName()).get名称();
            }
        } else if (数値.equals(entity.get帳票出力対象データリスト().getJigyoshoName())) {
            source.list1Lower_5 = entity.get帳票出力対象データリスト().getJigyoshoName();
        } else {
            source.list1Lower_5 = RString.EMPTY;
        }
        if (区分_1.equals(entity.get帳票出力対象データリスト().getDataKubun())
                && !RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getKyotakuServiceSakuseiKubunCode())) {
            source.list1Lower_5 = KyotakuservicekeikakuSakuseikubunCode.
                    toValue(entity.get帳票出力対象データリスト().getKyotakuServiceSakuseiKubunCode()).get名称();
        } else if (区分_2.equals(entity.get帳票出力対象データリスト().getDataKubun())
                && !数値.equals(entity.get帳票出力対象データリスト().getJigyoshoNo())) {
            source.list1Lower_5 = entity.get帳票出力対象データリスト().getJigyoshoNo();
        } else {
            source.list1Lower_5 = RString.EMPTY;
        }
        RStringBuilder iraiDateTime1 = new RStringBuilder();
        if (!RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getServiceTeikyoYM())) {
            iraiDateTime.append(new RDate(entity.get帳票出力対象データリスト()
                    .getServiceTeikyoYM().toString()).wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).
                    fillType(FillType.BLANK).toDateString());
            source.listGokeiJoho_1 = iraiDateTime1.toRString();
        }
        return source;
    }

    private RiyoJokyoIchiranReportSource editSource2(RiyoJokyoIchiranReportSource source) {
        source.listGokeiJoho_2 = YokaigoJotaiKubunSupport.toValue(new FlexibleYearMonth(entity.get帳票出力対象データリスト().getServiceTeikyoYM()),
                entity.get帳票出力対象データリスト().getYoKaigoJotaiKubunCode()).getName();
        RStringBuilder iraiDateTime2 = new RStringBuilder();
        if (!RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getNinteiYukoKaishiYMD())) {
            iraiDateTime2.append(new RDate(entity.get帳票出力対象データリスト().getNinteiYukoKaishiYMD().
                    toString()).wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).
                    fillType(FillType.BLANK).toDateString());
            source.listGokeiJoho_3 = iraiDateTime2.toRString();
        }
        RStringBuilder iraiDateTime3 = new RStringBuilder();
        if (!RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getNinteiYukoShuryoYMD())) {
            iraiDateTime3.append(new RDate(entity.get帳票出力対象データリスト().getNinteiYukoShuryoYMD().
                    toString()).wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).
                    fillType(FillType.BLANK).toDateString());
            source.listGokeiJoho_3 = iraiDateTime3.toRString();
        }
        RStringBuilder stringBuilder1 = new RStringBuilder();
        stringBuilder1.append(iraiDateTime2.toRString());
        stringBuilder1.append(KANA);
        stringBuilder1.append(iraiDateTime3.toRString());
        source.listGokeiJoho_3 = stringBuilder1.toRString();
        if (entity.get帳票出力対象データリスト().getNinteiYukoKaishiYMD().isEmpty()) {
            source.listGokeiJoho_3 = RString.EMPTY;
        } else if (entity.get帳票出力対象データリスト().getNinteiYukoShuryoYMD().isEmpty()) {
            source.listGokeiJoho_3 = iraiDateTime2.toRString();
        }
        if (!RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getKyufuJissekiKubunCode())) {
            source.listMeisaiJoho_1 = KyufuJissekiKubun.toValue(entity.get帳票出力対象データリスト().getKyufuJissekiKubunCode()).get名称();
        }
        source.listMeisaiJoho_2 = entity.get帳票出力対象データリスト().getServiceShuruiCode();
        source.listMeisaiJoho_3 = entity.get帳票出力対象データリスト().getServiceShuruiMei();
        source.listRiyoJokyo1_1 = entity.get帳票出力対象データリスト().getNissuKaisu();
        source.listRiyoJokyo1_2 = entity.get帳票出力対象データリスト().getGaihakuNissu();
        source.listRiyoJokyo1_3 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHokenTanisu().toString()), 0);
        source.listRiyoJokyo1_4 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHokenSeikyugaku().toString()), 0);
        source.listRiyoJokyo1_5 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHokenRiyoshaFutangaku().toString()), 0);
        source.listRiyoJokyo2_1 = entity.get帳票出力対象データリスト().getTankiNyushoJitsunissu();
        if (RString.isNullOrEmpty(entity.get帳票出力対象データリスト().getTaishogoJotaiCode())) {
            source.listRiyoJokyo2_2 = RString.EMPTY;
        } else {
            source.listRiyoJokyo2_2 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.退所_院_後の状態コード.getコード(),
                    new Code(entity.get帳票出力対象データリスト().getTaishogoJotaiCode()), FlexibleDate.getNowDate());
        }
        source.listRiyoJokyo2_3 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHokenDekidakaTanisu().toString()), 0);
        source.listRiyoJokyo2_4 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHokenDekidakaSeikyugaku().toString()), 0);
        source.listRiyoJokyo2_5 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHokenDekidakaRiyoshaFutangaku().toString()), 0);
        return source;
    }

    private RiyoJokyoIchiranReportSource editSource3(RiyoJokyoIchiranReportSource source) {
        source.listRiyoJokyo3_1 = entity.get帳票出力対象データリスト().getShafukuKeigenritsu();
        if (is制度改正以降()) {
            source.listRiyoJokyo3_2 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getShafukuRiyoshaFutangaku().toString()), 0);
        } else if (is制度改正以前()) {
            source.listRiyoJokyo3_2 = RString.EMPTY;
        }
        if (is制度改正以降()) {
            source.listRiyoJokyo3_3 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getShafukuKeigengaku().toString()), 0);
        } else if (is制度改正以前()) {
            source.listRiyoJokyo3_3 = RString.EMPTY;
        }
        if (is制度改正以降()) {
            source.listRiyoJokyo3_4 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getShafukuKeigengoRiyoshaFutangaku().toString()), 0);
        } else if (is制度改正以前()) {
            source.listRiyoJokyo3_4 = RString.EMPTY;
        }
        int 食費_日数 = Integer.parseInt(entity.get帳票出力対象データリスト().getTokuteiNyushoShokuhiNissu().toString());
        int 居住_日数 = Integer.parseInt(entity.get帳票出力対象データリスト().getTokuteiNyushoKyojuNissu().toString());
        if (is制度改正以降()) {
            if (居住_日数 < 食費_日数) {
                source.listRiyoJokyo1_6 = entity.get帳票出力対象データリスト().getTokuteiNyushoShokuhiNissu();
            } else {
                source.listRiyoJokyo1_6 = entity.get帳票出力対象データリスト().getTokuteiNyushoKyojuNissu();
            }
        }
        if (is制度改正以前()) {
            source.listRiyoJokyo1_6 = new RString(居住_日数 + 食費_日数);
        }
        Decimal 食費_費用額 = new Decimal(entity.get帳票出力対象データリスト().getTokuteiNyushoShokuhiHiyogaku().toString());
        Decimal 居住_費用額 = new Decimal(entity.get帳票出力対象データリスト().getTokuteiNyushoKyojuHiyogaku().toString());
        if (is制度改正以降()) {
            source.listRiyoJokyo1_7 = DecimalFormatter.toコンマ区切りRString(食費_費用額.add(居住_費用額), 0);
        }
        if (is制度改正以前()) {
            source.listRiyoJokyo1_7 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getNichigakuHyojunFutangaku().toString()), 0);
        }
        Decimal 食費_負担額 = new Decimal(entity.get帳票出力対象データリスト().getTokuteiNyushoShokuhiRiyoshaFutangaku().toString());
        Decimal 居住_負担額 = new Decimal(entity.get帳票出力対象データリスト().getTokuteiNyushoKyojuRiyoshaFutangaku().toString());
        if (is制度改正以降()) {
            source.listRiyoJokyo2_6 = DecimalFormatter.toコンマ区切りRString(食費_負担額.add(居住_負担額), 0);
        }
        if (is制度改正以前()) {
            source.listRiyoJokyo2_6 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getShokujiTeikyohiGokei().toString()), 0);
        }
        Decimal 食費_請求額 = new Decimal(entity.get帳票出力対象データリスト().getTokuteiNyushoShokuhiRiyoshaFutangaku().toString());
        Decimal 居住_請求額 = new Decimal(entity.get帳票出力対象データリスト().getTokuteiNyushoKyojuRiyoshaFutangaku().toString());
        if (is制度改正以降()) {
            source.listRiyoJokyo3_5 = DecimalFormatter.toコンマ区切りRString(食費_請求額.add(居住_請求額), 0);
        }
        if (is制度改正以前()) {
            source.listRiyoJokyo3_5 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getShokujiTeikyohiSeikyugaku().toString()), 0);
        }
        source.listRiyoJokyo1_8 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHomonShikyuGendogaku().toString()), 0);
        if (区分_1.equals(entity.get帳票出力対象データリスト().getDataKubun())) {
            source.listRiyoJokyo1_9 = RString.HALF_SPACE;
            source.listRiyoJokyo2_7 = RString.HALF_SPACE;
            source.listRiyoJokyo2_8 = entity.get帳票出力対象データリスト().getHomonRiyoritsu();
            source.listRiyoJokyo3_6 = RString.HALF_SPACE;
            source.listRiyoJokyo3_7 = entity.get帳票出力対象データリスト().getTankiRiyoritsu();
        } else {
            source.listRiyoJokyo1_9 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHomonRiyoServiceTanisu().toString()), 0);
            source.listRiyoJokyo2_7 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getHomonRiyoServiceTanisu().toString()), 0);
            source.listRiyoJokyo2_8 = RString.EMPTY;
            source.listRiyoJokyo3_7 = RString.EMPTY;
            source.listRiyoJokyo3_6 = DecimalFormatter.
                    toコンマ区切りRString(new Decimal(entity.get帳票出力対象データリスト().getTankiRiyoServiceTanisu().toString()), 0);
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hihokennshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                entity.get帳票出力対象データリスト().getHihokenshaNo());
        return source;
    }

    private boolean is制度改正以降() {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(entity.get帳票出力対象データリスト().getServiceTeikyoYM());
        FlexibleYearMonth 度改正施行日 = new FlexibleYearMonth(DbBusinessConfig.
                get(ConfigNameDBU.制度改正施行日_平成１７年１０月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(0, SIX));
        return 度改正施行日.isBeforeOrEquals(サービス提供年月);
    }

    private boolean is制度改正以前() {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(entity.get帳票出力対象データリスト().getServiceTeikyoYM());
        FlexibleYearMonth 度改正施行日 = new FlexibleYearMonth(DbBusinessConfig.
                get(ConfigNameDBU.制度改正施行日_平成１７年１０月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(0, SIX));
        return サービス提供年月.isBefore(度改正施行日);
    }
}
