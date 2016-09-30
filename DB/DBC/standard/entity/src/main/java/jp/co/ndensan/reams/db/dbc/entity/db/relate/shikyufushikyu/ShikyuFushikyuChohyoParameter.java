/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給不支給決定一時TBLと被保険者一時TBLの帳票用データパラメータ。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuChohyoParameter {

    private ShikyuFushikyuChohyoEntity 帳票出力対象;
    private final List<RString> 並び順リスト;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final RString 保険者番号;
    private final RString 保険者名;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象 ShikyuFushikyuChohyoEntity
     * @param 並び順リスト Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 保険者番号 RString
     * @param 保険者名 RString
     * @param 連番 int
     */
    public ShikyuFushikyuChohyoParameter(ShikyuFushikyuChohyoEntity 帳票出力対象, List<RString> 並び順リスト,
            List<RString> 改頁リスト, FlexibleYearMonth 処理年月, RDateTime 作成日時, RString 保険者番号,
            RString 保険者名, int 連番) {
        this.帳票出力対象 = 帳票出力対象;
        this.並び順リスト = 並び順リスト;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.保険者番号 = 保険者番号;
        this.保険者名 = 保険者名;
        this.連番 = 連番;
    }

}
