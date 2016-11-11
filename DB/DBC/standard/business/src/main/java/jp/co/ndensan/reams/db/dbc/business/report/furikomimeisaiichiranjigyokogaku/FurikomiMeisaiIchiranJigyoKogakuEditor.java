/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiranjigyokogaku;

import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.FurikomiMeisaiIchiranJigyoKogakuSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 振込明細一覧表（事業高額）Editorクラスです。
 *
 * @reamsid_L DBC-4870-070 wangxingpeng
 */
public class FurikomiMeisaiIchiranJigyoKogakuEditor implements IFurikomiMeisaiIchiranJigyoKogakuEditor {

    private final FurikomiMeisaiIchiranJigyoKogakuParameter target;
    private final boolean is頁計;
    private final boolean is総合計;
    private static final RString 作成 = new RString("作成");
    private static final RString 申請中 = new RString("申請中");
    private static final RString 未申請 = new RString("未申請");
    private static final RString 事業対象 = new RString("事業対象");
    private static final RString 期間 = new RString("～");
    private static final RString 有 = new RString("有");
    private static final RString 数字 = new RString("1");
    private static final RString 文_被保険者番号 = new RString("被保険者番号");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_0 = 0;
    private static final RString コロン = new RString(":");

    /**
     * コンストラクタです
     *
     * @param target FurikomiMeisaiIchiranJigyoKogakuParameter
     * @param is頁計 boolean
     * @param is総合計 boolean
     */
    public FurikomiMeisaiIchiranJigyoKogakuEditor(FurikomiMeisaiIchiranJigyoKogakuParameter target,
            boolean is頁計, boolean is総合計) {
        this.target = target;
        this.is頁計 = is頁計;
        this.is総合計 = is総合計;
    }

    @Override
    public FurikomiMeisaiIchiranJigyoKogakuSource edit(FurikomiMeisaiIchiranJigyoKogakuSource source) {
        if (target != null) {
            source.printTimeStamp = パターン12(target.getシステム日付());
            editHead(source);
            edit振込データ(source);
            edit集計(source);
            if (target.get振込明細一時() != null
                    && target.get振込明細一時().getHihokenshaNo() != null
                    && target.get振込明細一時().getShikibetsuCode() != null) {
                PersonalData personalData = PersonalData.of(target.get振込明細一時().getShikibetsuCode(),
                        new ExpandedInformation(new Code("003"), 文_被保険者番号, target.get振込明細一時().getHihokenshaNo().getColumnValue()));
                AccessLogger.log(AccessLogType.照会, personalData);
            }
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), 文_被保険者番号, source.list1_1);
        return source;
    }

    private void edit集計(FurikomiMeisaiIchiranJigyoKogakuSource source) {

        if (is頁計) {
            if (target.getNinzu_shokei() != null) {
                source.ninzu_shokei = DecimalFormatter.toコンマ区切りRString(target.getNinzu_shokei(), 0);
            }
            if (target.getShikyu_shokei() != null) {
                source.shikyu_shokei = DecimalFormatter.toコンマ区切りRString(target.getShikyu_shokei(), 0);
            }
            edit総合計(source);
        }
    }

    private void edit総合計(FurikomiMeisaiIchiranJigyoKogakuSource source) {
        if (is総合計) {
            if (target.getYoshien_ninzu_gokei() != null) {
                source.yoshien_ninzu_gokei = DecimalFormatter.toコンマ区切りRString(target.getYoshien_ninzu_gokei(), 0);
            }
            if (target.getYoshien_kingaku_gokei() != null) {
                source.yoshien_kingaku_gokei = DecimalFormatter.toコンマ区切りRString(target.getYoshien_kingaku_gokei(), 0);
            }
            if (target.getJigyotaisho_ninzu_gokei() != null) {
                source.jigyotaisho_ninzu_gokei = DecimalFormatter.toコンマ区切りRString(target.getJigyotaisho_ninzu_gokei(), 0);
            }
            if (target.getJigyotaisho_kingaku_gokei() != null) {
                source.jigyotaisho_kingaku_gokei = DecimalFormatter.toコンマ区切りRString(target.getJigyotaisho_kingaku_gokei(), 0);
            }
            if (target.getFumei_ninzu_gokei() != null) {
                source.fumei_ninzu_gokei = DecimalFormatter.toコンマ区切りRString(target.getFumei_ninzu_gokei(), 0);
            }
            if (target.getFumei_kingaku_gokei() != null) {
                source.fumei_kingaku_gokei = DecimalFormatter.toコンマ区切りRString(target.getFumei_kingaku_gokei(), 0);
            }
            if (target.getNinzu_gokei() != null) {
                source.ninzu_gokei = DecimalFormatter.toコンマ区切りRString(target.getNinzu_gokei(), 0);
            }
            if (target.getShikyu_gokei() != null) {
                source.shikyu_gokei = DecimalFormatter.toコンマ区切りRString(target.getShikyu_gokei(), 0);
            }
        }
    }

    private void editHead(FurikomiMeisaiIchiranJigyoKogakuSource source) {
        source.title = target.get帳票タイトル();
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (target.get並び順１() != null) {
            source.shutsuryokujun1 = target.get並び順１();
            source.shutsuryokujun2 = target.get並び順２();
            source.shutsuryokujun3 = target.get並び順３();
            source.shutsuryokujun4 = target.get並び順４();
            source.shutsuryokujun5 = target.get並び順５();
        }
    }

    private void edit振込データ(FurikomiMeisaiIchiranJigyoKogakuSource source) {
        if (null == target.get振込明細一時()) {
            return;
        }
        DbWT0510FurikomiMeisaiTempEntity 振込明細 = target.get振込明細一時();
        source.list1_1 = 振込明細.getHihokenshaNo().getColumnValue();
        if (振込明細.getShimei() != null) {
            source.list1_2 = 振込明細.getShimei().value();
        }
        source.list1_3 = パターン54(振込明細.getServiceTeikyoYM());
        source.list1_4 = パターン4(振込明細.getShinseiYMD());
        source.list1_5 = NinteiShinseiShinseijiKubunCode.toValue(振込明細.getShiharaiHohoKubunCode()).get名称();

        if (振込明細.getShiharaiHohoKubunCode() != null) {
            source.list4_1 = ShiharaiHohoKubun.toValue(振込明細.getShiharaiHohoKubunCode()).get名称();
            if (数字.equals(振込明細.getShiharaiHohoKubunCode())) {
                source.list1_7 = 振込明細.getShiharaiBasho();
                FlexibleDate 支払期間開始年月日 = 振込明細.getShiharaiKaishiYMD();
                FlexibleDate 支払期間終了年月日 = 振込明細.getShiharaiShuryoYMD();
                RString 支払窓口開始時間 = 振込明細.getShiharaiKaishiTime();
                RString 支払窓口終了時間 = 振込明細.getShiharaiShuryoTime();
                RString 支払窓口開始時間R = 支払窓口開始時間 == null || 支払窓口開始時間.isEmpty()
                        ? RString.EMPTY : 支払窓口開始時間.substring(INT_0, INT_2).concat(コロン).concat(支払窓口開始時間.substring(INT_2));
                RString 支払窓口終了時間R = 支払窓口終了時間 == null || 支払窓口終了時間.isEmpty()
                        ? RString.EMPTY : 支払窓口終了時間.substring(INT_0, INT_2).concat(コロン).concat(支払窓口終了時間.substring(INT_2));
                RString 開始 = パターン4(支払期間開始年月日).concat(RString.HALF_SPACE).concat(支払窓口開始時間R);
                RString 終了 = パターン4(支払期間終了年月日).concat(RString.HALF_SPACE).concat(支払窓口終了時間R);
                source.list2_7 = 開始.concat(期間).concat(終了);
            } else {
                RString 金融機関名称 = 振込明細.getKinyuKikanName();
                RString 支店名称 = 振込明細.getKinyuKikanShitenName();
                RString 預金種別名称 = 振込明細.getYokinShubetsuName();
                RString 口座番号 = 振込明細.getKozaNo();
                RString 口座名義人 = 振込明細.getKozaMeiginin().getColumnValue();
                source.list1_7 = 金融機関名称.concat(RString.HALF_SPACE).concat(支店名称);
                source.list2_7 = 預金種別名称.concat(RString.HALF_SPACE)
                        .concat(口座番号).concat(RString.HALF_SPACE).concat(口座名義人);
            }
        }
        if (振込明細.getJusho() != null) {
            source.list2_1 = 振込明細.getJusho().getColumnValue();
        }
        if (振込明細.getYokaigoJotaiKubunCode() != null) {
            if (振込明細.isShinseiDataFlag()) {
                source.list2_2 = 申請中;
            } else if (!振込明細.isShinseiDataFlag() && 振込明細.getYokaigoJotaiKubunCode().isEmpty()) {
                source.list2_2 = 未申請;
            } else if (!振込明細.isShinseiDataFlag() && !振込明細.getYokaigoJotaiKubunCode().isEmpty()) {
                source.list2_2 = RString.EMPTY;
            }
        }
        if (振込明細.getKetteiYMD() != null) {
            FlexibleYearMonth 決定年月 = 振込明細.getKetteiYMD().getYearMonth();
            source.list2_3 = パターン54(決定年月);
        }
        edit1(振込明細, source);

    }

    private void edit1(DbWT0510FurikomiMeisaiTempEntity 振込明細, FurikomiMeisaiIchiranJigyoKogakuSource source)
            throws IllegalStateException, IllegalArgumentException {
        editList24(振込明細, source);
        source.ｌist3_1 = new RString(target.get連番());
        if (振込明細.getFurikomiKingaku() != null) {
            source.list2_6 = DecimalFormatter.toコンマ区切りRString(振込明細.getFurikomiKingaku(), 0);
        }

        if (INT_1 == target.get名寄せ件数()) {
            source.list5_1 = RString.EMPTY;
        } else if (INT_2 <= target.get名寄せ件数()) {
            source.list5_1 = 有;
        }
    }

    private void editList24(DbWT0510FurikomiMeisaiTempEntity 振込明細, FurikomiMeisaiIchiranJigyoKogakuSource source) throws IllegalArgumentException, IllegalStateException {
        if (null == 振込明細 || null == 振込明細.getYokaigoJotaiKubunCode()) {
            return;
        }
        if (!振込明細.getYokaigoJotaiKubunCode().isEmpty()) {
            source.list1_6 = パターン4(振込明細.getNinteiYukoKikanKaishiYMD());

            FlexibleYearMonth 終了年月 = 振込明細.getKeisanShuryoYMD() == null || 振込明細.getKeisanShuryoYMD().isEmpty()
                    ? FlexibleYearMonth.EMPTY : 振込明細.getKeisanShuryoYMD().getYearMonth();
            if (!終了年月.isEmpty()) {
                source.list2_4 = YokaigoJotaiKubunSupport.toValue(終了年月,
                        振込明細.getYokaigoJotaiKubunCode().value()).getName();
            }
            source.list2_5 = パターン4(振込明細.getNinteiYukoKikanKaishiYMD());
        } else if (振込明細.isSogoJigyoFlag() && 振込明細.getYokaigoJotaiKubunCode().isEmpty()) {
            source.list1_6 = パターン4(振込明細.getSogoJigyoTekiyoKaishiYMD());
            source.list2_4 = 事業対象;
            source.list2_5 = パターン4(振込明細.getSogoJigyoTekiyoKaishiYMD());
        } else if (!振込明細.isSogoJigyoFlag() && 振込明細.getYokaigoJotaiKubunCode().isEmpty()) {
            source.list1_6 = RString.EMPTY;
            source.list2_4 = RString.EMPTY;
            source.list2_5 = RString.EMPTY;
        }

    }

    private RString パターン12(YMDHMS 作成日時) {
        if (null == 作成日時) {
            return RString.EMPTY;
        } else {
            RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 作成時 = 作成日時.getRDateTime().getTime().
                    toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(作成);
            return 作成日.concat(RString.HALF_SPACE).concat(作成時);
        }
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
