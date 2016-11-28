/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import java.util.List;
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
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final RDateTime 作成日時;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;

    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KogakuKyufuKetteiChohyoDataEntity
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 作成日時 RDateTime
     */
    public KogakuShikyuFushikyuKetteishaIchiranHeaderEditor(KogakuKyufuKetteiChohyoDataEntity 帳票出力対象データ,
            List<RString> 出力項目リスト, List<RString> 改頁項目リスト, RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
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
            source.shoKisaiHokenshaNo = 帳票出力対象データ.getKetteiTemp().get証記載保険者番号().getColumnValue();
        } else {
            source.shoKisaiHokenshaNo = RString.EMPTY;
        }
        source.shoKisaiHokenshaName = 帳票出力対象データ.getKetteiTemp().get証記載保険者名();
        source.shutsuryokujun1 = get並び順(NUM_1);
        source.shutsuryokujun2 = get並び順(NUM_2);
        source.shutsuryokujun3 = get並び順(NUM_3);
        source.shutsuryokujun4 = get並び順(NUM_4);
        source.shutsuryokujun5 = get並び順(NUM_5);
        source.kaipage1 = get改頁(NUM_1);
        source.kaipage2 = get改頁(NUM_2);
        source.kaipage3 = get改頁(NUM_3);
        source.kaipage4 = get改頁(NUM_4);
        source.kaipage5 = get改頁(NUM_5);
        return source;
    }

    private RString get改頁(int index) {
        return index < 改頁項目リスト.size() ? 改頁項目リスト.get(index) : RString.EMPTY;
    }

    private RString get並び順(int index) {
        return index < 出力項目リスト.size() ? 出力項目リスト.get(index) : RString.EMPTY;
    }

}
