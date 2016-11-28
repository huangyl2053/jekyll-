/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200022_償還払不支給決定者一覧表 ShokanFushikyuKetteiInHeaderEditor
 *
 * @reamsid_L DBC-2590-040 xuhao
 */
public class ShokanFushikyuKetteiInHeaderEditor implements IShokanFushikyuKetteiInEditor {

    private final ShokanFushikyuKetteiInEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁項目;
    private final RDateTime 作成日時;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ ShokanFushikyuKetteiInEntity
     * @param 出力順Map Map<RString, RString>
     * @param 改頁項目 List<RString>
     * @param 作成日時 RDateTime
     */
    protected ShokanFushikyuKetteiInHeaderEditor(
            ShokanFushikyuKetteiInEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁項目,
            RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.改頁項目 = 改頁項目;
        this.作成日時 = 作成日時;
    }

    @Override
    public ShokanbaraiFushikyuKetteishaIchiranSource edit(ShokanbaraiFushikyuKetteishaIchiranSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.kokuhorenName = 帳票出力対象データ.get国保連合会名();
        if (帳票出力対象データ.get証記載保険者番号() != null) {
            source.shoKisaiHokenshaNo = 帳票出力対象データ.get証記載保険者番号().getColumnValue();
        } else {
            source.shoKisaiHokenshaNo = RString.EMPTY;
        }
        source.shoKisaiHokenshaName = 帳票出力対象データ.get証記載保険者名();
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);
        source.kaipage1 = get改頁(INDEX_1);
        source.kaipage2 = get改頁(INDEX_2);
        source.kaipage3 = get改頁(INDEX_3);
        source.kaipage4 = get改頁(INDEX_4);
        source.kaipage5 = get改頁(INDEX_5);

        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return 改頁項目.size() > index ? 改頁項目.get(index) : RString.EMPTY;
    }

}
