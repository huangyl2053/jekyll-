/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyutsuchishotorikomiichiran;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuChohyoParameter;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200039_高額合算支給不支給決定通知書情報取込一覧表のEditorrクラスです。
 *
 * @reamsid_L DBC-2690-030 qinzhen
 */
public class GassanShikyuTsuchishoTorikomiIchiranEditor implements
        IGassanShikyuTsuchishoTorikomiIchiranEditor {

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString 支給 = new RString("1");
    private static final RString 窓口払 = new RString("1");
    private static final RString 口座払 = new RString("2");
    private static final RString 作成 = new RString("作成");
    private static final RString KEY_並び順の１件目 = new RString("KEY_並び順の１件目");
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private final ShikyuFushikyuChohyoParameter entity;

    /**
     * コンストラクタです
     *
     * @param entity ShikyuFushikyuChohyoParameter
     *
     */
    public GassanShikyuTsuchishoTorikomiIchiranEditor(ShikyuFushikyuChohyoParameter entity) {
        this.entity = entity;

    }

    @Override
    public GassanShikyuTsuchishoTorikomiIchiranSource edit(GassanShikyuTsuchishoTorikomiIchiranSource source) {

        DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 計算結果entity = entity.get帳票出力対象().get決定データ();

        source.printTimeStamp = getSakuseiYmhm(entity.get作成日時());
        source.torikomiYM = entity.get処理年月().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.hokenshaNo = entity.get保険者番号();
        source.hokenshaName = entity.get保険者名();

        source.shutsuryokujun1 = entity.get出力順Map().get(KEY_並び順の１件目);
        source.shutsuryokujun2 = entity.get出力順Map().get(KEY_並び順の２件目);
        source.shutsuryokujun3 = entity.get出力順Map().get(KEY_並び順の３件目);
        source.shutsuryokujun4 = entity.get出力順Map().get(KEY_並び順の４件目);
        source.shutsuryokujun5 = entity.get出力順Map().get(KEY_並び順の５件目);

        source.kaipage1 = entity.get改頁リスト().get(NUM_0);
        source.kaipage2 = entity.get改頁リスト().get(NUM_1);
        source.kaipage3 = entity.get改頁リスト().get(NUM_2);
        source.kaipage4 = entity.get改頁リスト().get(NUM_3);
        source.kaipage5 = entity.get改頁リスト().get(NUM_4);

        source.listCenter_1 = new RString(entity.get連番());

        source.listUpper_1 = entity.get帳票出力対象().get被保険者().get登録被保険者番号().value();
        source.listUpper_2 = entity.get帳票出力対象().get被保険者().get宛名名称();

        source.listUpper_3 = 計算結果entity.get支給申請書整理番号();
        source.listUpper_4 = new FlexibleDate(計算結果entity.get申請年月日()).wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        source.listCenter_2 = ShikyuFushikyuKubun.toValue(計算結果entity.get支給区分コード()).get名称();

        if (計算結果entity.get自己負担総額() != null) {
            source.listUpper_5 = DecimalFormatter.toコンマ区切りRString(計算結果entity.get自己負担総額(), 0);
        }
        if (計算結果entity.get支給区分コード().equals(支給)) {
            source.listCenter_3 = ShiharaiHohoKubun.toValue(計算結果entity.get支払方法区分()).get名称();
            if (計算結果entity.get支払方法区分().equals(窓口払)) {
                source.listUpper_6 = 計算結果entity.get支払場所();
                source.listLower_6 = getlistLower_6(new FlexibleDate(計算結果entity.get支払期間開始年月日()), new RTime(計算結果entity.get支払期間開始時間()),
                        new FlexibleDate(計算結果entity.get支払期間終了年月日()), new RTime(計算結果entity.get支払期間終了時間()));
            } else if (計算結果entity.get支払方法区分().equals(口座払)) {

                source.listUpper_6 = getlistUpper_6(計算結果entity.get金融機関名(), 計算結果entity.get金融機関支店名());
                source.listLower_6 = getlistlower_6(計算結果entity.get口座種目名(), 計算結果entity.get口座番号(), 計算結果entity.get口座名義人_カナ());
            }
        } else {
            source.listUpper_6 = RString.EMPTY;
            source.listLower_6 = RString.EMPTY;
        }

        source.listLower_1 = new RString(計算結果entity.get履歴番号());
        source.listLower_2 = listLower_2(entity.get帳票出力対象().get被保険者().get住所(), entity.get帳票出力対象().get被保険者().get番地(),
                entity.get帳票出力対象().get被保険者().get方書());

        FlexibleDate kaishiYMD = new FlexibleDate(計算結果entity.get対象計算期間開始年月日());
        FlexibleDate shuryoYMD = new FlexibleDate(計算結果entity.get対象計算期間終了年月日());

        source.listLower_3 = getlistLower_3(kaishiYMD, shuryoYMD);

        source.listLower_4 = new FlexibleDate(計算結果entity.get決定年月日()).wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString();

        if (計算結果entity.get支給額() != null) {
            source.listLower_5 = DecimalFormatter.toコンマ区切りRString(計算結果entity.get支給額(), 0);
        }

        return source;

    }

    private RString getSakuseiYmhm(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(作成);

        return sakuseiYMD.toRString();
    }

    private RString getlistLower_3(FlexibleDate kaishiYMD, FlexibleDate shuryoYMD) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(kaishiYMD.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString());
        sakuseiYMD.append(new RString("～"));
        sakuseiYMD.append(shuryoYMD.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString());

        return sakuseiYMD.toRString();
    }

    private RString getlistUpper_6(RString kinyuKikanMei, RString kinyuKikanShitenMei) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(kinyuKikanMei);
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(kinyuKikanShitenMei);

        return sakuseiYMD.toRString();
    }

    private RString getlistLower_6(FlexibleDate kaishiYMD, RTime kaishiTime, FlexibleDate shuryoYMD, RTime shuryoTime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(kaishiYMD.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString());
        sakuseiYMD.append(new RString("("));
        sakuseiYMD.append(kaishiYMD.getDayOfWeek().getShortTerm());
        sakuseiYMD.append(new RString(")"));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(kaishiTime.toFormattedTimeString(DisplayTimeFormat.HH_mm));
        sakuseiYMD.append(new RString("～"));
        sakuseiYMD.append(shuryoYMD.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString());
        sakuseiYMD.append(new RString("("));
        sakuseiYMD.append(shuryoYMD.getDayOfWeek().getShortTerm());
        sakuseiYMD.append(new RString(")"));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(shuryoTime.toFormattedTimeString(DisplayTimeFormat.HH_mm));

        return sakuseiYMD.toRString();
    }

    private RString getlistlower_6(RString kozaShumokuMei, RString kozaNo, RString kozaMeiginin) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(kozaShumokuMei);
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(kozaNo);
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(kozaMeiginin);

        return sakuseiYMD.toRString();
    }

    private RString listLower_2(RString jusho, RString banchi, RString katagaki) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(jusho);
        sakuseiYMD.append(banchi);
        sakuseiYMD.append(RString.FULL_SPACE);
        sakuseiYMD.append(katagaki);

        return sakuseiYMD.toRString();
    }
}
