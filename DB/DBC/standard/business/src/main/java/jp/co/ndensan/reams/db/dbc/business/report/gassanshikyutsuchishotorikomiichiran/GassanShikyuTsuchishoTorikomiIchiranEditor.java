/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyutsuchishotorikomiichiran;

import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuChohyoParameter;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
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
    private static final RString 日時作成 = new RString("作成");
    private static final RString 接続文字 = new RString("～");
    private static final RString 左カッコ = new RString("（");
    private static final RString 右カッコ = new RString("）");
    private static final RString 被保険者番号 = new RString("被保険者番号");
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
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get帳票出力対象().get被保険者();

        source.printTimeStamp = getSakuseiYmhm(entity.get作成日時());
        source.torikomiYM = entity.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.hokenshaNo = entity.get保険者番号();
        source.hokenshaName = entity.get保険者名();

        source.shutsuryokujun1 = get並び順(NUM_0);
        source.shutsuryokujun2 = get並び順(NUM_1);
        source.shutsuryokujun3 = get並び順(NUM_2);
        source.shutsuryokujun4 = get並び順(NUM_3);
        source.shutsuryokujun5 = get並び順(NUM_4);

        source.kaipage1 = get改頁(NUM_0);
        source.kaipage2 = get改頁(NUM_1);
        source.kaipage3 = get改頁(NUM_2);
        source.kaipage4 = get改頁(NUM_3);
        source.kaipage5 = get改頁(NUM_4);

        source.listCenter_1 = new RString(entity.get連番());
        source.listUpper_1 = getColumnValue(被保険者.get登録被保険者番号());
        source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                source.listUpper_1);

        source.listUpper_2 = 被保険者.get宛名名称();
        source.listLower_2 = listLower_2(被保険者.get住所(), 被保険者.get番地(), 被保険者.get方書());

        set規定外項目(source, 被保険者, 計算結果entity);
        source.listUpper_3 = get非空項目(計算結果entity.get支給申請書整理番号());
        source.listUpper_4 = new FlexibleDate(計算結果entity.get申請年月日()).wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        if (!RString.isNullOrEmpty(計算結果entity.get支給区分コード())) {
            source.listCenter_2 = ShikyuFushikyuKubun.toValue(計算結果entity.get支給区分コード()).get名称();
        }

        if (計算結果entity.get自己負担総額() != null) {
            source.listUpper_5 = DecimalFormatter.toコンマ区切りRString(計算結果entity.get自己負担総額(), 0);
        }
        if (支給.equals(計算結果entity.get支給区分コード())) {
            if (!RString.isNullOrEmpty(計算結果entity.get支払方法区分())) {
                source.listCenter_3 = ShiharaiHohoKubun.toValue(計算結果entity.get支払方法区分()).get名称();
            }
            if (窓口払.equals(計算結果entity.get支払方法区分())) {
                source.listUpper_6 = 計算結果entity.get支払場所();
                source.listLower_6 = getlistLower_6(new FlexibleDate(計算結果entity.get支払期間開始年月日()),
                        new RTime(計算結果entity.get支払期間開始時間()),
                        new FlexibleDate(計算結果entity.get支払期間終了年月日()),
                        new RTime(計算結果entity.get支払期間終了時間()));
            } else if (口座払.equals(計算結果entity.get支払方法区分())) {
                source.listUpper_6 = getlistUpper_6(計算結果entity.get金融機関名(), 計算結果entity.get金融機関支店名());
                source.listLower_6 = getlistlower_6(計算結果entity.get口座種目名(), 計算結果entity.get口座番号(),
                        計算結果entity.get口座名義人_カナ());
            }
        }

        source.listLower_1 = new RString(計算結果entity.get履歴番号());

        source.listLower_3 = getlistLower_3(new FlexibleDate(計算結果entity.get対象計算期間開始年月日()),
                new FlexibleDate(計算結果entity.get対象計算期間終了年月日()));

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
                fillType(FillType.BLANK).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);

        return sakuseiYMD.toRString();
    }

    private RString getlistLower_3(FlexibleDate kaishiYMD, FlexibleDate shuryoYMD) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(kaishiYMD.wareki().
                eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).
                toDateString());
        sakuseiYMD.append(接続文字);
        if (shuryoYMD != null && !shuryoYMD.isEmpty()) {
            sakuseiYMD.append(shuryoYMD.wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).
                    toDateString());
        }

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
        sakuseiYMD.append(左カッコ);
        sakuseiYMD.append(kaishiYMD.getDayOfWeek().getShortTerm());
        sakuseiYMD.append(右カッコ);
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(kaishiTime.toFormattedTimeString(DisplayTimeFormat.HH_mm));
        sakuseiYMD.append(接続文字);
        if (shuryoYMD != null && !shuryoYMD.isEmpty()) {
            sakuseiYMD.append(shuryoYMD.wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).
                    toDateString());
            sakuseiYMD.append(左カッコ);
            sakuseiYMD.append(shuryoYMD.getDayOfWeek().getShortTerm());
            sakuseiYMD.append(右カッコ);
            sakuseiYMD.append(RString.HALF_SPACE);
            sakuseiYMD.append(shuryoTime.toFormattedTimeString(DisplayTimeFormat.HH_mm));
        }
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

    private RString get改頁(int index) {
        return index < entity.get改頁リスト().size() ? entity.get改頁リスト().get(index) : RString.EMPTY;
    }

    private RString get並び順(int index) {
        return index < entity.get並び順リスト().size() ? entity.get並び順リスト().get(index) : RString.EMPTY;
    }

    private void set規定外項目(GassanShikyuTsuchishoTorikomiIchiranSource source, DbWT0001HihokenshaTempEntity 被保険者,
            DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 計算結果entity) {
        source.yubinNo = get非空項目(被保険者.get郵便番号());
        source.choikiCode = get非空項目(被保険者.get町域コード());
        source.gyoseikuCode = get非空項目(被保険者.get行政区コード());
        source.shimei50onKana = get非空項目(被保険者.get氏名50音カナ());
        source.shichosonCode = getColumnValue(被保険者.get市町村コード());
        source.taishoNendo = get非空項目(計算結果entity.get対象年度());
        source.shikyuKubunCode = get非空項目(計算結果entity.get支給区分コード());
        source.shikibetsuCode = get非空項目(被保険者.get識別コード());
        source.shoKisaiHokenshaNo = getColumnValue(計算結果entity.get保険者番号());
    }

    private RString get非空項目(RString 項目) {
        if (RString.isNullOrEmpty(項目)) {
            return RString.EMPTY;
        }
        return 項目;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
