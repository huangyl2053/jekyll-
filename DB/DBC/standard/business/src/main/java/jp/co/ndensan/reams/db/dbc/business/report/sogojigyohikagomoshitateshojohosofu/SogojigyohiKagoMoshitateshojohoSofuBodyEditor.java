/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表 のeditorクラスです。
 *
 * @reamsid_L DBC-2530-042 zhengshenlei
 */
public class SogojigyohiKagoMoshitateshojohoSofuBodyEditor implements ISogojigyohiKagoMoshitateshojohoSofuEditor {

    private final SogojigyohiKagoMoshitateshojohoSofuIchiranEntity 送付一覧表データ;
    private final int 連番;
    private final int 合計;
    private final boolean flag;
    private static final RString 合計件数タイトル = new RString("合計件数");
    private static final RString 件 = new RString("件");

    /**
     * コンストラクタです
     *
     * @param 送付一覧表データ SogojigyohiKagoMoshitateshojohoSofuIchiranEntity
     * @param 連番 int
     * @param 合計 int
     * @param flag boolean
     */
    public SogojigyohiKagoMoshitateshojohoSofuBodyEditor(
            SogojigyohiKagoMoshitateshojohoSofuIchiranEntity 送付一覧表データ,
            int 連番,
            int 合計,
            boolean flag) {
        this.送付一覧表データ = 送付一覧表データ;
        this.連番 = 連番;
        this.合計 = 合計;
        this.flag = flag;
    }

    @Override
    public SogojigyohiKagoMoshitateshojohoSofuSource edit(SogojigyohiKagoMoshitateshojohoSofuSource source) {
        DbWT1731KagoMoshitateTempEntity 過誤申立一時TBL = 送付一覧表データ.get過誤申立一時TBL();
        DbWT1001HihokenshaTempEntity 被保険者一時TBL = 送付一覧表データ.get被保険者一時TBL();
        source.listUpper_1 = new RString(連番);
        if (過誤申立一時TBL.getJigyoshaNo() != null) {
            source.listUpper_2 = 過誤申立一時TBL.getJigyoshaNo().value();
        }
        source.listUpper_3 = 過誤申立一時TBL.getJigyoshaName();
        if (過誤申立一時TBL.getHiHokenshaNo() != null) {
            source.listUpper_4 = 過誤申立一時TBL.getHiHokenshaNo().value();
        }
        if (被保険者一時TBL.getShikibetsuCode() != null) {
            source.shikibetsuCode = 被保険者一時TBL.getShikibetsuCode().value();
        }
        source.listUpper_5 = 被保険者一時TBL.getKanaMeisho();
        source.listLower_1 = 被保険者一時TBL.getMeisho();
        source.listUpper_6 = 過誤申立一時TBL.getServiceTeikyoYM().wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.listUpper_7 = get年月日(過誤申立一時TBL.getMoshitateYMD());
        source.listUpper_8 = 過誤申立一時TBL.getMoshitateJiyuCode();
        source.listUpper_9 = get申立事由(DBCCodeShubetsu.過誤申立事由_上２桁_様式番号.getコード());
        source.listLower_2 = get申立事由(DBCCodeShubetsu.過誤申立事由コード_下２桁_申立理由.getコード());
        if (flag) {
            source.gokeiKensuTitle = 合計件数タイトル;
            source.gokeiKensu = new RString(合計).concat(件);
        }
        source.listUpper_11 = 被保険者一時TBL.getYubinNo();
        source.listUpper_12 = 被保険者一時TBL.getChoikiCode();
        source.listUpper_13 = 被保険者一時TBL.getGyoseikuCode();
        source.listUpper_14 = 被保険者一時TBL.getShimei50onKana();
        source.listUpper_15 = getColumnValue(被保険者一時TBL.getShichosonCode());
        return source;
    }

    private RString get年月日(FlexibleDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get申立事由(CodeShubetsu code) {
        if (送付一覧表データ.get過誤申立一時TBL().getMoshitateJiyuCode() != null) {
            return CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, code,
                    new Code(送付一覧表データ.get過誤申立一時TBL().getMoshitateJiyuCode()));
        }
        return RString.EMPTY;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
