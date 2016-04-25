/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証帳票Entity作成クラスです。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NyutaiShoParameter {

    private RString 入所施設種類;
    private RString 入所施設コード;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
}
