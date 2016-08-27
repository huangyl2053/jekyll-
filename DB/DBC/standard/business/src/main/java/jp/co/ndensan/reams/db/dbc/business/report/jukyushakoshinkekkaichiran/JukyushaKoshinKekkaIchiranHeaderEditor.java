/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.DbWT5331JukyushaJohoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 受給者情報更新結果情報取込一覧表帳票HeaderEditor
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public class JukyushaKoshinKekkaIchiranHeaderEditor implements IJukyushaKoshinKekkaIchiranEditor {

    private final JukyushaHihokenshaEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final RDateTime 作成日時;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private final RString 帳票ID;
    private final RString 帳票DBC200006 = new RString("DBC200006_KokuhorenJukyushaDaichoIchiran");
    private final RString 帳票DBC200055 = new RString("DBC200055_JukyushaKoshinkekkaIchiran");
    private final RString 帳票DBC200058 = new RString("DBC200058_JukyushaTotsugokekkaIchiran");
    private static final RString DBC200006タイトル = new RString("受給者台帳（一覧表)");
    private static final RString DBC200055タイトル = new RString("受給者情報更新結果");
    private static final RString DBC200058タイトル = new RString("受給者情報突合結果");
    private static final RString BC200006_DBC200055_項目1 = new RString("訂正年月日");
    private static final RString DBC200058_項目1 = new RString("突合結果");
    private static final RString DBC200055_項目2 = new RString("訂正区分");
    private static final RString DBC200058_項目2 = new RString("突合情報");
    private static final RString DBC20000_項目3 = new RString("有料老人ホーム同意書");

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ JukyushaHihokenshaEntity
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 作成日時 RDateTime
     * @param 帳票ID RString
     */
    public JukyushaKoshinKekkaIchiranHeaderEditor(
            JukyushaHihokenshaEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, List<RString> 改頁リスト, RDateTime 作成日時, RString 帳票ID) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.作成日時 = 作成日時;
        this.帳票ID = 帳票ID;
    }

    @Override
    public JukyushaKoshinKekkaIchiranSource edit(
            JukyushaKoshinKekkaIchiranSource source) {
        DbWT5331JukyushaJohoCsvEntity 対象者 = 帳票出力対象データ.get受給者情報明細一時();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        if (帳票DBC200006.equals(帳票ID)) {
            source.title = DBC200006タイトル;
            source.komokuName1 = BC200006_DBC200055_項目1;
            source.komokuName2 = RString.EMPTY;
            source.komokuName3 = DBC20000_項目3;
        } else if (帳票DBC200055.equals(帳票ID)) {
            source.title = DBC200055タイトル;
            source.komokuName1 = BC200006_DBC200055_項目1;
            source.komokuName2 = DBC200055_項目2;
            source.komokuName3 = RString.EMPTY;
        } else if (帳票DBC200058.equals(帳票ID)) {
            source.title = DBC200058タイトル;
            source.komokuName1 = DBC200058_項目1;
            source.komokuName2 = DBC200058_項目2;
            source.komokuName3 = RString.EMPTY;
        }
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.hokenshaNo = 対象者.get保険者番号();
        source.hokenshaName = 対象者.get保険者名();
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);
        source.kaiPege1 = get改頁(INDEX_1);
        source.kaiPege2 = get改頁(INDEX_2);
        source.kaiPege3 = get改頁(INDEX_3);
        source.kaiPege4 = get改頁(INDEX_4);
        source.kaiPege5 = get改頁(INDEX_5);
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }
}
