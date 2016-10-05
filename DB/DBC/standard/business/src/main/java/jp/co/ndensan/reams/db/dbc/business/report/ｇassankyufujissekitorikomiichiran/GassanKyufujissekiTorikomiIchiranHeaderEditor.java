/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.report.gassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 高額合算給付実績情報取込一覧表HeaderEditorクラスです。
 *
 * @reamsid_L DBC-2700-030 wangxingpeng
 */
public class GassanKyufujissekiTorikomiIchiranHeaderEditor implements IGassanKyufujissekiTorikomiIchiranEditor {

    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private static final RString SAKUSEI = new RString("作成");
    private static final RString KEY_並び順の1件目 = new RString("KEY_並び順の1件目");
    private static final RString KEY_並び順の2件目 = new RString("KEY_並び順の2件目");
    private static final RString KEY_並び順の3件目 = new RString("KEY_並び順の3件目");
    private static final RString KEY_並び順の4件目 = new RString("KEY_並び順の4件目");
    private static final RString KEY_並び順の5件目 = new RString("KEY_並び順の5件目");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです
     *
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     */
    public GassanKyufujissekiTorikomiIchiranHeaderEditor(
            Map<RString, RString> 出力順Map,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時) {
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.作成日時 = 作成日時;
        this.処理年月 = 処理年月;
    }

    @Override
    public GassanKyufujissekiTorikomiIchiranSource edit(GassanKyufujissekiTorikomiIchiranSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.torikomiYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.shutsuryokujun1 = get並び順(KEY_並び順の1件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の2件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の3件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の4件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の5件目);
        source.kaipage1 = get改頁(INDEX_0);
        source.kaipage2 = get改頁(INDEX_1);
        source.kaipage3 = get改頁(INDEX_2);
        source.kaipage4 = get改頁(INDEX_3);
        source.kaipage5 = get改頁(INDEX_4);

        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }

}
