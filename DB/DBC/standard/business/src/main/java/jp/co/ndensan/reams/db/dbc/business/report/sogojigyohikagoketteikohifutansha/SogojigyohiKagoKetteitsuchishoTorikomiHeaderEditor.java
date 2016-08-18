/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteikohifutansha.SogoKohifutanshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 総合事業費過誤決定通知書情報取込（公費負担者分）一覧表帳票Editor。
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
public class SogojigyohiKagoKetteitsuchishoTorikomiHeaderEditor implements ISogojigyohiKagoKetteitsuchishoTorikomiEditor {

    private final SogoKohifutanshaEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;

    private static final RString SAKUSEI = new RString("作成");

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogoKohifutanshaEntity
     * @param 出力順Map Map<RString, RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     */
    public SogojigyohiKagoKetteitsuchishoTorikomiHeaderEditor(SogoKohifutanshaEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, FlexibleYearMonth 処理年月, RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
    }

    @Override
    public SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource edit(SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.torikomiYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.kohiFutanshaNo = getColumnValue(帳票出力対象データ.get公費負担者番号());
        source.kohiFutanshaName = 帳票出力対象データ.get公費負担者名();
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);
        source.kaipage1 = RString.EMPTY;
        source.kaipage2 = RString.EMPTY;
        source.kaipage3 = RString.EMPTY;
        source.kaipage4 = RString.EMPTY;
        source.kaipage5 = RString.EMPTY;
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    /**
     * DB形から文字列に転換する。
     *
     * @param entity IDbColumnMappable
     * @return 文字列
     */
    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
