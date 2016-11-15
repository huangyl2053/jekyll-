/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表 のeditorクラスです。
 *
 * @reamsid_L DBC-2530-042 zhengshenlei
 */
public class SogojigyohiKagoMoshitateshojohoSofuBodyEditor implements ISogojigyohiKagoMoshitateshojohoSofuEditor {

    private final KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 送付一覧表データ;
    private final int 合計;
    private final boolean flag;
    private static final RString 合計件数タイトル = new RString("合計件数");
    private static final RString 件 = new RString("件");
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param 送付一覧表データ SogojigyohiKagoMoshitateshojohoSofuIchiranEntity
     * @param 合計 int
     * @param flag boolean
     * @param 連番 int
     */
    public SogojigyohiKagoMoshitateshojohoSofuBodyEditor(
            KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 送付一覧表データ,
            int 合計,
            boolean flag,
            int 連番) {
        this.送付一覧表データ = 送付一覧表データ;
        this.合計 = 合計;
        this.flag = flag;
        this.連番 = 連番;
    }

    @Override
    public SogojigyohiKagoMoshitateshojohoSofuSource edit(SogojigyohiKagoMoshitateshojohoSofuSource source) {
        source.listUpper_1 = new RString(連番);
        if (送付一覧表データ.getDbWT1731Entity().getJigyoshaNo() != null) {
            source.listUpper_2 = 送付一覧表データ.getDbWT1731Entity().getJigyoshaNo().value();
        }
        source.listUpper_3 = 送付一覧表データ.getDbWT1731Entity().getJigyoshaName();
        if (送付一覧表データ.getDbWT1731Entity().getHiHokenshaNo() != null) {
            source.listUpper_4 = 送付一覧表データ.getDbWT1731Entity().getHiHokenshaNo().value();
        }
        if (送付一覧表データ.getDbWT1001Entity().getShikibetsuCode() != null) {
            source.shikibetsuCode = 送付一覧表データ.getDbWT1001Entity().getShikibetsuCode().value();
        }
        source.listUpper_5 = 送付一覧表データ.getDbWT1001Entity().getKanaMeisho();
        source.listLower_1 = 送付一覧表データ.getDbWT1001Entity().getMeisho();
        source.listUpper_6 = 送付一覧表データ.getDbWT1731Entity().getServiceTeikyoYM().wareki()
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        source.listUpper_7 = get年月日(送付一覧表データ.getDbWT1731Entity().getMoshitateYMD());
        source.listUpper_8 = 送付一覧表データ.getDbWT1731Entity().getMoshitateJiyuCode();
        RString 申立事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.総合事業過誤申立事由_様式.getコード(),
                new Code(送付一覧表データ.getDbWT1731Entity().getMoshitateJiyuCode().substringEmptyOnError(0, 2)));
        source.listUpper_9 = 申立事由;

        申立事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.総合事業過誤申立事由_理由.getコード(),
                new Code(送付一覧表データ.getDbWT1731Entity().getMoshitateJiyuCode().substringEmptyOnError(
                                送付一覧表データ.getDbWT1731Entity().getMoshitateJiyuCode().length() - 2,
                                送付一覧表データ.getDbWT1731Entity().getMoshitateJiyuCode().length())));
        source.listLower_2 = 申立事由;
        if (flag) {
            source.gokeiKensuTitle = 合計件数タイトル;
            source.gokeiKensu = doカンマ編集(new Decimal(合計)).concat(件);
        }
        source.listUpper_11 = 送付一覧表データ.getDbWT1001Entity().getYubinNo();
        source.listUpper_12 = 送付一覧表データ.getDbWT1001Entity().getChoikiCode();
        source.listUpper_13 = 送付一覧表データ.getDbWT1001Entity().getGyoseikuCode();
        source.listUpper_14 = 送付一覧表データ.getDbWT1001Entity().getShimei50onKana();
        source.listUpper_15 = getColumnValue(送付一覧表データ.getDbWT1001Entity().getShichosonCode());
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                ReportKomokuEditorUtil.get非空文字列(source.listUpper_4));
        return source;
    }

    private RString get年月日(FlexibleDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
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
}
