/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiChohyoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufukettei.KogakuShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 高額サービス費支給（不支給）決定者一覧表帳票HeaderEditor
 *
 * @reamsid_L DBC-0980-500 surun
 */
public class KogakuShikyuFushikyuKetteishaIchiranHeaderEditor implements IKogakuShikyuFushikyuKetteishaIchiranEditor {

    private final KogakuKyufuKetteiChohyoDataEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");

    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KogakuKyufuKetteiChohyoDataEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     */
    public KogakuShikyuFushikyuKetteishaIchiranHeaderEditor(KogakuKyufuKetteiChohyoDataEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
    }

    @Override
    public KogakuShikyuFushikyuKetteishaIchiranSource edit(KogakuShikyuFushikyuKetteishaIchiranSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.kokuhorenName = 帳票出力対象データ.getKetteiTemp().get国保連合会名();
        if (null != 帳票出力対象データ.getKetteiTemp().get証記載保険者番号()) {
            source.hokenshaNo = 帳票出力対象データ.getKetteiTemp().get証記載保険者番号().getColumnValue();
        }
        source.hokenshaName = 帳票出力対象データ.getKetteiTemp().get証記載保険者名();
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);
        source.kaipage1 = get並び順(KEY_並び順の２件目);
        source.kaipage2 = get並び順(KEY_並び順の３件目);
        source.kaipage3 = get並び順(KEY_並び順の４件目);
        source.kaipage4 = get並び順(KEY_並び順の５件目);
        source.kaipage5 = get並び順(KEY_並び順の６件目);
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

}
