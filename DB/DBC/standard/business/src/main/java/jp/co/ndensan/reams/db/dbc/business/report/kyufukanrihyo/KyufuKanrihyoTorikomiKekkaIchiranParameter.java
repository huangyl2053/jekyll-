/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin.HihokenshaKyufukanrihyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票取込結果一覧表帳票のパラメータです。
 *
 * @reamsid_L DBC-2450-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuKanrihyoTorikomiKekkaIchiranParameter {

    private HihokenshaKyufukanrihyoEntity 帳票出力対象;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final DonyuKeitaiCode 導入形態コード;
    private final Boolean 集計Flag;
    private final int 連番;
    private int 件数1 = 0;
    private int 件数2 = 0;
    private int 件数3 = 0;
    private int 合計件数 = 0;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象 HihokenshaKyufukanrihyoEntity
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 導入形態コード DonyuKeitaiCode
     * @param 集計Flag boolean
     * @param 連番 int
     */
    public KyufuKanrihyoTorikomiKekkaIchiranParameter(HihokenshaKyufukanrihyoEntity 帳票出力対象,
            Map<RString, RString> 出力順Map, List<RString> 改頁リスト, FlexibleYearMonth 処理年月,
            RDateTime 作成日時, DonyuKeitaiCode 導入形態コード, Boolean 集計Flag, int 連番) {
        this.帳票出力対象 = 帳票出力対象;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.導入形態コード = 導入形態コード;
        this.集計Flag = 集計Flag;
        this.連番 = 連番;
    }

}
