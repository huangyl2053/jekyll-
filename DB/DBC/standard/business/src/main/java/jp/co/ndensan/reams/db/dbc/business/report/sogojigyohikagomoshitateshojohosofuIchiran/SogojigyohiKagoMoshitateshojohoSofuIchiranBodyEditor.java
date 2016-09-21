/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofuIchiran;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200046_総合事業費（経過措置）過誤申立書情報送付一覧表 BodyEditorクラスです。
 *
 * @reamsid_L DBC-2530-041 liuxiaoyu
 */
public class SogojigyohiKagoMoshitateshojohoSofuIchiranBodyEditor implements ISogojigyohiKagoMoshitateshojohoSofuIchiranEditor {

    private final KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 帳票出力対象データ;
    private final boolean 合計出力flag;
    private final int 件数;

    private int 連番 = 1;
    private static final int NUM_0 = 0;
    private static final RString 合計件数 = new RString("合計件数");
    private static final RString 漢字_件 = new RString("件");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity
     * @param 合計出力flag boolean
     * @param 件数 int
     */
    public SogojigyohiKagoMoshitateshojohoSofuIchiranBodyEditor(
            KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 帳票出力対象データ, boolean 合計出力flag, int 件数) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.合計出力flag = 合計出力flag;
        this.件数 = 件数;
    }

    @Override
    public SogojigyohiKagoMoshitateshojohoSofuIchiranSource edit(SogojigyohiKagoMoshitateshojohoSofuIchiranSource source) {
        DbWT1731KagoMoshitateTempEntity 過誤申立一時TBL = 帳票出力対象データ.getDbWT1731Entity();
        DbWT1001HihokenshaTempEntity 被保険者一時TBL = 帳票出力対象データ.getDbWT1001Entity();
        source.listUpper_1 = new RString(連番);
        source.listUpper_2 = 過誤申立一時TBL.getJigyoshaNo().getColumnValue();
        source.listUpper_3 = 過誤申立一時TBL.getJigyoshaName();

        source.listUpper_4 = 過誤申立一時TBL.getHiHokenshaNo().getColumnValue();
        source.listUpper_5 = 被保険者一時TBL.getKanaMeisho();

        source.listLower_1 = 被保険者一時TBL.getMeisho();
        source.listUpper_6 = doパターン54(過誤申立一時TBL.getServiceTeikyoYM());
        source.listUpper_7 = 過誤申立一時TBL.getMoshitateYMD().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();

        RString jiyuCode = 過誤申立一時TBL.getMoshitateJiyuCode();
        source.listUpper_8 = jiyuCode;

        RString 申立事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.過誤申立事由_上２桁_様式番号.getコード(),
                new Code(jiyuCode.substringEmptyOnError(0, 2)));
        source.listUpper_9 = 申立事由;

        申立事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.過誤申立事由コード_下２桁_申立理由.getコード(),
                new Code(jiyuCode.substringEmptyOnError(jiyuCode.length() - 2, jiyuCode.length())));
        source.listLower_2 = 申立事由;
        source.listUpper_11 = 被保険者一時TBL.getYubinNo();
        source.listUpper_12 = 被保険者一時TBL.getChoikiCode();
        source.listUpper_13 = 被保険者一時TBL.getGyoseikuCode();
        source.listUpper_14 = 被保険者一時TBL.getShimei50onKana();
        source.listUpper_15 = getColumnValue(被保険者一時TBL.getShichosonCode());
        source.shikibetsuCode = 被保険者一時TBL.getShikibetsuCode().getColumnValue();
        if (合計出力flag) {
            source.gokeiKensuTitle = 合計件数;
            source.gokeiKensu = DecimalFormatter.toコンマ区切りRString(new Decimal(件数), NUM_0).concat(漢字_件);
        }
        連番++;
        return source;
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
