/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujisekijohosofuichiran;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyuufujisekikoshinnkekka.KyuufuJisekiKoshinnKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200053_給付実績情報送付一覧表　BodyEditorクラスです。
 *
 * @reamsid_L DBC-2460-030 lijian
 */
public class KyufuJisekiJohoSofuIchiranBodyEditor implements IKyufuJisekiJohoSofuIchiranEditor {

    private final KyuufuJisekiKoshinnKekkaEntity 給付実績更新結果一覧表データ;
    private static final RString 合計件数タイトル = new RString("合計件数");
    private static final RString 件数 = new RString("件");
    private static final RString 中空まる = new RString("○");
    private static final RString ソリッドまる = new RString("●");
    private static final RString 環まる = new RString("◎");
    private static final RString 事業者名_事業者名不明 = new RString("事業者名不明");
    private static final int LENGTH_ZERO = 0;
    private static final int LENGTH_EIGHT = 8;
    private static final int LENGTH_SISTEEN = 16;
    private static final int レコード値_ONE = 1;
    private static final int レコード値_ZERO = 0;
    private final boolean 合計フラグ;
    private final Decimal 合計件数;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 給付実績更新結果一覧表データ KyuufuJisekiKoshinnKekkaEntity
     * @param 合計フラグ boolean
     * @param 合計件数 Decimal
     * @param 連番 int
     */
    public KyufuJisekiJohoSofuIchiranBodyEditor(
            KyuufuJisekiKoshinnKekkaEntity 給付実績更新結果一覧表データ,
            boolean 合計フラグ,
            Decimal 合計件数,
            int 連番) {

        this.給付実績更新結果一覧表データ = 給付実績更新結果一覧表データ;
        this.合計フラグ = 合計フラグ;
        this.合計件数 = 合計件数;
        this.連番 = 連番;
    }

    @Override
    public KyufuJisekiJohoSofuIchiranSource edit(KyufuJisekiJohoSofuIchiranSource source) {

        DbWT1111KyufuJissekiTempEntity 給付実績一時 = 給付実績更新結果一覧表データ.get給付実績一時Entity();

        source.listUpper_1 = new RString(連番);

        set入力識別名称と明細(給付実績一時, source);

        if (給付実績一時.get入力識別番号() != null) {
            source.listUpper_2 = 給付実績一時.get入力識別番号().value();
        }

        source.listUpper_4 = get作成区分(給付実績一時, DBCCodeShubetsu.給付実績情報作成区分.getコード());

        DbWT1001HihokenshaTempEntity 被保険者一時 = 給付実績更新結果一覧表データ.get被保険者一時Entity();

        if (被保険者一時.getShikibetsuCode() != null) {
            source.shikibetsuCode = 被保険者一時.getShikibetsuCode().value();
        }

        if (被保険者一時.getExHihokenshaNo() != null) {
            source.listUpper_5 = 被保険者一時.getExHihokenshaNo().value();
        }

        source.listUpper_6 = 被保険者一時.getKanaMeisho();
        if (給付実績一時.getサービス提供年月() != null) {
            source.listUpper_7 = 給付実績一時.getサービス提供年月().wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.listUpper_8 = get給付実績区分(給付実績一時, DBCCodeShubetsu.給付実績区分.getコード());

        if (給付実績一時.get事業所番号() != null) {
            source.listUpper_9 = 給付実績一時.get事業所番号().value();
        }

        source.listUpper_10 = 給付実績一時.get整理番号();

        source.listUpper_11 = getレコード種別(給付実績一時.get件数_H1());

        source.listUpper_13 = getレコード種別(給付実績一時.get件数_D2());
        source.listUpper_14 = getレコード種別(給付実績一時.get件数_D3());
        source.listUpper_15 = getレコード種別(給付実績一時.get件数_D4());
        source.listUpper_16 = getレコード種別(給付実績一時.get件数_D5());
        source.listUpper_17 = getレコード種別(給付実績一時.get件数_D6());
        source.listUpper_18 = getレコード種別(給付実績一時.get件数_D7());

        if (レコード値_ONE <= 給付実績一時.get件数_D8() || レコード値_ONE <= 給付実績一時.get件数_DE()) {
            source.listUpper_19 = 中空まる;
        } else if (給付実績一時.get件数_D8() == レコード値_ZERO && 給付実績一時.get件数_DE() == レコード値_ZERO) {
            source.listUpper_19 = RString.EMPTY;
        }

        source.listUpper_20 = getレコード種別(給付実績一時.get件数_T1());
        source.listUpper_21 = getレコード種別(給付実績一時.get件数_D9());
        source.listUpper_22 = getレコード種別(給付実績一時.get件数_DA());
        source.listUpper_23 = getレコード種別(給付実績一時.get件数_DC());

        source.listLower_2 = 被保険者一時.getMeisho();

        if (!給付実績一時.get事業所番号().isEmpty() && 給付実績一時.get事業者名称().isEmpty()) {
            source.listLower_3 = 事業者名_事業者名不明;
        } else {
            source.listLower_3 = 給付実績一時.get事業者名称();
        }

        if (合計フラグ) {
            source.gokeiKensuTitle = 合計件数タイトル;
            source.gokeiKensu = doカンマ編集(合計件数).concat(件数);
        }

        source.yubinNo = 被保険者一時.getYubinNo();
        source.choikiCode = 被保険者一時.getChoikiCode();
        source.gyoseikuCode = 被保険者一時.getGyoseikuCode();
        source.shimei50onKana = 被保険者一時.getShimei50onKana();
        if (被保険者一時.getShichosonCode() != null) {
            source.shichosonCode = 被保険者一時.getShichosonCode().value();
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                ReportKomokuEditorUtil.get非空文字列(source.listUpper_5));
        return source;
    }

    private void set入力識別名称と明細(
            DbWT1111KyufuJissekiTempEntity 給付実績一時,
            KyufuJisekiJohoSofuIchiranSource source) {

        RString 入力識別名称 = 給付実績一時.get入力識別名称();

        if (入力識別名称.length() <= LENGTH_EIGHT) {
            source.listUpper_3 = 入力識別名称;
            source.listLower_1 = RString.EMPTY;
        } else if (LENGTH_EIGHT < 入力識別名称.length() && 入力識別名称.length() <= LENGTH_SISTEEN) {
            source.listUpper_3 = 入力識別名称.substring(LENGTH_ZERO, LENGTH_EIGHT);
            source.listLower_1 = 入力識別名称.substring(LENGTH_EIGHT, 入力識別名称.length());
        } else {
            source.listUpper_3 = 入力識別名称.substring(LENGTH_ZERO, LENGTH_EIGHT);
            source.listLower_1 = 入力識別名称.substring(LENGTH_ZERO, LENGTH_SISTEEN);
        }

        if (レコード値_ONE <= 給付実績一時.get件数_D1() && レコード値_ONE <= 給付実績一時.get件数_DD()) {
            source.listUpper_12 = 環まる;
        } else if (レコード値_ONE <= 給付実績一時.get件数_D1() && 給付実績一時.get件数_DD() == レコード値_ZERO) {
            source.listUpper_12 = 中空まる;
        } else if (給付実績一時.get件数_D1() == レコード値_ZERO && レコード値_ONE <= 給付実績一時.get件数_DD()) {
            source.listUpper_12 = ソリッドまる;
        } else if (給付実績一時.get件数_D1() == レコード値_ZERO && 給付実績一時.get件数_DD() == レコード値_ZERO) {
            source.listUpper_12 = RString.EMPTY;
        }

    }

    private RString getレコード種別(int value) {
        if (レコード値_ONE <= value) {
            return 中空まる;
        }
        return RString.EMPTY;
    }

    private RString get作成区分(DbWT1111KyufuJissekiTempEntity 給付実績一時, CodeShubetsu code) {
        if (給付実績一時.get給付実績情報作成区分コード() != null) {
            return CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, code,
                    new Code(給付実績一時.get給付実績情報作成区分コード()));
        }
        return RString.EMPTY;
    }

    private RString get給付実績区分(DbWT1111KyufuJissekiTempEntity 給付実績一時, CodeShubetsu code) {
        if (給付実績一時.get給付実績区分() != null) {
            return CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, code,
                    new Code(給付実績一時.get給付実績区分()));
        }
        return RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

}
