/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120160.KagoKetteiHokenshaChohyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤決定通知書情報取込（保険者分）帳票のパラメータです。
 *
 * @reamsid_L DBC-0980-300 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaIchiranParameter {

    private final List<RString> 改頁リスト;
    private final List<RString> 並び順リスト;
    private final KagoKetteiHokenshaChohyoEntity 帳票出力対象;
    private final RDateTime 作成日時;
    private final FlexibleYearMonth 処理年月;
    private final boolean 集計flg;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 改頁リスト List<RString>
     * @param 並び順リスト List<RString>
     * @param 帳票出力対象 KagoKetteiHokenshaChohyoEntity
     * @param 作成日時 RDateTime
     * @param 処理年月 FlexibleYearMonth
     * @param 集計flg boolean
     * @param 連番 int
     */
    public KagoKetteiHokenshaIchiranParameter(List<RString> 改頁リスト, List<RString> 並び順リスト,
            KagoKetteiHokenshaChohyoEntity 帳票出力対象, RDateTime 作成日時, FlexibleYearMonth 処理年月,
            boolean 集計flg, int 連番) {
        this.改頁リスト = 改頁リスト;
        this.並び順リスト = 並び順リスト;
        this.帳票出力対象 = 帳票出力対象;
        this.作成日時 = 作成日時;
        this.処理年月 = 処理年月;
        this.集計flg = 集計flg;
        this.連番 = 連番;
    }

}
