/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101detail;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoShokan3Keta;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.gokeidata.GokeiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata.MeisaiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata.PrintNoKingakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101detail.FurikomiMeisaiIchiranDetailReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
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
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
    private static final int LISTINDEX_24 = 24;
    private static final RString 作成 = new RString("作成");
    private static final Decimal ZERO = new Decimal("0");
    private static final RString データ区分_1 = new RString("1");
    private static final RString データ区分_2 = new RString("2");
    private static final RString 支払方法_口座 = new RString("1");
    private static final RString 金融機関 = new RString("金融機関");
    private static final RString 支払場所 = new RString("支払場所");
    private static final RString 預金種別 = new RString("預金種別");
    private static final RString 支払期間 = new RString("支払期間");
    private static final RString 口座番号 = new RString("口座番号");
    private static final RString 口座名義人 = new RString("口座名義人");
    private static final RString 半角ハイフン = new RString("-");
    private static final RString 丸 = new RString("●");
    private static final RString 名寄せ = new RString("名寄せ");
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
    private final GokeiDataEntity 合計データリスト;
    private final IOutputOrder 出力順;
    private final Furikomi_ShihraiHohoShitei 支払方法;
    private final RDateTime 作成日時;
    private final RString 設定値;

    private static int データ数 = 0;
    private static int 毎ページ数 = 0;
    private static int 総レコード数 = 0;
    private static Decimal 毎ページ振込金額合算 = Decimal.ZERO;
    private static Decimal 振込金額合算 = Decimal.ZERO;
    private static final int ページ件数 = 15;
    private static final int 様式連番_1 = 1;

    /**
     * インスタンスを生成します。
     *
     * @param 一覧表用データ MeisaiDataEntity
     * @param 合計データリスト 合計データリスト
     * @param 出力順 IOutputOrder
     * @param 支払方法 Furikomi_ShihraiHohoShitei
     * @param 作成日時 RDateTime
     * @param 設定値 RString
     */
    protected FurikomiMeisaiIchiranDetailEditor(MeisaiDataEntity 一覧表用データ, GokeiDataEntity 合計データリスト, IOutputOrder 出力順,
            Furikomi_ShihraiHohoShitei 支払方法, RDateTime 作成日時, RString 設定値) {
        this.一覧表用データ = 一覧表用データ;
        this.合計データリスト = 合計データリスト;
        this.出力順 = 出力順;
        this.支払方法 = 支払方法;
        this.作成日時 = 作成日時;
        this.設定値 = 設定値;
    }

    @Override
    public FurikomiMeisaiIchiranDetailReportSource edit(FurikomiMeisaiIchiranDetailReportSource source) {
        if (一覧表用データ != null) {
            source.layout = Layouts.鑑;

            List<PrintNoKingakuEntity> list = 一覧表用データ.get印字様式番号別金額List();

            int 様式連番 = list.get(0).get様式連番();
            Decimal 振込金額 = Decimal.ZERO;
            if (一覧表用データ.get振込明細一時TBL() != null && 一覧表用データ.get振込明細一時TBL().getFurikomiKingaku() != null) {
                振込金額 = 一覧表用データ.get振込明細一時TBL().getFurikomiKingaku();
            }
            setページ数と金額(様式連番, 振込金額);
            editHeader(source);
            if (様式連番_1 == 様式連番) {
                edit明細1(source);
            } else {
                edit明細2(source);
            }
            editフッター(source);

        }
        if (合計データリスト != null) {
            source.layout = Layouts.必須;
            FurikomiMeisaiGokeiEditor furikomiMeisaiGokeiEditor = new FurikomiMeisaiGokeiEditor(合計データリスト, 出力順,
                    設定値, 作成日時);
            source = furikomiMeisaiGokeiEditor.edit(source);
        }

        return source;
    }

    private static void setページ数と金額(int 様式連番, Decimal 振込金額) {
        データ数++;
        if (1 == データ数 % ページ件数 && 1 != データ数) {
            毎ページ振込金額合算 = Decimal.ZERO;
            毎ページ数 = 0;
        }
        if (様式連番_1 == 様式連番) {
            毎ページ数++;
            総レコード数++;
            毎ページ振込金額合算 = 毎ページ振込金額合算.add(振込金額);
            振込金額合算 = 振込金額合算.add(振込金額);
        }
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
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (null != this.出力順 && (null != this.出力順.get設定項目リスト() && !this.出力順.get設定項目リスト().isEmpty())) {
            List<ISetSortItem> 設定項目リスト = this.出力順.get設定項目リスト();
            if (!設定項目リスト.isEmpty()) {
                source.shutsuryokujun1 = 設定項目リスト.get(0).get項目名();
            }
            if (設定項目リスト.size() > 1) {
                source.shutsuryokujun2 = 設定項目リスト.get(1).get項目名();
            }
            if (設定項目リスト.size() > 2) {
                source.shutsuryokujun3 = 設定項目リスト.get(2).get項目名();
            }
            if (設定項目リスト.size() > LISTINDEX_3) {
                source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
            if (設定項目リスト.size() > LISTINDEX_4) {
                source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
        if (支払方法 != null) {
            if (支払方法_口座.equals(this.支払方法.getコード())) {
                source.hdrTitle1 = 金融機関;
            } else {
                source.hdrTitle1 = 支払場所;
            }
            if (支払方法_口座.equals(this.支払方法.getコード())) {
                source.hdrTitle2 = 預金種別;
            } else {
                source.hdrTitle2 = 支払期間;
            }
            if (支払方法_口座.equals(this.支払方法.getコード())) {
                source.hdrTitle3 = 口座番号;
            }
            if (支払方法_口座.equals(this.支払方法.getコード())) {
                source.hdrTitle4 = 口座名義人;
            }
        }
    }

    private void edit明細1(FurikomiMeisaiIchiranDetailReportSource source) {
        set様式連番_1のUpper帳票データ(source);
        set様式連番_1のLower帳票データ(source);
        set様式連番_1のその他帳票データ(source);
    }

    private void edit明細2(FurikomiMeisaiIchiranDetailReportSource source) {
        set様式連番_1以外のUpper帳票データ(source);
        set様式連番_1以外のLower帳票データ(source);
        set様式連番_1以外のその他帳票データ(source);
    }

    private void set様式連番_1のUpper帳票データ(FurikomiMeisaiIchiranDetailReportSource source) {
        if (一覧表用データ.get振込明細一時TBL() != null) {
            FurikomiDetailTempTableEntity 振込明細一時TBL = 一覧表用データ.get振込明細一時TBL();
            if (振込明細一時TBL.getHihokenshaNo() != null) {
                source.listUpper_1 = 振込明細一時TBL.getHihokenshaNo().value();
            }
            get氏名漢字(source, 振込明細一時TBL);

            if (振込明細一時TBL.getYubinNo() != null) {
                RString 郵便番号1 = 振込明細一時TBL.getYubinNo().getYubinNo().substringEmptyOnError(0, LISTINDEX_3);
                RString 郵便番号2 = 振込明細一時TBL.getYubinNo().getYubinNo().substringEmptyOnError(LISTINDEX_3);
                source.listUpper_3 = 郵便番号1.concat(半角ハイフン).concat(郵便番号2);
            }
            set様式連番_1のUpper支払方法_口座以外情報(source, 振込明細一時TBL);

            source.listUpper_8 = 振込明細一時TBL.getKetteiTsuchiNo();

            if (振込明細一時TBL.getServiceTeikyoYM() != null && !振込明細一時TBL.getServiceTeikyoYM().isEmpty()) {
                source.listUpper_9 = 振込明細一時TBL.getServiceTeikyoYM().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            RString 申請区分コード = RString.EMPTY;
            if (振込明細一時TBL.getShinseiKubunCode() != null) {
                申請区分コード = 振込明細一時TBL.getShinseiKubunCode().value();
            }

            RString 申請区分名称 = RString.EMPTY;
            if (申請区分コード != null && !申請区分コード.isEmpty()) {
                申請区分名称 = NinteiShinseiShinseijiKubunCode.toValue(申請区分コード).get名称();
            }
            if (申請区分名称.length() <= LISTINDEX_4) {
                source.listUpper_10 = 申請区分名称;
            } else {
                source.listUpper_10 = 申請区分名称.substring(0, LISTINDEX_4);
            }
            if (振込明細一時TBL.getNinteiYukoKikanKaishiYMD() != null && !振込明細一時TBL.getNinteiYukoKikanKaishiYMD().isEmpty()) {
                source.listUpper_11 = 振込明細一時TBL.getNinteiYukoKikanKaishiYMD().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            source.listUpper_12 = RString.EMPTY;
            source.listUpper_13 = RString.EMPTY;
            if (振込明細一時TBL.getFurikomiKingaku() != null) {
                source.listUpper_14 = DecimalFormatter.toコンマ区切りRString(振込明細一時TBL.getFurikomiKingaku(), 0);
            }
            source.listUpper_15 = RString.EMPTY;
            if (振込明細一時TBL.getZenkaiShiharaiKingaku() != null
                    && !振込明細一時TBL.getZenkaiShiharaiKingaku().equals(ZERO)) {
                source.listUpper_16 = 丸;
            }
            if (1 < 一覧表用データ.get印字様式番号別金額List().get(0).get名寄せ件数()) {
                source.listUpper_17 = 名寄せ;
            }
        }
    }

    private void set様式連番_1のLower帳票データ(FurikomiMeisaiIchiranDetailReportSource source) {
        FurikomiDetailTempTableEntity 振込明細一時Data = 一覧表用データ.get振込明細一時TBL();
        if (振込明細一時Data.getJusho() != null) {
            if (振込明細一時Data.getJusho().length() <= LISTINDEX_20) {
                source.listLower_1 = 振込明細一時Data.getJusho();
            } else {
                source.listLower_1 = 振込明細一時Data.getJusho().substring(0, LISTINDEX_20);
            }
            set様式連番_1のLower支払方法_口座以外情報(source, 振込明細一時Data);

            if (振込明細一時Data.isShinseiDataFlag()) {
                source.listLower_4 = 申請中;
            } else if (振込明細一時Data.getYokaigoJotaiKubunCode() == null
                    || 振込明細一時Data.getYokaigoJotaiKubunCode().isEmpty()) {
                source.listLower_4 = 未申請;
            }
            if (振込明細一時Data.getServiceTeikyoYM() != null && 振込明細一時Data.getYokaigoJotaiKubunCode() != null) {
                source.listLower_5 = YokaigoJotaiKubunSupport.toValue(振込明細一時Data.getServiceTeikyoYM(),
                        振込明細一時Data.getYokaigoJotaiKubunCode().value()).getName();
            }

            if (振込明細一時Data.getNinteiYukoKikanShuryoYMD() != null && !振込明細一時Data.getNinteiYukoKikanShuryoYMD().isEmpty()) {
                source.listLower_6 = 振込明細一時Data.getNinteiYukoKikanShuryoYMD().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }

            PrintNoKingakuEntity data = 一覧表用データ.get印字様式番号別金額List().get(0);
            set様式連番_1のLower支払方法_印字様式名称(source, data);
            source.listLower_8 = 左カッコ;
            if (一覧表用データ.get印字様式番号別金額List().get(0).get様式別集計金額() != null) {
                source.listLower_9 = DecimalFormatter.toコンマ区切りRString(
                        一覧表用データ.get印字様式番号別金額List().get(0).get様式別集計金額(), 0);
            }
            source.listLower_10 = 右カッコ;

            set様式連番_1のLower支払方法_集計様式番号(source, 振込明細一時Data, data);
        }
    }

    private void set様式連番_1のその他帳票データ(FurikomiMeisaiIchiranDetailReportSource source) {
        if (支払方法_口座.equals(一覧表用データ.get振込明細一時TBL().getShiharaiHohoKubunCode())) {
            FurikomiDetailTempTableEntity 振込明細一時Data = 一覧表用データ.get振込明細一時TBL();
            if (振込明細一時Data.getShiharaiBasho() != null) {
                source.listMadoguchiUpper_1 = 振込明細一時Data.getShiharaiBasho();
            }
            if (振込明細一時Data.getShiharaiKaishiYMD() != null && 振込明細一時Data.getShiharaiKaishiTime() != null) {
                RString 支払期間開始年月日 = 振込明細一時Data.getShiharaiKaishiYMD().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                RTime 支払窓口開始時間 = new RTime(振込明細一時Data.getShiharaiKaishiTime());
                RString 支払窓口開始時間1 = 支払窓口開始時間.toFormattedTimeString(DisplayTimeFormat.HH_mm);
                source.listMadoguchiUpper_2 = 支払期間開始年月日.concat(半角スペース1桁).concat(支払窓口開始時間1);
            }

            if (振込明細一時Data.getShiharaiShuryoYMD() != null && 振込明細一時Data.getShiharaiShuryoTime() != null) {
                RString 支払期間終了年月日 = 振込明細一時Data.getShiharaiShuryoYMD().wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
                RTime 支払窓口終了時間 = new RTime(振込明細一時Data.getShiharaiShuryoTime());
                RString 支払窓口終了時間1 = 支払窓口終了時間.toFormattedTimeString(DisplayTimeFormat.HH_mm);
                source.listMadoguchiLower_1 = 支払期間終了年月日.concat(半角スペース1桁).concat(支払窓口終了時間1);
            }
        }
    }

    private void set様式連番_1以外のUpper帳票データ(FurikomiMeisaiIchiranDetailReportSource source) {
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
        get印字様式(source);
        source.listUpper_13 = 左カッコ;
        get振込明細(source);
        source.listUpper_15 = 右カッコ;
        source.listUpper_16 = RString.EMPTY;
        source.listUpper_17 = RString.EMPTY;
    }

    private void set様式連番_1以外のLower帳票データ(FurikomiMeisaiIchiranDetailReportSource source) {
        source.listLower_1 = RString.EMPTY;
        source.listLower_2 = RString.EMPTY;
        source.listLower_3 = RString.EMPTY;
        source.listLower_4 = RString.EMPTY;
        source.listLower_5 = RString.EMPTY;
        source.listLower_6 = RString.EMPTY;
        get印字様式名称(source);
        source.listLower_11 = RString.EMPTY;
    }

    private void set様式連番_1以外のその他帳票データ(FurikomiMeisaiIchiranDetailReportSource source) {
        source.listMadoguchiUpper_1 = RString.EMPTY;
        source.listMadoguchiUpper_2 = RString.EMPTY;
        source.listMadoguchiLower_1 = RString.EMPTY;
    }

    private void editフッター(FurikomiMeisaiIchiranDetailReportSource source) {

        source.shokeiNinzu = new RString(毎ページ数);
        source.shokeiKingaku = DecimalFormatter.toコンマ区切りRString(毎ページ振込金額合算, 0);
        if (0 != データ数 % ページ件数) {
            source.gokeiNinzu = new RString(総レコード数);
            source.gokeiKingaku = DecimalFormatter.toコンマ区切りRString(振込金額合算, 0);
        }
    }

    private void get氏名漢字(FurikomiMeisaiIchiranDetailReportSource source, FurikomiDetailTempTableEntity 振込明細一時TBL) {
        if (振込明細一時TBL.getShimei() != null) {
            if (振込明細一時TBL.getShimei().value().length() <= LISTINDEX_15) {
                source.listUpper_2 = 振込明細一時TBL.getShimei().value();
            } else {
                source.listUpper_2 = 振込明細一時TBL.getShimei().value().substring(0, LISTINDEX_15);
            }
        }
    }

    private void get印字様式(FurikomiMeisaiIchiranDetailReportSource source) {
        PrintNoKingakuEntity data = 一覧表用データ.get印字様式番号別金額List().get(0);
        if (data.get印字様式名称() != null) {
            if (data.get印字様式名称().length() <= LISTINDEX_4) {
                source.listUpper_12 = data.get印字様式名称();
            } else {
                source.listUpper_12 = data.get印字様式名称().substring(0, LISTINDEX_4);
            }
        }
    }

    private void get振込明細(FurikomiMeisaiIchiranDetailReportSource source) {
        if (一覧表用データ.get振込明細一時TBL() != null) {
            PrintNoKingakuEntity 印字様式番号別金額 = 一覧表用データ.get印字様式番号別金額List().get(0);

            source.listUpper_14 = DecimalFormatter.toコンマ区切りRString(印字様式番号別金額.get様式別集計金額(), 0);

        }
    }

    private void get印字様式名称(FurikomiMeisaiIchiranDetailReportSource source) {
        List<PrintNoKingakuEntity> 印字様式番号別金額List = 一覧表用データ.get印字様式番号別金額List();
        PrintNoKingakuEntity data = 印字様式番号別金額List.get(1);
        if (data.get印字様式名称() != null) {
            if (data.get印字様式名称().length() <= LISTINDEX_4) {
                source.listLower_7 = data.get印字様式名称();
            } else {
                source.listLower_7 = data.get印字様式名称().substring(0, LISTINDEX_4);
            }
        }
        if (data.get様式別集計金額() != null) {
            source.listLower_8 = 左カッコ;
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(data.get様式別集計金額(), 0);
            source.listLower_10 = 右カッコ;
        }
    }

    private void set様式連番_1のUpper支払方法_口座以外情報(FurikomiMeisaiIchiranDetailReportSource source, FurikomiDetailTempTableEntity 振込明細一時TBL) {
        if (!支払方法_口座.equals(一覧表用データ.get振込明細一時TBL().getShiharaiHohoKubunCode())) {
            if (振込明細一時TBL.getKinyuKikanCode() != null && 振込明細一時TBL.getKinyuKikanShitenCode() != null) {
                source.listUpper_4 = 振込明細一時TBL.getKinyuKikanCode().value().
                        concat(半角ハイフン).concat(振込明細一時TBL.getKinyuKikanShitenCode().value());
            }
            if (振込明細一時TBL.getKinyuKikanCode() != null) {
                source.listUpper_5 = 振込明細一時TBL.getKinyuKikanName();
            }

            source.listUpper_6 = 振込明細一時TBL.getYokinShubetsuName();
            source.listUpper_7 = 振込明細一時TBL.getKozaNo();
        }
    }

    private void set様式連番_1のLower支払方法_口座以外情報(FurikomiMeisaiIchiranDetailReportSource source, FurikomiDetailTempTableEntity 振込明細一時Data) {
        if (!支払方法_口座.equals(一覧表用データ.get振込明細一時TBL().getShiharaiHohoKubunCode())) {
            source.listLower_2 = 振込明細一時Data.getKinyuKikanShitenName();
            set様式連番_1のLower支払方法_口座名義人(source, 振込明細一時Data);
        }
    }

    private void set様式連番_1のLower支払方法_口座名義人(FurikomiMeisaiIchiranDetailReportSource source, FurikomiDetailTempTableEntity 振込明細一時Data) {
        if (振込明細一時Data.getKozaMeiginin() != null) {
            if (振込明細一時Data.getKozaMeiginin().value().length() <= LISTINDEX_24) {
                source.listLower_3 = 振込明細一時Data.getKozaMeiginin().value();
            } else {
                source.listLower_3 = 振込明細一時Data.getKozaMeiginin().value().substring(0, LISTINDEX_24);
            }
        }
    }

    private void set様式連番_1のLower支払方法_集計様式番号(FurikomiMeisaiIchiranDetailReportSource source,
            FurikomiDetailTempTableEntity 振込明細一時Data, PrintNoKingakuEntity data) {
        if (data.get集計様式番号() != null) {
            RString 集計様式番号 = data.get集計様式番号();
            if (集計様式番号.equals(NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.getコード())) {
                source.listLower_11 = 福祉用具;
            } else if (集計様式番号.equals(NyuryokuShikibetsuNoShokan3Keta.住宅改修費.getコード())) {
                source.listLower_11 = 住宅改修;
            } else if (振込明細一時Data.getDataKubun() != null && データ区分_1.equals(振込明細一時Data.getDataKubun())) {
                source.listLower_11 = 償還;
            } else if (振込明細一時Data.getDataKubun() != null && データ区分_2.equals(振込明細一時Data.getDataKubun())) {
                source.listLower_11 = 高額;
            }
        }
    }

    private void set様式連番_1のLower支払方法_印字様式名称(FurikomiMeisaiIchiranDetailReportSource source, PrintNoKingakuEntity data) {
        if (data.get印字様式名称() != null) {
            if (data.get印字様式名称().length() <= LISTINDEX_4) {
                source.listLower_7 = data.get印字様式名称();
            } else {
                source.listLower_7 = data.get印字様式名称().substring(0, LISTINDEX_4);
            }
        }
    }
}
