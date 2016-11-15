/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekitorikomiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.definition.core.keikoku.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekitorikomiichiran.KyufujissekiTorikomiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufujissekitorikomiichiran.KyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200007_給付実績情報取込結果一覧表のEditorrクラスです。
 *
 * @reamsid_L DBC-2440-030 qinzhen
 */
public class KyufujissekiTorikomiIchiranEditor implements
        IKyufujissekiTorikomiIchiranEditor {

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    private static final int INDEX_0 = 0;
    private static final int INDEX_16 = 16;
    private static final int INDEX_8 = 8;

    private static final int レコード値_0 = 0;
    private static final int レコード値_1 = 1;

    private static final int LENGTH_9 = 9;
    private static final int LENGTH_17 = 17;

    private static final RString 中空まる = new RString("○");
    private static final RString 環まる = new RString("◎");
    private static final RString ソリッドまる = new RString("●");
    private static final RString 日時作成 = new RString("作成");
    private static final RString 件タイトル = new RString("件");
    private static final RString 合計件数タイトル = new RString("合計件数");
    private static final RString 事業者名不明タイトル = new RString(" 事業者名不明");
    private static final Code CODE = new Code("0003");
    private static final RString NAME = new RString("被保険者番号");

    private final List<RString> 改頁リスト;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final FlexibleYearMonth 処理年月;
    private final YMDHMS 作成日時;
    private final int 連番;
    private final boolean 集計flag;
    private final int 合計件数;
    private final KyufujissekiTorikomiIchiranEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuGassanDataEntity
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     * @param 集計flag boolean
     * @param 合計件数 int
     */
    public KyufujissekiTorikomiIchiranEditor(KyufujissekiTorikomiIchiranEntity entity, RString 並び順の１件目, RString 並び順の２件目,
            RString 並び順の３件目, RString 並び順の４件目, RString 並び順の５件目,
            List<RString> 改頁リスト, FlexibleYearMonth 処理年月, YMDHMS 作成日時, int 連番, boolean 集計flag, int 合計件数) {
        this.entity = entity;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
        this.集計flag = 集計flag;
        this.合計件数 = 合計件数;

    }

    @Override
    public KyufujissekiTorikomiIchiranSource edit(KyufujissekiTorikomiIchiranSource source) {

        source.printTimeStamp = getSakuseiYmhm(作成日時.getRDateTime());
        source.torikomiYM = 処理年月.wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        source.hokenshaNo = entity.get給付実績_保険者番号().value();
        source.hokenshaName = entity.get給付実績_保険者名();

        source.shutsuryokujun1 = 並び順の１件目;
        source.shutsuryokujun2 = 並び順の２件目;
        source.shutsuryokujun3 = 並び順の３件目;
        source.shutsuryokujun4 = 並び順の４件目;
        source.shutsuryokujun5 = 並び順の５件目;
        source.kaiPege1 = get改頁(INDEX_1);
        source.kaiPege2 = get改頁(INDEX_2);
        source.kaiPege3 = get改頁(INDEX_3);
        source.kaiPege4 = get改頁(INDEX_4);
        source.kaiPege5 = get改頁(INDEX_5);

        source.listUpper_1 = new RString(連番);
        source.listUpper_2 = entity.get給付実績_入力識別番号();
        if (entity.get給付実績_入力識別名称() != null) {
            if (entity.get給付実績_入力識別名称().length() < LENGTH_9) {
                source.listUpper_3 = entity.get給付実績_入力識別名称();
            } else if (entity.get給付実績_入力識別名称().length() < LENGTH_17) {
                source.listUpper_3 = entity.get給付実績_入力識別名称().substring(INDEX_0, INDEX_8);
                source.listLower_1 = entity.get給付実績_入力識別名称().substring(INDEX_8);
            } else {
                source.listUpper_3 = entity.get給付実績_入力識別名称().substring(INDEX_0, INDEX_8);
                source.listLower_1 = entity.get給付実績_入力識別名称().substring(INDEX_8, INDEX_16);
            }
        }
        source.listUpper_4 = get作成区分(entity, DBCCodeShubetsu.給付実績情報作成区分.getコード());

        if (entity.get被保険者_登録被保険者番号() != null) {
            source.listUpper_5 = entity.get被保険者_登録被保険者番号().value();
        }

        source.listUpper_6 = entity.get被保険者_宛名カナ名称();
        if (entity.get給付実績_サービス提供年月() != null) {
            source.listUpper_7 = entity.get給付実績_サービス提供年月().wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }

        source.listUpper_8 = get給付実績区分(entity, DBCCodeShubetsu.給付実績区分.getコード());
        if (entity.get給付実績_事業所番号() != null) {
            source.listUpper_9 = entity.get給付実績_事業所番号().value();
        }

        source.listUpper_10 = entity.get給付実績_整理番号();

        source.listUpper_11 = getレコード種別(entity.get給付実績_レコード件数H1());
        if (レコード値_1 <= entity.get給付実績_レコード件数D1()) {
            if (レコード値_1 <= entity.get給付実績_レコード件数DD()) {
                source.listUpper_12 = 環まる;
            } else if (entity.get給付実績_レコード件数DD() == レコード値_0) {
                source.listUpper_12 = 中空まる;
            }
        } else if (entity.get給付実績_レコード件数D1() == レコード値_0 && レコード値_1 <= entity.get給付実績_レコード件数DD()) {
            source.listUpper_12 = ソリッドまる;

        }

        source.listUpper_13 = getレコード種別(entity.get給付実績_レコード件数D2());
        source.listUpper_14 = getレコード種別(entity.get給付実績_レコード件数D3());
        source.listUpper_15 = getレコード種別(entity.get給付実績_レコード件数D4());
        source.listUpper_16 = getレコード種別(entity.get給付実績_レコード件数D5());
        source.listUpper_17 = getレコード種別(entity.get給付実績_レコード件数D6());
        source.listUpper_18 = getレコード種別(entity.get給付実績_レコード件数D7());
        if (レコード値_1 <= entity.get給付実績_レコード件数D8() || レコード値_1 <= entity.get給付実績_レコード件数DE()) {
            source.listUpper_19 = 中空まる;
        }

        source.listUpper_20 = getレコード種別(entity.get給付実績_レコード件数T1());
        source.listUpper_21 = getレコード種別(entity.get給付実績_レコード件数D9());
        source.listUpper_22 = getレコード種別(entity.get給付実績_レコード件数DA());
        source.listUpper_23 = getレコード種別(entity.get給付実績_レコード件数DB());
        source.listUpper_24 = getレコード種別(entity.get給付実績_レコード件数DC());
        if (!KeikokuKubun.警告なし.getコード().equals(entity.get給付実績_警告区分コード())) {
            source.listUpper_25 = KeikokuKubun.警告あり.get略称();
        }

        source.listLower_2 = entity.get被保険者_宛名名称();
        if (!entity.get給付実績_事業所番号().value().isEmpty()) {
            if (entity.get給付実績_事業者名称().isEmpty()) {
                source.listLower_3 = 事業者名不明タイトル;
            } else {
                source.listLower_3 = entity.get給付実績_事業者名称();
            }

        } else {
            source.listLower_3 = RString.EMPTY;
        }
        if (集計flag) {
            source.gokeiKensuTitle = 合計件数タイトル;
            source.gokeiKensu = DecimalFormatter.toコンマ区切りRString(new Decimal(合計件数), 0).concat(件タイトル);
        }

        if (entity != null && entity.get識別コード() != null) {
            source.shikibetsuCode = entity.get識別コード();
        } else {
            source.shikibetsuCode = RString.EMPTY;
        }
        if (entity.get給付実績_保険者番号() != null) {
            source.hokenshaNo = entity.get給付実績_保険者番号().getColumnValue();
        }
        source.yubinNo = entity.get被保険者_郵便番号();
        source.choikiCode = entity.get被保険者_町域コード();
        source.gyoseikuCode = entity.get被保険者_行政区コード();
        source.shimei50onKana = entity.get被保険者_氏名50音カナ();
        source.shichosonCode = entity.get被保険者_市町村コード();
        source.kyufuJissekiKubun = entity.get給付実績_給付実績区分();
        source.拡張情報 = new ExpandedInformation(CODE, NAME,
                ReportKomokuEditorUtil.get非空文字列(source.listUpper_5));
        return source;

    }

    private RString getSakuseiYmhm(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }

    private RString get作成区分(KyufujissekiTorikomiIchiranEntity entity, CodeShubetsu code) {
        if (entity.get給付実績_情報作成区分コード() != null) {
            return CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, code,
                    new Code(entity.get給付実績_情報作成区分コード()));
        }
        return RString.EMPTY;
    }

    private RString get給付実績区分(KyufujissekiTorikomiIchiranEntity entity, CodeShubetsu code) {
        if (entity.get給付実績_給付実績区分() != null) {
            return CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, code,
                    new Code(entity.get給付実績_給付実績区分()));
        }
        return RString.EMPTY;
    }

    private RString getレコード種別(int index) {
        if (index >= 1) {
            return 中空まる;
        }
        return RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }
}
