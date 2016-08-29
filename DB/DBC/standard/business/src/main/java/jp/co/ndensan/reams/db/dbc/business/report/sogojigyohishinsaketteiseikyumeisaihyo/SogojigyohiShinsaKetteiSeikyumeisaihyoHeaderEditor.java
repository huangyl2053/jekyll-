/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
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
 *
 * 帳票設計_DBC200070_介護予防・日常生活支援総合事業費審査決定請求明細表帳票HeaderEditorクラスです
 *
 * @reamsid_L DBC-2500-031 jiangwenkai
 */
public class SogojigyohiShinsaKetteiSeikyumeisaihyoHeaderEditor implements ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor {

    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;
    private final SogojigyohiShinsaKetteiSeikyumeisaihyoEntity 帳票出力対象データ;
    private final List<RString> 改頁リスト;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 帳票出力対象データ DbWT1613SinsaKetteiSeikyuGokeiTempEntity
     * @param 改頁リスト List<RString>
     */
    public SogojigyohiShinsaKetteiSeikyumeisaihyoHeaderEditor(Map<RString, RString> 出力順Map,
            RDateTime 作成日時, SogojigyohiShinsaKetteiSeikyumeisaihyoEntity 帳票出力対象データ, List<RString> 改頁リスト) {
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.帳票出力対象データ = 帳票出力対象データ;
        this.改頁リスト = 改頁リスト;

    }

    @Override
    public SogojigyohiShinsaKetteiSeikyumeisaihyoSource edit(SogojigyohiShinsaKetteiSeikyumeisaihyoSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.shinsaYM = this.パターン56(帳票出力対象データ.get審査決定請求合計().get審査年月());
        source.hokenshaNo = this.getColumnValue(帳票出力対象データ.get審査決定請求合計().get保険者番号());
        source.hokenshaName = 帳票出力対象データ.get審査決定請求合計().get保険者名();
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);
        source.kokuhorenName = 帳票出力対象データ.get審査決定請求合計().get国保連合会名();
        source.kaipage1 = get改頁(INT_1);
        source.kaipage2 = get改頁(INT_2);
        source.kaipage3 = get改頁(INT_3);
        source.kaipage4 = get改頁(INT_4);
        source.kaipage5 = get改頁(INT_5);
        source.shoKisaiHokenshaNo = this.getColumnValue(帳票出力対象データ.get審査決定請求合計().get証記載保険者番号());
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

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
