/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 総合事業費（経過措置）過誤決定通知書情報取込一覧表帳票Editor。
 *
 * @reamsid_L DBC-2550-030 jianglaisheng
 */
public class SogojigyohiKagoKetteiInHeaderEditor implements ISogojigyohiKagoKetteiInEditor {

    private final SogojigyohiKagoKetteiInEntity 帳票出力対象データ;
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
     * @param 帳票出力対象データ SogojigyohiKagoKetteiInEntity
     * @param 出力順Map Map<RString, RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     */
    public SogojigyohiKagoKetteiInHeaderEditor(SogojigyohiKagoKetteiInEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, FlexibleYearMonth 処理年月, RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
    }

    @Override
    public SogojigyohiKagoKetteiInSource edit(SogojigyohiKagoKetteiInSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.torikomiYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        if (null != 帳票出力対象データ.get保険者番号()) {
            source.hokenshaNo = 帳票出力対象データ.get保険者番号().getColumnValue();
        }
        source.hokenshaName = 帳票出力対象データ.get保険者名();
        if (null != 帳票出力対象データ.get証記載保険者番号()) {
            source.shoKisaiHokenshaNo = 帳票出力対象データ.get証記載保険者番号().getColumnValue();
        }
        source.shoKisaiHokenshaName = 帳票出力対象データ.get証記載保険者名();
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
}
