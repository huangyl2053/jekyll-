/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigokyufuhikagomoshitateshoout;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomoshitateshoout.KyufuKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200045_給付過誤申立書情報送付一覧表BodyEditorクラスです
 *
 * @reamsid_L DBC-2530-040 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutBodyEditor implements IKaigokyufuhiKagoMoshitateshoOutEditor {

    private final KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 帳票出力対象データ;
    private final boolean 合計出力flag;
    private final int 件数;
    private final int 連番;

    private static final RString 合計件数 = new RString("合計件数");
    private static final RString 漢字_件 = new RString("件");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiShinsaKetteiSeikyumeisaihyoEntity
     * @param 合計出力flag boolean
     * @param 件数 int
     * @param 連番 int
     */
    public KaigokyufuhiKagoMoshitateshoOutBodyEditor(KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 帳票出力対象データ, boolean 合計出力flag,
            int 件数, int 連番
    ) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.合計出力flag = 合計出力flag;
        this.件数 = 件数;
        this.連番 = 連番;
    }

    @Override
    public KyufuKagoMoshitateshojohoSofuIchiranSource edit(KyufuKagoMoshitateshojohoSofuIchiranSource source) {
        source.listUpper_1 = new RString(連番);
        source.listUpper_2 = 帳票出力対象データ.getDbWT1731Entity().getJigyoshaNo().getColumnValue();
        source.listUpper_3 = 帳票出力対象データ.getDbWT1731Entity().getJigyoshaName();
        source.listUpper_4 = 帳票出力対象データ.getDbWT1731Entity().getHiHokenshaNo().getColumnValue();
        source.listUpper_5 = 帳票出力対象データ.getDbWT1001Entity().getKanaMeisho();
        source.listLower_1 = 帳票出力対象データ.getDbWT1001Entity().getMeisho();
        source.listUpper_6 = doパターン54(帳票出力対象データ.getDbWT1731Entity().getServiceTeikyoYM());
        source.listUpper_7 = 帳票出力対象データ.getDbWT1731Entity().getMoshitateYMD().wareki()
                .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();

        RString jiyuCode = 帳票出力対象データ.getDbWT1731Entity().getMoshitateJiyuCode();
        source.listUpper_8 = jiyuCode;

        RString 申立事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.過誤申立事由_上２桁_様式番号.getコード(),
                new Code(jiyuCode.substringEmptyOnError(0, 2)));
        source.listUpper_9 = 申立事由;

        申立事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.過誤申立事由コード_下２桁_申立理由.getコード(),
                new Code(jiyuCode.substringEmptyOnError(jiyuCode.length() - 2, jiyuCode.length())));
        source.listLower_2 = 申立事由;
        source.listUpper_11 = 帳票出力対象データ.getDbWT1001Entity().getYubinNo();
        source.listUpper_12 = 帳票出力対象データ.getDbWT1001Entity().getChoikiCode();
        source.listUpper_13 = 帳票出力対象データ.getDbWT1001Entity().getGyoseikuCode();
        source.listUpper_14 = 帳票出力対象データ.getDbWT1001Entity().getShimei50onKana();
        source.listUpper_15 = getColumnValue(帳票出力対象データ.getDbWT1001Entity().getShichosonCode());
        source.shikibetsuCode = getColumnValue(帳票出力対象データ.getDbWT1001Entity().getShikibetsuCode());
        if (合計出力flag) {
            source.gokeiKensuTitle = 合計件数;
            source.gokeiKensu = doカンマ編集(new Decimal(件数)).concat(漢字_件);
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), source.listUpper_4);
        setPageBreakEmpty(source);
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

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private void setPageBreakEmpty(KyufuKagoMoshitateshojohoSofuIchiranSource source) {
        if (source.shokisaiHokenshaNo == null) {
            source.shokisaiHokenshaNo = RString.EMPTY;
        }
        if (source.listUpper_11 == null) {
            source.listUpper_11 = RString.EMPTY;
        }
        if (source.listUpper_12 == null) {
            source.listUpper_12 = RString.EMPTY;
        }
        if (source.listUpper_13 == null) {
            source.listUpper_13 = RString.EMPTY;
        }
        if (source.listUpper_14 == null) {
            source.listUpper_14 = RString.EMPTY;
        }
        if (source.listUpper_15 == null) {
            source.listUpper_15 = RString.EMPTY;
        }
        if (source.listUpper_4 == null) {
            source.listUpper_4 = RString.EMPTY;
        }
        if (source.listUpper_2 == null) {
            source.listUpper_2 = RString.EMPTY;
        }
        if (source.listUpper_6 == null) {
            source.listUpper_6 = RString.EMPTY;
        }
    }

}
