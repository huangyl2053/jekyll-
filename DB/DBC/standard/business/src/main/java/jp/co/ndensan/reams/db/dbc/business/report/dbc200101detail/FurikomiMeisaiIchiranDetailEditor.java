/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101detail;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoShokan3Keta;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata.ItijiTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata.MeisaiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101detail.FurikomiMeisaiIchiranDetailReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 振込明細一覧表（明細）Editorのクラスです。
 *
 * @reamsid_L DBC-2180-050 b_liuyang2
 */
public class FurikomiMeisaiIchiranDetailEditor implements IFurikomiMeisaiIchiranDetailEditor {

    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int LISTINDEX_15 = 15;
    private static final int LISTINDEX_20 = 20;
    private static final int LISTINDEX_22 = 22;
    private static final int LISTINDEX_24 = 24;
    private static final int LISTINDEX_30 = 30;
    private static final RString 作成 = new RString("作成");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 金融機関 = new RString("金融機関");
    private static final RString 支払場所 = new RString("支払場所");
    private static final RString 預金種別 = new RString("預金種別");
    private static final RString 支払期間 = new RString("支払期間");
    private static final RString 口座番号 = new RString("口座番号");
    private static final RString 口座名義人 = new RString("口座名義人");
    private static final RString 半角ハイフン = new RString("-");
    private static final RString 丸 = new RString("●");
    private static final RString 左カッコ = new RString("(");
    private static final RString 右カッコ = new RString(")");
    private static final RString 半角スペース1桁 = new RString(" ");
    private static final RString 申請中 = new RString("申請中");
    private static final RString 未申請 = new RString("未申請");
    private static final RString 福祉用具 = new RString("福祉用具");
    private static final RString 住宅改修 = new RString("住宅改修");
    private static final RString 償還 = new RString("償還");
    private static final RString 高額 = new RString("高額");

    private final MeisaiDataEntity 一覧表用データ;
    private final IOutputOrder 出力順;
    private final Furikomi_ShihraiHohoShitei 支払方法;
    private final RDateTime 作成日時;
    private final RString 設定値;

    /**
     * インスタンスを生成します。
     *
     * @param 一覧表用データ MeisaiDataEntity
     * @param 出力順 IOutputOrder
     * @param 支払方法 Furikomi_ShihraiHohoShitei
     * @param 作成日時 RDateTime
     * @param 設定値 RString
     */
    protected FurikomiMeisaiIchiranDetailEditor(MeisaiDataEntity 一覧表用データ, IOutputOrder 出力順,
            Furikomi_ShihraiHohoShitei 支払方法, RDateTime 作成日時, RString 設定値) {
        this.一覧表用データ = 一覧表用データ;
        this.出力順 = 出力順;
        this.支払方法 = 支払方法;
        this.作成日時 = 作成日時;
        this.設定値 = 設定値;
    }

    @Override
    public FurikomiMeisaiIchiranDetailReportSource edit(FurikomiMeisaiIchiranDetailReportSource source) {
        editHeader(source);
        edit明細1(source);
        edit明細2(source);
//        editFuttaa(source);
        return source;
    }

    private void editHeader(FurikomiMeisaiIchiranDetailReportSource source) {
        source.printTimeStamp = new RStringBuilder()
                .append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString())
                .append(RString.FULL_SPACE)
                .append(作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒))
                .append(RString.FULL_SPACE)
                .append(作成).toRString();
        if (null != this.設定値) {
            source.title = this.設定値;
        }
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (null != this.出力順 && (null != this.出力順.get設定項目リスト() && !this.出力順.get設定項目リスト().isEmpty())) {
            List<ISetSortItem> 設定項目リスト = this.出力順.get設定項目リスト();
            if (!設定項目リスト.isEmpty()) {
                source.shutsuryokujun1 = 設定項目リスト.get(0).get項目名();
            }
            if (設定項目リスト.size() > 1) {
                source.shutsuryokujun2 = 設定項目リスト.get(1).get項目名();
            }
            if (設定項目リスト.size() > 2) {
                source.shutsuryokujun2 = 設定項目リスト.get(2).get項目名();
            }
            if (設定項目リスト.size() > LISTINDEX_3) {
                source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
            if (設定項目リスト.size() > LISTINDEX_4) {
                source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
        if (null != this.支払方法) {
            if (ONE.equals(this.支払方法.getコード())) {
                source.hdrTitle1 = 金融機関;
            } else {
                source.hdrTitle1 = 支払場所;
            }
            if (ONE.equals(this.支払方法.getコード())) {
                source.hdrTitle2 = 預金種別;
            } else {
                source.hdrTitle2 = 支払期間;
            }
            if (ONE.equals(this.支払方法.getコード())) {
                source.hdrTitle3 = 口座番号;
            }
            if (ONE.equals(this.支払方法.getコード())) {
                source.hdrTitle4 = 口座名義人;
            }
        }
    }

    private void edit明細1(FurikomiMeisaiIchiranDetailReportSource source) {
        if (null != this.一覧表用データ) {
            if (null != this.一覧表用データ.get様式連番() && ONE.equals(this.一覧表用データ.get様式連番())) {
                get振込明細一時TBL(source);
                get一覧表用データ(source);

            }
        }
    }

    private void edit明細2(FurikomiMeisaiIchiranDetailReportSource source) {
        if (null != this.一覧表用データ && (null != this.一覧表用データ.get様式連番()
                && this.一覧表用データ.get様式連番().compareTo(TWO) >= 0)) {
            source.listUpper_1 = RString.EMPTY;
            source.listUpper_2 = RString.EMPTY;
            source.listUpper_3 = RString.EMPTY;
            source.listUpper_4 = RString.EMPTY;
            source.listUpper_5 = RString.EMPTY;
            source.listUpper_6 = RString.EMPTY;
            source.listUpper_7 = RString.EMPTY;
            source.listUpper_8 = RString.EMPTY;
            source.listUpper_9 = RString.EMPTY;
            source.listUpper_10 = RString.EMPTY;
            source.listUpper_11 = RString.EMPTY;
            if (null != this.一覧表用データ.get印字様式名称()) {
                if (this.一覧表用データ.get印字様式名称().length() <= LISTINDEX_4) {
                    source.listUpper_12 = this.一覧表用データ.get印字様式名称();
                } else {
                    source.listUpper_12 = this.一覧表用データ.get印字様式名称().substring(0, LISTINDEX_4);
                }
            }
            source.listUpper_13 = 左カッコ;
            if (null != this.一覧表用データ.get振込明細一時TBL()) {
                ItijiTableEntity 振込明細一時TBL = this.一覧表用データ.get振込明細一時TBL();
                if (null != 振込明細一時TBL.get振込金額()) {
                    source.listUpper_14 = DecimalFormatter.toコンマ区切りRString(振込明細一時TBL.get振込金額(), 0);
                }
            }
            source.listUpper_15 = 右カッコ;
            source.listUpper_16 = RString.EMPTY;
            source.listUpper_17 = RString.EMPTY;
            source.listLower_1 = RString.EMPTY;
            source.listLower_2 = RString.EMPTY;
            source.listLower_3 = RString.EMPTY;
            source.listLower_4 = RString.EMPTY;
            source.listLower_5 = RString.EMPTY;
            source.listLower_6 = RString.EMPTY;
            if (!this.一覧表用データ.get様式連番().equals(ONE)) {
                if (null != this.一覧表用データ.get印字様式名称()) {
                    if (this.一覧表用データ.get印字様式名称().length() <= LISTINDEX_4) {
                        source.listLower_7 = this.一覧表用データ.get印字様式名称();
                    } else {
                        source.listLower_7 = this.一覧表用データ.get印字様式名称().substring(0, LISTINDEX_4);
                    }
                }
                source.listLower_8 = 左カッコ;
                if (null != this.一覧表用データ.get様式別集計金額()) {
                    source.listLower_9 = DecimalFormatter.toコンマ区切りRString(this.一覧表用データ.get様式別集計金額(), 0);
                }
                source.listLower_10 = 右カッコ;
            } else {
                source.listLower_7 = RString.EMPTY;
                source.listLower_8 = RString.EMPTY;
                source.listLower_9 = RString.EMPTY;
                source.listLower_10 = RString.EMPTY;
            }
            source.listLower_11 = RString.EMPTY;
            source.listMadoguchiUpper_1 = RString.EMPTY;
            source.listMadoguchiUpper_2 = RString.EMPTY;
            source.listMadoguchiLower_1 = RString.EMPTY;
        }
    }

//    private void editFuttaa(FurikomiMeisaiIchiranDetailReportSource source) {
//    }
    private void get振込明細一時TBL(FurikomiMeisaiIchiranDetailReportSource source) {
        if (null != this.一覧表用データ.get振込明細一時TBL()) {
            ItijiTableEntity 振込明細一時TBL = this.一覧表用データ.get振込明細一時TBL();
            if (null != 振込明細一時TBL.get被保険者番号()) {
                source.listUpper_1 = 振込明細一時TBL.get被保険者番号();
            }
            get氏名漢字(source, 振込明細一時TBL);

            if (null != 振込明細一時TBL.get郵便番号()) {
                RString 郵便番号1 = 振込明細一時TBL.get郵便番号().substring(0, LISTINDEX_3);
                RString 郵便番号2 = 振込明細一時TBL.get郵便番号().substring(LISTINDEX_4);
                source.listUpper_3 = 郵便番号1.concat(半角ハイフン).concat(郵便番号2);
            }
            if (null != 振込明細一時TBL.get支払方法区分コード()
                    && !振込明細一時TBL.get支払方法区分コード().getコード().equals(ONE)) {
                get支払方法区分コードnotEqualsOne(source, 振込明細一時TBL);
            }
            if (null != 振込明細一時TBL.get決定通知番号()) {
                source.listUpper_8 = 振込明細一時TBL.get決定通知番号();
            }
            if (null != 振込明細一時TBL.getサービス提供年月()) {
                source.listUpper_9 = 振込明細一時TBL.getサービス提供年月().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            RString 申請区分コード = 振込明細一時TBL.get申請区分コード();
            RString 申請区分名称 = RString.EMPTY;
            if (null != 申請区分コード && !申請区分コード.isEmpty()) {
                申請区分名称 = NinteiShinseiShinseijiKubunCode.toValue(申請区分コード).get名称();
            }
            if (申請区分名称.length() <= LISTINDEX_4) {
                source.listUpper_10 = 申請区分名称;
            } else {
                source.listUpper_10 = 申請区分名称.substring(0, LISTINDEX_4);
            }
            if (null != 振込明細一時TBL.get認定有効期間開始年月日()) {
                source.listUpper_11 = 振込明細一時TBL.get認定有効期間開始年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            source.listUpper_12 = RString.EMPTY;
            source.listUpper_13 = RString.EMPTY;
            if (null != 振込明細一時TBL.get振込金額()) {
                source.listUpper_14 = DecimalFormatter.toコンマ区切りRString(振込明細一時TBL.get振込金額(), 0);
            }
            source.listUpper_15 = RString.EMPTY;
            if (null != 振込明細一時TBL.get前回支払金額() && !振込明細一時TBL.get前回支払金額().equals(ZERO)) {
                source.listUpper_16 = 丸;
            }
            get住所(source, 振込明細一時TBL);
            if (振込明細一時TBL.is申請データフラグ()) {
                source.listLower_4 = 申請中;
            } else if (null != 振込明細一時TBL.get要介護認定状態区分コード()
                    && 振込明細一時TBL.get要介護認定状態区分コード().isEmpty()) {
                source.listLower_4 = 未申請;
            }
            if (null != 振込明細一時TBL.getサービス提供年月() && null != 振込明細一時TBL.get要介護認定状態区分コード()) {
                source.listLower_5 = YokaigoJotaiKubunSupport.toValue(振込明細一時TBL.getサービス提供年月(),
                        振込明細一時TBL.get要介護認定状態区分コード()).getName();
            }
            if (null != 振込明細一時TBL.get認定有効期間終了年月日()) {
                source.listLower_6 = 振込明細一時TBL.get認定有効期間終了年月日().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            get集計様式番号(source, 振込明細一時TBL);
            if (null != 振込明細一時TBL.get支払方法区分コード()
                    && 振込明細一時TBL.get支払方法区分コード().getコード().equals(ONE)) {
                get支払方法区分コードequalsOne(source, 振込明細一時TBL);

            }
        }
    }

    private void get支払方法区分コードnotEqualsOne(FurikomiMeisaiIchiranDetailReportSource source, ItijiTableEntity 振込明細一時TBL) {
        if (null != 振込明細一時TBL.get金融機関コード() && null != 振込明細一時TBL.get支店コード()) {
            source.listUpper_4 = 振込明細一時TBL.get金融機関コード().
                    concat(半角ハイフン).concat(振込明細一時TBL.get支店コード());
        }
        if (null != 振込明細一時TBL.get金融機関名称()) {
            source.listUpper_5 = 振込明細一時TBL.get金融機関名称();
        }
        if (null != 振込明細一時TBL.get預金種別名称()) {
            source.listUpper_6 = 振込明細一時TBL.get預金種別名称();
        }
        if (null != 振込明細一時TBL.get口座番号()) {
            source.listUpper_7 = 振込明細一時TBL.get口座番号();
        }
        if (null != 振込明細一時TBL.get支店名称()) {
            source.listLower_2 = 振込明細一時TBL.get支店名称();
        }
        if (null != 振込明細一時TBL.get口座名義人()) {
            if (振込明細一時TBL.get口座名義人().length() <= LISTINDEX_24) {
                source.listLower_2 = 振込明細一時TBL.get口座名義人();
            } else {
                source.listLower_2 = 振込明細一時TBL.get口座名義人().substring(0, LISTINDEX_24);
            }
        }
    }

    private void get支払方法区分コードequalsOne(FurikomiMeisaiIchiranDetailReportSource source, ItijiTableEntity 振込明細一時TBL) {
        if (null != 振込明細一時TBL.get支払場所()) {
            if (振込明細一時TBL.get支払場所().length() <= LISTINDEX_30) {
                RString 支払場所1 = 振込明細一時TBL.get支払場所().substring(0, LISTINDEX_22);
                RString 支払場所2 = 振込明細一時TBL.get支払場所().substring(LISTINDEX_22);
                source.listMadoguchiUpper_1 = 支払場所1.concat("\n\r").concat(支払場所2);
            } else {
                RString 支払場所1 = 振込明細一時TBL.get支払場所().substring(0, LISTINDEX_22);
                RString 支払場所2 = 振込明細一時TBL.get支払場所().substring(LISTINDEX_22, LISTINDEX_30);
                source.listMadoguchiUpper_1 = 支払場所1.concat("\n\r").concat(支払場所2);
            }
        }
        if (null != 振込明細一時TBL.get支払期間開始年月日() && null != 振込明細一時TBL.get支払窓口開始時間()) {
            RString 支払期間開始年月日 = 振込明細一時TBL.get支払期間開始年月日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            RString 支払窓口開始時間 = 振込明細一時TBL.get支払窓口開始時間().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            source.listMadoguchiUpper_2 = 支払期間開始年月日.concat(半角スペース1桁).concat(支払窓口開始時間);
        }
        if (null != 振込明細一時TBL.get支払期間終了年月日() && null != 振込明細一時TBL.get支払窓口終了時間()) {
            RString 支払期間終了年月日 = 振込明細一時TBL.get支払期間終了年月日().wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            RString 支払窓口終了時間 = 振込明細一時TBL.get支払窓口終了時間().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            source.listMadoguchiLower_1 = 支払期間終了年月日.concat(半角スペース1桁).concat(支払窓口終了時間);
        }
    }

    private void get住所(FurikomiMeisaiIchiranDetailReportSource source, ItijiTableEntity 振込明細一時TBL) {
        if (null != 振込明細一時TBL.get住所()) {
            if (振込明細一時TBL.get住所().length() <= LISTINDEX_20) {
                source.listLower_1 = 振込明細一時TBL.get住所();
            } else {
                source.listLower_1 = 振込明細一時TBL.get住所().substring(0, LISTINDEX_20);
            }
        }
    }

    private void get氏名漢字(FurikomiMeisaiIchiranDetailReportSource source, ItijiTableEntity 振込明細一時TBL) {
        if (null != 振込明細一時TBL.get氏名漢字()) {
            if (振込明細一時TBL.get氏名漢字().length() <= 15) {
                source.listUpper_2 = 振込明細一時TBL.get氏名漢字();
            } else {
                source.listUpper_2 = 振込明細一時TBL.get氏名漢字().substring(0, LISTINDEX_15);
            }
        }
    }

    private void get集計様式番号(FurikomiMeisaiIchiranDetailReportSource source, ItijiTableEntity 振込明細一時TBL) {
        if (null != this.一覧表用データ.get集計様式番号()) {
            RString 集計様式番号 = this.一覧表用データ.get集計様式番号();
            if (集計様式番号.equals(NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.getコード())) {
                source.listLower_11 = 福祉用具;
            } else if (集計様式番号.equals(NyuryokuShikibetsuNoShokan3Keta.住宅改修費.getコード())) {
                source.listLower_11 = 住宅改修;
            } else if (null != 振込明細一時TBL.getデータ区分() && 振込明細一時TBL.getデータ区分().getコード().equals(ONE)) {
                source.listLower_11 = 償還;
            } else if (null != 振込明細一時TBL.getデータ区分() && 振込明細一時TBL.getデータ区分().getコード().equals(TWO)) {
                source.listLower_11 = 高額;
            }
        }
    }

    private void get一覧表用データ(FurikomiMeisaiIchiranDetailReportSource source) {
        if (null != this.一覧表用データ.get名寄せ件数() && this.一覧表用データ.get名寄せ件数().compareTo(ONE) > 0) {
            source.listUpper_17 = this.一覧表用データ.get名寄せ件数();
        }
        if (null != this.一覧表用データ.get印字様式名称()) {
            if (this.一覧表用データ.get印字様式名称().length() <= LISTINDEX_4) {
                source.listLower_7 = this.一覧表用データ.get印字様式名称();
            } else {
                source.listLower_7 = this.一覧表用データ.get印字様式名称().substring(0, LISTINDEX_4);
            }
        }
        source.listLower_8 = 左カッコ;
        if (null != this.一覧表用データ.get様式別集計金額()) {
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(this.一覧表用データ.get様式別集計金額(), 0);
        }
        source.listLower_10 = 右カッコ;

    }
}
