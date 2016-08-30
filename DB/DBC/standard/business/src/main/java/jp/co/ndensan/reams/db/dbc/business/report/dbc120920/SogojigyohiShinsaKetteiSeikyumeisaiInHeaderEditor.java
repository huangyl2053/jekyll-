/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120920;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200084_総合事業費審査決定請求明細表帳票HeaderEditor
 *
 * @reamsid_L DBC-2500-032 jiangxiaolong
 */
public class SogojigyohiShinsaKetteiSeikyumeisaiInHeaderEditor
        implements ISogojigyohiShinsaKetteiSeikyumeisaiInEditor {

    private final SogojigyohiShinsaKetteiSeikyumeisaiInEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final RDateTime 作成日時;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");

    private static final RString SAKUSEI = new RString("作成");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    /**
     * コンストラクタです
     * @param 帳票出力対象データ SogojigyohiShinsaKetteiSeikyumeisaiInEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 改頁リスト List<RString>
     */
    public SogojigyohiShinsaKetteiSeikyumeisaiInHeaderEditor(
            SogojigyohiShinsaKetteiSeikyumeisaiInEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, RDateTime 作成日時, List<RString> 改頁リスト) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public SogojigyohiShinsaKetteiSeikyumeisaihyoSource edit(
            SogojigyohiShinsaKetteiSeikyumeisaihyoSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.shinsaYM = パターン56(帳票出力対象データ.get審査決定請求合計一時TBL().get審査年月());
        source.hokenshaNo = 帳票出力対象データ.get審査決定請求合計一時TBL().get保険者番号().getColumnValue();
        source.hokenshaName = 帳票出力対象データ.get審査決定請求合計一時TBL().get保険者名();
        source.shoKisaiHokenshaNo = 帳票出力対象データ.get審査決定請求合計一時TBL().get証記載保険者番号().getColumnValue();
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);
        source.kokuhorenName = 帳票出力対象データ.get審査決定請求合計一時TBL().get国保連合会名();
        if (改頁リスト != null) {
            source.kaipage1 = get改頁(INT_1);
            source.kaipage2 = get改頁(INT_2);
            source.kaipage3 = get改頁(INT_3);
            source.kaipage4 = get改頁(INT_4);
            source.kaipage5 = get改頁(INT_5);
        }
        source.shoKisaiHokenshaNo = 帳票出力対象データ.get審査決定請求合計一時TBL().get証記載保険者番号().getColumnValue();
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }
    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }
    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
