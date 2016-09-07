/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunjikofutangakukeisankekkaichiran;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJigyobunJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 *
 * 事業高額合算・事業分自己負担額計算結果一覧表帳票HeaderEditorクラスです
 *
 * @reamsid_L DBC-4790-040 jiangwenkai
 */
public class GassanJigyobunJikofutangakuKeisanKekkaIchiranHeaderEditor implements IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor {

    private final Map<RString, RString> 出力順Map;
    private final Map<RString, RString> 改頁Map;
    private final RDateTime 作成日時;
    private final RString 市町村コード;
    private final RString 市町村名称;

    private static final RString KEY_並び順の1件目 = new RString("KEY_並び順の1件目");
    private static final RString KEY_並び順の2件目 = new RString("KEY_並び順の2件目");
    private static final RString KEY_並び順の3件目 = new RString("KEY_並び順の3件目");
    private static final RString KEY_並び順の4件目 = new RString("KEY_並び順の4件目");
    private static final RString KEY_並び順の5件目 = new RString("KEY_並び順の5件目");
    private static final RString KEY_改頁の1件目 = new RString("KEY_改頁の1件目");
    private static final RString KEY_改頁の2件目 = new RString("KEY_改頁の2件目");
    private static final RString KEY_改頁の3件目 = new RString("KEY_改頁の3件目");
    private static final RString KEY_改頁の4件目 = new RString("KEY_改頁の4件目");
    private static final RString KEY_改頁の5件目 = new RString("KEY_改頁の5件目");

    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 出力順Map Map<RString, RString>
     * @param 改頁Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 市町村コード RString
     * @param 市町村名称 RString
     */
    public GassanJigyobunJikofutangakuKeisanKekkaIchiranHeaderEditor(Map<RString, RString> 出力順Map,
            Map<RString, RString> 改頁Map, RDateTime 作成日時, RString 市町村コード, RString 市町村名称) {
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.改頁Map = 改頁Map;
    }

    @Override
    public GassanJigyobunJikofutangakuKeisanKekkaIchiranSource edit(GassanJigyobunJikofutangakuKeisanKekkaIchiranSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.shutsuryokujun1 = get並び順(KEY_並び順の1件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の2件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の3件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の4件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の5件目);
        source.kaipage1 = get改頁(KEY_改頁の1件目);
        source.kaipage2 = get改頁(KEY_改頁の2件目);
        source.kaipage3 = get改頁(KEY_改頁の3件目);
        source.kaipage4 = get改頁(KEY_改頁の4件目);
        source.kaipage5 = get改頁(KEY_改頁の5件目);
        source.shichosonCd = this.市町村コード;
        source.shichosonName = this.市町村名称;
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString get改頁(RString 改頁Key) {
        return 改頁Map.containsKey(改頁Key) ? 出力順Map.get(改頁Key) : RString.EMPTY;
    }

}
