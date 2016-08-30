/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran;

import jp.co.ndensan.reams.db.dbd.definition.core.common.TainoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TokuchoFuchoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 収納情報Entity
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJohoEntity {

    private FlexibleYear 賦課年度;
    private FlexibleYear 調定年度;
    private RString 期別;
    private Decimal 保険料金;
    private FlexibleDate 納期限;
    private Decimal 滞納額;
    private TainoKubun 滞納区分;
    private FlexibleDate 時効起算日;
    private RString 時効起算事由;
    private TokuchoFuchoKubun 特徴普徴区分;
    private RString 収納情報なし;
}
