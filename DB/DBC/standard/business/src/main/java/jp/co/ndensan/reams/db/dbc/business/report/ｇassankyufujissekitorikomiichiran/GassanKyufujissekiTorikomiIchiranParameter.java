/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報取込一覧表のパラメータです。
 *
 * @reamsid_L DBC-2700-030 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanKyufujissekiTorikomiIchiranParameter {

    private KogakuGassanKyufuJissekiInEntity 帳票出力対象;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象 KogakuGassanKyufuJissekiInEntity
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     */
    public GassanKyufujissekiTorikomiIchiranParameter(KogakuGassanKyufuJissekiInEntity 帳票出力対象,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 連番) {
        this.帳票出力対象 = 帳票出力対象;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
    }

}
