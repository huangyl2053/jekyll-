/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅計画届出情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItakuKeikakuTodokedejohoEntity {

    private RString 居宅計画区分;
    private RString 明細番号;
    private FlexibleYearMonth 対象年月;
    private RString 区分;
    private RString 作成;
    private FlexibleDate 計画届出日;
    private FlexibleDate 変更日;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private RString 事業所番号;
    private RString 事業所名称;
    private RString 電話番号;
}
