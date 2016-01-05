/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.kyokaisogaitosha;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 境界層保険料段階グリッドのエンティティクラスです。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyokaisoHokenryoDankaiEntity {

    private RString 保険料段階_状態;
    private FlexibleYearMonth 保険料段階_適用開始日;
    private FlexibleYearMonth 保険料段階_適用終了日;
    private RString 保険料段階_保険料段階;
    private FlexibleYearMonth 修正前保険料段階_適用開始日;
}
