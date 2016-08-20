/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo;

import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin.HihokenshaKyufukanrihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 給付管理票取込結果一覧表帳票BodyEditor
 *
 * @reamsid_L DBC-2450-040 zhangrui
 */
public class KyufuKanrihyoTorikomiKekkaIchiranBodyEditor implements IKyufuKanrihyoTorikomiKekkaIchiranEditor {

    private final HihokenshaKyufukanrihyoEntity 帳票出力対象データ;
    private final DonyuKeitaiCode 導入形態コード;
    private final boolean 集計Flag;
    private final int 連番;
    private final int 件数1;
    private final int 件数2;
    private final int 件数3;
    private final int 合計件数;

    private static final int 字数_10 = 10;
    private static final int 字数_20 = 10;
    private static final RString から = new RString("～");
    private static final RString 居宅サービス計画作成区分コード_自己作成 = new RString("2");
    private static final RString 備考_支援事業者未登録 = new RString("2");
    private static final FlexibleYearMonth 基準サービス提供年月 = new FlexibleYearMonth("200604");

    private static final RString 件数1タイトル = new RString("訪問通所");
    private static final RString 件数2タイトル = new RString("短期入所");
    private static final RString 件数3タイトル = new RString("居宅");
    private static final RString 合計件数タイトル = new RString("合計");
    private static final RString 漢字_件 = new RString("件");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ HihokenshaKyufukanrihyoEntity
     * @param 導入形態コード DonyuKeitaiCode
     * @param 集計Flag boolean
     * @param 連番 int
     * @param 件数1 int
     * @param 件数2 int
     * @param 件数3 int
     * @param 合計件数 int
     */
    public KyufuKanrihyoTorikomiKekkaIchiranBodyEditor(HihokenshaKyufukanrihyoEntity 帳票出力対象データ,
            DonyuKeitaiCode 導入形態コード, boolean 集計Flag, int 連番, int 件数1, int 件数2, int 件数3, int 合計件数) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.導入形態コード = 導入形態コード;
        this.集計Flag = 集計Flag;
        this.連番 = 連番;
        this.件数1 = 件数1;
        this.件数2 = 件数2;
        this.件数3 = 件数3;
        this.合計件数 = 合計件数;
    }

    @Override
    public KyufuKanrihyoTorikomiKekkaIchiranSource edit(KyufuKanrihyoTorikomiKekkaIchiranSource source) {
        edit明細(source);
        if (集計Flag) {
            edit集計(source);
        }
        return source;
    }

    private void edit明細(KyufuKanrihyoTorikomiKekkaIchiranSource source) {
        DbWT1121KyufuKanrihyoTempEntity 給付管理票 = 帳票出力対象データ.get給付管理票();
        DbWT0001HihokenshaTempEntity 被保険者 = 帳票出力対象データ.get被保険者();
        source.listCenter_1 = new RString(連番);
        source.listCenter_2 = doパターン54(給付管理票.getサービス提供年月());
        if (!RString.isNullOrEmpty(給付管理票.get給付管理票情報作成区分コード())) {
            RString 作成区分名 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.給付管理票情報作成区分.getコード(),
                    new Code(給付管理票.get給付管理票情報作成区分コード()));
            source.listCenter_3 = 作成区分名;
        }
        source.listCenter_4 = getColumnValue(被保険者.get登録被保険者番号());
        if (!RString.isNullOrEmpty(給付管理票.get給付管理票種別区分コード())) {
            RString 作成種別区分名 = CodeMaster.getOption2(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.給付管理票種別区分.getコード(),
                    new Code(給付管理票.get給付管理票種別区分コード()));
            source.listCenter_5 = 作成種別区分名;
        }
        IYokaigoJotaiKubun 要介護状態区分 = YokaigoJotaiKubunSupport.toValue(給付管理票.getサービス提供年月(),
                給付管理票.get要介護状態区分コード());
        if (null != 要介護状態区分) {
            source.listCenter_6 = 要介護状態区分.getName();
        }
        source.listCenter_7 = doパターン54(給付管理票.get限度額適用開始年月());
        if ((null != 給付管理票.get限度額適用開始年月()
                && !FlexibleYearMonth.EMPTY.equals(給付管理票.get限度額適用開始年月()))
                || (null != 給付管理票.get限度額適用終了年月()
                && !FlexibleYearMonth.EMPTY.equals(給付管理票.get限度額適用終了年月()))) {
            source.listCenter_8 = から;
        }
        source.listCenter_9 = doパターン54(給付管理票.get限度額適用終了年月());
        source.listCenter_10 = doカンマ編集(給付管理票.get居宅_介護予防支給限度額());
        if (null != 給付管理票.getサービス提供年月() && 給付管理票.getサービス提供年月().isBefore(基準サービス提供年月)) {
            source.listCenter_11 = doカンマ編集(給付管理票.get指定サービス分小計());
            source.listCenter_12 = doカンマ編集(給付管理票.get基準該当サービス分小計());
        }

        source.listCenter_13 = doカンマ編集(給付管理票.get給付計画合計単位数_日数());
        RString 計画作成区分コード = 給付管理票.get居宅サービス計画作成区分コード();
        if (居宅サービス計画作成区分コード_自己作成.equals(計画作成区分コード)) {
            source.listUpper_1 = RString.EMPTY;
            source.listUpper_2 = 給付管理票.get居宅支援事業所番号();
        } else {
            JukyushaIF_KeikakuSakuseiKubunCode 居宅サービス計画作成区分
                    = JukyushaIF_KeikakuSakuseiKubunCode.toValue(給付管理票.get居宅サービス計画作成区分コード());
            source.listUpper_1 = (null != 居宅サービス計画作成区分) ? 居宅サービス計画作成区分.get名称() : RString.EMPTY;
            source.listUpper_2 = RString.EMPTY;
            source.listLower_1 = 給付管理票.get事業者名称();
        }
        if (null != 被保険者.get宛名名称()) {
            source.listUpper_3 = 被保険者.get宛名名称().substringReturnAsPossible(0, 字数_10);
            source.listLower_2 = 被保険者.get宛名名称().substringReturnAsPossible(字数_10, 字数_20);
        }
        if (!居宅サービス計画作成区分コード_自己作成.equals(計画作成区分コード)
                && RString.isNullOrEmpty(給付管理票.get事業者名称())) {
            source.listUpper_4 = 備考_支援事業者未登録;
        }
        if (導入形態コード.is広域()) {
            source.listLower_3 = getColumnValue(被保険者.get証記載保険者番号());
        }
    }

    private void edit集計(KyufuKanrihyoTorikomiKekkaIchiranSource source) {
        source.kensu1Title = 件数1タイトル;
        source.kensu2Title = 件数2タイトル;
        source.kensu3Title = 件数3タイトル;
        source.gokeiKensuTitle = 合計件数タイトル;
        source.kensu1 = doカンマ編集(new Decimal(件数1)).concat(漢字_件);
        source.kensu2 = doカンマ編集(new Decimal(件数2)).concat(漢字_件);
        source.kensu3 = doカンマ編集(new Decimal(件数3)).concat(漢字_件);
        source.gokeiKensu = doカンマ編集(new Decimal(合計件数)).concat(漢字_件);

    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IValueObject<RString> column) {
        return (null == column) ? RString.EMPTY : column.value();
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null == decimal) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(decimal, 0);
    }

}
