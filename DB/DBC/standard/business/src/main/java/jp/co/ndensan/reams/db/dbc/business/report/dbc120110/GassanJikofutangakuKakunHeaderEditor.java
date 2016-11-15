/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120110;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110.KogakuGassanJikofutangakuKakunEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120110.GassanJikofutangakuKakuninSource;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
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
 * 高額合算自己負担額確認情報取込一覧表HeadEditor。
 *
 * @reamsid_L DBC-2650-030 chenjie
 */
public class GassanJikofutangakuKakunHeaderEditor implements IGassanJikofutangakuKakunEditor {

    private final KogakuGassanJikofutangakuKakunEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 取込年月;

    private static final RString SAKUSEI = new RString("作成");

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

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KogakuGassanJikofutangakuKakunEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 FlexibleYearMonth
     * @param 取込年月 RDateTime
     * @param 改頁リスト List<RString>
     */
    public GassanJikofutangakuKakunHeaderEditor(KogakuGassanJikofutangakuKakunEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, FlexibleYearMonth 取込年月, RDateTime 作成日時, List<RString> 改頁リスト) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.取込年月 = 取込年月;
        this.作成日時 = 作成日時;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public GassanJikofutangakuKakuninSource edit(GassanJikofutangakuKakuninSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.torikomiYM = 取込年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.hokenshaNo = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        source.shoKisaiHokenshaNo = 帳票出力対象データ.get証記載保険者番号();
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
        source.yubinNo = 帳票出力対象データ.get被保険者_郵便番号();
        source.choikiCode = 帳票出力対象データ.get被保険者_町域コード();
        source.gyoseikuCode = 帳票出力対象データ.get被保険者_行政区コード();
        source.shimei50onKana = 帳票出力対象データ.get被保険者_氏名50音カナ();
        source.shichosonCode = 帳票出力対象データ.get被保険者_市町村コード();
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
    }
}
