/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.keikoku.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.chohyoshutsuryokutaishodate.ChohyoShutsuryokuTaishoDateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表 Editor
 *
 * @reamsid_L DBC-2470-030 surun
 */
public class KyufujissekiKoshinkekkaIchiranEditor implements IKyufujissekiKoshinkekkaIchiranEditor {

    private final FlexibleYearMonth 処理年月;
    private final ChohyoShutsuryokuTaishoDateEntity entity;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;
    private final YMDHMS システム日時;
    private final int 連番;
    private final boolean flag;
    private final int 合計;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_16 = 16;
    private static final int NUM_17 = 17;
    private static final RString NUM_ONE = new RString("1");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 図形_ONE = new RString("○");
    private static final RString 図形_TWO = new RString("◎");
    private static final RString 図形_THREE = new RString("●");
    private static final RString 事業者名不明_定数 = new RString("事業者名不明");
    private static final RString 合計件数タイトル = new RString("合計件数");

    /**
     * コンストラクタです
     *
     * @param 処理年月 FlexibleYearMonth
     * @param entity ChohyoShutsuryokuTaishoDateEntity
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     * @param システム日時 YMDHMS
     * @param 連番 int
     * @param flag boolean
     * @param 合計 int
     */
    public KyufujissekiKoshinkekkaIchiranEditor(
            FlexibleYearMonth 処理年月,
            ChohyoShutsuryokuTaishoDateEntity entity,
            RString 並び順の１件目,
            RString 並び順の２件目,
            RString 並び順の３件目,
            RString 並び順の４件目,
            RString 並び順の５件目,
            List<RString> 改頁項目List,
            YMDHMS システム日時,
            int 連番,
            boolean flag,
            int 合計) {
        this.処理年月 = 処理年月;
        this.entity = entity;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
        this.システム日時 = システム日時;
        this.連番 = 連番;
        this.flag = flag;
        this.合計 = 合計;
    }

    /**
     * 帳票設計_DBC200054_給付実績更新結果情報一覧表の項目編集です
     *
     * @param source KyufujissekiKoshinkekkaIchiranSource
     * @return KyufujissekiKoshinkekkaIchiranSource
     */
    @Override
    public KyufujissekiKoshinkekkaIchiranSource edit(KyufujissekiKoshinkekkaIchiranSource source) {
        RString 帳票作成年月日 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成時 = システム日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時)
                .concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.shoriYM = 処理年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        if (entity != null) {
            source.hokenshaNo = entity.get給付実績_コントロールレコード保険者番号();
            source.hokenshaName = entity.get給付実績_コントロールレコード保険者名();
            set出力順And改ページ(source);
            source.listUpper_1 = new RString(連番);
            source.listUpper_2 = entity.get給付実績_入力識別番号();
            source.listUpper_3 = entity.get給付実績_入力識別名称().substring(NUM_0, NUM_8);
            if (entity.get給付実績_給付実績情報作成区分コード() != null) {
                source.listUpper_4 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.給付実績情報作成区分.getコード(),
                        new Code(entity.get給付実績_給付実績情報作成区分コード()), FlexibleDate.getNowDate());
            }
            source.listUpper_5 = entity.get被保険者_登録被保険者番号();
            source.listUpper_6 = entity.get被保険者_宛名カナ名称();
            source.listUpper_7 = entity.get給付実績_サービス提供年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            if (entity.get給付実績_給付実績区分() != null) {
                source.listUpper_8 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.給付実績区分.getコード(),
                        new Code(entity.get給付実績_給付実績区分()), FlexibleDate.getNowDate());
            }
            source.listUpper_9 = entity.get給付実績_事業所番号();
            source.listUpper_10 = entity.get給付実績_整理番号();
            editor給付実績_レコード件数(source);
            editorAdd(source);
            editor集計(source);
        }
        return source;
    }

    private KyufujissekiKoshinkekkaIchiranSource editor給付実績_レコード件数(KyufujissekiKoshinkekkaIchiranSource source) {
        if (entity.get給付実績_レコード件数H1() >= NUM_1) {
            source.listUpper_11 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数D1() >= NUM_1
                && entity.get給付実績_レコード件数DD() >= NUM_1) {
            source.listUpper_12 = 図形_TWO;
        } else if (entity.get給付実績_レコード件数D1() >= NUM_1
                && entity.get給付実績_レコード件数DD() == NUM_0) {
            source.listUpper_12 = 図形_ONE;
        } else if (entity.get給付実績_レコード件数D1() == NUM_0
                && entity.get給付実績_レコード件数DD() >= NUM_1) {
            source.listUpper_12 = 図形_THREE;
        }
        if (entity.get給付実績_レコード件数D2() >= NUM_1) {
            source.listUpper_13 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数D3() >= NUM_1) {
            source.listUpper_14 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数D4() >= NUM_1) {
            source.listUpper_15 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数D5() >= NUM_1) {
            source.listUpper_16 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数D6() >= NUM_1) {
            source.listUpper_17 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数D7() >= NUM_1) {
            source.listUpper_18 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数D8() >= NUM_1) {
            source.listUpper_19 = 図形_ONE;
        } else if (entity.get給付実績_レコード件数DE() >= NUM_1) {
            source.listUpper_19 = 図形_ONE;
        } else if (entity.get給付実績_レコード件数D8() == NUM_0
                && entity.get給付実績_レコード件数DE() == NUM_0) {
            source.listUpper_19 = RString.EMPTY;
        }
        return source;
    }

    private KyufujissekiKoshinkekkaIchiranSource editor集計(KyufujissekiKoshinkekkaIchiranSource source) {
        if (flag) {
            source.gokeiKensuTitle = 合計件数タイトル;
            source.gokeiKensu = new RString(合計);
        }
        return source;
    }

    private KyufujissekiKoshinkekkaIchiranSource editorAdd(KyufujissekiKoshinkekkaIchiranSource source) {
        if (entity.get給付実績_レコード件数T1() >= NUM_1) {
            source.listUpper_20 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数D9() >= NUM_1) {
            source.listUpper_21 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数DA() >= NUM_1) {
            source.listUpper_22 = 図形_ONE;
        }
        if (entity.get給付実績_レコード件数DC() >= NUM_1) {
            source.listUpper_23 = 図形_ONE;
        }
        if (NUM_ONE.equals(entity.get給付実績_警告区分コード())) {
            source.listUpper_24 = RString.EMPTY;
        } else {
            source.listUpper_24 = KeikokuKubun.toValue(entity.get給付実績_警告区分コード()).get名称();
        }
        int 入力識別名称Length = entity.get給付実績_入力識別名称().length();
        if (入力識別名称Length >= NUM_9 && 入力識別名称Length < NUM_16) {
            source.listLower_1 = entity.get給付実績_入力識別名称().substring(NUM_8, 入力識別名称Length);
        } else if (入力識別名称Length >= NUM_16) {
            source.listLower_1 = entity.get給付実績_入力識別名称().substring(NUM_8, NUM_16);
        }
        int 宛名名称Length = entity.get被保険者_宛名名称().length();
        if (宛名名称Length < NUM_17) {
            source.listLower_2 = entity.get被保険者_宛名名称().substring(NUM_0, 宛名名称Length);
        } else {
            source.listLower_2 = entity.get被保険者_宛名名称().substring(NUM_0, NUM_17);
        }
        if (!entity.get給付実績_事業所番号().isEmpty() && entity.get給付実績_事業者名称().isEmpty()) {
            source.listLower_3 = 事業者名不明_定数;
        } else {
            source.listLower_3 = entity.get給付実績_事業者名称();
        }
        return source;
    }

    private void set出力順And改ページ(KyufujissekiKoshinkekkaIchiranSource source) {
        source.shutsuryokujun1 = 並び順の１件目;
        source.shutsuryokujun2 = 並び順の２件目;
        source.shutsuryokujun3 = 並び順の３件目;
        source.shutsuryokujun4 = 並び順の４件目;
        source.shutsuryokujun5 = 並び順の５件目;
        if (null != 改頁項目List && !改頁項目List.isEmpty()) {
            if (改頁項目List.size() > NUM_0) {
                source.kaipage1 = 改頁項目List.get(NUM_0);
            }
            if (改頁項目List.size() > NUM_1) {
                source.kaipage2 = 改頁項目List.get(NUM_1);
            }
            if (改頁項目List.size() > NUM_2) {
                source.kaipage3 = 改頁項目List.get(NUM_2);
            }
            if (改頁項目List.size() > NUM_3) {
                source.kaipage4 = 改頁項目List.get(NUM_3);
            }
            if (改頁項目List.size() > NUM_4) {
                source.kaipage5 = 改頁項目List.get(NUM_4);
            }
        }
    }
}
