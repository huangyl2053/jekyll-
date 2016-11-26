/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120160.KagoKetteiHokenshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
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
 * 過誤決定通知書情報取込一覧表（保険者分）
 * 帳票KagoKetteitsuchishoTorikomiIchiranHokenshaBunHeaderEditor
 *
 * @reamsid_L DBC-0980-470 lijunjun
 */
public class KagoKetteitsuchishoTorikomiIchiranHokenshaBunHeaderEditor implements IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor {

    private final KagoKetteiHokenshaIchiranParameter 帳票用パラメター;

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final RString SAKUSEI = new RString("作成");
    private final List<RString> 並び順リスト;

    /**
     * コンストラクタです
     *
     * @param 帳票用パラメター KagoKetteiHokenshaIchiranParameter
     */
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunHeaderEditor(KagoKetteiHokenshaIchiranParameter 帳票用パラメター) {
        this.帳票用パラメター = 帳票用パラメター;
        this.並び順リスト = 帳票用パラメター.get並び順リスト();
    }

    @Override
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource edit(KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {
        RDateTime 作成日時 = 帳票用パラメター.get作成日時();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        FlexibleYearMonth 処理年月 = 帳票用パラメター.get処理年月();
        source.torikomiYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        KagoKetteiHokenshaChohyoEntity 帳票出力対象 = 帳票用パラメター.get帳票出力対象();
        source.hokenshaNo = getColumnValue(帳票出力対象.get保険者番号());
        source.hokenshaName = 帳票出力対象.get保険者名();
        source.shoKisaiHokenshaNo = getColumnValue(帳票出力対象.get証記載保険者番号());
        source.shoKisaiHokenshaName = 帳票出力対象.get証記載保険者名();
        source.shutsuryokujun1 = get並び順(INDEX_1);
        source.shutsuryokujun2 = get並び順(INDEX_2);
        source.shutsuryokujun3 = get並び順(INDEX_3);
        source.shutsuryokujun4 = get並び順(INDEX_4);
        source.shutsuryokujun5 = get並び順(INDEX_5);
        setPageBreakEmpty(source);
        return source;
    }

    private void setPageBreakEmpty(KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {
        if (source.shoKisaiHokenshaNo == null) {
            source.shoKisaiHokenshaNo = RString.EMPTY;
        }
    }

    private RString get並び順(int index) {
        return index < 並び順リスト.size() ? 並び順リスト.get(index) : RString.EMPTY;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
